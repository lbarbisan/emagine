<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<!-- Un formulaire de modification -->
<div class="form">
	<br/>
	<fieldset>
		<legend>Promotion </legend>
		<p><label for="die">Fili&egrave;re <font color="red">*</font> </label>
			<select name="die">
			<!-- mettre en base, pas de valeur par défaut, elle sera sélectionnée selon l'apprenti concerné -->
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select></p>
		<p><label for="year">Ann&eacute;e <font color="red">*</font> </label>
			<select name="year">
				<!-- mettre en base, pas de valeur par défaut, elle sera sélectionnée selon l'apprenti concerné -->
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select></p>
		<p><label for="section">Groupe <font color="red">*</font> </label>
			<select name="section">
				<!-- mettre en base, pas de valeur par défaut, elle sera sélectionnée selon l'apprenti concerné -->
				<option value="1">groupe&nbsp;1</option>
				<option value="2">groupe&nbsp;2</option>
			</select></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Entreprise </legend>
		<p><label for="companyName">Nom <font color="red">*</font> </label><input type="text" id="companyName" size="20" />
			<html:link action="/studentCompanyAdd"><input type="button" name="companyButton" value="Affecter"/></html:link></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Tutelle </legend>
		<p><label for="engineTutor">Tuteur ing&eacute;nieur <font color="red">*</font> </label>
			<select name="engineTutor">
				<!--données de la mettre en base selon l'entreprise concernée -->
				<option value="1">Mr&nbsp;tuteur&nbsp;1</option>
				<option value="2">Mr&nbsp;tuteur&nbsp;2</option>
			</select></p>
		<p><label for="teacherTutor">Tuteur enseignant <font color="red">*</font> </label><input type="text" id="teacherTutor" size="20" />
		<html:link action="/studentTutorAdd"><input type="button" name="teacherButton" value="Affecter"/></html:link></p>
	</fieldset> 
<br/>           
</div>

