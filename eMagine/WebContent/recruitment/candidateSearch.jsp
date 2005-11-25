<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Recherche de candidat</h2>
<br/>
<div align="center">
	<div class="search">
		<fieldset>
		<div class="search_b1">
			<p><label for="name">Nom </label><input type="text" id="name" size="20" />  </p>
			<p><label for="firstName">Pr&eacute;nom </label> <input type="text" id="firstName" size="20" /> </p>
		</div>		
		<div class="search_b2">
		<p>
		<label for="die">Fili&egrave;re&nbsp;demand&eacute;e&nbsp;</label>
			<select name="die">
				<!-- � mettre en base -->
				<option value="all" selected="selected">Toutes</option>
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select>
		</p>
		<p><label for="center">Centre&nbsp;examen&nbsp;</label>
			<select name="center">
				<!-- � mettre en base -->
				<option value="all" selected="selected">Tous</option>
				<option value="Paris">Paris</option>
				<option value="Toulouse">Toulouse</option>
				<option value="Bordeaux">Bordeaux</option>
			</select>
		</p>
		</div>
		</fieldset>
		</div>
		<br/>
		<input type="button" value="Rechercher"/>
</div>
<h3>R&eacute;sultats </h3>
<div align=center>
	<div id="statSearch">
	<p>
	<label for="result">R&eacute;sultats </label> <input type="text" id="result" size="5" />&nbsp;&nbsp;&nbsp;
	<label for="pageNb">Nombre par page </label><input type="text" id="pageNb" size="5" /> 
	</p>
	
	</div>
	<form name="results">
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
			<td><input type="checkbox" value="ON"  name="all_none"/></td>
			<td><html:link action="/candidateOnglet">Cadic</html:link></td>
			<td>Yann</td>
			<td>GM</td>
			<td>Paris</td>
			<td>014387544508</td>
			<td>yann.cadic@leneuf.fr</td>
			<td><input type="checkbox" value="ON" checked/></td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON"  name="all_none"/></td>
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
			<li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');">Aucun</a> </li>
		</ul>
		<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/passage.png" alt="passer le candidat en apprenti"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/virer.png" alt="Supprimer le candidat"/></a></li>
		<li><html:link action="/candidateMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></html:link></li>
		<li><html:link action="/candidateEmailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effectuer un mailing"/></html:link></li>
		<li><html:link action="/candidateMailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effectuer un publipostage"/></html:link></li>
		<li><html:link action="/candidateExtract"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire un candidat"/></html:link></li>
	</ul>
	</form>
</div>
