<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<div id="bloc_menu2">
	<ul id="menu2">
		<li> <a href="#">Pr&eacute;f&eacute;rences</a> | </li>
		<li><html:link action="/userSearch">Administration</html:link> | </li>
		<li> <a href="#">Aide</a> | </li>
		<li><html:link href="javascript:deconnection();">Se d&eacute;connecter</html:link></li>
	</ul>
</div>