<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
<h2>Recherche d'apprenti</h2>
<br/>

   Votre prénom : 


<!-- Un formulaire de recherche -->
<div id="recherche">
<html:form action="createUser.do" method="GET">
	<ul>
		<li>
			<label for="nom">Nom </label><html:text name="firstNameBean" property="firstName" />
		</li>
		<li>
			<label for="prenom">Pr&eacute;nom </label><html:text name="lastNameBean" property="lastName" />
		</li>
		<li>
			<html:submit value="Créer" />
		</li>
	</ul>
</html:form>
</div>
</body>
</html>
