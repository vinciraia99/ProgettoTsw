package Control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet-navigation")
public class ServletNavigation extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String home= req.getParameter("Home");
        String prodotti= req.getParameter("Prodotti");
        String galleria = req.getParameter("Galleria");
        String info= req.getParameter("Info");

        if(home!=null){
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("homepage.jsp");
            dispatcher.forward(req, resp);
        }else if(prodotti!=null){
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("./View/prodotti.jsp");
            dispatcher.forward(req, resp);
        }else if(galleria!=null){
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("./View/galleria.jsp");
            dispatcher.forward(req, resp);
        }else if(info!=null){
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("./View/info.jsp");
            dispatcher.forward(req, resp);
        }


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);

    }



}
