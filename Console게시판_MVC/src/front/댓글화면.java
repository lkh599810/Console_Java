package front;

import java.util.Scanner;

public class ���ȭ�� {

	
	
	
	public ���ȭ��() {
		
	}
	
	public static void ���ȭ�����(int boardnum) {//from Boardcontroller-�󼼺���
		
		System.out.println();
		System.out.println("====================��۸��===================");
		System.out.println("1. ��۾��� \t 2.��ۻ���"); 
		System.out.println("=============================================");

		
		controller.CommentController.��۸��(boardnum);
		
		System.out.println("=============================================");
		
		
		Scanner �Է�=new Scanner(System.in);
		
		int choose=�Է�.nextInt();
		
		if(choose ==1) {
			controller.CommentController.��۾���(boardnum);
			
			
		}
		if(choose==2) {
			
			//writerid �޾ƿ��� & commentnum �޾ƿ���
			
			System.out.println("��� ����� �����Ͻðڽ��ϱ�?");
			
			int choose2=�Է�.nextInt();
			
			controller.CommentController.��ۻ���(choose2-1,boardnum);
			
			
		}
		
	}
	
	
}
