<br/>
<div id="search">
	<ul>
		<li>
			<label for="initDate">Date&nbsp;d&eacute;but </label>
			<input type="text" id="initDate" size="20" /> 
		</li>
		<li>
			<label for="endDate">Date&nbsp;fin </label>
			<input type="text" id="endDate" size="20" /> 
		</li>
	</ul>
	<ul>
		<li>
			<label for="type">Type </label>
			<select name="type">
				<!-- à mettre en base -->
				<option value="all" selected="selected">Tous</option>
				<option value="email">email</option>
				<option value="mail">courrier</option>
				<option value="tutor">tutelle</option>
			</select>
		</li>
		<li>
			<input type="button" value="Rechercher"/>
		</li>
	</ul>
</div>
<br/>
<h2>Ev&eacute;nements </h2> 
<br/>
	<div id="statSearch">
		<ul>
			<li>
				<label for="result">R&eacute;sulats </label>
				<input type="text" id="result" size="5" />
			</li>
			<li>
				<label for="pageNb">Nombre par page </label>
				<input type="text" id="pageNb" size="5" /> 
			</li>
		</ul>
	</div>
<br/>
<!-- Un tableau de resultats -->
<table width="60%" cellpadding="0" cellspacing="0">
	<tr>
		<th>&nbsp;</th>
		<th>Date</th>
		<th>Ev&eacute;nements</th>
		<th>Commentaire</th>
	</tr>
	<tr>
		<td><input type="checkbox" value="ON" /></td>
		<td><a href="#">12.10.2005</a></td>
		<td>envoi mail</td>
		<td>pour les jpo</td>
	</tr>
	<tr>
		<td><input type="checkbox" value="ON" /></td>
		<td><a href="#">13.10.2005</a></td>
		<td>tutelle</td>
		<td>changement&nbsp;de&nbsp;tuteur&nbsp;enseignant</td>
	</tr>
</table>
<!-- Les actions propres a la selection -->
<div id="actions">
	<ul>
		<li><a href="#">Tous</a> / </li>
		<li><a href="#">Aucun</a> </li>
	</ul>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="supprimer un événement"/></a></li>
	</ul>
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire un événement"/></a></li>
	</ul>
</div>
