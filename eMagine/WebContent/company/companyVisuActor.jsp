<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<form name="results">
	<h2><bean:message key="actor.list.title"/></h2>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.function"/></th>
				<th><bean:message key="table.header.phone"/></th>
				<th><bean:message key="table.header.email"/></th>
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
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>	
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer un acteur"/></a></li>
			<li><html:link action="/actorMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" title="Cr&eacute;er une maling list"/></html:link></li>
			<li><html:link action="/actorEmailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effectuer un mailing"/></html:link></li>
			<li><html:link action="/actorMailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effectuer un publipostage"/></html:link></li>
			<li><html:link action="/actorExtract"><img src="/eMagine/common/images/icones/extraire.png" title="Extraire une liste d'acteurs"/></html:link></li>
			<li><html:link action="/actorCreate"><img src="/eMagine/common/images/icones/ajouter.png" title="Ajouter un acteur"/></html:link></li>
		</ul>
	</div>
</form>