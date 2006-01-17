<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout" %>

<h2><bean:message key="apprentice.absence.add.title"/><html:link action="/apprenticeVisuAbsence"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>
<html:form action="/apprenticeAbsenceAddAction">
	<div class="form">

	<script src="/eMagine/common/js/strutsLayout.js"></script>
	<script>
		 imgsrc="/eMagine/common/images/icones/";
	</script>
		<p><layout:date key="form.initDate" styleClass="form_calendar" property="initDate" startYear="1994" endYear="2030" /></p>
		<p><layout:date key="form.endDate" styleClass="form_calendar" property="endDate" startYear="1994" endYear="2030" /></p>
		<p><label for="nbdays"><bean:message key="form.daysNumber"/></label><html:text property="nbdays" size="20" /></p>
		<p><label for="justification"><bean:message key="form.justification"/></label>
			<html:select property="justification">
				<html:option value="M">maladie</html:option>
				<html:option value="E">entreprise</html:option>
				<html:option value="NJ">non&nbsp;justifi&eacute;</html:option>
			</html:select>
		</p>
		<p><label for="comment"><bean:message key="form.comment"/></label><html:textarea property="comment"></html:textarea></p>
	</div>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/ok.png" title="<bean:message key="button.title.ok"/>"/></a></li>
		</ul>
	</div>
</html:form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>