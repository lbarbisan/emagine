<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="teacher.apprentice.add.title"/><html:link action="/teacherVisuInfo"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
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
						<option value="all" selected="selected"><bean:message key="select.all.feminin"/></option>
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
	<div class="buttons"><input type="button" value="Rechercher"/></div>
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
			<th><bean:message key="table.header.firstName"/></th>
			<th><bean:message key="table.header.die"/></th>
			<th><bean:message key="table.header.year"/></th>
		</tr>
		<tr>
			<td><input type="radio" name="all_none" value="ON" /></td>
			<td><html:link action="/apprenticeVisuAdress">Barbisan</html:link></td>
			<td>Laurent</td>
			<td>IR</td>
			<td>3</td>
		</tr>
		<tr>
			<td><input type="radio" name="all_none" value="ON" /></td>
			<td><html:link action="/apprenticeVisuAdress">Ogier</html:link></td>
			<td>Anthony</td>
			<td>IR</td>
			<td>3</td>
		</tr>
	</table>
</div>
	<div id="actions">
		<h2>&nbsp;</h2>	
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/ok.png" title="<bean:message key="button.title.ok"/>"/></a></li>
		</ul>
	</div>
</form>