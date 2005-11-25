<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Visualiser&nbsp;le&nbsp;d&eacute;tail&nbsp;d'un&nbsp;centre&nbsp;d'examen</h2>
<form name="results">
	<div class="form">
		<br/>	
		<p><label for="name">Nom&nbsp;<font color="red">*</font> </label><input type="text" id="name" size="20"/></p>
		<p><label for="adress">Adresse&nbsp;<font color="red">*</font> </label><input type="text" id="adress" size="20"/></p>
		<p><label for="phone">T&eacute;l&eacute;phone&nbsp;fixe&nbsp;</label><input type="text" id="phone" size="20"/></p>	
		<p><label for="nbRoom">Nb.&nbsp;de&nbsp;salles</label><input type="text" id="nbRoom" size="20"/></p>
		<p><label for="nbPlace">Nb.&nbsp;disponible<font color="red">*</font> </label><input type="text" id="nbPlace" size="20"/></p>
		<br/>
	</div>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>Nom</th>
				<th>Places</th>
				<th>Places&nbsp;disponibles</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/roomDetail">A10</html:link></td>
				<td>16</td>
				<td>57</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/roomDetail">A12</html:link></td>
				<td>40</td>
				<td>12</td>
			</tr>
		</table>
		<br/>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');">Aucun</a> </li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer une salle"/></a></li>
			<li><html:link action="roomAdd"><img src="/eMagine/common/images/icones/ajouter.png" alt="Ajouter une salle"/></html:link></li>
		</ul>
	</div>
</form>
<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>