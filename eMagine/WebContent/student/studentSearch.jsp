<div class="contenu">
<h2>Recherche d'apprenti</h2>
<br/>
<!-- Un formulaire de recherche -->
<div id="search">
	<ul>
		<li>
			<label for="name">Nom </label><input type="text" id="name" />
		</li>
		<li>
			<label for="firstName">Pr&eacute;nom </label><input type="text" id="firstName" />
		</li>
		<li>
			<label for="die">Promotion </label>
			<select name="die">
				<!-- à mettre en base -->
				<option value="all" selected="selected">Toutes</option>
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select>
		</li>
		<li>
			<label for="year">Année </label><input type="text" id="year" />
		</li>
		<li>
			<input type="button" value="Rechercher" />
		</li>
	</ul>
</div>
<br/>
<h2>R&eacute;sultats </h2> 
<br/>
<!-- Un tableau de resultats -->
<table width="60%" cellpadding="0" cellspacing="0">
	<tr>
		<th>&nbsp;</th>
		<th>Nom</th>
		<th>Pr&eacute;nom</th>
		<th>Promotion</th>
	</tr>
	<tr>
		<td><input type="checkbox" /></th>
		<td><a href="#">Barbisan</a></td>
		<td>Laurent</td>
		<td>IR3</td>
	</tr>
	<tr>
		<td><input type="checkbox" /></th>
		<td><a href="#">Ogier</a></td>
		<td>Anthony</td>
		<td>IR3</td>
	</tr>
</table>
<!-- Les actions propres a la selection -->
<div id="actions">
	<ul>
		<li><a href="#">Tous</a> /  </li>
		<li><a href="#">Aucun</a> </li>
	</ul>
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="images/icones/supprimer.png" alt="Supprimer un apprenti"/></a> </li>
		<li><a href="#"><img src="images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></a> </li>
		<li><a href="#"><img src="images/icones/mailing.png" alt="Effecter un mailing"/></a> </li>
		<li><a href="#"><img src="images/icones/publipostage.png" alt="Effecter un publipostage"/></a> </li>
	</ul>
</div>