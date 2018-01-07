
import java.sql.*;

public class DbAccess {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Test.accdb");

            Statement s = conn.createStatement();

            String tableName = "User";

//            String createTable = "CREATE TABLE " + tableName
//                    + " (id Integer, name Text(32))";
//
//            s.execute(createTable);
//
//            System.out.println("CREATED");
//            
            // enter value into table
            for (int i = 0; i < 25; i++) {
                String addRow = "INSERT INTO " + tableName + "(name) VALUES ('r')";
                s.execute(addRow);
            }

            // Fetch table
            String selTable = "SELECT * FROM " + tableName;
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            while ((rs != null) && (rs.next())) {
                System.out.println(rs.getString(1) + " : " + rs.getString(2));
            }

//            // drop the table
//            String dropTable = "DROP TABLE " + tableName;
//            s.execute(dropTable);
            // close and cleanup
            s.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e);

        }

    }
}
