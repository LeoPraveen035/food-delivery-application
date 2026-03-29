<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List,com.tap.model.*,com.tap.dao.*,com.tap.daoimpl.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

 <style>

        @import url('https://fonts.cdnfonts.com/css/poppins');
        
        *{
            box-sizing: border-box;
            margin:0;
            padding:0;
            font-family: 'Poppins', sans-serif;
            caret-color:transparent;
            
        }
        body{
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
        .body-container {
        		
		    display: flex;
		    justify-content: center;   /* center content horizontally */
		    align-items: flex-start;   /* align items to top */
		    gap: 80px;                 /* space between cart and order summary */
		    padding: 30px;
		    
		    
		}

        
        
          
        
        .header{
        		display:grid;
        		grid-template-columns:600px 1fr;
        		 
        		
        		
        		  
        }
        .title{
        		margin-top:5px;
        }
        .container {
            width: 700px;
           
            text-align:center;
            
            
           
        }
        #addBtn{
        		display: inline-block;
        		margin-top:20px;
        		background:#ff4d4d;
        		color:white;
        		text-decoration:none;
        		
        		padding: 8px 12px;
        		border-radius:25px;
        		width:200px ;
        		cursor:pointer;
        }
        .item{
            display: grid;
            grid-template-columns: 100px 1fr 120px 100px 80px;
            align-items: center;
            gap: 20px;
            margin-bottom: 20px;
            /* border-bottom: 1px solid #ccc; */
            background:white; 
            border-radius:10px; 

           
        }
        img{
            width: 100px;
            height: 100px;
            border-radius: 10px;
        }
        .menu-name{
            text-align: center;
        }

        p{
            margin: 10px 0;
        }
        .quantity{
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin: 10px 0;
        }
       	.minus, .plus{
            padding: 0px 10px;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        .minus{
            width: 30px;
            height: 30px;
            font-size: 20px;
            background-color: #ff4d4d;
        }
        .plus {
            width: 30px;
            height: 30px;
            font-size: 20px;
            background-color: #4CAF50; 
        }
        
        a{       
        		text-align:center;
        		color: red;
        }
        
        .container2{
        		width:280px;
        		
        		 
        		
        }

        .order-summary{ 
            display:flex;
            
            flex-direction: column;
          /*   border: 1px solid #ccc; */
            padding:30px; 
            border-radius:25px;
            text-align:center;
            background:white;
           
        }
        
        #summary-title{
        		font-size:1.5rem; 
        		font-size:bold;
        } 

        .order-detail{
            padding:20px;
            border-bottom: 1px solid #ccc;
            border-top: 1px solid #ccc;
            text-align:left; 
              
        }
        .order-detail{
        		display:grid;
        		grid-template-columns: 100px 1fr;
        }

        .order-btn{
            background: #ff4d4d;
            margin:20px 0px 0px 0px;
            text-align: center;
            	color:white;
        		padding:8px 10px;
        		border:none;
        		cursor:pointer;
        		border-radius:25px;
        		font-size:1rem;
        		text-decoration:none;

        }
        
        .order-btn:hover{
        		background: ;
        }
        
        .value{
        		font-weight:bold;
        }
       
       

        /* Payment Section */
        
        .payment-section {
		  
		 
		  width: 500px;
		 
		  background:white;  
		  transition: right 0.5s ease-in-out;
		 
		}
		.payment-section h2{
			margin:15px 0px 20px 20px;
			
		}
	
		.payment-section input{
			margin:20px 0px 10px 25px;
		}
		.payment-section.active {
		  right: 50px;
		}
		.payment-section input[type="submit"]{
			width:90%;
			padding:15px 20px;
			
		}
        .back-btn{
        		border-radius:50px;
        		padding:0px 5px;
        		background:rgb(202, 201, 201); 
        		display:inline-block;
        		max-width:40px;
        		height:40px;
        		margin:5px 0px 0px 5px; 
        		cursor:pointer;
        		text-decoration:none;
        		color:grey;
        }
        .back-btn span{
        		font-size:1.5rem;
        }
        .back-btn:hover{
        		color:black;
        }
    </style>
</head>
<body>
	<%
		int restId = (int) session.getAttribute("restaurantId");
	%>
			<nav>
				<h1>FoodApp</h1>
				<div class="nav-links">
					<a href="HomeServlet">Home</a>
					<a href="cart?restaurantId=<%= restId %>&action=null">Cart</a>
					<a href="OrderServlet?orderStatus=false">Order</a>
				</div>
			</nav>
	
	<div class="header">
			<a href="RestaurantServlet?restaurantId=<%= restId %>" class="back-btn"><span >&larr;</span></a>
			<h1 class="title">Your Cart</h1>
	</div>
	
	<%
		Cart cart = (Cart) session.getAttribute("cart");
		
		RestaurantDAO impl = new RestaurantDAOImpl();
		Restaurant restaurant = impl.getRestaurant(restId);
		%>
		 
		<div class="body-container">
	
		<div class="container">	
		
		<%
		if(cart != null && !cart.getItems().isEmpty()){
			for(CartItem item: cart.getItems().values()){	
	%>
	
	
	     
	       
	        <div class="item">
	            <img src="<%= item.getImageUrl()%>"> 
	            <p class="menu-name"><%= item.getName() %></p>
	            <p >&#8377;
	            <%= item.getPrice()%></p>
	            <div class="quantity">
	            		<form action="cart">
	            		<input type="hidden" name="quantity" value="<%= item.getQuantity() -1%>">
					<input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
					<input type="hidden" name="restaurantId" value="<%= restId %>">
					<input type="hidden" name="action" value="update">
	                <input type="submit" class="minus" value="-">
	                </form>
	                <p><%=item.getQuantity()%></p>
	                <form action="cart">
	                <input type="hidden" name="quantity" value="<%= item.getQuantity() +1%>">
					<input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
					<input type="hidden" name="restaurantId" value="<%= restId %>">
					<input type="hidden" name="action" value="update">
	                <input type="submit" class="plus" value="+">
	                </form>
	            </div>
	           
				<a href="cart?menuId=<%= item.getMenuId() %>&action=delete&restaurantId=<%= restId %>"><i class="fa-solid fa-trash"></i></a>    
		
	        </div> 
	        
	        
	<%  
			}
		}
		else
		{
	%>
			<p>No Menu Found</p>
	<% 
			}
		
	%>
	<a href="RestaurantServlet?restaurantId=<%= restId %>" id="addBtn">Add more items</a>
	</div>
		
		
			<div class="container2">
				<h2 style="padding-left:20px; margin-top:0px;"><%= restaurant.getName() %></h2>
				<p style="padding:0px 0px 0px 20px;"><%= restaurant.getAddress() %></p>
				<p style="padding:0px 0px 10px 20px;">Delivered in just <span style="color:green;"> <%= restaurant.getDeliveryTime() %></span></p>
				<div class="order-div">

		        <div class="order-summary">
		            <p id="summary-title">Order Summary</p>
		            
		            <div class="order-detail">
		                <p>Total Items </p><p class="value">: <%= session.getAttribute("totalItems") %></p>
		                <p>To Pay </p><p class="value">: &#8377; <%= session.getAttribute("totalPrice") %></p>
		            </div>
		            <a href="CheckOutServlet" class="order-btn" >Place Order</a>
		        </div>

    				</div>
			</div>
	
	</div>
	
	
     

    
   
	



     <script>
        
        
        function saveAddress(event){
    		event.preventDefault();
    		
    		const doorno= document.getElementById ("doorno").value.trim();
    		const area = document.getElementById("area").value.trim();
    		const landmark = document.getElementById("landmark").value.trim();
    		const place = document.getElementById("place").value.trim();
    		
    		
    		document.getElementById("hiddendoorno").value=doorno;
    		document.getElementById("hiddenarea").value=area;   
    		document.getElementById("hiddenlandmark").value=landmark;
    		document.getElementById("hiddenplace").value=place;
    		
    		alert("Address saved. Now choose paymentMethod");
    			
    		}
        
        
        

        
    </script>
	
</body>
</html>