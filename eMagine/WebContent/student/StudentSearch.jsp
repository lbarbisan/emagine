<h2>Recherche d'apprenti</h2>
<br/>
<!-- Un formulaire de recherche -->
<div id="recherche">
	<ul>
		<li>
			<label for="nom">Nom </label><input type="text" id="nom" />
		</li>
		<li>
			<label for="prenom">Pr&eacute;nom </label><input type="text" id="prenom" />
		</li>
		<li>
			<label for="promotion">Promotion </label>
				<select name="promotion">
				<option value="toutes" selected="selected">Toutes</option>
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
			</select>
		</li>
		<li>
		<input type="button" value="Rechercher" />
		</li>
	</ul>
</div>
<br/>
<h2>R&eacute;sultats </h2> 
<br/>
<table width="60%" cellpadding="0" cellspacing="0">
	<tr>
		<th>&nbsp;</th>
		<th>Nom</th>
		<th>Pr&eacute;nom</th>
		<th>Promotion</th>
	</tr>
<tr>
<td><input type="checkbox" /></th>
<td><a href="#">Nom1</a></td>
<td>Pr&eacute;nom1</td>
<td>IR3</td>
</tr>
<tr>
<td><input type="checkbox" /></th>
<td><a href="#">Nom2</a></td>
<td>Pr&eacute;nom2</td>
<td>IR3</td>
</tr>
</table>
<div id="actions">
<ul>
<li><a href="#">Tous</a>/</li>
<li><a href="#">Aucun</a></li>
</ul>
<h2>&nbsp;</h2>
<ul>
<li><a href="#"><img src="images/icones/ajouter.png" alt="Ajouter"/></a></li>
<li><a href="#"><img src="images/icones/supprimer.png" alt="Supprimer"/></a></li>
<li><a href="#"><img src="images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></a></li>
<li><a href="#"><img src="images/icones/mailing.png" alt="Effecter un mailing"/></a></li>
<li><a href="#"><img src="images/icones/publipostage.png" alt="Effecter un publipostage"/></a></li>
</ul>
</div>
</div>
</div>