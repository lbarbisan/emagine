<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="bringingTogether.extract.title"/></h2>
<br/>
<div class="form">
	<p><label for="type"><bean:message key="form.type"/></label><input type="radio" name="type" value="csv" checked>csv<input type="radio" name="type" value="xls">xls</p>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fildset.status"/></legend>
			<h5><bean:message key="title.identification"/></h5>
			<h2>&nbsp;</h2>
				<p><label for="name"><bean:message key="form.name"/></label>
				<input type="checkbox" value="ON" name="name" /></p>
				<p><label for="firstName"><bean:message key="form.firstName"/></label>
				<input type="checkbox" value="ON" name="firstName" /></p>
				<p><label for="sex"><bean:message key="form.sex"/></label>
				<input type="checkbox" value="ON" name="sex" /></p>
			<h5><bean:message key="title.birth"/></h5>
			<h2>&nbsp;</h2>
				<p><label for="birthDate"><bean:message key="form.date"/></label>
				<input type="checkbox" value="ON" name="birthDate" /></p>
				<p><label for="birthCity"><bean:message key="form.city"/></label>
				<input type="checkbox" value="ON" name="birthCity" /></p>
				<p><label for="birthDpt"><bean:message key="form.department"/></label>
				<input type="checkbox" value="ON" name="birthDpt" /></p>
				<p><label for="birthCountry"><bean:message key="form.country"/></label>
				<input type="checkbox" value="ON" name="birthCountry" /></p>
				<p><label for="birthNat"><bean:message key="form.nationality"/></label>
				<input type="checkbox" value="ON" name="birthNat" /></p>	
			<h5><bean:message key="title.parentsProfession"/></h5>
			<h2>&nbsp;</h2>
				<p><label for="father"><bean:message key="form.father"/></label>
				<input type="checkbox" value="ON" name="father" /></p>
				<p><label for="mother"><bean:message key="form.mother"/></label>
				<input type="checkbox" value="ON" name="mother" /></p>
	</fieldset>
	<fieldset>
	<legend><bean:message key="form.fieldset.adress"/></legend>
		<p><label for="personal"><bean:message key="form.personal"/></label>
		<input type="checkbox" value="ON" name="personal" /></p>
		<p><label for="professional"><bean:message key="form.professional"/></label>
		<input type="checkbox" value="ON" name="professional" /></p>
		<p><label for="academic"><bean:message key="form.academic"/></label>
		<input type="checkbox" value="ON" name="academic" /></p>
		<p><label for="current"><bean:message key="form.current"/></label>
		<input type="checkbox" value="ON" name="current" /></p>
	</fieldset>
	<fieldset>
		<legend><bean:message key="form.fieldset.situation"/></legend>
		<p><label for="year"><bean:message key="form.year"/></label>
		<input type="checkbox" value="ON" name="year" /></p>
		<p><label for="die"><bean:message key="form.die"/></label>
		<input type="checkbox" value="ON" name="die" /></p>
		<p><label for="group"><bean:message key="form.group"/></label>
		<input type="checkbox" value="ON" name="group" /></p>
		<p><label for="company"><bean:message key="form.company"/></label>
		<input type="checkbox" value="ON" name="company" /></p>
		<p><label for="ti"><bean:message key="form.company.tutor"/></label>
		<input type="checkbox" value="ON" name="ti" /></p>
		<p><label for="te"><bean:message key="form.teacher.tutor"/></label>
		<input type="checkbox" value="ON" name="te" /></p>
	</fieldset>
	<fieldset>
		<legend><bean:message key="form.fieldset.schooling"/></legend>
		<p><label for="language"><bean:message key="form.language"/></label>
		<input type="checkbox" value="ON" name="language" /></p>
		<p><label for="level"><bean:message key="form.level"/></label>
		<input type="checkbox" value="ON" name="level" /></p>
		<p><label for="marks"><bean:message key="form.marks"/></label>
		<input type="checkbox" value="ON" name="marks" /></p>
		<p><label for="diploma"><bean:message key="form.diplomas"/></label>
		<input type="checkbox" value="ON" name="diploma" /></p>
		<p><label for="schoolingPast"><bean:message key="scolarityPast"/></label>
		<input type="checkbox" value="ON" name="schoolingPast" /></p>
	</fieldset>
</div>

<div id="actions" align="center">
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/save.png" title="<bean:message key="button.title.save"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/generate.png" title="<bean:message key="button.title.generate"/>"/></a></li>
	</ul>
</div>
<br/>