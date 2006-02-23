<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.companySearchForm.action.value = value;
	}

	function deleteCompanies() {
		if(confirm("Souhaitez-vous réellement supprimer ces entreprises ?")) {
			document.companySearchForm.action = "/eMagine/companyDelete.do?action=delete&from=search";
			document.companySearchForm.submit();
		}
	}
-->
</script>

<h2><bean:message key="company.search.title"/></h2>

<html:form action="/companySearch" method="POST" focus="lastName">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name"><bean:message key="criteria.search.name"/></label><html:text property="name" size="20" /></p>
				</div>
				<div class="search_b2">
					<p><label for="department"><bean:message key="criteria.search.department"/></label>
						<html:select property="idDepartment">
							<option value="" ></option>
							<logic:notEmpty name="companySearchForm" property="departments">
								<html:optionsCollection property="departments" value="id" label="name"/>		
							</logic:notEmpty>
						</html:select>
				</div>
			</fieldset>
		</div>
		<br/>
		<div class="buttons"><html:submit onclick="javascript:setAction('search');" titleKey="button.title.search"><bean:message key="form.search" /></html:submit></div>
	</div>
	<h3><bean:message key="title.results"/></h3>
	<div align="center">
		<div id="statSearch">
			<p><label for="result"><bean:message key="statSearch.results"/></label><html:text property="nbResults" size="5" disabled="true"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><html:text property="nbResults" size="5" disabled="true"/></p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.department"/></th>
			</tr>

			<logic:notEmpty name="companySearchForm" property="results">
				<logic:iterate id="company" name="companySearchForm" property="results" type="fr.umlv.ir3.emagine.firm.Firm">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= company.getId().toString() %>" />&nbsp;</td>
						<td><html:link action="/companyModify?action=show" paramId="id" paramName="company" paramProperty="id"><bean:write name="company" property="name" />&nbsp;</html:link></td>
						<td>
							<logic:notEmpty name="company" property="address">
								<logic:notEmpty name="company" property="address.department">
									<bean:write name="company" property="address.department.name" />
								</logic:notEmpty>&nbsp;
							</logic:notEmpty>&nbsp;
						</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="companySearchForm" property="results">
				<tr><td colspan="5">Pas de résultats</td></tr>
			</logic:empty>

		</table>
	</div>
	<div id="actions">
		<logic:notEmpty name="companySearchForm" property="results">
		<ul>
			<li><a href="javascript:checkAll('companySearchForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('companySearchForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		</logic:notEmpty>	
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:deleteCompanies();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
			<li><html:link href="javascript:open_extract_win(document.companySearchForm, 'firm')"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
		</ul>
	</div>	
	
	<html:hidden property="action" />
</html:form>