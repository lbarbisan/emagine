<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html>
	<head>
		<link rel=stylesheet href="/eMagine/common/style/style1.css" type="text/css">
		<title><tiles:getAsString name="title" /></title>
	</head>
	<body>
	<div align="center">
			<div class="login">
				<h2>Authentification</h2>
				<p><label for="login">Login </label><input type="text" id="login" size="20" /></p>
				<p><label for="pwd">Mot&nbsp;de&nbsp;passe </label><input type="text" id="pwd" size="20" /></p>
				<p><html:link action="/studentSearch"><input type="button" value="Envoyer"></html:link></p>
				</div>
			</div>
	</body>
</html>
