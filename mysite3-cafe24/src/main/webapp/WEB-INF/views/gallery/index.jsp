<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%pageContext.setAttribute( "newLine", "\n" );%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/lightbox.css" rel="stylesheet" type="text/css">
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/lightbox.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script type="text/javascript">


$(function(){	
	var $galleryul = $("#gallery ul");
	var $galleryli = $("#gallery ul li");
	$galleryli.hide();
	
	// 업로드 다이알로그
	var dialogUpload = $( "#dialog-upload-form" ).dialog({
		autoOpen: false,
		height: 280,
		width: 300,
		modal: true,
		buttons: {
			"업로드": function() {
				var formData = new FormData($('#dialog-upload-form-data')[0]);				
				$ajax.upload(formData);
				
				$( this ).dialog( "close" );
			},
			"취소" : function() {
				$( this ).dialog( "close" );
			}
		},
		close: function() {
			$( "#dialog-upload-form form" ).get(0).reset();	
		}
	});
		
	$("#upload-image").click( function(event) {
		event.preventDefault();
		dialogUpload.dialog( "open" );
	});
	
	
	// 업로드 ajax
	var $ajax = {
			list: function(){
				$.ajax({
					url: "${pageContext.request.contextPath}/gallery/list",
					type: "post",
					beforeSend : function(xhr)
                    {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
                        xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
                    },
					success: function(response){
						if(response.result != "success"){
							console.error(reponse.message);
							return;
						}
						
						response.data.forEach(function(element){
							
							var $a1 = $galleryli.find("#a1");
							var $a2 = $galleryli.find("#a2");
							
							$a1.attr('href','${pageContext.request.contextPath }/'+ element.img);
							$a1.attr('style','background-image:url(${pageContext.request.contextPath }/'+ element.img +');');
							$a2.attr('href','${pageContext.request.contextPath }/gallery/delete/'+ element.no);
							
							var clone = $galleryli.clone();
							clone.show();
							$galleryul.append(clone);
							
						});
					},
					error: function(jqXHR, status, e){
						console.error(status + ":" + e);
					}
				});
			},
			upload: function(formdata){
				$.ajax({
					url: "${pageContext.request.contextPath}/gallery/upload",
					type: "post",
					contentType: false,
					processData: false,
					data: formdata,
					success: function(response){
						if(response.result != "success"){
							console.error(reponse.message);
							return;
						}
						$galleryli.html('');
						$ajax.list();
					},
					error: function(jqXHR, status, e){
						console.error(status + ":" + e);
					}
				});
			}			
	}
	$ajax.list();
	
});	
</script>

<style>
.image {
	display: block;
	height: 100%;
	width: 100%;
	background-size: 100%;
	background-repeat: no-repeat;	
	z-index: 9;
}

#gallery ul li {
	height: 100px;
	width: 100px;
	float: left;
	margin: 10px;
	position: relative;

}

.del-button {
	display: none;
	position: absolute;
	top: 0;
	right: 0;
	z-index: 10;
}

li:hover .image {
	border: 2px solid #f00;
}

#gallery li:hover .del-button{
	display: block;
	height: 20px;
	width: 20px;
	background: url('${pageContext.request.contextPath }/assets/images/delete-imge.png');
	z-index: 10;
	font-size: 0;
	background-size: 20px;
}

#gallery div{
	height: 50px;
}

#gallery div h1 {
	display: block;
	width: auto;
	float: left;
	background: url('${pageContext.request.contextPath }/assets/images/gallery.png') no-repeat;
	background-size: 1.4em;
	padding-left: 1.5em;
}

#upload-image {
	float: right;
}

.btn {
  background-color: #4CAF50; /* Green */
  border: none;
  border-radius: 10px;
  color: white;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

</style>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="gallery">
				<div>
					<h1>갤러리</h1>
					
					<sec:authorize access="hasRole('ADMIN')">
						<a href="" class="btn" id="upload-image">이미지 올리기</a>
					</sec:authorize>
				</div>
				<ul>
						<li>
							<a	href="${pageContext.request.contextPath }/assets/gallery-examples/im1.jpg"
								id="a1"
								data-lightbox="gallery"
								class="image"
								style="background-image:url('${pageContext.request.contextPath }/assets/gallery-examples/im1.jpg');">&nbsp;</a>
								 
							<a	href="${pageContext.request.contextPath }/gallery/delete/1"
								id="a2"
								class="del-button"
								title="삭제">삭제</a>
						</li>																																			
				</ul>	
			</div>

			<div id="dialog-upload-form" title="이미지 업로드" style="display:none">
  				<p class="validateTips normal">이미지와 간단한 코멘트를 입력해 주세요.</p>
  				<form action="${pageContext.request.contextPath }/gallery/upload" 
  					  method="post" id="dialog-upload-form-data"
  					  enctype="multipart/form-data">
					<label>코멘트</label>
					<input type="text" id="input-comments" name="description" value="">
					<label>이미지</label>
					<input type="file" id="input-file" name="multipartFile">
					<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
  				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="gallery"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>