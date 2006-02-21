<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout"%>

<div class="tabs">
	<ul>
		<li><html:link action="/actorVisuInfo">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li>
		<span class="tab_clicked"><li><html:link action="/actorVisuEvent">Ev&eacute;nement</html:link></li></span>
	</ul>
</div>

<script src="/eMagine/common/js/strutsLayout.js"></script>
<script>
	imgsrc="/eMagine/common/images/icones/";
</script>

<div class="tabs_div">
<form name="results">
<h2><bean:message key="event.search"/></h2>
<br/>
<div align="center">
	<div class="search">
		<fieldset>
			<div class="search_b1">
				<p>
					<label for="initDate"><bean:message key="criteria.search.initDate"/></label>
					<input type="text" id="initDate" size="15" />
					<a href="#"><img src="/eMagine/common/images/icones/calendar.png" title="<bean:message key=""/>"/></a>
					<layout:date key="button.title.calendar" styleClass="form_calendar" property="birth" startYear="1980" endYear="2030"/>
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
				<td><html:link action="/actorEventDetail">12.10.2005</html:link></td>
				<td>envoi mail</td>
				<td>pour les jpo</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON"  name="all_none"/></td>
				<td><html:link action="/actorEventDetail">13.10.2005</html:link></td>
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
			<li><html:link action="/actorEventExtract"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
		</ul>
	</div>
	</div>
</form>
