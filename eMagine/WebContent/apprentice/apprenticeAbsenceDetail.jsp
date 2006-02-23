<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout"%>

<script src="/eMagine/common/js/strutsLayout.js"></script>
<script>
	imgsrc="/eMagine/common/images/icones/";
</script>
<script type="text/javascript">
<!--
	function setAction(value) {
		document.absenceModifyForm.action.value = value;
	}
	
	function deleteAbsence() {
		if(confirm("Souhaitez-vous réellement supprimer cette absence ?")) {
			open("/eMagine/absenceDelete.do?action=delete&from=modify&currentSelectedIds=" + document.absenceModifyForm.elements['idAbsenceToModify'].value, "_self");
		}		
	}
	
	function modifyAbsence() {
		setAction('modify');
		document.absenceModifyForm.submit();
	}

	function resetForm() {
		document.absenceModifyForm.reset();
	}
-->
</script>

<h2><bean:message key="apprentice.absence.detail.title"/><html:link action="/apprenticeVisuAbsence?action=show"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
<html:form action="/absenceModify">
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
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
		<li><html:link href="javascript:modifyAbsence();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteAbsence();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
		</ul>
	</div>
<html:errors/>
<html:hidden property="action"/>
</html:form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>