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
		<a href="<c:url value="home.htm"/>" target="_self"
			style="text-decoration: none;"><img id="banner"
			src="<c:url value="/images/banner.png"/>"></a>
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
	</div>
	<div id="trangchu" style="height: 50%; margin-right: 5%">
		<c:if test="${fullname != '' }">
			<h1 id="box2">
			<label>Chào ${fullname}</label>
		</h1>
		</c:if>
		<p style="font-size: 20px;">
			<label>Kho truyện hay cập nhật liên tục.</label>
		</p>
		<img src="<c:url value="/images/tintuc3.jpg"/>"
			style="height: 15%; margin: 5%">
		<p style="font-size: 20px;">
			<label>Gửi thư yêu cầu để nhận truyện nhanh nhất.</label>
		</p>
		<img src="<c:url value="/images/tintuc4.jpeg"/>"
			style="margin-bottom: 50px; height: 15%;; margin: 5%">
		<table id="dieuhuong" style="margin-bottom: 5%; margin-left: 5%">
			<tr>
				<th
					style="font-size: 25px; color: white; text-align: center; background: #FF0033;"><label>Truyện
						Hay</label></th>
				<th style="background: #C2C2C2;"></th>
			</tr>
			<tr>
				<th class="hinhanh"><a
					href="<c:url value="/novel/chapterlist/7.htm"/>"><img
						src="<c:url value="/images/hoaxanh.jpg"/>" width="300px"
						height="200px"></a></th>
				<th><a href="<c:url value="/novel/chapterlist/7.htm"/>"> <span
						style="font-size: 30px;">Tôi thấy hoa vàng trên cỏ xanh</span><br>
					<br>
				</a> Ta bắt gặp trong Tôi Thấy Hoa Vàng Trên Cỏ Xanh một thế giới đấy
					bất ngờ và thi vị non trẻ với những suy ngẫm giản dị thôi nhưng gần
					gũi đến lạ.</th>
			</tr>
			<tr>
				<th class="hinhanh"><a
					href="<c:url value="/novel/chapterlist/12.htm"/>"><img
						src="<c:url value="/images/duongmotchieu.jpg"/>" width="300px"
						height="200px"></a></th>
				<th><a href="<c:url value="/novel/chapterlist/12.htm"/>"> <span
						style="font-size: 30px;">Đường một chiều</span><br>
					<br>
				</a> Hôm nay, chỉ tiêu đề: "Ngũ gia Tưởng Mộ Tranh say rượu làm càn, sau
					khi bị cảnh sát Lạc gọi lại kiểm tra, đã mượn rượu trắng bảo là
					nước hoa, phun đầy người mình." đã làm cho trên diễn đàn "Kinh
					thành hoa hoa công tử" dậy sóng.</th>
			</tr>
			<tr>
				<th class="hinhanh"><a
					href="<c:url value="/novel/chapterlist/14.htm"/>"><img
						src="<c:url value="/images/amhuong.jpg"/>" width="300px"
						height="200px"></a></th>
				<th><a href="<c:url value="/novel/chapterlist/14.htm"/>"> <span
						style="font-size: 30px;">Ám hương</span><br>
					<br>
				</a> Trong giời kinh doanh ai ai cũng biết Giang Triết Hàn là một Tổng
					tài nổi danh với tài mạo song toàn, cũng là chủ sở hữu của chuỗi
					khách sạn lớn nhất Bắc Kinh và những chi nhánh khác trải dài khắp
					châu lục.</th>
			</tr>
			<tr>
				<th class="hinhanh"><a
					href="<c:url value="/novel/chapterlist/0.htm"/>"><img
						src="<c:url value="/images/tamquoc.jpg"/>" width="300px"
						height="200px"></a></th>
				<th><a href="<c:url value="/novel/chapterlist/0.htm"/>"> <span
						style="font-size: 30px;">Tam quốc diễn nghĩa</span><br>
					<br>
				</a> Truyện kiếm hiệp, lịch sử Tam quốc Diễn Nghĩa lấy bối cảnh vào
					những năm cuối triều đại nhà Hán, sự suy yếu của của triều đình làm
					cho xã hội Trung Hoa rơi vào cảnh náo loạn.</th>
			</tr>
			<tr>
				<th class="hinhanh"><a
					href="<c:url value="/novel/chapterlist/11.htm"/>"><img
						src="<c:url value="/images/thienlinhcai.jpg"/>" width="300px"
						height="200px"></a></th>
				<th><a href="<c:url value="/novel/chapterlist/11.htm"/>"> <span
						style="font-size: 30px;">Thiên linh cái</span><br>
					<br>
				</a> Câu chuyện có những tình tiết đáng sợ đến ám ảnh, rùng mình, nhưng
					sự thật tàn độc của những kẻ luyện Thiên Linh cái là như thế, mà
					con người vì hai chữ dị đoan chỉ nhìn bề ngoài rồi tin, rồi chạy
					theo một cách không suy nghĩ, để đem đến đau khổ cho người thân của
					mình và cả cho chính bản thân mình.</th>
			</tr>
			<tr>
				<th class="hinhanh"><a
					href="<c:url value="/novel/chapterlist/9.htm"/>"><img
						src="<c:url value="/images/matbiec.jpg"/>" width="300px"
						height="200px"></a></th>
				<th><a href="<c:url value="/novel/chapterlist/9.htm"/>"> <span
						style="font-size: 30px;">Mắt biếc</span><br>
					<br>
				</a> Tuổi thơ ở nơi làng xóm bình yên giản dị thật là đẹp, nhưng rồi
					cũng đến lúc kết thúc khi cả hai đều phải lên thành phố tiếp tục
					việc học, và tấm bi kịch bắt đầu từ đây.</th>
			</tr>
			<tr>
				<th class="hinhanh"><a
					href="<c:url value="/novel/chapterlist/6.htm"/>"><img
						src="<c:url value="/images/deton.jpg"/>" width="300px"
						height="200px"></a></th>
				<th><a href="<c:url value="/novel/chapterlist/6.htm"/>"> <span
						style="font-size: 30px;">Đế tôn</span><br>
					<br>
				</a> Ngươi càng mạnh, dã tâm cũng sẽ càng lớn, dã tâm đã lớn thì năng
					lực đồng dạng cũng phải lớn theo. Phải có những ham muốn to lớn thì
					ngươi mới có động lực để tiến lên, mới đạt được những thành tựu
					ngày càng cao hơn!</th>
			</tr>
		</table>
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
</html>