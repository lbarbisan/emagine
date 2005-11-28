<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="post.detail.title"/></h2>
<br/>
<div class="form">
	<p>
		<label for="die"><bean:message key="form.die"/></label>
		<select name="die">
			<option value="ir">IR</option>
			<option value="mfpi">MFPI</option>
			<option value="gmu">GMU</option>
		</select>
	</p>
	<p><label for="nbAsked"><bean:message key="form.numberAsked"/><font color="red">*</font>&nbsp;</label><input type="text" id="firstName" size="20" /></p>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="submit" value="Modifier" title="Modifier le poste"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
