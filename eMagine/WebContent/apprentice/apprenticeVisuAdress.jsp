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
-->
</script>
	<div class="tabs">
		<ul>
			<span class="tab_clicked"><li><bean:message key="onglet.adress"/></li></span>
			<li><html:link action="/apprenticeVisuStatus"><bean:message key="onglet.status"/></html:link></li>
			<li><html:link action="/apprenticeVisuSituation"><bean:message key="onglet.situation"/></html:link></li>
			<li><html:link action="/apprenticeVisuSchooling"><bean:message key="onglet.schooling"/></html:link></li>
			<li><html:link action="/apprenticeVisuEvent"><bean:message key="onglet.event"/></html:link></li>
			<li><html:link action="/apprenticeVisuAbsence"><bean:message key="onglet.absence"/></html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
		<div class="form">
		<html:form action="/apprenticeModify" method="POST" focus="defaultAddresses">
			<br/>
			<html:errors />
			<fieldset>
				<legend><bean:message key="radio.adress.current"/></legend>
				<p><label for="defaultAddress"><bean:message key="radio.adress.current"/></label>
					<logic:notEmpty name="apprenticeModifyForm" property="defaultAddresses">
						<logic:iterate id="defaultAddress" name="apprenticeModifyForm" property="defaultAddresses" type="fr.umlv.ir3.emagine.apprentice.DefaultAddressEnum">
							<html:radio property="idDefaultAdress" value="id" idName="defaultAddress"/> 
		 						<bean:write name="defaultAddress" property="name"/>
						</logic:iterate>
					</logic:notEmpty>
				</p>
				<!-- <p>
					<label for="current" style="bold"><bean:message key="radio.adress.current"/></label>
					<input type="radio" name="current" value="personnal"><bean:message key="radio.adress.personal"/>	
					<input type="radio" name="current" value="professional"><bean:message key="radio.adress.professional"/>
					<input type="radio" name="current" value="academic" checked><bean:message key="radio.adress.academic"/>	
				</p> -->
				<br/>
			</fieldset>
			<fieldset>
				<legend><bean:message key="form.fieldset.adress.personal"/></legend>
					<!-- <p><label for="persAdress"><bean:message key="form.adress"/><font color="red">*</font>&nbsp;</label><input type="text" id="persAdress" size="20" /></p>
					<p><label for="persPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font>&nbsp;</label><input type="text" id="persPostalCode" size="20" /></p>
					<p><label for="persCity"><bean:message key="form.city"/><font color="red">*</font>&nbsp;</label><input type="text" id="persCity" size="20" /></p>
					<p><label for="persDepartment"><bean:message key="form.department"/></label>
						<select name="persDepartment">
							<option value="93">93</option>
							<option value="77">77</option>
							<option value="78">78</option>
						</select>
					</p>
					<p><label for="persPhone"><bean:message key="form.phone"/></label><input type="text" id="persPhone" size="20" /></p>	
					<p><label for="persMobile"><bean:message key="form.mobile"/></label><input type="text" id="persMobile" size="20" /></p>
					<p><label for="persFax"><bean:message key="form.fax"/></label><input type="text" id="persFax" size="20" /></p>
					<p><label for="persEmail"><bean:message key="form.email"/><font color="red">*</font>&nbsp;</label><input type="text" id="persEmail" size="20" /></p>	 -->
			
				<p><label for="persAdress"><bean:message key="form.adress"/><font color="red">*</font></label><html:text property="persAdress" size="20" /></p>
				<p><label for="persPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font></label><html:text property="persPostalCode" size="20" /></p>
				<p><label for="persCity"><bean:message key="form.city"/><font color="red">*</font></label><html:text property="persCity" size="20" /></p>
				<p>
					<label for="persDepartments"><bean:message key="form.department"/></label>
					<html:select property="idPersDepartment">
						<logic:notEmpty name="apprenticeModifyForm" property="departments">
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
				<legend><bean:message key="form.fieldset.adress.professional"/></legend>
				
				<!-- <p><label for="profAdress"><bean:message key="form.adress"/><font color="red">*</font>&nbsp;</label><input type="text" id="profAdress" size="20" /></p>
				<p><label for="profPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font>&nbsp;</label><input type="text" id="profPostalCode" size="20" /></p>
				<p><label for="profCity"><bean:message key="form.city"/><font color="red">*</font>&nbsp;</label><input type="text" id="profCity" size="20" /></p>
				<p><label for="profDepartment"><bean:message key="form.department"/></label>
						<select name="profDepartment">
							<option value="93">93</option>
							<option value="77">77</option>
							<option value="78">78</option>
						</select></p>
				<p><label for="profPhone"><bean:message key="form.phone"/></label><input type="text" id="profPhone" size="20" /></p>
				<p><label for="profMobile"><bean:message key="form.mobile"/></label><input type="text" id="profMobile" size="20" /></p>
				<p><label for="profFax"><bean:message key="form.fax"/></label><input type="text" id="profFax" size="20" /></p>
				<p><label for="profEmail"><bean:message key="form.email"/><font color="red">*</font>&nbsp;</label><input type="text" id="profEmail" size="20" /></p>-->
			<p><label for="profAdress"><bean:message key="form.adress"/><font color="red">*</font></label><html:text property="profAdress" size="20" /></p>
			<p><label for="profPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font></label><html:text property="profPostalCode" size="20" /></p>
			<p><label for="profCity"><bean:message key="form.city"/><font color="red">*</font></label><html:text property="profCity" size="20" /></p>
			<p>
				<label for="profDepartments"><bean:message key="form.department"/></label>
				<html:select property="idProfDepartment">
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
				<legend><bean:message key="form.fieldset.adress.academic"/></legend>
				<!-- <p><label for="acaAdress"><bean:message key="form.adress"/><font color="red">*</font> </label><input type="text" id="acaAdress" size="20" /></p>
				<p><label for="acaPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><input type="text" id="acaPostalCode" size="20" /></p>
				<p><label for="acaCity"><bean:message key="form.city"/><font color="red">*</font>&nbsp;</label><input type="text" id="acaCity" size="20" /></p>
				<p><label for="acaDepartment"><bean:message key="form.department"/></label>
					<select name="acaDepartment">
						<option value="93">93</option>
						<option value="77">77</option>
						<option value="78">78</option>
					</select></p>
				<p><label for="acaPhone"><bean:message key="form.phone"/></label><input type="text" id="acaPhone" size="20" /></p>
				<p><label for="acaMobile"><bean:message key="form.mobile"/></label><input type="text" id="acaMobile" size="20" /></p>
				<p><label for="acaFax"><bean:message key="form.fax"/></label><input type="text" id="acaFax" size="20" /></p>
				<p><label for="acaEmail"><bean:message key="form.email"/><font color="red">*</font>&nbsp;</label><input type="text" id="acaEmail" size="20" /></p>-->
			<p><label for="acaAdress"><bean:message key="form.adress"/><font color="red">*</font></label><html:text property="acaAdress" size="20" /></p>
			<p><label for="acaPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font></label><html:text property="acaPostalCode" size="20" /></p>
			<p><label for="acaCity"><bean:message key="form.city"/><font color="red">*</font></label><html:text property="acaCity" size="20" /></p>
			<p>
				<label for="acaDepartments"><bean:message key="form.department"/></label>
				<html:select property="idAcaDepartment">
					<logic:notEmpty name="apprenticeModifyForm" property="departments">
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
</html:form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyApprentice();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>