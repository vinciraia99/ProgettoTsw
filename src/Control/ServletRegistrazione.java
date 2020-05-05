package Control;

import Model.Utente;
import Model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet-registrazione")
public class ServletRegistrazione extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtenteDAO service_user= new UtenteDAO();
        String nome= req.getParameter("nome");
        String cognome=req.getParameter("cognome");
        String email=req.getParameter("email");
        String nascita= req.getParameter("nascita");
        String password=req.getParameter("password");
        Utente user= new Utente(email,nome,cognome,nascita,password);
        service_user.updateUser(user);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
