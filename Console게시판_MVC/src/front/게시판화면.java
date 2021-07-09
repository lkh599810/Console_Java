package front;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import controller.BoardController;
import domain.Board;

public class 게시판화면 {

	
	
	public 게시판화면() {
		
	}
	
	public void 게시판화면() {
		
		초기화면 초기화면=new 초기화면();
		Scanner 입력= new Scanner(System.in);
		
		Board board=new Board();
		
		
		  
		System.out.println("=====================게시판=====================");
		System.out.println("\t\t\t"+controller.MemberController.로그인상태);
		System.out.println("=============================================");
		System.out.println("1.글쓰기 2.상세보기 ");

		System.out.println("=====================LIST====================");
		//컨트롤러에 리스트출력도 만들기  
		
		controller.BoardController.리스트출력();
		
		
		System.out.println("============================================= \n");
		
		int menuchoose=입력.nextInt();
		
		if(menuchoose==1) {
			
			controller.BoardController.글쓰기();
			
			
		}else if(menuchoose==2) {
			
			System.out.println("\n 게시물 번호를 입력하세요");
			
			int choose=입력.nextInt();
			
			//choose=BoardController.상세보기번호;
		
			controller.BoardController.상세보기(choose);
		
		}else if(menuchoose==3) {
			System.out.println("\n 게시물 번호를 입력하세요");
			
			int choose=입력.nextInt();
			
			controller.BoardController.수정(choose);
			
		}else if(menuchoose==4) {
			System.out.println("몇 번 게시물을 삭제하시겠습니까?");
			
			int choose=입력.nextInt();
			controller.BoardController.삭제(choose);
		}
		
		
		
	}
	
	
}
