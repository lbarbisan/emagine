<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="statistics.list.title"/></h2>
<br/>
<div class="search">
	<fieldset>
	<p><label for="stat"></label>
		<select name="stat">
			<!-- à mettre en base -->
			<option value="1">sexe(histogramme)</option>
			<option selected value="2">sexe(camembert)</option>
			<option value="3">section bac(camembert)</option>
		</select></p>
	</fieldset>
</div>
<br/>
<div class="form">
	<fieldset>
		<legend>sexe(camembert)</legend>
			<div align="center"><img src="/eMagine/common/images/pieChart.jpg" /></div>
	</fieldset>
</div>
<div id="actions">
<h2>&nbsp;</h2>
	<ul>
		<li><html:link action="/statisticsDetail"><img src="/eMagine/common/images/icones/visualiser.png" title="Visualiser le détail de la statistique"/></html:link></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer une statistique"/></a></li>
	</ul>
</div>