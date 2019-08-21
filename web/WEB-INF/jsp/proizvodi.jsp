
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products - Web Shop</title>
    </head>
    <style>
        
        #div1, h1, #forma {
            text-align: center;
        }
        a {
           
            text-decoration: none;
            color: black;
            
        }
        
    </style>
    
    <body>

        <div id="div1">
            <a href="kupci.htm">Customers</a>

            <a href="prodaja.htm">Sales</a>
        </div>
        
        <h1>Products</h1>
        
        <br/>
        <textarea cols="150" rows="15" id="proizvodi_lista" readonly>${sviProizvodi}</textarea>
        <br/>
        
        <form:form id="forma" commandName="proizvodi" method="post" action="proizvodi.htm">
            
            <form:input id="name" path="name" placeholder="Product name..." type="text"></form:input>
            <input type="submit" name="ubaci" value="Add"/>
            <input type="submit" name="delete" value="Delete"/>
            
        </form:form>
        <br/>
        

    </body>
</html>
