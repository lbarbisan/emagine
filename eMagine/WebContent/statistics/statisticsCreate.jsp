<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Cr&eacute;er&nbsp;une&nbsp;statistique</h2>
<br/>
<div class="form">
	<p><label for="name">Nom&nbsp;<font color="red">*</font>&nbsp;</label>
		<input type="text" id="name" size="20" /> 
	</p>
	<p><label for="request">Requête&nbsp;&nbsp;<font color="red">*</font>&nbsp;</label>
		<textarea id="request"></textarea>
		<input type="submit" value="?" name="help"/> 
	</p>
	<p><label for="diagram">Diagramme&nbsp;<font color="red">*</font>&nbsp;</label>
		<select name="diagram">
			<!-- à mettre en base -->
			<option value="c">Camembert</option>
			<option value="h">Histogramme</option>
		</select></p>
</div>
<br/>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="submit" value="Créer" alt="Créer la statistique"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>
