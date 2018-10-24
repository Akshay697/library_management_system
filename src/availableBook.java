import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class availableBook extends javax.swing.JFrame {
    JTable table;
    JScrollPane sp;
    availableBook()
    {
        try{
    
   
    Connection con = DB.getConnection();
    String sql="select * from book_details ";
    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
             rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            String[][] data = new String[row][col];
            row = 0;
            while(rs.next())
            {
                for(int i =0;i<col;i++)
                {
                    data[row][i] = rs.getString(i+1);
                }
                row++;
            }
            String[] cols = new String[col];
            for(int j =0;j<col;j++)
            {
               cols[j] = rsmd.getColumnName(j+1);
            }
            
             table = new JTable(data,cols);
             sp = new JScrollPane(table);
           add(sp);
           setBounds(500,100,0,0);
          setSize(640,300);
           
            
            
          
    }           
  catch(SQLException e)
  {
  e.printStackTrace();
  }
    
    }
    public static void main(String args[])
    {
       availableBook avail = new availableBook();
       avail.setVisible(true);
        
}
  
}