package application;

import java.util.Scanner;

import Repository.MemberDao;
import domain.Member;
import front.�ʱ�ȭ��;

public class Start {

	public static void main(String[] args) {

	// �α����� �ϸ� => 1.�Խ��� 2. ȸ������
		
		
	Scanner �Է�=new Scanner(System.in);	
	
	while(true) {
		
	System.out.println("\n\n========�ʱ�ȭ��=========");
	System.out.println("0.ȸ������ 1.�α���"); 
	
	int ����=�Է�.nextInt();
	
	�ʱ�ȭ�� �ʱ�ȭ��=new �ʱ�ȭ��();
	
	�ʱ�ȭ��.ȸ������or�α���(����);
	
	
	
	}
	
		
	}

}
