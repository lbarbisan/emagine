<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.mailingTypeListForm.action.value = value;
	}

	function deleteMailingTypes() {
		if(confirm("Souhaitez-vous réellement supprimer ses types de mailing ?")) {
			document.mailingTypeListForm.action = "/eMagine/mailingTypeDelete.do?action=delete&from=list";
			document.mailingTypeListForm.submit();
		}
	}
-->
</script>

<h2><bean:message key="mailType.list.title"/></h2>

<html:form action="/mailingTypeVisu" method="POST">

<br/>
	
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.file"/></th>
				<th><bean:message key="table.header.comment"/></th>
			</tr>
			
			<logic:notEmpty name="mailingTypeListForm" property="results">
				<logic:iterate id="mailingType" name="mailingTypeListForm" property="results" type="fr.umlv.ir3.emagine.extraction.mailstype.MailingType">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= mailingType.getId().toString() %>" />&nbsp;</td>
						<td><bean:write name="mailingType" property="title" />&nbsp;</td>
						<td><html:link action="/openAttachment" paramId="id" paramName="mailingType" paramProperty="id"><bean:write name="mailingType" property="fileName" /></html:link>&nbsp;</td>
						<td><bean:write name="mailingType" property="comment" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="mailingTypeListForm" property="results">
				<tr><td colspan="5">Pas de type de mailing disponible</td></tr>
			</logic:empty>
		</table>
	</div>
	
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('mailingTypeListForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('mailingTypeListForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:deleteMailingTypes();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
		</ul>	
	</div>
	
<html:hidden property="action" />	
</html:form>