<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Rechercher&nbsp;une&nbsp;absence</h2>
<br/>
<div align="center">
	<div class="search">
		<fieldset>
			<div class="search_b1">
				<p>
					<label for="initDate">Date&nbsp;d&eacute;but&nbsp;</label>
					<input type="text" id="initDate" size="20" /> 
				</p>
				<p>
					<label for="endDate">Date&nbsp;fin&nbsp;</label>
					<input type="text" id="endDate" size="20" /> 
				</p>
			</div>
			<div class="search_b2">
				<p>
					<label for="justification">Justification&nbsp;</label>
					<select name="justification">
						<!-- à mettre en base -->
						<option value="all" selected="selected">Toutes</option>
						<option value="M">maladie</option>
						<option value="E">entreprise</option>
						<option value="NJ">non&nbsp;justifi&eacute;</option>
					</select>
				</p>
			</div>
		</fieldset>
	</div>
	<br/>
	<input type="button" value="Rechercher"/>
</div>
<form name="results">
	<h3>R&eacute;sultats</h3>
	<div align=center>
		<div id="statSearch">
			<p><label for="result">R&eacute;sultats&nbsp;</label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb">Nb.&nbsp;par&nbsp;page&nbsp;</label><input type="text" id="pageNb" size="5" /></p>
		</div>
		<p align="left"><label for="total">Nb.&nbsp;total&nbsp;</label>
		<input type="text" id="total" size="20" /></p> 
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>Date&nbsp;début</th>
				<th>Date&nbsp;fin</th>
				<th>Nb.&nbsp;de&nbsp;jours</th>
				<th>Justification</th>
				<th>Commentaire</th>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none"/></td>
				<td><html:link action="/studentAbsenceDetail">12.10.2005</html:link></td>
				<td>12.10.2005</td>
				<td>0.5</td>
				<td>NJ</td>
				<td>pas bien pas de justification</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON" name="all_none"/></td>
				<td><html:link action="/studentAbsenceDetail">21.12.2005</html:link></td>
				<td>24.12.2005</td>
				<td>3</td>
				<td>M</td>
				<td>oula très malade!!</td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');">Aucun</a> </li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer une(des) absence(s)"/></a></li>
			<li><html:link action="/studentAbsenceExtract"><img src="/eMagine/common/images/icones/extraire.png" title="Extraire des absences"/></html:link></li>
			<li><html:link action="/studentAbsenceAdd"><img src="/eMagine/common/images/icones/ajouter.png" title="Ajouter une absence"/></html:link></li>
		</ul>
	</div>
</form>