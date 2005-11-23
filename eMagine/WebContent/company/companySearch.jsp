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
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>&nbsp;</th>
			<th>Nom</th>
			<th>D&eacute;partement</th>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/companyOnglet">Keops</html:link></td>
			<td>77</td>
		</tr>
		<tr>
			<td><input type="checkbox" value="ON" /></td>
			<td><html:link action="/companyOnglet">Nestle</html:link></td>
			<td>93</td>
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
		<li><a href="#"><img src="/eMagine/common/images/icones/ajouter.png" alt="Ajouter un apprenti"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer un apprenti"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/mailing.png" alt="Effecter un mailing"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/publipostage.png" alt="Effecter un publipostage"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/extraire.png" alt="Extraire un apprenti"/></a></li>
	</ul>
</div>
