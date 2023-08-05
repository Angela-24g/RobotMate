<!-- 포워딩용 메인 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
    <!-- Header -->
    <!-- Topbar -->

    <!-- end: Topbar -->
    <jsp:include page="header.jsp" flush="false"/>
    <!-- Inspiro Slider -->
    <div id="slider" class="inspiro-slider slider-fullscreen dots-creative">
        <c:forEach var="item" items="${mainGalleries}" begin="0" end="${mainGalleries.size()}" step="1" varStatus="status">
            <!-- Slide 1 -->
            <c:choose>
                <c:when test="${item.file.fileFormat.startsWith('video')}">
                    <div class="slide kenburns" data-bg-video="${item.imageUri}"
                         style="background-size: cover;">
                        <div class="bg-overlay"></div>
                        <div class="container">
                            <div class="slide-captions text-center text-light">
                                <h1>${item.title}</h1>
                                <p>${item.contents}</p>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="slide kenburns" data-bg-image="${item.imageUri}"
                         style="background-size: cover;">
                        <div class="bg-overlay"></div>
                        <div class="container">
                            <div class="slide-captions text-center text-light">

                                <h1>${item.title}</h1>
                                <p>${item.contents}</p>

                            </div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
    <!--end: Inspiro Slider -->
    <!-- WELCOME -->
    <section id="welcome" class="p-b-0">
        <div class="container">
            <div class="heading-text heading-section text-center m-b-40" data-animate="fadeInUp">
                <h2>자기주도 학습의 완성</h2>
                <span class="lead">스스로 학습하여 문제를 해결하는 능력을 길러줍니다.</span>
            </div>
        </div>
    </section>
    <!-- end: WELCOME -->

    <!-- PORTFOLIO -->
    <section class="p-t-0 p-b-0">
        <div class="container">
            <div class="heading-text heading-section">
                <h2><i class="icon-award"></i>수상 실적</h2>
                <span class="lead">대회에 나가 아이들이 직접 이룬 뿌듯한 결과입니다.</span>
            </div>
        </div>
        <div class="portfolio">
            <c:if test="${galleries.size() <= 0}">
                <div class="text-center">
                    수상실적이 없습니다.
                </div>
            </c:if>
            <!-- Portfolio Items -->
            <div id="portfolio" class="grid-layout portfolio-6-columns" data-margin="0">
                <!-- portfolio item -->
                <c:forEach var="item" items="${galleries}" begin="0" end="${galleries.size()}" step="1" varStatus="status">
                    <div class="portfolio-item img-zoom ct-photography ct-media ct-branding ct-Media">
                        <div class="portfolio-item-wrap">
                            <div class="portfolio-image">
                                <a href="#"><img src="${item.imageUri}" alt="${item.file.name}"></a>
                            </div>
                            <div class="portfolio-description">
                                <a href="portfolio-page-grid-gallery.html">
                                    <h3>${item.title}</h3>
                                    <h3>${item.contents}</h3>
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <!-- end: portfolio item -->
            </div>
            <!-- end: Portfolio Items -->
        </div>
    </section>
    <!-- end: PORTFOLIO -->


    <!-- SERVICES -->
    <section>
        <div class="container">
            <div class="heading-text heading-section text-center">
                <h2>코딩 & 로봇메이트 학생이 진학한 학교</h2>
                <p></p>
            </div>
            <div class="row" style="padding-top:20px;">
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>하버드대학교</h3>
                        <!-- <p>전기정보과</p> -->
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>서울대학교</h3>
                        <p>전기정보과</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>카이스트</h3>
                        <p>공과대학</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>고려대학교</h3>
                        <p>기계공학과</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>연세대학교</h3>
                        <p>전기전자공학부</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>포항공대</h3>
                        <p>전자과</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>서울과학기술대학교</h3>
                        <p>기계시스템디자인공학과</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>건국대학교</h3>
                        <p>컴퓨터공학과</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>단국대학교</h3>
                        <p>응용화공학과</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>한국산업기술대학교</h3>
                        <p>메카트로닉스공학과</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>조선대학교 의과대학</h3>
                        <p></p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>강남대학교</h3>
                        <p>소프트웨어응용학부</p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>민족사관고등학교</h3>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>디지털미디어고등학교</h3>
                        <p></p>
                    </div>
                </div>
                <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100">
                    <div class="icon-box effect medium border small">
                        <div class="icon">
                            <a href="#"><i class="fa fa-thumbs-up"></i></a>
                        </div>
                        <h3>인터넷선린고등학교</h3>
                    </div>
                </div>
                <!-- <div class="col-lg-4" data-animate="fadeInUp" data-animate-delay="100"> -->
                <!-- <div class="icon-box effect medium border small"> -->
                <!-- <div class="icon"> -->
                <!-- <a href="#"><i class="fa fa-thumbs-up"></i></a> -->
                <!-- </div> -->
                <!-- <h3>수원하이텍고등학교</h3> -->
                <!-- </div> -->
                <!-- </div>                                          -->
            </div>
        </div>
    </section>
    <!-- end: SERVICES -->

    <!-- WHAT WE DO -->
    <section class="background-grey">
        <div class="container">
            <div class="heading-text heading-section">
                <h2><i class="icon-book-open"></i> 교육 커리큘럼</h2>

            </div>
            <div class="row">
                <div class="col-lg-4" style="margin-bottom:30px;">
                    <div data-animate="fadeInUp" data-animate-delay="0">
                        <h3>교육용 입문단계(7세~11세)</h3>
                        <h4>교육용 로봇 (로보로보, 프로보 활용)<br>코딩 (스크래치, 엔트리 활용)<br>로봇 조종 대회 출전</h4>
                    </div>
                </div>
                <div class="col-lg-4" style="margin-bottom:30px;">
                    <div data-animate="fadeInUp" data-animate-delay="200">
                        <h3>대회용 고급단계(초,중,고등학생)</h3>
                        <h4>대회용 로봇 (블랙라인 W 활용)<br>기초 C언어 학습<br>로봇 프로그램 대회 출전</h4>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div data-animate="fadeInUp" data-animate-delay="400">
                        <h3>전문화 선택학습 심화단계</h3>
                        <h4>파이썬 AI 축구연계<br>아두이노 학습<br>전자회로 학습<br>3D프린터 학습</h4>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- END WHAT WE DO -->


    <!-- Section -->
    <section class="" style="padding-top:150px !important;">
        <img src="/assets/images/section06/bg02.jpg"
             style="z-index: -1; width:100%; height:100%; position:absolute; left:0; top:0; opacity: 0.2;">
        <div class="container">
            <!--Embeds -->
            <div class="row" sytle="">
                <div class="col-lg-6">
                    <video src="/assets/images/video/sedtion06.mp4" controls autoplay muted loop></video>
                </div>
                <div class="col-lg-6" style="text-align: center;">
                    <h2>상담 안내</h2>
                    <h1>031-385-4236</h1>
                    <h3>문의주시면 자세히 안내해드리겠습니다.</h3>
                    <h4>(무료 체험 교육 1회 제공)</h4>
                </div>

            </div>
            <!--END: Embeds -->
            <hr class="space">
        </div>
    </section>
    <!-- end: Section -->
    <!-- Section -->
    <section class="" style="">

        <div class="container">
            <!--Embeds -->
            <div class="row" sytle="">

                <div class="col-lg-6" style="">
                    <h2 style=""><i class="icon-map-pin"> </i>주소</h2>
                    <h3><i class="icon-minus"> </i>경기도 안양시 동안구 평촌대로 131 아카데미센터 301호</h3>
                    <h2 style="padding-top:20px;"><i class="icon-map-pin"> </i>오시는 방법</h2>
                    <h4><a
                            href="https://map.kakao.com/link/map/로봇메이트 3층(경기도 안양시 동안구 평촌대로 131 아카데미센터 301호),37.383847, 126.959315">
                        카카오맵으로 길찾기</a></h4>
                    <h3><i class="icon-minus"> </i>범계역</h3>
                    <h4>마을버스 <span style="color:blue">03번</span> or <span style="color:blue">10-2번</span> 승차</h4>
                    <h4><i class="icon-arrow-right" style="color: red;"> </i>학원가, 먹자골목 하차</h4>
                    <h3 style="padding-top:10px;"><i class="icon-minus"> </i>평촌역</h3>
                    <h4>마을버스 <span style="color:blue">5-5번</span> or <span style="color:blue">52-1번</span> 승차</h4>
                    <h4><i class="icon-arrow-right" style="color:red"> </i>학원가, 먹자골목 하차</h4>

                </div>
                <div class="col-lg-6" id="map" style="width:500px; height:400px; margin-top:30px;"></div>
                <script type="text/javascript"
                        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=460cdd373014cd1639169c662c206254"></script>

                <script>
                    var container = document.getElementById('map');
                    var options = {
                        center: new kakao.maps.LatLng(37.383847, 126.959315),
                        level: 3
                    };
                    var map = new kakao.maps.Map(container, options);
                    //마커가 표시될 위치입니다.
                    var markerPosition = new kakao.maps.LatLng(37.383847, 126.959315);
                    // 마커를 생성합니다
                    var marker = new kakao.maps.Marker({
                        position: markerPosition
                    });

                    // 마커가 지도 위에 표시되도록 설정합니다
                    marker.setMap(map);
                    var iwContent =
                            '<div style="padding:5px;">로봇 메이트 3층<br><a href="https://map.kakao.com/link/map/로봇 메이트 3층,37.383847, 126.959315" style="color:blue" target="_blank">큰 지도보기 / </a> <a href="https://map.kakao.com/link/to/로봇메이트 2층,37.383847, 126.959315" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                        iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

                    // 인포윈도우를 생성합니다
                    var infowindow = new kakao.maps.InfoWindow({
                        position: iwPosition,
                        content: iwContent
                    });

                    // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
                    infowindow.open(map, marker);
                </script>


                <!-- <div class="col-lg-6" style="background-image: ;">
                    <img src="images/map/map.png" width="100%" height="100%">
                </div> -->
            </div>
            <!--END: Embeds -->

        </div>
    </section>
    <!-- end: Section -->
    <jsp:include page="footer.jsp" flush="false"/>

</div>

<!-- end: Body Inner -->
<!-- Channel Plugin Scripts 채널톡 스크립트  -->
<script>
    (function () {
        var w = window;
        if (w.ChannelIO) {
            return (window.console.error || window.console.log || function () {
            })(
                'ChannelIO script included twice.');
        }
        var ch = function () {
            ch.c(arguments);
        };
        ch.q = [];
        ch.c = function (args) {
            ch.q.push(args);
        };
        w.ChannelIO = ch;

        function l() {
            if (w.ChannelIOInitialized) {
                return;
            }
            w.ChannelIOInitialized = true;
            var s = document.createElement('script');
            s.type = 'text/javascript';
            s.async = true;
            s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
            s.charset = 'UTF-8';
            var x = document.getElementsByTagName('script')[0];
            x.parentNode.insertBefore(s, x);
        }

        if (document.readyState === 'complete') {
            l();
        } else if (window.attachEvent) {
            window.attachEvent('onload', l);
        } else {
            window.addEventListener('DOMContentLoaded', l, false);
            window.addEventListener('load', l, false);
        }
    })();
    ChannelIO('boot', {
        "pluginKey": "2bdd05d3-1b66-403c-9c0a-40804455e061"
    });
</script>
<!-- End Channel Plugin -->
<!-- Scroll top -->
<a id="scrollTop"><i class="icon-chevron-up"></i><i class="icon-chevron-up"></i></a>
<!--Plugins-->
<script src="/assets/js/jquery.js"></script>
<script src="/assets/js/plugins.js"></script>
<!--Template functions-->
<script src="/assets/js/functions.js"></script>
<!--Google Maps files-->
<script type='text/javascript' src='//maps.googleapis.com/maps/api/js?key=AIzaSyAZIus-_huNW25Jl7RPmHgoGZjD5udgBMI'>
</script>
<script type="text/javascript" src="/assets/plugins/gmap3/gmap3.min.js"></script>
<script type="text/javascript" src="/assets/plugins/gmap3/map-styles.js"></script>
<script type="text/javascript">
    $('#google-map-multiple').gmap3({
        center: [48.8620722, 2.352047],
        zoom: 3
    })
        .marker([{
            position: [40.712776, -74.005974],
            icon: ' '
        },
            {
                position: [55.378052, -3.435973],
                icon: ' '
            },
            {
                position: [51.165691, 10.451526],
                icon: ' '
            }
        ]).overlay({
        position: [40.712776, -74.005974],
        content: '<div class="animated-dot"></div>',
    }).overlay({
        position: [55.378052, -3.435973],
        content: '<div class="animated-dot"></div>',
    }).overlay({
        position: [51.165691, 10.451526],
        content: '<div class="animated-dot"></div>',
    });
</script>
<!--google Maps end-->
</body>
</html>
