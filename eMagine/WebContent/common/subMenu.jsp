<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script language="javascript">
<!--
	function disconnect() {
		if(confirm("Souhaitez-vous réellement vous déconnecter ?"))
			open("logout.do?action=logout", "_self");
	}
-->
</script>

<div id="bloc_menu2">
	<ul id="menu2">
		<li><bean:message key="form.login"/><%= fr.umlv.ir3.emagine.security.SessionManager.getInstance().getCurrentUser().getLogin() %> | </li>
		<logic:present role="user.retrieve,user.find">
			<li><html:link action="/userSearch?action=show"><bean:message key="form.administration"/></html:link> | </li>
		</logic:present>
		<li><html:link href="javascript:afaire();"><bean:message key="form.help"/></html:link> | </li>
		<li><html:link href="javascript:disconnect();"><bean:message key="form.disconnect"/></html:link></li>
	</ul>
</div>