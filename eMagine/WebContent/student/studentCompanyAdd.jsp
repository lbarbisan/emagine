<h2>Affecter&nbsp;une&nbsp;entreprise</h2>
<br/>
<form name="results">
	<div class="search">
		<p><label for="name">Nom&nbsp;</label><input type="text" id="name" size="20" /> 
		<input type="button" value="Rechercher"/></p>
	</div>
	<h3>R&eacute;sultats</h3>
	<div align=center>
		<div id="statSearch">
			<p><label for="result">R&eacute;sultats&nbsp;</label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb">Nb.&nbsp;par&nbsp;page&nbsp;</label><input type="text" id="pageNb" size="5" /></p>
		</div>
			<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>Nom</th>
			</tr>
			<tr>
				<td width="5"><input type="radio" name="radio" /></td>
				<td><a href="/eMagine/companyOnglet.do">Siemens</a></td>
			</tr>
			<tr>
				<td><input type="radio" name="radio" /></td>
				<td><a href="/eMagine/companyOnglet.do">Thomson</a></td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li>
				<input type="button" value="Affecter"/>
			</li>
		</ul>
	</div>
	<br/> 
</form>