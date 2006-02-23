<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.companyModifyForm.action.value = value;
	}

	function createCompany() {
		setAction('create');
		document.companyModifyForm.submit();
	}

	function resetForm() {
		document.companyModifyForm.reset();
	}

	function firmPopUp() {
		height = 300;
		width = 270;
		top = Math.round((screen.availHeight-height)/2);
		left = screen.availWidth;
		window.open("/eMagine/companyList.do", "firm", "width=" + width + ",height=" + height + ",top=" + top + ",left=" + left + ",menubar=no,status=no,scrollbars=yes,dependent=yes")
	}

	function setFirm(id,name) {
		document.companyModifyForm.idParentFirm.value = id;
		document.companyModifyForm.nameParentFirm.value = name;
	}

-->
</script>

<h2><bean:message key="company.create.title"/></h2>
<html:form action="/companyCreate" method="POST">

<div class="form">
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.organisation"/></legend>
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label><html:text property="name" size="20" /></p>
			<p><label for="idParentFirm"><bean:message key="form.branch"/></label>
				<html:select property="idParentFirm">
					<option value="" ></option>
					<logic:notEmpty name="companyModifyForm" property="parentFirms">
						<html:optionsCollection property="parentFirms" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.coord"/></legend>
			<p><label for="adress"><bean:message key="form.adress"/><font color="red">*</font>&nbsp;</label><html:text property="address" size="20" /></p>
			<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font>&nbsp;</label><html:text property="postalCode" size="20" /></p>
			<p><label for="city"><bean:message key="form.city"/><font color="red">*</font>&nbsp;</label><html:text property="city" size="20" /></p>
			<p><label for="department"><bean:message key="form.department"/><font color="red">*</font>&nbsp;</label>
				<html:select property="idDepartment">
					<logic:notEmpty name="companyModifyForm" property="departments">
						<html:optionsCollection property="departments" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
				
			<p><label for="phone"><bean:message key="form.phone"/></label><html:text property="phone" size="20" /></p>	
			<p><label for="fax"><bean:message key="form.fax"/></label><html:text property="fax" size="20" /></p>
			<p><label for="website"><bean:message key="form.website"/><font color="red">*</font> </label><html:text property="web" size="20" /></p>	
	</fieldset>
	<br/>
</div>

<html:errors />

<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:createCompany();"><html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.ok" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>

	<html:hidden property="action" />	
</html:form>
