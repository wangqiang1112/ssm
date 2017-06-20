<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<head>
<title>实用漂亮的仿百度风云榜选项卡菜单_www.97zzw.com</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<script src="../resources/js/tab.js"></script>
<!--把下面代码加到<head>与</head>之间-->
<style type="text/css">
body,div,h5,ul,li{margin:0;padding:0;}
body{font:12px/1.5 Arial;}
li{list-style:none;}
a:link,a:visited{color:#333;text-decoration:none;}
a:hover{text-decoration:underline;}
#wrap{width:836px;margin:10px auto;}
#list{overflow:hidden;zoom:1;margin-left:-10px;}
#wrap .item{display:inline;float:left;width:270px;padding-bottom:10px;border:1px solid #EBEBEB;margin:10px 0 10px 10px;}
#wrap .item .tab{position:relative;height:25px;border-bottom:1px solid #CCC;margin:8px;}
#wrap .item .tab h5{position:absolute;left:10px;font-size:14px;}
#wrap .item .tab .switchBtn{position:absolute;top:3px;right:0;}
#wrap .item .tab .switchBtn a{float:left;width:15px;height:15px;margin-left:5px;overflow:hidden;text-indent:-999px;background:url(../resources/js/images/icon_arr.gif) no-repeat;outline:none;}
#wrap .item .tab .switchBtn a.prev{background-position:0 -25px;}
#wrap .item .tab .switchBtn a.prevNot{background-position:0 0;cursor:default;}
#wrap .item .tab .switchBtn a.next{background-position:right -25px;}
#wrap .item .tab .switchBtn a.nextNot{background-position:right 0;cursor:default;}
#wrap .item .tab ul{position:absolute;top:-2px;width:160px;height:28px;overflow:hidden;}
#wrap .item .tab ul li{float:left;cursor:pointer;line-height:26px;padding:0 8px;}
#wrap .item .tab ul li.current{cursor:text;color:#E45E2E;font-weight:700;border:1px solid #CCC;border-bottom-color:#FFF;}
#wrap .item .items{display:none;background:url(../resources/js/images/icon_num.gif) 15px 4px no-repeat;padding:0 15px;}
#wrap .item .items a{color:#3A64B0;}
#wrap .item .items li{height:24px;line-height:24px;padding-left:20px;border-bottom:1px solid #EBEBEB;}
#wrap .item .btn{height:22px;margin-top:10px;}
#wrap .item .btn a{float:right;width:74px;height:22px;overflow:hidden;margin-right:15px;text-indent:-9999px;background:url(../resources/js/images/icon_btn.gif) no-repeat;}
#wrap .item .btn a:hover{background-position:0 -22px;}
#copyright{color:#9A9A9A;text-align:center;}
#copyright a{color:#FFF;padding:2px 5px;border-radius:10px;background:#9A9A9A;}
</style>

</head>
<body>
<div id="wrap">
    <div id="list">

        <div class="item">
            <div class="tab">
                <ul>
                    <li class="current">基础教育</li>
                    <li>英语培训</li>
                    <li>留学机构</li>

                    <li>语言培训</li>
                    <li>IT培训</li>
                </ul>
                <span class="switchBtn"><a href="javascript:;" class="prevNot">左</a><a href="javascript:;" class="next">右</a></span>
            </div>
            <ul class="items" style="display:block;">
                <li><a href="javascript:;">北京四中网校</a></li>

                <li><a href="javascript:;">学大教育</a></li>
                <li><a href="javascript:;">中国统一教育网</a></li>
                <li><a href="javascript:;">101远程教育网</a></li>
                <li><a href="javascript:;">巨人教育</a></li>
                <li><a href="javascript:;">黄冈中学网校</a></li>
            </ul>

            <ul class="items">
                <li><a href="javascript:;">新东方</a></li>
                <li><a href="javascript:;">英孚教育</a></li>
                <li><a href="javascript:;">环球雅思</a></li>
                <li><a href="javascript:;">韦博国际英语</a></li>
                <li><a href="javascript:;">华尔街英语</a></li>

                <li><a href="javascript:;">新航道</a></li>
            </ul>
            <ul class="items">
                <li><a href="javascript:;">2+2留学</a></li>
                <li><a href="javascript:;">澳际留学</a></li>
                <li><a href="javascript:;">新东方前途出国</a></li>
                <li><a href="javascript:;">启德留学</a></li>

                <li><a href="javascript:;">嘉华世达</a></li>
                <li><a href="javascript:;">金吉列留学</a></li>
            </ul>
            <ul class="items">
                <li><a href="javascript:;">新东方</a></li>
                <li><a href="javascript:;">英孚教育</a></li>
                <li><a href="javascript:;">昂立教育</a></li>

                <li><a href="javascript:;">环球雅思</a></li>
                <li><a href="javascript:;">韦博国际英语</a></li>
                <li><a href="javascript:;">华尔街英语</a></li>
            </ul>
            <ul class="items">
                <li><a href="javascript:;">北大青鸟</a></li>
                <li><a href="javascript:;">新华电脑学校</a></li>

                <li><a href="javascript:;">完美动力</a></li>
                <li><a href="javascript:;">达内培训</a></li>
                <li><a href="javascript:;">汇众教育</a></li>
                <li><a href="javascript:;">思远IT学院</a></li>
            </ul>
        </div>
        
    </div>
</div>
</body>
</html>