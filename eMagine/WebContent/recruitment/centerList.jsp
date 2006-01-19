<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<h2><bean:message key="center.list.title"/></h2>
<br/>

<html:form action="/formationCenterList" method="POST">
<div align=center>

	<table cellpadding="0" cellspacing="0">
		<tr>
			<th><bean:message key="table.header.name"/></th>
			<th><bean:message key="table.header.adress"/></th>
			<th><bean:message key="table.header.phone"/></th>
			<th><bean:message key="table.header.nbRoom"/></th>
			<th><bean:message key="table.header.nbAvailable"/></th>
		</tr>
		
		  <logic:notEmpty name="formationCenterListForm" property="centers">
				<logic:iterate id="currentCenter" name="teacherTutorModifyForm" property="centers">
					<tr>
						<td><bean:write name="currentCenter" property="name" />&nbsp;</td>
						<td><bean:write name="currentCenter" property="address" />&nbsp;</td>
						<td><bean:write name="currentCenter" property="phone" />&nbsp;</td>
						<td><bean:write name="currentCenter" property="phone" />&nbsp;</td>
						<td><bean:write name="currentCenter" property="phone" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="formationCenterListForm" property="centers">
				<tr><td colspan="6">Aucun centre de formation</td></tr>
			</logic:empty>		
	</table>
	<br/>
</div>
<html:hidden property="action" />	
<html:errors />
</html:form>