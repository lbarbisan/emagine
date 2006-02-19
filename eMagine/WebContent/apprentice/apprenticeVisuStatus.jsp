<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout"%>
<script src="/eMagine/common/js/strutsLayout.js"></script>
<script>
	imgsrc="/eMagine/common/images/icones/";
</script>
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
-->
</script>
<html:form action="/apprenticeModify" method="POST" focus="lastName">
	<div class="tabs">
		<ul>
			<li><html:link href="javascript:change('apprenticeVisuAdress');"><bean:message key="onglet.adress"/></html:link></li>
			<span class="tab_clicked"><li><html:link href="javascript:change('apprenticeVisuStatus');"><bean:message key="onglet.status"/></html:link></li></span>
			<li><html:link href="javascript:change('apprenticeVisuSituation');"><bean:message key="onglet.situation"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuSchooling');"><bean:message key="onglet.schooling"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuEvent');"><bean:message key="onglet.event"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuAbsence');"><bean:message key="onglet.absence"/></html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
		<div class="form">
			<fieldset>
				<legend><bean:message key="form.fieldset.identification"/></legend>
				<p><label for="lastName"><bean:message key="form.name"/><font color="red">*</font></label><html:text property="lastName" size="20" /></p>
				<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font></label><html:text property="firstName" size="20" /></p>
				<p><label for="sex"><bean:message key="radio.sex"/></label>
					<logic:notEmpty name="apprenticeModifyForm" property="sexes">
						<logic:iterate id="sex" name="apprenticeModifyForm" property="sexes" type="fr.umlv.ir3.emagine.apprentice.SexEnum">
							<html:radio property="idSex" value="id" idName="sex"/> 
		 						<bean:write name="sex" property="name"/>
						</logic:iterate>	   	
					</logic:notEmpty>
				</p>
			</fieldset>
			<br/>
			<fieldset>
				<legend><bean:message key="form.fieldset.birth"/></legend>
				<p><layout:date key="form.birth" styleClass="form_calendar" property="birth" startYear="1980" endYear="2030"/></p>
				<p><label for="city"><bean:message key="form.city"/></label><html:text property="city" size="20" /></p> -->
				<p>
					<label for="department"><bean:message key="form.department"/></label>
					<html:select property="idDepartmentBirth">
						<logic:notEmpty name="apprenticeModifyForm" property="departments">
							<html:optionsCollection property="departments" value="id" label="name"/>
						</logic:notEmpty>		
					</html:select>
				</p>
				<p>
					<label for="country"><bean:message key="form.country"/></label>
					<html:select property="idCountry">
						<logic:notEmpty name="apprenticeModifyForm" property="countries">
							<html:optionsCollection property="countries" value="id" label="name"/>
						</logic:notEmpty>
					</html:select>
				</p>
				<p>
					<label for="nationality"><bean:message key="form.nationality"/></label>
					<html:select property="idNationality">
						<logic:notEmpty name="apprenticeModifyForm" property="nationalities">
							<html:optionsCollection property="nationalities" value="id" label="name"/>
						</logic:notEmpty>	
					</html:select>
				</p>
			</fieldset>
			<br/>
			<fieldset>
				<legend><bean:message key="form.fieldset.parentsProfession"/></legend>
				<p>
			<label for="father"><bean:message key="form.father"/></label>
			<html:select property="idFather">
				<logic:notEmpty name="apprenticeModifyForm" property="professions">
					<html:optionsCollection property="professions" value="id" label="name"/>
				</logic:notEmpty>
			</html:select>
		</p>
		<p>
			<label for="mother"><bean:message key="form.mother"/></label>
			<html:select property="idMother">
				<logic:notEmpty name="apprenticeModifyForm" property="professions">
					<html:optionsCollection property="professions" value="id" label="name"/>
				</logic:notEmpty>
			</html:select>
		</p>
			</fieldset>
			<br/>
			<fieldset>
				<legend><bean:message key="form.fieldset.originContact"/></legend>
				<p><label for="contact"><bean:message key="form.contact"/></label>
					<html:select property="idContact">
						<logic:notEmpty name="apprenticeModifyForm" property="contacts">
							<html:optionsCollection property="contacts" value="id" label="name"/>
						</logic:notEmpty>	
					</html:select>
				</p>
			</fieldset>
			<br/>
		</div>
<html:errors />
<html:hidden property="idApprenticeToModify" />
<html:hidden property="action" />
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyApprentice();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>
</html:form>