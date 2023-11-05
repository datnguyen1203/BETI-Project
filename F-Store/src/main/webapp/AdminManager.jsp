<%-- 
    Document   : managerProduct
    Created on : Oct 18, 2023, 11:07:25 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Users</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <style>

        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

        .main-title {
            margin: 0;
            padding: 0;
            border: none;
            outline: none;
            box-sizing: border-box;
        }

        #logo_img img {
            width: 5px;
            height: 5px;
        }

        .table-wrapper {
            background: #fff;
            padding: 20px 25px;
            margin: 30px 0;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            position: fixed;
            padding-bottom: 15px;
            background: #000;
            color: #fff;
            padding: 16px 30px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;

        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .table-title .btn-group {
            float: right;
        }

        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }

        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }

        .custom-checkbox label:before {
            width: 18px;
            height: 18px;
        }

        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }

        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }

        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }

        .modal textarea.form-control {
            resize: vertical;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
        }

        img {
            width: 90px;
            height: 90px;
        }

        /*For menu*/
        body {
            margin: 0;
            padding: 0;
        }

        header {
            position: fixed;
            background: #22242A;
            padding: 20px;
            width: 100%;
            height: 30px;
        }

        .left_area h3 {
            color: #fff;
            margin: 0;
            text-transform: uppercase;
            font-size: 22px;
            font-weight: 900;
        }

        .left_area span {
            color: #19B3D3;
        }

        .logout_btn {
            padding: 5px;
            background: #19B3D3;
            text-decoration: none;
            float: right;
            margin-top: -30px;
            margin-right: 40px;
            border-radius: 2px;
            font-size: 15px;
            font-weight: 600;
            color: #fff;
            transition: 0.5s;
            transition-property: background;
        }

        .logout_btn:hover {
            background: #0B87A6;
        }

        .sidebar {
            background: #2f323a;
            padding-top: 30px;
            position: fixed;
            left: 0;
            width: 240px;
            height: 100%;
            transition: 0.5s;
            transition-property: left;
        }

        .sidebar .profile_image {
            width: 100px;
            height: 100px;
            border-radius: 100px;
            margin-bottom: 10px;
            margin-right: 40px;
        }

        .sidebar h4 {
            color: #ccc;
            margin-top: 0;
            margin-bottom: 20px;
        }

        .sidebar a {
            display: block;
            width: 100%;
            line-height: 60px;
            text-decoration: none;
            padding-left: 40px;
            box-sizing: border-box;
            transition: 0.5s;
            transition-property: background;
        }

        .sidebar a:hover {
            background: #19B3D3;
        }

        .sidebar i {
            padding-right: 10px;
        }

        label #sidebar_btn {
            z-index: 1;
            color: #fff;
            position: fixed;
            cursor: pointer;
            left: 300px;
            font-size: 20px;
            margin: 5px 0;
            transition: 0.5s;
            transition-property: color;
        }

        label #sidebar_btn:hover {
            color: #19B3D3;
        }

        #check:checked ~ .sidebar {
            left: -190px;
        }

        #check:checked ~ .sidebar a span {
            display: none;
        }

        #check:checked ~ .sidebar a {
            font-size: 20px;
            margin-left: 170px;
            width: 80px;
        }

        .content {
            margin-left: 250px;
            background: url(background.png) no-repeat;
            background-position: center;
            background-size: cover;
            height: 100vh;
            transition: 0.5s;
        }

        #check:checked ~ .content {
            margin-left: 60px;
        }

        #check {
            display: none;
        }

        .list-group {
            list-style: none;
            padding: 0;
        }

        .list-group-item.inactive {
            background-color: #22242A;
            border-color: transparent;
            color: #ccc;
        }

        .list-group-item.active {
            border-color: #fd7e14;
            background-color: #fd7e14;
            color: #ccc;
        }

        .bodymain {
            padding: 0;
            margin: 0;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
<div class="row bodymain">
    <!--Menu bar-->
    <jsp:include page="Sidebar.jsp"/>
    <div>
        <div class="content">
            <div class="table-wrapper">
                <div class="main-content">

                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>User ID</th>
                            <th>User Email</th>
                            <th>User Name</th>
                            <th>User Dob</th>
                            <th>User Phone</th>
                            <th>User Address</th>
                            <th>Action</th>

                        </tr>
                        </thead>
                        <tbody id="data">
                        <c:forEach items="${requestScope.list}" var="c">
                            <tr>
                                <td>${c.getUserID()}</td>
                                <td>${c.getUserEmail()}</td>
                                <td>${c.getUserName()}</td>
                                <td>${c.getUserDOB()}</td>
                                <td>${c.getUserPhone()}</td>
                                <td>${c.getUserAddress()}</td>
                                <td>
                                    <a data-toggle="modal" data-target="#delete${c.getUserID()}" href="#">
                                                <span style="font-size: 18px;" class="status pending">
                                                    <i class="fa-solid fa-trash-can"></i>
                                                </span>
                                    </a>
                                </td>
                            </tr>
                            <div class="modal fade" id="delete${c.getUserID()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Delete User</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Do you want to delete ${c.getUserName()} ?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button type="button" onclick="window.window.location.href = '${pageContext.request.contextPath}/deleteUser?id=${c.getUserID()}'" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="clearfix">
                        <ul class="pagination">
                            <c:if test="${requestScope.pagenum > 1}">
                                <li class="page-item"><a href="${pageContext.request.contextPath}/Admin/listuser?pagenum=${requestScope.pagenum - 1}">Previous</a></li>
                            </c:if>
                            <c:forEach begin="${requestScope.pagenum}" end="${requestScope.totalpage > requestScope.pagenum + 2 ? (requestScope.pagenum + 2) : requestScope.totalpage}" var="item">
                                <li class="page-item"><a href="${pageContext.request.contextPath}/Admin/listuser?pagenum=${item}" class="page-link">${item}</a></li>
                            </c:forEach>
                            <c:if test="${requestScope.pagenum <= requestScope.totalpage}">
                                <li class="page-item"><a href="${pageContext.request.contextPath}/Admin/listuser?pagenum=${requestScope.pagenum + 1}" class="page-link">Next</a></li>
                            </c:if>
                        </ul>
                    </div>
                    <div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Add User</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="${pageContext.request.contextPath}/admin/addUser" method="post">
                                        <div class="form-group">
                                            <label for="recipient-code" class="col-form-label">Email</label>
                                            <input type="text" class="form-control" id="recipient-code" name="email" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label">User Name</label>
                                            <input type="text" class="form-control" id="recipient-name" name="name" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-password" class="col-form-label">User Password</label>
                                            <input type="text" class="form-control" id="recipient-password" name="password" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="recipient-dob" class="col-form-label">Date Of Birth</label>
                                            <input type="text" class="form-control" id="recipient-dob" name="dob" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="subject" class="col-form-label">Phone</label>
                                            <input type="text" class="form-control" id="subject" name="phone" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="address" class="col-form-label">Address</label>
                                            <input type="text" class="form-control" id="address" name="address" required="">
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button type="submit" class="btn btn-primary">Update</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addproduct" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="img" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" class="form-control" type="number" required>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <input name="quantity" class="form-control" type="number" required>
                            </div>

                            <div class="form-group">
                                <label>Marterial</label>
                                <input name="marterial" class="form-control" type="text" required>
                            </div>
                            <div class="form-group">
                                <label>Type</label>
                                <input name="type" class="form-control" type="text" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input
                                    type="submit"
                                    value="Add"
                                    class="btn-primary btn w-100 mx-auto"
                            />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="EditProduct" method="POST">
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="pro_name">Product Name: </label>
                                <input type="text" class="form-control" name="pro_name" id="pro_name"/>
                            </div>
                            <div class="form-group">
                                <label for="pro_pic">Image: </label>
                                <input type="file" name="pro_pic" class="form-control" id="pro_pic"/>
                            </div>
                            <div class="form-group">
                                <label for="pro_quan">Color: </label>
                                <input type="text" name="pro_color" class="form-control" id="pro_color"/>
                            </div>
                            <div class="form-group">
                                <label for="pro_price">Gia San Pham: </label>
                                <input type="number" name="pro_price" class="form-control" id="pro_price"/>
                            </div>
                            <div class="form-group">
                                <label for="pro_quan">So Luong: </label>
                                <input type="number" name="pro_quan" class="form-control" id="pro_quan"/>
                            </div>
                            <div class="form-group">
                                <label for="pro_des">Mo ta san pham: </label>
                                <input type="text" name="pro_des" class="form-control" id="pro_des"/>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listC}" var="o">
                                        <option value="${o.category_id}">${o.category_name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Delete Modal HTML -->

    </div>
</div>
</body>
</html>
