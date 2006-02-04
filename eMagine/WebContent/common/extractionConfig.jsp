<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<bean:page id="formBean" property="extractionForm" />

<html><body>
<h2><bean:message name="extractionForm" property="extractionTitleKey" /></h2>
<br/>
<html:form>
<div class="form">
	<p>
		<label for="extractionType"><bean:message key="form.type"/></label>
		<html:radio name="extractionType" value="CSV">csv
		<html:radio name="extractionType" value="XLS">xls
	</p>
	<br/>
		<fieldset>
		<p><label for="name"><bean:message key="form.name"/></label>
		<input type="checkbox" value="ON" name="name" /></p>
		<p><label for="firstName"><bean:message key="form.firstName"/></label>
		<input type="checkbox" value="ON" name="firstName" /></p>
		<p><label for="function"><bean:message key="form.function"/></label>
		<input type="checkbox" value="ON" name="function" /></p>
		<p><label for="adress"><bean:message key="form.adress"/></label>
		<input type="checkbox" value="ON" name="adress" /></p>
		<p><label for="postalCode"><bean:message key="form.postalCode"/></label>
		<input type="checkbox" value="ON" name="postalCode" /></p>
		<p><label for="city"><bean:message key="form.country"/></label>
		<input type="checkbox" value="ON" name="city" /></p>
		<p><label for="department"><bean:message key="form.department"/></label>
		<input type="checkbox" value="ON" name="department" /></p>
		<p><label for="phone"><bean:message key="form.phone"/></label>
		<input type="checkbox" value="ON" name="phone" /></p>
		<p><label for="mobile"><bean:message key="form.mobile"/></label>
		<input type="checkbox" value="ON" name="mobile" /></p>
		<p><label for="fax"><bean:message key="form.fax"/></label>
		<input type="checkbox" value="ON" name="fax" /></p>
		<p><label for="email"><bean:message key="form.email"/></label>
		<input type="checkbox" value="ON" name="email" /></p>
	</fieldset>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/save.png" title="<bean:message key="button.title.save"/>"/></a></li>
		<li><html:link action="teacherExtractFile.do?action=generate"><img src="/eMagine/common/images/icones/generate.png" title="<bean:message key="button.title.generate"/>"/></html:link></li>
	</ul>
</div>
</html:form>
<br/>
</body></html>