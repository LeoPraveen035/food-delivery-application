<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Restaurants</title>
    <!-- <link rel="stylesheet" href="style.css"> -->
    <style>
    @import url('https://fonts.cdnfonts.com/css/poppins');
    
    *{
     	--gradient-end: #F0BB99; /* Lighter orange/yellow for button gradient end */
        --gradient-start: #543A14; /* Brown for page background start */
     	margin:0;
     	padding:0;
     	font-family: 'Poppins', sans-serif;
                                                
    }
    body{
    
    	background:#f9f9f9;
    caret-color:transparent;
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
    
    h2{
    text-align:center;
    margin: 40px 0px;
    color: #333; 
    }
    
    .card-grid{
    		margin:0px 130px;
    		display:flex;
    		flex-wrap:wrap;
 
    		
    }
    .card {
    			margin:20px;
            background: #fff;
            
            border-radius: 25px;
            width: 380px;
            max-height: 700px;
            float: left;
            
            transition: box-shadow 0.3s ease;
        }
        
        .card:hover{
		    
			box-shadow:0px 5px 10px rgb(0,0,0,0.25);
			
		}
		
        .rest-img{
        width:94%;
        height:250px;
        border-radius:25px;
        object-fit:fill;
        padding:12px;
        }
        .card-details{
        
        padding:0px 12px 20px 12px;
        border-radius: 10px;
        }
        
        .rest-head{
        		
        		font-size: 20px;
        		
        }
        .side{
        		padding:4px 0px;
        		font-size:14px;
        }
        .card-details a{
        		background-color:rgb(225, 141, 31);
        		color:black;
        		text-decoration:none;
		    display: inline-block;
		    width:100%;
		    margin-top: 12px;
		    
		    padding:8px 0px;
		    text-align:center;
		    
		    border-radius:25px;
		}
		
		
		
		.card-details a:hover{
			background-color: rgb(225, 178, 31);
		}
		.side{
			
			color:grey;
			
		}
		
		.card #rate{
			background-color:green;
			display:inline;
			border-radius:10px;
			padding:0px 5px;
			color:white;
			
		
		}
		.title-flex{
			display:flex;
			justify-content:space-between;
			height:25px;
			
		}
		
		
		
		
        		
        
        
        
        
        
        
        
        
    </style>
</head>
<body>
	
	<nav>
		<h1>FoodApp</h1>
		<div class="nav-links">
			<a href="HomeServlet">Home</a>
			<a href="Cart.jsp" onclick="alertMessage(event)">Cart</a>
			<a href="OrderServlet?orderStatus=false">Order</a>
		</div>
	</nav>
    <h2>Food Delivery Restaurants in Bangalore</h2>
	<div class="card-grid">
    <% 
    		List<com.tap.model.Restaurant> list = (List<com.tap.model.Restaurant>) request.getAttribute("restaurants");
    	%>
    	<%
        if(list != null){
        		for(com.tap.model.Restaurant r  : list){
     %>
    
     
    
     
	     <div class="card">
	     	 	<img src="<%= r.getImageUrl()%>" alt="restaurant img" class="rest-img">
	     		<div class="card-details">
	     			<div class="title-flex">
	     			<p class="rest-head"><%= r.getName() %></p>
	     			<p id="rate"><%= r.getRating() %> ★</p>
	     			</div>
	     		
	     		
	     		<div class="side">
	     		<p><%= r.getAddress() %></p>
	     		<p id="cuisine">🍽️ <%= r.getCuisineType() %></p>
	     		<p><%= r.getDeliveryTime() %> </p>
	     		</div>
	     		<a href="RestaurantServlet?restaurantId=<%= r.getRestaurantId() %>">Go to menu</a>
	     		</div>
	     </div>
     	
     
     	
    
     	
     <%
        		}
        }
        		else{
        			
     %>
     	<p>No Restaurants Found</p>
     <% 
        		}
        
    	 %>
    	 </div>
    	 
    	 <script>
    	 	function alertMessage(e){
			e.preventDefault();
			alert("Cart Empty...  Select Restaurant");
    	 	}
    	 </script>
</body>
</html>
    