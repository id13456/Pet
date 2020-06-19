function delconfirm(conseq) {
	if(confirm("정말로 삭제하시겠습니까?")) {
		location.href="PetServlet?command=pet_contest_delete&conseq=" + conseq;
	}
}

function go_search_petkind() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=pet_contest_list";
	document.frm.submit();
}

function go_search_petlike() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=pet_contest_list&like=1";
	document.frm.submit();
}

function go_total() {
	document.frm.all_view.value = "y";
	document.frm.search.value = "";
	document.frm.action =  "PetServlet?command=pet_contest_list";
	document.frm.submit();
}

function writeconfirmCon() {
	 if (document.frm.contitle.value == '') {
		  alert('제목을 입력하세요.');
		  document.frm.contitle.focus();
		  return false;
	 } else if (document.frm.conanikind[0].checked == false && document.frm.conanikind[1].checked == false
			 && document.frm.conanikind[2].checked == false && document.frm.conanikind[3].checked == false
			 && document.frm.conanikind[4].checked == false && document.frm.conanikind[5].checked == false
			 && document.frm.conanikind[6].checked == false) {
		  alert('동물종류를 선택하세요.');
		  return false;
	 } else if (document.frm.concontent.value == '') {
		  alert('내용을 입력하세요.');
		  document.frm.concontent.focus();
		  return false;
	 }
	 
	 return true;
}