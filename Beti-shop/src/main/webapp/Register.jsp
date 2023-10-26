<%-- Document : Register Created on : Oct 12, 2023, 9:19:08 PM Author : Dell --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập - Đăng ký</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="validate.js"></script>
        <link rel="stylesheet" href="style.css"/>
    </head>

    <body>
        <!--Navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" data-bs-theme="dark">
            <div class="container">
                <a class="navbar-brand fw-bold" href="#">F-Store</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                        aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <button onclick="checkReset()" id="LoginButton" type="button" class="btn btn-group btn-light m-2 rounded-5" href="#"
                                    data-bs-toggle="modal" data-bs-target="#Login">Login</button>
                        </li>
                        <li class="nav-item">
                            <button onclick="checkReset()" id="RegisterButton" type="button"
                                    class="btn btn-group btn-light m-2 rounded-5">Register</button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>



        <div class="container">
            <div class="row justify-content-around">
                <!--Form Login-->
                <form method="post" action="Login" id="loginform" class="col-6 p-3 m-5 bg-body-tertiary rounded-5">
                    <h1 class="text-center">Login</h1>
                    <div class="m-3">
                        <label class="form-label fw-bold">Email:</label>
                        <input id="email" type="text" name="email1" class="form-control" placeholder="Enter email">
                        <p id="emailerror"></p>
                    </div>
                    <div class="m-3">
                        <label class="form-label fw-bold">Password:</label>
                        <input id="password" type="password" name="password1" class="form-control"
                               placeholder="Enter password">
                        <p id="passerror"></p>
                    </div>
                    <div class="m-3">
                        <label class="form-label fw-bold">You are:</label>
                        <div class="row">
                            <div class=" col-lg-4">
                                <select id="role" name="role" class="form-control">
                                    <option value="user">User</option>
                                    <option value="staff">Staff</option>
                                    <option value="admin">Admin</option>
                                </select>
                            </div>

                            <div class="col-lg-8"></div>
                        </div>

                        <p id="emailerror"></p>
                    </div>
                    <div class="text-center m-2">
                        <a class="link-dark" href="#" style="text-decoration: underline">Forgot password</a> <br>
                    </div>
                    <div class="text-center">
                        <button type="submit" onclick=""
                                class="btn btn-dark fw-bold rounded-5" name="btnLogin" value="login">Login</button>
                        <button type="reset" onclick="checkReset()"
                                class="btn btn-secondary fw-bold rounded-5">Reset</button>
                    </div>
                </form>
                <!--Form Register-->
                <form style="display: none;" method="" id="registerform"
                      class="col-6 p-3 m-5 bg-body-tertiary rounded-5">
                    <h1 class="text-center">Register</h1>
                    <div class="m-3">
                        <label class="form-label fw-bold">Email:</label>
                        <input id="email1" type="text" name="email" class="form-control" placeholder="Enter email">
                        <p id="emailerror1"></p>
                    </div>
                    <div class="m-3">
                        <label class="form-label fw-bold">Username:</label>
                        <input id="username" type="text" name="username" class="form-control" placeholder="Enter username">
                        <p id="usernameerror"></p>
                    </div>
                    <div class="m-3">
                        <label class="form-label fw-bold">Password:</label>
                        <input id="password1" type="password" name="password" class="form-control"
                               placeholder="Enter password">
                        <p id="passerror1"></p>
                    </div>
                    <div class="m-3">
                        <label class="form-label fw-bold">Confirm password:</label>
                        <input id="repassword" type="password" name="repassword" class="form-control"
                               placeholder="Enter password again">
                        <p id="repasserror"></p>
                    </div>
                    <div class="m-3">
                        <label class="form-label fw-bold">Day of birth:</label>
                        <input id="birthday" type="date" name="birthday" class="form-control"
                               placeholder="Enter your email">
                        <p id="birtherror"></p>
                    </div>
                    <div class="m-3">
                        <label class="form-label fw-bold">Phone number:</label>
                        <input id="phone" type="text" name="phone" class="form-control" placeholder="Enter phone number">
                        <p id="phoneerror"></p>
                    </div>
                    <div class="m-3">
                        <label class="form-label fw-bold">Address:</label>
                        <textarea id="address" name="address" cols="30" rows="5" class="form-control"
                                  placeholder="Enter address"></textarea>
                        <p id="addresserror"></p>
                    </div>
                    <div class="text-center m-2">
                        <a class="link-dark" id="LoginLink" href="#" onclick="checkReset()" style="text-decoration: underline" >Already have an account -
                            Login</a> <br>
                    </div>
                    <div class="text-center">
                        <button type="submit" onclick="checkValidate()"
                                class="btn btn-dark fw-bold rounded-5">Register</button>
                        <button type="reset" onclick="checkReset()"
                                class="btn btn-secondary fw-bold rounded-5">Reset</button>
                    </div>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
        <script>
                            // JavaScript function to show the Login form
                            function showLoginForm() {
                                document.getElementById("loginform").style.display = "block";
                                document.getElementById("registerform").style.display = "none";
                            }

                            // JavaScript function to show the Registration form
                            function showRegisterForm() {
                                document.getElementById("loginform").style.display = "none";
                                document.getElementById("registerform").style.display = "block";
                            }

                            // JavaScript function to switch to the Login form
                            function switchToLoginForm() {
                                document.getElementById("loginform").style.display = "block";
                                document.getElementById("registerform").style.display = "none";
                            }

                            // Add event listeners to the buttons and link
                            document.querySelector("#LoginButton").addEventListener("click", showLoginForm);
                            document.querySelector("#RegisterButton").addEventListener("click", showRegisterForm);
                            document.querySelector("#LoginLink").addEventListener("click", switchToLoginForm);
        </script>
    </body>
    <!--Footer-->
    <footer class="footer bg-dark">
        <div class="container">
            <div class="row">
                <!--About F-Store-->
                <div class="col-3 col-sm-4 card bg-dark border-0" style="color: white;">
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
                <div class="col-2 col-sm-2 bg-dark border-0" style="color: white;">
                    <div class="card-body pt-5 pb-5">
                        <h5 class="card-title">Liên kết
                        </h5>
                        <ul class="card-text">
                            <li>
                                <a href="#" style="color: white; text-decoration: none;">Trang chủ</a>
                            </li>
                            <li>
                                <a href="#" style="color: white; text-decoration: none;">Sản phẩm</a>
                            </li>
                            <li>
                                <a href="#" style="color: white; text-decoration: none;">Phụ kiện</a>
                            </li>
                            <li>
                                <a href="#" style="color: white; text-decoration: none;">Thương hiệu</a>
                            </li>
                            <li>
                                <a href="#" style="color: white; text-decoration: none;">Giới thiệu</a>
                            </li>
                            <li>
                                <a href="#" style="color: white; text-decoration: none;">F-Store OUTLET</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!--Chính sách-->
                <div class="col-3 col-sm-3 card bg-dark border-0" style="color: white;">
                    <div class="card-body pt-5 pb-5">
                        <h5 class="card-title">Chính sách
                        </h5>
                        <ul class="card-text">
                            <li>
                                <a href="#" style="color: white; text-decoration: none;">Sản phẩm bestseller</a>
                            </li>
                            <li>
                                <a href="#" style="color: white; text-decoration: none;">Sản phẩm khuyến mãi</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!--Phương thức thanh toán-->
                <div class="col-4 col-sm-3 card bg-dark border-0" style="color: white;">
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
</html>