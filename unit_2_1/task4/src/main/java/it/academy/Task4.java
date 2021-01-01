package it.academy;

import java.sql.*;

public class Task4 {
    public static void main(String[] args) {
        String sqlQuery = "";
        if(args.length > 0){
            sqlQuery = "INSERT INTO `listexpenses`.`expenses`\n" +
                "(`num`,\n" +
                "`paydate`,\n" +
                "`receiver`,\n" +
                "`value`)\n" +
                "VALUES\n" +
                "(null,\n" +
                "CURRENT_DATE(),\n" +
                args[0] + ",\n" +
                args[1] +");";
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses?serverTimezone=UTC", "root", "root");
            final Statement statement = connection.createStatement();
            if(args.length  > 0) {
                statement.execute(sqlQuery);
            }
            ResultSet resultSet = statement.executeQuery("SELECT `expenses`.`num`,\n" +
                    "    `expenses`.`paydate`,\n" +
                    "    `expenses`.`receiver`,\n" +
                    "    `expenses`.`value`\n" +
                    "FROM `listexpenses`.`expenses`;");
            while (resultSet.next()){
               System.out.println("num = " + resultSet.getInt(1) + " paydate =" + resultSet.getDate(2) +
               " receiver ="+ resultSet.getInt(3) + " value = "+resultSet.getFloat(4));
            }
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
