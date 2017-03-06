<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/23
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
    <script type="text/javascript" src="../resources/js/jquery-1.9.1.min.js" ></script>
    <script type="text/javascript" src="../resources/validform/Validform_v5.3.2.js" ></script>
    <script type="text/javascript">
	    $(function(){
	    	$(".registerform").Validform({
				tiptype:2,
				usePlugin:{
					passwordstrength:{
						minLen:6,
						maxLen:18,
						trigger:function(obj,error){
							if(error){
								obj.parent().next().find(".passwordStrength").hide().siblings(".info").show();
							}else{
								obj.removeClass("Validform_error").parent().next().find(".passwordStrength").show().siblings().hide();	
							}
						}
					}
				}
			});
	    
	    
	    
		})
    </script>
</head>
<body>
<div class="main">
    <div class="wraper">
        <form class="registerform" method="post" action="demo/ajax_post.php">
            <table width="100%" style="table-layout:fixed;">
                <tr>
                    <td class="need" style="width:10px;">*</td>
                    <td style="width:70px;">昵称：</td>
                    <td style="width:280px;"><input type="text" value="" name="name" class="inputxt" datatype="s6-18" nullmsg="请输入您的昵称！" errormsg="昵称至少6个字符,最多18个字符！" /></td>
                    <td>
                    	<div class="Validform_checktip"></div>
                        <div class="info">昵称至少6个字符,最多18个字符<span class="dec"><s class="dec1">&#9670;</s><s class="dec2">&#9670;</s></span></div>
                    </td>
                </tr>
                <tr>
                    <td class="need" style="width:10px;">*</td>
                    <td style="width:70px;">密码：</td>
                    <td style="width:210px;">
                        <input type="password" value="" name="password" class="inputxt" plugin="passwordStrength"  datatype="*6-18" nullmsg="请输入密码！" errormsg="密码至少6个字符,最多18个字符！" />
                    </td>
                    <td>
                        <div class="Validform_checktip"></div>
                        <div class="passwordStrength" style="display:none;"><b>密码强度：</b> <span>弱</span><span>中</span><span class="last">强</span></div>
                        <div class="info">密码至少6个字符,最多18个字符<span class="dec"><s class="dec1">&#9670;</s><s class="dec2">&#9670;</s></span></div>
                    </td>
                </tr>
                <tr>
                    <td class="need">*</td>
                    <td>确认密码：</td>
                    <td><input type="password" value="" name="repassword" class="inputxt" recheck="password"  datatype="*6-18" nullmsg="请确认密码！" errormsg="两次输入的密码不一致！" /></td>
                    <td>
                    	<div class="Validform_checktip"></div>
                    	<div class="info">请确认您的密码<span class="dec"><s class="dec1">&#9670;</s><s class="dec2">&#9670;</s></span></div>
                    </td>
                </tr>
                <tr>
                    <td class="need">*</td>
                    <td>移动电话：</td>
                    <td><input type="text" value="" name="tel" class="inputxt" datatype="m" nullmsg="请输入您的手机号码！" errormsg="请输入您的手机号码！"  /></td>
                    <td>
                    	<div class="Validform_checktip"></div>
                        <div class="info">请输入您的手机号码<span class="dec"><s class="dec1">&#9670;</s><s class="dec2">&#9670;</s></span></div>
                    </td>
                </tr>
                <tr>
                    <td class="need">*</td>
                    <td>所在城市：</td>
                    <td><select name="province" datatype="*" nullmsg="请选择所在城市！" errormsg="请选择所在城市！" style="width:266px;"><option value="">请选择城市</option><option value="1">瑞金市</option></select></td>
                    <td>
                    	<div class="Validform_checktip"></div>
                        <div class="info">请选择您所在的城市<span class="dec"><s class="dec1">&#9670;</s><s class="dec2">&#9670;</s></span></div>
                    </td>
                </tr>
                <tr>
                    <td class="need">*</td>
                    <td>性别：</td>
                    <td><input type="radio" value="1" name="gender" id="male" class="pr1" datatype="*" nullmsg="请选择性别！" errormsg="请选择性别！" /><label for="male">男</label> <input type="radio" value="2" name="gender" id="female" class="pr1" /><label for="female">女</label></td>
                    <td>
                    	<div class="Validform_checktip"></div>
                        <div class="info">请告诉我们您的性别<span class="dec"><s class="dec1">&#9670;</s><s class="dec2">&#9670;</s></span></div>
                    </td>
                </tr>
                <tr>
                    <td class="need">*</td>
                    <td>购物网：</td>
                    <td>
                        <input name="shoppingsite2" class="rt2" id="shoppingsite21" type="checkbox"  value="1" datatype="*" nullmsg="请选择您常去的购物网站！" errormsg="请选择您常去的购物网站！" /><label for="shoppingsite21">新蛋</label>
                        <input name="shoppingsite2" class="rt2" id="shoppingsite22" type="checkbox"  value="2" /><label for="shoppingsite22">淘宝</label>
                        <input name="shoppingsite2" class="rt2" id="shoppingsite23" type="checkbox"  value="3" /><label for="shoppingsite23">京东</label>
                    </td>
                    <td>
                    	<div class="Validform_checktip"></div>
                        <div class="info">请选择您常去的购物网站<span class="dec"><s class="dec1">&#9670;</s><s class="dec2">&#9670;</s></span></div>
                    </td>
                </tr>
                <tr>
                    <td class="need"></td>
                    <td>备注：</td>
                    <td colspan="2">
                        <textarea tip="请在这里输入您的意见。" altercss="gray" class="gray" name="msg" value="">请在这里输入您的意见。</textarea>
                    </td>
                </tr>
                <tr>
                    <td class="need"></td>
                    <td></td>
                    <td colspan="2" style="padding:10px 0 18px 0;">
                        <input type="submit" value="提 交" /> <input type="reset" value="重 置" />
                    </td>
                </tr>
            </table>
        </form>
        
        <h2>说明：</h2>
        <div class="tipmsg">
        	<p>如示例，需要自己另外绑定事件实现这效果。</p>
        </div>
        
    </div>
</div>






    <form id="loginform" action="/web01/login/login.do" method="post">
        <input type="text" name="name" id="name" placeholder="请输入用户名"/>
        <input type="submit" name="btn_login" id="login" value="登录" />
    </form>
    
    
</body>
</html>
