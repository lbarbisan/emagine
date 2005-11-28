<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="mailType.list.title"/></h2>
<form name="results">
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.file"/></th>
				<th><bean:message key="table.header.concerned"/></th>
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
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link action="/supprimer"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer courrier type"/></html:link></li>
			<li><html:link action="/emailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effecter un mailing"/></html:link></li>
			<li><html:link action="/mailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effecter un publipostage"/></html:link></li>
		</ul>
	</div>
</form>