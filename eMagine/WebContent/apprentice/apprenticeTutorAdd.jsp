<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="apprentice.tutor.add.title"/></h2>
<br/>
<form name="results">
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name"><bean:message key="form.name"/></label><input type="text" id="name" size="20" /></p>
				</div>
				<div class="search_b2">
					<p><label for="firstName"><bean:message key="form.firstName"/></label><input type="text" id="firstName" size="20" /></p> 
				</div>
			</fieldset>
		</div>
		<br/>
		<html:link action="#"><img src="/eMagine/common/images/icones/search.png" title="<bean:message key="button.title.search"/>"/></html:link>
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
				<th><bean:message key="table.header.firstName"/></th>
			</tr>
			<tr>
				<td><input type="radio" name="radio"/></td>
				<td><a href="/eMagine/teacherOnglet.do">Forax</a></td>
				<td>R&eacute;mi</td>
			</tr>
			<tr>
				<td><input type="radio" name="radio"/></td>
				<td><a href="/eMagine/teacherOnglet.do">Revuz</a></td>
				<td>Dominique</td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li>
				<input type="button" value="Affecter" title="Affecter le tuteur"/>
			</li>
		</ul>
	</div>
	<br/>
</form>