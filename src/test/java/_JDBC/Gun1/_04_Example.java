package _JDBC.Gun1;

import _JDBC._JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Example extends _JDBCParent {

    @Test
    private void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        rs.relative(5); // adana
        String cityName= rs.getString(2);
        System.out.println("cityName = " + cityName);

        rs.relative(5); // Akishima
        cityName= rs.getString(2);
        System.out.println("cityName = " + cityName);
    }

    @Test
    private void test2_LastFirstKeyword() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        rs.last(); // en son kayda gidiyor
        String cityName= rs.getString(2);
        int countryId = rs.getInt("country_id");
        System.out.println("cityName = " + cityName);
        System.out.println("countryId = " + countryId);


        rs.first(); // ilk kayda gidiyor
        cityName= rs.getString(2);
        countryId = rs.getInt("country_id");
        System.out.println("cityName = " + cityName);
        System.out.println("countryId = " + countryId);
    }

}