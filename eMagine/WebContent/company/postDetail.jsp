<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.jobModifyForm.action.value = value;
	}
	
	function deleteJob() {
		if(confirm("Souhaitez-vous réellement supprimer ce poste ?")) {
			open("/eMagine/posteDelete.do?action=delete&from=modify&currentSelectedIds=" + document.jobModifyForm.elements['idJobToModify'].value, "_self");
		}
		
	}
	
	function modifyJob() {
		setAction('modify');
		document.jobModifyForm.submit();
	}

	function resetForm() {
		document.jobModifyForm.reset();
	}
-->
</script>


<html:form action="/jobModify" method="POST" focus="idCourseOption">

<h2><bean:message key="post.detail.title"/><html:link action="/companyVisuPost"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>

<div class="form">
	<p>
		<label for="idCourseOption"><bean:message key="form.die"/></label>
		<html:select property="idCourseOption">
			<html:optionsCollection property="courseOptions" value="id" label="name"/>		
		</html:select>
		
	<p><label for="nbPost"><bean:message key="form.nbPost"/><font color="red">*</font>&nbsp;</label><html:text property="nbPostes" size="20" /></p>
</div>

<br/>
<html:errors />

<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyJob();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteJob();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
	</ul>
</div>


<html:hidden property="idJobToModify" />
<html:hidden property="action" />
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>