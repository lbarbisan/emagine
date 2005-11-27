<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="post.list.title"/></h2>
<br/>
<form name="results">
	<div align=center>
		<div id="statSearch">
			<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.die"/></th>
				<th><bean:message key="table.header.numberAsked"/></th>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" /></td>
				<td><html:link action="/postDetail">IR</html:link></td>
				<td>1</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" /></td>
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
			<li><html:link action="/postCreate"><img src="/eMagine/common/images/icones/ajouter.png" title="Ajouter un post"/></html:link></li>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer un(des) poste(s)"/></a></li>
		</ul>
	</div>
</form>