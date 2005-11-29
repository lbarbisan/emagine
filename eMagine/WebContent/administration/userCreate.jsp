<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="user.create.title"/></h2>
<div class="form">
	<br/>
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
	<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
	<p><label for="email"><bean:message key="form.email"/><font color="red">*</font> </label><input type="text" id="email" size="20" /></p>
	<p><label for="identifiant"><bean:message key="form.identifiant"/><font color="red">*</font> </label><input type="text" id="identifiant" size="20" /></p>
	<p><label for="password"><bean:message key="form.password"/></label><input type="text" id="password" size="20" /></p>	
	<p><label for="confirmPassword"><bean:message key="form.confirmPassword"/></label><input type="text" id="confirmPassword" size="20" /></p>
	<p>
		<label for="profil"><bean:message key="form.profil"/></label>
		<select name="profil">
			<option value="1">ProfilApprenti</option>
			<option value="2">ProfilEnseignant</option>
		</select>
	</p>
<br/>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/ok.png" title="<bean:message key="button.title.ok"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/reinit.png" title="<bean:message key="button.title.reinitialize"/>"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>