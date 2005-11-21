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
<div id="create">
<html:form action="/userShowInformation" method="GET">
	<ul>
		<li>
			<label for="id">Nom </label><html:text name="userInformationForm" property="id" />
		</li>		<li>
			<html:submit value="Visualiser"/>
		</li>
	</ul>
</html:form>
</div>
</body>
</html>
