package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class proizvodi {

    private int pid;
    private String name;

   public String getName(){
       return name;
   }
   public int getPid(){
       return pid;
   }
   public void setName(String name){
       this.name = name;
   }
   public void setPID(int pid) {
       this.pid = pid;
   }

    public static String prikazProizvoda() throws ClassNotFoundException {

        StringBuilder prikaz_proizvoda = new StringBuilder();

        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebProdavnica?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "kjpu8vk6");) {

            Statement st = conn.createStatement();
            st.executeQuery("select  proizvod_id, proizvod_ime from proizvodi");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {

                prikaz_proizvoda.append(rs.getInt("proizvod_id"));
                prikaz_proizvoda.append(".  ");
                prikaz_proizvoda.append(rs.getString("proizvod_ime"));
                prikaz_proizvoda.append("\n");

            }

        } catch (SQLException ex) {

            prikaz_proizvoda.append(ex.getMessage());

        }

        return prikaz_proizvoda.toString();

    }

    public void kreiranjeProizvoda() throws ClassNotFoundException {
 
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebProdavnica?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "kjpu8vk6");) {

            if(name != null && !(name.isEmpty())) {

                Statement st = conn.createStatement();
                st.executeUpdate("insert into proizvodi (proizvod_ime) values ('" + name + "') ");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void brisanjeProizvoda() throws ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebProdavnica?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "kjpu8vk6");)
        {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from proizvodi where proizvod_ime ='" + name +  "'");
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

}
