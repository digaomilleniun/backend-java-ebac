<html>

    <head>
        <title>First Web Application</title>
        <meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>
    </head>

    <body>
        <form method="post" action="/usuario/salvar" commandName="Usuario">
            <font color="red">${errorMessage}</font>
            Nome : <input type="text" name="nome" />

            <font color="red">${errorMessage}</font>
            Email : <input type="text" name="email" />
            <input type="submit" />
        </form>
    </body>

</html>