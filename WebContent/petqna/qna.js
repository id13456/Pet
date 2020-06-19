function go_rep(qseq) {
	if(document.form.qreply.value == "") {
		alert("답변을 입력해주세요.");
		document.form.qreply.focus();
		return false;
	} else {
   		document.form.action="PetServlet?command=pet_qna_rep&qseq="+qseq;
   		document.form.submit();
	}
}  

function delconfirm(qseq) {
	if(confirm("정말로 삭제하시겠습니까?")) {
		location.href="PetServlet?command=pet_qna_delete&qseq=" + qseq;
	}
}

function writeconfirm() {
	 if (document.form.qtitle.value == '') {
		  alert('제목을 입력하세요.');
		  document.form.qtitle.focus();
		  return false;
	 } else if (document.form.qgroup[0].checked == false && document.form.qgroup[1].checked == false) {
		  alert('질문유형을 선택하세요.');
		  return false;
	 } else if (document.form.qcontent.value == '') {
		  alert('내용을 입력하세요.');
		  document.form.qcontent.focus();
		  return false;
	 }
	 
	 return true;
}

function go_search_my() {
	document.frm.all_view.alue = "n";
	document.frm.action =  "PetServlet?command=pet_qna_list&my=1";
	document.frm.submit();
}

function go_search_myrep() {
	document.frm.all_view.alue = "n";
	document.frm.action =  "PetServlet?command=pet_qna_list&rep=n";
	document.frm.submit();
}

function go_search_rep() {
	document.frm.all_view.value = "n";
	document.frm.action = "PetServlet?command=pet_qna_list&rep=n";
	document.frm.submit();
}

function go_total_qna() {
	document.frm.all_view.value = "y";
	document.frm.action =  "PetServlet?command=pet_qna_list";
	document.frm.submit();
}