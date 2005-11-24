<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<br/>
<h2>Recherche d'&eacute;v&eacute;nement</h2>
<div align="center">
	<div class="search">
		<fieldset>
			<div class="search_b1">
				<p>
					<label for="initDate">Date&nbsp;d&eacute;but </label>
					<input type="text" id="initDate" size="20" /> 
				</p>
				<p>
					<label for="endDate">Date&nbsp;fin </label>
					<input type="text" id="endDate" size="20" /> 
				</p>
			</div>
			<div class="search_b2">
				<p>
					<label for="type">Type </label>
					<select name="type">
						<!-- à mettre en base -->
						<option value="all" selected="selected">Tous</option>
						<option value="email">email</option>
						<option value="mail">courrier</option>
						<option value="tutor">tutelle</option>
					</select>
				</p>
			</div>
		</fieldset>
		</div>
		<br/>
		<input type="button" value="Rechercher"/>
</div>	
<br/>
<h2>Ev&eacute;nements</h2> 
<br/>
<div align=center>
	<div id="statSearch">
		<p>
			<label for="result">R&eacute;sulats </label> <input type="text" id="result" size="5" />&nbsp;&nbsp;&nbsp;
			<label for="pageNb">Nombre par page </label><input type="text" id="pageNb" size="5" /> 
		</p>
	</div>
	<form name="results"><br/>
	<!-- Un tableau de resultats -->
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>Date</th>
			<th>Ev&eacute;nements</th>
			<th>Commentaire</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON"  name="all_none"/></td>
			<td><html:link action="/teacherEventDetail">12.10.2005</html:link></td>
			<td>envoi mail</td>
			<td>pour les jpo</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON"  name="all_none"/></td>
			<td><html:link action="/teacherEventDetail">13.10.2005</html:link></td>
			<td>tutelle</td>
			<td>changement&nbsp;de&nbsp;tuteur&nbsp;enseignant</td>
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
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="supprimer un événement"/></a></li>
			<li><html:link action="/teacherEventExtract"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire un événement"/></html:link></li>
		</ul>
	</form>

