<%@ page import="java.util.List" %>
<%@ page import="lesServlets.ModelAppleOffre" %>
<%@ page import="lesServlets.AppleOffers" %>
<%@ page import="lesServlets.Utulisateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); %>

<html>
<head>
    <title>Offer List</title>
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
        
        .container {
            width: 80%;
            max-width: 1200px;
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            margin-top: 20px; /* Added to ensure some separation between elements */
        }
        table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 10px;
            overflow: hidden;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:hover {background-color: #f5f5f5;}
        h1 {
            text-align: center;
            color: #444;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: deepskyblue;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px 0;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
<%
    List<ModelAppleOffre> offerList = AppleOffers.getOffers();
    Utulisateur currentUser = (Utulisateur) session.getAttribute("utilisateur");
    boolean isAdmin = currentUser != null && "admin".equals(currentUser.getRole());
%>

<h1>Offer List</h1>

<% if (isAdmin) { %>
    <button class="button" onclick="showAddOfferDialog()">Add New Offer</button>
<% } %>

<table>
    <tr>
        <th>ID</th>
        <th>Budget Prévisionnel</th>
        <th>Date Limite</th>
        <th>Organisme Émetteur</th>
        <th>Contact Personne Gère AO</th>
        <% if (isAdmin) { %>
            <th>Actions</th>
        <% } %>
    </tr>
<% for(ModelAppleOffre offer : offerList) { %>
<tr>
    <td><%= offer.getId() %></td>
    <td><%= offer.getBudgetPrevisionnel() %></td>
    <td>
        <%= sdf.format(offer.getDateLimite()) %>
    </td>
    <td><%= offer.getOrganismeEmetteur() %></td>
    <td><%= offer.getContactPersonneGereAO() %></td>
    <% if (isAdmin) { %>
        <td>Edit | Delete</td>
    <% } %>
</tr>
<% } %>
</table>
</div>

<script>
    function showAddOfferDialog() {
        // Implement the logic to show dialog for adding a new offer
    }
</script>

</body>
</html>