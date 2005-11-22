<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<br/>
<h2>Modifier&nbsp;une&nbsp;statistique</h2>
<div class="form">
	<p><label for="name">Nom&nbsp;<font color="red">*</font>&nbsp;</label>
		<input type="text" id="name" size="20" /> 
	</p>
	<p><label for="request">Requête&nbsp;&nbsp;<font color="red">*</font>&nbsp;</label>
		<input type="text" id="request" size="20" />
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
		<li><a href="#"><input type="submit" value="Modifier" alt="Modifier la statistique"/></a></li>
	</ul>
</div>
