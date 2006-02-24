<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.mailingListListForm.action.value = value;
	}

	function deleteMailingLists() {
		if(confirm("Souhaitez-vous réellement supprimer ses listes de mailing ?")) {
			document.mailingListListForm.action = "/eMagine/mailingTypeDelete.do?action=delete&from=list";
			document.mailingListListForm.target = '';
			document.mailingListListForm.submit();
		}
	}
-->
</script>

<h2><bean:message key="mailingList.list.title"/></h2>

<html:form action="/mailingListVisu" method="POST">

<br/>
	
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.description"/></th>
			</tr>
			
			<logic:notEmpty name="mailingListListForm" property="results">
				<logic:iterate id="mailingList" name="mailingListListForm" property="results" type="fr.umlv.ir3.emagine.extraction.mailings.MailingList">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= mailingList.getId().toString() %>" />&nbsp;</td>
						<td>
							<html:link action="/emailDo">
								<html:img src="/eMagine/common/images/icones/publipostage_small.png" titleKey="button.title.mailing"/>
							</html:link>
							<html:link action="/mailDo">
								<html:img src="/eMagine/common/images/icones/mailing_small.png" titleKey="button.title.email"/>
							</html:link>
						</td>
						<td><bean:write name="mailingList" property="title" />&nbsp;</td>
						<td><bean:write name="mailingList" property="comment" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="mailingListListForm" property="results">
				<tr><td colspan="5">Pas de liste de mailing disponible</td></tr>
			</logic:empty>
		</table>
	</div>
	
	<div id="actions">
		<logic:notEmpty name="mailingListListForm" property="results">
		<ul>
			<li><a href="javascript:checkAll('mailingListListForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('mailingListListForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		</logic:notEmpty>	
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:deleteMailingLists();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
		</ul>	
	</div>
	
<html:hidden property="action" />	
</html:form>