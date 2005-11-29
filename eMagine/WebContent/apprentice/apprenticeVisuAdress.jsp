<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<div align="right"><p><html:link action="/apprenticeSearch"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></p></div>
<form name="results">
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
<!-- Un formulaire de modification -->
<div class="form">
		<br/>
		<p>
			<label for="current" style="bold"><bean:message key="radio.adress.current"/></label>
			<input type="radio" name="current" value="personnal"><bean:message key="radio.adress.personal"/>	
			<input type="radio" name="current" value="professional"><bean:message key="radio.adress.professional"/>
			<input type="radio" name="current" value="academic" checked><bean:message key="radio.adress.academic"/>	
		</p>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.adress.personal"/></legend>
				<p><label for="persAdress"><bean:message key="form.adress"/><font color="red">*</font>&nbsp;</label><input type="text" id="persAdress" size="20" /></p>
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
				<p><label for="persEmail"><bean:message key="form.email"/><font color="red">*</font>&nbsp;</label><input type="text" id="persEmail" size="20" /></p>	
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.adress.professional"/></legend>
			<p><label for="profAdress"><bean:message key="form.adress"/><font color="red">*</font>&nbsp;</label><input type="text" id="profAdress" size="20" /></p>
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
			<p><label for="profEmail"><bean:message key="form.email"/><font color="red">*</font>&nbsp;</label><input type="text" id="profEmail" size="20" /></p>
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.adress.academic"/></legend>
			<p><label for="acaAdress"><bean:message key="form.adress"/><font color="red">*</font> </label><input type="text" id="acaAdress" size="20" /></p>
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
			<p><label for="acaEmail"><bean:message key="form.email"/><font color="red">*</font>&nbsp;</label><input type="text" id="acaEmail" size="20" /></p>
		</fieldset>
		<br/>
	</div>
</form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
<br/>
</div>