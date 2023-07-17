<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri= "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/style.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TraPWanGz | Flavors</title>
</head>
<body>

	<nav class="navbar">
    
    <div class="logo"></div>

    <ul class="nav-links">

      <div class="menu">

        <li class="services">
          <a href="/createOrder">Create Order</a>

          <ul class="dropdown">
            <li><a href="/">Wings</a></li>
            <li><a href="/">Sides</a></li>
            <li><a href="/">Sets</a></li>
          </ul>

        </li>

        <li><a href="/home">Home</a></li>
        <li><a href="/contact">Contact</a></li>
        <li><a href="/login">Login</a></li>
        <li><a href="/register">Make an Account</a></li>
      </div>
    </ul>
  </nav>
  
<p>The order.id is ${order.id} and the order.comboChoice is ${order.comboChoice }</p>
  <c:choose>
  
	  <c:when test = "${order.comboChoice == 1}">
		<p><c:out value="You're getting that 6-piece combo."/></p>
	</c:when>
	
	<c:when test = "${order.comboChoice == 2}">
		<p><c:out value="You're getting that 10-piece combo."/></p>
	</c:when>
	
	<c:otherwise>
		<p><c:out value="You're getting that 15-piece combo."/></p>
	</c:otherwise>
	
 </c:choose>
  
  <div id = "menuMain">
	<form:form action = "/chooseFlavor"  method = "post"  modelAttribute = "order">
	<input type = "hidden" name = "_method" value = "put">
	
		<form:label  path = "flavorChoice">Choose your flavor</form:label>
			<form:select  path = "flavorChoice" name="flavorChoice" id="flavorChoice">
				<form:option value="BMF" path = "flavorChoice">BMF</form:option>
				<form:option value="DSG" path = "flavorChoice">DSGB</form:option>
				<form:option value="EXO"  path = "flavorChoice" >Exotics</form:option>
				<form:option value="TRY" path = "flavorChoice">Trap Yak</form:option>
				<form:option value="GAR" path = "flavorChoice">Garlic Parm</form:option>
				<form:option value="TRA"   path = "flavorChoice">Trapping Apple</form:option>
				<form:option value="BAD" path = "flavorChoice">Bad & Boujee</form:option>
				<form:option value="HEN" path = "flavorChoice">Henndawgs</form:option>
				<form:option value="TRC"  path = "flavorChoice" >Trap Chili</form:option>
				<form:option value="CIL" path = "flavorChoice">Cilantro Lime Jalepeno</form:option>
				<form:option value="STR" path = "flavorChoice">Strawberry Heat</form:option>
				<form:option value="TRH"  path = "flavorChoice" >Trap Habanero</form:option>
				<form:option value="LEM" path = "flavorChoice">Lemon Pepper</form:option>
				<form:option value="HON" path = "flavorChoice">Honey Garlic</form:option>
				<form:option value="GOL"  path = "flavorChoice" >Gold Rush</form:option>
				<form:option value="BUF" path = "flavorChoice">Buffalo</form:option>
				<form:option value="RAN" path = "flavorChoice">Ranch</form:option>
				<form:option value="24K"  path = "flavorChoice">24k</form:option>
			</form:select>
			
			<div>
				<form:errors path="user" class="error"/>			
				<form:input type="hidden"  path="user"  value=" ${user.id}"/>
			</div>
			
		<button type = "submit"  value  = "chooseFlavor" >Next Screen</button>
		
	</form:form>
</div>

</body>
</html>