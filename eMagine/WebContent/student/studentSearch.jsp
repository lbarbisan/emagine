<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Recherche d'apprenti</h2>
<br/>
<div align="center">
	<div class="search">
		<fieldset>
		<div class="search_b1">
			<p><label for="name">Nom </label> <input type="text" id="name" size="20" /> </p>
			<p><label for="firstName">Pr&eacute;nom </label> <input type="text" id="firstName" size="20" /> </p>
		</div>
		
		<div class="search_b2">
		<p>
		<label for="die">Fili&egrave;re </label>
			<select name="die">
				<option value="all" selected="selected">Toutes</option>
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select>
		</p>
		<p><label for="year">Ann&eacute;e</label>
			<select name="year">
				<option value="all" selected="selected">Toutes</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
		</p>
		</div>
		</fieldset>
		</div>
		<br/>
		<input type="button" value="Rechercher"/>
</div>
		<h2>R&eacute;sultats </h2> 
		
		<!-- Un tableau de resultats -->
		<div align=center>
			<div id="statSearch">
			<p>
			<label for="result">R&eacute;sulats </label> <input type="text" id="result" size="5" />&nbsp;&nbsp;&nbsp;
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
					<th>Ann&eacute;e</th>
				</tr>
				<tr>
					<td><input type="checkbox" value="ON" name="all_none" /></td>
					<td><html:link action="/studentOnglet">Barbisan</html:link></td>
					<td>Laurent</td>
					<td>IR</td>
					<td>3</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="ON" name="all_none" /></td>
					<td><html:link action="/studentOnglet">Ogier</html:link></td>
					<td>Anthony</td>
					<td>IR</td>
					<td>3</td>
				</tr>
			</table>
		</div>
		<!-- Les actions propres a la selection -->
		<div id="actions">
		<a name="all_none" />
			<ul>
				<li><a href="#all_none" onclick="checkAll('results','all_none');">Tous</a> / </li>
				<li><a href="#all_none" onclick="checkNothing('results','all_none');">Aucun</a> </li>
			</ul>
			<h2>&nbsp;</h2>
			<ul>
				<li><a href="#"><img src="/eMagine/common/images/icones/passage.png" alt="Faire passer un apprenti"/></a></li>
				<li><a href="#"><img src="/eMagine/common/images/icones/virer.png" alt="Exclure un apprenti"/></a></li>
				<li><a href="#"><img src="/eMagine/common/images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></a></li>
				<li><a href="#"><img src="/eMagine/common/images/icones/mailing.png" alt="Effecter un mailing"/></a></li>
				<li><a href="#"><img src="/eMagine/common/images/icones/publipostage.png" alt="Effecter un publipostage"/></a></li>
				<li><html:link action="/studentExtract"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire un apprenti"/></html:link></li>
			</ul>
		</form>
</div>
