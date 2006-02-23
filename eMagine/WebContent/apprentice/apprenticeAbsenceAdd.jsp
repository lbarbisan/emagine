<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout" %>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<script src="/eMagine/common/js/strutsLayout.js"></script>
<script>
	imgsrc="/eMagine/common/images/icones/";
</script>
<script type="text/javascript">
<!--
	function setAction(value) {
		document.absenceModifyForm.action.value = value;
	}

	function create() {
		setAction('create');
		document.absenceModifyForm.submit();
	}

	function resetForm() {
		document.absenceModifyForm.reset();
	}
		
	function deleteAbsences() {
		if(confirm("Souhaitez-vous r�ellement supprimer ces absences ?")) {
			document.companySearchForm.action = "/eMagine/absenceDelete.do?action=delete&from=search";
			document.companySearchForm.submit();
		}
	}
-->
</script>
<h2><bean:message key="apprentice.absence.add.title"/><html:link action="/apprenticeVisuAbsence"><html:img src="/eMagine/common/images/icones/retour.png" titleKey="button.title.return"/></html:link></h2>
<br/>
<html:form action="/absenceCreate">
	<div class="form">
		<p><layout:date key="form.initDate" styleClass="form_calendar" property="initDate" startYear="1994" endYear="2030" /></p>
		<p><layout:date key="form.endDate" styleClass="form_calendar" property="endDate" startYear="1994" endYear="2030" /></p>
		<p><label for="nbDays"><bean:message key="form.daysNumber"/><html:text property="nbDays" size="20" /></label></p>
		<p>
			<label for="justifications"><bean:message key="criteria.search.justification"/></label>
			<html:select property="idJustification">
				<logic:notEmpty name="absenceModifyForm" property="justifications">
					<html:optionsCollection property="justifications" value="id" label="name"/>
				</logic:notEmpty>
			</html:select>
		</p>
		<p><label for="comment"><bean:message key="form.comment"/></label><html:textarea property="comment"></html:textarea></p>
	</div>
	<html:errors />
	<html:hidden property="action" />
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:create();"><html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.ok" /></html:link></li>
			<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
			<li><html:link href="javascript:deleteAbsences();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
		</ul>
	</div>
</html:form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>