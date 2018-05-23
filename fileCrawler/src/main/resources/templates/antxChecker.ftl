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

    <h1>Antx 配置项检查工具</h1>

    <el-row :gutter="20" type="flex" class="row-bg" justify="left">
        <el-col :span="12">
            <el-form ref="appForm" :rules="rules" :model="appForm" label-width="100px">
                <el-form-item label="项目路径" prop="inputPath">
                    <el-input v-model="appForm.inputPath" placeholder="请输入项目路径"></el-input>
                </el-form-item>

                <el-form-item label="antx配置项" prop="antxProperties">
                    <el-input type="textarea"
                              :rows="20"
                              v-model="appForm.antxProperties" placeholder="请输入antx配置项"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('appForm')">开始检查</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </el-row>

    <el-dialog title="比对结果" :visible.sync="dialogTableVisible">
        <el-row type="flex" class="row-bg" justify="center">
            <el-table :data="checkDetailList" stripe>
                <el-table-column property="keyName" label="变量名" min-width="600"></el-table-column>
                <el-table-column property="result" label="比对结果" min-width="120"></el-table-column>
            </el-table>
        </el-row>
        <el-row type="flex" class="row-bg" justify="center">
            <el-button type="primary" @click="dialogTableVisible = false">关 闭</el-button>
        </el-row>
    </el-dialog>

</div>



</body>

<script src="${base}/js/jquery.min.js"></script>
<script src="${base}/js/vue.min.js"></script>
<script src="${base}/js/echarts.min.js"></script>
<!--  element-ui -->
<script src="${base}/element-ui/index.js"></script>
<script>
var apiPath = "${base}/checkantx";

var vm = new Vue({
        el: '#app',
        data: {
            visible: false,
            loading: false,
            appForm: {
                inputPath: '',
                antxProperties: ''
            },
            rules: {
                inputPath : [{required: true , message: '项目路径不可为空', trigger: 'blur'}],
                antxProperties : [{required: true , message: 'antx配置项不可为空', trigger: 'blur'}]
            },
            dialogTableVisible: false,
            checkDetailList: [],
            diffInfo : ''
        },
        created: initData,
        mounted: mounted,
        methods: {
            submitForm: function(formName) {
                var _this_ = this;
                this.$refs[formName].validate(function(result){
                    if (result) {
                        var param = JSON.stringify(_this_.appForm);
                        //console.info(param);
                        $.ajax(apiPath, {
                            contentType: "application/json; charset=utf-8",
                            data: param,
                            method: "POST",
                            success: function (data) {
                                if(data){
                                    if(data.bizCode == 'SUCCESS'){
                                        _this_.dialogTableVisible = true;
                                        if(data.details && data.details.length > 0){
                                            _this_.checkDetailList = data.details;
                                        }
                                    }
                                }
                            },
                            error: function (request, message, error) {
                                alert("error:"+error + " message:"+message);
                            }
                        });
                    }
                });
            }
        }
    });

function initData(){
}

function mounted(){

}



</script>
</html>