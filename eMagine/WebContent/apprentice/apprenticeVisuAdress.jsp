<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.apprenticeModifyForm.action.value = value;
	}
	
	function modifyApprentice() {
		setAction('modify');
		document.apprenticeModifyForm.submit();
	}

	function resetForm() {
		document.apprenticeModifyForm.reset();
	}
	
	function change(action) {
		document.apprenticeModifyForm.action = "/eMagine/" + action + ".do";
		document.apprenticeModifyForm.submit();
	}
	
	function excludeApprentice() {
		if(confirm("Souhaitez-vous réellement exclure cet apprenti ?")) {
			open("/eMagine/apprenticeExclude.do?action=execute&from=modify&currentSelectedIds=" + document.apprenticeModifyForm.elements['idApprenticeToModify'].value, "_self");
		}
	}
	
	function moveUpApprentice() {
		if(confirm("Souhaitez-vous réellement faire passer cet apprenti en année supérieure ?")) {
			open("/eMagine/apprenticeMoveUp.do?action=execute&from=modify&currentSelectedIds=" + document.apprenticeModifyForm.elements['idApprenticeToModify'].value, "_self");
		}
	}
-->
</script>
	<div class="tabs">
		<ul>
			<li><html:link href="javascript:change('apprenticeVisuSituation');"><bean:message key="onglet.situation"/></html:link></li>
			<span class="tab_clicked"><li><html:link href="javascript:change('apprenticeVisuAdress');"><bean:message key="onglet.adress"/></html:link></li></span>
			<li><html:link href="javascript:change('apprenticeVisuStatus');"><bean:message key="onglet.status"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuSchooling');"><bean:message key="onglet.schooling"/></html:link></li>
			<li><html:link action="/eventSearch.do?action=show&from=apprentice"><bean:message key="onglet.event"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuAbsence');"><bean:message key="onglet.absence"/></html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
		<div class="form">
		<html:form action="/apprenticeModify" method="POST" focus="defaultAddresses">
			<br/>
			<html:errors />
			<fieldset>
				<legend><bean:message key="form.fieldset.address.current"/></legend>
				<p><label for="defaultAddress"><bean:message key="radio.address.type"/></label>
					<logic:notEmpty name="apprenticeModifyForm" property="defaultAddresses">
						<logic:iterate id="defaultAddress" name="apprenticeModifyForm" property="defaultAddresses" type="fr.umlv.ir3.emagine.apprentice.DefaultAddressEnum">
							<html:radio property="idDefaultAddress" value="id" idName="defaultAddress"/> 
		 						<bean:write name="defaultAddress" property="name"/>
						</logic:iterate>
					</logic:notEmpty>
				</p>
				<br/>
			</fieldset>
			<fieldset>
				<legend><bean:message key="form.fieldset.address.personal"/></legend>			
				<p><label for="persAdress"><bean:message key="form.adress"/><font color="red">*</font></label><html:text property="persAddress" size="20" /></p>
				<p><label for="persPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font></label><html:text property="persPostalCode" size="20" /></p>
				<p><label for="persCity"><bean:message key="form.city"/><font color="red">*</font></label><html:text property="persCity" size="20" /></p>
				<p>
					<label for="persDepartments"><bean:message key="form.department"/><font color="red">*</font></label>
					<html:select property="idPersDepartment">
						<logic:notEmpty name="apprenticeModifyForm" property="departments">
							<option value="" selected></option>
							<html:optionsCollection property="departments" value="id" label="name"/>		
						</logic:notEmpty>
					</html:select>
				</p>
				<p><label for="persPhone"><bean:message key="form.phone"/></label><html:text property="persPhone" size="20" /></p>	
				<p><label for="persMobile"><bean:message key="form.mobile"/></label><html:text property="persMobile" size="20" /></p>
				<p><label for="persFax"><bean:message key="form.fax"/></label><html:text property="persFax" size="20" /></p>
				<p><label for="persEmail"><bean:message key="form.email"/><font color="red">*</font></label><html:text property="persEmail" size="20" /></p>			
			</fieldset>
			<br/>
			<fieldset>
				<legend><bean:message key="form.fieldset.address.professional"/></legend>
				<p><label for="profAdress"><bean:message key="form.adress"/><font color="red">*</font></label><html:text property="profAddress" size="20" /></p>
				<p><label for="profPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font></label><html:text property="profPostalCode" size="20" /></p>
				<p><label for="profCity"><bean:message key="form.city"/><font color="red">*</font></label><html:text property="profCity" size="20" /></p>
				<p>
					<label for="profDepartments"><bean:message key="form.department"/><font color="red">*</font></label>
					<html:select property="idProfDepartment">
						<option value="" selected></option>
						<logic:notEmpty name="apprenticeModifyForm" property="departments">
							<html:optionsCollection property="departments" value="id" label="name"/>		
						</logic:notEmpty>
					</html:select>
				</p>
				<p><label for="profPhone"><bean:message key="form.phone"/></label><html:text property="profPhone" size="20" /></p>	
				<p><label for="profMobile"><bean:message key="form.mobile"/></label><html:text property="profMobile" size="20" /></p>
				<p><label for="profFax"><bean:message key="form.fax"/></label><html:text property="profFax" size="20" /></p>
				<p><label for="profEmail"><bean:message key="form.email"/><font color="red">*</font></label><html:text property="profEmail" size="20" /></p>		
			</fieldset>
			<br/>
			<fieldset>
				<legend><bean:message key="form.fieldset.address.academic"/></legend>
				<p><label for="acaAdress"><bean:message key="form.adress"/><font color="red">*</font></label><html:text property="acaAddress" size="20" /></p>
				<p><label for="acaPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font></label><html:text property="acaPostalCode" size="20" /></p>
				<p><label for="acaCity"><bean:message key="form.city"/><font color="red">*</font></label><html:text property="acaCity" size="20" /></p>
				<p>
					<label for="acaDepartments"><bean:message key="form.department"/><font color="red">*</font></label>
					<html:select property="idAcaDepartment">
						<logic:notEmpty name="apprenticeModifyForm" property="departments">
							<option value="" selected></option>
							<html:optionsCollection property="departments" value="id" label="name"/>		
						</logic:notEmpty>
					</html:select>
				</p>
				<p><label for="acaPhone"><bean:message key="form.phone"/></label><html:text property="acaPhone" size="20" /></p>	
				<p><label for="acaMobile"><bean:message key="form.mobile"/></label><html:text property="acaMobile" size="20" /></p>
				<p><label for="acaFax"><bean:message key="form.fax"/></label><html:text property="acaFax" size="20" /></p>
				<p><label for="acaEmail"><bean:message key="form.email"/><font color="red">*</font></label><html:text property="acaEmail" size="20" /></p>
			</fieldset>
				<br/>
		</div>
<html:errors />
<html:hidden property="idApprenticeToModify" />
<html:hidden property="action" />
<html:hidden property="tab" />
</html:form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyApprentice();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:moveUpApprentice();"><html:img src="/eMagine/common/images/icones/passage.png" titleKey="button.title.passage" /></html:link></li>
		<li><html:link href="javascript:excludeApprentice();"><html:img src="/eMagine/common/images/icones/virer.png" titleKey="button.title.exclude" /></html:link></li>
	</ul>
</div>