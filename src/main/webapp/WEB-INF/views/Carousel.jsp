<div class="container" id="gallary">
<div id="myCarousel" class="carousel slide" data-ride="carousel"><!--Carousel starts from here-->
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="<c:url value="E:/DevOps/foodiespot/src/main/webapp/WEB-INF/resources/images/01.jpg"></c:url>" alt="family combo">
       <div class="carousel-caption">
        <h3>Family Combo</h3>
        <p>Food tastes better when you eat it with your Family!</p>
      </div>
    </div>

    <div class="item">
      <img src="<c:url value="E:/DevOps/foodiespot/src/main/webapp/WEB-INF/resources/images/02.jpg"></c:url>" alt="BBQ">
       <div class="carousel-caption">
        <h3>BBQ</h3>
        <p>There's no love sincerer than the love of Food.</p>
      </div>
    </div>

  

    <div class="item">
      <img src="<c:url value="E:/DevOps/foodiespot/src/main/webapp/WEB-INF/resources/images/04.jpg"></c:url>" alt="pizza">
       <div class="carousel-caption">
        <h3>Pizzzzzaa!</h3>
        <p>You can't make everyone happy.You're not pizza!</p>
      </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
  </div>
</div>             <!--Carousel ends here-->
