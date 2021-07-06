package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;

public class MemberDao {
	
	Connection conn;
	
	private static MemberDao memberDao=new MemberDao();
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberDao() { //������ �ȿ� Ŀ�ؼ� �־��� �ٸ� ������ �����Ҷ� �ٷ�sql�� �����Ϸ�.
		// TODO Auto-generated constructor stub
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("����11"); System.out.println("����12");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/console?serverTimezone=UTC" , "root" , "1234");
			System.out.println("����12");
			
		}catch (Exception e) {
			System.out.println("����12" + e );
			
		}
	
	}//������ ��
	
	
	//ȸ������
	public int signup(Member member) {
		System.out.println("����");
		String SQL="insert into member(name , id, pw)"+ "values(asdf,sdf,sdf)";
		
		try {
			System.out.println("����");
			PreparedStatement pstmt=conn.prepareStatement(SQL);
//			System.out.println("����");
//			pstmt.setString(2, member.getId());
//			pstmt.setString(3, member.getPw());
//			pstmt.setString(1, member.getName());
			
			pstmt.executeUpdate();
			
			return 1;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
	
	
	public int login(String id, String pw) {
	
		String SQL="select * from member where id=? and password=?";

		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}else {
				return 2;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
		
	}
	
	

}
