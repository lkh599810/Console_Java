package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Repository.MemberDao;
import domain.Member;
import front.�Խ���ȭ��;

public class MemberController {
	
	public int choose;
	public static String �α��λ���="�α��ξȵ�";
	public static String �Խ����ۼ����̵�="";
	
	public static void signup() {
		
		
		ArrayList<Member> ȸ������Ʈ = MemberDao.getMemberDao().allmember();

		Scanner �Է�=new Scanner(System.in);	
		
		Member member= new Member();
		
		String ���Ծ��̵�;
		String ���Ժ��;
		String �����̸�;
		
		
		String �ߺ���="";
		
		System.out.println("===ȸ������===");
		System.out.println("���̵� �Է�: ");
		���Ծ��̵�=�Է�.next();

		for(int i=0; i<ȸ������Ʈ.size(); i++) {	
			if(���Ծ��̵�.equals(ȸ������Ʈ.get(i).getId())) {
				�ߺ���="�ߺ�";
			}
		}
		
		if(�ߺ���.equals("�ߺ�")) {
			System.out.println("���̵� �ߺ�.");
		}else {
			System.out.println("��й�ȣ �Է�:");
			���Ժ��=�Է�.next();
			System.out.println("�̸� �Է�:");
			�����̸�=�Է�.next();
			
			System.out.println("Ȯ��: ���̵�: "+���Ծ��̵� + "��й�ȣ: "+���Ժ��+" �̸�: "+�����̸�);
			
			member.setId(���Ծ��̵�);
			member.setPw(���Ժ��);
			member.setName(�����̸�);
			
			//ȸ������Ʈ.add(member); =>db���������� �ʿ����.
			MemberDao memberDao = MemberDao.getMemberDao();
			
			int result = memberDao.signup(member);
			if( result == 1 ) System.out.println("���� ");
			else System.out.println("����");
				
		}
	}//signup ��
	
	
	
	
	
	public static void login() {
		
		MemberDao memberDao=MemberDao.getMemberDao();
		
		ArrayList<Member> ȸ������Ʈ = MemberDao.getMemberDao().allmember();

		Scanner �Է�=new Scanner(System.in);	

		String �α��ξ��̵�;
		String �α��κ��;
		
		System.out.println("===�α���===");
		System.out.println("���̵� �Է�: "); 
		
		
		�α��ξ��̵�=�Է�.next();
		
		System.out.println("��й�ȣ �Է�: ");
		
		�α��κ��=�Է�.next();
		
		
		int result=memberDao.login(�α��ξ��̵�, �α��κ��);
		
		if(result==1) {
			System.out.println("�α��� ����");
			
//			�α��λ���="�α�������: "+ȸ������Ʈ.get(�ε���).getId();
//			�Խ����ۼ����̵�=ȸ������Ʈ.get(�ε���).getId();
			
			�α��λ���="�α�������: "+�α��ξ��̵�;
			�Խ����ۼ����̵�=�α��ξ��̵�;
			
			�Խ���ȭ�� �Խ���=new �Խ���ȭ��();
			�Խ���.�Խ���ȭ��();
			
			
			
		}else {
			System.out.println("db����");
		}
		
//		System.out.println("===�α���==="); ==>�ּ�ó���� ���� �����ϱ� ��. dao.login���� �Ҷ� �����.
//		System.out.println("���̵� �Է�:"); 
		
//		�α��ξ��̵�=�Է�.next();

		
//		String �α��ξ��̵�="";
//		String �α��κ����="";
		
//		int �ε���=-1;
		
		
//		for(int i=0; i<ȸ������Ʈ.size(); i++) {
//		  if(ȸ������Ʈ.get(i).getId().equals(�α��ξ��̵�)) {
//			  �α��ξ��̵�="����";
//			  �ε���=i;
//		  }
//		} //for�� ��: for�� �̿� ����Ʈ ���ΰ˻� => ���̵��� �ִ����� ��ȣ(�ε���)�� ������
//		
//		
//		
//		
//		if(�α��ξ��̵�.equals("����")) {
//			
//			System.out.println("��й�ȣ �Է�:");
//			�α��κ��=�Է�.next();
//			
//			if(�α��κ��.equals(ȸ������Ʈ.get(�ε���).getPw())) {
//				
//				System.out.println("�α��� ����");
//				
//					�α��λ���="�α�������: "+ȸ������Ʈ.get(�ε���).getId();
//					
//					�Խ����ۼ����̵�=ȸ������Ʈ.get(�ε���).getId();
//					
//					
//					
//					
//					�Խ���ȭ�� �Խ���=new �Խ���ȭ��();
//					�Խ���.�Խ���ȭ��();
//				
//			}else {
//				System.out.println("��� Ʋ��");
//			}
//			
//		}else {
//			
//			System.out.println("���̵� Ʋ��");
//		}
		
	}//login ��
	
	
	

}
