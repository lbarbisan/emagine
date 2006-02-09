<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<form name="results">
	<div class="tabs">
		<ul>
			<li><html:link action="/apprenticeVisuAdress"><bean:message key="onglet.adress"/></html:link></li>
			<span class="tab_clicked"><li><bean:message key="onglet.status"/></li></span>
			<li><html:link action="/apprenticeVisuSituation"><bean:message key="onglet.situation"/></html:link></li>
			<li><html:link action="/apprenticeVisuSchooling"><bean:message key="onglet.schooling"/></html:link></li>
			<li><html:link action="/apprenticeVisuEvent"><bean:message key="onglet.event"/></html:link></li>
			<li><html:link action="/apprenticeVisuAbsence"><bean:message key="onglet.absence"/></html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
		<div class="form">
			<fieldset>
				<legend><bean:message key="form.fieldset.identification"/></legend>
				<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
				<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
				<p><label for="sex"><bean:message key="form.sex"/></label><input type="radio" name="sex" value="male">femme<input type="radio" name="sex" value="female" checked>homme</p>
			</fieldset>
			<br/>
			<fieldset>
				<legend><bean:message key="form.fieldset.birth"/></legend>
				<p><label for="date"><bean:message key="form.date"/><font color="red">*</font> </label><input type="text" id="date" size="20" /><a href="#"><img src="/eMagine/common/images/icones/calendar.png" title="<bean:message key="button.title.calendar"/>"/></a></p>
				<p><label for="city"><bean:message key="form.city"/></label><input type="text" id="city" size="20" /></p>
				<p><label for="department"><bean:message key="form.department"/></label><input type="text" id="department" size="20" /></p>
				<p><label for="country"><bean:message key="form.country"/></label><input type="text" id="country" size="20" /></p>
				<p><label for="nationality"><bean:message key="form.nationality"/><font color="red">*</font> </label><input type="text" id="nationality" size="20" /></p>
			</fieldset>
			<br/>
			<fieldset>
				<legend><bean:message key="form.fieldset.parentsProfession"/></legend>
				<p><label for="father"><bean:message key="form.father"/></label><input type="text" id="father" size="20" /></p>
				<p><label for="mother"><bean:message key="form.mother"/></label><input type="text" id="mother" size="20" /></p>
			</fieldset>
			<br/>
			<fieldset>
				<legend><bean:message key="form.fieldset.originContact"/></legend>
				<p><label for="contact"><bean:message key="form.contact"/></label>
					<select name="contact">
						<!-- à mettre en base -->
						<option value="all" selected="selected"><bean:message key="select.all.masculine"/></option>
						<option value="jpo">JPO</option>
						<option value="internet">Internet</option>
						<option value="other">Autres</option>
					</select></p>
			</fieldset>
			<br/>
		</div>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
	</div>
</form>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyApprentice();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>
