<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<form name="results">
	<h2>Acteurs en entreprise</h2>
	<br/>
	<div align=center>
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
				<td><html:link action="/actorOnglet">Bariton</html:link></td>
				<td>José</td>
				<td>PDG</td>
				<td>0134658900</td>
				<td>pdg@siemens.fr</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none"/></td>
				<td><html:link action="/actorOnglet">Manille</html:link></td>
				<td>Patricia</td>
				<td>DRH</td>
				<td>0134658902</td>
				<td>rh@siemens.fr</td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');">Aucun</a> </li>
		</ul>
		<h2>&nbsp;</h2>	
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer un acteur"/></a></li>
			<li><html:link action="/actorMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></html:link></li>
			<li><html:link action="/actorEmailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effectuer un mailing"/></html:link></li>
			<li><html:link action="/actorMailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effectuer un publipostage"/></html:link></li>
			<li><html:link action="/companyExtract"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire une liste d'acteurs"/></html:link></li>
			<li><html:link action="/actorCreate"><img src="/eMagine/common/images/icones/ajouter.png" alt="Ajouter un acteur"/></html:link></li>
		</ul>
	</div>
</form>