<%-- 
    Document   : index
    Created on : 7 janv. 2024, 21:12:23
    Author     : Tmehyg
--%>
<%@ page import="models.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Favicon -->
    <link rel="stylesheet" href="assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />


  
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        <div class = "container">
            
            <div class="card mx-auto" style="width: 80%; height: 300px;">
                <p>choiser votre patient(e)</p>   
            <form action="GetAfaire" method ="POST">
            
            <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Patient</label>
                <select class="form-control" id="basic-default-name" name="patient">
                                    <% Client[] li = (Client[]) request.getAttribute("list");
                                           for (int i = 0; i < li.length; i++) {
                                               Client indice = li[i];
                                        %>
                                        <option value="<%= indice.getId() %>"><%= indice.getNom() %></option>
                                        <%
                                           }
                                        %>
               </select>
          </div>
            <input  class = "btn btn-primary" type="submit" value="Valider" />
          
        </form> 
        </div>
       </div>
               
               <a href="Insert_Dent.jsp"> insert </a>
    </body>
</html>
