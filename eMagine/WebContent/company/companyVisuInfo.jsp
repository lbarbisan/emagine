<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--

	function setAction(value) {
		document.companyModifyForm.action.value = value;
	}
	
	function deleteCompany() {
		if(confirm("Souhaitez-vous réellement supprimer cette entreprise ?")) {
			open("/eMagine/companyDelete.do?action=delete&from=modify&currentSelectedIds=" + document.companyModifyForm.elements['idFirmToModify'].value, "_self");
		}
	}
	
	function modifyCompany() {
		setAction('modify');
		document.companyModifyForm.submit();
	}

	function resetForm() {
		document.companyModifyForm.reset();
	}
	
	function change(action) {
		document.companyModifyForm.action = "/eMagine/" + action + ".do";
		document.companyModifyForm.submit();
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

<div class="tabs">
	<ul>
		<span class="tab_clicked"><li><html:link href="javascript:change('companyVisuInfo');">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li></span>
			<li><html:link href="javascript:change('companyVisuActor');">Acteur</html:link></li>
			<li><html:link href="javascript:change('companyVisuPost');">Poste</html:link></li>
			<li><html:link action="eventSearch.do?action=show&from=firm">Ev&eacute;nement</html:link></li>
	</ul>
</div>

<html:form action="companyModify" method="POST">

<div class="tabs_div">
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
			<p><label for="department"><bean:message key="form.department"/></label>
				<html:select property="idDepartment">
					<option value=""></option>
					<logic:notEmpty name="companyModifyForm" property="departments">
						<html:optionsCollection property="departments" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			<p><label for="phone"><bean:message key="form.phone"/></label><html:text property="phone" size="20" /></p>	
			<p><label for="fax"><bean:message key="form.fax"/></label><html:text property="fax" size="20" /></p>
			<p><label for="website"><bean:message key="form.website"/><font color="red">*</font> </label><html:text property="web" size="20" /></p>	
	</fieldset>
</div>
</div>

<html:errors />

<html:hidden property="idFirmToModify"/>
<html:hidden property="action"/>
</html:form>

<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyCompany();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteCompany();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
	</ul>
</div>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
