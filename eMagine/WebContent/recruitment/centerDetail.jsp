<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.formationCenterModifyForm.action.value = value;
	}

	function deleteRooms() {
		if(confirm("Souhaitez-vous réellement supprimer ces salles ?")) {
			document.formationCenterModifyForm.action = "/eMagine/roomDelete.do?action=delete&from=search" ;
			document.formationCenterModifyForm.submit();
		}
	}	
	function modifyCenter() {
		setAction('modify');
		document.formationCenterModifyForm.submit();
	}
	
-->
</script>

<h2><bean:message key="center.detail.title"/></h2>
<br/>

<html:form action="/centerDetail" method="POST" focus="name">
	<div class="form">
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><html:text property="name" size="20" /></p>
		<p><label for="street"><bean:message key="form.adress"/><font color="red">*</font> </label><html:text property="street" size="20"/></p>
		<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><html:text property="postalCode" size="20" /></p>
			<p><label for="city"><bean:message key="form.city"/><font color="red">*</font> </label><html:text property="city" size="20" /></p>
			<p><label for="department"><bean:message key="form.department"/><font color="red">*</font></label>
			<html:select property="idDepartment">
				<html:optionsCollection property="departments" value="id" label="name"/>		
			</html:select>
		</p>	
		<p><label for="phone"><bean:message key="form.phone"/></label><html:text property="phone" size="20" /></p>	
	</div>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.capacity"/></th>
				<th><bean:message key="table.header.nbAvailable"/></th>
			</tr>
		  	<logic:notEmpty name="formationCenterModifyForm" property="room">
				<logic:iterate id="currentRoom" name="formationCenterModifyForm" property="room" type="fr.umlv.ir3.emagine.apprentice.candidate.room.Room">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= currentRoom.getId().toString() %>" /></td>
						<td><html:link action="<%= "/roomDetail.do?action=show&id="+ currentRoom.getId()%>" paramId="idCenter" paramName="formationCenterModifyForm" paramProperty="idFormationCenterToModify"><bean:write name="currentRoom" property="name" />&nbsp;</html:link></td>
						<td><bean:write name="currentRoom" property="capacity" />&nbsp;</td>
						<td><bean:write name="currentRoom" property="numberOfFreeSits" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="formationCenterModifyForm" property="room">
				<tr><td colspan="3">Aucune salle d'examen</td></tr>
			</logic:empty>	
		</table>
	</div>
	<html:errors />
	<div id="actions">
		<logic:notEmpty name="formationCenterModifyForm" property="room">
		<ul>
			<li><a href="javascript:checkAll('formationCenterModifyForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('formationCenterModifyForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		</logic:notEmpty>	
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:modifyCenter();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
			<li><html:link href="javascript:deleteRooms();"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></html:link></li>
			<li><html:link action="/roomAdd.do?action=show" paramId="idCenter" paramName="formationCenterModifyForm" paramProperty="idFormationCenterToModify"><img src="/eMagine/common/images/icones/ajouter.png" title="<bean:message key="button.title.add"/>"/></html:link></li>
		</ul>
	</div>
	<html:hidden property="idFormationCenterToModify" />
	<html:hidden property="action" />
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>