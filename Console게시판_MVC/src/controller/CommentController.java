package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Repository.CommentDao;
import domain.Comment;

public class CommentController {

	public static ArrayList<Comment> 목록2=new ArrayList<>();
	
	public static void 댓글목록(int boardnum) {
		
		
		
		CommentDao commentDao= new CommentDao();
		
		ArrayList<Comment> commentlist=commentDao.commentlist(boardnum);
		
		//String 작성자=controller.MemberController.게시판작성아이디;
		
		for(int i=0; i<commentlist.size(); i++) {
			
			System.out.println("댓글"+(i+1)+" :"+commentlist.get(i).getContent()+"\t\t"+"작성자:"+commentlist.get(i).getWriterid());
			System.out.println();
			
		}
		
		
		System.out.println("=============================================");
		
	}
	
	public static void 댓글쓰기(int boardnum) {
		
		Scanner 입력= new Scanner(System.in);
		
		Comment comment=new Comment();
		
		CommentDao commentDao=new CommentDao();
		
		System.out.println("********** 댓글작성 ***********");
		
		
		System.out.println("댓글 입력:");
		
		String 작성자=controller.MemberController.게시판작성아이디;
		
		String 댓글내용=입력.next();
		
		comment.setContent(댓글내용);
		comment.setWriterid(작성자);
		comment.setBoardnum(boardnum);
		
		int result=commentDao.commentwrite(comment);
		
		if(result==1) {
		
		System.out.println("작성완료");
		
		댓글목록(boardnum);
		
		
		
		}else {
			System.out.println("실패");
		}
	}//댓글쓰기 끝
	
	public static void 댓글삭제(int commentnum, int boardnum) {
		
		System.out.println(commentnum);
		
		Comment comment= new Comment();
		
		CommentDao commentDao= new CommentDao();
		
		ArrayList<Comment> commentlist=commentDao.commentlist(boardnum);
		
		int listcommentnum=commentnum;
		
		int dbcommentnum=commentlist.get(listcommentnum).getNum();
		
		String 댓글작성자=commentlist.get(listcommentnum).getWriterid();
		
		String logid=controller.MemberController.게시판작성아이디;
		
		if(댓글작성자.equals(logid)) {
			
			System.out.println((commentnum+1)+"번 댓글을 삭제합니다.");
			
			commentDao.commentdelete(dbcommentnum);
			
				controller.BoardController.상세보기(boardnum);
			
		}else {
			
			System.out.println("삭제실패 : [댓글 작성자가 아닙니다.]");
			System.out.println();
		}
		
		
	
		

	}
	
	
	
}
