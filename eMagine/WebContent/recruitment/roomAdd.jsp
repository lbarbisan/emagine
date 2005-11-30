<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2><bean:message key="room.add.title"/><html:link action="/centerDetail"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
<div class="form">
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label><input type="text" id="name" size="20" /></p>
	<p><label for="center"><bean:message key="form.center"/></label><input type="text" id="center" size="20" /></p>
	<p><label for="capacity"><bean:message key="form.capacity"/><font color="red">*</font>&nbsp;</label><input type="text" id="capacity" size="20" /></p>
	<p><label for="nbAvailable"><bean:message key="form.nbAvailable"/></label><input type="text" id="nbAvailable" size="20" /></p>
</div>
<div id="actions">
	<h2>&nbsp;</h2>	
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/ok.png" title="<bean:message key="button.title.ok"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/reinit.png" title="<bean:message key="button.title.reinitialize"/>"/></a></li>
	</ul>
</div>
<br/>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>