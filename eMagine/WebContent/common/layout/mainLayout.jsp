<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<html>
	<head>
	<link rel=stylesheet href="<%=request.getContextPath()%>/common/style/style1.css" type="text/css">
	<title><tiles:getAsString name="title" /></title>
	</head>
	
	<body>
	<tiles:insert attribute="mainMenu"/>
	<tiles:insert attribute="subMainMenu"/>
	<tiles:insert attribute="subMenu"/>
	<tiles:insert attribute="modif"/>
	<tiles:insert attribute="body"/>
	<tiles:insert attribute="footer"/>
	</body>
</html>
