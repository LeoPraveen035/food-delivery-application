<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Items Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>
        
        @import url('https://fonts.cdnfonts.com/css/poppins');
        *{
            margin:0;
            padding:0;
            font-family: 'Poppins', sans-serif;
            caret-color: transparent;
                                                
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
        .container1{
            display: flex;
            flex-direction: column;
            align-items: center;
            
            
        }
        .container1 h1{
            margin:20px 0px;
        }
        
        a{
            text-decoration: none;
            color:black;
        }
        .inner-container1{
          
            display:grid;
            grid-template-columns: 1fr 150px 270px 130px;
            background: white;
            margin-top: 10px;
            width:800px;
            padding:30px;
            border-radius:10px;
            cursor: default;
         
        }
        .inner-container1.btn{
        	 	text-align:center;
        }
        img{
        		width:300px;
        		height:250px;
        }
        span{
        		color:grey;
        }
        button{
        		border:none;
        		background:none;
        		font-size:1rem;
        		color:green;
        		cursor: pointer;
        }
        
    </style>
</head>
<body>

			<nav>
				<h1>FoodApp</h1>
				<div class="nav-links">
					<a href="HomeServlet">Home</a>
					<a href="Cart.jsp">Cart</a>
					<a href="OrderServlet?orderStatus=false">Order</a>
				</div>
			</nav>

<% 	List<OrderDetail> orders=(List<OrderDetail>) session.getAttribute("orders");
	Cart cart = (Cart) session.getAttribute("cart");
	
	
	
%>
    
    <div class="container1">
        <h1>Your Orders</h1>
        
        <% if(orders != null){ 
        for(OrderDetail o: orders){ 
        	
        	
        %>
		<a href="OrderDetailServlet?restId=<%= o.getRest().getRestaurantId() %>&orderId=<%= o.getOrder().getOrderId() %>">
        <div class="inner-container1">
        			
        			 <div class="restaurant">
		        		<h3><%= o.getRest().getName() %></h3>
                		<p><span><%= o.getRest().getCuisineType()  %></span></p>
		        </div>
      			<div>
      				 <p><span>Items: </span></p>
                		 <p><span>Price: </span><span style="color:red;">&#8377; <%= o.getOrder().getTotalAmt() %></p>
      			</div>
      			
		       
		      
                <div class="deliver-details">
                    <p><span>Ordered date : </span><%= o.getOrder().getOrderDate() %></p>
                    <p><span>Delivered in : </span><span style="color:green;"><%= o.getRest().getDeliveryTime() %></span></p>
                </div>
                <div>
                		
                		<button style="text-align:center"; ">Order Detail <span>&rarr;</span></button>
                </div>
        </div>
        </a>
        <% }
        }else{
        %>
        <div><h2>No orders found...</h2></div>
        
        <%} %>
        

    </div>

   

    <script>
        /* function orderDetails(event){
			event.preventDefault();
             const orderBlocks = document.getElementsByClassName("inner-container1");
                for (let i = 0; i < orderBlocks.length; i++) {
                    orderBlocks[i].style.display = "none";
                }
            document.getElementsByClassName("container2")[0].style.display="grid";
        }
        function orderDetails2(){
        	const orderBlocks = document.getElementsByClassName("inner-container1");
            for (let i = 0; i < orderBlocks.length; i++) {
                orderBlocks[i].style.display = "grid";
            }
        document.getElementsByClassName("container2")[0].style.display="none";
        } */

           

    </script>
</body>
</html>