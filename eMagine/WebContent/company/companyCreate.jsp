<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="company.create.title/></h2>
<div class="form">
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.organisation"/></legend>
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label><input type="text" id="name" size="20" /></p>
		<p><label for="branch"><bean:message key="form.branch"/></label>
			<select name="branch">
				<!-- à mettre en base -->
				<option value="1">bahla</option>
				<option value="2">jvoipa</option>
			</select>
		</p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.coord"/></legend>
			<p><label for="adress"><bean:message key="form.adress"/><font color="red">*</font>&nbsp;</label><input type="text" id="persAdress" size="20" /></p>
			<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font>&nbsp;</label><input type="text" id="persPostalCode" size="20" /></p>
			<p><label for="city"><bean:message key="form.city"/><font color="red">*</font>&nbsp;</label><input type="text" id="persCity" size="20" /></p>
			<p><label for="department"><bean:message key="form.department"/></label>
				<select name="persDepartment">
				<option value="93">93</option>
				<option value="77">77</option>
				<option value="78">78</option>
				</select> </p>
			<p><label for="phone"><bean:message key="form.phone"/></label><input type="text" id="phone" size="20" /></p>	
			<p><label for="fax"><bean:message key="form.mobile"/></label><input type="text" id="fax" size="20" /></p>
			<p><label for="website"><bean:message key="form.email"/><font color="red">*</font> </label><input type="text" id="website" size="20" /></p>	
	</fieldset>
	<br/>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="submit" value="Créer" alt="Créer une entreprise"/></a></li>
		<li><a href="#"><input type="submit" value="Réinitialiser" alt="Réinitialiser le formulaire"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>