<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section class="content">
<div class="container">
	<div class="box-header">
		<h3 class="box-title">게시판 수정</h3>
	</div>

	<form role="form" method="post">
		<!-- 현재 페이지 번호와 페이지당 출력 개수를 넘겨줌 -->
		<input type="hidden" name="page" value="${criteria.page}"/>
		<input type="hidden" name="perPageNum" value="${criteria.perPageNum}"/>
		<!-- 데이터 수정을할 때 기본키의 값이 있어야하기 때문에 필요!!! 작업 끝나고 결과페이지 상세보기로 하려면 필요 -->
		<input type="hidden" name="board_num" value="${board.board_num}"/>
		<div class="box-body">
			<div class="form-group">
				<label>제목</label> 
				<input type="text" name='board_title' class="form-control" value="${board.board_title}">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" name="board_content" rows="5">${board.board_content}</textarea>
			</div>

			<div class="form-group">
				<label>작성자</label> <input type="text" name="nickname"
					value="${member.nickname}" class="form-control" readonly="readonly">
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">작성완료</button>
		</div>
	</form>
</div>
</section>
