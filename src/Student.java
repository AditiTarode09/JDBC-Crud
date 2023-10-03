import java.sql.*;

public class Student {
    public void createDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username,password);

            Statement statement = connection.createStatement();
            String query = "create database jdbcDemo";
            statement.execute(query);
            System.out.println("Database created Successfully.");
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable() {
        String url = "jdbc:mysql://localhost:3306/jdbcDemo";
        String username = "root";
        String password = "root";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username,password);

            Statement statement = connection.createStatement();

            String query = "create table studentInfo(id int(5),name varchar(30),email varchar(30))";
            statement.execute(query);
            System.out.println("Table created Successfully");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void insert() {
        String url = "jdbc:mysql://localhost:3306/jdbcDemo";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "insert into studentInfo (id,name,email) values (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"Divya");
            preparedStatement.setString(3, "divya@gmail.com");
            preparedStatement.execute();

            System.out.println("Data inserted Successfully");
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    public void readData() {
        String url = "jdbc:mysql://localhost:3306/jdbcDemo";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "Select * from studentInfo";
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println("id : "+ resultSet.getInt(1));
                System.out.println("name : "+ resultSet.getString(2));
                System.out.println("email : "+ resultSet.getString(3));
            }
            System.out.println("Table read Successfully");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTable() {
        String url = "jdbc:mysql://localhost:3306/jdbcDemo";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "Update studentInfo set id=? where name=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"Aditi");
            preparedStatement.executeUpdate();

            System.out.println("Data Updated Successfully");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //getting error in the update query
    public void updateTable2(){
        String url = "jdbc:mysql://localhost:3306/jdbcDemo";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();

            String query = "Update studentinfo set name=emmaa";
            statement.executeUpdate(query);

            System.out.println("Data Updated Successfully");
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void delete() {
        String url = "jdbc:mysql://localhost:3306/jdbcDemo";
        String username = "root";
        String password = "root";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);

            Statement statement = connection.createStatement();
            String query = "delete from studentinfo where id=2";
            statement.executeUpdate(query);

            System.out.println("Data deleted Successfully");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
