<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<h2><bean:message key="room.detail.title"/><html:link action="/centerDetail?action=show"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
<div class="form">

<html:form action="/roomDetail" method="POST" focus="name">
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label><html:text property="name" size="20" /></p>
	<p><label for="capacity"><bean:message key="form.capacity"/><font color="red">*</font>&nbsp;</label><html:text property="capacity" size="20" /></p>
	<p><label for="nbAvailable"><bean:message key="form.nbAvailable"/></label><html:text property="nbDispo" size="20" disabled="true" /></p>
</div>

<html:errors />
<html:hidden property="idRoomToModify" />
<html:hidden property="action" />
</html:form>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/modif.png" title="<bean:message key="button.title.update"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>