package front;

import java.util.ArrayList;
import java.util.Scanner;

import Repository.MemberDao;
import domain.Member;

public class �ʱ�ȭ�� {

	
	private int choose;



	public �ʱ�ȭ��() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void ȸ������or�α���(int choose) {
		
	
		this.choose=choose;

		
		
		
		
		Scanner �Է�=new Scanner(System.in);	
		
		
		
		
		
		
		if(choose==0) {
			
				
				controller.MemberController.signup();
			
		
			
		} 
		
		else if(choose==1){
			
				controller.MemberController.login();
			
		}
		
		
		
	}//ȸ������or�α��� ��
	
	

	
	
}

