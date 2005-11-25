<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<form name="results">
	<h2>Rapprocher&nbsp;candidats&nbsp;et&nbsp;entreprises</h2>
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
				<p><label for="die">Fili&egrave;re</label>
					<select name="die">
						<!-- à mettre en base -->
						<option value="all" selected="selected">Toutes</option>
						<option value="ir">IR</option>
						<option value="mfpi">MFPI</option>
						<option value="gmu">GMU</option>
					</select></p>
			</fieldset>
		</div>
		<br/>
		<input type="button" value="Rapprocher"/>
	</div>
	<br/>
	<h3>R&eacute;sultats </h3>
	<div align=center>
		<div id="statSearch">
		<p>
		<label for="result">R&eacute;sultats </label> <input type="text" id="result" size="5" />&nbsp;&nbsp;&nbsp;
		<label for="pageNb">Nombre par page </label><input type="text" id="pageNb" size="5" /> 
		</p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th>&nbsp;Nom&nbsp;</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/companyOnglet">Sanofi</html:link></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/companyOnglet">Bosh</html:link></td>
			</tr>
		</table>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');">Aucun</a> </li>
		</ul>
		<h2>&nbsp;</h2>	
		<ul>
			<li><html:link action="/companyExtract"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire les entreprises"/></html:link></li>
		</ul>
	</div>
</form>