<h2>Visualiser&nbsp;une&nbsp;demande&nbsp;de&nbsp;modification</h2>
<form name="results">
	<div class="form">
		<br/>
		<p>
			<label for="current" style="bold">Adresse&nbsp;courante&nbsp;</label>
			<input type="radio" name="current" value="personnal">Personnelle	
			<input type="radio" name="current" value="professional">Professionnelle	
			<input type="radio" name="current" value="academic" checked>Acad&eacute;mique
		</p>
		<br/>
		<fieldset>
			<legend>Adresse&nbsp;personnelle</legend>
				<p><label for="persAdress">Adresse&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="persAdress" size="20" /><font color="red">ca&nbsp;a&nbsp;changé&nbsp;</font><input type="submit" name="bPersAdress"/></p>
				<p><label for="persPostalCode">Code&nbsp;postal&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="persPostalCode" size="20" /></p>
				<p><label for="persCity">Ville&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="persCity" size="20" /></p>
				<p><label for="persDepartment">D&eacute;partement&nbsp;</label>
					<select name="persDepartment">
						<option value="93">93</option>
						<option value="77">77</option>
						<option value="78">78</option>
					</select>
				</p>
				<p><label for="persPhone">T&eacute;l&eacute;phone&nbsp;fixe&nbsp;</label><input type="text" id="persPhone" size="20" /></p>	
				<p><label for="persMobile">T&eacute;l&eacute;phone&nbsp;portable&nbsp;</label><input type="text" id="persMobile" size="20" /></p>
				<p><label for="persFax">Fax&nbsp;</label><input type="text" id="persFax" size="20" /></p>
				<p><label for="persEmail">E-mail&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="persEmail" size="20" /></p>	
		</fieldset>
		<br/>
		<fieldset>
			<legend>Adresse&nbsp;professionnelle</legend>
			<p><label for="profAdress">Adresse&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="profAdress" size="20" /></p>
			<p><label for="profPostalCode">Code&nbsp;postal&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="profPostalCode" size="20" /></p>
			<p><label for="profCity">Ville&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="profCity" size="20" /></p>
			<p><label for="profDepartment">D&eacute;partement</label>
					<select name="profDepartment">
						<option value="93">93</option>
						<option value="77">77</option>
						<option value="78">78</option>
					</select></p>
			<p><label for="profPhone">T&eacute;l&eacute;phone&nbsp;fixe&nbsp;</label><input type="text" id="profPhone" size="20" /></p>
			<p><label for="profMobile">T&eacute;l&eacute;phone&nbsp;portable&nbsp;</label><input type="text" id="profMobile" size="20" /></p>
			<p><label for="profFax">Fax&nbsp;</label><input type="text" id="profFax" size="20" /></p>
			<p><label for="profEmail">E-mail&nbsp;<font color="red">*</font> </label><input type="text" id="profEmail" size="20" /></p>
		</fieldset>
		<br/>
		<fieldset>
			<legend>Adresse&nbsp;acad&eacute;mique</legend>
			<p><label for="acaAdress">Adresse&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="acaAdress" size="20" /></p>
			<p><label for="acaPostalCode">Code&nbsp;postal&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="acaPostalCode" size="20" /></p>
			<p><label for="acaCity">Ville&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="acaCity" size="20" /></p>
			<p><label for="acaDepartment">D&eacute;partement&nbsp;</label>
					<select name="acaDepartment">
							<option value="93">93</option>
							<option value="77">77</option>
							<option value="78">78</option>
						</select></p>
			<p><label for="acaPhone">T&eacute;l&eacute;phone&nbsp;fixe&nbsp;</label><input type="text" id="acaPhone" size="20" /></p>
			<p><label for="acaMobile">T&eacute;l&eacute;phone&nbsp;portable&nbsp;</label><input type="text" id="acaMobile" size="20" /></p>
			<p><label for="acaFax">Fax&nbsp;</label><input type="text" id="acaFax" size="20" /></p>
			<p><label for="acaEmail">E-mail&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="acaEmail" size="20" /></p>
		</fieldset>
		<br/>
	</div>
		<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><input type="submit" value="Accepter"></a></li>
			<li><a href="#"><input type="submit" value="Accepter partiellement"></a></li>
			<li><a href="#"><input type="submit" value="Refuser"></a></li>
		</ul>
	</div>
</form>
<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>