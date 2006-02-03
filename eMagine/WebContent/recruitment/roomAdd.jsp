<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.roomModifyForm.action.value = value;
	}

	function createRoom() {
		setAction('create');
		document.roomModifyForm.submit();
	}

	function resetForm() {
		document.roomModifyForm.reset();
	}
-->
</script>
<bean:parameter name="id" id="examCenterId"/>
<h2><bean:message key="room.add.title"/><html:link action="/centerDetail?action=show"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
<html:form action="/roomAdd" method="POST" focus="name">
<div class="form">
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label><html:text property="name" size="20"/></p>
	<p><label for="capacity"><bean:message key="form.capacity"/><font color="red">*</font>&nbsp;</label><html:text property="capacity" size="20"/></p>
</div>
<html:errors />
<div id="actions">
	<h2>&nbsp;</h2>	
	<ul>
		<li><a href="javascript:createRoom();"><img src="/eMagine/common/images/icones/ok.png" title="<bean:message key="button.title.ok"/>"/></a></li>
		<li><a href="javascript:resetForm();"><img src="/eMagine/common/images/icones/reinit.png" title="<bean:message key="button.title.reinitialize"/>"/></a></li>
	</ul>
</div>
<br/>
<input type="hidden" id="idCenter" value="<%= examCenterId %>">
<html:hidden property="action" />
</html:form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>