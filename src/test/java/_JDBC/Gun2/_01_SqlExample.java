package _JDBC.Gun2;

import _JDBC._JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends _JDBCParent {

    @Test
    private void test2_LastFirstKeyword() throws SQLException {
        // address tablosundaki teki district alanını önce 10.satırdakini sonra, 22.satırdaki,
        // sonra en son satırdaki bilgisini yazdırınız.

        ResultSet rs = statement.executeQuery("select district from address");

        rs.absolute(10); // 10.satıra gittim
        String disrict=rs.getString("district");
        System.out.println("district = " + disrict);

        //rs.absolute(22); //22.satira gittim
        rs.relative(12); //22.satira gittim
        disrict=rs.getString("district");
        System.out.println("district = " + disrict);

        rs.last(); //sona geldik gene
        disrict=rs.getString("district");
        System.out.println("district = " + disrict);
    }


}
