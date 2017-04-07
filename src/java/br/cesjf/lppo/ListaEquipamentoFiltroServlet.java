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

@WebServlet(name = "ListaEquipamentoFiltroServlet", urlPatterns = {"/listaFiltro.html"})
public class ListaEquipamentoFiltroServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/lista-registros-filtro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer estado_filtro = Integer.parseInt(request.getParameter("estado_filtro"));
        List<Equipamento> equipamentos = new ArrayList<>();
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = null;
            if (estado_filtro == -1) {
               resultado = operacao.executeQuery("SELECT * FROM equipamento");
            } else {
                resultado = operacao.executeQuery("SELECT * FROM equipamento WHERE estado="+estado_filtro.toString());
            }
            
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
            Logger.getLogger(ListaEquipamentoFiltroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentoFiltroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("equipamentos", equipamentos);
        request.getRequestDispatcher("WEB-INF/lista-registros.jsp").forward(request, response);

    }
}
