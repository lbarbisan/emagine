<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.jobModifyForm.action.value = value;
	}

	function create() {
		setAction('create');
		document.jobModifyForm.submit();
	}

	function resetForm() {
		document.jobModifyForm.reset();
	}
-->
</script>

<html:form action="/jobCreate" method="POST" focus="idCourseOption">

<h2><bean:message key="post.create.title"/><html:link action="/companyVisuPost"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>

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
		<li><html:link href="javascript:create();"><html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.ok" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>

<html:hidden property="action" />
</html:form>


<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>