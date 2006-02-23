<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.apprenticeSearchForm.action.value = value;
	}

	function excludeApprentices() {
		if(confirm("Souhaitez-vous réellement exclure ces apprentis ?")) {
			document.apprenticeSearchForm.action = "/eMagine/apprenticeExclude.do?action=exclude&from=search";
			document.apprenticeSearchForm.submit();
		}
	}
	function moveUpApprentices() {
		if(confirm("Souhaitez-vous réellement faire passer ces apprentis en année supérieure?")) {
			document.apprenticeSearchForm.action = "/eMagine/apprenticeMoveUp.do?action=moveUp&from=search";
			document.apprenticeSearchForm.submit();
		}
	}
-->
</script>

<h2><bean:message key="apprentice.search.title"/></h2>
<br/>
<html:form action="/apprenticeSearch" method="POST" focus="lastName">
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
				<p><label for="lastName"><bean:message key="criteria.search.name"/></label><html:text property="lastName" size="20" />  </p>
				<p><label for="firstName"><bean:message key="criteria.search.firstName"/></label><html:text property="firstName" size="20" /> </p>
				</div>
				<div class="search_b2">
					<p>
						<label for="courseOption"><bean:message key="criteria.search.die"/></label>
						<html:select property="idCourseOption">
							<logic:notEmpty name="apprenticeSearchForm" property="courseOptions">
								<option value="" selected></option>
								<html:optionsCollection property="courseOptions" value="id" label="name"/>		
							</logic:notEmpty>
						</html:select>
					</p>
					<p>
						<label for="year"><bean:message key="criteria.search.year"/></label>
						<html:select property="idYear">
							<logic:notEmpty name="apprenticeSearchForm" property="years">
								<option value="" selected></option>
								<html:optionsCollection property="years" value="id" label="name"/>		
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
				<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><html:text property="nbResults" size="5" disabled="true"/>
			</p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.die"/></th>
				<th><bean:message key="table.header.year"/></th>
			</tr>
			<logic:notEmpty name="apprenticeSearchForm" property="results">
				<logic:iterate id="apprentice" name="apprenticeSearchForm" property="results" type="fr.umlv.ir3.emagine.apprentice.Apprentice">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= apprentice.getId().toString() %>"/></td>
						<td><html:link action="/apprenticeModify?action=show" paramId="id" paramName="apprentice" paramProperty="id"><bean:write name="apprentice" property="lastName"/>&nbsp;</html:link></td>
						<td><bean:write name="apprentice" property="firstName"/>&nbsp;</td>
						<td>
							<logic:present name="apprentice" property="courseOption">
								<bean:write name="apprentice" property="courseOption.name"/>
							</logic:present>&nbsp;
						</td>
						<td>
							<logic:present name="apprentice" property="year">
								<bean:write name="apprentice" property="year.name"/>&nbsp;
							</logic:present>&nbsp;
						</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="apprenticeSearchForm" property="results">
				<tr><td colspan="8">Pas&nbsp;de&nbsp;r&eacute;sultats</td></tr>
			</logic:empty>		
		</table>
	</div>
	<!-- Les actions propres a la selection -->
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('apprenticeSearchForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('apprenticeSearchForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:moveUpApprentices();"><html:img src="/eMagine/common/images/icones/passage.png" titleKey="button.title.passage" /></html:link></li>
			<li><html:link href="javascript:excludeApprentices();"><html:img src="/eMagine/common/images/icones/virer.png" titleKey="button.title.exclude" /></html:link></li>
			<li><html:link action="/apprenticeMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" title="<bean:message key="button.title.mailingListCreate"/>"/></html:link></li>
			<li><html:link href="javascript:open_mailing_win(document.apprenticeSearchForm, 'apprentice')"><img src="/eMagine/common/images/icones/mailing.png" title="<bean:message key="button.title.email"/>"/></html:link></li>
			<li><html:link href="javascript:open_mail_win(document.apprenticeSearchForm, 'apprentice')"><img src="/eMagine/common/images/icones/publipostage.png" title="<bean:message key="button.title.mailing"/>"/></html:link></li>
			<li><html:link href="javascript:open_extract_win(document.apprenticeSearchForm, 'apprentice')"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
		</ul>
	</div>
<html:hidden property="action" />
</html:form>