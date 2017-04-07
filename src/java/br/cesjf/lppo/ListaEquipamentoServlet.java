package br.cesjf.lppo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaEquipamentoServlet", urlPatterns = {"/lista.html"})
public class ListaEquipamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Equipamento> equipamentos = new ArrayList<>();

        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM equipamento ORDER BY local");
            while(resultado.next()){
                Equipamento equipamento = new Equipamento();
                equipamento.setId(resultado.getLong("id"));
                equipamento.setSerie(resultado.getString("serie"));
                equipamento.setLocal(resultado.getString("local"));
                equipamento.setDescricao(resultado.getString("descricao"));
                equipamento.setEstado(resultado.getInt("estado"));
                equipamentos.add(equipamento);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("equipamentos", equipamentos);
        request.getRequestDispatcher("WEB-INF/lista-registros.jsp").forward(request, response);
    }

}
