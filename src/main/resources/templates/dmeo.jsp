<%--
  Created by IntelliJ IDEA.
  User: constanting
  Date: 2018/5/26
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<script>
    document.getElementById(mTest).onclick(function(){
        window.location.href="<%=basePath%>/mTest>/";
    })
</script>
<body>
    <button id="mTest"></button>
</body>
</html>
