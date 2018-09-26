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
			<h3 class="box-title">북마크한 게시물</h3>
		</div>
		
	<div class="box-body">
			<table class="table table-hover table-sm">
				<thead>
					<tr align="center">
						<th width="10%">번호</th>
						<th width="40%">제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${bookmarkList}">
						<tr>
							<td align="center">
								${list.board_num}&nbsp;
							</td>
							<td>
								<a href="detail?board_num=${list.board_num}">${list.board_title}</a>&nbsp;
							</td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
	
</body>
</html>