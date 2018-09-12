package kr.co.myboard.domain;

// 검색에 사용 // 기존의 Criteria 클래스로부터 상속을 받고 searchType과 keyword를 추가로 갖는 구조
public class SearchCriteria extends Criteria{
	// 검색 옵션을 저장할 변수
	private String searchType;
	// 검색어를 저장할 변수
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
}
