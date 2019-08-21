package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class kupci {

    private int id;
    private String name;
    private String korpa;

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKorpa() {
        return korpa;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKorpa(String korpa) {
        this.korpa = korpa;
    }

    public static String prikazKupaca() throws ClassNotFoundException {

        StringBuilder prikaz_kupaca = new StringBuilder();
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebProdavnica?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "kjpu8vk6");) {

            Statement st = conn.createStatement();
            st.executeQuery("select kupci_id, kupci_ime, korpa from kupci");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {

                String korpa = rs.getString("korpa");
                if (rs.getString("korpa") == null) {
                    korpa = "Chart is empty";
                }

                prikaz_kupaca.append(rs.getInt("kupci_id"));
                prikaz_kupaca.append(". ");
                prikaz_kupaca.append(rs.getString("kupci_ime"));
                prikaz_kupaca.append(" || Chart: ");
                prikaz_kupaca.append(korpa);
                prikaz_kupaca.append("\n");

            }

        } catch (SQLException ex) {

            prikaz_kupaca.append(ex.getMessage());

        }

        return prikaz_kupaca.toString();

    }

    public void kreiranjeKupaca() throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebProdavnica?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "kjpu8vk6");) {

            if (name != null && !(name.isEmpty())) {

                Statement st = conn.createStatement();
                st.executeUpdate("insert into kupci (kupci_ime) values ('" + name + "')");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void brisanjeKupca() throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebProdavnica?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "kjpu8vk6");) {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from kupci where kupci_ime= '" + name + "' ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
