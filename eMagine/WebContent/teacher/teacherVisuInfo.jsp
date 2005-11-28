<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<form name="results">
	<div class="form">
		<br/>
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
		<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font> </label><input type="text" id="firstName" size="20" /></p>
		<p><label for="adress"><bean:message key="form.adress"/><font color="red">*</font> </label><input type="text" id="adress" size="20" /></p>
		<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><input type="text" id="postalCode" size="20" /></p>
		<p><label for="city"><bean:message key="form.city"/><font color="red">*</font> </label><input type="text" id="city" size="20" /></p>
		<p><label for="department"><bean:message key="form.department"/><font color="red">*</font></label>
			<select name="department">
				<option value="93">93</option>
				<option value="77">77</option>
				<option value="78">78</option>
			</select> </p>
		<p><label for="phone"><bean:message key="form.phone"/></label><input type="text" id="phone" size="20" /></p>	
		<p><label for="mobile"><bean:message key="form.mobile"/></label><input type="text" id="mobile" size="20" /></p>
		<p><label for="fax"><bean:message key="form.fax"/></label><input type="text" id="fax" size="20" /></p>
		<p><label for="email"><bean:message key="form.email"/><font color="red">*</font> </label><input type="text" id="email" size="20" /></p>
	</div>
	<h3><bean:message key="title.pupils"/></h3>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.firstName"/></th>
				<th><bean:message key="table.header.class"/></th>
				<th><bean:message key="table.header.group"/></th>
				<th><bean:message key="table.header.initDate"/></th>
				<th><bean:message key="table.header.endDate"/></th>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/studentOnglet">Renaudin</html:link></td>
				<td>Jean-Baptiste</td>
				<td>IR3</td>
				<td>2</td>
				<td>20.09.2003</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="all_none" value="ON" /></td>
				<td><html:link action="/studentOnglet">Mancel</html:link></td>
				<td>Mathieu</td>
				<td>IR3</td>
				<td>2</td>
				<td>20.09.2003</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<br/>
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a> </li><li><a href="javascript:checkAll('results','all_none');">Tous</a>&nbsp;&nbsp;/</li>
		</ul>
		<h2>&nbsp;</h2>	
		<ul>
			<li><html:link action="/teacherStudentAdd"><img src="/eMagine/common/images/icones/ajouter.png" title="Ajouter un pupille"/></html:link></li>
		</ul>
	</div>
</form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>