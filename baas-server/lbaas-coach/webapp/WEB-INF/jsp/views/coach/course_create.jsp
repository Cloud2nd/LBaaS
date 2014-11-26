<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>


<link rel="stylesheet" href="/assets/css/style.css">
<link rel="stylesheet" href="/assets/css/jquery.fileupload.css">

<ul class="breadcrumb breadcrumb-page">
  <div class="breadcrumb-label text-light-gray">
	You are here:
  </div>
  <li><a href="#">Home</a></li>
  <li>강좌 관리</a></li>
  <li class="active"><a href="#">강좌 등록</a></li>
</ul>

<div class="page-header">
  <div class="row">
	<h1 class="col-xs-12 col-sm-4 text-center text-left-sm">
	  <i class="fa fa-suitcase page-header-icon"></i>
	  &nbsp;&nbsp;강좌 등록</h1>
  </div>
</div>

<div class="row">
  <div class="col-md-8">
  </div>
</div>


<div class="row">
	<div class="col-sm-12">

		<form id="lecture-regist-form" class="panel form-horizontal">
			<div class="panel-body">
				<div class="form-group">
					<label for="inputEmail2" class="col-sm-2 control-label">강좌명</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="lectureName" name="lectureName" placeholder="강좌명을 입력해주세요">
					</div>
				</div> <!-- / .form-group -->
				<div class="form-group">
					<label for="asdasdas" class="col-sm-2 control-label">강좌설명</label>
					<div class="col-sm-10">
						<textarea id="lectureDescription" name="lectureDescription" class="form-control"></textarea>
						<p class="help-block">강좌 설명을 적어주세요</p>
					</div>
				</div> <!-- / .form-group -->

				<!-- 강의 Type -->
				<div class="form-group">
					<label class="col-sm-2 control-label">강좌Type</label>
					<div class="col-sm-10">
						<div class="radio">
							<label>
								<input type="radio" name="lectureType" id="lectureTypeMovie" value="MOVIE" class="px" checked="">
								<span class="lbl">동영상강좌</span>
							</label>
						</div> <!-- / .radio -->
						<div class="radio">
							<label>
								<input type="radio" name="lectureType" id="lectureTypeText" value="TEXT" class="px">
								<span class="lbl">File</span>
							</label>
						</div> <!-- / .radio -->
					</div> <!-- / .col-sm-10 -->
				</div> <!-- / .form-group -->

				<!-- 언어 선택 -->
				<div class="form-group">
					<label class="col-sm-2 control-label">Language</label>
					<div class="col-sm-10">
						<div class="radio">
							<label>
								<input type="radio" name="lectureLanguage" id="languageKR" value="KR" class="px" checked="">
								<span class="lbl">Korean</span>
							</label>
						</div> <!-- / .radio -->
						<div class="radio">
							<label>
								<input type="radio" name="lectureLanguage" id="languageEN" value="EN" class="px">
								<span class="lbl">English</span>
							</label>
						</div> <!-- / .radio -->
					</div> <!-- / .col-sm-10 -->
				</div> <!-- / .form-group -->

				
				<div class="form-group">
					<label for="fileName" class="col-sm-2 control-label">Thumnail</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="lectureThumbnailDisplay" name="lectureThumbnailDisplay" disabled > 
							<input type="hidden" class="form-control" id="lectureThumbnail" name="lectureThumbnail" > 
							<div id="uploadform">
							<span class="btn btn-success fileinput-button">
							<i class="glyphicon glyphicon-plus"></i>
							<span>Select files...</span>
							<!-- The file input field used as target for the file upload widget -->
							<input id="file" type="file" name="file" multiple>
							</span>
							<br>
							<br>
							<!-- The global progress bar -->
							<div id="progress" class="progress">
							<div class="progress-bar progress-bar-success"></div>
							</div>
							</div>

						</div>
						

				</div> <!-- / .form-group -->
				</form>

				 <!-- The fileinput-button span is used to style the file input field as button -->


				<div class="form-group right" style="margin-bottom: 0;">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" id="lectureRegistBtn" class="btn btn-primary">강좌 등록</button>
					</div>
				</div> <!-- / .form-group -->
			</div>
		
   
</div>


<script src="/assets/js/vendor/jquery.ui.widget.js"></script>
<script src="/assets/js/jquery.iframe-transport.js"></script>
<script src="/assets/js/jquery.fileupload.js"></script>


<script type="text/javascript">

$(document).ready(function() { 


	$("#lectureThumbnailDisplay").hide();
	$("#uploadform").show();
	
	$("#lectureRegistBtn").click(function(e){

		  var json_val = JSON.stringify($("#lecture-regist-form").serializeObject());
		  
		  $.ajax({
			type : 'POST',
			async : false,
			url : 'http://dev.api.coursevil.org/api/lecture',
			cache : false,
			contentType : "application/json; charset=UTF-8",
			data : json_val,
			success: function(data, textStatus, jqXHR)
			{
				var url = "/course/list";    
				$(location).attr('href',url);
			},
			error: function (jqXHR, textStatus, errorThrown)
			{
				alert("에러"+errorThrown);
			}
		});
	});
    

	$("#upload").click(function(e){
		 // Ajax 호출
		uploadFile();
	});

}); 


/* form data to json */
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
 

$(function () {
    'use strict';
    // Change this to the location of your server-side upload handler:
    var url = "http://file.coursevil.org:8080/api/file/thumnail/save";
     
    $('#file').fileupload({
        url: url,
        dataType: 'json',
        
        add: function(e, data){

        	var uploadFile = data.files[0];
        	
			if (!(/png|jpe?g|gif/i).test(uploadFile.name)) {
                alert('png, jpg, gif 만 가능합니다');
                goUpload = false;
            } else if (uploadFile.size > 5000000) { // 5mb
                alert('파일 용량은 5메가를 초과할 수 없습니다.');
            }
           
            data.submit();
        },
        done: function (e, data) {

			var filedata = data.result.data;
			$("#lectureThumbnail").val(filedata.filename);
			$("#lectureThumbnailDisplay").val(filedata.filename);
			$("#lectureThumbnailDisplay").show();
			$("#uploadform").hide();

        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .progress-bar').css('width',progress + '%');
        }
       
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');
});


</script>