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
</head>
<script>
    document.getElementsByClassName('plan')
</script>
<body>
<!-- Body Inner -->
<div class="body-inner">
    <jsp:include page="header.jsp" flush="false"/>
    <!-- Page title -->
    <section id="page-title" class="text-light" data-bg-parallax="" style="padding:0 !important;">
        <div>
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
            <!-- Pricing Table -->
            <div class="heading-text heading-line text-center pb-5">
                <h4>가격표</h4>
            </div>
            <div class="row pricing-table">
                <div class="col-md-12 col-12" style="display: flex !important;">
                    <c:forEach var="list" items="${price}">
                        <div class="plan" style="flex: 1;">
                            <div class="plan-header">
                                <h4>${list.contents}</h4>
                                <p class="text-muted">${list.target}</p>
                                <div class="plan-price"><sup>₩</sup>${list.intW1}<span>만원/월</span></div>
                            </div>
                            <div class="plan-list">
                                <ul>
                                    <li><i class="fas fa-globe-americas"></i>${list.w1}원(주 1회)</li>
                                    <li><i class="fa fa-thumbs-up"></i>${list.w2}원(주 2회)</li>
                                    <li><i class="fa fa-signal"></i>${list.w3}원(주 3회)</li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <!-- end: Pricing Table -->
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
