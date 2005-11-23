<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<html>
	<head>
		<link rel=stylesheet href="/eMagine/common/style/style1.css" type="text/css">
		<title><tiles:getAsString name="title" /></title>
	</head>
	<body>
		<p><label for="login">Login </label><input type="text" id="login" size="20" /></p>
		<p><label for="pwd">Mot&nbsp;de&nbsp;passe </label><input type="text" id="pwd" size="20" /></p>
		<p><a href"index1.jsp"><input type="submit" value="ok"/></a></p>
	</body>
</html>
