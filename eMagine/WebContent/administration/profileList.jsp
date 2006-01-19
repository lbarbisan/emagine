<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.profileListForm.action.value = value;
	}

	function deleteProfiles() {
		if(confirm("Souhaitez-vous réellement supprimer ses profiles ?")) {
			document.profileListForm.action = "/eMagine/profileDelete.do?action=delete&from=list";
			document.profileListForm.submit();
		}
	}
-->
</script>

<h2><bean:message key="profil.list.title"/></h2>

<html:form action="/profileList" method="POST">

<br/>
	
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.description"/></th>
			</tr>
			
			<logic:notEmpty name="profileListForm" property="results">
				<logic:iterate id="profile" name="profileListForm" property="results" type="fr.umlv.ir3.emagine.user.profile.Profile">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= profile.getId().toString() %>" />&nbsp;</td>
						<td><html:link action="/profileModify?action=show" paramId="id" paramName="profile" paramProperty="id"><bean:write name="profile" property="name" />&nbsp;</html:link></td>
						<td><bean:write name="profile" property="description" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="profileListForm" property="results">
				<tr><td colspan="5">Pas de profile disponible</td></tr>
			</logic:empty>
		</table>
	</div>
	
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('profileListForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('profileListForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:deleteProfiles();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
		</ul>	
	</div>
	
<html:hidden property="action" />	
</html:form>