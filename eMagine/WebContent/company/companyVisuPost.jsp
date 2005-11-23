<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Liste&nbsp;des&nbsp;postes</h2>
<br/>
<div align=center>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>Fili&egrave;re</th>
			<th>Nombre&nbsp;demand&eacute;</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/posteDetail">IR</html:link></td>
			<td>1</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/posteDetail">MFPI</html:link></td>
			<td>3</td>
		</tr>
	</table>
	<br/>
</div>