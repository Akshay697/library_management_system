import java.sql.*;

public class returnbook_db {
    
    public static boolean returnbook(int book_id, int stu_id)    {   
       try{
           Connection con = DB.getConnection();
           PreparedStatement pstmt = con.prepareStatement("Delete from issue_details where bookid=? and studentid=?");
           pstmt.setInt(1, book_id);
           pstmt.setInt(2, stu_id);
           pstmt.executeUpdate();
           updatebook_table(book_id);
       }
       catch(SQLException e)
       {
       e.printStackTrace();
       
       }
        return true;
        
    }
    public static void updatebook_table(int id)
    {  int num=0;
        try
        {   
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select quantity from book_details where bookid='"+id+"'");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
            num = Integer.parseInt(rs.getString("quantity"));
                    
            }
            PreparedStatement pst = con.prepareStatement("Update book_details set quantity=? where bookid='"+id+"'");
            pst.setInt(1,num+1);
            pst.executeUpdate();
        
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        
    }

}
