<%@ page import="Model.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href=".././css/DefaultStyle.css">
    <title>Carrello</title>

</head>
<body>

<div class="wrapper"> <!--Inizio finestra principale -->
    <div class="image"> <!-- Inizio Logo del Sito -->
        <img src=".././images/dellobuonologo.jpg" style="width:10%;height:100%;float:left">
    </div>  <!-- Fine Logo del Sito -->
    <div class="navbar">   <!-- Inizio barra navigazionale -->
        <form action ="../servlet-navigation">
            <label id="navigation">
                <button type="submit" name="Home" value="Home">Home</button>
            </label>
            <label id="navigation1">
                <button type="submit" name="Prodotti" value="Prodotti">Prodotti</button>
            </label>
            <label id="navigation2">
                <button type="submit" name="Galleria" value="Galleria">Galleria</button>
            </label>
            <label id="navigation3">
                <button type="submit" name="Info" value="Info">Info</button>
            </label>
        </form>
    </div>  <!-- Fine barra navigazionale -->
        <%
        Utente utente = (Utente) getServletConfig().getServletContext().getAttribute("utente");
        if(utente == null){
    %>
    <div class="login"> <!-- Inizio LogIn -->

        <form action="../servlet-utente" method="post">
            <label for="email">Email:</label><br>
            <input type="text" id="email" name="email">
            <div class="carrello">
                <a href=".././View/carrello.jsp">
                    <img src=".././images/shopping-cart.png" alt="carello" style="width:42px;height:42px;border:0;">
                </a>
            </div>
            <br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password">
            <input type="submit" name="accedi" id="accedi" value="Accedi">
            <input type="submit" name="registrati" id="registrati" value="Registrati">
        </form>
    </div> <!-- Fine LogIn -->
        <%
        }
        else{
    %>
    <div class="utenteview"> <!--Inizio rettangolo benvenuto utente -->
        <p>Benvenuto <%utente.getE_mail();%>!</p> <br>
        <form action="servlet-utente">
            <label for="logout">Logout</label>
            <input id="logout" name="logout">
            <input type="submit">
        </form>
    </div> <!--Fine rettangolo benvenuto utente -->

        <%
        }
    %>


</body>
</html>
