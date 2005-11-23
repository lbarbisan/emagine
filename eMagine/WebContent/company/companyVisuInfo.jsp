<!-- Un formulaire de modification -->
<div class="form">
	<br/>
	<fieldset>
		<legend>Organisation</legend>
		<p><label for="name">Nom&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="name" size="20" /></p>
		<p><label for="branch">Maison&nbsp;m&egrave;re&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="branch" size="20" /></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Coordonn&eacute;es</legend>
			<p><label for="adress">Adresse <font color="red">*</font> </label><input type="text" id="persAdress" size="20" /></p>
			<p><label for="postalCode">Code&nbsp;postal <font color="red">*</font> </label><input type="text" id="persPostalCode" size="20" /></p>
			<p><label for="city">Ville <font color="red">*</font> </label><input type="text" id="persCity" size="20" /></p>
			<p><label for="department">D&eacute;partement <font color="red">*</font> </label><select name="persDepartment">
					<!-- à mettre en base -->
					<option value="" selected="selected">-- D&eacute;partement --</option>
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select> </p>
			<p><label for="phone">T&eacute;l&eacute;phone&nbsp;fixe </label><input type="text" id="phone" size="20" /></p>	
			<p><label for="fax">Fax </label><input type="text" id="fax" size="20" /></p>
			<p><label for="website">E-mail <font color="red">*</font> </label><input type="text" id="website" size="20" /></p>	
	</fieldset>
	<br/>
</div>
	
