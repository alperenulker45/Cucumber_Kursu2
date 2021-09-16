package _JDBC.Gun2;

import _JDBC._JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_GetAllRow extends _JDBCParent {

    @Test
    private void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from customer");

        int rowCount = 0;
        while (rs.next()) {
            String ad = rs.getString("first_name");
            String soyad = rs.getString("last_name");

            System.out.println(ad + " " + soyad);
            rowCount++;
        }

        System.out.println("rowCount = " + rowCount);

        System.out.println("rs.getRow() = " + rs.getRow());  // bu nokta while durduu yani satırın olmadığı nokta

        rs.last();
        System.out.println("last: rs.getRow() = " + rs.getRow());
    }


    @Test
    private void test1for() throws SQLException {
        // Yukarıdaki örneği for döngüsü ile yapınız
        ResultSet rs = statement.executeQuery("select * from customer");

        rs.last();
        int rowCount=rs.getRow();

        rs.first(); // gösterge tekrar başa getirildi
        for (int i = 0; i < rowCount; i++) {
            String ad = rs.getString("first_name");
            String soyad = rs.getString("last_name");

            System.out.println(ad + " " + soyad);
            rs.next();
        }
    }

    @Test
    private void test1for2() throws SQLException {
        // Yukarıdaki örneği for döngüsü ile yapınız (Absolute ile yapıldı)
        ResultSet rs = statement.executeQuery("select * from customer");

        rs.last();
        int rowCount=rs.getRow();

        for (int i = 1; i <= rowCount; i++) {
            rs.absolute(i); // verilen index deki satıra gider.
            String ad = rs.getString("first_name");
            String soyad = rs.getString("last_name");

            System.out.println(ad + " " + soyad);
        }
    }

    @Test
    private void test1for3Tersten() throws SQLException {
        // Yukarıdaki örneği for döngüsü ile TERSTEN yapınız
        ResultSet rs = statement.executeQuery("select * from customer");

        rs.last();
        int rowCount=rs.getRow();

        for (int i = rowCount; i > 0 ; i--) {
            rs.absolute(i); // verilen index deki satıra gider.
            String ad = rs.getString("first_name");
            String soyad = rs.getString("last_name");

            System.out.println(ad + " " + soyad);
        }
    }

}





