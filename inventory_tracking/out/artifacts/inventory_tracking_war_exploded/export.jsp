<%--
  Created by IntelliJ IDEA.
  User: chenmingyu
  Date: 2022/1/16
  Time: 8:14 下午
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="dao" class="bean.GoodDaoImp" scope="request"/>
<%request.setCharacterEncoding("utf-8");%>




<html>
<head>
  <title>Good</title>
</head>
<body>


<%
  dao.export();
%>
<center>
Output as CSV file successfully <br>
<a href="index.jsp">Return Good List</a>

</center>
</body>
</html>

