package domain;

public class Comment {
	
	private int num;
	private String content;
	private String writerid;
	private int boardnum;
	
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	public Comment(int num, String content, String writerid,int boardnum) {
		
		num=this.num;
		content=this.content;
		writerid=this.writerid;
		boardnum=this.boardnum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
 
	public String getWriterid() {
		return writerid;
	}

	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	
	
	
}
