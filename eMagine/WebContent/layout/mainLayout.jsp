<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<HTML>
<HEAD>
<%-- <link rel=stylesheet href="<%=request.getContextPath()%>/layouts/stylesheet.css" type="text/css"> --%>
<title><tiles:getAsString name="title" /></title>
</HEAD>

<body>
<table border="1" width="100%">
	<tr>
		<td colspan="2"><tiles:insert attribute="menu1" /></td>
	</tr>
	<tr>
		<td width="140" valign="top"><tiles:insert attribute="menu2" /></td>
		<td rowspan="2" valign="top" align="left"><tiles:insert attribute="body" /></td>
	</tr>
	<tr>
		<td><tiles:insert attribute="modif" /></td>
	</tr>
	<tr>
		<td colspan="2"><tiles:insert attribute="footer" /></td>
	</tr>
</table>
</body>
</html>
