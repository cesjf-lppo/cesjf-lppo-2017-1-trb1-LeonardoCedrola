<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Equipamentos</title>
    </head>
    <body>
        <h1>Listagem de Equipamentos</h1>
        <a href="novo.html">Nova reclamação</a>
        <td><a href="listaFiltro.html">Listar com filtros</a></td>
        <table>
            <tr>
                <th>ID</th>
                <th>Serie</th>
                <th>Local</th>
                <th>Descrição</th>
                <th>Estado</th>
                <th>Editar</th>
            </tr>
            <c:forEach var="equipamento" items="${equipamentos}">
                <tr>
                    <td>${equipamento.id}</td>
                    <td>${equipamento.serie}</td>
                    <td>${equipamento.local}</td>
                    <td>${equipamento.descricao}</td>
                    <td>${equipamento.stringEstado()}</td>
                    <td><a href="edita.html?id=${equipamento.id}">Editar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
