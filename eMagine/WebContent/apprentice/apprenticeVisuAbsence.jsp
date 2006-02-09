<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout"%>

<form name="results">
	<div class="tabs">
		<ul>
			<li><html:link action="/apprenticeVisuAdress"><bean:message key="onglet.adress"/></html:link></li>
			<li><html:link action="/apprenticeVisuStatus"><bean:message key="onglet.status"/></html:link></li>
			<li><html:link action="/apprenticeVisuSituation"><bean:message key="onglet.situation"/></html:link></li>
			<li><html:link action="/apprenticeVisuSchooling"><bean:message key="onglet.schooling"/></html:link></li>
			<li><html:link action="/apprenticeVisuEvent"><bean:message key="onglet.event"/></html:link></li>
			<span class="tab_clicked"><li><bean:message key="onglet.absence"/></li></span>
		</ul>
	</div>
	<div class="tabs_div">
	<!-- Un formulaire de modification -->
	<h2><bean:message key="apprentice.absence.search.title"/></h2>
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p>
						<label for="initDate"><bean:message key="criteria.search.initDate"/></label>
						<input type="text" id="initDate" size="15" /> 
						<a href="#"><img src="/eMagine/common/images/icones/calendar.png" title="<bean:message key="button.title.calendar"/>"/></a>
					</p>
					<p>
						<label for="endDate"><bean:message key="criteria.search.endDate"/></label>
						<input type="text" id="endDate" size="15" />
						<a href="#"><img src="/eMagine/common/images/icones/calendar.png" title="<bean:message key="button.title.calendar"/>"/></a> 
					</p>
				</div>
				<div class="search_b2">
					<p>
						<label for="justification"><bean:message key="criteria.search.justification"/></label>
						<select name="justification">
							<!-- à mettre en base -->
							<option value="all" selected="selected"><bean:message key="select.all.feminin"/></option>
							<option value="M">maladie</option>
							<option value="E">entreprise</option>
							<option value="NJ">non&nbsp;justifi&eacute;</option>
						</select>
					</p>
				</div>
			</fieldset>
		</div>
		<br/>
		<div class="buttons"><input type="button" value="Rechercher"/></div>
	</div>
		<h3><bean:message key="title.results"/></h3>
		<div align=center>
			<div id="statSearch">
				<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
				<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
			</div>
			<p align="center"><label for="total"><bean:message key="form.total"/></label>
			<input type="text" id="total" size="20" /></p> 
			<table cellpadding="0" cellspacing="0">
				<tr>
					<th>&nbsp;</th>
					<th><bean:message key="table.header.initDate"/></th>
					<th><bean:message key="table.header.endDate"/></th>
					<th><bean:message key="table.header.daysNumber"/></th>
					<th><bean:message key="table.header.justification"/></th>
					<th><bean:message key="table.header.comment"/></th>
				</tr>
				<tr>
					<td><input type="checkbox" value="ON" name="all_none"/></td>
					<td><html:link action="/apprenticeAbsenceDetail">12.10.2005</html:link></td>
					<td>12.10.2005</td>
					<td>0.5</td>
					<td>NJ</td>
					<td>pas bien pas de justification</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="ON" name="all_none"/></td>
					<td><html:link action="/apprenticeAbsenceDetail">21.12.2005</html:link></td>
					<td>24.12.2005</td>
					<td>3</td>
					<td>M</td>
					<td>oula très malade!!</td>
				</tr>
			</table>
		</div>
		<div id="actions">
			<div id="statSearch">
				<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
				<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
			</div>
			<h2>&nbsp;</h2>
			<ul>
				<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
				<li><html:link action="/apprenticeAbsenceExtract"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
				<li><html:link action="/apprenticeAbsenceAdd"><img src="/eMagine/common/images/icones/ajouter.png" title="<bean:message key="button.title.add"/>"/></html:link></li>
			</ul>
		</div>
	</div>
</form>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><html:link href="javascript:modifyAbsence();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteAbsence();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
	</ul>
</div>