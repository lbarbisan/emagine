<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.teacherTutorSearchForm.action.value = value;
	}

	function deleteTeachers() {
		if(confirm("Souhaitez-vous réellement supprimer ces enseignants ?")) {
			document.teacherTutorSearchForm.action = "/eMagine/teacherDelete.do?action=delete&from=search";
			document.teacherTutorSearchForm.submit();
		}
	}
-->
</script>

<html:form action="/teacherSearch" method="POST" focus="firstName">
	<h2><bean:message key="teacher.search.title"/></h2>
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="lastName"><bean:message key="criteria.search.name"/></label><html:text property="lastName" size="20" /></p>
				</div>
				<div class="search_b2">
					<p><label for="firstName"><bean:message key="criteria.search.firstName"/></label><html:text property="firstName" size="20" /></p>
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
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.phone"/></th>
				<th><bean:message key="table.header.email"/></th>
			</tr>
			<logic:notEmpty name="teacherTutorSearchForm" property="results">
				<logic:iterate id="teacher" name="teacherTutorSearchForm" property="results" type="fr.umlv.ir3.emagine.teachertutor.TeacherTutor">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= teacher.getId().toString() %>" /></td>
						<td><html:link action="/teacherModify?action=show" paramId="id" paramName="teacher" paramProperty="id"><bean:write name="teacher" property="lastName" />&nbsp;</html:link></td>
						<td><bean:write name="teacher" property="firstName" />&nbsp;</td>
						<td><bean:write name="teacher" property="phone" />&nbsp;</td>
						<td><bean:write name="teacher" property="email" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="teacherTutorSearchForm" property="results">
				<tr><td colspan="5">Pas de résultats</td></tr>
			</logic:empty>

		</table>
	</div>	
	<!-- Les actions propres a la selection -->
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('teacherTutorSearchForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('teacherTutorSearchForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:deleteTeachers();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
			<li><html:link href="javascript:afaire()"><img src="/eMagine/common/images/icones/creer_mailing_list.png" title="<bean:message key="button.title.mailingListCreate"/>"/></html:link></li>
			<li><html:link href="javascript:afaire()"><img src="/eMagine/common/images/icones/mailing.png" title="<bean:message key="button.title.email"/>"/></html:link></li>
			<li><html:link href="javascript:afaire()"><img src="/eMagine/common/images/icones/publipostage.png" title="<bean:message key="button.title.mailing"/>"/></html:link></li>
			<li><html:link action="/teacherExtract.do"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
		</ul>
	</div>
	
<html:hidden property="action" />	
</html:form>

