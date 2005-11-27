<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="student.extract.absence.title"/></h2>
<br/>
<form name="results">
	<div class="form">
		<p><label for="type">Type&nbsp;</label><input type="radio" name="type" value="csv" checked>csv<input type="radio" name="type" value="xls">xls</p>
		<br/>
		<fieldset>
			<p><label for="initDate"><bean:message key="form.initDate"/></label>
			<input type="checkbox" value="ON" name="initDate" /></p>
			<p><label for="endDate"><bean:message key="form.endDate"/></label>
			<input type="checkbox" value="ON" name="endDate" /></p>
			<p><label for="nbDays"><bean:message key="form.daysNumber"/></label>
			<input type="checkbox" value="ON" name="nbDays" /></p>
			<p><label for="justification"><bean:message key="form.justification"/></label>
			<input type="checkbox" value="ON" name="justification" /></p>
			<p><label for="comment"><bean:message key="form.comment"/></label>
			<input type="checkbox" value="ON" name="comment" /></p>
		</fieldset>
	</div>
	<div id="actions" align="center">
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><input type="button" value="Sauvegarder"/></a></li>
			<li><a href="#"><input type="button" value="Générer"/></a></li>
		</ul>
	</div>
</form>
<br/>
