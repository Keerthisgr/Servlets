<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="bcp" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Profiles</title>
    <style>
        body {
            text-align: center;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
        }
        .logo {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 150px;
            margin-bottom: 5px;
        }

        table {
            border-collapse: collapse;
            width: 50%;
            margin-left:5%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f0f0f0;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #ddd;
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
    </style>
</head>
<body>
    <img src="img/logo.png" alt="Company Logo" class="logo">
    <h1>User Profiles</h1>
    <table>
        <tr>
            <th>Sl.No</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Action</th>
        </tr>

        <bcp:forEach items= "${ listOfProfiles }" var="userProfile" varStatus="status">
            <tr>
                <td> ${ status.count } </td>
                <td> ${ userProfile.getFirstName() } </td>
                <td> ${ userProfile.getLastName() } </td>
                <td> ${ userProfile.getEmail() } </td>
                <td> ${ userProfile.getPhNumber() } </td>
                <td><a href="delete?anyThing=${userProfile.getUserId()}">DELETE</a> &nbsp;
                <a href="getProfile?userId=${userProfile.getUserId()}">UPDATE</a></td>
            </tr>
        </bcp:forEach>
    </table>

</body>
</html>