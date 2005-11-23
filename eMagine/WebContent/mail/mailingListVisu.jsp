<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Liste&nbsp;les&nbsp;mailings-lists</h2>
<br/>
<div align=center>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>Nom</th>
			<th>Description</th>
			<th>&nbsp;</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>	
			<td><html:link action="/mailingListUpdate">App3</html:link></td>
			<td>Apprenti 3ème année</td>
			<td><html:link action="/emailDo"><img src="/eMagine/common/images/icones/mailing.png" alt="Effecter un mailing"/></html:link><html:link action="/mailDo"><img src="/eMagine/common/images/icones/publipostage.png" alt="Effecter un publipostage"/></html:link></td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>	
			<td><html:link action="/mailingListUpdate">EnseignantTuteurs</html:link></td>
			<td>Ensemble des enseignants étant tuteurs</td>
			<td><html:link action="/emailDo"><img src="/eMagine/common/images/icones/mailing.png" alt="Effecter un mailing"/></html:link><html:link action="/mailDo"><img src="/eMagine/common/images/icones/publipostage.png" alt="Effecter un publipostage"/></html:link></td>
		</tr>
	</table>
	<br/>
</div>
<div id="actions">
	<ul>
		<li><a href="#">Tous</a> / </li>
		<li><a href="#">Aucun</a> </li>
	</ul>
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link action="/supprimer"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer mailing-list"/></html:link></li>
	</ul>
</div>