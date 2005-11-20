<div class="content">
	<!-- Un formulaire de modification -->
	<div id="search">
		<br/>
		<fieldset>
			<legend>Promotion </legend>
			<ul>
				<li>
					<label for="die">Fili&egrave;re * </label>
					<select name="die">
					<!-- mettre en base, pas de valeur par défaut, elle sera sélectionnée selon l'apprenti concerné -->
						<option value="ir">IR</option>
						<option value="mfpi">MFPI</option>
						<option value="gmu">GMU</option>
					</select>
				</li>
				<li>
					<label for="year">Ann&eacute;e *</label>
					<select name="year">
						<!-- mettre en base, pas de valeur par défaut, elle sera sélectionnée selon l'apprenti concerné -->
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</li>
				<li>
					<label for="section">Groupe * </label>
					<select name="section">
						<!-- mettre en base, pas de valeur par défaut, elle sera sélectionnée selon l'apprenti concerné -->
						<option value="1">groupe&nbsp;1</option>
						<option value="2">groupe&nbsp;2</option>
					</select>
				</li>				
			</ul>
		</fieldset>
		<br/>
		<fieldset>
			<legend>Entreprise </legend>
			<ul>
				<li>
					<label for="companyName">Nom </label>
	            	<input type="text" id="companyName" size="20" /> 
				</li>
				<li>
					<input type="button" name="companyButton" value="Affecter"/>
				</li>
			</ul>
		</fieldset>
		<br/>
		<fieldset>
			<legend>Tutelle </legend>
			<ul>
				<li>
					<label for="engineTutor">Tuteur ing&eacute;nieur </label>
					<select name="engineTutor">
						<!--données de la mettre en base selon l'entreprise concernée -->
					</select>				
				</li>
			</ul>
			<ul>
				<li>
					<label for="teacherTutor">Tuteur enseignant </label>
	            	<input type="text" id="teacherTutor" size="20" /> 
				</li>
				<li>
					<input type="button" name="teacherButton" value="Affecter"/>
				</li>
			</ul>
		</fieldset> 
		<br/>           
	</div>
</div>
