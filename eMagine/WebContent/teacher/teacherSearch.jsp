<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Recherche d'enseignant</h2>
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
			<label for="die">Fili&egrave;re </label>
			<select name="die">
				<!-- à mettre en base -->
				<option value="all" selected="selected">Toutes</option>
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
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
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/teacherOnglet">Duris</html:link></td>
			<td>Etienne</td>
			<td>IR</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/teacherOnglet">Mourrier</html:link></td>
			<td>Yves</td>
			<td>IR</td>
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
		<li><a href="#"><img src="/eMagine/common/images/icones/ajouter.png" alt="Ajouter un pupille"/></a> </li>
	</ul>
</div>
