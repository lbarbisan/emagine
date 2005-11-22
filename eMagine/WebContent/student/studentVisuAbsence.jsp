<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<br/>
<div id="search">
<h2>Filtre</h2>
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
			<label for="justification">Justification </label>
			<select name="justification">
				<!-- � mettre en base -->
				<option value="all" selected="selected">Tous</option>
				<option value="M">maladie</option>
				<option value="E">entreprise</option>
				<option value="NJ">non&nbsp;justifi&eacute;</option>
			</select>
		</li>
		<li>
			<input type="button" value="Rechercher"/>
		</li>
	</ul>
</div>
<br/>
<h2>Absences </h2> 
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
		<th>Date&nbsp;d�but</th>
		<th>Date&nbsp;fin</th>
		<th>Nb.&nbsp;de&nbsp;jours</th>
		<th>Justification</th>
		<th>Commentaire</th>
	</tr>
	<tr>
		<td><input type="checkbox" value="ON" /></td>
		<td><html:link action="/studentAbsenceModif">12.10.2005</html:link></td>
		<td>12.10.2005</td>
		<td>0.5</td>
		<td>NJ</td>
		<td>pas bien pas de justification</td>
	</tr>
	<tr>
		<td><input type="checkbox" value="ON" /></td>
		<td><a href="#">21.12.2005</a></td>
		<td>24.12.2005</td>
		<td>3</td>
		<td>M</td>
		<td>oula tr�s malade!!</td>
	</tr>
</table>
<!-- Les actions propres a la selection -->
<div id="actions">
	<ul>
		<li><a href="#">Tous</a> / </li>
		<li><a href="#">Aucun</a> </li>
	</ul>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer une(des) absence(s)"/></a></li>
	</ul>
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire des absences"/></a></li>
		<li><html:link action="/studentAbsenceAdd"><img src="/eMagine/common/images/icones/ajouter.png" alt="Ajouter une absence"/></html:link></li>
	</ul>
	<h2>&nbsp;</h2>
	<br/>
	<p><label for="total">Nombre&nbsp;total&nbsp;d&quote;absence </label>
		<input type="text" id="total" size="20" /></p> 
</div>