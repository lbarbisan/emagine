<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Cr&eacute;er&nbsp;un&nbsp;utilisateur</h2>
<div class="form">
	<br/>
	<p><label for="name">Nom&nbsp;<font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
	<p><label for="firstName">Pr&eacute;nom&nbsp;<font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
	<p><label for="email">E-mail&nbsp;<font color="red">*</font> </label><input type="text" id="email" size="20" /></p>
	<p><label for="identifiant">Identifiant&nbsp;<font color="red">*</font> </label><input type="text" id="identifiant" size="20" /></p>
	<p><label for="password">Mot&nbsp;de&nbsp;passe&nbsp;</label><input type="text" id="password" size="20" /></p>	
	<p><label for="confirmPassword">Confirmation&nbsp;du&nbsp;mot&nbsp;de&nbsp;passe&nbsp;</label><input type="text" id="confirmPassword" size="20" /></p>
	<p>
		<label for="profil">Profil&nbsp;</label>
		<select name="profil">
			<option value="1">ProfilApprenti</option>
			<option value="2">ProfilEnseignant</option>
		</select>
	</p>
<br/>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="submit" value="Créer" alt="Créer une entreprise"/></a></li>
		<li><a href="#"><input type="submit" value="Réinitialiser" alt="Réinitialiser le formulaire"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>
	
