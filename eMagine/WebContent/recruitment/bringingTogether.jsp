<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.bringingTogetherForm.action.value = value;
	}
-->
</script>

<h2><bean:message key="bringingTogether.title"/></h2>
<html:form action="/bringingTogether" method="POST">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<p>
					<label for="courseOption"><bean:message key="criteria.search.dieAsked"/></label>
					<html:select property="idCourseOption">
						<logic:notEmpty name="bringingTogetherForm" property="courseOptions">
							<option value="" selected></option>
							<html:optionsCollection property="courseOptions" value="id" label="name"/>		
						</logic:notEmpty>
					</html:select>
				</p>
			</fieldset>
		</div>
		<br/>
			<div class="buttons"><html:submit onclick="javascript:setAction('bringingTogether');" titleKey="button.title.bringingTogether"><bean:message key="button.title.bringingTogether" /></html:submit></div>
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
			<logic:notEmpty name="bringingTogetherForm" property="results">
				<logic:iterate id="firm" name="bringingTogetherForm" property="results" type="fr.umlv.ir3.emagine.firm.Firm">
					<tr>
						<td><html:multibox property="currentSelectedIds" value="<%= firm.getId().toString() %>"/></td>
						<td><html:link action="/companyOnglet?action=show" paramId="id" paramName="firm" paramProperty="id"><bean:write name="firm" property="name"/>&nbsp;</html:link></td>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="bringingTogetherForm" property="results">
				<tr><td colspan="2">Pas de résultats</td></tr>
			</logic:empty>
		</table>
	</div>
	<div id="actions">
		<logic:notEmpty name="bringingTogetherForm" property="results">
		<ul>
			<li><a href="javascript:checkAll('bringinigTogetherForm','currentSelectedIds');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('bringingTogetherForm','currentSelectedIds');"><bean:message key="all_none.none"/></a></li>
		</ul>
		</logic:notEmpty>	
		<h2>&nbsp;</h2>	
		<ul>
			<li><html:link href="javascript:extractResults();"><html:img src="/eMagine/common/images/icones/extraire.png" titleKey="button.title.passage" /></html:link></li>
		</ul>
	</div>
	<html:hidden property="action"/>
</html:form>