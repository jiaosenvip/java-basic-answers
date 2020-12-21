import java.sql.*;
import java.util.Scanner;

public class querysys {
    final static String DRIVER = "com.mysql.jdbc.Driver";

    final static String URL = "jdbc:mysql://localhost:3306/edusys?useUnicode=true&characterEncoding=utf8";
    final static String USERNAME = "root";
    final static String PASSWORD = "";
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static void executeQuery() {
        try{

            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            stmt = connection.createStatement();

            System.out.println("请选择你要查询的信息类别： 1. 学生信息   2.课程信息  3. 导师信息");

            Scanner se = new Scanner(System.in);

            int num = se.nextInt();

            if(num == 1){

                String querySql = "select ID,name,dept_name from student";

                rs = stmt.executeQuery(querySql);

                while(rs.next()) {

                    String ID = rs.getString("ID");

                    String name = rs.getString("name");

                    String dept_name = rs.getString("dept_name");

                    System.out.println(ID + "\t" + name + "\t" + dept_name + "\t");
                }
            } else if(num == 2) {

                String querySql = "select course_id,title,dept_name from course";

                rs = stmt.executeQuery(querySql);

                while(rs.next()) {

                    String course_id = rs.getString("course_id");

                    String title = rs.getString("title");

                    String dept_name = rs.getString("dept_name");

                    System.out.println(course_id + "\t" + title + "\t" + dept_name + "\t");
                }
            } else if(num == 3) {

                String querySql = "select ID,name,dept_name from instructor";

                rs = stmt.executeQuery(querySql);

                while(rs.next()) {

                    String ID = rs.getString("ID");

                    String name = rs.getString("name");

                    String dept_name = rs.getString("dept_name");

                    System.out.println(ID + "\t" + name + "\t" + dept_name + "\t");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(rs != null)rs.close();
                if(stmt != null)stmt.close();
                if(connection != null)connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        executeQuery();
    }
}
