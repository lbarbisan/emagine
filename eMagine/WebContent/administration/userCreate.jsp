<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.userModifyForm.action.value = value;
	}

	function createUser() {
		setAction('create');
		document.userModifyForm.submit();
	}

	function resetForm() {
		document.userModifyForm.reset();
	}
-->
</script>

<h2><bean:message key="user.create.title"/><html:link action="/userSearch?action=show"><html:img src="/eMagine/common/images/icones/retour.png" titleKey="button.title.return" /></html:link></h2>
<div class="form">
	<br/>


<html:form action="/userCreate" method="POST" focus="lastName">

	<p><label for="lastName"><bean:message key="form.name"/><font color="red">*</font> </label><html:text property="lastName" size="20" /></p>
	<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font> </label><html:text property="firstName" size="20" /></p>
	<p><label for="email"><bean:message key="form.email"/><font color="red">*</font> </label><html:text property="email" size="20" /></p>
	<p><label for="login"><bean:message key="form.identifiant"/><font color="red">*</font> </label><html:text property="login" size="20" /></p>
	<p><label for="password"><bean:message key="form.password"/></label><html:password property="password" size="20" /></p>
	<p><label for="repassword"><bean:message key="form.confirmPassword"/></label><html:password property="repassword" size="20" /></p>
	<p>
		<label for="profil"><bean:message key="form.profil"/></label>
		<html:select property="idProfile">
			<html:optionsCollection property="profiles" value="id" label="name"/>		
		</html:select>
	</p>
</div>

<br/>
<html:errors />

<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:createUser();"><html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.ok" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>

<html:hidden property="action" />
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>