<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<script>
var lectureCode = "${lectureCode}";
var selectedChapterCode = "";
</script>

<ul class="breadcrumb breadcrumb-page">
  <div class="breadcrumb-label text-light-gray">
	You are here:
  </div>
  <li><a href="/">Home</a></li>
  <li><a href="/course/list">강좌 관리</a></li>
  <li class="active"><a href="#">Mysql</a></li>
</ul>


<div class="page-header">
  <div class="row">
	<h1 class="col-xs-12 col-md-8 text-center text-left-sm" id="LectureCodeHead">
	  <i class="fa fa-file-text page-header-icon"></i>
	</h1>
  </div>
</div>


<div class="row">
  <div class="col-md-8">
  </div>
</div>

<div class="row">
	<div class="panel">
		<div class="panel-body">
			<ul id="uidemo-tabs-default-demo" class="nav nav-tabs">
				<li class="active">
					<a href="#lectur-default" data-toggle="tab">기본정보</a>
				</li>
				<li class="">
					<a href="#lectur-detail" data-toggle="tab">상세정보</a>
				</li>
				<li class="">
					<a href="#lecture-chapter" data-toggle="tab">챕터정보</a>
				</li>
				<li class="">
					<a href="#lecture-users" data-toggle="tab">수강생관리</a>
				</li>
			</ul>

			<div class="tab-content tab-content-bordered">
			    <!-- 강좌 기본 정보 -->
				<div class="tab-pane fade active in" id="lectur-default">
					
					<div class="panel-body form-horizontal">
						<div class="form-group">
							<label for="lectureCode" class="col-sm-2 text-right">Lecture Code</label>
							<div class="col-sm-10" id="lectureCodeValue">
							</div>
						</div> <!-- / .form-group -->

						<div class="form-group">
							<label for="lectureName" class="col-sm-2 text-right">Lecture Name</label>
							<div class="col-sm-10" id="lectureNameValue">
							</div>
						</div> <!-- / .form-group -->

						<div class="form-group">
							<label for="lectureName" class="col-sm-2 text-right">Language</label>
							<div class="col-sm-10" id="lectureLanguageValue">
								<p id=""></p>
							</div>
						</div> <!-- / .form-group -->

						<div class="form-group">
							<label for="lectureName" class="col-sm-2 text-right">Type</label>
							<div class="col-sm-10" id="lectureTypeValue">
							</div>
						</div> <!-- / .form-group -->

						<div class="form-group">
							<label for="lectureName" class="col-sm-2 text-right">thumNamil</label>
							<div class="col-sm-10" id="lectureThumbnailValue">
							</div>
						</div> <!-- / .form-group -->
					</div>
				</div> <!-- / .tab-pane -->


				<!-- 강좌 상세 정보 -->
				<div class="tab-pane fade" id="lectur-detail">
					<div class="row">
							&nbsp;&nbsp;&nbsp;<button id="lectureDetailEditBtn" class="btn btn-primary">상세정보수정</button>
					</div>
					<div class="panel-body form-horizontal">
						
						<div class="form-group">
							<label for="lectureName" class="col-sm-2 text-right">About</label>
							<div class="col-sm-10" id="lectureDetailAboutValue">
								<p>lectureName</p>
							</div>
						</div> <!-- / .form-group -->

						<div class="form-group">
							<label for="lectureName" class="col-sm-2 text-right">Syllabus</label>
							<div class="col-sm-10" id="lectureDetailSyllabusValue">
							</div>
						</div> <!-- / .form-group -->

						<div class="form-group">
							<label for="lectureName" class="col-sm-2 text-right">Format</label>
							<div class="col-sm-10" id="lectureDetailFormatValue">
							</div>
						</div> <!-- / .form-group -->
					</div>
				</div> <!-- / .tab-pane -->

			
				<!-- 강좌 챕터 정보 -->
				<div class="tab-pane fade" id="lecture-chapter">
					<div>
   					    <div class="pannel-header">
							<button id="chapterRegistBtn" class="btn btn-primary">챕터등록</button>
						</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th width="30%">챕터</th>
										<th>Status</th>
										<th>Edit</th>
									</tr>
								</thead>
								<tbody id="chapterList">
									
								</tbody>
							</table>
						</div>
						
					</div>
				</div> <!-- / .tab-pane -->

				<!-- 강좌 기본 정보 -->
				<div class="tab-pane fade widget-followers" id="lecture-users">
					<div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>User</th>
										<th>Status</th>
										<th>승인</th>
									</tr>
								</thead>
								<tbody id="userList">
									
								</tbody>
							</table>
						</div>
						
					</div>
				</div> <!-- / .tab-pane -->
				
			</div> <!-- / .tab-content -->
		</div>
	</div>
</div>

<!-- Edit Detail Modal -->

<div id="eidtDetailModal" class="modal fade" tabindex="-1" role="dialog" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">챕터 수정</h4>
			</div>
			<div class="modal-body">
				<form id="detail-edit-form" class="panel form-horizontal">
					<div class="panel-body">
						<div class="form-group">
							<label for="inputEmail2" class="col-sm-2 control-label">개요</label>
							<div class="col-sm-10">
								<textarea id="editAbout" name="about" class="form-control"></textarea>
								<p class="help-block">강의 개요를 적어주세요</p>
							</div>
						</div> <!-- / .form-group -->
						<div class="form-group">
							<label for="asdasdas" class="col-sm-2 control-label">강의계획서</label>
							<div class="col-sm-10">
								<textarea id="editSyllabus" name="syllabus" class="form-control"></textarea>
								<p class="help-block">강좌 계획서를 적어주세요</p>
							</div>
						</div> <!-- / .form-group -->
						<div class="form-group">
							<label for="asdasdas" class="col-sm-2 control-label">Format</label>
							<div class="col-sm-10">
								<textarea id="editFormat" name="format" class="form-control"></textarea>
								<p class="help-block">강좌 형식을 적어주세요</p>
							</div>
						</div> <!-- / .form-group -->
					</div>
				</form>
			</div> <!-- / .modal-body -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="detailEditBtn" class="btn btn-primary">Save changes</button>
			</div>
		</div> <!-- / .modal-content -->
	</div> <!-- / .modal-dialog -->
</div> <!-- /.modal -->

<!-- end edit detail modal -->

<div id="eidtChapterModal" class="modal fade" tabindex="-1" role="dialog" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">챕터 수정</h4>
			</div>
			<div class="modal-body">
				<form id="chapter-edit-form" class="panel form-horizontal">
					<div class="panel-body">
						<div class="form-group">
							<label for="inputEmail2" class="col-sm-2 control-label">챕터명</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="editChapterName" name="chapterName" placeholder="강좌명을 입력해주세요">
							</div>
						</div> <!-- / .form-group -->
						<div class="form-group">
							<label for="asdasdas" class="col-sm-2 control-label">챕터설명</label>
							<div class="col-sm-10">
								<textarea id="editChapterDescription" name="chapterDescription" class="form-control"></textarea>
								<p class="help-block">강좌 설명을 적어주세요</p>
							</div>
						</div> <!-- / .form-group -->
					</div>
				</form>
			</div> <!-- / .modal-body -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="chapterEditBtn" class="btn btn-primary">Save changes</button>
			</div>
		</div> <!-- / .modal-content -->
	</div> <!-- / .modal-dialog -->
</div> <!-- /.modal -->

<div id="chapterModal" class="modal fade" tabindex="-1" role="dialog" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Modal Heading</h4>
			</div>
			<div class="modal-body">
				
				<form id="chapter-regist-form" class="panel form-horizontal">
					<div class="form-group">
						<label for="inputEmail2" class="col-sm-2 control-label">챕터명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="chapterName" name="chapterName" placeholder="챕터명을 입력해주세요">
						</div>
					</div> <!-- / .form-group -->
					<div class="form-group">
						<label for="asdasdas" class="col-sm-2 control-label">챕터설명</label>
						<div class="col-sm-10">
							<textarea id="lectureDescription" name="chapterDescription" class="form-control"></textarea>
							<p class="help-block">챕터 설명을 적어주세요</p>
						</div>
					</div> <!-- / .form-group -->
					<div class="form-group">
						<label for="fileName" class="col-sm-2 control-label">FileName</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="chapterFileDsiplay" name="chapterFileDsiplay" disabled > 

							<input type="hidden" class="form-control" id="lectureCode" name="lectureCode" value="${lectureCode}">
							<input type="hidden" class="form-control" id="chapterFile" name="chapterFile" > 
							<button type="button" id="uploaddelete" class="btn btn-primary">Delete</button>
						</div>
					</div> <!-- / .form-group -->
				</form>

				<div id="fileForm" class="row">
					<form id="file-upload-form">

						<div class="col-sm-8">
							<input id="uploadfile" name="uploadfile" type="file" multiple="" />
						</div>
						<div class="col-sm-2">
							<button type="button" id="upload" class="btn btn-primary">Upload</button>
						</div>
					</form>
				</div>

				
			</div> <!-- / .modal-body -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="chapterModalRegistBtn" class="btn btn-primary">Save Chapter</button>
			</div>

			
		</div> <!-- / .modal-content -->
	</div> <!-- / .modal-dialog -->

</div> <!-- /.modal -->

<!-- Success -->
<div id="uidemo-modals-alerts-success" class="modal modal-alert modal-success fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<i class="fa fa-check-circle"></i>
			</div>
			<div class="modal-title">성공</div>
			<div class="modal-body">등록 요청 되었습니다.</div>
			<div class="modal-footer">
				<button type="button" id="successBtn" class="btn btn-success">OK</button>
			</div>
		</div> <!-- / .modal-content -->
	</div> <!-- / .modal-dialog -->
</div> <!-- / .modal -->
<!-- / Success -->

<script type="text/javascript">



$(document).ready(function() { 

	// Tabl Action
	$('a[href="#lecture-users"]').click(function() { 
		getUserListData();
    });

	$('a[href="#lectur-default"]').click(function() { 
		getDefaultData();
    });

	$('a[href="#lectur-detail"]').click(function() { 
		getDetailData();
    });

	$('a[href="#lecture-chapter"]').click(function() { 
		getChapterListData();
    });


	/*$('a[data-toggle="tab"]').click('shown', function (e) {
		alert(e.target);
	}); // tabl action*/

	// Button Action

	// Detail
	$("#lectureDetailEditBtn").click(function(e){

		var aboutValue = $('#lectureDetailAboutValue').text();
		var syllabusValue = $('#lectureDetailSyllabusValue').text();
		var formatValue = $('#lectureDetailFormatValue').text();
		$('#editAbout').val(aboutValue);
		$('#editSyllabus').val(syllabusValue);
		$('#editFormat').val(formatValue);
		$('#eidtDetailModal').modal('show');
	});

	$("#detailEditBtn").click(function(e){
		editDetail();
	});

	
	// -- end Detail


	//
	$("#chapterEditBtn").click(function(e){
		  //getData();
		 //$('#myModal').modal('hide');
		 $('#eidtChapterModal').modal('hide');
		 editChapter();
	});

	$('#chapterRegistBtn').click(function(e){

		$('#chapterName').val("");
		$('#chapterDescription').val("");
		$('#uploaddelete').hide();
		$("#chapterFile").val("");
		$("#chapterFileDsiplay").val("");
		$("#fileForm").show();
		$('#chapterModal').modal('show');
	});

	$('#chapterModalRegistBtn').click(function(e){
		registeChapter();
	});


	$("#successBtn").click(function(e){
		 // Ajax 호출
		 $('#uidemo-modals-alerts-success').modal('hide');

		 // 현재탭 확인하여 
		 getChapterListData();
	});

    // File Upload
	$("#upload").click(function(e){
		 // Ajax 호출
		uploadFile();
	});


	getDefaultData();

}); 


// File Upload
function uploadFile(){

	var file = document.getElementById("uploadfile");

	var formData = new FormData();
	formData.append("file", file.files[0]);

	var urlValue = 'http://file.coursevil.org/api/file/save';
	
	 $.ajax({
		type : 'POST',
		url : urlValue,
		contentType : false,
		data : formData,
		processData: false,
		success: function(data, textStatus, jqXHR)
		{
			var filedata = data.data;
			$("#chapterFile").val(filedata.filename);
			$("#chapterFileDsiplay").val(filedata.filename);
			$("#fileForm").hide();
			$('#uploaddelete').show();
		},
		error: function (jqXHR, textStatus, errorThrown)
		{
			console.log(errorThrown);
		}
	});
	
}

// 기본 정보 호출
function getDefaultData(){

	$.ajax({
		type : 'get',
		async : false,
		url : 'http://dev.api.coursevil.org/api/lecture/'+lectureCode,
		cache : false,
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		success : function(data) {
			generate(data);
		},

		error : function(data, status, err) {
			//에러처리
		}
	});
	
}

// 상세 정보 호출
function getDetailData(){
	$.ajax({
		type : 'get',
		async : false,
		url : 'http://dev.api.coursevil.org/api/lecture/'+lectureCode+'/detail',
		cache : false,
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		success : function(data) {
			generateDetail(data);
		},

		error : function(data, status, err) {
			// 에러처리
		}
	});
	
}

// 챕터 리스트 호출
function getChapterListData(){

	$.ajax({
		type : 'get',
		async : false,
		url : 'http://dev.api.coursevil.org/api/chapter/'+lectureCode,
		cache : false,
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		success : function(data) {
			generateChapter(data);
		},

		error : function(data, status, err) {
			//에러처리
		}
	});
	
}

// 유저 리스트 호출
function getUserListData(){

    var urlValue = 'http://dev.api.coursevil.org/api/lecture/'+lectureCode+'/users';

	$.ajax({
		type : 'GET',
		async : false,
		url : urlValue,
		cache : false,
		dataType : "json",
		success : function(data) {
			generateUsers(data);
		},

		error : function(data, status, err) {
			//에러처리
			alert(err)
			console.log(status);
		}
	});
	
}

// 챕터 등록
function registeChapter(){

	var json_val = JSON.stringify($("#chapter-regist-form").serializeObject());


	var urlValue = 'http://dev.api.coursevil.org/api/chapter/'+lectureCode;
	
	 $.ajax({
		type : 'POST',
		async : false,
		url : urlValue,
		cache : false,
		contentType : "application/json; charset=UTF-8",
		data : json_val,
		success: function(data, textStatus, jqXHR)
		{
			$('#chapterModal').modal('hide');
			getRefreshChapter();
		},
		error: function (jqXHR, textStatus, errorThrown)
		{
			// 에러처리
		}
	});
	
}

// 기본정보 세팅
function generate(data){

	var courseData = data.data;
	$("#LectureCodeHead").html("<i class=\"fa fa-file-text page-header-icon\"></i>&nbsp;&nbsp;"+courseData.lectureName);
	$("#lectureCodeValue").html(courseData.lectureCode);
	$("#lectureNameValue").html(courseData.lectureName);
	$("#lectureLanguageValue").html(courseData.lectureLanguage);
	$("#lectureTypeValue").html(courseData.lectureType);

	if(courseData.lectureThumbnail!='undefined' && courseData.lectureThumbnail!=null){
		var html = '<img src="http://d3kiw56smicmwo.cloudfront.net/'+ courseData.lectureThumbnail+'"/>';
		$("#lectureThumbnailValue").html(html);
	}
}

// 상세정보 세팅
function generateDetail(data){

	var detail = data.data;
	$("#lectureDetailAboutValue").html(detail.about);
	$("#lectureDetailSyllabusValue").html(detail.syllabus);
	$("#lectureDetailBackgroundValue").html(detail.background);
	$("#lectureDetailFormatValue").html(detail.format);
}


// 챕터 List 세팅
function generateChapter(data){

	var chapterList = $("#chapterList");
	chapterList.html("");

	var chapter = data.data;
	$.each(chapter, function(index){
		var obj=chapter[index];
		chapterList.append(getChapterList(index+1, obj.chapterCode, obj.chapterName, obj.chapterDescription, obj.chapterStatus));
	});	

	// Event Binding
	getEvent();
}

//ChapterList List 생성
function getChapterList(index, code, name, description, status){
	var innerDiv = '';
	innerDiv = innerDiv + '<tr>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + index;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + name;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + status;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + '<button class="btn btn-primary" name="editChapterBtn" chapterCode=\"'+code+'\">Edit</button>';
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '</tr>';
	return innerDiv
}

// Refresh
function getRefreshChapter(){
	$('#uidemo-modals-alerts-success').modal('show');	
}




// Edit 시 정보 가져오기
function getEvent(){

	$( "button[name='editChapterBtn']" ).bind( "click", function(e) {

		$('#eidtChapterModal').modal('show');
		
		selectedChapterCode = $(this).attr('chapterCode');

		var urlValue = 'http://dev.api.coursevil.org/api/chapter/'+lectureCode+'/'+ selectedChapterCode;

		$.ajax({
			type : 'get',
			async : false,
			url : urlValue,
			cache : false,
			contentType : "application/json; charset=UTF-8",
			dataType : "json",
			success : function(data) {
				$('#editChapterName').val(data.data.chapterName);
				$('#editChapterDescription').val(data.data.chapterDescription);
			},

			error : function(data, status, err) {

			}
		});
		 
	})
}

// Edit 시 수정하기
function editChapter(){

   var urlValue = 'http://dev.api.coursevil.org/api/chapter/'+lectureCode+'/'+ selectedChapterCode;
   var json_val = JSON.stringify($("#chapter-edit-form").serializeObject());

	console.log(urlValue);
	console.log(json_val);

	 $.ajax({
		type : 'PUT',
		async : false,
		url : urlValue,
		cache : false,
		contentType : "application/json; charset=UTF-8",
		data : json_val,
		success: function(data, textStatus, jqXHR)
		{
			getChapterListData();
			alert(data.message);
		},
		error: function (jqXHR, textStatus, errorThrown)
		{
			alert(errorThrown);
		}
	});

}

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



// 챕터 List 세팅
function generateUsers(data){

	var userList = $("#userList");
	userList.html("");

	var users = data.data;
	$.each(users, function(index){
		var obj=users[index];
		userList.append(getUserList(obj.customerCode, obj.status));
	});	

	// Event Binding
	getUserEvent();
}

//ChapterList List 생성
function getUserList(name, status){

	var innerDiv = '';
	innerDiv = innerDiv + '<tr>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + name;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + status;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	if(status!='approve'){
		innerDiv = innerDiv + '<button class="btn btn-primary" name="userApproveBtn" userCode=\"'+name+'\">Approve</button>';
	}
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '</tr>';
	return innerDiv
}

// Edit 시 정보 가져오기
function getUserEvent(){

	$( "button[name='userApproveBtn']" ).bind( "click", function(e) {
		
		var selectedUserCode = $(this).attr('userCode');
		
		var urlValue = 'http://dev.api.coursevil.org/api/entroll/'+lectureCode;
		var json_val = '{"customerCode":"'+selectedUserCode+'", "status":"approve"}' 

		console.log(json_val);
		
		$.ajax({
			type : 'PUT',
			async : false,
			url : urlValue,
			cache : false,
			contentType : "application/json; charset=UTF-8",
			dataType : "json",
			data : json_val,
			success : function(data) {
				getUserListData();
				alert('승인처리되었습니다');

			},

			error : function(data, status, err) {

			}
		});

		 
	})
}

// Edit Detail

// Edit 시 수정하기
function editDetail(){

   var urlValue = 'http://dev.api.coursevil.org/api/lecture/'+lectureCode+'/detail';
   var json_val = JSON.stringify($("#detail-edit-form").serializeObject());

	console.log(urlValue);
	console.log(json_val);

	 $.ajax({
		type : 'POST',
		async : false,
		url : urlValue,
		cache : false,
		contentType : "application/json; charset=UTF-8",
		data : json_val,
		success: function(data, textStatus, jqXHR)
		{
			alert(data.message);
		},
		error: function (jqXHR, textStatus, errorThrown)
		{
			alert(errorThrown);
		}
	});
}



</script>