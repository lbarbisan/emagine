<h2>Affecter&nbsp;un&nbsp;tuteur&nbsp;enseignant</h2>
<br/>
<form name="results">
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name">Nom&nbsp;</label><input type="text" id="name" size="20" /></p>
				</div>
				<div class="search_b2">
					<p><label for="firstName">Pr&eacute;nom&nbsp;</label><input type="text" id="firstName" size="20" /></p> 
				</div>
			</fieldset>
		</div>
		<br/>
		<input type="button" value="Rechercher"/>
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
				<th>Pr&eacute;nom</th>
			</tr>
			<tr>
				<td><input type="radio" name="radio"  /></td>
				<td><a href="/eMagine/teacherOnglet.do">Forax</a></td>
				<td>R&eacute;mi</td>
			</tr>
			<tr>
				<td><input type="radio" name="radio"  /></td>
				<td><a href="/eMagine/teacherOnglet.do">Revuz</a></td>
				<td>Dominique</td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li>
				<input type="button" value="Affecter" title="Affecter le tuteur"/>
			</li>
		</ul>
	</div>
	<br/>
</form>