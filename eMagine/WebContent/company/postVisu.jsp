<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<br/>
<h2>Cr&eacute;er&nbsp;un&nbsp;poste</h2>
<div class="form">
	<p>
		<label for="die">Fili&egrave;re </label>
		<select name="die">
			<!-- à mettre en base -->
			<option value="all" selected="selected">Toutes</option>
			<option value="ir">IR</option>
			<option value="mfpi">MFPI</option>
			<option value="gmu">GMU</option>
		</select>
	</p>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="submit" value="Modifier" alt="Modifier le poste"/></a></li>
	</ul>
</div>
