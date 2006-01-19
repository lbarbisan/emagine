function checkAll(form_name, chk_name){
	check(form_name, chk_name, true);
}
function checkNothing(form_name, chk_name){
	check(form_name, chk_name, false);
}
function check(form_name, chk_name, status){
	chk_list = document.forms[form_name].elements[chk_name];

	if(chk_list.length) {
		for(var i=0; i< chk_list.length; i++){
			chk_list[i].checked=status;
		}
	}
	else {
		chk_list.checked=status;
	}
}
