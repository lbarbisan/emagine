<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.firmActorModifyForm.action.value = value;
	}

	function deleteActor() {
		if(confirm("Souhaitez-vous réellement supprimer cet acteur ?")) {
			open("/eMagine/actorDelete.do?action=delete&from=modify&currentSelectedIds=" + document.firmActorModifyForm.elements['idFirmActorToModify'].value, "_self");
		}
	}
	
	function modifyActor() {
		setAction('modify');
		document.firmActorModifyForm.submit();
	}
	
	function resetForm() {
		document.firmActorModifyForm.reset();
	}
-->
</script>

<div class="tabs">
	<ul>
		<span class="tab_clicked"><li><html:link action="/actorVisuInfo">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li></span>
		<li><html:link action="/actorVisuEvent">Ev&eacute;nement</html:link></li>
	</ul>
</div>

<html:form action="/actorModify" method="POST" focus="lastname">

<div class="tabs_div">

<div class="form">
		<br/>
		<p><label for="lastname"><bean:message key="form.name"/><font color="red">*</font> </label><html:text property="lastname" size="20" /></p>
		<p><label for="firstname"><bean:message key="form.firstName"/><font color="red">*</font> </label><html:text property="firstname" size="20" /></p>
		<p>
			<label for="idFunction"><bean:message key="form.function"/></label>
			<html:select property="idFunction">
				<html:optionsCollection property="functions" value="id" label="name"/>		
			</html:select>
		</p>
		<p><label for="adress"><bean:message key="form.adress"/><font color="red">*</font> </label><html:text property="adress" size="20" /></p>
		<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><html:text property="postalCode" size="20" /></p>
		<p><label for="city"><bean:message key="form.city"/><font color="red">*</font> </label><html:text property="city" size="20" /></p>
		<p><label for="idDepartment"><bean:message key="form.department"/><font color="red">*</font> </label>
			<html:select property="idDepartment">
				<html:optionsCollection property="departments" value="id" label="name"/>		
			</html:select>
		<p><label for="phone"><bean:message key="form.phone"/></label><html:text property="fixPhone" size="20" /></p>	
		<p><label for="mobile"><bean:message key="form.mobile"/></label><html:text property="portPhone" size="20" /></p>
		<p><label for="fax"><bean:message key="form.fax"/></label><html:text property="fax" size="20" /></p>
		<p><label for="mail"><bean:message key="form.email"/><font color="red">*</font> </label><html:text property="mail" size="20" /></p>
	</div>
	<br/>
	<h3><bean:message key="title.pupils"/></h3>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.class"/></th>
				<th><bean:message key="table.header.group"/></th>
				<th><bean:message key="table.header.initDate"/></th>
				<th><bean:message key="table.header.endDate"/></th>
			</tr>
			
			<logic:notEmpty name="firmActorModifyForm" property="results">
				<logic:iterate id="pupille" name="firmActorModifyForm" property="results" type="fr.umlv.ir3.emagine.apprentice.Apprentice">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= pupille.getId().toString() %>" />&nbsp;</td>
						<td><html:link action="/actorModify?action=show" paramId="id" paramName="pupille" paramProperty="id"><bean:write name="pupille" property="lastname" />&nbsp;</html:link></td>
						<td><bean:write name="pupille" property="firstname" />&nbsp;</td>
						<td><bean:write name="pupille" property="firstname" />&nbsp;</td>
						<td><bean:write name="pupille" property="firstname" />&nbsp;</td>
						<td><bean:write name="pupille" property="firstname" />&nbsp;</td>
						<td><bean:write name="pupille" property="firstname" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="firmActorModifyForm" property="results">
				<tr><td colspan="8">Pas de pupille</td></tr>
			</logic:empty>

		</table>
	</div>

<br/>

<div id="actions">
	<ul>
		<li><a href="javascript:checkAll('currentSelectedIds','firmActorModifyForm');">Tous</a>&nbsp;&nbsp;/</li>
		<li><a href="javascript:checkNothing('currentSelectedIds','firmActorModifyForm');">Aucun</a></li>
	</ul>

<br />
<html:errors />	

		<h2>&nbsp;</h2>	
		<ul>
			<li><html:link href="javascript:modifyActor();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
			<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
			<li><html:link href="javascript:deleteActor();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
			<li><html:link action="/actorApprenticeAdd?action=show"><img src="/eMagine/common/images/icones/ajouter.png" title="<bean:message key="button.title.add"/>"/></html:link></li>
		</ul>
	</div>
	</div>

<html:hidden property="action"/>
<html:hidden property="idFirmActorToModify"/>
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>