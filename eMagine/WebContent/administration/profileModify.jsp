<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.profileModifyForm.action.value = value;
	}
	
	function deleteProfile() {
		if(confirm("Souhaitez-vous réellement supprimer ce profile ?")) {
			open("/eMagine/profileDelete.do?action=delete&from=modify&rightIds=" + document.profileModifyForm.elements['idProfileToModify'].value, "_self");
		}
	}
	
	function modifyProfile() {
		setAction('modify');
		document.profileModifyForm.submit();
	}

	function resetForm() {
		document.profileModifyForm.reset();
	}
-->
</script>

<h2><bean:message key="profil.detail.title"/><html:link action="/profileList?action=list"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>

<html:form action="/profileModify" method="POST">
<div class="form">
	<p><label for="name"><bean:message key="form.name"/></label><html:text property="name" size="20" /></p><br/>
	<p><label for="description"><bean:message key="form.description"/></label><html:text property="description" size="20" /></p><br/>
		
	<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
			</tr>
			<logic:notEmpty name="profileModifyForm" property="rights">
				<logic:iterate id="right" name="profileModifyForm" property="rights" type="fr.umlv.ir3.emagine.user.profile.Right">
					<tr>
						<td><html:multibox property="rightIds" value="<%= right.getId().toString() %>" />&nbsp;</td>
						<td><bean:write name="right" property="name" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	
		</table>
</div>

<br />
<html:errors />

<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyProfile();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteProfile();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
	</ul>
</div>
<br/>

<html:hidden property="idProfileToModify" />
<html:hidden property="action" />
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>