<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <title>First Web Application</title>
    </head>

    <body>
        Seu nome &eacute; : ${name}

        <a href="/usuario/novo">Clique aqui para cadastrar</br></br>

        Lista de todos os usu&aacute;rios:</br>

        <table>
            <tr>
                <th>Nome</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${todos}" var="user" varStatus="tagStatus">
              <tr>
                <td>${user.nome}</td>
                <td>${user.email}</td>
              </tr>
            </c:forEach>
        </table>

    </body>

</html>