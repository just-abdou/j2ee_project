<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Apple Offer</title>
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
            width: 500px; /* Width adjusted for form */
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            display: flex;
            flex-direction: column;
            align-items: left; /* Align items to the left for form */
        }
        h2 {
            text-align: center;
            color: #444;
        }
        form {
            width: 100%;
        }
        label {
            margin-top: 10px;
        }
        input[type="number"], input[type="date"], input[type="text"] {
            margin: 10px 0;
            padding: 10px;
            width: calc(100% - 22px); 
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
            transition: background 0.3s ease;
            width: 100%; 
            box-sizing: border-box;
        }
        input[type="submit"]:hover {
            background-color: dodgerblue;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Add new Apple Offer</h2>
    <form action="AddAppleOffer" method="post">
        <label for="budget">Budget (in dollars):</label>
        <input type="number" id="budget" name="budget" step="0.01" required><br>

        <label for="dateLimite">Expiration Date:</label>
        <input type="date" id="dateLimite" name="dateLimite" required><br>
        
        <label for="organisme">Issuing Organization:</label>
        <input type="text" id="organisme" name="organisme" required><br>
        
        <label for="contact">Contact Person:</label>
        <input type="text" id="contact" name="contact" required><br>
        
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>