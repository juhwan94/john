<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>board</title>
</head>
<body>
	<table border="1">
	<c:forEach items="${List}" var="board">
		<tr>
			<td>
				${board.seq}
			</td>
		</tr>
		<tr>
			<td>
				${board.title}
			</td>
		</tr>
		<tr>
			<td>
				${board.content }
			</td>
		</tr>
		<tr>
			<td>
				${board.writer }
			</td>
		</tr>
		<tr>
			<td>
				${board.regdate }
			</td>
		</tr>
		<tr>
			<td>
				${board.cnt }
			</td>
		</tr>
		</c:forEach>
	</table>
	<table border="1">
		<c:forEach items="${userList}" var="userList">
			<tr>
			<td>
				${userList.userID}
			</td>
			</tr>
			<tr>
			<td>
				${userList.userPW}
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>