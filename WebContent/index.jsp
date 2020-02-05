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
<link href="<c:url value="/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/bootstrap/css/style.css"/>" type="text/css" rel="stylesheet"/>
<script src="<c:url value="/bootstrap/js/jquery-3.2.1.min.js" />" ></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />" ></script>
<base href="${pageConext.servletContext.contextPath}" />
<base href="${pageConext.servletContext.contextPath}"/>
</head>
<body>
	<div id="header">
			<a href="<c:url value=""/>" target="_self" style="text-decoration: none;"><img id="banner" src="<c:url value="/images/banner.png"/>"></a>
			<div id="menu">
				<ul>
					<li><a href="<c:url value="/user/apply.htm"/>"> Đăng Nhập </a></li> 
					<li><a href="<c:url value="/user/form.htm"/>"> Đăng Ký </a></li> 
					
				</ul>
				
			</div>
		</div>
		<div id="trangchu" style="height: 20%">
			<h1 id="box2"><label>Đọc truyện điều độ giữ gìn sức khỏe.</label></h1>
			<p style="font-size:20px;">
				<label>Kho truyện hay cập nhật liên tục.</label>
			</p>
			<img src="<c:url value="/images/tintuc3.jpg"/>" style="height: 15%">
			<p style="font-size:20px;">
				<label>Gửi thư yêu cầu để nhận truyện nhanh nhất.</label>
			</p>
			<img src="<c:url value="/images/tintuc4.jpeg"/>" style="padding-top:50px;margin-bottom: 50px;height: 17%;">
		</div>
		<div id="footer">
			<div id="thongtin">
				Email: duongthichkhampha@gmail.com
			</div>
			<div id="menucuoi">
				<ul>
					<li><a href="<c:url value="/user/form.htm"/>">Đăng ký</a></li>
				</ul>
			</div>
		</div>
</body>
</html>