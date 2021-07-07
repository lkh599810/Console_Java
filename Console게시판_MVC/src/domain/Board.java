package domain;

import java.util.Date;

public class Board {
	
	private int num;
	private String title;
	private String content;
	private String writerid;
	private String date;
	private int count;
	
	public Board() {

	
	}
	
	public Board(String title, String content, String writerid, String date) {

		
		this.title=title;
		this.content=content;
		this.writerid=writerid;
		this.date=date;
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
