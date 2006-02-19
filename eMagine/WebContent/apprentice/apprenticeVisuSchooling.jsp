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
-->
</script>
<html:form action="/apprenticeModify" method="POST" focus="">
	<div class="tabs">
		<ul>
			<li><html:link href="javascript:change('apprenticeVisuSituation');"><bean:message key="onglet.situation"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuAdress');"><bean:message key="onglet.adress"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuStatus');"><bean:message key="onglet.status"/></html:link></li>
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
			<label for="levels"><bean:message key="form.level"/></label>
			<html:select property="idLevel">
				<logic:notEmpty name="apprenticeModifyForm" property="levels">
					<html:optionsCollection property="levels" value="id" label="name"/>	
				</logic:notEmpty>
			</html:select>
		</p>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.languages"/></legend>
			<p>
				<label for="language1"><bean:message key="form.language1"/></label> 
				<html:select property="idLanguage1">
					<logic:notEmpty name="apprenticeModifyForm" property="languages">
						<html:optionsCollection property="languages" value="id" label="name"/>	
					</logic:notEmpty>
				</html:select>
			</p>
			<p>
				<label for="language2"><bean:message key="form.language2"/></label>
				<html:select property="idLanguage2">
					<logic:notEmpty name="apprenticeModifyForm" property="languages">
						<html:optionsCollection property="languages" value="id" label="name"/> 	
					</logic:notEmpty>
				</html:select>
			</p>
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.marksExam"/></legend>
			<p><label for="firstMarkExam">Psychotest&nbsp;</label><html:text property="firstMarkExam" size="5" /></p>	
			<p><label for="secondMarkExam">Maths&nbsp;</label><html:text property="secondMarkExam" size="5" /></p>	
			<p><label for="thirdMarkExam">Logique&nbsp;</label><html:text property="thirdMarkExam" size="5" /></p>		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.obtainedDiplomas"/></legend>
			<p>
				<label for="year"><bean:message key="form.year"/></label>
				<html:select property="idYearDiploma1">
					<logic:notEmpty name="apprenticeModifyForm" property="obtentionYears">
						<html:optionsCollection property="obtentionYears" value="id" label="name"/>	
					</logic:notEmpty>
				</html:select>
			</p>
			<p>
				<label for="diploma"><bean:message key="form.lastDiploma"/></label>
				<html:select property="idDiploma1">
					<logic:notEmpty name="apprenticeModifyForm" property="diplomas">
						<html:optionsCollection property="diplomas" value="id" label="name"/>
					</logic:notEmpty>	
				</html:select>
			</p>
			<p>
				<label for="section"><bean:message key="form.section"/></label>
				<html:select property="idSection1">
					<logic:notEmpty name="apprenticeModifyForm" property="sections">
						<html:optionsCollection property="sections" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			<hr/>
			<p>
				<label for="year"><bean:message key="form.year"/></label>
				<html:select property="idYearDiploma2">
					<logic:notEmpty name="apprenticeModifyForm" property="obtentionYears">
						<html:optionsCollection property="obtentionYears" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			<p>
				<label for="diploma"><bean:message key="form.lastDiploma"/></label>
				<html:select property="idDiploma2">
					<logic:notEmpty name="apprenticeModifyForm" property="diplomas">
						<html:optionsCollection property="diplomas" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			<p>
				<label for="section"><bean:message key="form.section"/></label>
				<html:select property="idSection2">
					<logic:notEmpty name="apprenticeModifyForm" property="sections">
						<html:optionsCollection property="sections" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			<hr/>
			<p>
				<label for="year"><bean:message key="form.year"/></label>
				<html:select property="idYearDiploma3">
					<logic:notEmpty name="apprenticeModifyForm" property="obtentionYears">
						<html:optionsCollection property="obtentionYears" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			<p>
				<label for="diploma"><bean:message key="form.lastDiploma"/></label>
				<html:select property="idDiploma3">
					<logic:notEmpty name="apprenticeModifyForm" property="diplomas">
						<html:optionsCollection property="diplomas" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			<p>
				<label for="section"><bean:message key="form.section"/></label>
				<html:select property="idSection3">
					<logic:notEmpty name="apprenticeModifyForm" property="sections">
						<html:optionsCollection property="sections" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.scolarityPast"/></legend>
			<p><label for="scolarityYear2"><bean:message key="form.year"/></label>
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