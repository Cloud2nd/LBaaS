<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<script>

var lectureCode = "${lectureCode}";

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
					<a href="#uidemo-tabs-default-demo-home5" data-toggle="tab">수강생관리</a>
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
					</div>
				</div> <!-- / .tab-pane -->


				<!-- 강좌 상세 정보 -->
				<div class="tab-pane fade" id="lectur-detail">
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
							<button class="btn btn-primary">챕터등록</button>
						</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>챕터</th>
										<th>Status</th>
										<th>Edit</th>
										<th>Order</th>
									</tr>
								</thead>
								<tbody id="chapterList">
									
								</tbody>
							</table>
						</div>
						
					</div>
				</div> <!-- / .tab-pane -->

				<!-- 강좌 기본 정보 -->
				<div class="tab-pane fade widget-followers" id="uidemo-tabs-default-demo-home5">
					<div class="follower">
						<img src="/assets/demo/avatars/1.jpg" alt="" class="follower-avatar">
						<div class="body">
							<div class="follower-controls">
								<a href="#" class="btn btn-sm btn-success"><i class="fa fa-check"></i><span>&nbsp;&nbsp;Following</span></a>
							</div>
							<a href="#" class="follower-name">John Doe</a><br>
							<a href="#" class="follower-username">@jdoe</a>
						</div>
					</div>
				</div> <!-- / .tab-pane -->
				
			</div> <!-- / .tab-content -->
		</div>
	</div>
</div>



<div id="myModal" class="modal fade" tabindex="-1" role="dialog" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Modal Heading</h4>
			</div>
			<div class="modal-body">
				<form id="lecture-regist-form" class="panel form-horizontal">
					<div class="panel-body">
						<div class="form-group">
							<label for="inputEmail2" class="col-sm-2 control-label">챕터명</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="lectureName" name="lectureName" placeholder="강좌명을 입력해주세요">
							</div>
						</div> <!-- / .form-group -->
						<div class="form-group">
							<label for="asdasdas" class="col-sm-2 control-label">챕터설명</label>
							<div class="col-sm-10">
								<textarea id="lectureDescription" name="lectureDescription" class="form-control"></textarea>
								<p class="help-block">강좌 설명을 적어주세요</p>
							</div>
						</div> <!-- / .form-group -->
					</div>
				</form>
			</div> <!-- / .modal-body -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="lectureRegistBtn" class="btn btn-primary">Save changes</button>
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
			<div class="modal-title">Some alert title</div>
			<div class="modal-body">Some alert text</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" data-dismiss="modal">OK</button>
			</div>
		</div> <!-- / .modal-content -->
	</div> <!-- / .modal-dialog -->
</div> <!-- / .modal -->
<!-- / Success -->

<script type="text/javascript">



$(document).ready(function() { 

	$('a[href="#uidemo-tabs-default-demo-home5"]').click(function() { 
		
    });

	$('a[href="#lectur-default"]').click(function() { 
		getDefaultData();
    });

	$('a[href="#lectur-detail"]').click(function() { 
		getDetailData();
    });

	$('a[href="#lecture-chapter"]').click(function() { 
		getChapterData();
    });
	
	/*$('a[data-toggle="tab"]').click('shown', function (e) {
		alert(e.target);
	});*/

	$("#lectureRegistBtn").click(function(e){

		  //getData();
		 $('#myModal').modal('hide');
	});

	$("#editChapterBtn").click(function(e){
		 // Ajax 호출
		 $('#myModal').modal('show');
	});

	getDefaultData();

}); 
	
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
			alert('error');
		}
	});
	
}

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
			alert('error');
		}
	});
	
}

function getChapterData(){

	$.ajax({
		type : 'get',
		async : false,
		url : 'http://dev.api.coursevil.org/api/lecture/'+lectureCode+'/chapters',
		cache : false,
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		success : function(data) {
			generateChapter(data);
		},

		error : function(data, status, err) {
			alert('error');
		}
	});
	
}

function generate(data){

	var courseData = data.data;
	$("#LectureCodeHead").html("<i class=\"fa fa-file-text page-header-icon\"></i>&nbsp;&nbsp;"+courseData.lectureName);
	$("#lectureCodeValue").html(courseData.lectureCode);
	$("#lectureNameValue").html(courseData.lectureName);
	$("#lectureLanguageValue").html(courseData.lectureLanguage);
	$("#lectureTypeValue").html(courseData.lectureType);
}

function generateDetail(data){

	var detail = data.data;
	$("#lectureDetailAboutValue").html(detail.about);
	$("#lectureDetailSyllabusValue").html(detail.syllabus);
	$("#lectureDetailBackgroundValue").html(detail.background);
	$("#lectureDetailFormatValue").html(detail.format);
}

function generateChapter(data){


	var chapterList = $("#chapterList");
	chapterList.html("");

	var chapter = data.data;
	$.each(chapter, function(index){
		var obj=chapter[index];
		chapterList.append(getChapterList(index+1, obj.lectureCode, obj.chapterName, obj.chapterDescription));
	});	

}



function getChapterList(index, code, name, description){
	var innerDiv = '';
	innerDiv = innerDiv + '<tr>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + index;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + name + '<br/>' + description;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + 'intall';
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + '<button class="btn btn-primary" id="editChapterBtn">Edit</button>';
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td><button class="btn btn-primary">Up</button>&nbsp;<button class="btn btn-primary">Down</button></td>';
	innerDiv = innerDiv + '</tr>';
	return innerDiv
}


function update(){
	alert("업데이트 요청되었습니다.");
}
</script>

