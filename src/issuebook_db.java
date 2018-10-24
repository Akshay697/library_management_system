import java.sql.*;
import javax.swing.JOptionPane;

public class issuebook_db {
    
   
    public static boolean issue(int Book_id,int Student_id,String Student_name)
    { 
       try{ 
           Connection con = DB.getConnection();
           PreparedStatement pstmt = con.prepareStatement("insert into issue_details values(?,?,?)");
        pstmt.setInt(1, Book_id);
        pstmt.setInt(2, Student_id);
        pstmt.setString(3, Student_name);
        pstmt.execute();
        table_update(Book_id);
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       return true;
    }
    public static void table_update(int ID)
    {   int num=0;
        try{
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement("Select quantity from book_details where bookid=?");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
             num = rs.getInt("quantity");
            }
            if(num>0)
            {
            PreparedStatement ps = con.prepareStatement("Update book_details set quantity=? where bookid=?");
            ps.setInt(1, num-1);
            ps.setInt(2,ID);
            ps.executeUpdate();
            
            }
        }
        catch(SQLException e)
        {
            System.out.print(e);
        
        }
    }
        public static void stu_details(int id, String name, String clss, String sec)
        {
            try{
                Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement("insert into student_details values(?,?,?,?)");
                stmt.setInt(1, id);
                stmt.setString(2,name);
                stmt.setString(3, clss);
                stmt.setString(4, sec);
                stmt.execute();
            
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        
        }
    
    
}
