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
<body>
<!-- Body Inner -->
<div class="body-inner">
  <!-- Header -->
  <!-- Topbar -->

  <!-- end: Topbar -->
  <!-- Header -->
  <header id="header" data-fullwidth="true">
    <div class="header-inner">
      <div class="container">
        <!--Logo-->
        <div id="logo">
          <a href="/">
            코딩 & 로봇 메이트
          </a>
        </div>
        <!--End: Logo-->


        <!--Navigation Resposnive Trigger-->
        <div id="mainMenu-trigger">
          <a class="lines-button x"><span class="lines"></span></a>
        </div>
        <!--end: Navigation Resposnive Trigger-->
        <!--Navigation-->
        <div id="mainMenu">
          <div class="container">
            <nav>
              <ul>
                <li sytle=""><a href="index.html" style="color:red; font-weight:bold;">국제 올림피아드 인증
                  교육기관</a></li>
                <li><a href="index.html">Home</a></li>
                <li><a href="https://cafe.naver.com/breshit0" target="_blank">공식 카페</a>

                </li>
                <li class="dropdown"><a href="#">교육과정</a>
                </li>
                <li class=""><a href="gallery">갤러리</a>

                </li>
                <li class="dropdown"><a href="#" style="color:red;">031-385-4236</a>

                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!--end: Navigation-->
      </div>
    </div>
  </header>
  <!-- end: Header -->
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
  <!-- Page Content -->
  <section id="page-content" class="no-sidebar">
    <div class="container">
      <!-- DataTable -->
      <div class="row mb-3">
        <div class="col-lg-6">
          <h4>DataTables</h4>
          <p>Add advanced interaction controls to your HTML tables</p>
        </div>
        <div class="col-lg-6 text-right">
          <button type="button" class="btn btn-light"><i class="icon-plus"></i> Add Record</button>
          <div class="p-dropdown ml-3 float-right">
            <a class="title btn btn-light"><i class="icon-sliders"></i> Options</a>
            <div class="p-dropdown-content">
              <ul>
                <li><a href="#"><i class="icon-refresh-cw"></i>Update Records</a></li>
                <li><a href="#"><i class="icon-edit"></i>Edit</a></li>
                <li><a href="#"><i class="icon-x"></i>Delete</a></li>
                <li>
                  <hr>
                </li>
                <li><a href="#"><i class="icon-life-buoy"></i>Documentation</a></li>
                <li><a href="#"><i class="icon-mail"></i>Email Support Team</a></li>
                <li><a href="#"><i class="icon-alert-triangle"></i>Report an issue</a></li>
              </ul>
            </div>
          </div>
          <div id="export_buttons" class="mt-2"></div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <table id="datatable" class="table table-bordered table-hover" style="width:100%">
            <thead>
            <tr>
              <th>Name</th>
              <th>Position</th>
              <th>Office</th>
              <th>Age</th>
              <th>Date</th>
              <th>Salary</th>
              <th>Status</th>
              <th class="noExport">Actions</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>Tiger Nixon</td>
              <td>System Architect</td>
              <td>Edinburgh</td>
              <td>61</td>
              <td>2011/04/25</td>
              <td>$320,800</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Garrett Winters</td>
              <td>Accountant</td>
              <td>Tokyo</td>
              <td>63</td>
              <td>2011/07/25</td>
              <td>$170,750</td>
              <td><span class="badge badge-pill badge-secondary">Inactive</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Ashton Cox</td>
              <td>Junior Technical Author</td>
              <td>San Francisco</td>
              <td>66</td>
              <td>2009/01/12</td>
              <td>$86,000</td>
              <td><span class="badge badge-pill badge-secondary">Inactive</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Cedric Kelly</td>
              <td>Senior Javascript Developer</td>
              <td>Edinburgh</td>
              <td>22</td>
              <td>2012/03/29</td>
              <td>$433,060</td>
              <td><span class="badge badge-pill badge-secondary">Inactive</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Airi Satou</td>
              <td>Accountant</td>
              <td>Tokyo</td>
              <td>33</td>
              <td>2008/11/28</td>
              <td>$162,700</td>
              <td><span class="badge badge-pill badge-secondary">Inactive</span></td>
              <td>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Brielle Williamson</td>
              <td>Integration Specialist</td>
              <td>New York</td>
              <td>61</td>
              <td>2012/12/02</td>
              <td>$372,000</td>
              <td><span class="badge badge-pill badge-secondary">Inactive</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Herrod Chandler</td>
              <td>Sales Assistant</td>
              <td>San Francisco</td>
              <td>59</td>
              <td>2012/08/06</td>
              <td>$137,500</td>
              <td><span class="badge badge-pill badge-secondary">Inactive</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Rhona Davidson</td>
              <td>Integration Specialist</td>
              <td>Tokyo</td>
              <td>55</td>
              <td>2010/10/14</td>
              <td>$327,900</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Colleen Hurst</td>
              <td>Javascript Developer</td>
              <td>San Francisco</td>
              <td>39</td>
              <td>2009/09/15</td>
              <td>$205,500</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Sonya Frost</td>
              <td>Software Engineer</td>
              <td>Edinburgh</td>
              <td>23</td>
              <td>2008/12/13</td>
              <td>$103,600</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Jena Gaines</td>
              <td>Office Manager</td>
              <td>London</td>
              <td>30</td>
              <td>2008/12/19</td>
              <td>$90,560</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Quinn Flynn</td>
              <td>Support Lead</td>
              <td>Edinburgh</td>
              <td>22</td>
              <td>2013/03/03</td>
              <td>$342,000</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Charde Marshall</td>
              <td>Regional Director</td>
              <td>San Francisco</td>
              <td>36</td>
              <td>2008/10/16</td>
              <td>$470,600</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Haley Kennedy</td>
              <td>Senior Marketing Designer</td>
              <td>London</td>
              <td>43</td>
              <td>2012/12/18</td>
              <td>$313,500</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Tatyana Fitzpatrick</td>
              <td>Regional Director</td>
              <td>London</td>
              <td>19</td>
              <td>2010/03/17</td>
              <td>$385,750</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Michael Silva</td>
              <td>Marketing Designer</td>
              <td>London</td>
              <td>66</td>
              <td>2012/11/27</td>
              <td>$198,500</td>
              <td><span class="badge badge-pill badge-danger">Suspended</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Paul Byrd</td>
              <td>Chief Financial Officer (CFO)</td>
              <td>New York</td>
              <td>64</td>
              <td>2010/06/09</td>
              <td>$725,000</td>
              <td><span class="badge badge-pill badge-info">Pending</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Gloria Little</td>
              <td>Systems Administrator</td>
              <td>New York</td>
              <td>59</td>
              <td>2009/04/10</td>
              <td>$237,500</td>
              <td><span class="badge badge-pill badge-info">Pending</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Bradley Greer</td>
              <td>Software Engineer</td>
              <td>London</td>
              <td>41</td>
              <td>2012/10/13</td>
              <td>$132,000</td>
              <td><span class="badge badge-pill badge-info">Pending</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Dai Rios</td>
              <td>Personnel Lead</td>
              <td>Edinburgh</td>
              <td>35</td>
              <td>2012/09/26</td>
              <td>$217,500</td>
              <td><span class="badge badge-pill badge-info">Pending</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Jenette Caldwell</td>
              <td>Development Lead</td>
              <td>New York</td>
              <td>30</td>
              <td>2011/09/03</td>
              <td>$345,000</td>
              <td><span class="badge badge-pill badge-info">Pending</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Yuri Berry</td>
              <td>Chief Marketing Officer (CMO)</td>
              <td>New York</td>
              <td>40</td>
              <td>2009/06/25</td>
              <td>$675,000</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Caesar Vance</td>
              <td>Pre-Sales Support</td>
              <td>New York</td>
              <td>21</td>
              <td>2011/12/12</td>
              <td>$106,450</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Doris Wilder</td>
              <td>Sales Assistant</td>
              <td>Sidney</td>
              <td>23</td>
              <td>2010/09/20</td>
              <td>$85,600</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Angelica Ramos</td>
              <td>Chief Executive Officer (CEO)</td>
              <td>London</td>
              <td>47</td>
              <td>2009/10/09</td>
              <td>$1,200,000</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Gavin Joyce</td>
              <td>Developer</td>
              <td>Edinburgh</td>
              <td>42</td>
              <td>2010/12/22</td>
              <td>$92,575</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Jennifer Chang</td>
              <td>Regional Director</td>
              <td>Singapore</td>
              <td>28</td>
              <td>2010/11/14</td>
              <td>$357,650</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Brenden Wagner</td>
              <td>Software Engineer</td>
              <td>San Francisco</td>
              <td>28</td>
              <td>2011/06/07</td>
              <td>$206,850</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Fiona Green</td>
              <td>Chief Operating Officer (COO)</td>
              <td>San Francisco</td>
              <td>48</td>
              <td>2010/03/11</td>
              <td>$850,000</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Shou Itou</td>
              <td>Regional Marketing</td>
              <td>Tokyo</td>
              <td>20</td>
              <td>2011/08/14</td>
              <td>$163,000</td>
              <td><span class="badge badge-pill badge-warning">In progress</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Michelle House</td>
              <td>Integration Specialist</td>
              <td>Sidney</td>
              <td>37</td>
              <td>2011/06/02</td>
              <td>$95,400</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Suki Burks</td>
              <td>Developer</td>
              <td>London</td>
              <td>53</td>
              <td>2009/10/22</td>
              <td>$114,500</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Prescott Bartlett</td>
              <td>Technical Author</td>
              <td>London</td>
              <td>27</td>
              <td>2011/05/07</td>
              <td>$145,000</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Gavin Cortez</td>
              <td>Team Leader</td>
              <td>San Francisco</td>
              <td>22</td>
              <td>2008/10/26</td>
              <td>$235,500</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Martena Mccray</td>
              <td>Post-Sales support</td>
              <td>Edinburgh</td>
              <td>46</td>
              <td>2011/03/09</td>
              <td>$324,050</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Unity Butler</td>
              <td>Marketing Designer</td>
              <td>San Francisco</td>
              <td>47</td>
              <td>2009/12/09</td>
              <td>$85,675</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Howard Hatfield</td>
              <td>Office Manager</td>
              <td>San Francisco</td>
              <td>51</td>
              <td>2008/12/16</td>
              <td>$164,500</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Hope Fuentes</td>
              <td>Secretary</td>
              <td>San Francisco</td>
              <td>41</td>
              <td>2010/02/12</td>
              <td>$109,850</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Vivian Harrell</td>
              <td>Financial Controller</td>
              <td>San Francisco</td>
              <td>62</td>
              <td>2009/02/14</td>
              <td>$452,500</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Timothy Mooney</td>
              <td>Office Manager</td>
              <td>London</td>
              <td>37</td>
              <td>2008/12/11</td>
              <td>$136,200</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Jackson Bradshaw</td>
              <td>Director</td>
              <td>New York</td>
              <td>65</td>
              <td>2008/09/26</td>
              <td>$645,750</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Olivia Liang</td>
              <td>Support Engineer</td>
              <td>Singapore</td>
              <td>64</td>
              <td>2011/02/03</td>
              <td>$234,500</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Bruno Nash</td>
              <td>Software Engineer</td>
              <td>London</td>
              <td>38</td>
              <td>2011/05/03</td>
              <td>$163,500</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Sakura Yamamoto</td>
              <td>Support Engineer</td>
              <td>Tokyo</td>
              <td>37</td>
              <td>2009/08/19</td>
              <td>$139,575</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Thor Walton</td>
              <td>Developer</td>
              <td>New York</td>
              <td>61</td>
              <td>2013/08/11</td>
              <td>$98,540</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Finn Camacho</td>
              <td>Support Engineer</td>
              <td>San Francisco</td>
              <td>47</td>
              <td>2009/07/07</td>
              <td>$87,500</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Serge Baldwin</td>
              <td>Data Coordinator</td>
              <td>Singapore</td>
              <td>64</td>
              <td>2012/04/09</td>
              <td>$138,575</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Zenaida Frank</td>
              <td>Software Engineer</td>
              <td>New York</td>
              <td>63</td>
              <td>2010/01/04</td>
              <td>$125,250</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Zorita Serrano</td>
              <td>Software Engineer</td>
              <td>San Francisco</td>
              <td>56</td>
              <td>2012/06/01</td>
              <td>$115,000</td>
              <td><span class="badge badge-pill badge-success">Completed</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Jennifer Acosta</td>
              <td>Junior Javascript Developer</td>
              <td>Edinburgh</td>
              <td>43</td>
              <td>2013/02/01</td>
              <td>$75,650</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Cara Stevens</td>
              <td>Sales Assistant</td>
              <td>New York</td>
              <td>46</td>
              <td>2011/12/06</td>
              <td>$145,600</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Hermione Butler</td>
              <td>Regional Director</td>
              <td>London</td>
              <td>47</td>
              <td>2011/03/21</td>
              <td>$356,250</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Lael Greer</td>
              <td>Systems Administrator</td>
              <td>London</td>
              <td>21</td>
              <td>2009/02/27</td>
              <td>$103,500</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Jonas Alexander</td>
              <td>Developer</td>
              <td>San Francisco</td>
              <td>30</td>
              <td>2010/07/14</td>
              <td>$86,500</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Shad Decker</td>
              <td>Regional Director</td>
              <td>Edinburgh</td>
              <td>51</td>
              <td>2008/11/13</td>
              <td>$183,000</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Michael Bruce</td>
              <td>Javascript Developer</td>
              <td>Singapore</td>
              <td>29</td>
              <td>2011/06/27</td>
              <td>$183,000</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            <tr>
              <td>Donna Snider</td>
              <td>Customer Support</td>
              <td>New York</td>
              <td>27</td>
              <td>2011/01/25</td>
              <td>$112,000</td>
              <td><span class="badge badge-pill badge-primary">Active</span></td>
              <td><a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Edit"><i
                      class="icon-edit"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Delete"><i class="icon-trash-2"></i></a>
                <a class="ml-2" href="#" data-toggle="tooltip" data-original-title="Settings"><i
                        class="icon-settings"></i></a>
              </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
              <th>Name</th>
              <th>Position</th>
              <th>Office</th>
              <th>Age</th>
              <th>Date</th>
              <th>Salary</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
            </tfoot>
          </table>
        </div>
      </div>
      <!-- end: DataTable -->
    </div>
  </section>
  <!-- end: Page Content -->
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
  </footer>
  <!-- end: Footer -->
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
<script src='/assets/plugins/datatables.min.js'></script>

<!--Google Maps files-->
<script type='text/javascript'
        src='//maps.googleapis.com/maps/api/js?key=AIzaSyAZIus-_huNW25Jl7RPmHgoGZjD5udgBMI'></script>
<script type="text/javascript" src="plugins/gmap3/gmap3.min.js"></script>
<script type="text/javascript" src="plugins/gmap3/map-styles.js"></script>
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
<script>
    $(document).ready(function () {
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

        fn_search();
    });

    function fn_search() {
        var data = {};

        $.ajax({
            url: '/notice/noticeList',
            data: data,
            cache: false,
            async: false,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            pagingYn: false,
            success: function (jsonView) {
                var resultData = jsonView;
                console.log(resultData);
                //  for (const data of jsonView.payload) {
                // var hstTyp = data.hstTyp;

            }

        });
    }
</script>
</body>

</html>