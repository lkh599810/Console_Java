package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Comment;

public class CommentDao {

	Connection conn;

	private static CommentDao commentDao;
	
	public static CommentDao getCommentDao() {
		
		return commentDao;
	}
	
	public CommentDao() {

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/console?serverTimezone=UTC" , "root" , "1234");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	
	
	}
	
	//게시물 아이디별 댓글리스트
	public  ArrayList<Comment> commentlist(int boardnum){
		
		ArrayList<Comment> commentlist=new ArrayList<>();
		
		String SQL= "select * from comment where boardnum=?";
		try {
			
			
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			pstmt.setInt(1, boardnum);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				Comment comment=new Comment();
				
				comment.setNum(rs.getInt(1));
				comment.setContent(rs.getString(2));
				comment.setWriterid(rs.getString(3));
				comment.setBoardnum(rs.getInt(4));
				
				commentlist.add(comment);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return commentlist;
	}//댓글리스트 끝
	
	
	public int commentwrite(Comment comment) {
		
		String SQL="insert into comment ( content, writerid , boardnum )"+"values( ? , ? , ? )";
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			pstmt.setString(1, comment.getContent());
			pstmt.setString(2, comment.getWriterid());
			pstmt.setInt(3, comment.getBoardnum());
			
			pstmt.executeUpdate();
			
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
		
	}
	
	public void commentdelete(int commentnum) {
		
		String SQL="delete from comment where num=?";
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			pstmt.setInt(1, commentnum);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
