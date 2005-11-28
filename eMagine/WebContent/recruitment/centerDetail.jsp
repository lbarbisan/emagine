<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="center.detail.title"/></h2>
<br/>
<form name="results">
	<div class="form">
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><input type="text" id="name" size="20"/></p>
		<p><label for="adress"><bean:message key="form.adress"/><font color="red">*</font> </label><input type="text" id="adress" size="20"/></p>
		<p><label for="phone"><bean:message key="form.phone"/></label><input type="text" id="phone" size="20"/></p>	
		<p><label for="nbRoom"><bean:message key="form.nbRoom"/></label><input type="text" id="nbRoom" size="20"/></p>
		<p><label for="nbPlace"><bean:message key="form.nbPlace"/><font color="red">*</font>&nbsp;</label><input type="text" id="nbPlace" size="20"/></p>
	</div>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.nbPlace"/></th>
				<th><bean:message key="table.header.nbAvailable"/></th>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/roomDetail">A10</html:link></td>
				<td>16</td>
				<td>57</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/roomDetail">A12</html:link></td>
				<td>40</td>
				<td>12</td>
			</tr>
		</table>
		<br/>
	</div>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer une salle"/></a></li>
			<li><html:link action="roomAdd"><img src="/eMagine/common/images/icones/ajouter.png" title="Ajouter une salle"/></html:link></li>
		</ul>
	</div>
</form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>