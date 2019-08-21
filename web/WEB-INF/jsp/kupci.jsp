

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers - Web Shop</title>
    </head>
    <style>
        
        #div1 {
            text-align: center;
        }
        h1 {
            text-align: center;
        }
        #forma {
            text-align: center;
        }
       a {
            
            text-decoration: none;
            color: black;
            
        }
        
    </style>
    
    <body>

        <div id="div1">
            <a href="proizvodi.htm">Products</a>
            <a href="prodaja.htm">Sales</a>
        </div>

        <h1>Customers</h1>
        <br/>
        <textarea id="lista_kupaca" rows="15" cols="150" readonly>${sviKupci}</textarea>

        <br/>
        <form:form id="forma" method="POST" commandName="kupci" action="kupci.htm">

            <form:input type="text" path="name" placeholder="First and last name..." id="name"></form:input>
                <input type="submit" name="Dodaj" value="Add"/>
                <input type="submit" name="Obrisi" value="Delete"/>

        </form:form>



    </body>
</html>
