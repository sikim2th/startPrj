<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
	<!-- main -->
	<section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> 게시글 수정   </h3>
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> 수정 사항 </h4>
                      <form role="form" class="form-horizontal style-form" method="post">
                      
                         <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">글번</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="bid" value="${bbsVO.bid }" >
                              </div>
                          </div>
                      
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">제목</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="subject" value="${bbsVO.subject }" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"> 내용 </label>
                              <div class="col-sm-10">
                                  <!-- <input type="text" class="form-control"> -->
                                  <textarea class="form-control"  rows="4" cols="" name="content"  >${bbsVO.content }</textarea>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">작성자 </label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control round-form" name="writer" value="${bbsVO.writer }"  >
                              </div>
                          </div>
                          
                          
                          
                      
          			</form>
                  </div>
                  
					<div class="form-group">
						<div class="col-sm-12" align="center">
			          		<button type="button" id="btn_save" class="btn btn-primary">저장하기 </button>&nbsp;
			          		<button type="button" id="btn_cancel" class="btn btn-warning">취소하기 </button>
		          		</div>
		          	</div> 
		          	
		          	<script>
		          		$(document).ready(function() {
		          			var frmObj = $("form[role='form']");
		          			
		          			console.log("폼태그 입니다. ");
		          			
		          			$("#btn_save").on("click", function(){
		          				frmObj.submit();
		          			});
		          			
		          			$("#btn_cancel").on("click", function(){
		          				self.location = "/bbs/list";
		          			});
		          		});
		          	</script>
		          	                         
          		</div><!-- col-lg-12-->      	
          	</div><!-- /row -->
          	
          	
          	
          	<!-- INLINE FORM ELELEMNTS -->
          	<!-- /row -->
          	
          	<!-- INPUT MESSAGES -->
          	<!-- /row -->
          	
          	<!-- INPUT MESSAGES -->
          	<!-- /row -->
          	
          	
		</section><! --/wrapper -->
      </section>

<%@ include file="../include/footer.jsp" %>
