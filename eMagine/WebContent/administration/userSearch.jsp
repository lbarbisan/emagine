<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Recherche d'utilisateur</h2>
<br/>
<div align="center">
	<div class="search">
		<fieldset>
			<div class="search_b1">
				<p><label for="name">Nom </label> <input type="text" id="name" size="20" /> </p>
				<p><label for="firstName">Pr&eacute;nom </label> <input type="text" id="firstName" size="20" /> </p>
			</div>
			
			<div class="search_b2">
			<p><label for="identifiant">Identifiant&nbsp;</label> <input type="text" id="identifiant" size="20" /> </p>
			<p><label for="profil">Profil&nbsp;</label>
				<select name="profil">
					<option value="all" selected="selected">Tous</option>
					<option value="1">ProfilApprenti</option>
					<option value="2">ProfilEnseignant</option>
				</select>
			</p>
			</div>
		</fieldset>
</div>
<br/>
<input type="button" value="Rechercher"/>
</div>
	<h2>R&eacute;sultats </h2> 
	
	<!-- Un tableau de resultats -->
	<div align=center>
		<div id="statSearch">
		<p>
		<label for="result">R&eacute;sulats </label> <input type="text" id="result" size="5" />&nbsp;&nbsp;&nbsp;
		<label for="pageNb">Nombre par page </label><input type="text" id="pageNb" size="5" /> 
		</p>
		</div>
		<form name="results">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>Nom</th>
				<th>Pr&eacute;nom</th>
				<th>Identifiant</th>
				<th>Profil</th>
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
	<!-- Les actions propres a la selection -->
	<div id="actions">
	<a name="all_none" />
		<ul>
			<li><a href="#all_none" onclick="checkAll('results','all_none');">Tous</a> / </li>
			<li><a href="#all_none" onclick="checkNothing('results','all_none');">Aucun</a> </li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer un utilisateur"/></a></li>
		</ul>
	</form>
</div>
