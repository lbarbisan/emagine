<!-- Un formulaire de modification -->
<div class="form">
<br/>
	<ul>
		<li>
			<label for="current" style="bold">Adresse courante </label>
			<input type="radio" name="current" value="professional">Personnelle	
			<input type="radio" name="current" value="professional">Professionnelle	
			<input type="radio" name="current" value="academic" checked>Acad&eacute;mique
		</li>
	</ul>
	<br/>
	<fieldset>
		<legend>Adresse&nbsp;personnelle</legend>
			<p><label for="persAdress">Adresse <font color="red">*</font> </label><input type="text" id="persAdress" size="20" /> </p>
			<p><label for="persPostalCode">Code&nbsp;postal <font color="red">*</font> </label><input type="text" id="persPostalCode" size="20" /> </p>	
			<p><label for="persCity">Ville <font color="red">*</font> </label><input type="text" id="persCity" size="20" /> </p>
			<p><label for="persDepartment">D&eacute;partement <font color="red">*</font> </label><select name="persDepartment">
					<!-- à mettre en base -->
					<option value="" selected="selected">-- D&eacute;partement --</option>
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select> </p>
			<p><label for="persPhone">T&eacute;l&eacute;phone&nbsp;fixe </label><input type="text" id="persPhone" size="20" />  </p>	
			<p><label for="persMobile">T&eacute;l&eacute;phone&nbsp;portable </label><input type="text" id="persPhone" size="20" /> 
			<p><label for="persFax">Fax </label><input type="text" id="persFax" size="20" />   	
			<p><label for="persEmail">E-mail <font color="red">*</font> </label><input type="text" id="persEmail" size="20" />    	
	</fieldset>
	<br/>
	<fieldset>
		<legend>Adresse&nbsp;professionnelle</legend>
		<p><label for="profAdress">Adresse <font color="red">*</font> </label><input type="text" id="profAdress" size="20" /></p>
		<p><label for="profPostalCode">Code&nbsp;postal <font color="red">*</font> </label><input type="text" id="profPostalCode" size="20" /></p>
		<p><label for="profCity">Ville <font color="red">*</font> </label><input type="text" id="profCity" size="20" /></p>
		<p><label for="profDepartment">D&eacute;partement <font color="red">*</font> </label>
				<select name="profDepartment">
					<!-- à mettre en base -->
					<option value="" selected="selected">-- D&eacute;partement --</option>
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select></p>
		<p><label for="profPhone">T&eacute;l&eacute;phone&nbsp;fixe </label><input type="text" id="profPhone" size="20" /></p>
		<p><label for="profMobile">T&eacute;l&eacute;phone&nbsp;portable </label><input type="text" id="profMobile" size="20" /></p>
		<p><label for="profFax">Fax </label><input type="text" id="profFax" size="20" /></p>
		<p><label for="profEmail">E-mail <font color="red">*</font> </label><input type="text" id="profEmail" size="20" /></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Adresse&nbsp;acad&eacute;mique</legend>
		<p><label for="acaAdress">Adresse <font color="red">*</font> </label><input type="text" id="acaAdress" size="20" /></p>
		<p><label for="acaPostalCode">Code&nbsp;postal <font color="red">*</font> </label><input type="text" id="acaPostalCode" size="20" /></p>
		<p><label for="acaCity">Ville <font color="red">*</font> </label><input type="text" id="acaCity" size="20" /></p>
		<p><label for="acaDepartment">D&eacute;partement <font color="red">*</font> </label>
				<select name="acaDepartment">
					<!-- à mettre en base -->
						<option value="" selected="selected">-- D&eacute;partement --</option>
						<option value="93">93</option>
						<option value="77">77</option>
						<option value="78">78</option>
					</select></p>
		<p><label for="acaPhone">T&eacute;l&eacute;phone&nbsp;fixe </label><input type="text" id="acaPhone" size="20" /></p>
		<p><label for="acaMobile">T&eacute;l&eacute;phone&nbsp;portable </label><input type="text" id="acaMobile" size="20" /></p>
		<p><label for="acaFax">Fax </label><input type="text" id="acaFax" size="20" /></p>
		<p><label for="acaEmail">E-mail <font color="red">*</font> </label><input type="text" id="acaEmail" size="20" /></p>
	</fieldset>
	<br/>
</div>
	
