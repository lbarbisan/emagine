<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<form name="results">
	<h2><bean:message key="teacher.search.title"/></h2>
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name"><bean:message key="criteria.search.name"/></label><input type="text" id="name" size="20" /></p>
				</div>
				<div class="search_b2">
					<p><label for="firstName"><bean:message key="criteria.search.firstName"/></label><input type="text" id="firstName" size="20" /></p>
				</div>
			</fieldset>
		</div>
		<br/>
		<div class="buttons"><input type="button" value="Rechercher"/></div>
	</div>
	<h3><bean:message key="title.results"/></h3>
	<div align=center>
		<div id="statSearch">
		<p>
			<label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" />
		</p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.phone"/></th>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none" /></td>
				<td><html:link action="/teacherVisuInfo">Duris</html:link></td>
				<td>Etienne</td>
				<td>0123456789</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none" /></td>
				<td><html:link action="/teacherVisuInfo">Mourrier</html:link></td>
				<td>Yves</td>
				<td>0123456789</td>
			</tr>
		</table>
	</div>	
	<!-- Les actions propres a la selection -->
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a> </li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
			<li><html:link action="/teacherMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" title="<bean:message key="button.title.mailingListCreate"/>"/></html:link></li>
			<li><html:link action="/teacherEmailDo"><img src="/eMagine/common/images/icones/mailing.png" title="<bean:message key="button.title.email"/>"/></html:link></li>
			<li><html:link action="/teacherMailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="<bean:message key="button.title.mailing"/>"/></html:link></li>
			<li><html:link action="/teacherExtract"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
		</ul>
	</div>
</form>

