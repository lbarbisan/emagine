<h2>Modifier&nbsp;un&nbsp;courrier&nbsp;type</h2>
<br/>
	<div class="form">
		<p><label for="name">Nom&nbsp;<font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
		<p><label for="file">Fichier&nbsp;<font color="red">*</font> </label><input type="text" id="file" size="20" /><a href="#"><input type="button" value="Parcourir"/></a></p>
		<p><label for="description">Descritpion&nbsp;</label><textarea type="text" id="description" ></textarea></p>
		<p><label for="section">Section&nbsp;<font color="red">*</font>&nbsp;</label>
			<select name="section">
				<!-- � mettre en base -->
				<option value="" selected="selected">-- D&eacute;partement --</option>
				<option value="1">Apprenti</option>
				<option value="2">Entreprise</option>
				<option value="3">Enseignant</option>
				<option value="4">Recrutement</option>
				<option value="5">Courrier</option>
			</select>
		</p>
	</div>
	<fieldset>
		<legend>Champs de l'extraction</legend>
	</fieldset>
	<div id="actions">
		<ul>
			<li><a href="#"><input type="button" value="Modifier"/></a></li>
			<li><a href="#"><input type="button" value="Supprimer"/></a></li>
		</ul>
	</div>
<br/>