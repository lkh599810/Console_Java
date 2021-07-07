package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Repository.MemberDao;
import domain.Member;
import front.게시판화면;

public class MemberController {
	
	public int choose;
	public static String 로그인상태="로그인안됨";
	public static String 게시판작성아이디="";
	
	public static void signup() {
		
		
		ArrayList<Member> 회원리스트 = MemberDao.getMemberDao().allmember();

		Scanner 입력=new Scanner(System.in);	
		
		Member member= new Member();
		
		String 가입아이디;
		String 가입비번;
		String 가입이름;
		
		
		String 중복값="";
		
		System.out.println("===회원가입===");
		System.out.println("아이디 입력: ");
		가입아이디=입력.next();

		for(int i=0; i<회원리스트.size(); i++) {	
			if(가입아이디.equals(회원리스트.get(i).getId())) {
				중복값="중복";
			}
		}
		
		if(중복값.equals("중복")) {
			System.out.println("아이디 중복.");
		}else {
			System.out.println("비밀번호 입력:");
			가입비번=입력.next();
			System.out.println("이름 입력:");
			가입이름=입력.next();
			
			System.out.println("확인: 아이디: "+가입아이디 + "비밀번호: "+가입비번+" 이름: "+가입이름);
			
			member.setId(가입아이디);
			member.setPw(가입비번);
			member.setName(가입이름);
			
			//회원리스트.add(member); =>db연결했으니 필요없음.
			MemberDao memberDao = MemberDao.getMemberDao();
			
			int result = memberDao.signup(member);
			if( result == 1 ) System.out.println("성공 ");
			else System.out.println("실패");
				
		}
	}//signup 끝
	
	
	
	
	
	public static void login() {
		
		MemberDao memberDao=MemberDao.getMemberDao();
		
		ArrayList<Member> 회원리스트 = MemberDao.getMemberDao().allmember();

		Scanner 입력=new Scanner(System.in);	

		String 로그인아이디;
		String 로그인비번;
		
		System.out.println("===로그인===");
		System.out.println("아이디 입력: "); 
		
		
		로그인아이디=입력.next();
		
		System.out.println("비밀번호 입력: ");
		
		로그인비번=입력.next();
		
		
		int result=memberDao.login(로그인아이디, 로그인비번);
		
		if(result==1) {
			System.out.println("로그인 성공");
			
//			로그인상태="로그인정보: "+회원리스트.get(인덱스).getId();
//			게시판작성아이디=회원리스트.get(인덱스).getId();
			
			로그인상태="로그인정보: "+로그인아이디;
			게시판작성아이디=로그인아이디;
			
			게시판화면 게시판=new 게시판화면();
			게시판.게시판화면();
			
			
			
		}else {
			System.out.println("db오류");
		}
		
//		System.out.println("===로그인==="); ==>주석처리도 실행 가능하긴 함. dao.login없이 할때 쓰면됨.
//		System.out.println("아이디 입력:"); 
		
//		로그인아이디=입력.next();

		
//		String 로그인아이디값="";
//		String 로그인비번값="";
		
//		int 인덱스=-1;
		
		
//		for(int i=0; i<회원리스트.size(); i++) {
//		  if(회원리스트.get(i).getId().equals(로그인아이디)) {
//			  로그인아이디값="있음";
//			  인덱스=i;
//		  }
//		} //for문 끝: for문 이용 리스트 전부검사 => 아이디값이 있는쪽의 번호(인덱스)를 정해줌
//		
//		
//		
//		
//		if(로그인아이디값.equals("있음")) {
//			
//			System.out.println("비밀번호 입력:");
//			로그인비번=입력.next();
//			
//			if(로그인비번.equals(회원리스트.get(인덱스).getPw())) {
//				
//				System.out.println("로그인 성공");
//				
//					로그인상태="로그인정보: "+회원리스트.get(인덱스).getId();
//					
//					게시판작성아이디=회원리스트.get(인덱스).getId();
//					
//					
//					
//					
//					게시판화면 게시판=new 게시판화면();
//					게시판.게시판화면();
//				
//			}else {
//				System.out.println("비번 틀림");
//			}
//			
//		}else {
//			
//			System.out.println("아이디 틀림");
//		}
		
	}//login 끝
	
	
	

}
