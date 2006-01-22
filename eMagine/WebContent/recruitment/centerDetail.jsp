<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<h2><bean:message key="center.detail.title"/></h2>
<br/>

<html:form action="/centerDetail" method="POST" focus="name">
	<div class="form">
		<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><html:text property="name" size="20" /></p>
		<p><label for="adress"><bean:message key="form.adress"/><font color="red">*</font> </label><input type="text" id="adress" size="20"/></p>
		<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><input type="text" id="postalCode" size="20" /></p>
			<p><label for="city"><bean:message key="form.city"/><font color="red">*</font> </label><input type="text" id="city" size="20" /></p>
			<p><label for="department"><bean:message key="form.department"/><font color="red">*</font> </label><select name="department">
					<!-- à mettre en base -->
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select> </p>		
		<p><label for="phone"><bean:message key="form.phone"/></label><input type="text" id="phone" size="20"/></p>	
	</div>
	<br/>
	<div align=center>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th>&nbsp;</th>
				<th><bean:message key="table.header.name"/></th>
				<th><bean:message key="table.header.capacity"/></th>
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
	</div>
	<html:errors />
	<div id="actions">
		<ul>
			<li><a href="javascript:checkAll('results','all_none');"><bean:message key="all_none.all"/></a>&nbsp;&nbsp;/</li>
			<li><a href="javascript:checkNothing('results','all_none');"><bean:message key="all_none.none"/></a></li>
		</ul>
		<h2>&nbsp;</h2>
		<ul>
			<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="<bean:message key="button.title.remove"/>"/></a></li>
			<li><html:link action="roomAdd"><img src="/eMagine/common/images/icones/ajouter.png" title="<bean:message key="button.title.add"/>"/></html:link></li>
		</ul>
	</div>
	<html:hidden property="idFormationCenterToModify" />
	<html:hidden property="action" />
</html:form>

<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>