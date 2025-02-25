<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
        }
        img {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        a {
            display: inline-block;
            margin-bottom: 20px;
            font-size: 18px;
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: left;
            width: 100%;
            max-width: 400px;
            display: flex;
            flex-direction: column;
        }
        form.img{
            text-align: center;
        }
        label {
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            margin-bottom: 15px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 12px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #008bff;
        }
    </style>
</head>
<body>
    <a href="paneer-roll.jpeg">Click here to grab paneer roll</a>

    <form action="addProfile" method="post">
        <img src="img/logo.png" alt="logo" width="100" height="100">

        <label for="fName">First Name:</label>
        <input id="fName" name="firstName" type="text" required>

        <label for="lName">Last Name:</label>
        <input id="lName" name="lastName" type="text" required>

        <label for="mail">Email:</label>
        <input id="mail" name="emailId" type="email" required>

        <label for="phNo">Mobile:</label>
        <input id="phNo" name="phNumber" type="text" required>

        <input type="submit" value="Add Profile">
    </form>
    <a href="./getAllProfiles">Click here to get all profile</a>
</body>
</html>
