<%--
  Created by IntelliJ IDEA.
  User: chenmingyu
  Date: 2022/1/16
  Time: 8:14 下午
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="bean.*, java.util.*" %>

<jsp:useBean id="dao" class="bean.GoodDaoImp" scope="request"/>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
  <title>Good</title>
</head>
<body>

<h1 ALIGN=center>Goods List</h1>
<center>
  <table bgcolor=lightgrey>
    <tr>
      <td>
        Good Id
      </td>
      <td>
        Good Name
      </td>
      <td>
        Type
      </td>
      <td>
        Supplier
      </td>
      <td>
        Count
      </td>
      <td>
        Price
      </td>
    </tr>
    <% List list=dao.getGoods();
      Good goods=null;
      for(int i=0;i<list.size();i++){

        goods=(Good)list.get(i);
    %>
    <tr bgcolor=cyan>
      <td><a href="ToEditGood?goodId=<%=goods.getGoodId() %>" >
        <%=goods.getGoodId() %>
      </a>
      </td>
      <td> <%=goods.getGoodName()%> </td>
      <td><%=goods.getType() %></td>
      <td><%=goods.getSupplier()%></td>
      <td><%=goods.getCount() %> </td>
      <td><%=goods.getPrice() %> </td>
      <td><a href="DoDeleteGood?goodId=<%=goods.getGoodId()%>">delete </a>

      </td>
    </tr>
    <% } %>
  </table><br>

  <a href="addGood.jsp">Add Good</a><br>
  <a href="export.jsp">Export Good</a>

</center>
</body>
</html>



