package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import bean.*;

@WebServlet(name = "DoDeleteGood", value = "/DoDeleteGood")
public class DoDeleteGood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String goodId=request.getParameter("goodId");
        GoodDao goodDao=new GoodDaoImp();
        //call the delete in db
        int n=goodDao.delete(goodId);
        if(n>0)
            response.sendRedirect("index.jsp");
        else
            response.sendRedirect("error.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
