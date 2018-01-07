import java.sql.*;

public class DbAccess
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
 
        try {
                       
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
 
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Test.accdb");
 
            Statement s = conn.createStatement();
            
//            String sql = "SELECT * FROM Награда";
// 
//            ResultSet rs = s.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println("\n" + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
//            }

// create a table
            String tableName = "myTable" + String.valueOf((int)(Math.random() * 1000.0));
            String createTable = "CREATE TABLE " + tableName + 
                                 " (id Integer, name Text(32))";
            s.execute(createTable); 

            // enter value into table
            for(int i=0; i<25; i++)
            {
              String addRow = "INSERT INTO " + tableName + " VALUES ( " + 
                     String.valueOf((int) (Math.random() * 32767)) + ", 'Text Value " + 
                     String.valueOf(Math.random()) + "')";
              s.execute(addRow);
            }

            // Fetch table
            String selTable = "SELECT * FROM " + tableName;
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            while((rs!=null) && (rs.next()))
            {
                System.out.println(rs.getString(1) + " : " + rs.getString(2));
            }

//            // drop the table
//            String dropTable = "DROP TABLE " + tableName;
//            s.execute(dropTable);

            // close and cleanup
            s.close();
            conn.close();
 
        } catch (Exception e) {
 
            System.out.println(e.getMessage());
 
        }
 
    }
}