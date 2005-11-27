<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<h2><bean:message key="teacher.create.title"/></h2>
<div class="form">
	<br/>
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
	<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
	<p><label for="adress"><bean:message key="form.adress"/><font color="red">*</font> </label><input type="text" id="adress" size="20" /></p>
	<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><input type="text" id="postalCode" size="20" /></p>
	<p><label for="city"><bean:message key="form.city"/><font color="red">*</font> </label><input type="text" id="city" size="20" /></p>
	<p><label for="department"><bean:message key="form.department"/><font color="red">*</font> </label><select name="department">
			<!-- à mettre en base -->
			<option value="" selected="selected">-- D&eacute;partement --</option>
			<option value="93">93</option>
			<option value="77">77</option>
			<option value="78">78</option>
		</select> </p>
	<p><label for="phone"><bean:message key="form.phone"/></label><input type="text" id="phone" size="20" /></p>	
	<p><label for="mobile"><bean:message key="form.mobile"/></label><input type="text" id="mobile" size="20" /></p>
	<p><label for="fax"><bean:message key="form.fax"/></label><input type="text" id="fax" size="20" /></p>
	<p><label for="email"><bean:message key="form.email"/><font color="red">*</font> </label><input type="text" id="email" size="20" /></p>
	<br/>
	<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/ajouter.png" alt="Ajouter l'enseignant"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>