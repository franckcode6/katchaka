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
        
        <label for="ville_id">Ville</label>
        <select name="VILLE_ID">
            <option value="0">Merci de choisir une ville</option>
            <c:forEach items="${villes}" var="ville">
                <option value="${ville.id}">${ville.nom}</option>
            </c:forEach>
        </select><br>
        
        <label for="genre_id">Genre</label>
        <select name="GENRE_ID">
            <option value="0">Merci de choisir un genre</option>
            <c:forEach items="${genres}" var="genre">
                <option value="${genre.id}">${genre.nom}</option>
            </c:forEach>
        </select><br>
        
        <label for="genre_recherche_id">Genre recherché</label>
        <select name="GENRE_RECHERCHE_ID">
            <option value="0">Quel genre recherchez vous?</option>
            <c:forEach items="${genres}" var="genre">
                <option value="${genre.id}">${genre.nom}</option>
            </c:forEach>
        </select><br>
        
         <label for="statut_id">Statut</label>
        <select name="STATUT_ID">
            <option value="0">Merci de choisir un statut</option>
            <c:forEach items="${statuts}" var="statut">
                <option value="${statut.id}">${statut.nom}</option>
            </c:forEach>
        </select><br>
        
       <label for="interet">Interet 1</label><input name="INTERET1"><br> 
       <label for="interet">Interet 2</label><input name="INTERET2"><br>
       <label for="interet">Interet 3</label><input name="INTERET3"><br>
       <label for="interet">Interet 4</label><input name="INTERET4"><br>
        
        
        <label for="bio">Bio</label><textarea name="BIO"></textarea> <br> 
        
        <label for="date">Date de naissance</label>
        <input type="date" name="DATE_DE_NAISSANCE"><br>
        
        <label for="fumeur">Fumeur</label>
        <input type="checkbox" name="FUMEUR" checked><br>
        
         <input class ="button" type="submit" value="S'inscrire">
    </form>
</body>
</html>