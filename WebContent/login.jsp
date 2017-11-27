<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style>
<!--
该页面的样式修饰
-->
		#body{
		width: 800px;
		margin: 0 auto;
		
		}
		#box{
		width: 800px;
		background-color: lightgreen;
		border: 2px solide red;
		text-align: center;
		margin-left:300px ;
		margin-bottom: 100px;
		
		
		}	
	 table {
		margin-left:280px; 
		margin-bottom: 100px;
		
}	
		.right{ 
			margin-left: 10px;
		
		}
		.left{
			margin-right: 10px ;
		}
		#b{
			margin-left: 200px;
		
		}
	
		
</style>
</head>
<body>
	<div id="box">
	<h1>用户登录</h1>
	
	<%  String mess=(String )request.getAttribute("mess"); 
	
		if(mess!=null)
		{
			%><span>
			<%=mess %>>
			
			</span>
			
			
			<% 
		}
	
	%>
	
	
	<form action="login.in" method="post">
	<table border="1" cellspacing="0">
	<tr><td class="left">用户名：</td> <td class="right"><input type="text" name="uname"></td></tr>
	<tr><td class="left">密码：</td> <td class="right"><input type="password" name="upwd"></td></tr>
	<tr><td class="left">用户类型：</td> <td class="right">
	<input type="radio" name="utype" value="管理员">管理员
	<input type="radio" name="utype" value ="用户">用户</td></tr>
	<tr ><td  colspan="3" id="b"><input type="button" onclick="register()" value="新用户注册"></td></tr>
	<tr><td class="left"><input type="submit" value="提交"></td> <td class="right"><input type="reset" value="重置"></td></tr>
	
	</table>
</form>
	</div>
	<script type="text/javascript">
			function register(){
				location.href="register.jsp";
				
			}
			
</script>

</body>
</html>