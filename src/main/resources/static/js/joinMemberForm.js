function fn_submit() {
	let frm = document.frm;
	
	let id = frm.id.value;
	let pwd = frm.pwd.value;
	let name = frm.name.value;
	let email = frm.email. value;
	
	if (id.length == 0 || id == ""){
		alert("아이디가 입력되지 않았습니다. 다시 입력하세요.");
		frm.id.foucs();
	} else if (pwd.length == 0 || pwd == ""){
		alert("암호가 입력되지 않았습니다. 다시 입력하세요.");
		frm.pwd.foucs();
	} else if (name.length == 0 || name == ""){
		alert("이름이 입력되지 않았습니다. 다시 입력하세요.");
		frm.name.foucs();
	} else if (email.length == 0 || email == ""){
		alert("이메일이 입력되지 않았습니다. 다시 입력하세요.");
		frm.email.foucs();
	} else{
		frm.action = "/member/joinMember";
		frm.method = "post";
		frm.submit();
	}
}