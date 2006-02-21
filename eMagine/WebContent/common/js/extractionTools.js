// Bas? sur open_compose_win(args) du projet IMP
// IMP: Copyright 2001-2004, The Horde Project. IMP is under the GPL.
//   Horde Project: http://horde.org/ | IMP: http://horde.org/imp/
//      GNU Public License: http://www.fsf.org/copyleft/gpl.html

function open_extract_win(form, extractionEntityName) {
	open_win(form, extractionEntityName, "extract.do?action=showConfig");
}

function open_mail_win(form, extractionEntityName) {
	open_win(form, extractionEntityName, "mail.do?action=showConfig");
}

function open_win(form, extractionEntityName, url) {
	if (url.indexOf('?') == -1) glue = '?';
	else glue = '&';
	var now = new Date();
	var name = "extract_windows_" + extractionEntityName;
	if (extractionEntityName != "") {
        url = url + glue + 'extractionEntityName=' + extractionEntityName;// + '&' + 'uniq=' + now.getTime();
    } else {
        url = url + glue;// + 'uniq=' + now.getTime();
    }

    form.action = url;
    form.target = name;

	var Width = screen.width;
    if (Width > 775) {
        Width = 700;
    } else {
        Width -= 75;
    }
    var Height = screen.height;
    if (Height > 725) {
        Height = 650;
    } else {
        Height -= 75;
    }
    param = "toolbar=no,location=no,status=yes,scrollbars=yes,resizable=yes,width=" + Width + ",height=" + Height + ",left=0,top=0";
    /*
    eval("name = window.open(url, name, param)");
    if (!eval("name.opener")) {
        eval("name.opener = self");
    }*/
    form.submit();
}
