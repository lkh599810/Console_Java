package front;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import controller.BoardController;
import domain.Board;

public class �Խ���ȭ�� {

	
	
	public �Խ���ȭ��() {
		
	}
	
	public void �Խ���ȭ��() {
		
		�ʱ�ȭ�� �ʱ�ȭ��=new �ʱ�ȭ��();
		Scanner �Է�= new Scanner(System.in);
		
		Board board=new Board();
		
		
		  
		System.out.println("=====================�Խ���=====================");
		System.out.println("\t\t\t"+controller.MemberController.�α��λ���);
		System.out.println("=============================================");
		System.out.println("1.�۾��� 2.�󼼺��� ");

		System.out.println("=====================LIST====================");
		//��Ʈ�ѷ��� ����Ʈ��µ� �����  
		
		controller.BoardController.����Ʈ���();
		
		
		System.out.println("============================================= \n");
		
		int menuchoose=�Է�.nextInt();
		
		if(menuchoose==1) {
			
			controller.BoardController.�۾���();
			
			
		}else if(menuchoose==2) {
			
			System.out.println("\n �Խù� ��ȣ�� �Է��ϼ���");
			
			int choose=�Է�.nextInt();
			
			//choose=BoardController.�󼼺����ȣ;
		
			controller.BoardController.�󼼺���(choose);
		
		}else if(menuchoose==3) {
			System.out.println("\n �Խù� ��ȣ�� �Է��ϼ���");
			
			int choose=�Է�.nextInt();
			
			controller.BoardController.����(choose);
			
		}else if(menuchoose==4) {
			System.out.println("�� �� �Խù��� �����Ͻðڽ��ϱ�?");
			
			int choose=�Է�.nextInt();
			controller.BoardController.����(choose);
		}
		
		
		
	}
	
	
}
