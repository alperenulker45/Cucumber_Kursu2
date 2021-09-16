package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {
        String url = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        String user = "technostudy";
        String password = "zhTPis0l9#$&";
        // Veritabanına ulaşabilmek için JDBC ye : db nini tipi (mysql), db nin yolu (test.medis.mersys.io)
        // db nin bulunduğu bilgisayarın içindeki mysql db nin port numarası (33306) ve db nin adı verildi.

        Connection connection= DriverManager.getConnection(url, user, password);// bağlantı sağlandı.

        Statement statement = connection.createStatement(); // sorgularımı çalıştırabilmek için bir yol oluştur.

        ResultSet rs=statement.executeQuery("select * from actor");
        // fakat performans için bütün sonuçlar bir anda rs ye aktarılmıyor.
        // Biz komut verdikçe satır satır gelecek.

        // 1.Satır
        rs.next(); // göstergeyi sonraki adıma getir, orada satır varsa, bütün satırı rs ye at. yani burada ilk satır

        String firstName= rs.getString("first_name");
        String lastName = rs.getString(3); // kolunun indexini de verebiliriz (1 ilk kolon)

        System.out.println(firstName +" "+ lastName);

        // 2.Satır
        rs.next(); // göstergeyi sonraki adıma getir, orada satır varsa, bütün satırı rs ye at. yani burada ilk satır

        firstName= rs.getString("first_name");
        lastName = rs.getString("last_name"); // kolunun indexini de verebiliriz (1 ilk kolon)

        System.out.println(firstName +" "+ lastName);

        connection.close();
    }



}
