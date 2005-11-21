<!-- Un formulaire de modification -->
<div id="search">
	<fieldset>
		<legend>Identification</legend>
		<ul>
			<li>
				<label for="name">Nom </label>
            	<input type="text" id="name" size="20" /> 
			</li>
		</ul>
		<ul>
			<li>
				<label for="firstName">Pr&eacute;nom </label>
           		<input type="text" id="firstName" size="20" /> 
			</li>
		</ul>
		<ul>
			<li>
				<label for="sex">Sexe </label>
				<input type="radio" name="sex" value="male">femme	
				<input type="radio" name="sex" value="female" checked>homme
			</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend>Naissance </legend>
		<ul>
			<li>
				<label for="date">Date </label>
            	<input type="text" id="date" size="20" /> 
			</li>
		</ul>
		<ul>
			<li>
				<label for="city">Ville </label>
            	<input type="text" id="city" size="20" /> 
			</li>
		</ul>
		<ul>
			<li>
				<label for="department">D&eacute;partement </label>
            	<input type="text" id="department" size="20" />
			</li>
		</ul>
		<ul>
			<li>
				<label for="country">Pays </label>
            	<input type="text" id="country" size="20" />
			</li>
		</ul>
		<ul>
			<li>
				<label for="nationality">Nationalit&eacute; </label>
            	<input type="text" id="nationality" size="20" />
			</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend>Profession&nbsp;des&nbsp;parents</legend>
		<ul>
			<li>
				<label for="father">P&egrave;re </label>
            	<input type="text" id="father" size="20" /> 
			</li>
		</ul>
		<ul>
			<li>
				<label for="mother">M&egrave;re </label>
            	<input type="text" id="mother" size="20" /> 
			</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend>Origine&nbsp;du&nbsp;contact</legend>
		<ul>
			<li>
				<label for="contact">Contact </label>
				<select name="contact">
					<!-- à mettre en base -->
					<option value="all" selected="selected">Tous</option>
					<option value="jpo">JPO</option>
					<option value="internet">Internet</option>
					<option value="other">Autres</option>
				</select>
			</li>
		</ul>
	</fieldset>
	<br/>
</div>