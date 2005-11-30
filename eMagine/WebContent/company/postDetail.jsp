<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="post.detail.title"/><html:link action="/companyVisuPost"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
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
	<p><label for="nbPost"><bean:message key="form.nbPost"/><font color="red">*</font>&nbsp;</label><input type="text" id="nbPost" size="20" /></p>
</div>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><img src="/eMagine/common/images/icones/modif.png" title="<bean:message key="button.title.update"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
