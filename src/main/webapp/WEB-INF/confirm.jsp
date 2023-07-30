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
<title>TraPWanGz | Confirm Order</title>
</head>
<body>

	<nav class="navbar">
    
    <div class="logo">Welcome, ${user.firstName} | <a href = "/logout">Log out of your account</a>
    </div>
    					
    <ul class="nav-links">

      <div class="menu">

        <li class="services">
          <a href="/createOrder">Create Order</a>

          <ul class="dropdown">
            <li><a href="/wings">Wings</a></li>
            <li><a href="/sides">Sides</a></li>
            <li><a href="/sets">Sets</a></li>
          </ul>

        </li>

        <li><a href="/home">Home</a></li>
        <li><a href="/contact">Contact</a></li>
        <li><a href="/login">Login</a></li>
        <li><a href="/register">Make an Account</a></li>
      </div>
    </ul>
  </nav>


<H2>Order Confirmation</H2>

<table class = "table table-hover">
    <thead>
        <tr>
            <th>Combo</th>
            <th>Flavor</th>
            <th>Side</th>
            <th>Drink</th>
            <th>Notes</th>
        </tr>
    </thead>
    <tbody>
	         <tr>
	         	<td>
					  <!-- COMBO CHOICE FROM HERE -->
	         			<c:choose>
  
							  <c:when test="${order.comboChoice == 1}">
								6-piece combo
							  </c:when>
							  
							  <c:when test="${order.comboChoice == 2}">
								10-piece combo
							  </c:when>
							
							  <c:otherwise>
								15-piece combo
							  </c:otherwise>
							
						</c:choose>
	         		
	         	</td>
	         	
   		        <td>
   		    		<!-- FLAVORS FROM HERE -->
   		    		<c:choose>
   		    		
   		    					<c:when test="${order.flavorChoice == 1}">
								BMF
							  	</c:when>
					
							  	<c:when test="${order.flavorChoice == 2}">
								DSGB
							  	</c:when>
							  
							   	<c:when test="${order.flavorChoice == 3}">
								Exotics
							  	</c:when>
							  	
								<c:when test="${order.flavorChoice == 4}">
								Trap Yak
							  	</c:when>
							  
							   	<c:when test="${order.flavorChoice == 5}">
								Garlic Parm
							  	</c:when>
							
								<c:when test="${order.flavorChoice == 6}">
								Trapping Apple
							  	</c:when>
							  
							  	<c:when test="${order.flavorChoice == 7}">
								Bad & Boujee
							  	</c:when>
							  
							   	<c:when test="${order.flavorChoice == 8}">
								Henndawgs
							  	</c:when>
							  
				  				<c:when test="${order.flavorChoice == 9}">
								Trap Chili
							  	</c:when>
							  
							  	<c:when test="${order.flavorChoice == 10}">
								Cilantro Lime Jalapeno
							  	</c:when>
							  
							  	<c:when test="${order.flavorChoice == 11}">
								Strawberry Heat
							  	</c:when>
							  	
							  	<c:when test="${order.flavorChoice == 12}">
								Trap Habanero
							  	</c:when>
						
								<c:when test="${order.flavorChoice == 13}">
								Lemon Pepper
							  	</c:when>
							
								<c:when test="${order.flavorChoice == 14}">
								Honey Garlic
							  	</c:when>
							  	
							  	<c:when test="${order.flavorChoice == 15}">
								Gold Rush
							  	</c:when>
							  	
							  	<c:when test="${order.flavorChoice == 16}">
								Buffalo
							  	</c:when>
							  	
							  	<c:when test="${order.flavorChoice == 17}">
								Ranch
							  	</c:when>
							  	
							  <c:otherwise>
								24k
							  </c:otherwise>
							  
   		        	</c:choose>
   		        	
   		       </td>
  	         	
  	         	<td>
	         	   		   <!-- SIDES FROM HERE -->
	         	   		   <c:choose>
	         	   		   
							  <c:when test="${order.sideChoice == 1}">
								French Fries
							  </c:when>
							  
							  <c:when test="${order.sideChoice == 2}">
								Macaroni & Cheese
							  </c:when>
							  			
							  <c:otherwise>
								Baked Beans
							  </c:otherwise>
							
						</c:choose>
						
  	         	</td>
  	         	
 	         	<td>
         		   		   <!-- DRINKS FROM HERE -->
         		   		    <c:choose>
  
							  <c:when test="${order.drinkChoice == 1}">
								Sprite
							  </c:when>
							  
							  <c:when test="${order.drinkChoice == 2}">
								Coke
							  </c:when>
							  
							 <c:when test="${order.drinkChoice == 3}">
								Trap Juice
							  </c:when>
							
							  <c:otherwise>
								(none)
							  </c:otherwise>
							
						</c:choose>
         		
         		</td>
         		
         		<td>
					${order.notes}         		
         		</td>
         		
         		
	        </tr>
    </tbody>
</table>
	
	<form:form action = "/orderComplete/${order.id}"  method = "put" modelAttribute = "order" >
			<input type = "hidden"  name = "_method"  value = "put"/>
					
			<form:input path = "comboChoice" type = "hidden"  name ="comboChoice"  value = "${order.comboChoice }"/>
			
			<form:input path = "flavorChoice" type = "hidden"  name ="flavorChoice"  value = "${order.flavorChoice}"/>
			
			<form:input path = "sideChoice" type = "hidden"  name ="sideChoice"  value = "${order.sideChoice}"/>
			
			<form:input path = "drinkChoice" type = "hidden" name = "drinkChoice"  value = "${order.drinkChoice }"/>
			
			<form:input path = "notes" type = "hidden" name = "notes"  value = "${order.notes}"/>
			
			<form:input path = "orderComplete" type = "hidden"  name ="orderComplete"  value = "yes"/>
			
			<form:input path = "user" type= "hidden" value="${user.id}"/>
			
			<button class  = "btn btn-success" type = "submit"  >Complete This Order Now</button>
	
	</form:form>

<div class = "buttons-down">
	<a href = "/order/${order.id}/edit">Edit This Order</a>
	<br>
	<a href = "/delete/${order.id}">Cancel This Order</a>
</div>

</body>
</html>