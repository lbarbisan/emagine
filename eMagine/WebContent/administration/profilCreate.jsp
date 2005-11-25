<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Cr&eacute;er&nbsp;un&nbsp;profil</h2>
<br/>
<div class="form">
	<p><label for="name">Nom&nbsp;</label><input type="text" id="name" size="20" /></p>
	<br/>
	<fieldset>
		<p><label for="administration">Administration&nbsp;</label>
		<input type="checkbox" value="ON" name="administration" /></p>
		<p><label for="absence">Absence&nbsp;</label>
		<input type="checkbox" value="ON" name="absence" /></p>
		<p><label for="student">Apprenti&nbsp;</label>
		<input type="checkbox" value="ON" name="student" /></p>
		<p><label for="teacher">Enseignant&nbsp;</label>
		<input type="checkbox" value="ON" name="teacher" /></p>
		<p><label for="recruitment">Recrutement&nbsp;</label>
		<input type="checkbox" value="ON" name="recruitment" /></p>
		<p><label for="statistics">Statistique&nbsp;</label>
		<input type="checkbox" value="ON" name="statistics" /></p>
	</fieldset>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="submit" value="Modifier" title="Modifier le profil"/></a></li>
		<li><a href="#"><input type="submit" value="Supprimer" title="Supprimer le profil"/></a></li>
	</ul>
</div>
<br/>
<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>