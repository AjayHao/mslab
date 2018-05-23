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

    <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="选择基金">
            <el-select v-model="form.fundCodeName" placeholder="请选择">
                <el-option
                        v-for="item in fundInfoList"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="定投开始日">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.aipBeginDate"></el-date-picker>
            <!--<el-col class="line" :span="2">-</el-col>-->
        </el-form-item>
        <el-form-item label="定投结束日">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.aipEndDate"></el-date-picker>
            <!--<el-col class="line" :span="2">-</el-col>-->
        </el-form-item>
        <el-form-item label="定投周期">
            <el-radio-group v-model="form.periodType" v-on:change="changePeriodType">
                <el-radio-button label="1">月</el-radio-button>
                <el-radio-button label="2">周</el-radio-button>
                <el-radio-button label="3">双周</el-radio-button>
            </el-radio-group>
        </el-form-item>
        <el-form-item label="定投扣款日">
            <el-select v-model="form.monthday" v-show="form.periodType==1">
                <el-option
                        v-for="item in monthdayList"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
            <el-select v-model="form.weekday"  v-show="form.periodType!=1">
                <el-option
                        v-for="item in weekdayList"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="活动形式">
            <el-input type="textarea" v-model="form.desc"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
            <el-button>取消</el-button>
        </el-form-item>
    </el-form>

</div>
</body>

<script src="${base}/js/jquery.min.js"></script>
<script src="${base}/js/vue.min.js"></script>
<script src="${base}/js/echarts.min.js"></script>
<!--  element-ui -->
<script src="${base}/element-ui/index.js"></script>
<script>

var _monthdayList = [];
var _weekdayList = [];



var vm = new Vue({
        el: '#app',
        data: {
            visible: false,
            loading: false,
            message: 'elementui',
            form: {
                fundCodeName: '',
                aipBeginDate: '',
                aipEndDate: '',
                periodType: '1',
                monthday: '',
                weekday: '',
                delivery: false,
                type: [],
                resource: '',
                desc: '',
                //
                monthdayShow : true
            },
            fundInfoList: [{
                label: "兴全沪深300     163407",
                value: "163407"
            },{
                label: "兴全添利宝货币  000575",
                value: "000575"
            }],
            monthdayList: _monthdayList,
            weekdayList: _weekdayList
        },
        created: function(){
            initData();
            monthday = "01";
            weekday = "1";
        },
        mounted: mounted,
        methods: {
            eventInvoke: function () {
                this.message = this.message.split('').reverse().join('');
            },
            onSubmit: function() {
                console.log('submit!');
            },
            changePeriodType : function (value) {
                this.form.monthdayShow = (value == '1');
            }
        }
    });

function initData(){
    //构建月数据
    for(var i = 1; i <= 28; i++){
        var option = new Object();
        option["label"] = i+"日";
        option["value"] = (i < 10 ) ? "0"+i : ""+i;
        _monthdayList.push(option);
    }

    //构建日数据
    for(var i = 1; i <= 5; i++){
        var option = new Object();
        if(i==1){ option["label"] = "周一";}
        else if(i==2){ option["label"] = "周二";}
        else if(i==3){ option["label"] = "周三";}
        else if(i==4){ option["label"] = "周四";}
        else if(i==5){ option["label"] = "周五";}
        option["value"] = ""+i;
        _weekdayList.push(option);
    }

}

function mounted(){

}


</script>
</html>