<h2>Affecter un tuteur enseignant</h2>
<br/>
<!-- Un formulaire d'affectation -->
<div class="search">
	<p>
		<label for="name">Nom </label><input type="text" id="name" size="20" />
		<label for="firstName">Pr&eacute;nom </label><input type="text" id="firstName" size="20" /> 
		<input type="button" value="Rechercher"/> 
	</p>
</div>
<h2>Tuteurs enseignants </h2> 
<div align="center">
<div id="statSearch">
	<ul>
		<li>
			<label for="result">R&eacute;sulats </label>
			<input type="text" id="pageNb" size="5" /> 
		</li>
		<li>
			<label for="pageNb">Nombre par pages </label>
			<input type="text" id="result" size="5" /> 
		</li>
	</ul>
</div>
<br/>
<!-- Un tableau de resultats -->
<table width="60%" cellpadding="0" cellspacing="0">
	<tr>
		<th>&nbsp;</th>
		<th>Nom</th>
		<th>Pr&eacute;nom</th>
	</tr>
	<tr>
		<td><input type="radio" name="radio"  /></td>
		<td><a href="/eMagine/teacherOnglet.do">Forax</a></td>
		<td>R&eacute;mi</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio"  /></td>
		<td><a href="/eMagine/teacherOnglet.do">Revuz</a></td>
		<td>Dominique</td>
	</tr>
</table>
</div>
<br/>
<div id="actions">
	<ul>
		<li>
			<input type="button" value="Affecter"/>
		</li>
	</ul>
</div>
<br/>