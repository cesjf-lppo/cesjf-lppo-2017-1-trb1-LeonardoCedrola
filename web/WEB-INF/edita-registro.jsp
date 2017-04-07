<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Equipamento</title>
    </head>
    <body>
        <h1>Edita Equipamento</h1>
        <form method="post">
            <div><input type="hidden" name="id" value="${equipamento.id}" /> id: ${equipamento.id}</div>
            <div><label>Serie: <input type="text" disabled="true" name="serie" value="${equipamento.serie}" /></label></div>
            <div><label>Local <input type="text" name="local" value="${equipamento.local}" /></label></div>
            <div><label>Descrição: <input disabled="true" type="text" name="descricao" value="${equipamento.descricao}" /></label></div>
            Estado: ${equipamento.stringEstado()} <select name="estado">
                <option value="${equipamento.estado}"></option>
                <option value="0">Novo</option>
                <option value="1">Em uso</option>
                <option value="2">Danificado</option>
                <option value="3">Perdido</option>
            </select>
            <div><input type="submit"/></div>
        </form>
    </body>
</html>
