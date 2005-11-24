<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Recherche d'enseignant</h2>
<br/>
<div class="search">
<p><label for="name">Nom </label><input type="text" id="name" size="20" />&nbsp;<label for="firstName">Pr&eacute;nom </label> <input type="text" id="firstName" size="20" /> <input type="button" value="Rechercher"/> </p>
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
	<form name="results">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>Nom</th>
			<th>Pr&eacute;nom</th>
			<th>T&eacute;l&eacute;phone</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" name="all_none" /></td>
			<td><html:link action="/teacherOnglet">Duris</html:link></td>
			<td>Etienne</td>
			<td>0123456789</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" name="all_none" /></td>
			<td><html:link action="/teacherOnglet">Mourrier</html:link></td>
			<td>Yves</td>
			<td>0123456789</td>
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
		<li><html:link action="/teacherExtract"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire les enseignants"/></html:link></li>
	</ul>
	</form>
</div>
