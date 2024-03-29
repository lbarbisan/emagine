<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--

	function setAction(value) {
		document.firmActorListForm.action.value = value;
	}

	function change(action) {
		document.firmActorListForm.action = "/eMagine/" + action + ".do";
		document.firmActorListForm.target = '';
		document.firmActorListForm.submit();
	}
	
	
	function deletes() {
		if(confirm("Souhaitez-vous r�ellement supprimer ces acteurs ?")) {
			document.firmActorListForm.action = "/eMagine/actorDelete.do?action=delete&from=search";
			document.firmActorListForm.target = '';
			document.firmActorListForm.submit();
		}
	}
		
-->
</script>
<div class="tabs">
	<ul>
			<li><html:link href="javascript:change('companyVisuInfo');">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li>
			<span class="tab_clicked"><li><html:link href="javascript:change('companyVisuActor');">Acteur</html:link></li></span>
			<li><html:link href="javascript:change('companyVisuPost');">Poste</html:link></li>
			<li><html:link action="/eventSearch.do?action=show&from=firm">Ev&eacute;nement</html:link></li>
	</ul>
</div>

<html:form action="/companyVisuActor" method="POST">

<div class="tabs_div">
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

			<logic:notEmpty name="firmActorListForm" property="results">
				<logic:iterate id="actor" name="firmActorListForm" property="results" type="fr.umlv.ir3.emagine.firm.actor.FirmActor">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= actor.getId().toString() %>" />&nbsp;</td>
						<td><html:link action="/actorModify?action=show" paramId="id" paramName="actor" paramProperty="id"><bean:write name="actor" property="lastName" />&nbsp;</html:link></td>
						<td><bean:write name="actor" property="firstName" />&nbsp;</td>
						<td><bean:write name="actor" property="function" />&nbsp;</td>
						<td><bean:write name="actor" property="phone" />&nbsp;</td>
						<td><bean:write name="actor" property="email" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="firmActorListForm" property="results">
				<tr><td colspan="6">Pas de r�sultats</td></tr>
			</logic:empty>

		</table>
	</div>
	<div id="actions">
		<logic:notEmpty name="firmActorListForm" property="results">
		<ul>
			<li><a href="javascript:checkAll('firmActorListForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('firmActorListForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		</logic:notEmpty>	
		<h2>&nbsp; </h2>	
		<ul>
			<li><html:link action="/actorCreate?action=show"><html:img src="/eMagine/common/images/icones/ajouter.png" titleKey="button.title.add"/></html:link></li>
			<li><html:link href="javascript:deletes();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
			<li><html:link href="javascript:open_mailing_create_win(document.firmActorListForm, 'firmActor')"><html:img src="/eMagine/common/images/icones/creer_mailing_list.png" titleKey="button.title.email"/></html:link></li>
			<li><html:link href="javascript:open_mailing_win(document.firmActorListForm, 'firmActor')"><html:img src="/eMagine/common/images/icones/mailing.png" titleKey="button.title.email"/></html:link></li>
			<li><html:link href="javascript:open_mail_win(document.firmActorListForm, 'firmActor')"><html:img src="/eMagine/common/images/icones/publipostage.png" titleKey="button.title.mailing"/></html:link></li>
			<li><html:link href="javascript:open_extract_win(document.firmActorListForm, 'firmActor')"><html:img src="/eMagine/common/images/icones/extraire.png" titleKey="button.title.extract"/></html:link></li>
		</ul>
	</div>
</div>

<html:hidden property="action" />
</html:form>