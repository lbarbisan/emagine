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
		document.companyModifyForm.action = "/eMagine/" + action + ".do";
		document.companyModifyForm.submit();
	}
-->
</script>
<html:form action="/apprenticeModify" method="POST" focus="">
	<div class="tabs">
		<ul>
			<li><html:link href="javascript:change('apprenticeVisuAdress');"><bean:message key="onglet.adress"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuStatus');"><bean:message key="onglet.status"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuSituation');"><bean:message key="onglet.situation"/></html:link></li>
			<span class="tab_clicked"><li><html:link href="javascript:change('apprenticeVisuSchooling');"><bean:message key="onglet.schooling"/></html:link></li></span>
			<li><html:link href="javascript:change('apprenticeVisuEvent');"><bean:message key="onglet.event"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuAbsence');"><bean:message key="onglet.absence"/></html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
<!-- Un formulaire de modification -->
<div class="form">
		<br/>
		<html:errors />
		<p>
			<!--<label for="levels"><bean:message key="form.level"/></label>
			<html:select property="idLevel">
				<html:optionsCollection property="levels" value="id" label="name"/>		
			</html:select>-->
		</p>
		<!-- <p><label for="level"><bean:message key="form.level"/></label>
			<input type="radio" name="level" checked/>bac 
			<input type="radio" name="level" />+2
			<input type="radio" name="level" />+3
		</p> -->
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.marksExam"/></legend>
				<p><label for="language1"><bean:message key="form.language1"/></label><input type="text" id="language1" size="20" /> </p>
				<p><label for="language2"><bean:message key="form.language2"/></label><input type="text" id="language2" size="20" /> </p>
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.marksExam"/></legend>
				<p><label for="psy">Psychotest&nbsp;</label><input type="text" id="psy" size="20" /></p>
				<p><label for="maths">Maths&nbsp;</label><input type="text" id="maths" size="20" /></p>	
				<p><label for="logic">Logique&nbsp;</label><input type="text" id="logic" size="20" /></p>
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.obtainedDiplomas"/></legend>
				<p><label for="diplomaYear1"><bean:message key="form.year"/></label>
					<select name="diplomaYear1">
						<option value="" selected="selected">-- Ann&eacute;e --</option>	
					</select></p>
				<p><label for="diploma1"><bean:message key="form.diploma"/></label>
					<select name="diploma1">
						<option value="" selected="selected">-- Diplome --</option>	
					</select></p>
				<p><label for="spec1"><bean:message key="form.speciality"/></label>
					<select name="spec1">
						<option value="" selected="selected">-- Sp&eacute;cialit&eacute; --</option>	
					</select></p>
				<p><label for="option1"><bean:message key="form.option"/></label>
					<select name="option1">
							<option value="" selected="selected">-- Option --</option>	
						</select></p>
				<h2>&nbsp;</h2>
				<p><label for="diplomaYear2"><bean:message key="form.year"/></label>
					<select name="diplomaYear2">
						<option value="" selected="selected">-- Ann&eacute;e --</option>	
					</select></p>
				<p><label for="diploma2"><bean:message key="form.diploma"/></label>
					<select name="diploma2">
						<option value="" selected="selected">-- Diplome --</option>	
					</select></p>
				<p><label for="spec2"><bean:message key="form.speciality"/></label>
					<select name="spec2">
						<option value="" selected="selected">-- Sp&eacute;cialit&eacute; --</option>	
					</select></p>
				<p><label for="option2"><bean:message key="form.option"/></label>
					<select name="option2">
						<option value="" selected="selected">-- Option --</option>	
					</select></p>
				<h2>&nbsp;</h2>
				<p><label for="diplomaYear3"><bean:message key="form.year"/></label>
					<select name="diplomaYear3">
						<option value="" selected="selected">-- Ann&eacute;e --</option>	
					</select></p>
				<p><label for="diploma3"><bean:message key="form.diploma"/></label>
					<select name="diploma3">
						<option value="" selected="selected">-- Diplome --</option>	
					</select></p>
				<p><label for="spec3"><bean:message key="form.speciality"/></label>
					<select name="spec3">
						<option value="" selected="selected">-- Sp&eacute;cialit&eacute; --</option>	
					</select></p>
				<p><label for="option3"><bean:message key="form.option"/></label>
					<select name="option3">
						<option value="" selected="selected">-- Option --</option>	
					</select>
				</p>
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.scolarityPast"/></legend>
			<p><label for="scolarityYear1"><bean:message key="form.year"/></label>
				<select name="scolarityYear1">
					<option value="" selected="selected">-- Ann&eacute;e --</option>	
				</select></p>
			<p><label for="class1"><bean:message key="form.class"/></label>
				<select name="class1">
					<option value="" selected="selected">-- Classe --</option>	
				</select></p>
			<p><label for="section1"><bean:message key="form.section"/></label>
				<select name="section1">
					<option value="" selected="selected">-- Section --</option>	
				</select></p>
			<p><label for="establishment1"><bean:message key="form.establishment"/></label><input type="text" id="establishment1" size="20" /></p>
			<p><label for="postalCode1"><bean:message key="form.postalCode"/></label><input type="text" id="postalCode1" size="20" /></p>
			<p><label for="city1"><bean:message key="form.city"/></label><input type="text" id="city1" size="20" /></p>
			<p><label for="department1"><bean:message key="form.department"/></label>
				<select name="department1">
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select></p>
			<h2>&nbsp;</h2>
			<p><label for="scolarityYear2"><bean:message key="form.year"/></label>
				<select name="scolarityYear2">
					<option value="" selected="selected">-- Ann&eacute;e --</option>	
				</select></p>
			<p><label for="class2"><bean:message key="form.class"/></label>
				<select name="class2">
					<option value="" selected="selected">-- Classe --</option>	
				</select></p>
			<p><label for="section2"><bean:message key="form.section"/></label>
				<select name="section2">
					<option value="" selected="selected">-- Section --</option>	
				</select></p>
			<p><label for="establishment2"><bean:message key="form.establishment"/></label><input type="text" id="establishment2" size="20" /></p>
			<p><label for="postalCode2"><bean:message key="form.postalCode"/></label><input type="text" id="postalCode2" size="20" /></p>
			<p><label for="city2"><bean:message key="form.city"/></label><input type="text" id="city2" size="20" /></p>
			<p><label for="department2"><bean:message key="form.department"/></label>
				<select name="department2">
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select></p>
			<h2>&nbsp;</h2>
			<p><label for="scolarityYear3"><bean:message key="form.year"/></label>
				<select name="scolarityYear3">
					<option value="" selected="selected">-- Ann&eacute;e --</option>	
				</select></p>
			<p><label for="class3"><bean:message key="form.class"/></label>
				<select name="class3">
					<option value="" selected="selected">-- Classe --</option>	
				</select></p>
			<p><label for="section3"><bean:message key="form.section"/></label>
				<select name="section3">
					<option value="" selected="selected">-- Section --</option>	
				</select></p>
			<p><label for="establishment3"><bean:message key="form.establishment"/></label><input type="text" id="establishment3" size="20" /></p>
			<p><label for="postalCode3"><bean:message key="form.postalCode"/></label><input type="text" id="postalCode3" size="20" /></p>
			<p><label for="city3"><bean:message key="form.city"/></label><input type="text" id="city3" size="20" /></p>
			<p><label for="department3"><bean:message key="form.department"/></label>
				<select name="department3">
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select></p>
		</fieldset>
		<br/>
	</div>
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