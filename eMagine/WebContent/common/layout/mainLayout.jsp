<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<html>
	<head>
		<link rel=stylesheet
			href="<%=request.getContextPath()%>/common/style/style1.css"
			type="text/css">
		<title><tiles:getAsString name="title" /></title>
	</head>
	<body>
		<tiles:insert attribute="mainMenu" />
		<tiles:insert attribute="subMainMenu" />
		<a name="top" />
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
