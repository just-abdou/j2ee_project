<%@page import="lesServlets.Utulisateur"%>
<%@page import="lesServlets.AuthentificationUtil"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*" %>
<% 
    String successMessage = (String) request.getAttribute("successMessage");
    String errorMessage = (String) request.getAttribute("errorMessage");
    if(successMessage != null) {
%>
    <script>alert('<%= successMessage %>');</script>
    
<%
    }
    if(errorMessage != null) {
%>
    <script>alert('<%= errorMessage %>');</script>
<%
    }
%>


<html>
<head>
    <title>Accueil</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            color: #333;
        }
	a {
    	text-decoration: none;
    		color: inherit;
		}
        
        .container {
            width: 80%;
            max-width: 1200px; /* Adjusted for better layout on large screens */
            background-color: #fff;
            padding: 40px; /* Increased padding for aesthetics */
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
        }
        .category {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 40px; /* Increased margin for better separation */
        }
        .category-title {
            margin-bottom: 20px; /* Space between title and cards */
            text-align: center;
            font-size: 24px; /* Larger font size for titles */
            color: #444;
            width: 100%;
        }
        .cards {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
        }
        .card {
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 10px;
            padding: 20px;
            margin: 10px;
            width: 300px; /* Adjusted card width for better layout */
            text-align: center;
            transition: box-shadow 0.3s ease; /* Smooth transition for hover effect */
        }
        .card span {
            text-decoration: none;
                display: block; 
            
            color: deepskyblue;
            font-weight: bold;
        }
        .card > * {
 			   text-decoration: none;
    			color: deepskyblue;
    			font-weight: bold;
}
        .card:hover {
            box-shadow: 0 6px 12px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            color: #444;
            margin-bottom: 40px; /* Space after the welcome message */
        }
    </style>
</head>
<body>
<div class="container">
    <%
        Utulisateur currentUser = AuthentificationUtil.getLoggedInUser(request);
        String welcomeMessage = currentUser != null ? "Bienvenue, " + currentUser.getNom() : "Bienvenue, Visiteur";
        boolean isAdmin = currentUser != null && "admin".equals(currentUser.getRole());
    %>

    <h2><%= welcomeMessage %></h2>

<div class="category">
    <div class="category-title">Offres</div>
    <div class="cards">
        <a href="offers.jsp" class="card">
            Les Offres
            <span>Voir les offres</span>
        </a>
        <a href="AddOffer.jsp" class="card">
            Ajouter une offre
            <span>Ajouter</span>
        </a>
        <a href="extendDeadline.html" class="card">
            Prolonger la date limite
            <span>Prolonger</span>
        </a>
    </div>
</div>
    
    <div class="category">
        <div class="category-title"><% if (isAdmin) { %>Utilisateurs<% } else { %>Votre compte<% } %></div>
        <div class="cards">
            <% if (isAdmin) { %>
            <a href="addUser.jsp" class="card">
            	
                	Ajouter un utilisateur
                	<span >Ajouter</span>
            	
            </a>
            
            <% } %>
            <a href="changePassword.jsp" class="card">
            	
                	Modifier le mot de passe
                	<span >Modifier</span>
            	
            </a>
			<a href="logout" onclick="return confirm('Êtes-vous sûr de vouloir vous déconnecter ?');" class="card">
            	
                	Se déconnecter
                	<span>Déconnexion</span>
            	
            </a>
        </div>
    </div>
</div>
</body>
</html>