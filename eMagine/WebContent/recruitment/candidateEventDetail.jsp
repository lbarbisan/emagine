<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2><bean:message key="event.detail.title"/><html:link action="/eventSearch.do?action=show&from=candidate"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
<div class="form">
	<p><label for="name"><bean:message key="form.name"/></label><input type="text" id="name" size="20" /></p>
	<p><label for="date"><bean:message key="form.date"/></label><input type="text" id="date" size="20" /></p>
	<p><label for="description"><bean:message key="form.description"/></label><textarea type="text" id="description"></textarea></p>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
	</ul>
</div>
<br/>