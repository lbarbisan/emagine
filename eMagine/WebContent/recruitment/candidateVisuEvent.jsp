<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.eventSearchForm.action.value = value;
	}

	function deleteEvents() {
		if(confirm("Souhaitez-vous réellement supprimer ces évenements ?")) {
			document.eventSearchForm.action = "/eMagine/eventDelete.do?from=candidate";
			document.eventSearchForm.submit();
		}
	}
-->
</script>

<script src="/eMagine/common/js/strutsLayout.js"></script>
<script>
	imgsrc="/eMagine/common/images/icones/";
</script>

<div class="tabs">
<ul>
	<li><html:link action="/candidateVisuInfo">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li>
	<span class="tab_clicked"><li><html:link action="/eventSearch.do?action=show&from=candidate">Ev&eacute;nement</html:link></li></span>
</ul>
</div>

<html:form action="/eventSearch.do?action=search&from=candidate" method="POST" focus="lastName">
<div class="tabs_div">

<h2><bean:message key="event.search"/></h2>
<br/>
<div align="center">
	<div class="search">
		<fieldset>
			<div class="search_b1">
				<p>
					<layout:date key="criteria.search.endDate" styleClass="form_calendar" property="dateBegin" startYear="1980" endYear="2030"/>
				</p>
				<p>
					<layout:date key="criteria.search.initDate" styleClass="form_calendar" property="dateEnd" startYear="1980" endYear="2030"/>
				</p>
			</div>
			<div class="search_b2">
				<p>
					<label for="type"><bean:message key="criteria.search.type"/></label>
					<html:select property="idType">
						<option value="" ></option>
						<logic:notEmpty name="eventSearchForm" property="types">
							<html:optionsCollection property="types" value="id" label="name"/>		
						</logic:notEmpty>
					</html:select>
				</p>
			</div>
			</fieldset>
		</div>
		<br/>
		<div class="buttons"><html:submit onclick="javascript:submitForm(eventSearchForm, 'eventSearch.do', 'search');" titleKey="button.title.search"><bean:message key="form.search" /></html:submit></div>
	</div>	
	<br/>
	<h3><bean:message key="title.results"/></h3>
	<div align=center>
		<div id="statSearch">
			<p><label for="result"><bean:message key="statSearch.results"/></label><html:text property="nbResults" size="5" disabled="true"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><html:text property="nbResults" size="5" disabled="true"/></p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.date"/></th>
				<th><bean:message key="table.header.event"/></th>
				<th><bean:message key="table.header.comment"/></th>
			</tr>
			
			<logic:notEmpty name="eventSearchForm" property="results">
				<logic:iterate id="event" name="eventSearchForm" property="results" type="fr.umlv.ir3.emagine.event.Event">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= event.getId().toString() %>" />&nbsp;</td>
						<td><bean:write name="event" property="date" />&nbsp;</td>
						<td><bean:write name="event" property="title" />&nbsp;</td>
						<td><bean:write name="event" property="description" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="eventSearchForm" property="results">
				<tr><td colspan="5">Pas de résultats</td></tr>
			</logic:empty>
		</table>
	</div>
	<div id="actions">
		<logic:notEmpty name="eventSearchForm" property="results">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		</logic:notEmpty>	
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:deleteEvents();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
			<li><html:link href="javascript:open_extract_win(document.eventSearchForm, 'firm')"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
		</ul>
	</div>	
	
	<html:hidden property="action" />
</html:form>