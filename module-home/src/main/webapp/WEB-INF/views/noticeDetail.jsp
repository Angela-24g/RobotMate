<!-- 포워딩용 메인 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
  String id = request.getParameter("id");
%>

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
<style>
    #editorContent img{
        max-width: 400px;
    }
    a {text-decoration: none}
</style>
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
  <section id="page-content">
    <div class="container">
      <div class="row">
        <!-- content -->
        <div class="content col-lg-12">
          <!-- form -->
          <form>
            <div class="row">
              <div class="col-lg-12">
                <div class="form-group">
                  <label>제목</label>
                  <input type="text" style="color: black" id="notify_title" value="${notice.title}"
                         class="form-control notification-message">
                </div>
                <div class="form-group">
                  <label>내용</label>
                  <div style="min-height:400px; height: 100%;" id="editorContent"
                       class="form-control notification-message">${notice.contents}
                    <%--                  <textarea id="notify_message" class="form-control notification-message"--%>
                    <%--                            required="" rows="5">${notice.contents}</textarea>--%>
                  </div>
                </div>
              </div>
              <div class="row mt-5" style="text-align: center; width:100%">
                <div class="col-lg-12 text-center">
                  <a href="/notice" id="notify_btn" class="btn btn-primary">목록으로</a>
                </div>
              </div>
          </form>
          <!--end::Form-->
        </div>
        <!-- end: content -->

      </div>
    </div>
  </section>
  <jsp:include page="footer.jsp" flush="false"/>
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
  <script src='/assets/plugins/datatables.min.js'></script>
  <!--Bootstrap switch files-->
  <script src="plugins/bootstrap-switch/bootstrap-switch.min.js"></script>

</html>
