package _JDBC.Gun2;

import _JDBC._JDBCParent;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class _03_GetAllRowColumn extends _JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();
        // Sonuçların haricindeki diğer bilgiler: colon sayısı, isimleri, tipleri

        int columnCount = rsmd.getColumnCount(); // kolon sayısı
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            String columnType = rsmd.getColumnTypeName(i);

            System.out.println(columnName+ " " + columnType);
        }
    }

    @Test
    public void test2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd=rs.getMetaData();
        int columnCount=rsmd.getColumnCount();

        for(int i=1; i<= columnCount; i++) {
            System.out.print(rsmd.getColumnName(i)+" ");
        }
        System.out.println();

        while(rs.next())
        {
            // her satırın bilgileri kolon kolon yazdırılıyor
            for(int i=1; i<= columnCount; i++) {
                System.out.print(rs.getString(i)+" ");
            }

            System.out.println();
        }
    }


    @Test
    public void test2_2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd=rs.getMetaData();
        int columnCount=rsmd.getColumnCount();

        for(int i=1; i<= columnCount; i++) {
            System.out.printf("%-25s", rsmd.getColumnName(i)+" ");
        }
        System.out.println();

        while(rs.next())
        {
            // her satırın bilgileri kolon kolon yazdırılıyor
            for(int i=1; i<= columnCount; i++) {
                System.out.printf("%-25s",rs.getString(i)+" ");
            }

            System.out.println();
        }
    }

    @Test
    public void task1() throws SQLException {
        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.
        getTable("select * from actor");
    }

    private void getTable(String query) throws SQLException {

        ResultSet rs = statement.executeQuery(query);

        ResultSetMetaData rsmd=rs.getMetaData();
        int columnCount=rsmd.getColumnCount();

        for(int i=1; i<= columnCount; i++) {
            System.out.printf("%-25s", rsmd.getColumnName(i)+" ");
        }
        System.out.println();

        while(rs.next())
        {
            // her satırın bilgileri kolon kolon yazdırılıyor
            for(int i=1; i<= columnCount; i++) {
                System.out.printf("%-25s",rs.getString(i)+" ");
            }

            System.out.println();
        }
    }


    @Test
    @Parameters("tableName")
    public void task2(String tableName) throws SQLException {
        // Kullanıcıdan alacağını tablo adındaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.
        // Scanner gibi kullanıcı ile test içinde etkileşimli bir okuma ile alınamz TEST olduğu için
        // Bunun yerine TestNG konusunda gördüğümüz PARAMETERS XML yöntemi ile değişkeni gönderdik.

        getTable("select * from "+tableName);
    }
}










