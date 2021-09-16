package Utilities;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    // Gönderilen sorgunun sonucunu List olarak geri gönderen
    // bir Reusable bir fonksiyon yazınız.

    private static Connection connection;
    private static  Statement statement;

    public static void DBConnectionOpen(){
        String url = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        String user = "technostudy";
        String password = "zhTPis0l9#$&";
        try {
            connection= DriverManager.getConnection(url, user, password);// bağlantı sağlandı.
            statement = connection.createStatement(); // sorgularımı çalıştırabilmek için bir yol oluştur.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void DBConnectionClose(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<List<String>> getListData(String query) {
        DBConnectionOpen();
        List<List<String>> returnList = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                List<String> rowList = new ArrayList<>();
                // her satırın bilgileri kolon kolon yazdırılıyor
                for (int i = 1; i <= columnCount; i++) {
                    rowList.add(rs.getString(i));
                }

                returnList.add(rowList);
            }
        }
        catch(Exception ex)
        {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        DBConnectionClose();
        return returnList;
    }

    public static void main(String[] args) {
        List<List<String>> data=getListData("select * from actor");

        for(List<String> a: data)
        {
            System.out.println(a);
        }
    }


}
