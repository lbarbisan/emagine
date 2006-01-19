<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.teacherTutorModifyForm.action.value = value;
	}
	
	function deleteTeacher() {
		if(confirm("Souhaitez-vous réellement supprimer cet enseignant ?")) {
			open("/eMagine/teacherDelete.do?action=delete&from=modify&currentSelectedIds=" + document.teacherModifyForm.elements['idTeacherTutorToModify'].value, "_self");
		}
	}
	
	function modifyTeacher() {
		setAction('modify');
		document.teacherTutorModifyForm.submit();
	}

	function resetForm() {
		document.teacherTutorModifyForm.reset();
	}
-->
</script>

<div class="tabs">
<ul>
	<li><html:link action="/teacherVisuInfo">Informations&nbsp;g&eacute;n&eacute;rales&nbsp;</html:link></li>
	<span class="tab_clicked"><li>Ev&eacute;nement</li></span>
	
	
</ul>
</div>
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
			<td><html:link action="/teacherEventDetail">12.10.2005</html:link></td>
			<td>envoi mail</td>
			<td>pour les jpo</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON"  name="all_none"/></td>
			<td><html:link action="/teacherEventDetail">13.10.2005</html:link></td>
			<td>tutelle</td>
			<td>changement&nbsp;de&nbsp;tuteur&nbsp;enseignant</td>
		</tr>
	</table>
	</div>
	<div id="actions">
		
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
			<li><html:link action="/teacherEventExtract"><img src="/eMagine/common/images/icones/extraire.png" title="<bean:message key="button.title.extract"/>"/></html:link></li>
		</ul>
	</div>
	</div>
</form>
<div id="actions">
	<ul>
		<li><html:link href="javascript:modifyTeacher();"><html:img src="/eMagine/common/images/icones/modif.png" titleKey="button.title.update" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
		<li><html:link href="javascript:deleteTeacher();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
	</ul>
</div>
