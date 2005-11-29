<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<div id="bloc_menu2">
	<ul id="menu2">
		<li><html:link action="/userSearch"><bean:message key="form.administration"/></html:link> | </li>
		<li> <a href="#">Aide</a> | </li>
		<li><html:link href="javascript:deconnection();"><bean:message key="form.disconnect"/></html:link></li>
	</ul>
</div>