package front;

import java.util.ArrayList;
import java.util.Scanner;

import Repository.MemberDao;
import domain.Member;

public class 초기화면 {

	
	private int choose;



	public 초기화면() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void 회원가입or로그인(int choose) {
		
	
		this.choose=choose;

		
		
		
		
		Scanner 입력=new Scanner(System.in);	
		
		
		
		
		
		
		if(choose==0) {
			
				
				controller.MemberController.signup();
			
		
			
		} 
		
		else if(choose==1){
			
				controller.MemberController.login();
			
		}
		
		
		
	}//회원가입or로그인 끝
	
	

	
	
}

