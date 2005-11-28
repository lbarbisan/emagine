<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<form name="results">
	<div class="tabs">
		<ul>
			<li><html:link action="/apprenticeVisuAdress">Adresses</html:link></li>
			<li><html:link action="/apprenticeVisuStatus">Etat&nbsp;civil</html:link></li>
			<li><html:link action="/apprenticeVisuSituation">Situation</html:link></li>
			<span class="tab_clicked"><li>Scolarit&eacute;</li></span>
			<li><html:link action="/apprenticeVisuEvent">Ev&eacute;nement</html:link></li>
			<li><html:link action="/apprenticeVisuAbsence">Absence</html:link></li>
		</ul>
	</div>
	<div class="tabs_div">
<!-- Un formulaire de modification -->
<div class="form">
		<br/>
		<p><label for="langage1"><bean:message key="form.language1"/></label><input type="text" id="langage1" size="20" /> </p>
		<p><label for="langage2"><bean:message key="form.language2"/></label><input type="text" id="langage2" size="20" /> </p>
		<p><label for="level"><bean:message key="form.level"/></label>
			<input type="radio" name="level" checked/>bac 
			<input type="radio" name="level" />+2
			<input type="radio" name="level" />+3
		</p>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.marksExam"/></legend>
				<p><label for="psy">Psychotest&nbsp;</label><input type="text" id="psy" size="20" /></p>
				<p><label for="maths">Maths&nbsp;</label><input type="text" id="maths" size="20" /></p>	
				<p><label for="logic">Logique&nbsp;</label><input type="text" id="logic" size="20" /></p>
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.obtainedDiplomas"/></legend>
				<p><label for="diplomaYear1"><bean:message key="form.year"/></label>
					<select name="diplomaYear1">
						<option value="" selected="selected">-- Ann&eacute;e --</option>	
					</select></p>
				<p><label for="diploma1"><bean:message key="form.diploma"/></label>
					<select name="diploma1">
						<option value="" selected="selected">-- Diplome --</option>	
					</select></p>
				<p><label for="spec1"><bean:message key="form.speciality"/></label>
					<select name="spec1">
						<option value="" selected="selected">-- Sp&eacute;cialit&eacute; --</option>	
					</select></p>
				<p><label for="option1"><bean:message key="form.option"/></label>
					<select name="option1">
							<option value="" selected="selected">-- Option --</option>	
						</select></p>
				<h2>&nbsp;</h2>
				<p><label for="diplomaYear2"><bean:message key="form.year"/></label>
					<select name="diplomaYear2">
						<option value="" selected="selected">-- Ann&eacute;e --</option>	
					</select></p>
				<p><label for="diploma2"><bean:message key="form.diploma"/></label>
					<select name="diploma2">
						<option value="" selected="selected">-- Diplome --</option>	
					</select></p>
				<p><label for="spec2"><bean:message key="form.speciality"/></label>
					<select name="spec2">
						<option value="" selected="selected">-- Sp&eacute;cialit&eacute; --</option>	
					</select></p>
				<p><label for="option2"><bean:message key="form.option"/></label>
					<select name="option2">
						<option value="" selected="selected">-- Option --</option>	
					</select></p>
				<h2>&nbsp;</h2>
				<p><label for="diplomaYear3"><bean:message key="form.year"/></label>
					<select name="diplomaYear3">
						<option value="" selected="selected">-- Ann&eacute;e --</option>	
					</select></p>
				<p><label for="diploma3"><bean:message key="form.diploma"/></label>
					<select name="diploma3">
						<option value="" selected="selected">-- Diplome --</option>	
					</select></p>
				<p><label for="spec3"><bean:message key="form.speciality"/></label>
					<select name="spec3">
						<option value="" selected="selected">-- Sp&eacute;cialit&eacute; --</option>	
					</select></p>
				<p><label for="option3"><bean:message key="form.option"/></label>
					<select name="option3">
						<option value="" selected="selected">-- Option --</option>	
					</select>
				</p>
		</fieldset>
		<br/>
		<fieldset>
			<legend><bean:message key="form.fieldset.scolarityPast"/></legend>
			<p><label for="scolarityYear1"><bean:message key="form.year"/></label>
				<select name="scolarityYear1">
					<option value="" selected="selected">-- Ann&eacute;e --</option>	
				</select></p>
			<p><label for="class1"><bean:message key="form.class"/></label>
				<select name="class1">
					<option value="" selected="selected">-- Classe --</option>	
				</select></p>
			<p><label for="section1"><bean:message key="form.section"/></label>
				<select name="section1">
					<option value="" selected="selected">-- Section --</option>	
				</select></p>
			<p><label for="establishment1"><bean:message key="form.establishment"/></label><input type="text" id="establishment1" size="20" /></p>
			<p><label for="postalCode1"><bean:message key="form.postalCode"/></label><input type="text" id="postalCode1" size="20" /></p>
			<p><label for="city1"><bean:message key="form.city"/></label><input type="text" id="city1" size="20" /></p>
			<p><label for="department1"><bean:message key="form.department"/></label>
				<select name="department1">
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select></p>
			<h2>&nbsp;</h2>
			<p><label for="scolarityYear2"><bean:message key="form.year"/></label>
				<select name="scolarityYear2">
					<option value="" selected="selected">-- Ann&eacute;e --</option>	
				</select></p>
			<p><label for="class2"><bean:message key="form.class"/></label>
				<select name="class2">
					<option value="" selected="selected">-- Classe --</option>	
				</select></p>
			<p><label for="section2"><bean:message key="form.section"/></label>
				<select name="section2">
					<option value="" selected="selected">-- Section --</option>	
				</select></p>
			<p><label for="establishment2"><bean:message key="form.establishment"/></label><input type="text" id="establishment2" size="20" /></p>
			<p><label for="postalCode2"><bean:message key="form.postalCode"/></label><input type="text" id="postalCode2" size="20" /></p>
			<p><label for="city2"><bean:message key="form.city"/></label><input type="text" id="city2" size="20" /></p>
			<p><label for="department2"><bean:message key="form.department"/></label>
				<select name="department2">
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select></p>
			<h2>&nbsp;</h2>
			<p><label for="scolarityYear3"><bean:message key="form.year"/></label>
				<select name="scolarityYear3">
					<option value="" selected="selected">-- Ann&eacute;e --</option>	
				</select></p>
			<p><label for="class3"><bean:message key="form.class"/></label>
				<select name="class3">
					<option value="" selected="selected">-- Classe --</option>	
				</select></p>
			<p><label for="section3"><bean:message key="form.section"/></label>
				<select name="section3">
					<option value="" selected="selected">-- Section --</option>	
				</select></p>
			<p><label for="establishment3"><bean:message key="form.establishment"/></label><input type="text" id="establishment3" size="20" /></p>
			<p><label for="postalCode3"><bean:message key="form.postalCode"/></label><input type="text" id="postalCode3" size="20" /></p>
			<p><label for="city3"><bean:message key="form.city"/></label><input type="text" id="city3" size="20" /></p>
			<p><label for="department3"><bean:message key="form.department"/></label>
				<select name="department3">
					<option value="93">93</option>
					<option value="77">77</option>
					<option value="78">78</option>
				</select></p>
		</fieldset>
		<br/>
	</div>
</form>
<div align="right"><font color="red" size="1"><bean:message key="form.msg.obligation.star"/></font></div>
<br/>
</div>