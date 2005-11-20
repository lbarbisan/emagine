<div class="content">
<h2>Affecter un tuteur enseignant</h2>
<br/>
	<!-- Un formulaire d'affectation -->
	<div id="search">
		<ul>
			<li>
				<label for="name">Nom </label>
				<input type="text" id="name" size="20" /> 
			</li>
			<li>
				<label for="firstName">Pr&eacute;nom </label>
				<input type="text" id="firstName" size="20" /> 
			</li>
			<li>
				<input type="button" value="Rechercher"/>
			</li>
		</ul>
	</div>
	<br/>
	<h2>Tuteurs enseignants </h2> 
	<br/>
	<div class="statSearch">
		<ul>
			<li>
				<label for="pageNb">Nombre de pages </label>
				<input type="text" id="pageNb" size="5" /> 
			</li>
			<li>
				<label for="result">R&eacute;sulats </label>
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
			<td><input type="checkbox" value="ON" /></td>
			<td><a href="#">Forax</a></td>
			<td>R&eacute;mi</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><a href="#">Revuz</a></td>
			<td>Dominique</td>
		</tr>
	</table>
	<br/>
	<div id="actions">
		<ul>
			<li>
				<input type="button" value="Affecter"/>
			</li>
		</ul>
	</div>
	<br/>
</div>