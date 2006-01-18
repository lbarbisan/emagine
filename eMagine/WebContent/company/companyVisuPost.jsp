<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<div class="tabs">
	<ul>
		<li><html:link action="/companyVisuInfo">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li>
		<li><html:link action="/companyVisuActor">Acteur</html:link></li>
		<span class="tab_clicked"><li><html:link action="/companyVisuPost">Poste</html:link></li></span>
		<li><html:link action="/companyVisuEvent">Ev&eacute;nement</html:link></li>
</ul>
</div>
<div class="tabs_div">

<h2><bean:message key="post.list.title"/></h2>
<br/>
<form name="results">
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.die"/></th>
				<th><bean:message key="table.header.numberAsked"/></th>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/postDetail">IR</html:link></td>
				<td>1</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/postDetail">MFPI</html:link></td>
				<td>3</td>
			</tr>
		</table>
	</div>
	<!-- Les actions propres a la selection -->
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link action="/postCreate"><img src="/eMagine/common/images/icones/ajouter.png" title="<bean:message key="button.title.add"/>"/></html:link></li>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
		</ul>
	</div>
	</div>
</form>