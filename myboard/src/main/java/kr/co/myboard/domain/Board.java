package kr.co.myboard.domain;

import java.sql.Date;

public class Board {
	private int board_num;
	private String board_title;
	private String board_content;
	private String id;
	private String nickname;
	private String profile_img;
	private String write_date;
	private int board_cnt;
	private int board_recommend;

	// 날짜 및 시간을 출력할 변수 // 오늘 작성한 글은 시간을, 어제 이전에 작성된 글은 날짜를 출력
	private String dispDate;

	// 댓글 개수 저장할 변수
	private int replycnt;
	
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
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

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
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

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public int getBoard_cnt() {
		return board_cnt;
	}

	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}

	public int getBoard_recommend() {
		return board_recommend;
	}

	public void setBoard_recommends(int board_recommend) {
		this.board_recommend = board_recommend;
	}

	public String getDispDate() {
		return dispDate;
	}

	public void setDispDate(String dispDate) {
		this.dispDate = dispDate;
	}

	@Override
	public String toString() {
		return "Board [board_num=" + board_num + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", id=" + id + ", nickname=" + nickname + ", profile_img=" + profile_img + ", write_date="
				+ write_date + ", board_cnt=" + board_cnt + ", board_recommend=" + board_recommend + ", dispDate="
				+ dispDate + "]";
	}
}
