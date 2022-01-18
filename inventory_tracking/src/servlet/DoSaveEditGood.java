package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import bean.*;

@WebServlet(name = "DoSaveEditGood", value = "/DoSaveEditGood")
public class DoSaveEditGood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String goodId=request.getParameter("goodId");
        String goodName=request.getParameter("goodName");
        String type=request.getParameter("type");
        String supplier=request.getParameter("supplier");
        int count=Integer.parseInt(request.getParameter("count"));
        float price=Float.parseFloat(request.getParameter("price"));

        //add data in bean class
        Good good=new Good();
        good.setGoodId(goodId);
        good.setGoodName(goodName);
        good.setType(type);
        good.setSupplier(supplier);
        good.setCount(count);
        good.setPrice(price);

        //call the update method
        GoodDao goodDao=new GoodDaoImp();
        int n=goodDao.update(good);
        if(n>0){
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("error.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
