<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<h2><bean:message key="bringingTogether.title"/></h2>
<html:form action="/userCreate" method="POST" focus="lastName">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<p>
					<label for="die"><bean:message key="form.die"/></label>
					<html:select property="die">
						<html:optionsCollection property="dies" value="id" label="filière"/>		
					</html:select>
				</p>
				
				<!--<p><label for="die"><bean:message key="criteria.search.die"/></label>
					<select name="die">
						<option value="all" selected="selected"><bean:message key="select.all.feminin"/></option>
						<option value="ir">IR</option>
						<option value="mfpi">MFPI</option>
						<option value="gmu">GMU</option>
					</select></p>-->
			</fieldset>
		</div>
		<br/>
		<div class="buttons"><input type="button" value="<bean:message key="button.title.bringingTogether"/>"/></div>
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
				<th><bean:message key="table.header.name"/></th>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/companyOnglet">Sanofi</html:link></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/companyOnglet">Bosh</html:link></td>
			</tr>
		</table>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>	
		<ul>
			<li><html:image src="/eMagine/common/images/icones/extraire.png" titleKey="button.title.extract" onclick="javascript:setDispatch('create')" /></li>
		
			<!--  <li><html:link action="/bringingTogetherExtract"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>-->
		</ul>
	</div>
</html:form>