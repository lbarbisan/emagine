<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:getAsString /></title>
</head>
<body>
<p><label for="login">Login </label><input type="text" id="login"
	size="20" /></p>
<p><label for="pwd">Mot&nbsp;de&nbsp;passe </label><input type="text"
	id="pwd" size="20" /></p>
<p><a href"index1.jsp"><input type="submit" value="ok"/></a></p>
</body>
</html>




<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<html>
	<head>
		<link rel=stylesheet
			href="/eMagine/common/style/style1.css"
			type="text/css">
		<script type="text/javascript" src="/eMagine/common/js/checkboxTools.js"></script>
		<title><tiles:getAsString name="title" /></title>
	</head>
	<body>
		<a name="top" />
		<tiles:insert attribute="mainMenu" />
		<tiles:insert attribute="subMainMenu" />
		<div id="global">
			<div id="left_bloc">
				<div class="left">
					<tiles:insert attribute="subMenu" />
				</div>
				<div class="left">
					<tiles:insert attribute="modif" />
				</div>
			</div>
			<div class="content">
				<tiles:insert attribute="body" />
			</div>			
		</div>
		<tiles:insert attribute="footer" />
	</body>
</html>
