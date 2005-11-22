<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Rapprochement&nbsp;de&nbsp;candidats&nbsp;et&nbsp;d'entreprises</h2>
<br/>
<div id="search">
	<ul>
		<li><label for="die">Fili&egrave;re</label></li>
		<li><select name="die">
				<!-- à mettre en base -->
				<option value="all" selected="selected">Toutes</option>
				<option value="ir">IR</option>
				<option value="mfpi">MFPI</option>
				<option value="gmu">GMU</option>
			</select></li>
			<li><a href="#"><input type="submit" value="Rapprocher" alt="Rapprocher les candidats de la filière et les entreprises"/></a></li>
	</ul>
</div>
<br/>
<div align=center>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>&nbsp;Nom&nbsp;</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/companyOnglet">Sanofi</html:link></td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/companyOnglet">Bosh</html:link></td>
		</tr>
	</table>
</div>
<div id="actions">
	<ul>
		<li><a href="#">Tous</a> / </li>
		<li><a href="#">Aucun</a> </li>
	</ul>
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire les entreprises"/></a></li>
	</ul>
</div>