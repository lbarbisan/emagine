<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<form name="results">
	<h2>Visualiser&nbsp;les&nbsp;courriers&nbsp;types</h2>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>Nom</th>
				<th>Fichier</th>
				<th>Concern&eacute;</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>	
				<td><html:link action="/mailTypeUpdate">JPO</html:link></td>
				<td>jpo.csv</td>
				<td>Enseignant</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>	
				<td><html:link action="/mailTypeUpdate">EDT3</html:link></td>
				<td>emploi_du_temps_3.csv</td>
				<td>Apprenti</td>
			</tr>
		</table>
		<br/>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');">Aucun</a> </li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link action="/supprimer"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer courrier type"/></html:link></li>
			<li><html:link action="/emailDo"><img src="/eMagine/common/images/icones/mailing.png" alt="Effecter un mailing"/></html:link></li>
			<li><html:link action="/mailDo"><img src="/eMagine/common/images/icones/publipostage.png" alt="Effecter un publipostage"/></html:link></li>
		</ul>
	</div>
</form>