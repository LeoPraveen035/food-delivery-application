<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">



<!-- <link rel="stylesheet" href="style.css" type="text/css"> -->

<style>
	@import url('https://fonts.cdnfonts.com/css/poppins');
	*{
		margin:0px;
		padding:0px;
		font-family: 'Poppins', sans-serif;
		box-sizing:border-box;
	}
	body{
		
		caret-color:transparent;
		background: #e9ecee; 
		margin-bottom:50px; 
		
	}
	nav{
    		margin:0px;
    		height:100px;
    		display:grid;
    		grid-template-columns: 1fr 300px 150px;
    		align-items:center;
    		box-shadow:0px 5px 10px rgb(0,0,0,0.25);
    }
    nav h1{
    		margin-left:130px;
    }
    .nav-links{
    		display:flex;
    		justify-content: space-between;
    }
    nav a{
    		
    		padding:20px;
    		text-decoration:none;
    }
    .body-container{
    		margin-top:20px;
		padding:0px 280px;
    }
	
	.title{
		margin-top:20px;
	}
	.menu-title{
		margin-top:50px;
	}
	h3{
		padding:10px 0px 0px 0px;
	}
	
	
	.menu-card img{
		
		width:100%;
		height:250px;
		object-fit: fill;
		border-radius:10px 10px;
	}
	 .menu-card-grid{
		position:relative;
		
		display:grid;
		grid-template-columns: 325px 325px 325px;
		
		
		
		
		
		
		
		
	} 
	
	.menu-card{
	
		background:#e4e7ea;
		max-height:700px;
		width:300px;
		margin-top:20px;
		padding:10px;  
		border-radius:15px;
		transition:transform 0.3s ease, box-shadow 0.2s ease;
	}
	
	.menu-card:hover{
		/* transform:translateY(-5px); */
		box-shadow:0px 5px 10px rgb(0,0,0,0.25);
		
		
		
	}
	
	
	
	
	
	.header{
		position:relative;
		padding:20px 0px 0px 0px;
		
		height:300px;
		
	}
	.header-img{
		position:absolute;
		width:100%;
		height:100%;
		border-radius:15px;
		box-shadow: 0px 4px 8px rgb(0,0,0,0.50);
	}
	
	.header-details{
		position:absolute;
		margin:40px;
		
		
		background-color:white;
		width:500px;
		border-radius:25px;
		padding:20px;
		box-shadow:0px 4px 8px rgb(0,0,0,0.25);
		
		
		
	}
	.rest-head{
		display:flex;
		align-items:center;
		
	}
	.rest-address{
		margin:20px 0px;
	}
	
	.rest-details{
		display:flex;
		gap:15px;
		
	}
	
	.rest-detail{
		background: #c5c7c7;
		border-radius:25px;
		padding:5px; 
		display:flex;
		gap:10px;   
		
		 
	}
	.rest-detail span{
		
	}
	.rest-time {
	display:flex;
	gap:15px;  
	margin-top:15px;  
	}  
	
	
	.title-flex{
		display:flex;
		justify-content:space-between;
	}
	
	.rating{
		background-color:green;
		color:white;
		padding:0px 5px;
		margin-top:13px;
		border-radius:10px;
	}
	.rate-star{
		background-color:green;
		color:white;
		padding:0px 5px;
		
		border-radius:15px;
	}
	.desc{
		font-size:15px;
	}
	
	.menu-card-details{
		height:110px;
	}
	.cbtn{
	
		background:rgb(225, 141, 31);
		width:100%;
		border-radius:25px;
		padding:6px 12px;
		border:none;
		font-size:1rem;
		cursor:pointer;
	}
	.btn{
		display:flex;
		flex-direction:column;
		
		margin-bottom:1px;
		
	}
</style>
</head>
<body>

		
		
		<%
		    List<Menu> menus = (List<Menu>) request.getAttribute("menus");
		    Restaurant r = (Restaurant) request.getAttribute("restaurant");

		%>
			<nav>
				<h1>FoodApp</h1>
				<div class="nav-links">
					<a href="HomeServlet">Home</a>
					<a href="cart?restaurantId=<%= r.getRestaurantId() %>&action=null">Cart</a>
					<a href="OrderServlet?orderStatus=false">Order</a>
				</div>
			</nav>
		
		<div class="body-container">
			<h1 class="title"><%= r.getName() %></h1>
	
		<div class="header">
			<img class="header-img" src="<%= r.getImageUrl() %>">
			
			<div class="header-details">
		
				<div class="rest-details">
				
					<div class="rest-detail">
					<span class="material-icons">restaurant</span>
					<span><%= r.getCuisineType() %></span>
					</div>
					
					
					<div class="rest-detail">
					<span class="rate-star">★</span>
					<span> <%= r.getRating() %> Star </span>
					</div>
				
				</div> 
				
				<div class="rest-time">
					<div class="rest-detail">
						<span>🟢 Open now</span>
					</div>
					<div class="rest-detail">
						<span class="material-icons">schedule</span>
						<span>Delivered in <%=r.getDeliveryTime()%></span>
					</div>
				</div> 
				
				<div class="rest-address">
					
					<p style="display:flex; gap:10px;"><span class="material-icons" style="color:red;">location_on</span>
					<span><%= r.getAddress() %></span></p>
					
					
					<p style="display:flex; gap:10px; margin-top:5px;"><span class="material-icons">phone</span>
					<span>+91 <%= r.getPhoneNumber()  %></span> </p>
				</div>
					
					
					
				
					
				
				
				</div>
			</div>
		  	 
		
		<h2 class="menu-title">Menu Items</h2>
		<hr>
		<div class="menu-card-grid">
		<% if (menus != null) {
		    for (Menu m : menus) {
		%>
		   
		    	<div class="menu-card">
		    		<img alt="menu img" src="<%= m.getImageUrl() %>">
		    		<div class="menu-card-details">
			        <div class="title-flex">
			        <h3><%= m.getItemName() %></h3>
			        <p class="rating"><%= m.getRating() %> ★</p>
			        </div>
			        <p class="desc"><%= m.getDescription() %></p>
			        <p>&#8377; <%= m.getPrice() %></p>
		    		</div>
		    		<div class="btn">
		    		<form action="cart">
		 		
		 		<input type="hidden" name="restaurantId" value="<%= m.getRestId() %>">
		 		<input type="hidden" name="menuId" value="<%= m.getMenuId() %>">
		 		<input type="hidden" name="price" value="<%= m.getPrice() %>">
		 		<input type="hidden" name="quantity" value="1">
		 		
		 		
		 		<input class="cbtn" type="submit" name="action" value="add">
		 		
		 	</form>
		 	</div>
		    	</div>
		   
		
		 
		 
		 	
		 
		<% 
		    }
		} else { %>
		    <p>No menu items found.</p>
		<% } %>
		 </div>
		 		
		</div>	
		 
	
	
		
</body>
</html>