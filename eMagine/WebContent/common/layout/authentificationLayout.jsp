<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<html>
	<head>
		<link rel="stylesheet" href="/eMagine/common/style/style1.css" type="text/css">
		<title><bean:message key="app.title" /></title>
	</head>
	<body>
	<!--  <img src="/eMagine/common/images/auth.png"/><br/><br/>-->

			<div class="login">
				<form method="post" name="auth" action="j_security_check">
					<html:img src="/eMagine/common/images/logo.gif"/>
					<h2>Authentification</h2>
					<br/>
					<p><label for="login">Identifiant </label><input type="text" name="j_username" id="login" size="20" /></p>
					<p><label for="pwd">Mot&nbsp;de&nbsp;passe </label><input type="password" name="j_password" id="pwd" size="20" /></p>
					<br/>
					<% if (request.getParameter("j_username") != null) { %>
						<font color="red"><bean:message key="exception.login.failed"/></font>
					<% } %>
					<hr/>
					<div align=center><html:submit value="Envoyer"/></div>
					<html:errors/>
				</form>
			</div>

<script type="text/javascript" language="JavaScript">
  <!--
  var focusControl = document.forms["auth"].elements["j_username"];

  if (focusControl.type != "hidden" && !focusControl.disabled) {
     focusControl.focus();
  }
  // -->
</script>

	</body>
</html>
