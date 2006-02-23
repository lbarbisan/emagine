<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested"%>

<html>
	<head>
		<link rel="stylesheet" href="/eMagine/common/style/style1.css" type="text/css">
		<script type="text/javascript" src="/eMagine/common/js/checkboxTools.js"></script>
		<title><bean:message key="app.title" /> : <bean:message name="mailForm" property="extractionTitleKey" /></title>
		<script type="text/javascript">
		<!--
			function mail() {
				document.mailForm.action.value = "extract";
				document.mailForm.submit();
				return false;
			}
		-->
		</script>
	</head>
	<body>
	<div class="extract">
		<html:form action="/mail" method="POST">
			<h2><bean:message name="mailForm" property="extractionTitleKey"/></h2>
			<div class="form">
				<p>
					<html:errors/>
				</p>
			</div>
			<div id="content">
				<ul>
					<li>
						<html:link action="/openAttachment" paramId="id" paramName="mailForm" paramProperty="mailingType.id">
							<bean:message key="mail.do.docFile"/><bean:write name="mailForm" property="mailingType.fileName"/>
						</html:link>
					</li>
					<li>
						<html:link href="javascript:mail();">
							<bean:message key="mail.do.dataFile"/>
						</html:link>
					</li>
				</ul>
			</div>
			<html:hidden property="extractionEntityName"/>
			<input type="hidden" name="action"/>
		</html:form>
		<br/>
	</div>
	</body>
</html>