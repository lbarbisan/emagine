<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="event.extract.title"/></h2>
<br/>
<div class="form">
	<p><label for="type"><bean:message key="form.type"/></label><input type="radio" name="type" value="csv" checked>csv<input type="radio" name="type" value="xls">xls</p>
	<br/>
	<fieldset>
		<p><label for="name"><bean:message key="form.name"/></label>
		<input type="checkbox" value="ON" name="name" /></p>
		<p><label for="date"><bean:message key="form.date"/></label>
		<input type="checkbox" value="ON" name="date" /></p>
		<p><label for="description"><bean:message key="form.description"/></label>
		<input type="checkbox" value="ON" name="descritpion" /></p>
	</fieldset>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/save.png" title="<bean:message key="button.title.save"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/generate.png" title="<bean:message key="button.title.generate"/>"/></a></li>
		<li><html:link action="/candidateSearch"><img src="/eMagine/common/images/icones/annuler.png" title="<bean:message key="button.title.cancel"/>"/></html:link></li>		
	</ul>
</div>
<br/>
