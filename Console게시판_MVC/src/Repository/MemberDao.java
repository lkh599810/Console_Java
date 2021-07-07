package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/console?serverTimezone=UTC" , "root" , "1234");
			
			
		}catch (Exception e) {
			
			
		}
	
	}//������ ��
	
	
	//ȸ������
	public int signup(Member member) {
		
		String SQL="insert into member( name , id , pw )"+"values(?,?,?)";
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			
			
			pstmt.executeUpdate();
			
			return 1;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
	
	
	//�α��� �� ��ü ȸ���˻��� ����Ʈ
	public ArrayList<Member> allmember(){
		
		ArrayList<Member> members=new ArrayList<>();
		
		String SQL="select * from member";
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				Member member=new Member();
				
				member.setName(rs.getString(1));
				member.setId(rs.getString(2));
				member.setPw(rs.getString(3));
				
				members.add(member);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return members;
	}
	
	public int login(String id, String pw) {
	
		String SQL="select * from member where id=? and pw=?";

		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs=pstmt.executeQuery();
			
			if( rs.next() ) {
				return 1;
			}else {
				return -1;
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
		
	}
	
	

}
