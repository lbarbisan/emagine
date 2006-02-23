<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Onglets Entreprise</h2>

<ul>
	<li><html:link action="/companyVisuInfo">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li>
</ul>
<ul>
	<li><html:link action="/companyVisuActor">Acteur</html:link></li>
</ul>
<ul>
	<li><html:link action="/companyVisuPost">Poste</html:link></li>
</ul>
<ul>
	<li><html:link action="/eventSearch.do?action=show&from=firm">Ev&eacute;nement</html:link></li>
</ul>
