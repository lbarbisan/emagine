<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script src="/eMagine/common/js/strutsLayout.js"></script>
<script>
	imgsrc="/eMagine/common/images/icones/";
</script>
<script type="text/javascript">
<!--
	function setAction(value) {
		document.absenceSearchForm.action.value = value;
	}

	function deleteAbsences() {
		if(confirm("Souhaitez-vous réellement supprimer ces absences ?")) {
			document.absenceSearchForm.action = "/eMagine/absenceDelete.do?action=delete&from=search";
			document.absenceSearchForm.submit();
		}
	}
	
	function change(action) {
		document.absenceSearchForm.action = "/eMagine/" + action + ".do";
		document.absenceSearchForm.submit();
	}
-->
</script>
<html:form action="/apprenticeVisuAbsence" method="POST" focus="">
	<div class="tabs">
		<ul>
			<li><html:link href="javascript:change('apprenticeVisuSituation');"><bean:message key="onglet.situation"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuAdress');"><bean:message key="onglet.adress"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuStatus');"><bean:message key="onglet.status"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuSchooling');"><bean:message key="onglet.schooling"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuEvent');"><bean:message key="onglet.event"/></html:link></li>
			<li><span class="tab_clicked"><html:link href="javascript:change('apprenticeVisuAbsence');"><bean:message key="onglet.absence"/></html:link></span></li>
		</ul>
	</div>
	<div class="tabs_div">
	<!-- Un formulaire de modification -->
	<h2><bean:message key="apprentice.absence.search.title"/></h2>
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="initDate"><layout:date key="criteria.search.initDate" styleClass="form_calendar" property="initDate" startYear="2006" endYear="2030"/></label></p>
					<p><label for="endDate"><layout:date key="criteria.search.endDate" styleClass="form_calendar" property="endDate" startYear="2006" endYear="2030"/></label></p>
				</div>
				<div class="search_b2">
					<p>
					<label for="justifications"><bean:message key="criteria.search.justification"/></label>
					<html:select property="idJustification">
						<logic:notEmpty name="absenceSearchForm" property="justifications">
							<html:optionsCollection property="justifications" value="id" label="name"/>
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
			<p><label for="result"><bean:message key="statSearch.results"/></label><html:text property="nbResults" size="5" disabled="true"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><html:text property="nbResults" size="5" disabled="true"/></p>
			</div>
			<p align="center"><label for="total"><bean:message key="form.total"/></label>
			<input type="text" id="total" size="20" /></p> 
			<table cellpadding="0" cellspacing="0">
				<tr>
					<th>&nbsp;</th>
					<th><bean:message key="table.header.initDate"/></th>
					<th><bean:message key="table.header.endDate"/></th>
					<th><bean:message key="table.header.justification"/></th>
					<th><bean:message key="table.header.comment"/></th>
				</tr>
				<tr>
				<logic:notEmpty name="absenceSearchForm" property="results">
					<logic:iterate id="absence" name="absenceSearchForm" property="results" type="fr.umlv.ir3.emagine.apprentice.absence.Absence">
						<tr>
							<td><html:multibox property="currentSelectedIds" value="<%= absence.getId().toString() %>" />&nbsp;</td>
							<td><html:link action="/absenceModify?action=show" paramId="id" paramName="absence" paramProperty="id"><bean:write name="absence" property="name" />&nbsp;</html:link></td>
							<td><bean:write name="absence" property="initDate"/>&nbsp;</td>
							<td><bean:write name="absence" property="endDate"/>&nbsp;</td>
							<td>
								<logic:present name="absence" property="justification">
									<bean:write name="absence" property="justification.name"/>
								</logic:present>&nbsp;
							</td>
							<td><bean:write name="absence" property="comment"/>&nbsp;</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>	
				<logic:empty name="absenceSearchForm" property="results">
					<tr><td colspan="6">Pas de résultats</td></tr>
				</logic:empty>
			</table>
		</div>
		<div id="actions">
			<ul>
			<li><a href="javascript:checkAll('absenceSearchForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('absenceSearchForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
			</ul>
			<h2>&nbsp;</h2>
			<ul>
				<li><html:link action="/absenceCreate"><html:img src="/eMagine/common/images/icones/ajouter.png" titleKey="button.title.add" /></html:link></li>
			</ul>
		</div>
	</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyAbsence();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteAbsence);"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
		<li><html:link action="/apprenticeAbsenceExtract"><html:img src="/eMagine/common/images/icones/extraire.png" titleKey="button.title.extract"/></html:link></li>
	</ul>
</div>
<html:hidden property="action" />
</html:form>