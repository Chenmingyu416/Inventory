package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import bean.*;

@WebServlet(name = "ToEditGood", value = "/ToEditGood")
public class ToEditGood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String goodId=request.getParameter("goodId");
        GoodDao goodDao=new GoodDaoImp();

        Good good=goodDao.findById(goodId);
        request.setAttribute("good",good);
        request.getRequestDispatcher("editGood.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
