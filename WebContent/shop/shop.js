function delconfirm(exseq) {
	if(confirm("정말로 삭제하시겠습니까?")) {
		location.href="PetServlet?command=shop_delete&exseq=" + exseq;
	}
}

function matchCancel(exseq) {
	if(confirm("정말로 취소하시겠습니까?")) {
		location.href="PetServlet?command=shop_match_cancle&exseq=" + exseq;
	}
}

function go_search() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=shop_list";
	document.frm.submit();
}

function go_search_match() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=shop_list&match=1";
	document.frm.submit();
}

function go_total() {
	document.frm.all_view.value = "y";
	document.frm.search.value = "";
	document.frm.action =  "PetServlet?command=shop_list";
	document.frm.submit();
}

function writeconfirm() {
	 if (document.frm.exarea.value == '') {
		  alert('지역을 선택하세요.');
		  document.frm.exarea.focus();
		  return false;
	 } else if (document.frm.extitle.value == '') {
		  alert('제목을 입력하세요.');
		  document.frm.extitle.focus();
		  return false;
	 } else if (document.frm.excontent.value == '') {
		  alert('내용을 입력하세요.');
		  document.frm.excontent.focus();
		  return false;
	 }
	 
	 return true;
}