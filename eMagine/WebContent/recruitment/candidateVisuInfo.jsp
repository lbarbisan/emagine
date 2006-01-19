<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.candidateModifyForm.action.value = value;
	}
	
	function deleteUser() {
		if(confirm("Souhaitez-vous réellement supprimer ce candidat ?")) {
			open("/eMagine/userDelete.do?action=delete&from=modify&currentSelectedIds=" + document.candidateModifyForm.elements['idCandidateToModify'].value, "_self");
		}
	}
	
	function modifyUser() {
		setAction('modify');
		document.candidateModifyForm.submit();
	}

	function resetForm() {
		document.candidateModifyForm.reset();
	}
-->
</script>

<div class="tabs">
<ul>
	<span class="tab_clicked"><li><html:link action="/candidateVisuInfo">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li></span>
	<li><html:link action="/candidateVisuEvent">Ev&eacute;nement</html:link></li>
</ul>
</div>
<div class="tabs_div">
<div class="form">
	<fieldset>
		<legend><bean:message key="form.fieldset.status"/></legend>
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
		<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
		<p><label for="sex"><bean:message key="radio.sex"/></label><input type="radio" name="sex" value="male"><bean:message key="radio.sex.female"/><input type="radio" name="sex" value="female" checked><bean:message key="radio.sex.male"/></p>
		<p><label for="date"><bean:message key="form.date"/><font color="red">*</font> </label><input type="text" id="date" size="20" />&nbsp;<a href="#"><img src="/eMagine/common/images/icones/calendar.png" title="<bean:message key="button.title.calendar"/>"/></a></p>
		<p><label for="city"><bean:message key="form.city"/></label><input type="text" id="city" size="20" /></p>
		<p><label for="department"><bean:message key="form.department"/></label><input type="text" id="department" size="20" /></p>
		<p><label for="country"><bean:message key="form.country"/></label><input type="text" id="country" size="20" /></p>
		<p><label for="nationality"><bean:message key="form.nationality"/><font color="red">*</font> </label><input type="text" id="nationality" size="20" /></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.adress"/></legend>
			<p><label for="persAdress"><bean:message key="form.adress"/><font color="red">*</font> </label><input type="text" id="persAdress" size="20" /></p>
			<p><label for="persPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><input type="text" id="persPostalCode" size="20" /></p>
			<p><label for="persCity"><bean:message key="form.city"/><font color="red">*</font> </label><input type="text" id="persCity" size="20" /></p>
			<p><label for="persDepartment"><bean:message key="form.department"/><font color="red">*</font> </label><select name="persDepartment">
					<!-- à mettre en base -->
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select> </p>
			<p><label for="persPhone"><bean:message key="form.phone"/></label><input type="text" id="persPhone" size="20" /></p>	
			<p><label for="persMobile"><bean:message key="form.mobile"/></label><input type="text" id="persMobile" size="20" /></p>
			<p><label for="persFax"><bean:message key="form.fax"/></label><input type="text" id="persFax" size="20" /></p>
			<p><label for="persEmail"><bean:message key="form.email"/><font color="red">*</font> </label><input type="text" id="persEmail" size="20" /></p>	
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.studies"/></legend>
		<p><label for="die"><bean:message key="form.dieAsked"/></label>
			<select name="die">
				<!-- à mettre en base -->
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select>
		</p>
		<p><label for="level"><bean:message key="form.level"/></label>
			<input type="radio" name="level" checked/>bac 
			<input type="radio" name="level" />+2
			<input type="radio" name="level" />+3
		</p>
		<p><label for="diploma"><bean:message key="form.lastDiploma"/></label>
			<select name="diploma">
				<!-- à mettre en base -->
				<option value="bac">bac</option>
				<option selected value="dut">dut</option>
				<option value="licence">licence</option>
				<option value="maîtrise">maîtrise</option>
			</select>
		</p>
		<!-- change selon le denier diplome -->
		<p><label for="section"><bean:message key="form.section"/></label>
			<select name="section">
				<!-- à mettre en base -->
				<option value="I">Informatique</option>
				<option value="GEII">Génie Electrique</option>
			</select>
		</p>
		<p><label for="center"><bean:message key="form.center"/></label>
			<select name="center">
				<!-- à mettre en base -->
				<option value="Paris">Paris</option>
				<option value="Toulouse">Toulouse</option>
				<option value="Bordeaux">Bordeaux</option>
			</select></p>
		<p><label for="formation"><bean:message key="form.otherFormation"/></label><input type="checkbox" value="ON" /></p>
		<p><label for="admissibility"><bean:message key="form.acceptable"/></label><input type="checkbox" value="ON" /></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.originContact"/></legend>
		<p><label for="contact"><bean:message key="form.contact"/></label>
			<select name="contact">
				<!-- à mettre en base -->
				<option value="jpo">JPO</option>
				<option value="internet">Internet</option>
				<option value="other">Autres</option>
			</select></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.parentsProfession"/></legend>
		<p><label for="father"><bean:message key="form.father"/></label><input type="text" id="father" size="20" /></p>
		<p><label for="mother"><bean:message key="form.mother"/></label><input type="text" id="mother" size="20" /></p>
	</fieldset>
	<br/>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
</div>