package front;

import java.util.Scanner;

public class ´ñ±ÛÈ­¸é {

	
	
	
	public ´ñ±ÛÈ­¸é() {
		
	}
	
	public static void ´ñ±ÛÈ­¸éÃâ·Â(int boardnum) {//from Boardcontroller-»ó¼¼º¸±â
		
		System.out.println();
		System.out.println("====================´ñ±Û¸ñ·Ï===================");
		System.out.println("1. ´ñ±Û¾²±â \t 2.´ñ±Û»èÁ¦"); 
		System.out.println("=============================================");

		
		controller.CommentController.´ñ±Û¸ñ·Ï(boardnum);
		
		System.out.println("=============================================");
		
		
		Scanner ÀÔ·Â=new Scanner(System.in);
		
		int choose=ÀÔ·Â.nextInt();
		
		if(choose ==1) {
			controller.CommentController.´ñ±Û¾²±â(boardnum);
			
			
		}
		if(choose==2) {
			
			//writerid ¹Þ¾Æ¿À±â & commentnum ¹Þ¾Æ¿À±â
			
			System.out.println("¸î¹ø ´ñ±ÛÀ» »èÁ¦ÇÏ½Ã°Ú½À´Ï±î?");
			
			int choose2=ÀÔ·Â.nextInt();
			
			controller.CommentController.´ñ±Û»èÁ¦(choose2-1,boardnum);
			
			
		}
		
	}
	
	
}
