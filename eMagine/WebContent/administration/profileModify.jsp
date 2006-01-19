<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<h2><bean:message key="profil.detail.title"/><html:link action="/profilList"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
<div class="form">
	<p><label for="name"><bean:message key="form.name"/></label><input type="text" id="name" size="20" /></p>
	<br/>
	<fieldset>
		<p><label for="administration"><bean:message key="form.administration"/></label>
		<input type="checkbox" value="ON" name="administration" /></p>
		<p><label for="absence"><bean:message key="form.absence"/></label>
		<input type="checkbox" value="ON" name="absence" /></p>
		<p><label for="apprentice"><bean:message key="form.apprentice"/></label>
		<input type="checkbox" value="ON" name="apprentice" /></p>
		<p><label for="teacher"><bean:message key="form.teacher"/></label>
		<input type="checkbox" value="ON" name="teacher" /></p>
		<p><label for="recruitment"><bean:message key="form.recruitment"/></label>
		<input type="checkbox" value="ON" name="recruitment" /></p>
		<p><label for="statistics"><bean:message key="form.statistics"/></label>
		<input type="checkbox" value="ON" name="statistics" /></p>
	</fieldset>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/modif.png" title="<bean:message key="button.title.update"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
	</ul>
</div>
<br/>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>