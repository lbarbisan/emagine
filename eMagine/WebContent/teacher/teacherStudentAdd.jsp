<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="teacher.student.add.title"/></h2>
<form name="results">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name"><bean:message key="criteria.search.name"/></label>
						<input type="text" id="name" size="20" /> 
					</p>
					<p>
						<label for="firstName"><bean:message key="criteria.search.firstName"/></label>
						<input type="text" id="firstName" size="20" /> 
					</p>
				</div>
				<div class="search_b2">
				<p><label for="die"><bean:message key="criteria.search.die"/></label>
					<select name="die">
						<!-- à mettre en base -->
						<option value="all" selected="selected"><bean:message key="select.option.feminin"/></option>
						<option value="ir">IR</option>
						<option value="mfpi">MFPI</option>
						<option value="gmu">GMU</option>
					</select>
				<p>
				<p>
					<label for="year"><bean:message key="criteria.search.year"/></label>
					<select name="year">
						<!-- à mettre en base -->
						<option value="all" selected="selected">Toutes</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</p>	
			</div>
		</fieldset>
	</div>
	<br/>
	<input type="button" value="Rechercher"/>
</div>
<h3><bean:message key="title.results"/></h3>
	<div align="center">
		<div id="statSearch">
			<p>
			<label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5" />&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /> 
			</p>
		</div>
		<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th><bean:message key="table.header.name"/></th>
			<th><bean:message key="table.header.firtsName"/></th>
			<th><bean:message key="table.header.die"/></th>
			<th><bean:message key="table.header.year"/></th>
		</tr>
		<tr>
			<td><input type="checkbox" name="all_none" value="ON" /></td>
			<td><html:link action="/studentOnglet">Barbisan</html:link></td>
			<td>Laurent</td>
			<td>IR</td>
			<td>3</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="all_none" value="ON" /></td>
			<td><html:link action="/studentOnglet">Ogier</html:link></td>
			<td>Anthony</td>
			<td>IR</td>
			<td>3</td>
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
			<li><a href="#"><input type="submit" name="addStudent" value="Affecter"></a></li>
		</ul>
	</div>
</form>