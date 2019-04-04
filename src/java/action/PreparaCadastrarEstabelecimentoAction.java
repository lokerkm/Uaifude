/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Endereco;
import model.Estabelecimento;
import persistence.CategoriaDAO;
import persistence.EnderecoDAO;
import persistence.EstabelecimentoDAO;

/**
 *
 * @author kevin
 */
public class PreparaCadastrarEstabelecimentoAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        
       
        try {

           List<Categoria> categorias = CategoriaDAO.getInstance().getCategorias();
            request.setAttribute("categorias", categorias);

            RequestDispatcher view = request.getRequestDispatcher("cadastraEstabelecimento.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
