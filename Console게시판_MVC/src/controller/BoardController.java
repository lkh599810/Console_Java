package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import domain.Board;
import front.�Խ���ȭ��;

public class BoardController {// ����Ʈ, ���, �۾���, ����

	public static Scanner �Է�=new Scanner(System.in);
	
	public static ArrayList<Board> �Խ��Ǹ���Ʈ= new ArrayList<>();
	
	public static int �Խù���ȣ=-1;
	
	public static int �󼼺����ȣ=-1;
	
	public static int ��ȸ��;
	
	
	public static void �۾���() {//create
	
		Board board=new Board();
	
		System.out.println("===========�۾���===========");
		System.out.print("����:");
		String ����=�Է�.next();
		System.out.print("\n����:");
		String ����=�Է�.next();
		//date, writerid, count�� �ڵ��������ֱ� date�� Ư�� date�Լ� ���� ���ָ��.
		
		
		
		String �ۼ���=controller.MemberController.�Խ����ۼ����̵�;
		
		Date �ۼ���= new Date();	//�Խù� �ۼ���
		
		��ȸ��=0;
		
		board.setTitle(����);
		board.setContent(����);
		board.setDate(�ۼ���);
		board.setWriterid(�ۼ���);
		board.setCount(��ȸ��);
		
		�Խ��Ǹ���Ʈ.add(board);
		
		
	
	}//�۾��� ��
	
	public static void ����Ʈ���() {
		
		for(int i=0; i<�Խ��Ǹ���Ʈ.size(); i++) {
			
			�Խù���ȣ=i+1;
			
			�󼼺����ȣ=�Խù���ȣ-1; //���� num
			
			System.out.println("����: "+�Խ��Ǹ���Ʈ.get(i).getTitle()+"\t \t �ۼ���: "+�Խ��Ǹ���Ʈ.get(i).getWriterid()+"\t ��ȣ: "+�Խù���ȣ); 
			System.out.println(); 
			
		}
		
		
	}//����Ʈ��� ��
	
	
	
	
	
	
	public static void �󼼺���(int choose) { //read
		
		//choose�� �󼼺����ȣ�� ������� ��. ===> how? ==> for�� ����ҰŰ�����?

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
		
		Board board=new Board();


		�󼼺����ȣ=choose-1;
		
		System.out.println("����:" +�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getTitle()); 
		System.out.println("����: "+�Խ��Ǹ���Ʈ.get(�󼼺����ȣ).getContent()); 
		
		System.out.println("****�ش� �Խù��� �����մϴ�.*****");
		
		�Խ��Ǹ���Ʈ.remove(�󼼺����ȣ);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
