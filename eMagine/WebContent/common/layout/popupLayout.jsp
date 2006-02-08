<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<html>
	<head>
		<link rel="stylesheet" href="/eMagine/common/style/style1.css" type="text/css">
		<title><tiles:getAsString name="title" /></title>
		<script type="text/javascript" src="/struts-layout/config/javascript.js"></script>
		<script type="text/javascript" src="/eMagine/common/js/checkboxTools.js"></script>
		<script type="text/javascript" src="/eMagine/common/js/extractionTools.js"></script>
	</head>
	<body>
		<tiles:insert attribute="list" />

		<br />
		<a href="javascript:window.close();">Fermer</a>
	</body>
</html>
