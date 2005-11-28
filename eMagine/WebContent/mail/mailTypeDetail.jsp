<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="mailType.detail.title"/></h2>
<br/>
<br/>
<div class="form">
	<p><label for="name"><bean:message key="form.name"/><font color="red">*</font> </label><input type="text" id="name" size="20" /></p>
	<p><label for="file"><bean:message key="form.file"/><font color="red">*</font> </label><input type="text" id="file" size="20" /><a href="#"><input type="button" value="Parcourir"/></a></p>
	<p><label for="description"><bean:message key="form.description"/></label><textarea type="text" id="description" ></textarea></p>
	<p><label for="group"><bean:message key="form.section"/><font color="red">*</font>&nbsp;</label>
		<select name="group">
			<!-- à mettre en base -->
			<option value="1"><bean:message key="form.apprentice"/></option>
			<option value="2"><bean:message key="form.company"/></option>
			<option value="3"><bean:message key="form.teacher"/></option>
			<option value="4"><bean:message key="form.recruitment"/></option>
			<option value="5"><bean:message key="form.mail"/></option>
		</select></p>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.wording.extract"/></legend>
		<br/>
		<br/>
		<br/>
		<br/>
	</fieldset>
</div>
<br/>
<div id="actions">
	<h2>&nbsp;</h2>
	<ul>
		<li><a href="#"><input type="button" value="Modifier"/></a></li>
		<li><a href="#"><img src="/eMagine/common/images/icones/supprimer.png" title="Supprimer le courrier type"/></a></li>
	</ul>
</div>
<div align="right"><font color="red" size="1">Les&nbsp;champs&nbsp;marqu&eacute;s&nbsp;d'une&nbsp;*&nbsp;sont&nbsp;obligatoires</font></div>
