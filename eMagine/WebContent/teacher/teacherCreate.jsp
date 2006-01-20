<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.teacherTutorModifyForm.action.value = value;
	}

	function createTeacher() {
		setAction('create');
		document.teacherTutorModifyForm.submit();
	}

	function resetForm() {
		document.teacherTutorModifyForm.reset();
	}
-->
</script>

<h2><bean:message key="teacher.create.title"/><html:link action="/teacherSearch?action=show"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<div class="form">
<html:form action="/teacherCreate" method="POST" focus="lastName">
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

<br/>
<html:errors />

	<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:createTeacher();"><html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.ok" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>

<html:hidden property="action" />
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>