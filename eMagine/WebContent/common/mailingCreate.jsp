<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<html>
	<head>
		<link rel="stylesheet" href="/eMagine/common/style/style1.css" type="text/css">
		<script type="text/javascript" src="/eMagine/common/js/checkboxTools.js"></script>
		<title><bean:message key="app.title" /> : <bean:message name="mailingCreateForm" property="extractionTitleKey" /></title>
		<script type="text/javascript">
		<!--
			function mailingCreate() {
				document.mailingCreateForm.action.value = "create";
				document.mailingCreateForm.submit();
				return false;
			}
		-->
		</script>
	</head>
	<body>
	<div class="extract">
		<h2><bean:message key="mailingList.create"/></h2>
		<br/>
		<html:form action="/mailingCreate" method="POST" focus="name">
			<div class="form">
				<p><html:errors/></p>
				<p><label for="title"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label>
					<html:text property="title" size="20"/></p>
				<p><label for="comment"><bean:message key="form.description"/></label>
					<html:text property="comment"/></p>
			</div>
			<div id="actions">
				<h2>&nbsp;</h2>
				<ul>
					<li>
						<html:link href="javascript:mailingCreate();">
							<html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.mailingListCreate"/>
						</html:link>
					</li>
				</ul>
			</div>
			<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>

			<html:hidden property="extractionEntityName"/>
			<input type="hidden" name="action"/>
		</html:form>
		<br/>
	</div>
	</body>
</html>