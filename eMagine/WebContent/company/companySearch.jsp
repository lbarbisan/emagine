<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="company.search.title"/></h2>
<form name="results">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name"><bean:message key="criteria.search.name"/></label> <input type="text" id="name" size="20" /> </p>
				</div>
				<div class="search_b2">
					<p><label for="department"><bean:message key="criteria.search.department"/></label><select name="persDepartment">
						<!-- à mettre en base -->
						<option value="93">93</option>
						<option value="77">77</option>
						<option value="78">78</option>
					</select></p>
				</div>
			</fieldset>
		</div>
		<br/>
		<html:link action="#"><img src="/eMagine/common/images/icones/search.png" title="<bean:message key="button.title.search"/>"/></html:link>
	</div>
	<h3><bean:message key="title.results"/></h3>
	<div align="center">
		<div id="statSearch">
			<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.department"/></th>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none"/></td>
				<td><html:link action="/companyOnglet">Keops</html:link></td>
				<td>77</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none"/></td>
				<td><html:link action="/companyOnglet">Nestle</html:link></td>
				<td>93</td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer une entreprise"/></a></li>
			<li><html:link action="/companyExtract"><img src="/eMagine/common/images/icones/extraire.png" title="Extraire une entreprise"/></html:link></li>
		</ul>
	</div>
</form>
