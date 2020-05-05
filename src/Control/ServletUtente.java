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

@WebServlet("/servlet-utente")
public class ServletUtente extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtenteDAO serviceu = new UtenteDAO();

        String loginButton= req.getParameter("accedi");
        String registrationButton= req.getParameter("registrati");
        String carrelloButton = req.getParameter("carrello");

        if(registrationButton!=null){

            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/View/registrazione.jsp");
            dispatcher.forward(req, resp);
        }else if(loginButton!=null){
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            Utente user = serviceu.doRetrieveByUsernamePassword(email,password);
            getServletContext().setAttribute("utente",user);

            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("homepage.jsp");
            dispatcher.forward(req, resp);
        }else if(carrelloButton!=null){
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/View/carrello.jsp");
            dispatcher.forward(req, resp);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
