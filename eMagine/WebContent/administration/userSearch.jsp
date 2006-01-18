<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setDispatch(value) {
		document.userSearchForm.dispatch.value = value;
	}

	function deleteUsers() {
		if(confirm("Souhaitez-vous r�ellement supprimer ses utilisateurs ?")) {
			setDispatch('delete');
			document.userSearchForm.submit();
		}
	}
-->
</script>

<h2><bean:message key="user.search.title"/></h2>

<html:form action="/userSearch" method="POST" focus="lastName">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="lastName"><bean:message key="criteria.search.name"/></label><html:text property="lastName" size="20" /></p>
					<p><label for="firstName"><bean:message key="criteria.search.firstName"/></label><html:text property="firstName" size="20" /></p>
				</div>
				<div class="search_b2">
					<p><label for="identifiant"><bean:message key="criteria.search.identifiant"/></label><html:text property="login" size="20" /></p>
					<p><label for="profil"><bean:message key="criteria.search.profil"/></label>
		
						<html:select property="profile">
							<option value="" ></option>
							<html:optionsCollection property="profiles" value="id" label="name"/>		
						</html:select>
					</p>
				</div>
			</fieldset>
		</div>
		<br/>
		<div class="buttons"><html:submit onclick="javascript:setDispatch('search');" titleKey="button.title.search"><bean:message key="form.search" /></html:submit></div>
	</div>
	<h2><bean:message key="title.results"/></h2> 
	<div align=center>
		<div id="statSearch">
			<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.identifiant"/></th>
				<th><bean:message key="table.header.profil"/></th>
			</tr>
			
			<logic:notEmpty name="userSearchForm" property="results">
				<logic:iterate id="user" name="userSearchForm" property="results">
					<tr>
						<td><input type="checkbox" value="ON" name="all_none" /></td>
						<td><html:link action="/userModify?dispatch=show" paramId="id" paramName="user" paramProperty="id"><bean:write name="user" property="lastName" /></html:link></td>
						<td><bean:write name="user" property="firstName" /></td>
						<td><bean:write name="user" property="login" /></td>
						<td><bean:write name="user" property="profile.name" /></td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>	

			<logic:empty name="userSearchForm" property="results">
				<tr><td colspan="5">Pas de r�sultats</td></tr>
			</logic:empty>
		</table>
	</div>

	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('userSearchForm','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('userSearchForm','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		
		<h2>&nbsp;</h2>
	
		<ul>
			<li><html:link href="javascript:deleteUsers();"><html:img src="/eMagine/common/images/icones/supprimer.png" titleKey="button.title.remove" /></html:link></li>
		</ul>
	</div>
	
<html:hidden property="dispatch" />	
</html:form>
