<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="statistics.detail.title"/></h2>
<br/>
<div class="form">
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label>
		<input type="text" id="name" size="20" /> 
	</p>
	<p><label for="request"><bean:message key="form.request"/><font color="red">*</font>&nbsp;</label>
		<textarea id="request"></textarea>
		<img src="/eMagine/common/images/icones/help.png" title="<bean:message key="button.title.help"/>"/>
	</p>
	<p><label for="diagram"><bean:message key="form.diagram"/><font color="red">*</font>&nbsp;</label>
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
		<li><a href="#"><img src="/eMagine/common/images/icones/modif.png" title="<bean:message key="button.title.update"/>"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/annuler.png" title="<bean:message key="button.title.cancel"/>"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
