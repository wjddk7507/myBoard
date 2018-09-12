package kr.co.myboard.domain;

// 페이지 처리
// 리스트 하단에 페이지 번호들을 출력하기 위해 별도의 데이터들이 필요한데 이 데이터들을 저장할 VO
public class PageMaker {
	// 전체 데이터 개수
	private int totalCount;
	// 시작하는 페이지 번호와 끝나는 페이지 번호
	private int startPage;
	private int endPage;
	// 이전과 다음 링크 여부
	private boolean prev;
	private boolean next;
	// 페이지 번호 출력 개수
	private int displayPageNum = 10;
	// 이전에 설정된 옵션 값을 저장하기 위한 변수
	private SearchCriteria criteria;
	
	public int getTotalCount() {
		return totalCount;
	}
	// 전체 데이터 개수를 알고 현제 페이지 번호와 출력할  페이지 개수를 알면 나머지 전부 계산 가능
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		// Math.ceil 함수는 올림을 해주는 함수
		endPage = (int)(Math.ceil(criteria.getPage() / (double)displayPageNum)) * displayPageNum;
		// 시작 페이지 번호
		startPage = endPage-displayPageNum+1;
		// 이전 페이지 링크 여부
		prev = startPage==1? false:true;
		// 끝 페이지 번호는 한가지를 더 확인
		// 끝나는 페이지 번호가 전체 데이터의 페이지 개수보다 크면 전체 데이터의 페이지 개수로 설정
		int pagesu = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		if(endPage > pagesu) {
			endPage = pagesu;
		}
		// 마지막 페이지 번호와 페이지 개수가 같으면 다음은 나올 필요 없음
		next = endPage == pagesu ? false:true;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public Criteria getCriteria() {
		return criteria;
	}
	public void setCriteria(SearchCriteria criteria) {
		this.criteria = criteria;
	}
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", criteria=" + criteria + "]";
	}
}
