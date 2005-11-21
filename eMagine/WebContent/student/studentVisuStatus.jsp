<div class="form">
	<fieldset>
		<legend>Identification</legend>
		<p><label for="name">Nom <font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
		<p><label for="firstName">Pr&eacute;nom <font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
		<p><label for="sex">Sexe </label><input type="radio" name="sex" value="male">femme<input type="radio" name="sex" value="female" checked>homme</p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Naissance</legend>
		<p><label for="date">Date <font color="red">*</font> </label><input type="text" id="date" size="20" /></p>
		<p><label for="city">Ville </label><input type="text" id="city" size="20" /></p>
		<p><label for="department">D&eacute;partement</label><input type="text" id="department" size="20" /></p>
		<p><label for="country">Pays </label><input type="text" id="country" size="20" /></p>
		<p><label for="nationality">Nationalit&eacute; <font color="red">*</font> </label><input type="text" id="nationality" size="20" /></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Profession&nbsp;des&nbsp;parents</legend>
		<p><label for="father">P&egrave;re </label><input type="text" id="father" size="20" /></p>
		<p><label for="mother">M&egrave;re </label><input type="text" id="mother" size="20" /></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Origine&nbsp;du&nbsp;contact</legend>
		<p><label for="contact">Contact </label>
			<select name="contact">
				<!-- à mettre en base -->
				<option value="all" selected="selected">Tous</option>
				<option value="jpo">JPO</option>
				<option value="internet">Internet</option>
				<option value="other">Autres</option>
			</select></p>
	</fieldset>
	<br/>
</div>