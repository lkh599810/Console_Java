package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Repository.BoardDao;
import domain.Board;
import front.게시판화면;

public class BoardController {// 리스트, 출력, 글쓰기, 삭제

	 
	
	public static Scanner 입력=new Scanner(System.in);
	
	BoardDao boardDao=new BoardDao();
	
	ArrayList<Board> 게시판리스트= boardDao.allboard();
	
	private static int 게시물번호;
	
	public static int 상세보기번호;
	
	private static int 조회수;
	
	
	public static void 글쓰기() {//create
	
		Board board=new Board();
		
		BoardDao boardDao=BoardDao.getBoardDao();
	
		System.out.println("===========글쓰기===========");
		System.out.print("제목:");
		String 제목=입력.next();
		System.out.print("\n내용:");
		String 내용=입력.next();
		//date, writerid, count는 자동주입해주기 date는 특히 date함수 만들어서 해주면됨.
		
		
		
		String 작성자=controller.MemberController.게시판작성아이디;
		
		
		Date date= new Date();	//게시물 작성일
		
		String 작성일=date.toString();
		
		조회수=0;
		
		board.setTitle(제목);
		board.setContent(내용);
		board.setDate(작성일);
		board.setWriterid(작성자);
		board.setCount(조회수);
		
		int result=boardDao.boardwrite(board);
		
		if(result==1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
	
	}//글쓰기 끝
	
	
	
	public static void 리스트출력() {
	
		ArrayList<Board> 게시판리스트= BoardDao.getBoardDao().allboard();	
		
		
		
		
		for(int i=0; i<게시판리스트.size(); i++) {
			
			게시물번호=i+1;
			
			System.out.println("제목: "+게시판리스트.get(i).getTitle()+"\t \t 작성자: "+게시판리스트.get(i).getWriterid()+"\t 번호: "+게시물번호); 
			System.out.println(); 
			
		}
		
		
		
	}//리스트출력 끝
	
	
	
	
	
	
	public static void 상세보기(int choose) { //choose==리스트의 번호(프론트 게시물번호)
		
		
		
		ArrayList<Board> 게시판리스트= BoardDao.getBoardDao().allboard();	


		int boardnum=게시판리스트.get(choose-1).getNum(); // db 게시물 넘버
		
		상세보기번호=boardnum;
			
		BoardDao boardDao=BoardDao.getBoardDao();
		
		boardDao.countup(게시판리스트.get(choose-1)); //리스트에 있는 i번째 board 자체. ==게시판리스트.get(choose-1)
		
		//boardDao.countup(게시물넘버, 게시물에서 빼온 카운트+1) , dao에도 인수두개 주고 setint boardnum setint count+1로 해줫엇음. 이것도 맞는것.

		
		Board board= boardDao.getboard(boardnum); 
		
		
		
		System.out.println("=================================================");
		
	
		System.out.println("=====================상세보기=====================");
		
	

	
		System.out.println("제목:" +board.getTitle()); 
	
		System.out.println("내용: "+board.getContent()); 
	
		System.out.println("작성자: "+board.getWriterid());
	
		System.out.println("조회수: "+board.getCount());

		System.out.println("작성일: "+board.getDate());

		
	
		String 로그인아이디=controller.MemberController.게시판작성아이디;
		
		System.out.println("=================================================");
		
		System.out.print("1. 댓글 ");
		
		if(board.getWriterid().equals(로그인아이디)){
				System.out.print("2.수정"); System.out.print("3.삭제"); 
				System.out.println();
			}
		
			int choose2=입력.nextInt();
		
			if(choose2==1) { //boardcontroller상세보기 => front댓글화면 =>commentcontroller=>commentdao
				front.댓글화면.댓글화면출력(boardnum);
			}
			else if(choose2==2) {
				
				수정(boardnum);
			
			}else if(choose2==3) {
				
				삭제(boardnum);
			}
		
		
			System.out.println();
			System.out.println("=================================================");

	
		
		
		
//		//choose랑 상세보기번호를 맞춰줘야 함. ===> how? ==> for문 써야할거같은데?
//		BoardDao boardDao=new BoardDao();
//		
//		ArrayList<Board> 게시판리스트=boardDao.allboard();
//		
//		
//		상세보기번호=choose-1;
//		
//		조회수++;
//		String 로그인아이디=controller.MemberController.게시판작성아이디;
//		
//		
//		System.out.println("=================================================");
//			
//		
//		System.out.println("=====================상세보기=====================");
//			
//		
//	
//		
//		System.out.println("제목:" +게시판리스트.get(상세보기번호).getTitle()); 
//		
//		System.out.println("내용: "+게시판리스트.get(상세보기번호).getContent()); 
//		
//		System.out.println("작성자: "+게시판리스트.get(상세보기번호).getWriterid());
//
//		System.out.println("조회수: "+조회수);
//
//		System.out.println("작성일: "+게시판리스트.get(상세보기번호).getDate());
//
//		
//		
//		
//		System.out.println("=================================================");
//		
//	System.out.print("1. 댓글 ");
//		
//		if(게시판리스트.get(상세보기번호).getWriterid().equals(로그인아이디)){
//				System.out.print("2.수정"); System.out.print("3.삭제"); 
//				System.out.println();
//			}
//		
//			int choose2=입력.nextInt();
//		
//			if(choose2==1) {
//				//댓글dao.댓글목록
//			}
//			else if(choose2==2) {
//				
//				수정(choose2);
//			
//			}else if(choose2==3) {
//				
//				삭제(choose2);
//			}
//		
//		
//			System.out.println();
//			System.out.println("=================================================");
//
//		
		
		}
	
	
	public static void 수정 (int 상세보기번호) { //update
		
	BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> 게시판리스트=boardDao.allboard();
		
		Board board=new Board();

		System.out.println(상세보기번호);
			
		System.out.println("========================수정페이지====================");
		
		System.out.println("수정 제목:" );
		String 수정제목=입력.next();
		System.out.println("수정 내용: ");
		String 수정내용=입력.next();
		System.out.println();
		
		int 수정num=상세보기번호; //어레이리스트는 0부터, db num은 1부터. ???
		
		board.setTitle(수정제목);
		board.setContent(수정내용);
//		board.setNum(게시판리스트.get(상세보기번호).getNum());
		board.setNum(수정num);


		
		
		int result=boardDao.boardupdate(board);
		
		if(result==1) {
			System.out.println("성공");
			System.out.println("=================================================");
			System.out.println();
			
			리스트출력();
		
		}else {
			System.out.println("실패");
			
		}
		
		
		System.out.println("=================================================");
		
		
		}//수정 끝
	
	
	public static void 삭제(int 상세보기번호) {
		
	BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> 게시판리스트=boardDao.allboard();
		
		Board board=new Board();


		System.out.println(상세보기번호);
		
		System.out.println("제목:" +게시판리스트.get(상세보기번호).getTitle()); 
		System.out.println("내용: "+게시판리스트.get(상세보기번호).getContent()); 
		
		System.out.println("****해당 게시물을 삭제합니다.*****");
		
		board.setNum(상세보기번호);
		
//		int 삭제번호=게시판리스트.get(상세보기번호).getNum()-1;
//		board.setNum(삭제번호);

		int result=boardDao.boarddelete(board);
		
		if(result==1) {
			System.out.println("성공");
		}else {
			
			System.out.println("실패");
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
