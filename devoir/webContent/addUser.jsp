<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un utilisateur</title>
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
            width: 500px; /* Optimized for form size */
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            display: flex;
            flex-direction: column;
            align-items: left;
        }
        h2 {
            text-align: center;
            color: #444;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        input[type=text], input[type=password] {
            margin: 10px 0;
            padding: 10px;
            width: calc(100% - 22px); /* Adjust width to account for padding */
            border: 1px solid #ddd;
            border-radius: 5px;
            display: block;
        }
        select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff;
            display: block;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: deepskyblue;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s ease;
            width: 100%; /* Make button full width */
            box-sizing: border-box; /* Ensures padding doesn't affect width */
        }
        input[type="submit"]:hover {
            background-color: dodgerblue;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Ajouter un utilisateur</h2>
    
    <form action="AddUserWebService" method="post">
        <div>Nom: <input type="text" name="nom" required></div>
        <div>Prénom: <input type="text" name="prenom" required></div>
        <div>Login: <input type="text" name="login" required></div>
        <div>Mot de passe: <input type="password" name="motDePasse" required></div>
        <div>Mail: <input type="text" name="mail" required></div>
        <div>Numéro de téléphone: <input type="text" name="numeroTelephone" required></div>
        <div>Rôle: 
            <select name="role" required>
                <option value="">Sélectionnez un rôle</option>
                <option value="admin">Admin</option>
                <option value="user">User</option>
            </select></div>
        <input type="submit" value="Ajouter l'utilisateur">
    </form>
</div>
</body>
</html>