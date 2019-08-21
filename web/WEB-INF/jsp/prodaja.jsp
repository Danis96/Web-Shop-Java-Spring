<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sale - Web Shop</title>
    </head>
    <style>
        a {
            
            text-decoration: none;
            color: black;
            
        }
        #div1, a, h1 {
            text-align: center;
        }
    </style>
    
    <body>

        <div id="div1">
            <a href="kupci.htm">Customers</a>

           <a href="proizvodi.htm">Products</a>
        </div>

        <h1>Sale</h1>
        <h3 id="kupciT">Customers: </h3>
        <textarea id="lista_kupaca" rows="15" cols="90" readonly>${sviKupci}</textarea>
        <h3 id="proizvodiT">Products: </h3>
        <textarea id="lista_proizvoda" rows="15"  cols="90" readonly>${sviProizvodi}</textarea>


        <form:form action="prodaja.htm" method="post" commandName="prodaja" id="forma">

            <form:label path="kupac">Customer number: </form:label>
            <form:input type="number" id="kupac" path="kupac" ></form:input>
            <form:label path="proizvod">Product number: </form:label>
            <form:input type="number" id="proizvodi" path="proizvod"></form:input>
            <input type="submit" name="Prodaj" value="Sell"/>
            
        </form:form>


    </body>
</html>
