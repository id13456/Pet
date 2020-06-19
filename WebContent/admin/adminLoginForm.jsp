<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">
function admin_check()
{
  if(document.frm.adminId.value==""){
      alert("아이디를 입력하세요.");
      document.frm.adminId.focus();
      return false;
  }
  if(document.frm.adminPwd.value==""){
     alert("비밀번호를 입력하세요.");
     document.frm.adminPwd.focus();
      return false;
  }
  return true;  
}
</script>
</head>
<body style="background-color: aliceblue;">
	<div id="p_login_box">
		<h1>관리자 로그인</h1>
		<form method="post" style="margin-top: 30px;" action="PetServlet?command=admin_login">
			<div id="hleper_login">
            	<div id="p_div">
                	<input name="adminId" type="text" maxlength="13" placeholder="관리자 ID" 
                		onfocus="this.placeholder='관리자 ID'"
                		style="width: 500px; height: 70px; text-align: left; font-size: 150%;">
                </div>
                <div id="p_div">
                	<input name="adminPwd" type="password" maxlength="13" placeholder="Password" 
                		onfocus="this.placceholder='Password'"
                    	style="width: 500px; height: 70px; text-align: left; font-size: 150%; margin-top: 20px;">
                </div>
                <div id="p_btn">
                	<input type="submit" value="로 그 인" class="p_login" onclick="return admin_check();">
                </div>
        	</div>
		</form>
	</div>
</body>
</html>