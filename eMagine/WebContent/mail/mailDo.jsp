<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="mail.do.title"/></h2>
<br/>
<div class="form">
	<p>
		<label for="mail"><bean:message key="form.mailType"/></label>
		<select name="mail">
			<option value="1">JPO</option>
			<option value="2">Emploi du temps</option>
		</select>
	</p>
</div>
<div id="actions">
<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="button" value="G�n�rer"/></a></li>
	</ul>
</div>
<br/>