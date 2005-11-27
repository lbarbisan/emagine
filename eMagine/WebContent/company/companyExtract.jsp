<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="company.extract.title"/></h2>
<h2></h2>
<br/>
<div class="form">
	<p><label for="type"><bean:message key="form.type"/></label><input type="radio" name="type" value="csv" checked>csv<input type="radio" name="type" value="xls">xls</p>
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
		<p><label for="city"><bean:message key="form.city"/></label>
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
		<li><a href="#"><input type="button" value="Sauvegarder"/></a></li>
		<li><a href="#"><input type="button" value="Générer"/></a></li>
	</ul>
</div>
<br/>