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

    <!-- Stylesheets & Fonts -->
    <link href="/assets/css/plugins.css" rel="stylesheet">
    <link href="/assets/css/style.css" rel="stylesheet">
    <script src="/assets/js/jquery.js"></script>
    <script src="/assets/js/plugins.js"></script>
    <!--Template functions-->
    <script src="/assets/js/functions.js"></script>
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
    <script>
        let page = 1;
        let yearType = "<c:out value="${param.year}" />"
    </script>
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
                        <a href="#"><img src="/images/gallery/main.png" alt=""/></a>
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
            <!-- Portfolio Filter -->
            <nav class="grid-filter gf-outline" data-layout="#portfolio">
                <ul>
                    <li class="${param.year == null || param.year == '' ? 'active' : ''}"><a href="/gallery" data-category="*">Show All</a></li>

                    <c:forEach var="year" items="${years}" begin="0" end="${years.size()}" step="1" varStatus="status">
                        <li class="${param.year== year ? 'active' : ''}"><a href="/gallery?year=${year}" >${year}</a></li>
                    </c:forEach>

                    <li class="${param.year == "prev" ? 'active' : ''}"><a href="/gallery?year=prev">이전</a></li>
                </ul>
                <div class="grid-active-title" style="z-index: -1">Show All</div>
            </nav>
            <!-- end: Portfolio Filter -->
            <!-- Portfolio -->
            <div id="noitems"></div>
            <div id="portfolio" class="portfolio-3-columns" data-margin="0"></div>
            <!-- end: Portfolio -->
        </div>
    </section> <!-- end: Content -->
    <div id="observer"></div>
    <!-- Footer -->
    <footer id="footer">
        <div class="footer-content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="widget" sytle="text-align:center;">
                            <div class="widget-title" style="text-align: center;">
                                <p class="mb-12" style="text-align: center;">경기 안양시 동안구 평촌대로 131 아카데미센터 301호 |
                                    사업자등록번호 138-91-25828 |
                                    개인정보보호책임자 박상훈 |
                                    Copyright © 2020. INSPIRO.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- end: Footer -->
</div>
<!-- end: Body Inner -->
<a id="scrollTop"><i class="icon-chevron-up"></i><i class="icon-chevron-up"></i></a>
<script type="text/javascript" src="/assets/js/page/gallery/gallery.scripts.js"></script>
</body>

</html>
