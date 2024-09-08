<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 포워딩용 메인 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
  <meta name="author" content="INSPIRO"/>
  <meta name="description" content="Themeforest Template Polo">
  <!-- Document title -->
  <title>코딩 & 로봇 메이트</title>
  <link rel="shortcut icon" href="/homejjang.ico">
  <!-- DataTables css -->
  <link href='/assets/css/datatables.min.css' rel='stylesheet'/>
  <!-- Stylesheets & Fonts -->
  <link href="/assets/css/plugins.css" rel="stylesheet">
  <link href="/assets/css/style.css" rel="stylesheet">

  <!-- Global site tag (gtag.js) - Google Analytics -->
  <script async src="https://www.googletagmanager.com/gtag/js?id=G-68Y1BSKSW1"></script>
  <script>
      window.dataLayer = window.dataLayer || [];

      function gtag() {
          dataLayer.push(arguments);
      }

      gtag('js', new Date());

      gtag('config', 'G-68Y1BSKSW1');
  </script>
  <script>
      // if (document.location.protocol == 'http:') {
      //     document.location.href = document.location.href.replace('http:', 'https:');
      // }

  </script>
</head>
<body>
<!-- Body Inner -->
<div class="body-inner">
  <!-- Header -->
  <!-- Topbar -->

  <!-- end: Topbar -->
  <jsp:include page="header.jsp" flush="false"/>
  <!-- Page title -->
  <section id="page-title" class="text-light" data-bg-parallax="" style="padding:0 !important;">
    <div class="" style="">
      <!-- portfolio item -->
      <div class="portfolio-item img-zoom">
        <div class="portfolio-item-wrap">
          <div class="portfolio-image">
            <a href="#"><img src="images/gallery/main.png" alt=""/></a>
          </div>
          <div class="portfolio-description">
            <a href="portfolio-page-grid-gallery.html">
              <h3>카이스트 주관 2020 AI축구 고등부</h3>
              <span>장관상 수상</span>
            </a>
          </div>
        </div>
      </div>
      <!-- end: portfolio item -->


      <div class="page-title">
        <h1>공지사항</h1>
      </div>

    </div>
  </section>
  <!-- end: Page title -->
  <!-- Page Content -->
  <section id="page-content" class="no-sidebar">
    <div class="container">
      <!-- DataTable -->
      <div class="row mb-3">
        <div class="col-lg-6">
          <h4>공지사항</h4>
          <p>로봇메이트 공지사항입니다.</p>
        </div>
        <div class="col-lg-6 text-right">
          <div id="export_buttons" class="mt-2"></div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <table id="" class="table table-bordered table-hover" style="width:100%">
            <thead>
            <tr>
              <th>등록번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성날짜</th>
              <th>조회수</th>
            </tr>
            </thead>
            <tbody id="noticeContents">
            <c:forEach var="list" items="${noticeList}">
              <tr>
                <td>${list.id}</td>
                <td><a style="color:black" href="/noticeDetail/${list.id}">${list.title}</a></td>

                <td>${list.admin.name}</td>
                <td>${list.displayCreateDate}</td>
                <td>${list.viewCount}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>

      <div class="card-footer bg-white">
        <nav>
          <ul class="pagination justify-content-end mb-0">
            <c:choose>
              <c:when test="${pageable.page > 1}">
                <li class="page-item">
                  <a class="page-link" aria-label="Previous" href="/notice?page=${pageable.prevBlock}">
                    <span aria-hidden="true">이전</span>
                  </a>
                </li>
              </c:when>
            </c:choose>
            <li class="page-item">
              <a class="page-link" style="color:black">${pageable.page}</a>
            </li>
            <c:choose>
              <c:when test="${pageable.endPage > pageable.page}">
                <li class="page-item">
                  <a class="page-link" aria-label="Next" href="/notice?page=${pageable.nextBlock}">
                    <span aria-hidden="true">다음</span>
                  </a>
                </li>
              </c:when>
            </c:choose>
          </ul>
        </nav>
      </div>

      <!-- end: DataTable -->
    </div>
  </section>
  <!-- end: Page Content -->
  <jsp:include page="footer.jsp" flush="false"/>

</div>
<!-- end: Body Inner -->
<!-- Scroll top -->
<a id="scrollTop"><i class="icon-chevron-up"></i><i class="icon-chevron-up"></i></a>
<!--Popover plugin files-->
<script src="/assets/plugins/popper.min.js"></script>
<!--Plugins-->
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/plugins.js"></script>
<!--Template functions-->
<script src="/assets/js/functions.js"></script>
<!--Datatables plugin files-->
<%--<script src='/assets/plugins/datatables.min.js'></script>--%>

<script>
    $(document).ready(function () {
        // fn_search();

        var table = $('#datatable').DataTable({
            buttons: [{
                extend: 'print',
                title: 'Test Data export',
                exportOptions: {
                    columns: "thead th:not(.noExport)"
                }
            }, {
                extend: 'pdf',
                title: 'Test Data export',
                exportOptions: {
                    columns: "thead th:not(.noExport)"
                }
            }, {
                extend: 'excel',
                title: 'Test Data export',
                exportOptions: {
                    columns: "thead th:not(.noExport)"
                }
            }, {
                extend: 'csv',
                title: 'Test Data export',
                exportOptions: {
                    columns: "thead th:not(.noExport)"
                }
            }, {
                extend: 'copy',
                title: 'Test Data export',
                exportOptions: {
                    columns: "thead th:not(.noExport)"
                }
            }]
        });
        table.buttons().container().appendTo('#export_buttons');
        $("#export_buttons .btn").removeClass('btn-secondary').addClass('btn-light');


    });


</script>
</body>

</html>
