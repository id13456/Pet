function do_user_delete() {
	var count = 0;
	// 전달된 체크박스의 갯수가 1개이면 length는 undefined, 전달된 체크박스의 갯수가 2개이상이면 length는 그 갯수를 숫자로 저장
	if(document.frm.userid.length == undefined) {
		if(document.frm.userid.checked == true) {
			count++;
		}
	}
	
	for(var i=0 ; i<document.frm.userid.length ; i++) {
		if(document.frm.userid[i].checked == true)
			count++;
	}
	
	if(count == 0)
		alert("삭제할 항목을 선택해 주세요.");
	else {
		document.frm.action = "NonageServlet?command=user_delete";
		document.frm.submit();
	}
}