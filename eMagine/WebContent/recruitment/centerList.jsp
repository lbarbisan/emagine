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
		
		  <logic:notEmpty name="formationCenterListForm" property="results">
				<logic:iterate id="center" name="formationCenterListForm" property="results" type="fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter">
					<tr>
						<td><html:link action="/centerDetail?action=show" paramId="id" paramName="center" paramProperty="id"><bean:write name="center" property="name" />&nbsp;</html:link></td>
						<td><bean:write name="center" property="addressString" />&nbsp;</td>
						<td><bean:write name="center" property="phone" />&nbsp;</td>
						<td><bean:write name="center" property="nbRooms" />&nbsp;</td>
						<td><bean:write name="center" property="nbAvailable" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="formationCenterListForm" property="results">
				<tr><td colspan="6">Aucun centre de formation</td></tr>
			</logic:empty>		
	</table>
	<br/>
</div>
<html:hidden property="action" />	
<html:errors />
</html:form>