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
	
	public static int �Խù���ȣ=-1;
	
	public static int �󼼺����ȣ=-1;
	
	public static int ��ȸ��;
	
	
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
		
		
		
		
		BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> �Խ��Ǹ���Ʈ= boardDao.allboard();		
		
//		ArrayList<Board> �Խ��Ǹ���Ʈ= boardDao.getBoardDao().allboard();		

		
		for(int i=0; i<�Խ��Ǹ���Ʈ.size(); i++) {
			
			�Խù���ȣ=i+1;
			
			�󼼺����ȣ=�Խù���ȣ-1; //���� num
			
			System.out.println("����: "+�Խ��Ǹ���Ʈ.get(i).getTitle()+"\t \t �ۼ���: "+�Խ��Ǹ���Ʈ.get(i).getWriterid()+"\t ��ȣ: "+�Խù���ȣ); 
			System.out.println(); 
			
		}
		
		
		
	}//����Ʈ��� ��
	
	
	
	
	
	
	public static void �󼼺���(int choose) { //read
		
		//choose�� �󼼺����ȣ�� ������� ��. ===> how? ==> for�� ����ҰŰ�����?
		BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> �Խ��Ǹ���Ʈ=boardDao.allboard();
		
		
		�󼼺����ȣ=choose-1;
		
		��ȸ��++;
		
		
		System.out.println("=================================================");
			
		
		System.out.println("=====================�󼼺���=====================");
		
		
		System.out.println("����:" +�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getTitle()); 
		
		System.out.println("����: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getContent()); 
		
		System.out.println("�ۼ���: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getWriterid());

		System.out.println("��ȸ��: "+��ȸ��);

		System.out.println("�ۼ���: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getNum());

		
		
		
		System.out.println("=================================================");
		

		
		
		
		
		
		}
	
	
	public static void ����(int choose) { //update
		
	BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> �Խ��Ǹ���Ʈ=boardDao.allboard();
		
		Board board=new Board();

		�󼼺����ȣ=choose-1;
			
		System.out.println("=================================================");
			
		
		System.out.println("=====================�󼼺���=====================");
		
		
		System.out.println("����:" +�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getTitle()); 
		System.out.println("����: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getContent()); 	
		System.out.println("�ۼ���: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getWriterid());
		System.out.println("��ȸ��: "+��ȸ��);
		System.out.println("�ۼ���: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getNum());
	
		
		System.out.println("���� ����:" );
		String ��������=�Է�.next();
		System.out.println("���� ����: ");
		String ��������=�Է�.next();
		
//		�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).setTitle(��������);
//		�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).setContent(��������);
		
		board.setTitle(��������);
		board.setContent(��������);
		
		�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).setTitle(��������);
		�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).setContent(��������);
		
		
		
		System.out.println("=================================================");
		
		
		}//���� ��
	
	
	public static void ����(int choose) {
		
	BoardDao boardDao=new BoardDao();
		
		ArrayList<Board> �Խ��Ǹ���Ʈ=boardDao.allboard();
		
		Board board=new Board();


		�󼼺����ȣ=choose-1;
		
		System.out.println("����:" +�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getTitle()); 
		System.out.println("����: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getContent()); 
		
		System.out.println("****�ش� �Խù��� �����մϴ�.*****");
		
		�Խ��Ǹ���Ʈ.remove(�󼼺����ȣ);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
