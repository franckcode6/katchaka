<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Page d'inscription</h1>

<form action="inscription" method="post">
        <label for="pseudo">Pseudo</label><input name="PSEUDO"><br> 
        <label for="email">Email</label><input type="email"  name="EMAIL"><br> 
        <label for="mot_de_passe">Mot de passe</label><input type="password" name="MOT_DE_PASSE"><br> 
        <label for="bio">Mot de passe</label><input name="BIO"><br> 
        <label for="ville_id">Ville</label>
        <select name="VILLE_ID">
            <option value="0">Merci de choisir une ville</option>
            <c:forEach items="${villes}" var="ville">
                <option value="${ville.id}">${ville.nom}</option>
            </c:forEach>
        </select><br> <input class ="button" type="submit" value="inscription">
    </form>
</body>
</html>