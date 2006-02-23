<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script type="text/javascript">
<!--
	function setAction(value) {
		document.firmActorModifyForm.action.value = value;
	}

	function createActor() {
		setAction('create');
		document.firmActorModifyForm.submit();
	}

	function resetForm() {
		document.firmActorModifyForm.reset();
	}
-->
</script>


<html:form action="/actorCreate" method="POST" focus="lastname">

<h2><bean:message key="actor.create.title"/><html:link action="/companyVisuActor"><img src="/eMagine/common/images/icones/retour.png" title="<bean:message key="button.title.return"/>"/></html:link></h2>
<br/>

<div class="form">
		<br/>
		<p><label for="lastname"><bean:message key="form.name"/><font color="red">*</font> </label><html:text property="lastname" size="20" /></p>
		<p><label for="firstname"><bean:message key="form.firstName"/><font color="red">*</font> </label><html:text property="firstname" size="20" /></p>
		<p>
			<label for="idFunction"><bean:message key="form.function"/></label>
			<html:select property="idFunction">
				<html:optionsCollection property="functions" value="id" label="name"/>		
			</html:select>
		</p>
		<p><label for="adress"><bean:message key="form.adress"/><font color="red">*</font> </label><html:text property="adress" size="20" /></p>
		<p><label for="postalCode"><bean:message key="form.postalCode"/><font color="red">*</font> </label><html:text property="postalCode" size="20" /></p>
		<p><label for="city"><bean:message key="form.city"/><font color="red">*</font> </label><html:text property="city" size="20" /></p>
		<p><label for="idDepartment"><bean:message key="form.department"/><font color="red">*</font> </label>
			<html:select property="idDepartment">
				<html:optionsCollection property="departments" value="id" label="name"/>		
			</html:select>
		<p><label for="phone"><bean:message key="form.phone"/></label><html:text property="fixPhone" size="20" /></p>	
		<p><label for="mobile"><bean:message key="form.mobile"/></label><html:text property="portPhone" size="20" /></p>
		<p><label for="fax"><bean:message key="form.fax"/></label><html:text property="fax" size="20" /></p>
		<p><label for="mail"><bean:message key="form.email"/><font color="red">*</font> </label><html:text property="mail" size="20" /></p>
	</div>
	<br/>

<br/>
<html:errors />
<br/>

<div id="actions">
	<ul>
		<li><html:link href="javascript:createActor();"><html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.ok" /></html:link></li>
		<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize" /></html:link></li>
	</ul>
</div>

<html:hidden property="action" />
</html:form>


<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>