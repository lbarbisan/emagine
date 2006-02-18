<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
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

<form name="results">
	<div class="tabs">
		<ul>
			<li><html:link href="javascript:change('apprenticeVisuAdress');"><bean:message key="onglet.adress"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuStatus');"><bean:message key="onglet.status"/></html:link></li>
			<span class="tab_clicked"><li><html:link href="javascript:change('apprenticeVisuSituation');"><bean:message key="onglet.situation"/></html:link></li></span>
			<li><html:link href="javascript:change('apprenticeVisuSchooling');"><bean:message key="onglet.schooling"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuEvent');"><bean:message key="onglet.event"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuAbsence');"><bean:message key="onglet.absence"/></html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
<!-- Un formulaire de modification -->
<div class="form">
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.promotion"/></legend>
		<p><label for="die"><bean:message key="form.die"/></label>
			<select name="die">
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select></p>
		<p><label for="year"><bean:message key="form.year"/></label>
			<select name="year">
				<!-- mettre en base, pas de valeur par d�faut, elle sera s�lectionn�e selon l'apprenti concern� -->
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select></p>
		<p><label for="group"><bean:message key="form.group"/></label>
			<select name="group">
				<!-- mettre en base, pas de valeur par d�faut, elle sera s�lectionn�e selon l'apprenti concern� -->
				<option value="1"><bean:message key="form.group1"/></option>
				<option value="2"><bean:message key="form.group2"/></option>
			</select></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.company"/></legend>
		<p><label for="companyName"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label><input type="text" id="companyName" size="20" />
			<html:link action="/apprenticeCompanyAdd"><span class="buttons"><input type="button" value="<bean:message key="button.title.affect"/>" /></span></html:link></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.tutelage"/></legend>
		<p><label for="engineTutor"><bean:message key="form.company.tutor"/><font color="red">*</font> </label>
			<select name="engineTutor">
				<!--donn�es de la mettre en base selon l'entreprise concern�e -->
				<option value="1">Mr&nbsp;tuteur&nbsp;1</option>
				<option value="2">Mr&nbsp;tuteur&nbsp;2</option>
			</select></p>
		<p><label for="teacherTutor"><bean:message key="form.teacher.tutor"/><font color="red">*</font>&nbsp;</label><input type="text" id="teacherTutor" size="20" />
		<html:link action="/apprenticeTutorAdd"><span class="buttons"><input type="button" value="<bean:message key="button.title.affect"/>" /></span></html:link></p>
	</fieldset> 
<br/>           
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyApprentice();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>