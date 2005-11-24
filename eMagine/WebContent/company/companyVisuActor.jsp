<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Acteurs en entreprise</h2>
<br/>
<div align=center>
	<form name="results">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>Nom</th>
			<th>Pr&eacute;nom</th>
			<th>Fonction</th>
			<th>T&eacute;l&eacute;phone</th>
			<th>e-mail</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" name="all_none"/></td>
			<td><html:link action="/actorVisu">Bariton</html:link></td>
			<td>José</td>
			<td>PDG</td>
			<td>0134658900</td>
			<td>pdg@siemens.fr</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" name="all_none"/></td>
			<td><html:link action="/actorVisu">Manille</html:link></td>
			<td>Patricia</td>
			<td>DRH</td>
			<td>0134658902</td>
			<td>rh@siemens.fr</td>
		</tr>
	</table>
</div>
<div id="actions">
<a name="all_none" />
			<ul>
				<li><a href="#all_none" onclick="checkAll('results','all_none');">Tous</a> / </li>
				<li><a href="#all_none" onclick="checkNothing('results','all_none');">Aucun</a> </li>
			</ul>
			<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer un acteur"/></a></li>
		<li><html:link action="/actorMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></html:link></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/mailing.png" alt="Effecter un mailing"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/publipostage.png" alt="Effecter un publipostage"/></a></li>
		<li><html:link action="/companyExtract"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire une liste d'acteurs"/></html:link></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/ajouter.png" alt="Ajouter un acteur"/></a></li>
	</ul>
</div>
