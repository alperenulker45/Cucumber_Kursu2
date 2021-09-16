package _JDBC.Gun1;

import _JDBC._JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends _JDBCParent {

    @Test
    private void test1() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from film");

        rs.absolute(10); // 10.satıra git.
        String title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15); // absolute verilen satıra gider.
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15); //sondan 15.satıra git.
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5); // en son bulunduğu yerden 5 ileri gider. yani -10. ye gider
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5); // en son bulunduğu yerden 5 geri gider. yani 15. ye gider
        title=rs.getString("title");
        System.out.println("title = " + title);
    }


}
