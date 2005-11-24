<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Recherche d'entreprise</h2>
<br/>
<div align="center">
	<div class="search">
		<fieldset>
			<div class="search_b1">
				<p><label for="name">Nom&nbsp;</label> <input type="text" id="name" size="20" /> </p>
			</div>
			<div class="search_b2">
				<p><label for="department">D&eacute;partement&nbsp;<font color="red">*</font>&nbsp;</label><select name="persDepartment">
					<!-- à mettre en base -->
					<option value="" selected="selected">-- D&eacute;partement --</option>
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select></p>
			</div>
		</fieldset>
	</div>
	<br/>
	<input type="button" value="Rechercher"/>
</div>
<h2>R&eacute;sultats </h2>
<div align=center>
	<div id="statSearch">
		<p>
		<label for="result">R&eacute;sulats&nbsp;</label><input type="text" id="result" size="5" />&nbsp;&nbsp;&nbsp;
		<label for="pageNb">Nombre par page&nbsp;</label><input type="text" id="pageNb" size="5" /> 
		</p>
	</div>
	<form name="results">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>Nom</th>
			<th>D&eacute;partement</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" name="all_none"/></td>
			<td><html:link action="/companyOnglet">Keops</html:link></td>
			<td>77</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" name="all_none"/></td>
			<td><html:link action="/companyOnglet">Nestle</html:link></td>
			<td>93</td>
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
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer une entreprise"/></a></li>
		<li><html:link action="/companyExtract"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire une entreprise"/></html:link></li>
	</ul>
	</form>
</div>
