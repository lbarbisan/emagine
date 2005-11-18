<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>eMagine</title>
		<link rel="stylesheet" type="text/css" href="eMagine.css" media="screen"/>
		
	</head>

<body>
<a name="top"/>
        <!-- Zone supérieure -->
        <div id="bloc_menu1">
            <ul id="menu">
                <li> <a href="#">Apprenti</a> | </li>
                <li> <a href="#">Entreprise</a> | </li>
                <li> <a href="#">Enseignant</a> | </li>
                <li> <a href="#">Statistiques</a> | </li>
                <li> <a href="#">Courriers</a> </li>
            </ul>
        </div>
        <div id="bloc_menu2">
            <ul id="menu2">
                <li> <a href="#">Pr&eacute;f&eacute;rences</a> | </li>
                <li> <a href="#">Administration</a> | </li>
                <li> <a href="#">Aide</a> | </li>
                <li> <a href="#">Se d&eacute;connecter</a></li>
            </ul>
        </div>
        <!-- Zone principale -->
        <div id="global">
            <div id="bloc_gauche">
                <!-- Sous menu -->
                <div class="gauche">
                    <h2>Un sous menu</h2>
                    <ul>
                        <li> <a href="#">Action 1</a> </li>
                        <li> <a href="#">Action 2</a> </li>
                        <li> <a href="#">Action 3</a> </li>
                        <li> <a href="#">Action 4</a> </li>
                        <li> <a href="#">Action 5</a> </li>
                    </ul>
                </div>
                
                <!-- Demandes de modfication -->
                <div class="gauche">
                    <h2>Demandes de modifications</h2>
                    <ul>
                        <li> <a href="#">Modif 1</a> </li>
                        <li> <a href="#">Modif 2</a> </li>
                        <li> <a href="#">Modif 3</a> </li>
                        <li> <a href="#">Modif 4</a> </li>
                        <li> <a href="#">Modif 5</a> </li>
                    </ul>
                </div>
            </div>
            <!-- Zone principale -->
            <div class="contenu">
                <h2>Recherche d'apprenti</h2>
				<br/>
				<!-- Un formulaire de recherche -->
				<div id="recherche">
					<ul>
						<li>
							<label for="nom">Nom </label><input type="text" id="nom" />
						</li>
                    	<li>
							<label for="prenom">Pr&eacute;nom </label><input type="text" id="prenom" />
						</li>
						<li>
							<label for="promotion">Promotion </label>
							<select name="promotion">
    							<option value="toutes" selected="selected">Toutes</option>
    							<option value="ir">IR</option>
								<option value="mfpi">MFPI</option>
							</select>
						</li>
						<li>
							<input type="button" value="Rechercher" />
						</li>
                	</ul>
				</div>
				<br/>
				<h2>R&eacute;sultats </h2> 
				<br/>
				<!-- Un tableau de résultats -->
				<table width="60%" cellpadding="0" cellspacing="0">
  					<tr>
						<th>&nbsp;</th>
    					<th>Nom</th>
    					<th>Pr&eacute;nom</th>
    					<th>Promotion</th>
  					</tr>
  					<tr>
						<td><input type="checkbox" /></th>
    					<td><a href="#">Nom1</a></td>
    					<td>Pr&eacute;nom1</td>
    					<td>IR3</td>
  					</tr>
					<tr>
						<td><input type="checkbox" /></th>
    					<td><a href="#">Nom2</a></td>
    					<td>Pr&eacute;nom2</td>
    					<td>IR3</td>
  					</tr>
				</table>
				<!-- Les actions propres à la sélection -->
				<div id="actions">
				<ul>
					<li> <a href="#">Tous</a> /  </li>
                    <li> <a href="#">Aucun</a> </li>
                </ul>
				<h2>&nbsp;</h2>
				<ul>
					<li> <a href="#"><img src="images/icones/ajouter.png" alt="Ajouter"/></a> </li>
                    <li> <a href="#"><img src="images/icones/supprimer.png" alt="Supprimer"/></a> </li>
                    <li> <a href="#"><img src="images/icones/creer_mailing_list.png" alt="Cr&eacute;er une maling list"/></a> </li>
                    <li> <a href="#"><img src="images/icones/mailing.png" alt="Effecter un mailing"/></a> </li>
                    <li> <a href="#"><img src="images/icones/publipostage.png" alt="Effecter un publipostage"/></a> </li>
                </ul>
				</div>
            </div>
        </div>
        <!-- Pied de page -->
        <div id="pied">
            <p>&copy; 2005 eMagine Group | <a href="index.htm">Accueil</a> | <a href="#top">Haut</a></p>
        </div>

</body>
</html>
