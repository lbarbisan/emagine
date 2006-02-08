<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
	<!--
		function setFirm(id, name) {
			window.opener.setFirm(id,name);
			window.close();
		}
	-->
</script>

<html:form action="/companyList" method="POST">

<div class="form">

		<table width="100%">
			<logic:notEmpty name="companyListForm" property="firms">
				<logic:iterate id="company" name="companyListForm" property="firms" type="fr.umlv.ir3.emagine.firm.Firm">
					<tr>
						<td><a href="javascript:setFirm(<%= company.getId().toString() %>,'<%= company.getName() %>');"><bean:write name="company" property="name" /></a></td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	
			
			<logic:empty name="companyListForm" property="firms">
				<tr>
					<td>Aucun résultat</td>
				</tr>
			</logic:empty>	
		</table>
			
</div>

</html:form>
