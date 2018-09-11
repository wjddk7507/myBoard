<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록보기</title>
</head>
<body>
	<%@include file="../include/header.jsp"%>
	<div class="box container">
		<div class="box-header with-border">
			<c:if test="${msg == null}">
				<h3 class="box-title">게시판 목록보기</h3>
			</c:if>
			<c:if test="${msg != null}">
				<h3 class="box-title">${msg}</h3>
			</c:if>
		</div>
		
		<!-- 출력할 데이터 개수를 설정하는 select -->
		<div class="box-header with-border">
			<span>목록 개수</span>
			<select id="count" class="form-controller">
				<option value="1" <c:out value="${map.pageMaker.criteria.perPageNum==1?'selected':' ' }"/>>1개씩 보기</option>
				<option value="2" <c:out value="${map.pageMaker.criteria.perPageNum==2?'selected':' ' }"/>>2개씩 보기</option>
				<option value="3" <c:out value="${map.pageMaker.criteria.perPageNum==3?'selected':' ' }"/>>3개씩 보기</option>
				<option value="4"<c:out value="${map.pageMaker.criteria.perPageNum==4?'selected':' ' }"/>>4개씩 보기</option>
			</select>
		</div>
		
		<div class="box-body">
			<table class="table table-bordered table-hover">
				<tr>
					<th width="11%">글번호</th>
					<th width="46%">제목</th>
					<th width="16%">작성자</th>
					<th width="16%">작성일</th>
					<th width="11%">조회수</th>
				</tr>
				<c:forEach var="vo" items="${map.list }">
					<tr>
						<td align="right">${vo.board_num}&nbsp;</td>
						<td>&nbsp; <a href='detail?board_num=${vo.board_num}'>${vo.board_title}</a></td>
						<td>
							<img src="${pageContext.request.contextPath}/profile/${vo.profile_img}" id="profile-img">
							&nbsp;${vo.nickname}
						</td>
						<td>&nbsp; ${vo.dispDate}</td>
						<td align="right"><span class="badge bg-blue">
								${vo.board_cnt}</span>&nbsp;</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<!-- 페이지 번호 출력 영역 -->
		<div class="box-footer text-center">
			<ul class="pagination">
				<c:if test="${map.pageMaker.totalCount > 0}">
					<!-- 이전 링크 -->
					<c:if test="${map.pageMaker.prev}">
						<li><a href="list?page=${map.pageMaker.startPage-1}&perPageNum=${map.pageMaker.criteria.perPageNum}">이전</a></li>
					</c:if>
					<!-- 페이지 번호 -->
					<c:forEach var="idx" begin="${map.pageMaker.startPage}" end="${map.pageMaker.endPage}">
						<li <c:out value="${map.pageMaker.criteria.page==idx?'class=active':''}"/>><a href="list?page=${idx}&perPageNum=${map.pageMaker.criteria.perPageNum}">${idx}</a></li>
					</c:forEach>
					<!-- 다음 링크 -->
					<c:if test="${map.pageMaker.next}">
						<li><a href="list?page=${map.pageMaker.endPage+1}&perPageNum=${map.pageMaker.criteria.perPageNum}">다음</a></li>
					</c:if>
					
				</c:if>
			</ul>
		</div>
		
		<div class="box-footer">
			<div class="text-center">
				<button id='mainBtn' class="btn-primary">메인으로</button>
			</div>
			<script>
				$(function() {
					$('#mainBtn').on("click", function(event) {
						location.href = "../";
					});
				});
			</script>
		</div>
	</div>
</body>
<style>
.table th {
	text-align: center;
}
</style>
</html>