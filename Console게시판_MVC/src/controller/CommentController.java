package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Repository.CommentDao;
import domain.Comment;

public class CommentController {

	public static ArrayList<Comment> ���2=new ArrayList<>();
	
	public static void ��۸��(int boardnum) {
		
		
		
		CommentDao commentDao= new CommentDao();
		
		ArrayList<Comment> commentlist=commentDao.commentlist(boardnum);
		
		//String �ۼ���=controller.MemberController.�Խ����ۼ����̵�;
		
		for(int i=0; i<commentlist.size(); i++) {
			
			System.out.println("���"+(i+1)+" :"+commentlist.get(i).getContent()+"\t\t"+"�ۼ���:"+commentlist.get(i).getWriterid());
			System.out.println();
			
		}
		
		
		System.out.println("=============================================");
		
	}
	
	public static void ��۾���(int boardnum) {
		
		Scanner �Է�= new Scanner(System.in);
		
		Comment comment=new Comment();
		
		CommentDao commentDao=new CommentDao();
		
		System.out.println("********** ����ۼ� ***********");
		
		
		System.out.println("��� �Է�:");
		
		String �ۼ���=controller.MemberController.�Խ����ۼ����̵�;
		
		String ��۳���=�Է�.next();
		
		comment.setContent(��۳���);
		comment.setWriterid(�ۼ���);
		comment.setBoardnum(boardnum);
		
		int result=commentDao.commentwrite(comment);
		
		if(result==1) {
		
		System.out.println("�ۼ��Ϸ�");
		
		��۸��(boardnum);
		
		
		
		}else {
			System.out.println("����");
		}
	}//��۾��� ��
	
	public static void ��ۻ���(int commentnum, int boardnum) {
		
		System.out.println(commentnum);
		
		Comment comment= new Comment();
		
		CommentDao commentDao= new CommentDao();
		
		ArrayList<Comment> commentlist=commentDao.commentlist(boardnum);
		
		int listcommentnum=commentnum;
		
		int dbcommentnum=commentlist.get(listcommentnum).getNum();
		
		String ����ۼ���=commentlist.get(listcommentnum).getWriterid();
		
		String logid=controller.MemberController.�Խ����ۼ����̵�;
		
		if(����ۼ���.equals(logid)) {
			
			System.out.println((commentnum+1)+"�� ����� �����մϴ�.");
			
			commentDao.commentdelete(dbcommentnum);
			
				controller.BoardController.�󼼺���(boardnum);
			
		}else {
			
			System.out.println("�������� : [��� �ۼ��ڰ� �ƴմϴ�.]");
			System.out.println();
		}
		
		
	
		

	}
	
	
	
}
