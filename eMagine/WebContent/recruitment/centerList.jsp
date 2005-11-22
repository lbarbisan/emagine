<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Liste&nbsp;des&nbsp;centres&nbsp;d'examens</h2>
<br/>
<div align=center>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>Nom</th>
			<th>Adresse</th>
			<th>Téléphone</th>
			<th>Nombre&nbsp;de&nbsp;salles</th>
			<th>Nombre&nbsp;de&nbsp;places&nbsp;disponibles</th>
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
			<td>112, rue de la toulousaine</td>
			<td>0145654538</td>
			<td>10</td>
			<td>800</td>
		</tr>
	</table>
	<br/>
</div>