<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="user.search.title"/></h2>
<form name="results">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name"><bean:message key="criteria.search.name"/></label> <input type="text" id="name" size="20" /> </p>
					<p><label for="firstName"><bean:message key="criteria.search.firstName"/></label> <input type="text" id="firstName" size="20" /> </p>
				</div>
				<div class="search_b2">
					<p><label for="identifiant"><bean:message key="criteria.search.identifiant"/></label> <input type="text" id="identifiant" size="20" /> </p>
					<p><label for="profil"><bean:message key="criteria.search.profil"/></label>
						<select name="profil">
							<option value="all" selected="selected"><bean:message key="criteria.search.identifiant"/></option>
							<option value="1">ProfilApprenti</option>
							<option value="2">ProfilEnseignant</option>
						</select>
					</p>
				</div>
			</fieldset>
		</div>
		<br/>
		<html:link action="#"><img src="/eMagine/common/images/icones/search.png" title="<bean:message key="student.search.title"/>"/></html:link>
	</div>
	<h2><bean:message key="tilte.results"/></h2> 
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
			<tr>
				<td><input type="checkbox" value="ON" name="all_none" /></td>
				<td><html:link action="/userDetail">Jeudi</html:link></td>
				<td>Corinne</td>
				<td>cjeudi</td>
				<td>profilEntreprise</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none" /></td>
				<td><html:link action="/userDetail">menetrier</html:link></td>
				<td>Maud</td>
				<td>mmenetrier</td>
				<td>profilRecrutement</td>
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
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer un utilisateur"/></a></li>
		</ul>
	</div>
</form>

