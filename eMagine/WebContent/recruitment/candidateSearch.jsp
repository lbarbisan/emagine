<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.candidateSearchForm.action.value = value;
	}

	function deleteCandidates() {
		if(confirm("Souhaitez-vous réellement supprimer les candidats ?")) {
			document.candidateSearchForm.action = "/eMagine/candidateDelete.do?action=delete&from=search";
			document.candidateSearchForm.target = '';
			document.candidateSearchForm.submit();
		}
	}
	function integrateCandidates() {
		if(confirm("Souhaitez-vous réellement faire passer les candidats en apprentis ?")) {
			document.candidateSearchForm.action = "/eMagine/candidateIntegrate.do?action=integrate&from=search";
			document.candidateSearchForm.target = '';
			document.candidateSearchForm.submit();
		}
	}
-->
</script>

<h2><bean:message key="candidate.search.title"/></h2>
<html:form action="/candidateSearch" method="POST" focus="lastName">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
			<div class="search_b1">			
				<p><label for="lastName"><bean:message key="criteria.search.name"/></label><html:text property="lastName" size="20" />  </p>
				<p><label for="firstName"><bean:message key="criteria.search.firstName"/></label><html:text property="firstName" size="20" /> </p>
			</div>		
			<div class="search_b2">
			<p>
				<label for="courseOption"><bean:message key="criteria.search.dieAsked"/></label>
				<html:select property="idCourseOption">
					<logic:notEmpty name="candidateSearchForm" property="courseOptions">
						<option value="" selected></option>
						<html:optionsCollection property="courseOptions" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			<p>
			<p>
				<label for="center"><bean:message key="criteria.search.center"/></label>
				<html:select property="idCenter">
					<logic:notEmpty name="candidateSearchForm" property="centers">
						<option value="" selected></option>
						<html:optionsCollection property="centers" value="id" label="name"/>		
					</logic:notEmpty>
				</html:select>
			</p>
			</div>
			</fieldset>
		</div>
		<br/>
		<div class="buttons"><html:submit onclick="javascript:setAction('search');" titleKey="button.title.search"><bean:message key="form.search" /></html:submit></div>
	</div>
	<h3><bean:message key="title.results"/></h3>
	<div align=center>
		<div id="statSearch">
			<p>
				<label for="result"><bean:message key="statSearch.results"/></label><html:text property="nbResults" size="5" disabled="true"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><html:text property="nbResults" size="5" disabled="true"/></p>
			</p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.die"/></th>
				<th><bean:message key="table.header.center"/></th>
				<th><bean:message key="table.header.phone"/></th>
				<th><bean:message key="table.header.email"/></th>
				<th><bean:message key="table.header.acceptable"/></th>
			</tr>
			<logic:notEmpty name="candidateSearchForm" property="results">
				<logic:iterate id="candidate" name="candidateSearchForm" property="results" type="fr.umlv.ir3.emagine.apprentice.candidate.Candidate">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= candidate.getId().toString() %>"/></td>
						<td><html:link action="/candidateModify?action=show" paramId="id" paramName="candidate" paramProperty="id"><bean:write name="candidate" property="lastName"/>&nbsp;</html:link></td>
						<td><bean:write name="candidate" property="firstName"/>&nbsp;</td>
						<td>
							<logic:present name="candidate" property="courseOption">
								<bean:write name="candidate" property="courseOption.name"/>
							</logic:present>&nbsp;
						</td>
						<td>
							<logic:present name="candidate" property="formationCenter">
								<bean:write name="candidate" property="formationCenter.name"/>&nbsp;
							</logic:present>&nbsp;
						</td>
						<td><bean:write name="candidate" property="phone" />&nbsp;</td>
						<td><bean:write name="candidate" property="email" />&nbsp;</td>
						<td><bean:write name="candidate" property="accepted" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="candidateSearchForm" property="results">
				<tr><td colspan="8">Pas de r&eacute;sultats</td></tr>
			</logic:empty>
		</table>
	</div>
	<div id="actions">
		<logic:notEmpty name="candidateSearchForm" property="results">
		<ul>
			<li><a href="javascript:checkAll('candidateSearchForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('candidateSearchForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		</logic:notEmpty>	
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:integrateCandidates();"><html:img src="/eMagine/common/images/icones/passage.png" titleKey="button.title.passage" /></html:link></li>
			<li><html:link href="javascript:deleteCandidates();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.exclude" /></html:link></li>
			<li><html:link href="javascript:open_mailing_create_win(document.candidateSearchForm, 'candidate')"><html:img src="/eMagine/common/images/icones/creer_mailing_list.png" titleKey="button.title.email"/></html:link></li>
			<li><html:link href="javascript:open_mailing_win(document.candidateSearchForm, 'candidate')"><html:img src="/eMagine/common/images/icones/mailing.png" titleKey="button.title.email"/></html:link></li>
			<li><html:link href="javascript:open_mail_win(document.candidateSearchForm, 'candidate')"><html:img src="/eMagine/common/images/icones/publipostage.png" titleKey="button.title.mailing"/></html:link></li>
			<li><html:link href="javascript:open_extract_win(document.candidateSearchForm, 'candidate')"><html:img src="/eMagine/common/images/icones/extraire.png" titleKey="button.title.extract"/></html:link></li>
		</ul>
	</div>
	<html:hidden property="action" />	
</html:form>