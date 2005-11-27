<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="center.list.title"/></h2>
<br/>
<div align=center>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th><bean:message key="table.header.name"/></th>
			<th><bean:message key="table.header.adress"/></th>
			<th><bean:message key="table.header.phone"/></th>
			<th><bean:message key="table.header.nbRoom"/></th>
			<th><bean:message key="table.header.nbAvailable"/></th>
		</tr>
		<tr>
			<td><html:link action="/centerDetail">Toulouse</html:link></td>
			<td>112, rue de la toulousaine</td>
			<td>0556459899</td>
			<td>2</td>
			<td>117</td>
		</tr>
		<tr>
			<td><html:link action="/centerDetail">Paris</html:link></td>
			<td>13, rue de la parisienne</td>
			<td>0145654538</td>
			<td>10</td>
			<td>800</td>
		</tr>
	</table>
	<br/>
</div>