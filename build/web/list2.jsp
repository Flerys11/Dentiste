<%-- 
    Document   : list
    Created on : 7 janv. 2024, 21:56:35
    Author     : Tmehyg
--%>
<%@ page import="models.Afaire" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Afaire> result = (List<Afaire>)request.getAttribute("result"); 
   Double valeurCoutTotal = (Double) request.getAttribute("valeur_cout_total");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
        <title>JSP Page</title>
    </head>
    <body>

<div class="container">
   <h1>Resultats</h1>
   <h3>Nom du Client : <%= result.get(0).getNom_client() %></h3>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID Nify</th>
          <th scope="col">NOM Nify</th>
          <th scope="col">COUT</th>
        </tr>
      </thead>
      <tbody>
<%
    if (result != null && !result.isEmpty()) {
        for (int i = 0; i < result.size(); i++) {
            Afaire indice = result.get(i);
%>          
        <tr>
          <th scope="row"> <%= indice.getIdnify() %></th>
          <td><%= indice.getNom_nify() %></td>
          <td><%= indice.getCout_total() %> Ar</td>
        </tr>
<%
    }
} else {
%>
<p>Aucun produit trouvé.</p>
<%
    }
%>

      </tbody>
    </table>
            <h3>Cout Total : <%= valeurCoutTotal %> Ar</h3>
</div>   

    </body>
</html>
