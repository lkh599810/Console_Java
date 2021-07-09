package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Board;


public class BoardDao {

	Connection conn;
	
	private static BoardDao boardDao=new BoardDao();
	
	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	public BoardDao() {
		//생성자 안에 커넥션 넣어놓으면 다른곳에서 생성할때 바로 sql과 연동됨. [초기값]
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/console?serverTimezone=UTC" , "root" , "1234");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}//생성자 끝
	
	
	
	//게시판 접속 시 전체게시판 검사할 메소드
	public ArrayList<Board> allboard(){
		
		ArrayList<Board> boardlist=new ArrayList<>();
		
		String SQL="select * from board";
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board=new Board();
				
				board.setNum(rs.getInt(1)); //끌어올때는 모든컬럼 다 가져와야함.
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriterid(rs.getString(4));
				board.setDate(rs.getString(5));
				board.setCount(rs.getInt(6));
			
				
				boardlist.add(board);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			return boardlist;
	}
	
	
	//상세보기
	
	public Board getboard(int num) {
		
		Board board=new Board();
		
		String SQL="select * from board where num=?";
		
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			pstmt.setInt(1, num);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				board.setNum(rs.getInt(1)); //끌어올때는 모든컬럼 다 가져와야함.
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriterid(rs.getString(4));
				board.setDate(rs.getString(5));
				board.setCount(rs.getInt(6));
				
				return board;
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return board;
		
	}
	
	//조회수 증가
	
	public void countup(Board board) {
		
		
		
		String SQL="update board set count=? where num=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			pstmt.setInt(1, board.getCount()+1);
			pstmt.setInt(2, board.getNum());
			
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	
	//글쓰기
	public int boardwrite(Board board) {
	
		String SQL="insert into board( title , content , writerid , date ,count )"+"values( ? , ? , ? , ? , ? )";
	//	String SQL="insert into board( title , content , writerid )"+"values(?,?,?)";

		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriterid());	
			pstmt.setString(4, board.getDate());
			pstmt.setInt(5, board.getCount());
		
			
			pstmt.executeUpdate();
			
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
		return -1;
		
	}//글쓰기 끝
	

	//수정
	public int boardupdate(Board board) {
		
		String SQL="update board set title=? , content=? where num=?";
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNum());
			
			pstmt.executeUpdate();
			
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return -1;
	}
	
	
	public int boarddelete(Board board) {
		
		String SQL="delete from board where num=?";
		
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
		
			pstmt.setInt(1, board.getNum());
			
			pstmt.executeUpdate();
			
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
}
