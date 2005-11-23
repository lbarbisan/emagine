<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<html>
	<head>
		<link rel=stylesheet href="/eMagine/common/style/style1.css" type="text/css">
		<script type="text/javascript" src="/eMagine/common/js/checkboxTools.js"/>
		<script type="text/javascript" src="/eMagine/common/js/function.js"/>
		<title><tiles:getAsString name="title"/></title>
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
