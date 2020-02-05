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
<link href="<c:url value="/bootstrap/css/style.css"/>" type="text/css" rel="stylesheet"/>
<link href="<c:url value="/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
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
	<h1 style="text-align: center;color:#4192f4;">${chapter.novel.name}</h1>
	<h2 style="text-align: center;color:#4192f4;">Chương ${chapter.number}: ${chapter.name}</h2>
	<div style="font-size: x-large;;;padding: 5%;border:3px solid #f1f1f1;margin: 5%">${chapter.body}</div>
	<div style="font-size: large;text-align: center; padding: 3%;">
		<c:choose>
			<c:when test="${max == 1 }"></c:when>
			<c:when test="${chapter.number == 1 }">
				<a href="${chapter.number + 1}.htm" style="margin: 10%;">
					<img src="<c:url value="/images/arrow_right.jpg"/>" style="width: 15%;height: 15%">
				</a>
			</c:when>
			<c:when test="${chapter.number == max }">
				<a href="${chapter.number - 1}.htm" style="margin: 10%;"> 
					<img src="<c:url value="/images/arrow_left.jpg"/>" style="width: 15%;height: 15%">
				</a>
			</c:when>
			<c:otherwise>
				<a href="${chapter.number - 1}.htm" style="margin: 10%;"> 
					<img src="<c:url value="/images/arrow_left.jpg"/>" style="width: 15%;height: 15%">
				</a>
				<a href="${chapter.number + 1}.htm" style="margin: 10%;">
					<img src="<c:url value="/images/arrow_right.jpg"/>" style="width: 15%;height: 15%">
				</a>
			</c:otherwise>
		</c:choose>
		
		
	</div>
	<div id="footer">
		<div id="thongtin">Email: duongthichkhampha@gmail.com</div>
		<div id="menucuoi">
			<ul>
				<li><a href="<c:url value="/user/form.htm"/>">Đăng ký</a></li>
				<li><a href="<c:url value="/mailer/form.htm"/>">Liên hệ</a></li>
			</ul>
		</div>
	</div>
</body>