<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>D&eacute;d'un&nbsp;profil</h2>
<br/>
<div class="form">
	<p><label for="name">Nom&nbsp;</label><input type="text" id="name" size="20" /></p>
	<br/>
		<fieldset>
		<p><label for="administration">Nom&nbsp;</label>
		<input type="checkbox" value="ON" name="administration" /></p>
		<p><label for="absence">Pr&eacute;nom&nbsp;</label>
		<input type="checkbox" value="ON" name="absence" /></p>
		<p><label for="student">Fonction&nbsp;</label>
		<input type="checkbox" value="ON" name="student" /></p>
		<p><label for="teacher">Adresse&nbsp;</label>
		<input type="checkbox" value="ON" name="teacher" /></p>
		<p><label for="recruitment">Code&nbsp;postal&nbsp;</label>
		<input type="checkbox" value="ON" name="recruitment" /></p>
		<p><label for="statistics">Ville&nbsp;</label>
		<input type="checkbox" value="ON" name="statistics" /></p>
	</fieldset>
</div>
<div id="actions" align="center">
	<ul>
		<li><a href="#"><input type="submit" value="Modifier" title="Modifier le profil"/></a></li>
		<li><a href="#"><input type="submit" value="Supprimer" title="Supprimer le profil"/></a></li>
	</ul>
</div>
<br/>