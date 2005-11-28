<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="statistics.create.title"/></h2>
<br/>
<div class="form">
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font>&nbsp;</label>
		<input type="text" id="name" size="20" /> 
	</p>
	<p><label for="request"><bean:message key="form.request"/><font color="red">*</font>&nbsp;</label>
		<textarea id="request"></textarea>
		<input type="submit" value="?" name="help"/> 
	</p>
	<p><label for="diagram"><bean:message key="form.diagram"/><font color="red">*</font>&nbsp;</label>
		<select name="diagram">
			<!-- � mettre en base -->
			<option value="c">Camembert</option>
			<option value="h">Histogramme</option>
		</select></p>
</div>
<br/>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="submit" value="Cr�er" title="Cr�er la statistique"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
