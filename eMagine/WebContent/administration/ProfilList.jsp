<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Liste&nbsp;des&nbsp;profils</h2>
<br/>
<div align=center>
	<form name="results">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>Nom</th>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none" /></td>
				<td><html:link action="/profilDetail">ProfilApprenti</html:link></td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none" /></td>
				<td><html:link action="/profilDetail">ProfilEnseignant</html:link></td>
			</tr>
		</table>
		<br/>
</div>
<div id="actions">
		<a name="all_none" />
			<ul>
				<li><a href="#all_none" onclick="checkAll('results','all_none');">Tous</a> / </li>
				<li><a href="#all_none" onclick="checkNothing('results','all_none');">Aucun</a> </li>
			</ul>
			<h2>&nbsp;</h2>
			<ul>
				<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer profil(s)"/></a></li>
			</ul>
		</form>
</div>