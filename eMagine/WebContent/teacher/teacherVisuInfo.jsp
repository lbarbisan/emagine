<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.teacherTutorModifyForm.action.value = value;
	}
	
	
	function deleteTeacher() {
		if(confirm("Souhaitez-vous réellement supprimer cet enseignant ?")) {
			document.teacherTutorModifyForm.action = "/eMagine/teacherDelete.do?action=delete&from=modify&currentSelectedIds=" + document.teacherTutorModifyForm.elements['idTeacherTutorToModify'].value;
			document.teacherTutorModifyForm.submit();
		}
	}
	
	function modifyTeacher() {
		setAction('modify');
		document.teacherTutorModifyForm.submit();
	}

	function resetForm() {
		document.teacherTutorModifyForm.reset();
	}
-->
</script>

<div class="tabs">
<ul>
	<span class="tab_clicked"><li>Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</li></span>
	<li><html:link action="/teacherVisuEvent">Ev&eacute;nement</html:link></li>	
</ul>
</div>
<div class="tabs_div">

<html:form action="/teacherModify" method="POST" focus="lastName">
	<div class="form">
		<br/>
		<p><label for="lastName"><bean:message key="form.name"/><font color="red">*</font> </label><html:text property="lastName" size="20" /></p>
		<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font> </label><html:text property="firstName" size="20" /></p>
		<p><label for="address"><bean:message key="form.adress"/><font color="red">*</font> </label><html:text property="address" size="20" /></p>
		<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><html:text property="postalCode" size="20" /></p>
		<p><label for="city"><bean:message key="form.city"/><font color="red">*</font> </label><html:text property="city" size="20" /></p>
		<p><label for="department"><bean:message key="form.department"/><font color="red">*</font></label>
			<html:select property="idDepartment">
			 	<html:optionsCollection property="departments" label="name" value="id" />
		  	</html:select>
		</p>
		
		<p><label for="phone"><bean:message key="form.phone"/></label><html:text property="phone" size="20" /></p>	
		<p><label for="cellular"><bean:message key="form.mobile"/></label><html:text property="cellular" size="20" /></p>
		<p><label for="fax"><bean:message key="form.fax"/></label><html:text property="fax" size="20" /></p>
		<p><label for="mail"><bean:message key="form.email"/><font color="red">*</font> </label><html:text property="mail" size="20" /></p>
	</div>
	<h3><bean:message key="title.pupils"/></h3>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.class"/></th>
				<th><bean:message key="table.header.group"/></th>
				<th><bean:message key="table.header.initDate"/></th>
				<th><bean:message key="table.header.endDate"/></th>
			</tr>
			<logic:notEmpty name="teacherTutorModifyForm" property="pupils">
				<logic:iterate id="currentPupil" name="teacherTutorModifyForm" property="pupils">
					<tr>
						<td><bean:write name="currentPupil" property="lastName" />&nbsp;</td>
						<td><bean:write name="currentPupil" property="firstName" />&nbsp;</td>
						<td><bean:write name="currentPupil" property="class" />&nbsp;</td>
						<td><bean:write name="currentPupil" property="group" />&nbsp;</td>
						<td><bean:write name="currentPupil" property="initDate" />&nbsp;</td>
						<td><bean:write name="currentPupil" property="endDate" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="teacherTutorModifyForm" property="pupils">
				<tr><td colspan="6">Aucun pupille enregistré</td></tr>
			</logic:empty>
		</table>
	</div>
	<html:errors />
	<div id="actions">
		<h2>&nbsp;</h2>	
		<ul>
			<li><html:link action="/teacherApprenticeAdd"><img src="/eMagine/common/images/icones/ajouter.png" title="<bean:message key="button.title.add"/>"/></html:link></li>
		</ul>
	</div>
<html:hidden property="idTeacherTutorToModify" />
<html:hidden property="action" />
</html:form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
</div>
<div id="actions">
	<ul>
		<li><html:link href="javascript:modifyTeacher();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteTeacher();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
	</ul>
</div>
</div>
