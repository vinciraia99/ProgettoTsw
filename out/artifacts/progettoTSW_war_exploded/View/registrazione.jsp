<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/04/2020
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/DefaultStyle.css">
    <title>Registrazione</title>

</head>
<body>
<div class="wrapper"> <!--Inizio finestra principale -->
    <div class="image"> <!-- Inizio Logo del Sito -->
        <img src="images/dellobuonologo.jpg" style="width:10%;height:100%;float:left">
    </div>  <!-- Fine Logo del Sito -->
    <div class="navbar">   <!-- Inizio barra navigazionale -->
        <form action ="/servlet-navigation">
            <label id="navigation">
                <button type="submit" name="Home">Home</button>
            </label>
            <label id="navigation1">
                <button type="submit" name="Prodotti">Prodotti</button>
            </label>
            <label id="navigation2">
                <button type="submit" name="Galleria">Galleria</button>
            </label>
            <label id="navigation3">
                <button type="submit" name="Info">Info</button>
            </label>
        </form>
    </div>  <!-- Fine barra navigazionale -->
    </div><!---Fine finestra principale --->

    <div class="registrazione">
        <form action="servlet-registrazione" method="post">
            <label for="nome">Nome:</label><br>
            <input type="text" id="nome" name="nome"> <br>
            <label for="cognome"> Cognome: </label><br>
            <input type="text" id="cognome" name="cognome"><br>
            <label for="email">Email:</label><br>
            <input style="background:none; padding-left:0px;" type="text" id="email" name="email"> <br>
            <label for="nascita">Data di nascita:</label><br>
            <input type="date" id="nascita" name="nascita"><br>
            <label for="password"> Password:</label><br>
            <input style="background:none; padding-left:0px;" type="password" id="password" name="password">
            <input type="submit" id="registrati" name="registrati" value="registrati">
        </form>
    </div> <!-- Fine registrazione --->
</body>
</html>
