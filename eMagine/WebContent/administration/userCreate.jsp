<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<div class="form">
	<br/>
	<fieldset>
		<legend>Coordonn&eacute;es</legend>
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
	</fieldset>
	<br/>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="submit" value="Créer" alt="Créer une entreprise"/></a></li>
		<li><a href="#"><input type="submit" value="Réinitialiser" alt="Réinitialiser le formulaire"/></a></li>
	</ul>
</div>
	
