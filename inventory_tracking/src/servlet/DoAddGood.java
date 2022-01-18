package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import bean.*;

@WebServlet(name = "DoAddGood", value = "/DoAddGood")
public class DoAddGood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String goodId=request.getParameter("goodId");
        String goodName=request.getParameter("goodName");
        String type=request.getParameter("type");
        String supplier=request.getParameter("supplier");
        int count=Integer.parseInt(request.getParameter("count"));
        float price=Float.parseFloat(request.getParameter("price"));


        //add data in bean Title
        Good good=new Good();
        good.setGoodId(goodId);
        good.setGoodName(goodName);
        good.setType(type);
        good.setSupplier(supplier);
        good.setCount(count);
        good.setPrice(price);

        //call add in db
        GoodDao goodDao=new GoodDaoImp();
        int n=goodDao.add(good);

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
