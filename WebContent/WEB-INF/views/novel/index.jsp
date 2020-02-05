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
	<div id="header">
		<a href="<c:url value="/homeWithAdministrator.htm"/>" target="_self"
			style="text-decoration: none;"><img id="banner"
			src="<c:url value="/images/banner.png"/>"></a>
		<div id="menu">
			<ul>
				<li><a href="<c:url value="/novel/indexadmintt/new.htm"/>"> Truyện mới </a></li>
				<li><a href=""> Thể loại </a>
				<ul class="sub-menu">
					<c:forEach var="c" items="${categorylist}">
						<li><a href="<c:url value="/novel/indexadmintt/${c.id}.htm"/>">${c.name}</a></li>
					</c:forEach>
				</ul></li>
				<li><a href=""> Tác giả </a>
					<ul class="sub-menu">
						<li><a href="<c:url value="/author/insertadmintt.htm"/>">Thêm</a></li>
						<li><a href="<c:url value="/author/indexadmintt.htm"/>">Danh sách</a></li>
					</ul></li>
				<li><a href="<c:url value="/novel/indexadmintt.htm"/>"> Danh sách
				</a></li>
				<li><a href="<c:url value="/"/>"> Đăng xuất </a></li>
				<li><a href="<c:url value="/user/form.htm"/>"> Đăng Ký </a></li>
			</ul>

		</div>
	</div>
	<table class="table table-hover">
		<tr>
			<th><a href="insertadmintt.htm" style="font-size: 18px; text-decoration: none;">Thêm Truyện</a></th>
		</tr>
		<tr>
			<th>Hình ảnh</th>
			<th>Tên truyện</th>
			<th>Tác giả</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="n" items="${novels}">
			<tr>
				<th><img style="width: 120px; height: 80px"
					src="<c:url value="/images/${n.image}"/>"></th>
				<th>${n.name}</th>
				<th>${n.author.name}</th>
				<th><a href="chapterlistadmintt/${n.id}.htm">Xem</a></th>
				<th><a href="chapterlistadmintt/${n.id}/upload.htm">Sửa</a></th>
				<th><a href="chapterlistadmintt/${n.id}/delete.htm">Xóa</a></th>
			</tr>
		</c:forEach>
	</table>
	<div id="footer">
		<div id="thongtin">Email: duongthichkhampha@gmail.com</div>
		<div id="menucuoi">
			<ul>
				<li><a href="<c:url value="/user/form.htm"/>">Đăng ký</a></li>
			</ul>
		</div>
	</div>
</body>