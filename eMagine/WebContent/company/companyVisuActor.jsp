<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--

	function setAction(value) {
		document.companyModifyForm.action.value = value;
	}

	function change(action) {
		document.companyModifyForm.action = "/eMagine/" + action + ".do";
		document.companyModifyForm.submit();
	}
		
-->
</script>
<div class="tabs">
	<ul>
			<li><html:link href="javascript:change('companyVisuInfo');">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li>
			<span class="tab_clicked"><li><html:link href="javascript:change('companyVisuActor');">Acteur</html:link></li></span>
			<li><html:link href="javascript:change('companyVisuPost');">Poste</html:link></li>
			<li><html:link href="javascript:change('companyVisuEvent');">Ev&eacute;nement</html:link></li>
	</ul>
</div>

<html:form action="companyModify" method="POST">

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

			<logic:notEmpty name="companyModifyForm" property="actors">
				<logic:iterate id="actor" name="companyModifyForm" property="actors" type="fr.umlv.ir3.emagine.firm.actor.FirmActor">
					<tr>
						<td>&nbsp;</td>
						<td><html:link action="/actorVisuInfo?action=show" paramId="id" paramName="actor" paramProperty="id"><bean:write name="actor" property="lastname" />&nbsp;</html:link></td>
						<td><bean:write name="actor" property="firstname" />&nbsp;</td>
						<td><bean:write name="actor" property="function" />&nbsp;</td>
						<td><bean:write name="actor" property="phone" />&nbsp;</td>
						<td><bean:write name="actor" property="email" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="companyModifyForm" property="actors">
				<tr><td colspan="6">Pas de résultats</td></tr>
			</logic:empty>

		</table>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>	
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
			<li><html:link action="/actorMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" title="<bean:message key="button.title.mailingListCreate"/>"/></html:link></li>
			<li><html:link action="/actorEmailDo"><img src="/eMagine/common/images/icones/mailing.png" title="<bean:message key="button.title.email"/>"/></html:link></li>
			<li><html:link action="/actorMailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="<bean:message key="button.title.mailing"/>"/></html:link></li>
			<li><html:link action="/actorExtract"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
			<li><html:link action="/actorCreate"><img src="/eMagine/common/images/icones/ajouter.png" title="<bean:message key="button.title.add"/>"/></html:link></li>
		</ul>
	</div>
</div>

</html:form>