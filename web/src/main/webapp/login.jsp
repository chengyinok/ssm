<%--
  Created by IntelliJ IDEA.
  User: chengyin
  Date: 2017/8/20
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <style>
        .login-box{
            border: 1px solid #004444;
            margin: 50px auto;
            width: 400px;
        }
    </style>
</head>
<body>
<div class="login-box">
    <%--<div class="col-md-6">--%>
        <!-- Horizontal Form -->
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">Horizontal Form</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
                <div class="box-body">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">用户名</label>

                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">密码</label>

                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> 记住我
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                    <%--<button type="submit" class="btn btn-default">Cancel</button>--%>
                    <button type="submit" class="btn btn-info">登录</button>
                </div>
                <!-- /.box-footer -->
            </form>
        </div>
    <%--</div>--%>
</div>
</body>
</html>
