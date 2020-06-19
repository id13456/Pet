function writeconfirm() {
	 if (document.frm.hour.value == '') {
		  alert('시간을 선택하세요.');
		  document.frm.hour.focus();
		  return false;
	 } else if (document.frm.minute.value == '') {
		  alert('분을 선택하세요.');
		  document.frm.minute.focus();
		  return false;
	 } else if (document.frm.dtitle.value == '') {
		  alert('제목을 입력하세요.');
		  document.frm.dtitle.focus();
		  return false;
	 } else if (document.frm.dcontent.value == '') {
		  alert('내용을 입력하세요.');
		  document.frm.dcontent.focus();
		  return false;
	 }  else {
		 opener.parent.location.reload();
		 window.close();
		 return true;
	 }
}

function updateconfirm() {
	 if (document.frm.year.value == '') {
		  alert('년도를 선택하세요.');
		  document.frm.year.focus();
		  return false;
	 } else if (document.frm.month.value == '') {
		  alert('월을 선택하세요.');
		  document.frm.month.focus();
		  return false;
	 } else if (document.frm.hour.value == '') {
		  alert('시간을 선택하세요.');
		  document.frm.hour.focus();
		  return false;
	 } else if (document.frm.minute.value == '') {
		  alert('분을 선택하세요.');
		  document.frm.minute.focus();
		  return false;
	 } else if (document.frm.dtitle.value == '') {
		  alert('제목을 입력하세요.');
		  document.frm.dtitle.focus();
		  return false;
	 } else if (document.frm.dcontent.value == '') {
		  alert('내용을 입력하세요.');
		  document.frm.dcontent.focus();
		  return false;
	 } 
	 
	 return ture;
}

function delconfirm(dseq) {
	if(confirm("정말로 삭제하시겠습니까?")) {
		location.href="PetServlet?command=pet_diary_delete&dseq=" + dseq;
		opener.parent.location.reload();
		window.close();	
	}
}

function openview(dseq){
	 window.open("PetServlet?command=pet_diary_view&dseq=" + dseq, "_blank_1", "toolbar=no, menubar=no, scrollbars=no, "
			 		+"resizable=no, width=1000, height=400");
}
function openwriteview(y, m, d){
	 window.open("PetServlet?command=pet_diary_write_form&y=" + y + "&m=" + m + "&d=" +d, "_blank_1", "toolbar=no, menubar=no, scrollbars=no, "
			 		+"resizable=no, width=1000, height=400");
}