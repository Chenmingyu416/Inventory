<%--
  Created by IntelliJ IDEA.
  User: chenmingyu
  Date: 2022/1/16
  Time: 11:22 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<h1>Add Good</h1>
<form method="post" action="DoAddGood"  onsubmit = "return check(this)">
    <table>
        <tr><td>Good Id<td><input type="text" name="goodId"/></td></tr>
        <tr><td>GoodName</td><td><input type="text" name="goodName"/></td></tr>
        <tr><td>Type</td><td><input type="text" name="type"/></td></tr>
        <tr><td>Supplier</td><td><input type="text" name="supplier"/></td></tr>
        <tr><td>Count</td><td><input type="text" name="count"/></td></tr>
        <tr><td>Price</td><td><input type="text" name="price"/></td></tr>
        <tr><td><center><input type="submit" value="submit"  ></center></td></tr>
    </table>
</form>
</center>
</body>
</html>
