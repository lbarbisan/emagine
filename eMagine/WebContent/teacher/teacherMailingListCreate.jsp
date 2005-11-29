<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<h2><bean:message key="mailingList.create"/><html:link action="/teacherSearch"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
<form name="results">
	<div class="form">
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label><input type="text" id="name" size="20" /></p>
		<p><label for="description"><bean:message key="form.description"/></label><textarea type="text" id="description" ></textarea></p>
	</div>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/ok.png" title="<bean:message key="button.title.ok"/>"/></a></li>
		</ul>
	</div>
</form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>