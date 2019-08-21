
package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class prodaja {
    
    private int kupac;
    private  int proizvod;
    
    public int getKupac(){
        return kupac;
    }
    public int getProizvod(){
        return proizvod;
    }
    
    public void setKupac(int kupac){
        this.kupac = kupac;
    }
    
    public void setProizvod(int proizvod){
        this.proizvod = proizvod;
    }
    
    public static void prodaja(int kupac, int proizvod) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebProdavnica?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "kjpu8vk6");) {
            
            Statement st = conn.createStatement();
            st.executeQuery("select korpa from kupci where kupci_id= '" + String.valueOf(kupac) + "'");
            ResultSet rs = st.getResultSet();
            String korpa = null;
            while(rs.next())
            {
                korpa = rs.getString("korpa");
                
            }
            
            st.executeQuery("select proizvod_ime from proizvodi where proizvod_id= '" + String.valueOf(proizvod) + "' ");
            
            ResultSet rs2 = st.getResultSet();
            String imeProizvoda = null;
            while(rs2.next())
            {
                imeProizvoda = rs2.getString("proizvod_ime");
            }
            
            
            if(korpa == null) {
                st.executeUpdate("update kupci set korpa = '" + imeProizvoda +  " , " +  "' where kupci_id='" + String.valueOf(kupac) + "' ");
            } else {
                st.executeUpdate("update kupci set korpa='" + korpa + imeProizvoda + ", " + "' where kupci_id= '" +  String.valueOf(kupac) +  "' ");
            }
            
                st.executeUpdate("delete from proizvodi where proizvod_id='" + String.valueOf(proizvod) +  "' ");
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
