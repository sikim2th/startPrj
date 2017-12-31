<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
	<!-- main -->



      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> 리스트  페이지  </h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right"></i> 게시판 리스트 </h4>
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed">
                              <thead>
                              <tr>
                                  <th>글번</th>
                                  <th>제목 </th>
                                  <th>작성자 </th>
                                  <th>작성일 </th>
                                  <th class="numeric">조회</th>
                               </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${list }" var="bvo">
                              <tr>
                                  <td>${bvo.bid }</td>
                                  <!-- <td><a href="/bbs/read?bid=${bvo.bid }">${bvo.subject }</a></td> -->
                                  <td><a href="/bbs/readPage${pagingMaker.makeUri(pagingMaker.pageCriteria.page)}&bid=${bvo.bid} ">${bvo.subject }</a></td>
                                  <td >${bvo.writer }</td>
                                  <td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${bvo.regdate }"/></td>
                                  <td class="numeric">${bvo.hit }</td>
                              </tr>
                              </c:forEach>
                              
                              </tbody>
                          </table>
                          </section>
                  </div><!-- /content-panel -->
                  
                  	<div class="showback" align="center">
						<div class="btn-group">
						  <c:if test="${pagingMaker.prev }">
						  	<a href="pageList${pagingMaker.makeUri(pagingMaker.startPage - 1) }" ><button type="button" class="btn btn-theme03">PREV</button></a>
						  </c:if>
						  <c:forEach begin="${pagingMaker.startPage }" end="${pagingMaker.endPage }" var="pNum">
						  	<a href="pageList${pagingMaker.makeUri(pNum) }">
						  		<button type="button" class="<c:out value="${pagingMaker.pageCriteria.page == pNum?'btn btn-theme':'btn btn-default'}"></c:out>" >${pNum}</button>
						  	</a>
						  </c:forEach>
						  <c:if test="${pagingMaker.next && pagingMaker.endPage > 0 }">
						  	<a href="pageList${pagingMaker.makeUri(pagingMaker.endPage+1)}"><button type="button" class="btn btn-theme03"> NEXT</button></a>
						  </c:if>
						</div>
      				</div>
                  
               </div><!-- /col-lg-4 -->			
		  	</div><!-- /row -->
		  	
		  	<!-- /row -->

		</section><! --/wrapper -->
      </section> 
      <script>
      var result = '${result}';
      if(result == "success"){
    	  alert("등록되었습니다.")
      }
      </script>
      
      
<%@ include file="../include/footer.jsp" %>