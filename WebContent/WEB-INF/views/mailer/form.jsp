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
</head>
<body>
	<div id="menu">
			<ul>
				<li><a href="<c:url value="/novel/index/new.htm"/>">
						Truyện mới </a></li>
				<li><a href=""> Thể loại </a>
					<ul class="sub-menu">
						<c:forEach var="c" items="${categorylist}">
							<li><a href="<c:url value="/novel/index/${c.id}.htm"/>">${c.name}</a></li>
						</c:forEach>
					</ul></li>
				<li><a href=""> Tác giả </a>
					<ul class="sub-menu">
						<li><a href="<c:url value="/author/index.htm"/>">Danh
								sách</a></li>
					</ul></li>
				<li><a href="<c:url value="/novel/index.htm"/>"> Danh sách
				</a></li>
				<li><a href="<c:url value="/"/>"> Đăng xuất </a></li>
				<li><a href="<c:url value="/user/form.htm"/>"> Đăng Ký </a></li>
			</ul>

		</div>
	<div style="margin-left: 10%;margin-right: 10%;margin-top: 5%">
	${message}
	<form action="send.htm" method="post">
		<div class="form-group">
			<label>From</label>
			<input type="email" name="from" class="form-control" value="duongthichkhampha@gmail.com" readonly="readonly">
		</div>
		<div class="form-group">
			<label>To</label>
			<input name="to" class="form-control" placeholder="Điền email của bạn vào đây">
		</div>
		<button class="btn btn-primary">Send</button>
	</form>
	</div>
</body>
</html>