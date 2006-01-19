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
			document.candidateSearchForm.submit();
		}
	}
	function passCandidates() {
		if(confirm("Souhaitez-vous réellement faire passer les candidats en apprentis ?")) {
			document.candidateSearchForm.action = "/eMagine/candidatePass.do?action=pass&from=search";
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
					<option value="" selected>Toutes</option>
					<html:optionsCollection property="courseOptions" value="id" label="name"/>		
				</html:select>
			</p>
			<p>
			<p>
				<label for="center"><bean:message key="criteria.search.center"/></label>
				<html:select property="idCenter">
					<option value="" selected>Tous</option>
					<html:optionsCollection property="centers" value="id" label="name"/>		
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
			<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
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
						<td><html:link action="/candidateModify?action=show" paramId="id" paramName="candidate" paramProperty="id"><bean:write name="candidate" property="lastName"/></html:link></td>
						<td><bean:write name="candidate" property="firstName"/></td>
						<td><bean:write name="candidate" property="courseOption.name"/></td>
						<td><bean:write name="candidate" property="formationCenter.name"/></td>
						<td><bean:write name="candidate" property="phone" /></td>
						<td><bean:write name="candidate" property="email" /></td>
						<td><bean:write name="candidate" property="accepted" /></td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="candidateSearchForm" property="results">
				<tr><td colspan="5">Pas de résultats</td></tr>
			</logic:empty>
		</table>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:passCandidates();"><html:img src="/eMagine/common/images/icones/passage.png" titleKey="button.title.pass" /></html:link></li>
			<li><html:link href="javascript:deleteCandidates();"><html:img src="/eMagine/common/images/icones/virer.png" titleKey="button.title.out" /></html:link></li>
			<li><html:link action="/candidateMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" title="Cr&eacute;er une maling list"/></html:link></li>
			<li><html:link action="/candidateEmailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effectuer un mailing"/></html:link></li>
			<li><html:link action="/candidateMailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effectuer un publipostage"/></html:link></li>
			<li><html:link action="/candidateExtract"><img src="/eMagine/common/images/icones/extraire.png" title="Extraire un candidat"/></html:link></li>
		</ul>
	</div>
	
<html:hidden property="action" />	
</html:form>