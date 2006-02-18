<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--

	function setAction(value) {
		document.jobListForm.action.value = value;
	}

	function change(action) {
		document.jobListForm.action = "/eMagine/" + action + ".do";
		document.jobListForm.submit();
	}

	function setAction(value) {
		document.jobListForm.action.value = value;
	}

	function deletes() {
		if(confirm("Souhaitez-vous réellement supprimer ses propositions de postes ?")) {
			document.jobListForm.action = "/eMagine/jobDelete.do?action=delete&from=list";
			document.jobListForm.submit();
		}
	}
		
-->
</script>

<div class="tabs">
	<ul>
			<li><html:link href="javascript:change('companyVisuInfo');">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li>
			<li><html:link href="javascript:change('companyVisuActor');">Acteur</html:link></li>
			<span class="tab_clicked"><li><html:link href="javascript:change('companyVisuPost');">Poste</html:link></li></span>
			<li><html:link href="javascript:change('companyVisuEvent');">Ev&eacute;nement</html:link></li>
	</ul>
</div>
<div class="tabs_div">

<h2><bean:message key="post.list.title"/></h2>
<br/>


<html:form action="/companyVisuPost" method="POST">
<br/>
	
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.die"/></th>
				<th><bean:message key="table.header.numberAsked"/></th>
			</tr>
			
			<logic:notEmpty name="jobListForm" property="results">
				<logic:iterate id="job" name="jobListForm" property="results" type="fr.umlv.ir3.emagine.firm.Job">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= job.getId().toString() %>" />&nbsp;</td>
						<td><html:link action="/jobModify?action=show" paramId="id" paramName="job" paramProperty="id"><bean:write name="job" property="cursus.name" />&nbsp;</html:link></td>
						<td><bean:write name="job" property="nbPlace" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="jobListForm" property="results">
				<tr><td colspan="5">Pas de poste</td></tr>
			</logic:empty>
		</table>
	</div>
	
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('jobListForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('jobListForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link action="/jobCreate?action=show"><img src="/eMagine/common/images/icones/ajouter.png" title="<bean:message key="button.title.add"/>"/></html:link></li>
			<li><html:link href="javascript:deletes();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
		</ul>	
	</div>
	
<html:hidden property="action" />	
</html:form>