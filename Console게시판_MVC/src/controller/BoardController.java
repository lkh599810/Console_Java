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
	
	public static int 게시물번호=-1;
	
	public static int 상세보기번호=-1;
	
	public static int 조회수;
	
	
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
		
		
		
		
		BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> 게시판리스트= boardDao.allboard();		
		
//		ArrayList<Board> 게시판리스트= boardDao.getBoardDao().allboard();		

		
		for(int i=0; i<게시판리스트.size(); i++) {
			
			게시물번호=i+1;
			
			상세보기번호=게시물번호-1; //원래 num
			
			System.out.println("제목: "+게시판리스트.get(i).getTitle()+"\t \t 작성자: "+게시판리스트.get(i).getWriterid()+"\t 번호: "+게시물번호); 
			System.out.println(); 
			
		}
		
		
		
	}//리스트출력 끝
	
	
	
	
	
	
	public static void 상세보기(int choose) { //read
		
		//choose랑 상세보기번호를 맞춰줘야 함. ===> how? ==> for문 써야할거같은데?
		BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> 게시판리스트=boardDao.allboard();
		
		
		상세보기번호=choose-1;
		
		조회수++;
		
		
		System.out.println("=================================================");
			
		
		System.out.println("=====================상세보기=====================");
		
		
		System.out.println("제목:" +게시판리스트.get(상세보기번호).getTitle()); 
		
		System.out.println("내용: "+게시판리스트.get(상세보기번호).getContent()); 
		
		System.out.println("작성자: "+게시판리스트.get(상세보기번호).getWriterid());

		System.out.println("조회수: "+조회수);

		System.out.println("작성일: "+게시판리스트.get(상세보기번호).getNum());

		
		
		
		System.out.println("=================================================");
		

		
		
		
		
		
		}
	
	
	public static void 수정(int choose) { //update
		
	BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> 게시판리스트=boardDao.allboard();
		
		Board board=new Board();

		상세보기번호=choose-1;
			
		System.out.println("=================================================");
			
		
		System.out.println("=====================상세보기=====================");
		
		
		System.out.println("제목:" +게시판리스트.get(상세보기번호).getTitle()); 
		System.out.println("내용: "+게시판리스트.get(상세보기번호).getContent()); 	
		System.out.println("작성자: "+게시판리스트.get(상세보기번호).getWriterid());
		System.out.println("조회수: "+조회수);
		System.out.println("작성일: "+게시판리스트.get(상세보기번호).getNum());
	
		
		System.out.println("수정 제목:" );
		String 수정제목=입력.next();
		System.out.println("수정 내용: ");
		String 수정내용=입력.next();
		
//		게시판리스트.get(상세보기번호).setTitle(수정제목);
//		게시판리스트.get(상세보기번호).setContent(수정내용);
		
		board.setTitle(수정제목);
		board.setContent(수정내용);
		
		게시판리스트.get(상세보기번호).setTitle(수정제목);
		게시판리스트.get(상세보기번호).setContent(수정내용);
		
		
		
		System.out.println("=================================================");
		
		
		}//수정 끝
	
	
	public static void 삭제(int choose) {
		
	BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> 게시판리스트=boardDao.allboard();
		
		Board board=new Board();


		상세보기번호=choose-1;
		
		System.out.println("제목:" +게시판리스트.get(상세보기번호).getTitle()); 
		System.out.println("내용: "+게시판리스트.get(상세보기번호).getContent()); 
		
		System.out.println("****해당 게시물을 삭제합니다.*****");
		
		게시판리스트.remove(상세보기번호);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
