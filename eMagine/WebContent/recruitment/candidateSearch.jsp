<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="candidate.search.title"/></h2>
<form name="results">
	<br/>
	<div align="center">
		<div class="search">
			<fieldset>
			<div class="search_b1">
				<p><label for="name"><bean:message key="criteria.search.name"/></label><input type="text" id="name" size="20" />  </p>
				<p><label for="firstName"><bean:message key="criteria.search.firstName"/></label> <input type="text" id="firstName" size="20" /> </p>
			</div>		
			<div class="search_b2">
			<p>
			<label for="die"><bean:message key="criteria.search.dieAsked"/></label>
				<select name="die">
					<!-- à mettre en base -->
					<option value="all" selected="selected"><bean:message key="select.all.feminin"/></option>
					<option value="ir">IR</option>
					<option value="mfpi">MFPI</option>
					<option value="gmu">GMU</option>
				</select>
			</p>
			<p><label for="center"><bean:message key="criteria.search.center"/></label>
				<select name="center">
					<!-- à mettre en base -->
					<option value="all" selected="selected"><bean:message key="select.all.feminin"/></option>
					<option value="Paris">Paris</option>
					<option value="Toulouse">Toulouse</option>
					<option value="Bordeaux">Bordeaux</option>
				</select>
			</p>
			</div>
			</fieldset>
			</div>
			<br/>
		<div class="buttons"><input type="button" value="<bean:message key="button.title.search"/>"/></div>
	</div>
	<h3><bean:message key="title.results"/></h3>
	<div align=center>
		<div id="statSearch">
			<p><label for="result"><bean:message key="statSearch.results"/></label><input type="text" id="result" size="5"/>&nbsp;&nbsp;&nbsp;
			<label for="pageNb"><bean:message key="statSearch.numberByPage"/></label><input type="text" id="pageNb" size="5" /></p>
		</div>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.die"/></th>
				<th><bean:message key="table.header.center"/></th>
				<th><bean:message key="table.header.phone"/></th>
				<th><bean:message key="table.header.email"/></th>
				<th><bean:message key="table.header.acceptable"/></th>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON"  name="all_none"/></td>
				<td><html:link action="/candidateVisuInfo">Cadic</html:link></td>
				<td>Yann</td>
				<td>GM</td>
				<td>Paris</td>
				<td>014387544508</td>
				<td>yann.cadic@leneuf.fr</td>
				<td>oui</td>
			</tr>
			<tr>
				<td><input type="checkbox" value="ON"  name="all_none"/></td>
				<td><html:link action="/candidateVisuInfo">Dumoleyn</html:link></td>
				<td>Delphine</td>
				<td>EI</td>
				<td>Paris</td>
				<td>011045632211</td>
				<td>delphine.dumoleyn@wanadoo.fr</td>
				<td>oui</td>
			</tr>
		</table>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/passage.png" title="passer le candidat en apprenti"/></a></li>
			<li><a href="#"><img src="/eMagine/common/images/icones/virer.png" title="Supprimer le candidat"/></a></li>
			<li><html:link action="/candidateMailingListCreate"><img src="/eMagine/common/images/icones/creer_mailing_list.png" title="Cr&eacute;er une maling list"/></html:link></li>
			<li><html:link action="/candidateEmailDo"><img src="/eMagine/common/images/icones/mailing.png" title="Effectuer un mailing"/></html:link></li>
			<li><html:link action="/candidateMailDo"><img src="/eMagine/common/images/icones/publipostage.png" title="Effectuer un publipostage"/></html:link></li>
			<li><html:link action="/candidateExtract"><img src="/eMagine/common/images/icones/extraire.png" title="Extraire un candidat"/></html:link></li>
		</ul>
	</div>
</form>
