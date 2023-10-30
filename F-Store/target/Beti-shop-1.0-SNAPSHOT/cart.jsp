<%-- 
    Document   : cart
    Created on : Oct 18, 2023, 2:43:41 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ Hàng</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <style>
            #linkfooter{
                text-decoration: none;
                color: white;
            }

            .card-text > li{
                padding-top: 5px;
            }

            #payment > li{
                list-style-type: none;
            }

            #logoimg{
                border-radius: 10px;
            }
            .category a{
                text-decoration: none;
                color: black;
                font-size: large;
                font-weight: bold;
            }

            body{
                background-color: rgb(191, 191, 191);
            }

          
            #linkfooter{
                text-decoration: none;
                color: white;
            }

        </style>
    </head><!-- comment -->
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand text-white fw-bold" style="font-size: xx-large;" href="/Beti-shop">F-Store</a>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <!--Search-->
                        <form class="d-flex container " role="search" aria-label="Search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-light" type="submit">Search</button>
                        </form>
                        <ul class="navbar-nav d-sm-flex flex-sm-row justify-content-sm-center row">
                            <!--Cart-->
                            <li class="nav-item col-sm-2">
                                <a href="cart.jsp" class="nav-link
                                   active
                                   text-white">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1.5em" viewBox="0 0 576 512"
                                         style="fill: #ffffff;">
                                    <path
                                        d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z" />
                                    </svg>
                                </a>
                            </li>
                            <!--History-->
                            <li class="nav-item col-sm-2">
                                <a href="#" class="nav-link
                                   active
                                   text-white">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1.5em" viewBox="0 0 512 512"
                                         style="fill: #ffffff;">
                                    <path
                                        d="M75 75L41 41C25.9 25.9 0 36.6 0 57.9V168c0 13.3 10.7 24 24 24H134.1c21.4 0 32.1-25.9 17-41l-30.8-30.8C155 85.5 203 64 256 64c106 0 192 86 192 192s-86 192-192 192c-40.8 0-78.6-12.7-109.7-34.4c-14.5-10.1-34.4-6.6-44.6 7.9s-6.6 34.4 7.9 44.6C151.2 495 201.7 512 256 512c141.4 0 256-114.6 256-256S397.4 0 256 0C185.3 0 121.3 28.7 75 75zm181 53c-13.3 0-24 10.7-24 24V256c0 6.4 2.5 12.5 7 17l72 72c9.4 9.4 24.6 9.4 33.9 0s9.4-24.6 0-33.9l-65-65V152c0-13.3-10.7-24-24-24z" />
                                    </svg>
                                </a>
                            </li>
                            <!--User Information-->
                            <li class="nav-item col-sm-2">
                                <a href="/Beti-shop/User" class="nav-link
                                   active
                                   text-white">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1.5em" viewBox="0 0 448 512"
                                         style="fill: #ffffff;">
                                    <path
                                        d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z" />
                                    </svg>
                                </a>
                            </li>
                            <!--Logout-->
                            <li class="nav-item col-sm-2">
                                <a href="#" class="nav-link
                                   active
                                   text-white">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1.5em" viewBox="0 0 512 512"
                                         style="fill: #ffffff;">
                                    <path
                                        d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z" />
                                    </svg>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <!--Body home page-->
        <div class="bg-body-secondary">
            <div id="carouselExampleDark" class="carousel carousel-dark slide">



                <!--cart-->        
                <!--       <div class="container mt-4">
                        <h1>Your Cart</h1>
                        <div class="row">
                             Cart items go here 
                            <div class="col-12">
                                <div class="card mb-3">
                                    <div class="row g-0">
                                        <div class="col-md-4">
                                            <img src="img/cart/Gearvn_vũ-trụ-mới_-22-scaled.jpg" alt="img" class="img-fluid">
                                              <img id="logoimg" class="rounded-3 m-sm-2" src="img/logo/bank.png" alt="img" width="50px"> 
                                        </div>
                                        <div class="col-md-8">
                                            <div class="card-body">
                                                <h5 class="card-title">Product Name</h5>
                                                <p class="card-text">Product description</p>
                                                <p class="card-text">Price: $10.00</p>
                                                <p class="card-text">Quantity: 2</p>
                                                <p class="card-text">Total: $20.00</p>
                                                <button class="btn btn-danger">Remove</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                               
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 text-end">
                                <h4>Total: $50.00</h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 text-end">
                                <button class="btn btn-primary">Checkout</button>
                            </div>
                        </div>
                    </div>-->


                <div class="container pt-5">

                    <h1>Your Cart</h1>
                    <div class="row">
                        <!-- Cart items go here -->
                        <div class="col-12">
                            <div class="card mb-3">
                                <div class="row g-0">
                                    <div class="col-md-4">

                                        <img src="img/product/product.jpg" alt="img" class="img-fluid">

                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h5 class="card-title">Product Name</h5>
                                            <p class="card-text">Product description</p>
                                            <p class="card-text">Price: $10.00</p>
                                            <!-- Size selection -->
                                            <label for="size">Size:</label>
                                            <select id="size" name="size">
                                                <option value="XL">XL</option>
                                                <option value="X">X</option>
                                                <option value="L">L</option>
                                                <option value="S">S</option>
                                                <option value="M">M</option>
                                            </select>
                                            <br>
                                            <!-- Quantity selection -->


                                            <label for="quantity">Quantity:</label>

                                            <div class="input-group"    style="width: 100px ">
                                                <button class="btn btn-secondary" type="button" id="minus">-</button>
                                                <input type="text" class="form-control text-center" id="quantity" value="1">
                                                <button class="btn btn-secondary" type="button" id="plus">+</button>
                                            </div>
                                            <p class="card-text">Total: $20.00</p>
                                            <button class="btn btn-danger">Thanh Toán</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <!-- Cart items go here -->
                        <div class="col-12">
                            <div class="card mb-3">
                                <div class="row g-0">
                                    <div class="col-md-4">
                                        <img src="img/product/product.jpg" alt="img" class="img-fluid">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h5 class="card-title">Product Name</h5>
                                            <p class="card-text">Product description</p>
                                            <p class="card-text">Price: $10.00</p>
                                            <!-- Size selection -->
                                            <label for="size">Size:</label>
                                            <select id="size" name="size">
                                                <option value="XL">XL</option>
                                                <option value="X">X</option>
                                                <option value="L">L</option>
                                                <option value="S">S</option>
                                                <option value="M">M</option>
                                            </select>
                                            <br>
                                            <!-- Quantity selection -->

                                            <label for="quantity">Quantity:</label>

                                            <div class="input-group"    style="width: 100px ">
                                                <button class="btn btn-secondary" type="button" id="minus">-</button>
                                                <input type="text" class="form-control text-center" id="quantity" value="1">
                                                <button class="btn btn-secondary" type="button" id="plus">+</button>
                                            </div>
                                            <p class="card-text">Total: $20.00</p>
                                            <button class="btn btn-danger">Thanh Toán</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 text-end">
                            <h4>Total: $50.00</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 text-end mb-5">
                            <button class="btn btn-primary">Checkout</button>
                        </div>
                    </div>
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>      
        </div>
        <!--Footer-->
        <footer class="footer bg-dark">
            <div class="container">
                <div class="row">
                    <!--About F-Store-->
                    <div class="col-lg-3 col-sm-4 card bg-dark border-0" style="color: white;">
                        <div class="card-body pt-5 pb-5">
                            <h5 class="card-title">Về F-Store <br>
                                <span>Original and cheap</span>
                            </h5>
                            <p class="card-text"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512"
                                                      style="fill: #ffffff;">
                                <path
                                    d="M215.7 499.2C267 435 384 279.4 384 192C384 86 298 0 192 0S0 86 0 192c0 87.4 117 243 168.3 307.2c12.3 15.3 35.1 15.3 47.4 0zM192 128a64 64 0 1 1 0 128 64 64 0 1 1 0-128z" />
                                </svg>
                                Số 203, Trần Hưng Đạo, phường 10, quận 5, TP.HCM.
                            </p>
                            <p class="card-text">
                                <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"
                                     style="fill: #ffffff;">
                                <path
                                    d="M164.9 24.6c-7.7-18.6-28-28.5-47.4-23.2l-88 24C12.1 30.2 0 46 0 64C0 311.4 200.6 512 448 512c18 0 33.8-12.1 38.6-29.5l24-88c5.3-19.4-4.6-39.7-23.2-47.4l-96-40c-16.3-6.8-35.2-2.1-46.3 11.6L304.7 368C234.3 334.7 177.3 277.7 144 207.3L193.3 167c13.7-11.2 18.4-30 11.6-46.3l-40-96z" />
                                </svg>
                                0708330289
                            </p>
                            <p class="card-text">
                                <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"
                                     style="fill: #ffffff;">
                                <path
                                    d="M48 64C21.5 64 0 85.5 0 112c0 15.1 7.1 29.3 19.2 38.4L236.8 313.6c11.4 8.5 27 8.5 38.4 0L492.8 150.4c12.1-9.1 19.2-23.3 19.2-38.4c0-26.5-21.5-48-48-48H48zM0 176V384c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V176L294.4 339.2c-22.8 17.1-54 17.1-76.8 0L0 176z" />
                                </svg>
                                fstore@gmail.com
                            </p>
                        </div>
                    </div>
                    <!--Liên kết-->
                    <div class="col-lg-2 col-sm-2 bg-dark border-0" style="color: white;">
                        <div class="card-body pt-5 pb-5">
                            <h5 class="card-title">Liên kết
                            </h5>
                            <ul class="card-text">
                                <li>
                                    <a href="#" id="linkfooter">Trang chủ</a>
                                </li>
                                <li>
                                    <a href="#" id="linkfooter">Sản phẩm</a>
                                </li>
                                <li>
                                    <a href="#" id="linkfooter">Phụ kiện</a>
                                </li>
                                <li>
                                    <a href="#" id="linkfooter">Thương hiệu</a>
                                </li>
                                <li>
                                    <a href="#" id="linkfooter">Giới thiệu</a>
                                </li>
                                <li>
                                    <a href="#" id="linkfooter">F-Store OUTLET</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!--Chính sách-->
                    <div class="col-lg-3 col-sm-3 card bg-dark border-0" style="color: white;">
                        <div class="card-body pt-5 pb-5">
                            <h5 class="card-title">Chính sách
                            </h5>
                            <ul class="card-text">
                                <li>
                                    <a href="#" id="linkfooter">Sản phẩm bestseller</a>
                                </li>
                                <li>
                                    <a href="#" id="linkfooter">Sản phẩm khuyến mãi</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!--Phương thức thanh toán-->
                    <div class="col-lg-4 col-sm-3 card bg-dark border-0" style="color: white;">
                        <div class="card-body pt-5 pb-5">
                            <h5 class="card-title">Phương thức thanh toán
                            </h5>
                            <div>
                                <img id="logoimg" class="rounded-3 m-sm-2" src="img/logo/bank.png" alt="img" width="50px">

                                <img id="logoimg" class="rounded-3 m-sm-2" src="img/logo/zalopay.png" alt="img" width="50px">

                                <img id="logoimg" class="rounded-3 m-sm-2" src="img/logo/vnpay.png" alt="img" width="50px">

                                <img id="logoimg" class="rounded-3 m-sm-2" src="img/logo/money.jpg" alt="img" width="50px">

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
        <script src="validate.js"></script>
        <script src="quantity.js"></script>       
    </body>
</html>
