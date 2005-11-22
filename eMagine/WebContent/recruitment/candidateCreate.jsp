<h2>Cr&eacute;ation&nbsp;de&nbsp;candidat</h2>
<br/>
<div class="form">
	<fieldset>
		<legend>Etat&nbsp;civil</legend>
		<p><label for="name">Nom <font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
		<p><label for="firstName">Pr&eacute;nom <font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
		<p><label for="sex">Sexe </label><input type="radio" name="sex" value="male">femme<input type="radio" name="sex" value="female" checked>homme</p>
		<p><label for="date">Date <font color="red">*</font> </label><input type="text" id="date" size="20" /></p>
		<p><label for="city">Ville </label><input type="text" id="city" size="20" /></p>
		<p><label for="department">D&eacute;partement</label><input type="text" id="department" size="20" /></p>
		<p><label for="country">Pays </label><input type="text" id="country" size="20" /></p>
		<p><label for="nationality">Nationalit&eacute; <font color="red">*</font> </label><input type="text" id="nationality" size="20" /></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Adresse</legend>
			<p><label for="persAdress">Adresse <font color="red">*</font> </label><input type="text" id="persAdress" size="20" /></p>
			<p><label for="persPostalCode">Code&nbsp;postal <font color="red">*</font> </label><input type="text" id="persPostalCode" size="20" /></p>
			<p><label for="persCity">Ville <font color="red">*</font> </label><input type="text" id="persCity" size="20" /></p>
			<p><label for="persDepartment">D&eacute;partement <font color="red">*</font> </label><select name="persDepartment">
					<!-- à mettre en base -->
					<option value="" selected="selected">-- D&eacute;partement --</option>
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select> </p>
			<p><label for="persPhone">T&eacute;l&eacute;phone&nbsp;fixe </label><input type="text" id="persPhone" size="20" /></p>	
			<p><label for="persMobile">T&eacute;l&eacute;phone&nbsp;portable </label><input type="text" id="persMobile" size="20" /></p>
			<p><label for="persFax">Fax </label><input type="text" id="persFax" size="20" /></p>
			<p><label for="persEmail">E-mail <font color="red">*</font> </label><input type="text" id="persEmail" size="20" /></p>	
	</fieldset>
	<br/>
	<fieldset>
		<legend>Etudes</legend>
		<p><label for="die">Fili&egrave;re&nbsp;demand&eacute;</label>
			<select name="die">
				<!-- à mettre en base -->
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select>
		</p>
		<h2>&nbsp;</h2>
		<p><label for="langage1">Langue 1 </label><input type="text" id="langage1" size="20" /> </p>
		<p><label for="langage2">Langue 2 </label><input type="text" id="langage2" size="20" /> </p>
		<p><label for="level">Niveau&nbsp;scolaire</label>
			<input type="radio" name="level" checked/>bac 
			<input type="radio" name="level" />+2
			<input type="radio" name="level" />+3
		</p>
		<h2>&nbsp;</h2>
		<p><label for="diploma">Dernier&nbsp;diplôme</label>
			<select name="diploma">
				<!-- à mettre en base -->
				<option value="bac">bac</option>
				<option selected value="dut">dut</option>
				<option value="licence">licence</option>
				<option value="maîtrise">maîtrise</option>
			</select>
		</p>
		<!-- change selon le denier diplome -->
		<p><label for="section">Section</label>
			<select name="section">
				<!-- à mettre en base -->
				<option value="I">Informatique</option>
				<option value="GEII">Génie Electrique</option>
			</select>
		</p>
		<h2>&nbsp;</h2>
				<p><label for="center">Centre&nbsp;examen</label>
				<select name="center">
					<!-- à mettre en base -->
					<option value="Paris">Paris</option>
					<option value="Toulouse">Toulouse</option>
					<option value="Bordeaux">Bordeaux</option>
				</select></p>
			<p><label for="formation">Autres formation&nbsp;?&nbsp;</label><input type="checkbox" value="ON" /></p>
			<p><label for="admissibility">Admissible&nbsp;?&nbsp;</label><input type="checkbox" value="ON" /></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Origine&nbsp;du&nbsp;contact</legend>
		<p><label for="contact">Contact </label>
			<select name="contact">
				<!-- à mettre en base -->
				<option value="jpo">JPO</option>
				<option value="internet">Internet</option>
				<option value="other">Autres</option>
			</select></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Profession&nbsp;des&nbsp;parents</legend>
		<p><label for="father">P&egrave;re </label><input type="text" id="father" size="20" /></p>
		<p><label for="mother">M&egrave;re </label><input type="text" id="mother" size="20" /></p>
	</fieldset>
	<br/>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/ajouter.png" alt="Créer"/></a> </li>
	</ul>
</div>
