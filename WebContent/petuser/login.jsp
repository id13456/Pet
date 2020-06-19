<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">
function loginCheck(){
  	if(document.form.userid.value==""){
    	alert("아이디를 입력하세요.");
    	document.form.userid.focus();
      	return false;
  	}
  	if(document.form.userpwd.value==""){
    	alert("비밀번호를 입력하세요.");
    	document.form.userpwd.focus();
      	return false;
  	}
  return true;  
}

function find_id() {
	var url = "PetServlet?command=find_id_form";
	var pop = "toolbar=no, menuber=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300";
	window.open(url, "_blank_1", pop);
}
</script>
<body style="background-color:#E6F1FE;">
	<div id="login_box">
		<h1>Login</h1>
        <form method="post" action="PetServlet" name="form">
			<input type="hidden" name="command" value="login">
			<div id="login_box1">
				<div id="login">
                    <div id="id">
                        <input name="userid" type="text" maxlength="13" placeholder="User ID" 
                        	onfocus="this.placeholder='User ID'"
                            style="width: 400px; height: 50px; text-align: left; font-size: 100%;">
                    </div>
                </div>
			     <div id="login">
                    <div id="pwd">
                        <input name="userpwd" type="password" maxlength="13" placeholder="Password"
                        	onfocus="this.placeholder='Password'"
                            style="width: 400px; height: 50px; text-align: left; font-size: 100%;">
                            <br> ${message}
                    </div>
                </div>
                <div id="login_button">
                    <input type="button" value="회원가입" class="button" onclick="location.href='PetServlet?command=join_form'">   
                    <input type="submit" value="로그인" class="button" onclick="return loginCheck()">
                    <input type="button" value="아이디 비밀번호 찾기" class="button" onclick="find_id()">
                </div>
            </div>
            <div id="login_box2">
                <div id="p_box">
                   <!--  <div id="l_img"><img src="images/user.png"></div> -->
                    <div class="login">
                        <input type="button" value="수의사 로그인" class="b_login" 
                        	onclick="location.href='PetServlet?command=p_helper_login_form'">
                    </div>
                </div>
                <div id="p_box" style="margin-top: 25px;">
                    <!-- <div id="l_img"><img src="images/user.png"></div> -->
                    <div class="login">
                        <input type="button" value="관리자 로그인" class="b_login"
                        			onclick="location.href='PetServlet?command=admin_login_form'">
                    </div>
                </div>
            </div>
        </form>
	</div>
</body>
</html>