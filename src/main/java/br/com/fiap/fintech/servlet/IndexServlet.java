package br.com.fiap.fintech.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/index") // Mapeamento do Servlet. Acessível via /FINYOU/index
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Não cria nova sessão se não existir

        // Verifica se o usuário já está logado
        if (session != null && session.getAttribute("usuarioLogado") != null) {
            // Usuário já está logado, redireciona para o dashboard
            System.out.println("IndexServlet: Usuário já logado, redirecionando para /dashboard");
            response.sendRedirect(request.getContextPath() + "/dashboard"); // /dashboard é o DashboardServlet
        } else {
            // Usuário não está logado, mostra a página index.jsp que está dentro da pasta /jsp
            System.out.println("IndexServlet: Usuário não logado, encaminhando para /jsp/index.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}