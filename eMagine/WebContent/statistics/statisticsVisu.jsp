<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<h2>Visualiser&nbsp;une&nbsp;statistique</h2>
<div id="search">
	<ul>
		<li><label for="stat">Statistique&nbsp;</label><select name="stat">
			<!-- à mettre en base -->
			<option value="" selected="selected">-- D&eacute;partement --</option>
			<option value="1">sexe(histogramme)</option>
			<option selected value="2">sexe(camembert)</option>
			<option value="3">section bac(camembert)</option>
		</select></li>
		<li><html:link action="/statisticsModif"><img src="/eMagine/common/images/icones/visualiser.png" alt="visualiser le détail"/></html:link></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" alt="Supprimer une statistique"/></a></li>
	</ul>
<br/>
<fieldset>
	<legend>sexe(camembert)</legend>
	<img src="/eMagine/common/images/tichat.gif">
</fieldset>
<br/>
</div>
