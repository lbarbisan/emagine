<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-layout.tld" prefix="layout"%>

<h2><bean:message key="candidate.create.title"/></h2>
<br/>
<div class="form">

<script src="/eMagine/common/js/strutsLayout.js"></script>
<script>
	imgsrc="/eMagine/common/images/icones/";
</script>
<script type="text/javascript">
<!--	
	function setAction(value) {
		document.candidateModifyForm.action.value = value;
	}

	function createCandidate() {
		setAction('create');
		document.candidateModifyForm.submit();
	}

	function resetForm() {
		document.candidateModifyForm.reset();
	}
-->
</script>
<html:form action="/candidateCreate" method="POST" focus="lastName">
	<fieldset>
		<legend><bean:message key="form.fieldset.status"/></legend>
			<p><label for="lastName"><bean:message key="form.name"/><font color="red">*</font></label><html:text property="lastName" size="20" /></p>
			<p><label for="firstName"><bean:message key="form.firstName"/><font color="red">*</font></label><html:text property="firstName" size="20" /></p>
			<p><label for="sex"><bean:message key="radio.sex"/></label>
				<logic:notEmpty name="candidateModifyForm" property="sexes">
					<logic:iterate id="sex" name="candidateModifyForm" property="sexes" type="fr.umlv.ir3.emagine.apprentice.SexEnum">
						<html:radio property="idSex" value="id" idName="sex"/> 
  						<bean:write name="sex" property="name"/>
					</logic:iterate>	   	
				</logic:notEmpty>
			</p>
			<p><layout:date key="form.birth" styleClass="form_calendar" property="birth" startYear="1980" endYear="2030"/></p>
			<p><label for="city"><bean:message key="form.city"/></label><html:text property="city" size="20" /></p>
			<p>
				<label for="department"><bean:message key="form.department"/></label>
				<html:select property="idDepartment">
					<html:optionsCollection property="departments" value="id" label="name"/>		
				</html:select>
			</p>
			<p>
				<label for="country"><bean:message key="form.country"/></label>
				<html:select property="idCountry">
					<html:optionsCollection property="countries" value="id" label="name"/>		
				</html:select>
			</p>
			<p>
				<label for="nationality"><bean:message key="form.nationality"/></label>
				<html:select property="idNationality">
					<html:optionsCollection property="nationalities" value="id" label="name"/>		
				</html:select>
			</p>	
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.adress"/></legend>
			<p><label for="persAdress"><bean:message key="form.adress"/><font color="red">*</font></label><html:text property="persAdress" size="20" /></p>
			<p><label for="persPostalCode"><bean:message key="form.postalCode"/><font color="red">*</font></label><html:text property="persPostalCode" size="20" /></p>
			<p><label for="persCity"><bean:message key="form.city"/><font color="red">*</font></label><html:text property="persCity" size="20" /></p>
			<p>
				<label for="persDepartments"><bean:message key="form.department"/></label>
				<html:select property="idPersDepartment">
					<html:optionsCollection property="departments" value="id" label="name"/>		
				</html:select>
			</p>
			<p><label for="persPhone"><bean:message key="form.phone"/></label><html:text property="persPhone" size="20" /></p>	
			<p><label for="persMobile"><bean:message key="form.mobile"/></label><html:text property="persMobile" size="20" /></p>
			<p><label for="persFax"><bean:message key="form.fax"/></label><html:text property="persFax" size="20" /></p>
			<p><label for="persEmail"><bean:message key="form.email"/><font color="red">*</font></label><html:text property="persEmail" size="20" /></p>	
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.studies"/></legend>
		<p>
			<label for="courseOptions"><bean:message key="form.die"/></label>
			<html:select property="idCourseOption">
				<html:optionsCollection property="courseOptions" value="id" label="name"/>		
			</html:select>
		</p>
		<p>
			<label for="level"><bean:message key="form.level"/></label>
			<html:select property="idLevel">
				<html:optionsCollection property="levels" value="id" label="name"/>		
			</html:select>
		</p>
		
		<p>
			<label for="diploma"><bean:message key="form.lastDiploma"/></label>
			<html:select property="idDiploma">
				<html:optionsCollection property="diplomas" value="id" label="name"/>		
			</html:select>
		</p>
		<p>
			<label for="section"><bean:message key="form.section"/></label>
			<html:select property="idSection">
				<html:optionsCollection property="sections" value="id" label="name"/>		
			</html:select>
		</p>
		<p>
			<label for="center"><bean:message key="form.center"/></label>
			<html:select property="idCenter">
				<html:optionsCollection property="centers" value="id" label="name"/>		
			</html:select>
		</p>
		<p>
			<label for="formation">
			<bean:message key="form.otherFormation"/>
			</label>
			<html:multibox property="formation" value="true"/>
		</p>
		<p>
			<label for="admissibility">
			<bean:message key="form.acceptable"/>
			</label>
			<html:multibox property="admissibility" value="true"/>
		</p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.originContact"/></legend>
		<p>
			<label for="contact"><bean:message key="form.contact"/></label>
			<html:select property="idContact">
				<html:optionsCollection property="contacts" value="id" label="name"/>		
			</html:select>
		</p>
	</fieldset>
	<br/>
	<fieldset>
		<legend><bean:message key="form.fieldset.parentsProfession"/></legend>
		<p>
			<label for="father"><bean:message key="form.father"/></label>
			<html:select property="idFather">
				<html:optionsCollection property="professions" value="id" label="name"/>		
			</html:select>
		</p>
		<p>
			<label for="mother"><bean:message key="form.mother"/></label>
			<html:select property="idMother">
				<html:optionsCollection property="professions" value="id" label="name"/>		
			</html:select>
		</p>
	</fieldset>
	<br/>
	</div>
	<div id="actions">
		<h2>&nbsp;</h2>
		<ul>
			<li><html:link href="javascript:createCandidate();"><html:img src="/eMagine/common/images/icones/ok.png" titleKey="button.title.ok"/></html:link></li>
			<li><html:link href="javascript:resetForm();"><html:img src="/eMagine/common/images/icones/reinit.png" titleKey="button.title.reinitialize"/></html:link></li>
		</ul>
	</div>
	<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
	<html:hidden property="action"/>
</html:form>