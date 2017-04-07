<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cria Registro de Equipamento</title>
    </head>
    <body>
        <h1>Cria Registro de Equipamento</h1>
        <form method="post">
            <div><label>Serie: <input type="text" name="serie"  /></label></div>
            <div><label>Local: <input type="text" name="local"  /></label></div>
            <div><label>Descrição: <input type="text" name="descricao"  /></label></div>
            Estado: <select name="estado">
                <option value="-1"></option>
                <option value="0">Novo</option>
                <option value="1">Em uso</option>
                <option value="2">Danificado</option>
                <option value="3">Perdido</option>
            </select>
            <div><input type="submit"/></div>
        </form>
    </body>
</html>
