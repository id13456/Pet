function delconfirm(outseq) {
	if(confirm("정말로 삭제하시겠습니까?")) {
		location.href="PetServlet?command=pet_adopt_delete&outseq=" + outseq;
	}
}

function go_search_pet() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=pet_adopt_list";
	document.frm.submit();
}

function go_search_petmatch() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=pet_adopt_list&match=1";
	document.frm.submit();
}

function go_total() {
	document.frm.all_view.value = "y";
	document.frm.search.value = "";
	document.frm.action =  "PetServlet?command=pet_adopt_list";
	document.frm.submit();
}

function go_search_petgroup1() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=pet_adopt_list&group=1";
	document.frm.submit();
}

function go_search_petgroup2() {
	document.frm.all_view.value = "n";
	document.frm.action =  "PetServlet?command=pet_adopt_list&group=2";
	document.frm.submit();
}

function writeconfirm() {
	 if (document.frm.outarea.value == '') {
		  alert('지역을 입력하세요.');
		  document.frm.outarea.focus();
		  return false;
	 } else if (document.frm.outtitle.value == '') {
		  alert('제목을 입력하세요.');
		  document.frm.outtitle.focus();
		  return false;
	 } else if (document.frm.outgroup[0].checked == false && document.frm.outgroup[1].checked == false) {
		  alert('입양종류를 선택하세요.');
		  return false;
	 } else if (document.frm.outkind[0].checked == false && document.frm.outkind[1].checked == false
			 && document.frm.outkind[2].checked == false && document.frm.outkind[3].checked == false
			 && document.frm.outkind[4].checked == false && document.frm.outkind[5].checked == false
			 && document.frm.outkind[6].checked == false) {
		  alert('동물종류를 선택하세요.');
		  return false;
	 } else if (document.frm.outage.value == '') {
		  alert('동물나이를 입력하세요.');
		  document.frm.outage.focus();
		  return false;
	 } else if (document.frm.outsex[0].checked == false && document.frm.outsex[1].checked == false) {
		  alert('동물 성별을 선택하세요.');
		  return false;
	 } else if (document.frm.outindex.value == '') {
		  alert('소개를 입력하세요.');
		  document.frm.outindex.focus();
		  return false;
	 }
	 
	 return true;
}