<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
</head>
<script type="text/javascript">
function loginCheck(){
  	if(document.form.id.value==""){
    	alert("아이디를 입력하세요.");
    	document.form.id.focus();
      	return false;
  	}
  	if(document.form.pwd.value==""){
    	alert("비밀번호를 입력하세요.");
    	document.form.pwd.focus();
      	return false;
  	}
  return true;  
}
</script>
<body style="background-color: aliceblue;">
	<div id="p_login_box">
		<h1>수의사 로그인</h1>
		<form method="post" action="PetServlet?command=p_helper_login" style="margin-top: 30px;" name="form">
			<div id="hleper_login">
            	<div id="p_div">
                	<input name="id" type="text" maxlength="13" placeholder="수의사 ID" onfocus="this.placeholder='수의사 ID'"
                		style="width: 500px; height: 60px; text-align: left; font-size: 150%;">
                </div>
                <div id="p_div">
                	<input name="pwd" type="password" maxlength="13" placeholder="Password" onfocus="this.placceholder='Password'"
                    	style="width: 500px; height: 60px; text-align: left; font-size: 150%; margin-top: 20px;">
                </div>
                <div id="p_btn">
                	<input type="submit" value="로 그 인" class="p_login"  onclick="return loginCheck()">
                </div>
        	</div>
		</form>
	</div>
</body>
</html>