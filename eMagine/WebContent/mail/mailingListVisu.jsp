<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="mailingList.list.title"/></h2>
<form name="results">
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.description"/></th>
				<th>&nbsp;</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>	
				<td><html:link action="/mailingListDetail">App3</html:link></td>
				<td>Apprenti 3ème année</td>
				<td><html:link action="/emailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effectuer un mailing"/></html:link><html:link action="/mailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effecter un publipostage"/></html:link></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>	
				<td><html:link action="/mailingListDetail">EnseignantTuteurs</html:link></td>
				<td>Ensemble des enseignants étant tuteurs</td>
				<td><html:link action="/emailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effectuer un mailing"/></html:link><html:link action="/mailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effecter un publipostage"/></html:link></td>
			</tr>
		</table>
		<br/>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link action="/supprimer"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer mailing-list"/></html:link></li>
		</ul>
	</div>
</form>