<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2><bean:message key="mailingList.detail.title"/><html:link action="/mailingListVisu"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
	<div class="form">
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
		<p><label for="description"><bean:message key="form.description"/></label><textarea type="text" id="description" ></textarea></p>
	</div>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/modif.png" title="<bean:message key="button.title.update"/>"/></a></li>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
		</ul>
	</div>
<br/>
