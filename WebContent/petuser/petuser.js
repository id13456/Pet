function userWriteconfirm() {
	 if (document.frm.userid.value == '') {
		  alert('아이디를 입력하세요.');
		  document.frm.userid.focus();
		  return false;
	 } else if (document.frm.reid.value == '') {
		  alert('아이디 중복체크해주세요.');
		  document.frm.userid.focus();
		  return false;
	 } else if (document.frm.userpwd.value == '') {
		  alert('비밀번호를 입력하세요.');
		  document.frm.userpwd.focus();
		  return false;
	 } else if (document.frm.userpwd.value != document.frm.userpwd_ck.value) {
		  alert('비밀번호가 일치하지 않습니다.');
		  document.frm.userpwd_ck.focus();
		  return false;
	 } else if (document.frm.username.value == '') {
		  alert('이름을 입력하세요.');
		  document.frm.username.focus();
		  return false;
	 } else if (document.frm.userphone.value == '') {
		  alert('전화번호를 입력하세요.');
		  document.frm.userphone.focus();
		  return false;
	 } else if (document.frm.useremail.value == '') {
		  alert('이메일을 입력하세요.');
		  document.frm.useremail.focus();
		  return false;
	 } else if (document.frm.user_zip_num.value == '') {
		  alert('우편번호를 입력하세요.');
		  document.frm.user_zip_num.focus();
		  return false;
	 } else if (document.frm.user_address.value == '') {
		  alert('주소를 입력하세요.');
		  document.frm.user_address.focus();
		  return false;
	 } else if (document.frm.user_pet1[0].checked == false && document.frm.user_pet1[1].checked == false 
			 			&& document.frm.user_pet1[2].checked == false && document.frm.user_pet1[3].checked == false
			 			&& document.frm.user_pet1[4].checked == false && document.frm.user_pet1[5].checked == false
			 			&& document.frm.user_pet1[6].checked == false) {
		  alert('반려동물을 선택하세요.');
		  return false;
	 } 
	 
	 return true;
}

function idcheck() {
	if(document.frm.userid.value == "") {
		alert('아이디를 입력하여 주세요.');
		document.frm.userid.focus();
		return;
	}
	
	var url = "PetServlet?command=id_check_form&id=" + document.frm.userid.value;
	var pop = "toolbar=no, menuber=no, scrollbars=yes, resizable=no, width=450, height=200";
	window.open(url, "_blank_1", pop);
}

function matchCancel(id) {
	if(confirm("정말로 취소하시겠습니까?")) {
		location.href="PetServlet?command=remove_helper&helperid=" + id;
	}
}