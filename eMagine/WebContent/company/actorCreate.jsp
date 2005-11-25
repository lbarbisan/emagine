<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<form name="results">
	<h2>Créer&nbsp;un&nbsp;acteur&nbsp;en&nbsp;entreprise</h2>
	<div class="form">
		<br/>
		<p><label for="name">Nom&nbsp;<font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
		<p><label for="firstName">Pr&eacute;nom&nbsp;<font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
		<p><label for="function">Fonction&nbsp;</label><select name="department">
			<!-- à mettre en base -->
			<option value="drh">DRH</option>
			<option value="pdg">PDG</option>
			<option value="ti">Tuteur&nbsp;Ingénieur</option>
		</select> </p>
		<p><label for="adress">Adresse&nbsp;<font color="red">*</font> </label><input type="text" id="adress" size="20" /></p>
		<p><label for="postalCode">Code&nbsp;postal&nbsp;<font color="red">*</font> </label><input type="text" id="postalCode" size="20" /></p>
		<p><label for="city">Ville&nbsp;<font color="red">*</font> </label><input type="text" id="city" size="20" /></p>
		<p><label for="department">D&eacute;partement&nbsp;<font color="red">*</font> </label><select name="department">
				<!-- à mettre en base -->
				<option value="93">93</option>
				<option value="77">77</option>
				<option value="78">78</option>
			</select> </p>
		<p><label for="phone">T&eacute;l&eacute;phone&nbsp;fixe&nbsp;</label><input type="text" id="phone" size="20" /></p>	
		<p><label for="mobile">T&eacute;l&eacute;phone&nbsp;portable&nbsp;</label><input type="text" id="mobile" size="20" /></p>
		<p><label for="fax">Fax&nbsp;</label><input type="text" id="fax" size="20" /></p>
		<p><label for="email">E-mail&nbsp;<font color="red">*</font> </label><input type="text" id="email" size="20" /></p>
	</div>
	<br/>
	<h2>Pupilles</h2>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>Nom</th>
				<th>Pr&eacute;nom</th>
				<th>Classe</th>
				<th>Groupe</th>
				<th>Date&nbsp;d&eacute;but</th>
				<th>Date&nbsp;fin</th>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" /></td>
				<td><html:link action="/studentOnglet">Renaudin</html:link></td>
				<td>Jean-Baptiste</td>
				<td>IR3</td>
				<td>2</td>
				<td>20.09.2003</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" /></td>
				<td><html:link action="/studentOnglet">Mancel</html:link></td>
				<td>Matthieu</td>
				<td>IR3</td>
				<td>2</td>
				<td>20.09.2003</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');">Aucun</a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link action="/actorStudentAdd"><img src="/eMagine/common/images/icones/ajouter.png" alt="Ajouter un pupille"/></html:link></li>
		</ul>
	</div>
	</form>
	<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>