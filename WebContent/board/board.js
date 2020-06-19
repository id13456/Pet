function delconfirm(bseq) {
	if(confirm("정말로 삭제하시겠습니까?")) {
		location.href="PetServlet?command=pet_board_delete&bseq=" + bseq;
	}
}

function go_search_board() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=pet_board_list";
	document.frm.submit();
}

function go_total() {
	document.frm.all_view.value = "y";
	document.frm.search.value = "";
	document.frm.action =  "PetServlet?command=pet_board_list";
	document.frm.submit();
}

function boardCheck() {
	 if (document.frm.btitle.value == '') {
		  alert('제목을 입력하세요.');
		  document.frm.btitle.focus();
		  return false;
	 } else if (document.frm.bgroup[0].checked == false && document.frm.bgroup[1].checked == false) {
		  alert('게시글 종류를 체크하세요.');
		  return false;
	 }  else if (document.frm.bcontent.value == '') {
		  alert('내용을 입력하세요.');
		  document.frm.bcontent.focus();
		  return false;
	 } 
	 
	 return true;
}