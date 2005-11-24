<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<div class="form">
	<br/>
	<fieldset>
		<legend>Promotion</legend>
		<p><label for="die">Fili&egrave;re&nbsp;</label>
			<select name="die">
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select></p>
		<p><label for="year">Ann&eacute;e&nbsp;</label>
			<select name="year">
				<!-- mettre en base, pas de valeur par défaut, elle sera sélectionnée selon l'apprenti concerné -->
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select></p>
		<p><label for="group">Groupe&nbsp;</label>
			<select name="group">
				<!-- mettre en base, pas de valeur par défaut, elle sera sélectionnée selon l'apprenti concerné -->
				<option value="1">groupe&nbsp;1</option>
				<option value="2">groupe&nbsp;2</option>
			</select></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Entreprise</legend>
		<p><label for="companyName">Nom&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="companyName" size="20" />
			<html:link action="/studentCompanyAdd"><input type="button" name="companyButton" value="Affecter"  title="Affecter une entreprise"/></html:link></p>
	</fieldset>
	<br/>
	<fieldset>
		<legend>Tutelle</legend>
		<p><label for="engineTutor">Tuteur ing&eacute;nieur&nbsp;<font color="red">*</font> </label>
			<select name="engineTutor">
				<!--données de la mettre en base selon l'entreprise concernée -->
				<option value="1">Mr&nbsp;tuteur&nbsp;1</option>
				<option value="2">Mr&nbsp;tuteur&nbsp;2</option>
			</select></p>
		<p><label for="teacherTutor">Tuteur&nbsp;enseignant&nbsp;<font color="red">*</font>&nbsp;</label><input type="text" id="teacherTutor" size="20" />
		<html:link action="/studentTutorAdd"><input type="button" name="teacherButton" value="Affecter" title="Affecter un tuteur enseignant"/></html:link></p>
	</fieldset> 
<br/>           
</div>
<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>

