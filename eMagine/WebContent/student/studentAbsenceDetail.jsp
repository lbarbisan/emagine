<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="student.absence.detail.title"/></h2>
<br/>
<form name="results">
	<div class="form">
		<p><label for="initDate"><bean:message key="form.initDate"/><font color="red">*</font> </label><input type="text" id="initDate" size="20" /></p>
		<p><label for="endDate"><bean:message key="form.endDate"/><font color="red">*</font> </label><input type="text" id="endDate" size="20" /></p>
		<p><label for="nbdays"><bean:message key="form.daysNumber"/></label><input type="text" id="nbdays" size="20" /></p>
		<p><label for="justification"><bean:message key="form.justification"/></label>
			<select name="justification">
				<option value="M">maladie</option>
				<option value="E">entreprise</option>
				<option value="NJ">non&nbsp;justifi&eacute;</option>
			</select>
		</p>
		<p><label for="comment"><bean:message key="form.comment"/></label><textarea id="comment"></textarea></p>
	</div>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><input type="button" value="Modifier"/></a></li>
			<li><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer l'absence"/></a></li>
		</ul>
	</div>
</form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>