package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.io.*;
import bean.*;
import java.util.*;
import java.util.List;
import java.net.URLEncoder;



@WebServlet(name = "ExportGood", value = "/ExportGood")
public class ExportGood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置response
        response.setContentType("application/x-download;charset=utf-8");
        //生成样例数据

        List<Good> goods = Arrays.asList(new Good("0001", "coca", "baverage", "company", 10, 3));

        //设置文件名

        String fileName = "test1.csv";
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

        //获得打印流
        PrintWriter pw = response.getWriter();
        pw.println("goodId,goodName,type,supplier,count,price");

        StringBuilder sb = new StringBuilder();
        for (Good good : goods) {
            sb.append(good.getGoodId() + "," + good.getGoodName() + "," + good.getType() + "," + good.getSupplier() + "," + Integer.toString(good.getCount())+  "," + Float.toString(good.getPrice()) + "\n");
        }

        pw.print(sb);
        pw.close();
        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
