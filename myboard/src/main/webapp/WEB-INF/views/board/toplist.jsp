<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top50</title>
</head>
<body>

	<%@include file="../include/header.jsp"%>
	<div class="box container">
		<div class="box-header with-border">
			<h3 class="box-title">TOP 30 게시물</h3>
		</div>
		
	<div class="box-body">
			<table class="table table-hover table-sm">
				<thead>
					<tr class>
						<th width="10%">순위</th>
						<th width="44%">제목</th>
						<th width="16%">작성자</th>
						<th width="16%">작성일</th>
						<th width="7%">조회수</th>
						<th width="7%">북마크</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${order_recommend}" begin="0" end="29" varStatus="status">
						<tr>
							<td align="center">${status.count}</td>
							<td>
								<a href="detail?board_num=${board.board_num}">${board.board_title}</a>&nbsp; <span class="badge badge-info">${board.replycnt}</span>
							</td>
							<td>
								<img src="${pageContext.request.contextPath}/profile/${board.profile_img}" id="profile-img">
								&nbsp;${board.nickname}
							</td>
							<td>&nbsp; ${board.write_date}</td>
							<td align="center">
								<span class="badge bg-blue">${board.board_cnt}</span>&nbsp;
							</td>
							<td align="center">
								<span class="badge bg-blue">${board.board_recommend}</span>&nbsp;
							</td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
</body>
</html>