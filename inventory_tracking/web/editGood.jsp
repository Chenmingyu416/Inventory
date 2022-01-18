<%--
  Created by IntelliJ IDEA.
  User: chenmingyu
  Date: 2022/1/17
  Time: 2:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="bean.*" %>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>Title</title>
    <%
        Good good=(Good)request.getAttribute("good");
    %>
    <script language="javascript" type="">
    function check(form) {
          if(form.goodId.value=='') {
                alert("Please enter the Good ID");
                form.goodId.focus();
                return false;
          }
          if(form.goodName.value==''){
                alert("Please enter the Good Name");
                form.goodName.focus();
                return false;
          }
          if(!isNaN(Number(form.goodName.value))){
                alert("Type cannot be the number. Please enter the valid Good Name");
                form.count.focus();
                return false;
          }

          if(form.type.value==''){
                alert("Please enter the type");
                form.type.focus();
                return false;
          }
          if(!isNaN(Number(form.type.value))){
                alert("Type cannot be the number. Please enter the valid type");
                form.count.focus();
                return false;
          }

          if(form.supplier.value==''){
                alert("Please enter the supplier");
                form.supplier.focus();
                return false;
          }

          if(!isNaN(Number(form.supplier.value))){
                alert("Supplier cannot be the number. Please enter the valid supplier");
                form.count.focus();
                return false;
          }
          if(form.count.value==''){
                alert("Please enter the count");
                form.count.focus();
                return false;
          }
          if(isNaN(Number(form.count.value))){
                alert("Please enter the count as number");
                form.count.focus();
                return false;
          }
          else if(Number(form.count.value)<0){
                alert("Please enter positive number as the valid count");
                form.count.focus();
                return false;
          }
          if(form.price.value==''){
                alert("Please enter the price");
                form.price.focus();
                return false;
          }
          if(isNaN(Number(form.price.value))){
                alert("Please enter the number as the price");
                form.price.focus();
                return false;
          }else if(Number(form.price.value)<0){
                alert("Please enter the positive number as valid price");
                form.price.focus();
                return false;
          }
          return true;
    }

</script>
</head>
<body>
<center>
<h1>Edit Information</h1>

<form method="post" action="DoSaveEditGood" onsubmit = "return check(this)">
    <table>
        <tr><td>Good ID</td>
            <td><input type="text" name="goodId" readOnly="true"
                       value="<%=good.getGoodId() %>"/></td></tr>
        <% session.setAttribute("goodId",good.getGoodId());%>
        <tr><td>Good Name</td>
            <td><input type="text" name="goodName"
                       value="<%=good.getGoodName()%>"/></td></tr>
        <tr><td>Type</td>
            <td><input type="text" name="type"
                       value="<%=good.getType() %>"/></td></tr>
        <tr><td>Supplier</td>
            <td><input type="text" name="supplier"
                       value="<%=good.getSupplier() %>"/></td></tr>
        <tr><td>Count</td>
            <td><input type="text" name="count"
                       value="<%=good.getCount() %>"/></td></tr>
        <tr><td>Price</td>
            <td><input type="text" name="price"
                       value="<%=good.getPrice()%>"/></td></tr>

        <tr><td><input type="submit" value="submit"/></td></tr>
    </table>
</form><br>
</center>
</body>
</html>
