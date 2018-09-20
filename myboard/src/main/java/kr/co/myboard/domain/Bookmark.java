package kr.co.myboard.domain;

public class Bookmark {
	private int bookmark_num;
	private int board_num;
	private String board_title;
	private String id;
	private String nickname;
	
	public int getBookmark_num() {
		return bookmark_num;
	}
	public void setBookmark_num(int bookmark_num) {
		this.bookmark_num = bookmark_num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Bookmark [bookmark_num=" + bookmark_num + ", board_num=" + board_num + ", board_title=" + board_title
				+ ", id=" + id + ", nickname=" + nickname + "]";
	}
}
