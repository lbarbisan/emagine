<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.userModifyForm.dispatch.value = value;
	}
	
	function deleteUser() {
		if(confirm("Souhaitez-vous réellement supprimer cet utilisateur ?")) {
			open("/eMagine/userDelete.do?action=deleteOne&from=modify&id=" + document.userModifyForm.elements['idUserToModify'].value, "_self");
		}
	}
	
	function modifyUser() {
		setAction('modify');
		document.userModifyForm.submit();
	}

	function resetForm() {
		document.userModifyForm.reset();
	}
-->
</script>


<h2><bean:message key="user.detail.title"/></h2>

<html:form action="/userModify" method="POST" focus="lastName">

<div class="form">
	<br/>
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

<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyUser();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteUser();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
	</ul>
</div>

<html:hidden property="idUserToModify" />
<html:hidden property="action" />
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>