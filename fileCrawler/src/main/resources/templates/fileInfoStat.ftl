<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 引入样式 -->
    <link rel="stylesheet" href="${base}/element-ui/lib/theme-default/index.css">
    <!--<link rel="stylesheet" href="${base}/css/site.css">-->
    <style>
        html {
            /*height: 100%*/
        }

        body, button {
            /*padding-bottom: 0;*/
            /*height: 100%;*/
            /*background-color: #ededed;*/
            font-family: 'Segoe UI', 'Microsoft YaHei UI', 'Microsoft YaHei', sans-serif, SimSun;
            font-size: 12px;
        }

        .el-table .cell {
            white-space: nowrap;
        }
    </style>
</head>
<body>
<div id="app" v-loading.fullscreen.lock="loading" element-loading-text="拼命加载中">

    <el-row type="flex" class="row-bg" justify="left">
        <el-col :span="12">
            <el-form ref="form" :model="appForm" label-width="100px">
                <el-form-item label="输入路径">
                    <el-input v-model="appForm.inputPath" placeholder="请输入扫描路径"></el-input>
                </el-form-item>
                <el-form-item label="taskId" v-show="false">
                    <el-input v-model="appForm.taskId"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitData">提交</el-button>
                    <el-button @click="queryStatData">刷新</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </el-row>

    <el-collapse v-model="activeNames" accordion>
        <el-collapse-item title="后缀名统计" name="1">
            <el-row type="flex" class="row-bg" justify="left">
                <el-col :span="18">
                    <div class="grid-content">
                        <template>
                            <el-table  :data="statData" style="width: 90%"  @row-click="queryDetailData" stripe
                                       max-height="250" border :default-sort = "{prop: 'count', order: 'descending'}">
                                <el-table-column prop="ext" label="扩展名" min-width="120" sortable> </el-table-column>
                                <el-table-column  prop="size" label="大小(KB)" min-width="120" sortable> </el-table-column>
                                <el-table-column prop="count" label="数量" min-width="120" sortable> </el-table-column>
                            </el-table>
                        </template>
                    </div>
                </el-col>
            </el-row>
        </el-collapse-item>
        <el-collapse-item title="文件明细" name="2">
            <el-row  type="flex" class="row-bg" justify="left">
                <el-col>
                    <div class="grid-content">
                        <template>
                            <el-table  :data="detailData" style="width: 90%" max-height="250" border stripe
                                      :default-sort = "{prop: 'fileSize', order: 'descending'}">
                                <el-table-column prop="fullName" label="文件全称" min-width="600" sortable> </el-table-column>
                                <el-table-column  prop="fileSize" label="大小(KB)" min-width="120" sortable> </el-table-column>
                            </el-table>
                        </template>
                    </div>
                </el-col>
            </el-row>
        </el-collapse-item>
    </el-collapse>
</div>
</body>

<script src="${base}/js/jquery.min.js"></script>
<script src="${base}/js/vue.min.js"></script>
<script src="${base}/js/echarts.min.js"></script>
<!--  element-ui -->
<script src="${base}/element-ui/index.js"></script>
<script>
var apiPath = "${base}/filecrawler";

var vm = new Vue({
        el: '#app',
        data: {
            visible: false,
            loading: false,
            appForm: {
                inputPath: '',
                taskId: ''
            },
            statData : [],
            detailData : [],
            activeNames : '1'
        },
        created: initData,
        mounted: mounted,
        methods: {
            submitData: function() {
                var _this_ = this;
                var param =  JSON.stringify(this.appForm);
                $.ajax(apiPath, {
                    contentType: "application/json; charset=utf-8",
                    data: param,
                    method: "POST",
                    success: function (data) {
                        _this_.queryStatData();
                    },
                    error: function (request, message, error) {
                        alert("error:"+error + " message:"+message);
                    }
                });
            },
            queryStatData: function() {
                var _this_ = this;
                //var param =  JSON.stringify(this.appForm);
                var getUrl = apiPath+"/tasks/"+ this.appForm.taskId;
                this.loading = true;
                $.ajax(getUrl, {
                    contentType: "application/json; charset=utf-8",
                    //data: param,
                    method: "GET",
                    success: function (data){
                        if(!data) return;
                        _this_.statData = data.dataMapList;
                        _this_.detailData = [];
                        _this_.loading = false;
                    },
                    error: function (request, message, error) {
                        alert("error:"+error + " message:"+message);
                        _this_.loading = false;
                    }
                });
            },
            queryDetailData: function(row,event,column) {
                var _this_ = this;
                var getUrl = apiPath+"/tasks/"+this.appForm.taskId + "/ext/" + row.ext;
                this.loading = true;
                $.ajax(getUrl, {
                    contentType: "application/json; charset=utf-8",
                    //data: param,
                    method: "GET",
                    success: function (data){
                        if(!data) return;
                        _this_.detailData = data.detailList;
                        _this_.loading = false;
                        _this_.activeNames = '2';
                    },
                    error: function (request, message, error) {
                        alert("error:"+error + " message:"+message);
                        _this_.loading = false;
                    }
                });
            },
            getSummaries: function(param) {
                var sums = [];
                var columns = param.columns;
                if (columns && columns.length > 0) {
                    $.each(columns, function (index, data) {
                        if (index === 0) {
                            sums[index] = '总价';
                            return;
                        }
                    });
                }
            }
        }
    });

function generateUUID() {
    var d = new Date().getTime();
    var uuid = 'xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (d + Math.random()*16)%16 | 0;
        d = Math.floor(d/16);
        return (c=='x' ? r : (r&0x3|0x8)).toString(16);
    });
    return uuid;
};

function initData(){
    this.appForm.taskId = generateUUID();
}

function mounted(){

}



</script>
</html>