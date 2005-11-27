<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="candidate.extract.title"/></h2>
<br/>
<div class="form">
	<p><label for="type"><bean:message key="form.type"/></label><input type="radio" name="type" value="csv" checked>csv<input type="radio" name="type" value="xls">xls</p>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.identification"/></legend>
				<p><label for="name"><bean:message key="form.name"/></label>
				<input type="checkbox" value="ON" name="name" /></p>
				<p><label for="firstName"><bean:message key="form.firstName"/></label>
				<input type="checkbox" value="ON" name="firstName" /></p>
				<p><label for="sex"><bean:message key="form.sex"/></label>
				<input type="checkbox" value="ON" name="sex" /></p>
	</fieldset>
	<fieldset>
		<legend><bean:message key="form.fieldset.coord"/></legend>
		<p><label for="adress"><bean:message key="form.personal"/></label>
		<input type="checkbox" value="ON" name="adress" /></p>
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