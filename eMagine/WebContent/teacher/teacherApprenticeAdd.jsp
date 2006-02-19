<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.apprenticeSearchForm.action.value = value;
	}
-->
</script>

<h2><bean:message key="teacher.apprentice.add.title"/><html:link action="/teacherVisuInfo"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>


<html:form action="/apprenticeSearch" method="POST" focus="lastName">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name"><bean:message key="criteria.search.name"/></label>
						<html:text property="lastName" size="20" /> 
					</p>
					<p>
						<label for="firstName"><bean:message key="criteria.search.firstName"/></label>
						<html:text property="firstName" size="20" /> 
					</p>
				</div>
				<div class="search_b2">
				<p><label for="die"><bean:message key="criteria.search.die"/></label>

					<select name="die">
						<option value=""></option>
						
					</select>
				<p>
				<p>
					<label for="year"><bean:message key="criteria.search.year"/></label>
					<select name="year">
						<option value=""></option>

					</select>
				</p>	
			</div>
		</fieldset>
	</div>
	<br/>
		<div class="buttons"><html:submit onclick="javascript:setAction('search');" titleKey="button.title.search"><bean:message key="form.search" /></html:submit></div>
</div>
<h3><bean:message key="title.results"/></h3>
	<div align="center">
		<div id="statSearch">
			<p><label for="result"><bean:message key="statSearch.results"/></label><html:text property="nbResults" size="5" disabled="true"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><html:text property="nbResults" size="5" disabled="true"/></p>
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
			<p><label for="sex"><bean:message key="radio.sex"/></label>
				<logic:notEmpty name="candidateModifyForm" property="sexes">
					<logic:iterate id="sex" name="candidateModifyForm" property="sexes" type="fr.umlv.ir3.emagine.apprentice.SexEnum">
						 
  						<bean:write name="sex" property="name"/>
					</logic:iterate>	   	
				</logic:notEmpty>
			</p>


<!-- 			<logic:notEmpty name="apprenticeSearchForm" property="results">
				<logic:iterate id="apprentice" name="apprenticeSearchForm" property="results" type="fr.umlv.ir3.emagine.user.User">
					<tr>
						<td><html:radio property="currentSelectedIds" value="<%/*= apprentice.getId().toString() */%>" />&nbsp;</td>
						<td><html:link action="/userModify?action=show" paramId="id" paramName="user" paramProperty="id"><bean:write name="user" property="lastName" />&nbsp;</html:link></td>
						<td><bean:write name="apprentice" property="firstName.name" />&nbsp;</td>
						<td><bean:write name="apprentice" property="courseOption.name" />&nbsp;</td>
						<td><bean:write name="apprentice" property="year.name" />&nbsp;</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="apprenticeSearchForm" property="results">
				<tr><td colspan="5">Pas de résultats</td></tr>
			</logic:empty>
 -->
	</table>
</div>
	<div id="actions">
		<h2>&nbsp;</h2>	
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/ok.png" title="<bean:message key="button.title.ok"/>"/></a></li>
		</ul>
	</div>
</html:form>