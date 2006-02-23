// Bas? sur open_compose_win(args) du projet IMP
// IMP: Copyright 2001-2004, The Horde Project. IMP is under the GPL.
//   Horde Project: http://horde.org/ | IMP: http://horde.org/imp/
//      GNU Public License: http://www.fsf.org/copyleft/gpl.html

function open_extract_win(form, extractionEntityName) {
	open_win(form, extractionEntityName, 'extract', "extract.do?action=showConfig");
}

function open_mail_win(form, extractionEntityName) {
	open_win(form, extractionEntityName, 'mail', "mail.do?action=show");
}

function open_mailing_win(form, extractionEntityName) {
	open_win(form, extractionEntityName, 'mailing', "mailing.do?action=show");
}

function open_mailing_create_win(form, extractionEntityName) {
	open_win(form, extractionEntityName, 'mailingCreate', "mailingCreate.do?action=show");
}

function open_win(form, extractionEntityName, action, url, extractionEntityNameParam) {
	if (url.indexOf('?') == -1) glue = '?';
	else glue = '&';
	var now = new Date();
	if (!extractionEntityNameParam) {
		extractionEntityNameParam = 'extractionEntityName';
	}
	// backup des action / target
	var old_action = form.action;
	var old_target = form.target;

	var name = action + "_windows_" + extractionEntityName;
	if (extractionEntityName != "") {
        url = url + glue + extractionEntityNameParam + '=' + extractionEntityName;// + '&' + 'uniq=' + now.getTime();
    } else {
        url = url + glue;// + 'uniq=' + now.getTime();
    }

	// set des nouvelles action /target
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

	try {
		self.close(name);	//TODO : ne marche pas dans firefox...
	}
	catch (ex) {;}

    window = window.open('_blank', name, param);
    if (!window.opener) {
        window = self;
    }
    form.submit();
    // Remise des anciennes valeurs d'action / target
    //setTimeout("resetOldActionTarget("+form+", "+old_action+", "+old_target+")", 1000);
    //pausecomp(1000);
    //alert(old_target);
    //resetOldActionTarget(form, old_action, old_target);
}

function resetOldActionTarget(form, old_action, old_target) {
    form.action = old_action;
    form.target = old_target;
}

// www.sean.co.uk
function pausecomp(millis)
{
	date = new Date();
	var curDate = null;
	
	do { var curDate = new Date(); }
	while(curDate-date < millis);
}