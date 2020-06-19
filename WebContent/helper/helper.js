function delhelperconfirm(id) {
	if(confirm("정말로 삭제하시겠습니까?")) {
		location.href="PetServlet?command=helper_delete&id=" + id;
	}
}

function go_search_area() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=helper_list";
	document.frm.submit();
}

function go_search_men() {
	document.frm.all_view.value = "n";
	document.frm.action = "PetServlet?command=helper_list&sex=1";
	document.frm.submit();
}

function go_search_woman() {
	document.frm.all_view.value = "n";
	document.frm.action = "PetServlet?command=helper_list&sex=2";
	document.frm.submit();
}

function go_search_doctor() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=helper_list&group=1";
	document.frm.submit();
}

function go_search_helper() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=helper_list&group=2";
	document.frm.submit();
}

function go_total_helper() {
	document.frm.all_view.value = "y";
	document.frm.area_search.value = "";
	document.frm.action = "PetServlet?command=helper_list";
	document.frm.submit();
}

function helperWriteconfirm() {
	 if (document.frm.id.value == '') {
		  alert('아이디를 선택하세요.');
		  document.frm.id.focus();
		  return false;
	 } else if (document.frm.pwd.value == '') {
		  alert('비밀번호를 입력하세요.');
		  document.frm.pwd.focus();
		  return false;
	 } else if (document.frm.pwd_ch.value == '') {
		  alert('비밀번호를 입력하세요.');
		  document.frm.pwd_ch.focus();
		  return false;
	 } else if (document.frm.pwd.value != document.frm.pwd_ch.value) {
		  alert('비밀번호가 일치하지 않습니다.');
		  document.frm.pwd_ch.focus();
		  return false;
	 } else if (document.frm.name.value == '') {
		  alert('이름을 입력하세요.');
		  document.frm.name.focus();
		  return false;
	 } else if (document.frm.sex[0].checked == false && document.frm.sex[1].checked == false) {
		  alert('성별을 체크하세요.');
		  return false;
	 } else if (document.frm.phone.value == '') {
		  alert('전화번호를 입력하세요.');
		  document.frm.phone.focus();
		  return false;
	 } else if (document.frm.email.value == '') {
		  alert('이메일을 입력하세요.');
		  document.frm.email.focus();
		  return false;
	 } else if (document.frm.hgroup[0].checked == false && document.frm.hgroup[1].checked == false) {
		  alert('구분을 체크하세요.');
		  return false;
	 } else if (document.frm.hgroup.value == 1 && document.frm.hos_name.value == '') {
		  alert('병원이름을 입력하세요.');
		  document.frm.hos_name.focus();
		  return false;
	 } else if (document.frm.hgroup.value == 1 && document.frm.hos_address.value == '') {
		  alert('병원 주소를 입력하세요.');
		  document.frm.hos_address.focus();
		  return false;
	 } else if (document.frm.kind[0].checked == false && document.frm.kind[1].checked == false 
			 			&& document.frm.kind[2].checked == false && document.frm.kind[3].checked == false
			 			&& document.frm.kind[4].checked == false) {
		  alert('케어 가능범위를 선택하세요.');
		  return false;
	 } else if (document.frm.kind[0].checked == false && document.frm.kind[1].checked == false 
	 			&& document.frm.kind[2].checked == false ) {
		 alert('돌봄 유형은 반드시 포함되어야 합니다.');
		 return false;
	 }  else if (document.frm.kind[3].checked == false && document.frm.kind[4].checked == false) {
		 alert('돌봄 가능 동물은 반드시 포함되어야 합니다.');
		 return false;
	 } else if (document.frm.helper_index.value == '') {
		  alert('소개를 입력하세요.');
		  document.frm.helper_index.focus();
		  return false;
	 }
	 
	 return true;
}