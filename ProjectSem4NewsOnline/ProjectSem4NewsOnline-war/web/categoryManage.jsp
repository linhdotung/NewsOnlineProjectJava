<%-- 
    Document   : categoryManage
    Created on : 14-05-2013, 16:40:47
    Author     : Welcome
--%>

<%@page import="sessionBean.CategorySessionBean"%>
<%@page import="entityBean.Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr><th>ID</th><th>Name </th><th></th></tr>
            <%
           CategorySessionBean cateBean = new CategorySessionBean();
           List<Category> list = cateBean.getAllCategoryAndSubCategory();
           for(Category c : list){
           %>
           <tr><td><%=c.getCId() %></td><td><%=c.getCName()%></td><td><a href="#">Edit</a></td></tr>
           <%
           }
                 
%>
        </table>
    </body>
</html>
