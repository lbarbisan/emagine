<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
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
		<li><a href="#"><img src="/eMagine/common/images/icones/generate.png" title="<bean:message key="button.title.generate"/>"/></a></li>
		<li><html:link action="/candidateSearch"><img src="/eMagine/common/images/icones/annuler.png" title="<bean:message key="button.title.cancel"/>"/></html:link></li>		
	</ul>
</div>
<br/>