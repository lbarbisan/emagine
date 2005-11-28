<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<form name="results">
<h2><bean:message key="event.search"/></h2>
<br/>
<div align="center">
	<div class="search">
		<fieldset>
			<div class="search_b1">
				<p>
					<label for="initDate"><bean:message key="criteria.search.initDate"/></label>
					<input type="text" id="initDate" size="20" /> 
				</p>
				<p>
					<label for="endDate"><bean:message key="criteria.search.endDate"/></label>
					<input type="text" id="endDate" size="20" /> 
				</p>
			</div>
			<div class="search_b2">
				<p>
					<label for="type"><bean:message key="criteria.search.type"/></label>
					<select name="type">
						<!-- à mettre en base -->
						<option value="all" selected="selected"><bean:message key="select.all.masculine"/></option>
						<option value="email">email</option>
						<option value="mail">courrier</option>
						<option value="tutor">tutelle</option>
					</select>
				</p>
			</div>
		</fieldset>
	</div>
	<br/>
	<html:link action="#"><img src="/eMagine/common/images/icones/search.png" title="<bean:message key="student.search.title"/>"/></html:link>
</div>	
<br/>
<h3><bean:message key="title.results"/></h3>
<div align=center>
	<div id="statSearch">
		<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
		<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
	</div>
		<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th><bean:message key="table.header.date"/></th>
			<th><bean:message key="table.header.event"/></th>
			<th><bean:message key="table.header.comment"/></th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON"  name="all_none"/></td>
			<td><html:link action="/apprenticeEventDetail">12.10.2005</html:link></td>
			<td>envoi mail</td>
			<td>pour les jpo</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON"  name="all_none"/></td>
			<td><html:link action="/apprenticeEventDetail">13.10.2005</html:link></td>
			<td>tutelle</td>
			<td>changement&nbsp;de&nbsp;tuteur&nbsp;enseignant</td>
		</tr>
	</table>
	</div>
	<br/>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a> </li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="supprimer un événement"/></a></li>
			<li><html:link action="/teacherEventExtract"><img src="/eMagine/common/images/icones/extraire.png" title="Extraire un événement"/></html:link></li>
		</ul>
	</div>
</form>
