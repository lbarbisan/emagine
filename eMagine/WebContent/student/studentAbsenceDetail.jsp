<h2>Visualiser&nbsp;le&nbsp;d&eacute;tail&nbsp;d'une&nbsp;absence</h2>
<br/>
<form name="results">
	<div class="form">
		<p><label for="initDate">Date&nbsp;d&eacute;but&nbsp;<font color="red">*</font> </label><input type="text" id="initDate" size="20" /></p>
		<p><label for="endDate">Date&nbsp;fin&nbsp;<font color="red">*</font> </label><input type="text" id="endDate" size="20" /></p>
		<p><label for="nbdays">Nombre&nbsp;de&nbsp;jours </label><input type="text" id="nbdays" size="20" /></p>
		<p><label for="justification">Justification </label>
			<select name="justification">
				<option value="M">maladie</option>
				<option value="E">entreprise</option>
				<option value="NJ">non&nbsp;justifi&eacute;</option>
			</select>
		</p>
		<p><label for="comment">Commentaire&nbsp;</label><textarea id="comment"></textarea></p>
	</div>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><input type="button" value="Modifier"/></a></li>
			<li><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer l'absence"/></a></li>
		</ul>
	</div>
</form>
<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>