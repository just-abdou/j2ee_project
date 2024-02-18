<%@page import="lesServlets.Utulisateur"%>
<%@page import="lesServlets.AuthentificationUtil"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier le mot de passe</title>
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
            width: 400px; /* Adjusted for form size */
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            display: flex;
            flex-direction: column;
        }
        h2 {
            text-align: center;
            color: #444;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 20px;
        }
        input[type="password"] {
            margin: 10px 0;
            padding: 10px;
            width: calc(100% - 20px); /* Adjust width to account for padding */
            border: 1px solid #ddd;
            border-radius: 5px;
            display: block;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: deepskyblue;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s ease-in-out;
            width: 100%; /* Make the button full-width */
            box-sizing: border-box; /* Ensures padding and border are included in total width */
        }
        input[type="submit"]:hover {
            background-color: dodgerblue;
        }
    </style>
</head>
<body>
<div class="container">
  

    <h2>Modifier le mot de passe.</h2>
    
    <form action="ChangePasswordWebService" method="post">
        <div>Ancien mot de passe: <input type="password" name="oldPassword" required></div>
        <div>Nouveau mot de passe: <input type="password" name="newPassword" required></div>
        <input type="submit" value="Modifier le mot de passe">
    </form>
</div>
</body>
</html>