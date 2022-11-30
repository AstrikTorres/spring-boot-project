<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<head>
    <title>Sign Up</title>
</head>
<html>
<h1>Sign Up</h1>
<form id="signup-form">         
    <!-- <c:if test="${param.error != null}">          
        <p>  
            Invalid username and password.  
        </p>  
    </c:if>   -->
    <p>  
        <label for="username">Username</label>  
        <input type="text" name="username"/>      
    </p>  
    <p>  
        <label for="password">Password</label>  
        <input type="password" name="password"/>      
    </p>  
    <p>  
        <label for="confirmPassword">Confirm password</label>  
        <input type="password" name="confirmPassword"/>      
    </p>  
    <input type="hidden"                          
    name="${_csrf.parameterName}"  
    value="${_csrf.token}"/>
    <button type="submit" class="btn">Sign up</button>  
</form>
</html>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/js/signup.js" type="text/javascript"></script>