<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html>
	<head>
		<link rel=stylesheet href="/eMagine/common/style/style1.css" type="text/css">
		<title><tiles:getAsString name="title" /></title>
	</head>
	<body>
	<div align="center">
	<img src="/eMagine/common/images/auth.png"/>
	<br/>
			<div class="login">
				<h2>Authentification</h2>
				<br/>
				<p><label for="login">Login </label><input type="text" id="login" size="20" /></p>
				<p><label for="pwd">Mot&nbsp;de&nbsp;passe </label><input type="text" id="pwd" size="20" /></p>
				<br/>
				<hr/>
				<div align=center><html:link action="/studentSearch"><input type="button" value="Envoyer"></html:link></div>
				</div>
			</div>
	</body>
</html>
