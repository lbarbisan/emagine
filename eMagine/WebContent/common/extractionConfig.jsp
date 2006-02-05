<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<html>
	<head>
		<link rel="stylesheet" href="/eMagine/common/style/style1.css" type="text/css">
		<script type="text/javascript" src="/eMagine/common/js/checkboxTools.js"></script>
		<title><bean:message key="app.title" /></title>
		<script type="text/javascript">
		<!--
			function extract() {
				document.extractionForm.action.value = "extract";
				document.extractionForm.submit();
				return false;
			}
		-->
		</script>
	</head>
	<body>
		<h2><bean:message name="extractionForm" property="extractionTitleKey" /></h2>
		<br/>
		<html:form action="/extract" method="POST">
			<div class="form">
				<p>
					<label for="extractionTypeName"><bean:message key="form.type"/></label>
					<html:radio property="extractionTypeName" value="CSV"/><bean:message key="form.type.csv"/>
					<html:radio property="extractionTypeName" value="XLS"/><bean:message key="form.type.xls"/>
				</p>
				<br/>
				<fieldset>
					<logic:iterate id="property" name="extractionForm" property="entityProperties">
						<p>
							<label for="<bean:write name="property"/>"><bean:message key="<%= "form."+property %>"/></label>
							<html:multibox property="selectedEntityProperties" value="<%= (String)property %>"/>
						</p>
					</logic:iterate>
				</fieldset>
			</div>
			<div id="actions">
				<ul>
					<li><a href="javascript:checkAll('extractionForm','selectedEntityProperties');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
					<li><a href="javascript:checkNothing('extractionForm','selectedEntityProperties');"><bean:message key="all_none.none"/></a></li>
				</ul>
				<h2>&nbsp;</h2>
				<ul>
					<li><a href="#"><img src="/eMagine/common/images/icones/save.png" title="<bean:message key="button.title.save"/>"/></a></li>
					<li>
						<html:img
							onclick="javascript:extract();"
							src="/eMagine/common/images/icones/generate.png"
							titleKey="button.title.generate"/>
					</li>
				</ul>
			</div>
			<html:hidden property="extractionEntityName"/>
			<input type="hidden" name="action"/>
		</html:form>
		<br/>
	</body>
</html>