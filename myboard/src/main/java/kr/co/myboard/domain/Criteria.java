package kr.co.myboard.domain;

// 페이지 처리
// 현재 페이지 번호와 페이지 당 출력할 개수, 현재 페이지에 출력될 데이터의 시작 번호를 저장하는 VO
public class Criteria {
	// 현재 출력중인 페이지 번호 저장
	private int page;
	// 페이지에 출력할 데이터 개수
	private int perPageNum;
	// 현재 페이지에 출력될 데이터의 시작 번호
	// 이 데이터는 page와 perPageNum이 결정되면 자동을 ㅗ결정됨
	private int pageStart;
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getPageStart() {
		// 자동으로 계산 // page - 현재 페이지 번호 / perPageNum - 페이지 당 출력 개수
		pageStart  = (page-1)*perPageNum + 1;
		return pageStart;
	}
	
	// 현재 페이지의 데이터 시자건호는 입력받는 항목이 아니기 때문에 setter를 제거
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", pageStart=" + pageStart + "]";
	}
}
