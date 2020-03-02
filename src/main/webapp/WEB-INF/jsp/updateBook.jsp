<%--
  Created by IntelliJ IDEA.
  User: USERzhw
  Date: 2020/1/22
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
<div class="row clearfix">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                <small>修改书籍</small>
            </h1>
        </div>
    </div>
</div>

<form action="${pageContext.request.contextPath}/book/updateBook" method="post">
    <div class="form-group">
        <label >书籍名称</label>
        <input type="text" name="bookName" class="form-control" value="${Qbooks.bookName}"  required>
    </div>
    <div class="form-group">
        <label >书籍编号</label>
        <input type="text" name="bookID" class="form-control" value="${Qbooks.bookID}" required >
    </div>
    <div class="form-group">
        <label >书籍数量</label>
        <input type="text" name="bookCount" class="form-control" value="${Qbooks.bookCount}" required >
    </div>
    <div class="form-group">
        <label >书籍描述</label>
        <input type="text" name="detail" class="form-control" value="${Qbooks.detail}" required >
    </div>
    <input type="submit" class="form-control" value="修改">

</form>


</div>
</body>
</html>
