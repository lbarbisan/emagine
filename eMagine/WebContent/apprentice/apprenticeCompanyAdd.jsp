<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="apprentice.company.add.title"/></h2>
<br/>
<form name="results">
	<div class="search">
		<p><label for="name"><bean:message key="criteria.search.name"/></label><input type="text" id="name" size="20" /> 
		<html:link action="#"><img src="/eMagine/common/images/icones/search.png" title="<bean:message key="button.title.search"/>"/></html:link></p>
	</div>
	<h3><bean:message key="title.results"/></h3>
	<div align=center>
		<div id="statSearch">
			<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
		</div>
			<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
			</tr>
			<tr>
				<td width="5"><input type="radio" name="radio" /></td>
				<td><a href="/eMagine/companyOnglet.do">Siemens</a></td>
			</tr>
			<tr>
				<td><input type="radio" name="radio" /></td>
				<td><a href="/eMagine/companyOnglet.do">Thomson</a></td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li>
				<input type="button" value="Affecter"/>
			</li>
		</ul>
	</div>
	<br/> 
</form>