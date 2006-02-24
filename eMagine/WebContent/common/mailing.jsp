<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<html>
	<head>
		<link rel="stylesheet" href="/eMagine/common/style/style1.css" type="text/css">
		<script type="text/javascript" src="/eMagine/common/js/checkboxTools.js"></script>
		<title><bean:message key="app.title" /> : <bean:message name="mailingForm" property="extractionTitleKey" /></title>
		<script type="text/javascript">
		<!--
			function mailing() {
				document.mailingForm.action.value = "mailing";
				document.mailingForm.submit();
				return false;
			}
		-->
		</script>
	</head>
	<body>
	<div class="extract">
		<h2><bean:message name="mailingForm" property="extractionTitleKey" /></h2>
		
		<logic:notEmpty name="mailingForm" property="mailingTypes">
			<html:form action="/mailing" method="POST" focus="mailingTypeId">
				<div class="form">
					<html:errors/>
					<p>
						<label for="mailingTypeId"><bean:message key="form.type"/></label>
						<html:select property="mailingTypeId">
							<html:optionsCollection property="mailingTypes" label="title" value="id"/><bean:message key="form.mailingType"/>
						</html:select>
					</p>
				</div>
				<div id="actions">
					<ul>
						<li>
							<html:link href="javascript:mailing();">
								<html:img src="/eMagine/common/images/icones/mailing.png" titleKey="button.title.email" />
							</html:link>
						</li>
					</ul>
				</div>
				<html:hidden property="extractionEntityName"/>
				<input type="hidden" name="action"/>
			</html:form>
		</logic:notEmpty>
		<logic:empty name="mailingForm" property="mailingTypes">
			<bean:message key="mailingType.empty"/>
		</logic:empty>

		<br/>
	</div>
	</body>
</html>