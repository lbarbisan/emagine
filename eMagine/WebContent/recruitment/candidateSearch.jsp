<h2>Recherche d'apprenti</h2>
<br/>
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
	</ul>
	<ul>
		<li>
			<label for="die">Fili&egrave;re&nbsp;demand&eacute;</label>
			<select name="die">
				<!-- à mettre en base -->
				<option value="all" selected="selected">Toutes</option>
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select>
		</li>
		<li>
			<label for="center">Centre&nbsp;examen&nbsp;</label>
			<select name="center">
				<!-- à mettre en base -->
				<option value="all" selected="selected">Toutes</option>
				<option value="Paris">Paris</option>
				<option value="Toulouse">Toulouse</option>
				<option value="Bordeaux">Bordeaux</option>
			</select>
		</li>	
		<li>
			<input type="button" value="Rechercher"/>
		</li>
	</ul>
</div>
<br/>
<h2>R&eacute;sultats </h2>
<div align=center>
	<div id="statSearch">
	<p>
	<label for="result">R&eacute;sulats </label> <input type="text" id="result" size="5" />&nbsp;&nbsp;&nbsp;
	<label for="pageNb">Nombre par page </label><input type="text" id="pageNb" size="5" /> 
	</p>
	
	</div>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>Nom</th>
			<th>Pr&eacute;nom</th>
			<th>Fili&egrave;re</th>
			<th>Centre</th>
			<th>T&eacute;l&eacute;phone</th>
			<th>E-mail</th>
			<th>Admissible</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/candidateOnglet">Cadic</html:link></td>
			<td>Yann</td>
			<td>GM</td>
			<td>Paris</td>
			<td>014387544508</td>
			<td>yann.cadic@leneuf.fr</td>
			<td><input type="checkbox" value="ON" checked/></td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/candidateOnglet">Dumoleyn</html:link></td>
			<td>Delphine</td>
			<td>EI</td>
			<td>Paris</td>
			<td>011045632211</td>
			<td>delphine.dumoleyn@wanadoo.fr</td>
			<td><input type="checkbox" value="ON" checked/></td>
		</tr>
</table>
</div>
<!-- Les actions propres a la selection -->
<div id="actions">
	<ul>
		<li><a href="#">Tous</a> / </li>
		<li><a href="#">Aucun</a> </li>
	</ul>
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/passage.png" alt="passer le candidat en apprenti"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/virer.png" alt="Supprimer le candidat"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/mailing.png" alt="Effecter un mailing"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/publipostage.png" alt="Effecter un publipostage"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire un apprenti"/></a></li>
	</ul>
</div>
