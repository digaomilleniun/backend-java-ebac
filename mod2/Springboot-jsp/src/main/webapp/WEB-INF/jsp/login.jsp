<html>

    <head>
        <title>First Web Application</title>
        <meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>
    </head>

    <body>
        <font color="red">${errorMessage}</font>
        <form method="post" action="/login">
            Nome : <input type="text" name="name" />
            Senha : <input type="password" name="password" />
            <input type="submit" />
        </form>
    </body>

</html>