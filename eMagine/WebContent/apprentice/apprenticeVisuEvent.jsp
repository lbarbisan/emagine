<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<script type="text/javascript">
<!--
	function setAction(value) {
		document.apprenticeModifyForm.action.value = value;
	}

	function resetForm() {
		document.apprenticeModifyForm.reset();
	}
		
	function change(action) {
		document.companyModifyForm.action = "/eMagine/" + action + ".do";
		document.companyModifyForm.submit();
	}
-->
</script>
<form name="results">
	<div class="tabs">
		<ul>
			<li><html:link href="javascript:change('apprenticeVisuAdress');"><bean:message key="onglet.adress"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuStatus');"><bean:message key="onglet.status"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuSituation');"><bean:message key="onglet.situation"/></html:link></li>
			<li><html:link href="javascript:change('apprenticeVisuSchooling');"><bean:message key="onglet.schooling"/></html:link></li>
			<span class="tab_clicked"><li><html:link href="javascript:change('apprenticeVisuEvent');"><bean:message key="onglet.event"/></li></span>
			<li><html:link href="javascript:change('apprenticeVisuAbsence');"><bean:message key="onglet.absence"/></html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
		<h2><bean:message key="event.search"/></h2>
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
			<div class="buttons"><input type="button" value="Rechercher"/></div>
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
		<div id="actions">
			<ul>
				<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
				<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
			</ul>
			<h2>&nbsp;</h2>
			<ul>
				<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
				<li><html:link action="/apprenticeEventExtract"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
			</ul>
		</div>
	</div>
</form>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/modif.png" title="<bean:message key="button.title.update"/>"/></a></li>
	</ul>
</div>

