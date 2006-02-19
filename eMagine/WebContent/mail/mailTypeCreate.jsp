<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.mailingTypeModifyForm.action.value = value;
	}

	function createMailingType() {
		setAction('create');
		document.mailingTypeModifyForm.submit();
	}

	function resetForm() {
		document.mailingTypeModifyForm.reset();
	}
-->
</script>

<h2><bean:message key="mailType.create.title"/></h2>
<div class="form">
	<br/>

<html:form action="/mailingTypeCreate" focus="title" method="post" enctype="multipart/form-data">
	<p><label for="title"><bean:message key="form.name"/><font color="red">*</font> </label><html:text property="title" size="20" /></p>
	<p><label for="comment"><bean:message key="form.description"/></label><html:textarea property="comment" /></p>
	<p><label for="attachment"><bean:message key="form.file"/></label><html:file property="attachment" size="20" /></p>
</div>

<br/>
<html:errors />

<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:createMailingType();"><html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.ok" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>

<html:hidden property="action" />
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
	