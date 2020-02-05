<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Truyện Truyện</title>
<link href="<c:url value="/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/bootstrap/css/style.css"/>" type="text/css"
	rel="stylesheet" />
<script src="<c:url value="/bootstrap/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
<base href="${pageConext.servletContext.contextPath}" />
<style type="text/css">
	#errors{
		color: red;
		font-style: italic;
	}
</style>
</head>
<body>
	<fieldset id="dangky" style="margin-bottom: 10%;margin-top: 10%;width: 80%;margin-top: 5%;margin-left: 10%;margin-right: 10%;">
		<form:form action="form.htm" modelAttribute="user">
			<h2 id="errors">${message}</h2>
			<table>
				<tr>
					<th align="right"><label><b>ID:</b></label></th>
					<th><form:input path="id" placeholder="Tên đăng nhập"/></th>
					<th><form:errors path="id" id="errors"/></th>
				</tr>
				
				<tr>
					<th align="right"><label><b>Password:</b></label></th>
					<th><form:password path="password" placeholder="Mật khẩu"/></th>
					<th><form:errors path="password" id="errors"/></th>
				</tr>

				<tr>
					<th align="right"><label><b>Confirm Password:</b></label></th>
					<th><input type="password" name="repeatpassword"
						placeholder="Nhập lại mật khẩu"></th>
				</tr>
				<tr>
					<th align="right"><label><b>Fullname:</b></label></th>
					<th><form:input path="fullname" placeholder="Họ tên"/></th>
					<th><form:errors path="fullname" id="errors"/></th>
				</tr>
			</table>
			<button class="button" style="margin-left: 45%">Submit</button>
		</form:form>
	</fieldset>
</body>
</html>