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
	
	function affectCompany() {
		document.apprenticeModifyForm.action = "/eMagine/apprenticeCompanyAdd.do";
		document.apprenticeModifyForm.submit();
	}
	
	function affectTeacherTutor() {
		document.apprenticeModifyForm.action = "/eMagine/apprenticeTutorAdd.do";
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
<html:form action="/apprenticeModify" method="POST" focus="courseOptions">
	<div class="tabs">
		<ul>
			<span class="tab_clicked"><li><html:link href="javascript:change('apprenticeVisuSituation');"><bean:message key="onglet.situation"/></html:link></li></span>
			<li><html:link href="javascript:change('apprenticeVisuAdress');"><bean:message key="onglet.adress"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuStatus');"><bean:message key="onglet.status"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuSchooling');"><bean:message key="onglet.schooling"/></html:link></li>
			<li><html:link action="/eventSearch.do?action=show&from=apprentice"><bean:message key="onglet.event"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuAbsence');"><bean:message key="onglet.absence"/></html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
<!-- Un formulaire de modification -->
<div class="form">
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.promotion"/></legend>
		<p>
			<label for="courseOptions"><bean:message key="form.die"/><font color="red">*</font></label>
			<html:select property="idCourseOption">
				<logic:notEmpty name="apprenticeModifyForm" property="courseOptions">
					<option value="" selected></option>
					<html:optionsCollection property="courseOptions" value="id" label="name"/>
				</logic:notEmpty>
			</html:select>
		</p>
		<p><label for="year"><bean:message key="form.year"/><font color="red">*</font></label>
			<html:select property="idYear">
				<logic:notEmpty name="apprenticeModifyForm" property="years">
					<option value="" selected></option>
					<html:optionsCollection property="years" value="id" label="name"/>
				</logic:notEmpty>
			</html:select>
		</p>
		<p><label for="group"><bean:message key="form.group"/><font color="red">*</font></label>
			<html:select property="idGroup">
				<logic:notEmpty name="apprenticeModifyForm" property="groups">
					<option value="" selected></option>
					<html:optionsCollection property="groups" value="id" label="name"/>
				</logic:notEmpty>
			</html:select>
		</p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.company"/></legend>
		<p>
		<label for="firmName"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label>
			<html:select property="idFirm">
				<logic:notEmpty name="apprenticeModifyForm" property="firms">
					<option value="" selected></option>
					<html:optionsCollection property="firms" value="id" label="name"/>
				</logic:notEmpty>
			</html:select>
		</p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.tutelage"/></legend>
		<p><label for="engineTutor"><bean:message key="form.company.tutor"/><font color="red">*</font></label>
			<html:select property="idEngineerTutor">
				<logic:notEmpty name="apprenticeModifyForm" property="engineerTutors">
					<option value="" selected></option>
					<html:optionsCollection property="engineerTutors" value="id" label="fullName"/>
				</logic:notEmpty>
			</html:select>
		</p> 
		<p><label for="teacherTutor"><bean:message key="form.teacher.tutor"/><font color="red">*</font>&nbsp;</label>
			<html:select property="idTeacherTutor">
				<logic:notEmpty name="apprenticeModifyForm" property="teacherTutors">
					<option value="" selected></option>
					<html:optionsCollection property="teacherTutors" value="id" label="fullName"/>
				</logic:notEmpty>
			</html:select>
			<!--<div class="buttons">
				<html:submit onclick="javascript:setAction('affectTeacherTutor');" titleKey="button.title.affect"><bean:message key="form.affect"/></html:submit>
			</div>-->
		</p>
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
		<li><html:link href="javascript:moveUpApprentice();"><html:img src="/eMagine/common/images/icones/passage.png" titleKey="button.title.passage" /></html:link></li>
		<li><html:link href="javascript:excludeApprentice();"><html:img src="/eMagine/common/images/icones/virer.png" titleKey="button.title.exclude" /></html:link></li>
	</ul>
</div>
