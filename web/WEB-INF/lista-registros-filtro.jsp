<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Equipamentos</title>
    </head>
    <body>
        <h1>Cria Registro de Equipamento</h1>
        <form method="post">
            Estado: <select name="estado_filtro">
                <option value="-1">Sem Filtro</option>
                <option value="0">Novo</option>
                <option value="1">Em uso</option>
                <option value="2">Danificado</option>
                <option value="3">Perdido</option>
            </select>
            <div><input type="submit"/></div>
        </form>
    </body>
</html>
