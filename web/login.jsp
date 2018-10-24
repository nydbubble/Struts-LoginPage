<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  model.User: nydia
  Date: 24/10/18
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .errors {
            color: red;
            width: 400px;
            border: 1px solid #FFCCCC;
        }
        .errors li {
            list-style: none;
        }
    </style>
    <title>Log in</title>
</head>
<body>
<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>
<s:form action="login">
    <s:textfield name="user.username" label="Username" />
    <s:password name="user.password" label="Password" />
    <s:submit value="Login"/>
</s:form>
</body>
</html>
