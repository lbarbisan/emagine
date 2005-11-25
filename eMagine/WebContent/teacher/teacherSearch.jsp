<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Rechercher&nbsp;un&nbsp;enseignant</h2>
<br/>
<form name="results">
	<div align="center">
		<div class="search">
			<fieldset>
				<div class="search_b1">
					<p><label for="name">Nom </label><input type="text" id="name" size="20" /></p>
				</div>
				<div class="search_b2">
					<p><label for="firstName">Pr&eacute;nom </label><input type="text" id="firstName" size="20" /></p>
				</div>
			</fieldset>
		</div>
		<br/>
		<input type="button" value="Rechercher"/>
	</div>
	<h3>R&eacute;sultats</h3>
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
		<ul>
			<li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');">Aucun</a> </li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer enseignant(s)"/></a></li>
			<li><html:link action="/teacherMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" title="Cr&eacute;er une maling-list"/></html:link></li>
			<li><html:link action="/teacherEmailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effectuer un mailing"/></html:link></li>
			<li><html:link action="/teacherMailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effectuer un publipostage"/></html:link></li>
			<li><html:link action="/teacherExtract"><img src="/eMagine/common/images/icones/extraire.png" title="Extraire les enseignants"/></html:link></li>
		</ul>
	</div>
</form>

