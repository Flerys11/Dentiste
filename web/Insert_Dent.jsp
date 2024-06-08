<%-- 
    Document   : Insert_Dent
    Created on : 8 janv. 2024, 08:52:57
    Author     : Tmehyg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" href="assets/vendor/css/core.css" class="template-customizer-core-css" />
        <link rel="stylesheet" href="assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
        <title>JSP Page</title>
    </head>
    <body>
            <div class = "container">
                <p>Insert Etat Dent</p>
            
            <div class="card mx-auto" style="width: 80%; height: 300px;">
                <p>choiser votre patient(e)</p>   
            <form action="Insert" method ="POST">
            
            <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Patient</label>
            <input type="text" name="patient">
          </div>
          <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Nify</label>
            <input type="text" name="nify">
          </div>
         <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Etat</label>
            <input type="text" name="etat">
          </div>
            <input  class = "btn btn-primary" type="submit" value="Valider" />
          
        </form> 
        </div>
    </body>
</html>
