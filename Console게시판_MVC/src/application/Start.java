package application;

import java.util.Scanner;

import Repository.MemberDao;
import domain.Member;
import front.초기화면;

public class Start {

	public static void main(String[] args) {

	// 로그인을 하면 => 1.게시판 2. 회원정보
		
		
	Scanner 입력=new Scanner(System.in);	
	
	while(true) {
		
	System.out.println("\n\n========초기화면=========");
	System.out.println("0.회원가입 1.로그인"); 
	
	int 선택=입력.nextInt();
	
	초기화면 초기화면=new 초기화면();
	
	초기화면.회원가입or로그인(선택);
	
	
	
	}
	
		
	}

}
