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
  <jsp:include page="header.jsp" flush="false"/>
  <!-- Topbar -->

  <!-- end: Topbar -->

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
        <h1></h1>
      </div>

    </div>
  </section>
  <!-- end: Page title -->
  <!-- Content -->
  <section id="page-content">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h3>자주묻는 질문 TOP 4<small>(4)</small></h3>
          <p>Tempora incidunt ut labore et dolore magnam auam quaerat voluptatem. Adipisci velit, sed quia non numquam
            eius modi.</p>
          <div class="accordion toggle fancy radius clean">
            <div class="ac-item">
              <h5 class="ac-title"><i class="fa fa-question-circle"></i>Which Author Payment Option Do I Choose?</h5>
              <div class="ac-content" style="display: none;">Neque porro quisquam est, qui dolorem ipsum quia dolor sit
                amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore
                magnam aliquam quaerat voluptatem.
              </div>
            </div>
            <div class="ac-item">
              <h5 class="ac-title"><i class="fa fa-question-circle"></i>Envato Market and Intellectual Property </h5>
              <div class="ac-content" style="display: none;">Neque porro quisquam est, qui dolorem ipsum quia dolor sit
                amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore
                magnam aliquam quaerat voluptatem.
              </div>
            </div>
            <div class="ac-item">
              <h5 class="ac-title"><i class="fa fa-question-circle"></i>Tips for Increasing Your Affiliate Income</h5>
              <div class="ac-content" style="display: none;">Neque porro quisquam est, qui dolorem ipsum quia dolor sit
                amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore
                magnam aliquam quaerat voluptatem.
              </div>
            </div>
            <div class="ac-item ac-active">
              <h5 class="ac-title"><i class="fa fa-question-circle"></i>Showcase Items with a Referral Widget</h5>
              <div class="ac-content" style="">Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet,
                consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam
                aliquam quaerat voluptatem.
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section> <!-- end: Content -->
  <jsp:include page="footer.jsp" flush="false"/>
</div>
<!-- end: Body Inner -->
<!-- Scroll top -->
<a id="scrollTop"><i class="icon-chevron-up"></i><i class="icon-chevron-up"></i></a>
<!--Plugins-->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/plugins.js"></script>
<!--Template functions-->
<script src="assets/js/functions.js"></script>
<!--Google Maps files-->
<script type='text/javascript'
        src='//maps.googleapis.com/maps/api/js?key=AIzaSyAZIus-_huNW25Jl7RPmHgoGZjD5udgBMI'></script>
<script type="text/javascript">
</script>
<!--google Maps end-->
</body>

</html>
