<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="room.detail.title"/></h2>
<br/>
<div class="form">
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label><input type="text" id="name" size="20" /></p>
	<p><label for="center"><bean:message key="form.center"/></label><input type="text" id="center" size="20" /></p>
	<p><label for="nbPlace"><bean:message key="form.nbPlace"/></label><input type="text" id="nbPlace" size="20" /></p>
	<p><label for="nbAvailable"><bean:message key="form.nbAvailable"/></label><input type="text" id="nbAvailable" size="20" /></p>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/modif.png" title="<bean:message key="button.title.update"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
		<li><html:link action="/centerList"><img src="/eMagine/common/images/icones/annuler.png" title="<bean:message key="button.title.cancel"/>"/></html:link></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>