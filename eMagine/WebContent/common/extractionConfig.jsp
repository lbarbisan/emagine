<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<html>
	<head>
		<link rel="stylesheet" href="/eMagine/common/style/style1.css" type="text/css">
		<script type="text/javascript" src="/eMagine/common/js/checkboxTools.js"></script>
		<title><bean:message key="app.title" /> : <bean:message name="extractionForm" property="extractionTitleKey" /></title>
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
	<div class="extract">
		<h2><bean:message name="extractionForm" property="extractionTitleKey" /></h2>
		<html:form action="/extract" method="POST">
			<div class="form">
				<html:errors/>
				<p>
					<label for="extractionTypeName"><bean:message key="form.type"/></label>
					<html:radio property="extractionTypeName" value="CSV"/><bean:message key="form.type.csv"/>
					<html:radio property="extractionTypeName" value="XLS"/><bean:message key="form.type.xls"/>
				</p>
				<logic:iterate id="groupContainer" name="extractionForm" property="extractionGroupIterator">
					<bean:define id="group" name="groupContainer" property="group" type="fr.umlv.ir3.emagine.extraction.PropertiesExtractionGroup"/>
					<fieldset>
						<legend><bean:message key="<%= "form."+group.getGroupName() %>"/></legend>
						<logic:iterate id="property" name="group" property="properties">
							<p>
								<label for="<bean:write name="property"/>"><bean:message key="<%= "form."+property %>"/></label>
								<html:multibox property="selectedEntityProperties" value="<%= group.getFullNameProperty((String)property) %>"/>
							</p>
						</logic:iterate>
						<logic:iterate id="finshedIterator" name="groupContainer" property="finishedIterator">
							</fieldset>
						</logic:iterate>
				</logic:iterate>
				<label for="saveConfig"><bean:message key="form.saveExtractionConfig"/></label>
				<html:checkbox property="saveConfig"/>
				</fieldset>
				
			</div>
			<br/>
			<div id="actions">
				<ul>
					<li><a href="javascript:checkAll('extractionForm','selectedEntityProperties');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
					<li><a href="javascript:checkNothing('extractionForm','selectedEntityProperties');"><bean:message key="all_none.none"/></a></li>
				</ul>
				<ul>
					<li>
						<html:link href="javascript:extract();">
							<html:img src="/eMagine/common/images/icones/generate.png" titleKey="button.title.generate" />
						</html:link>
					</li>
				</ul>
			</div>
			</div>
			<html:hidden property="extractionEntityName"/>
			<input type="hidden" name="action"/>
		</html:form>
		<br/>
	</body>
</html>