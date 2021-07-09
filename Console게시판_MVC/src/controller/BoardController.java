package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Repository.BoardDao;
import domain.Board;
import front.�Խ���ȭ��;

public class BoardController {// ����Ʈ, ���, �۾���, ����

	 
	
	public static Scanner �Է�=new Scanner(System.in);
	
	BoardDao boardDao=new BoardDao();
	
	ArrayList<Board> �Խ��Ǹ���Ʈ= boardDao.allboard();
	
	private static int �Խù���ȣ;
	
	public static int �󼼺����ȣ;
	
	private static int ��ȸ��;
	
	
	public static void �۾���() {//create
	
		Board board=new Board();
		
		BoardDao boardDao=BoardDao.getBoardDao();
	
		System.out.println("===========�۾���===========");
		System.out.print("����:");
		String ����=�Է�.next();
		System.out.print("\n����:");
		String ����=�Է�.next();
		//date, writerid, count�� �ڵ��������ֱ� date�� Ư�� date�Լ� ���� ���ָ��.
		
		
		
		String �ۼ���=controller.MemberController.�Խ����ۼ����̵�;
		
		
		Date date= new Date();	//�Խù� �ۼ���
		
		String �ۼ���=date.toString();
		
		��ȸ��=0;
		
		board.setTitle(����);
		board.setContent(����);
		board.setDate(�ۼ���);
		board.setWriterid(�ۼ���);
		board.setCount(��ȸ��);
		
		int result=boardDao.boardwrite(board);
		
		if(result==1) {
			System.out.println("����");
		}else {
			System.out.println("����");
		}
		
	
	}//�۾��� ��
	
	
	
	public static void ����Ʈ���() {
	
		ArrayList<Board> �Խ��Ǹ���Ʈ= BoardDao.getBoardDao().allboard();	
		
		
		
		
		for(int i=0; i<�Խ��Ǹ���Ʈ.size(); i++) {
			
			�Խù���ȣ=i+1;
			
			System.out.println("����: "+�Խ��Ǹ���Ʈ.get(i).getTitle()+"\t \t �ۼ���: "+�Խ��Ǹ���Ʈ.get(i).getWriterid()+"\t ��ȣ: "+�Խù���ȣ); 
			System.out.println(); 
			
		}
		
		
		
	}//����Ʈ��� ��
	
	
	
	
	
	
	public static void �󼼺���(int choose) { //choose==����Ʈ�� ��ȣ(����Ʈ �Խù���ȣ)
		
		
		
		ArrayList<Board> �Խ��Ǹ���Ʈ= BoardDao.getBoardDao().allboard();	


		int boardnum=�Խ��Ǹ���Ʈ.get(choose-1).getNum(); // db �Խù� �ѹ�
		
		�󼼺����ȣ=boardnum;
			
		BoardDao boardDao=BoardDao.getBoardDao();
		
		boardDao.countup(�Խ��Ǹ���Ʈ.get(choose-1)); //����Ʈ�� �ִ� i��° board ��ü. ==�Խ��Ǹ���Ʈ.get(choose-1)
		
		//boardDao.countup(�Խù��ѹ�, �Խù����� ���� ī��Ʈ+1) , dao���� �μ��ΰ� �ְ� setint boardnum setint count+1�� �آZ����. �̰͵� �´°�.

		
		Board board= boardDao.getboard(boardnum); 
		
		
		
		System.out.println("=================================================");
		
	
		System.out.println("=====================�󼼺���=====================");
		
	

	
		System.out.println("����:" +board.getTitle()); 
	
		System.out.println("����: "+board.getContent()); 
	
		System.out.println("�ۼ���: "+board.getWriterid());
	
		System.out.println("��ȸ��: "+board.getCount());

		System.out.println("�ۼ���: "+board.getDate());

		
	
		String �α��ξ��̵�=controller.MemberController.�Խ����ۼ����̵�;
		
		System.out.println("=================================================");
		
		System.out.print("1. ��� ");
		
		if(board.getWriterid().equals(�α��ξ��̵�)){
				System.out.print("2.����"); System.out.print("3.����"); 
				System.out.println();
			}
		
			int choose2=�Է�.nextInt();
		
			if(choose2==1) { //boardcontroller�󼼺��� => front���ȭ�� =>commentcontroller=>commentdao
				front.���ȭ��.���ȭ�����(boardnum);
			}
			else if(choose2==2) {
				
				����(boardnum);
			
			}else if(choose2==3) {
				
				����(boardnum);
			}
		
		
			System.out.println();
			System.out.println("=================================================");

	
		
		
		
//		//choose�� �󼼺����ȣ�� ������� ��. ===> how? ==> for�� ����ҰŰ�����?
//		BoardDao boardDao=new BoardDao();
//		
//		ArrayList<Board> �Խ��Ǹ���Ʈ=boardDao.allboard();
//		
//		
//		�󼼺����ȣ=choose-1;
//		
//		��ȸ��++;
//		String �α��ξ��̵�=controller.MemberController.�Խ����ۼ����̵�;
//		
//		
//		System.out.println("=================================================");
//			
//		
//		System.out.println("=====================�󼼺���=====================");
//			
//		
//	
//		
//		System.out.println("����:" +�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getTitle()); 
//		
//		System.out.println("����: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getContent()); 
//		
//		System.out.println("�ۼ���: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getWriterid());
//
//		System.out.println("��ȸ��: "+��ȸ��);
//
//		System.out.println("�ۼ���: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getDate());
//
//		
//		
//		
//		System.out.println("=================================================");
//		
//	System.out.print("1. ��� ");
//		
//		if(�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getWriterid().equals(�α��ξ��̵�)){
//				System.out.print("2.����"); System.out.print("3.����"); 
//				System.out.println();
//			}
//		
//			int choose2=�Է�.nextInt();
//		
//			if(choose2==1) {
//				//���dao.��۸��
//			}
//			else if(choose2==2) {
//				
//				����(choose2);
//			
//			}else if(choose2==3) {
//				
//				����(choose2);
//			}
//		
//		
//			System.out.println();
//			System.out.println("=================================================");
//
//		
		
		}
	
	
	public static void ���� (int �󼼺����ȣ) { //update
		
	BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> �Խ��Ǹ���Ʈ=boardDao.allboard();
		
		Board board=new Board();

		System.out.println(�󼼺����ȣ);
			
		System.out.println("========================����������====================");
		
		System.out.println("���� ����:" );
		String ��������=�Է�.next();
		System.out.println("���� ����: ");
		String ��������=�Է�.next();
		System.out.println();
		
		int ����num=�󼼺����ȣ; //��̸���Ʈ�� 0����, db num�� 1����. ???
		
		board.setTitle(��������);
		board.setContent(��������);
//		board.setNum(�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getNum());
		board.setNum(����num);


		
		
		int result=boardDao.boardupdate(board);
		
		if(result==1) {
			System.out.println("����");
			System.out.println("=================================================");
			System.out.println();
			
			����Ʈ���();
		
		}else {
			System.out.println("����");
			
		}
		
		
		System.out.println("=================================================");
		
		
		}//���� ��
	
	
	public static void ����(int �󼼺����ȣ) {
		
	BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> �Խ��Ǹ���Ʈ=boardDao.allboard();
		
		Board board=new Board();


		System.out.println(�󼼺����ȣ);
		
		System.out.println("����:" +�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getTitle()); 
		System.out.println("����: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getContent()); 
		
		System.out.println("****�ش� �Խù��� �����մϴ�.*****");
		
		board.setNum(�󼼺����ȣ);
		
//		int ������ȣ=�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getNum()-1;
//		board.setNum(������ȣ);

		int result=boardDao.boarddelete(board);
		
		if(result==1) {
			System.out.println("����");
		}else {
			
			System.out.println("����");
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
