<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.tap.model.*,com.tap.dao.*,com.tap.daoimpl.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>order</title>


    <style>
        @import url('https://fonts.cdnfonts.com/css/poppins');
        *{
            margin:0;
            padding:0;
            font-family: 'Poppins', sans-serif;
                                                
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
        #title{
        		margin-top:5px;
        }
        
        .order-container{
            display:grid;
            grid-template-columns: 750px 350px;
            margin-left:200px;
            margin-top: 20px;
            gap:50px;   
        }
        .container2{
            background: white;
            height:fit-content; 
        }
        .address{
            background: white;
            padding:40px;
            position:relative;
        }
        
        .address p{
            margin-top:20px;
            
        }
        
        .alter-address{
            display: none;
            background: white;
            padding:40px;
        }
       
        .exist{
            border: 1px solid #d7d4d4bd;
            margin-top:20px;
            padding:20px;
            width:50%;
            box-shadow: 0px 0px 0px none;
            transition: box-shadow 0.3s ease;
        }
        .add{
            border: 1px solid #d7d4d4bd;
            margin-top:20px;
            padding:20px;
            width:50%;
            display: flex;
            flex-direction: column;
            
            gap: 60px;
            box-shadow: 0px 0px 0px none;
            transition: box-shadow 0.3s ease;
        }
        
        .exist a{
            background:#1ba672;
            border: none;
            color:white;
            width:120px;
            padding: 8px 16px;
            text-align:center;
            margin-top: 15px;
            cursor: pointer;
            text-decoration:none;
            display:block;
           
            
            
        }
        .add button{
            color:#1ba672;
            border: 2px solid#1ba672;
            background: none;
            width:150px;
            padding: 8px 16px;
            cursor: pointer;
            
        }
        .exist:hover{
            box-shadow: 1px 1px 3px rgb(208, 204, 204);
            transition: box-shadow 0.3s ease;
        }

        .add:hover{
            box-shadow: 1px 1px 2px rgb(208, 204, 204);
            transition: box-shadow 0.3s ease;
        }
        .add button:hover{
        		background :#1ba672;
        		color: white;
        }
        .address-detail input[type="radio"]{
        		cursor:pointer;
        }
        
        .address-detail label{
        	cursor:pointer;
        }

        .address-selection{
            display: flex;
            gap:20px;
            
        }
        .payments{
            margin-top:30px;
            padding:40px;
            background: white;
        }
        .payments button{
            margin-top:20px;
            padding:15px 15px;
            width:100%;
            background:#1ba672;
            border: none;
            color: white;
            cursor: pointer;
        }

        button .payments:hover{
             
        }
        .changeButton{
            position:absolute;
            top:40px;
            right:50px;
            border:none;
            background: none;
            cursor: pointer;
            font-size: 1rem;
            color:red;
        }
        .changeButton:hover{
            color:green;
        }
        
        .container2{
        		height:fit-content;     
        }
        
        .container3{
            margin-top:30px;
            padding:40px;
            background: white;
            display:none;
        }

        .payment{
            padding:20px 0px 20px 20px;
            border: 1px solid #ccc;
            margin-top:20px;
            caret-color: transparent;
            cursor: pointer;
            
        }
        .payment label{
            cursor: pointer;
        }

        .container3 button{
             margin-top:20px;
            padding:15px 15px;
             width:100%;
            background:#1ba672;
            border: none;
            color: white;
            cursor: pointer;
        }
        .restaurant{
            padding:30px 0px 10px 30px;
            
               
            
        }
        .items{
        		
            padding: 0px 30px ;
            margin:15px 0px;
            
        }
        .item{
            display:grid;
            grid-template-columns: 150px 1fr 70px;
            align-items: center;
            padding-bottom: 10px;
            
           
            
        }
        .item p{
             text-align: center;
        }
        .item button{
            border:none;
            background: none;
            
        }
        .quantity{
            display:flex;
            border: 1px solid #ccc;
            justify-content: space-around;
            padding: 5px;
            
        }
        .bill-details{
            
        }
        .bill-amount{
            padding:5px 0px;
            border-bottom:2px solid rgb(227, 222, 222);
           
            
        }
        .bill-amount p{
            display: grid;
            grid-template-columns: 1fr 10px 40px;

        }
        .bill-amount p{
            padding:10px 0px;
        }

        .bill-details {
            margin:10px 0px;
        }
        .pay{
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }
        
        /* Address Section */
       
        .title{
        		display:flex;
        		justify-content:space-between;
        		align-items:center; 
        		
        }
        
        
        body {
        
        overflow-x: hidden;
        
        }
		.slide-bar{
			background:white;
		}
        .slide-bar h2{
            margin: 20px;
        }
        .address-detail{
            width:500px;
           
        }
        
        .address-detail input{
           margin:20px 20px 15px 20px;
           padding:20px;

        }

        .address-detail input[type="text"]{
            width:90%;
            box-sizing: border-box;
        }
        .address-detail button{
            display:block;
            width:90%;
            margin:20px;
            padding:15px 15px;
            cursor:pointer;
            background:#1ba672;
            border: none;
            color: white;
           
            
            
        }
        .close-btn{
        		font-size: 20px; 
        		cursor: pointer;
        		background:none;
        		border:none;
        		margin:0px 20px 0px 0px;
        }
        .close-btn:hover{
        		color:red;
        }
        
        .slide-bar{
             position: absolute;
             top:115px;
             right: -500px;
             transition: right 0.5s ease;
        }
        
        
        .slide-bar.active {
            right: 50px; /* slide into view */
        }
        .slide-bar.inactive {
            right: -500px; /* slide into view */
        }
        .back-btn{
        		border-radius:50px;
        		padding:0px 5px;
        		background:rgb(202, 201, 201); 
        		max-width:30px;
        		height:40px; 
        		display:inline-block;
        		
        		margin:5px 0px 0px 5px; 
        		cursor:pointer;
        		text-decoration:none;
        		color:grey;
        }
        .head{
        		display:grid;
        		grid-template-columns:600px 1fr;
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
<script>
	function addAddress1(){
		
	    const address = document.getElementsByClassName("alter-address")[0];
	    address.style.display="block";
	    
	    const add = document.getElementsByClassName("exist")[0];
	    add.style.display="none";
	    const alter = document.getElementsByClassName("address")[0];
	    alter.style.display="none";
	}
</script>
	<% 
	   Cart cart = (Cart) session.getAttribute("cart");
	   int restId = (int) session.getAttribute("restaurantId");
	   
	   RestaurantDAO impl = new RestaurantDAOImpl();
	   Restaurant r=impl.getRestaurant(restId);
	   
	   String place = (String) session.getAttribute("place");
	   String saveAddress = (String) session.getAttribute("saveAddress");
	
		if(place == null){
			%> <script>
			 
			       window.onload = function() {
			           addAddress1();
			       }
			   </script><%
		}
	%>
	<nav>
				<h1>FoodApp</h1>
				<div class="nav-links">
					<a href="HomeServlet">Home</a>
					<a href="cart?restaurantId=<%= restId %>&action=null">Cart</a>
					<a href="OrderServlet?orderStatus=false">Order</a>
				</div>
			</nav>
	<div class="head">
	<a href="cart?restaurantId=<%= restId %>&action=null" class="back-btn"><span >&larr;</span></a>
    <h1 id="title">Check Out</h1>
	</div>
    <div class="order-container">
        
        
        <div class="container1">
            
            
            <div class="address">
            
           
                <h2>Delivery Address</h2>
                <p style="font-size:1.1rem; padding-top:10px; font-weight:large;"><%= place %></p>
                <p style="margin-top:3px;"><%= saveAddress %></p>
                <p style="color:green;">15 MINS</p> 
                <button class="changeButton" onclick="addAddress()">change</button>   
            </div>
            
            
            
             <div class="alter-address">
                <h2>Select delivery address</h2>
                <div class="address-selection">
                    <div class="exist">
                    <h3 style="font-size:1.2rem; font-weight:bold;"><%= place %></h3>
                    <p><%= saveAddress %></p>
                    <p style="margin-top:10px; color:green;">15 MINS</p>
                    <a href="Order.jsp">DELIVER HERE</a>
                </div>
                
                
                <div class="add">
                    <h3>Add new Address</h3>
                    <button onclick="toggleSlide()">ADD NEW</button>
                </div>
                
                </div>
                
             </div>
             

            <div class="payments">
                <h2>Choose Payment Method</h2>
                <button onclick="payMethod()">PROCEED TO PAY</button>
               
            </div>
            <div class="container3">
                    <h2>Select Payment Method</h2>
                    
                    <form action="OrderServlet">
                    <div class="payment">
                        <input type="radio" name="payment" id="payment-card" value="card" required>
                        <label for="payment-card">Credit/Debit Card</label>
                    </div>
                    
                    <div class="payment">
                        <input type="radio" name="payment" id="payment-upi" value="upi" required>
                        <label for="payment-upi">UPI</label>
                    </div>
                    
                    <div class="payment">
                        <input type="radio" name="payment" id="payment-cash" value="cash" required>
                        <label for="payment-cash">Cash on Delivery</label>
                    </div>
                    <input type="hidden" name="orderStatus" value="true">
                    <button type="submit">PROCEED TO PAY</button>
                    </form>
                    
                </div>

            
        </div>

       

  

        <div class="container2">
            <div class="restaurant">
                <h3><%= r.getName() %></h3>
                <p><%= r.getAddress() %></p>
                <p>Delivered in <span style="color:green;"><%= r.getDeliveryTime() %></span></p>
            </div>
            <div class="items">
            
            <% 
	            if(cart != null && !cart.getItems().isEmpty()){
	    			for(CartItem item: cart.getItems().values()){

           
            			%>
            			<div class="item">
                    <h4><%= item.getName() %></h4>
                    <div class="quantity">
                        <button>-</button>
                        <span><%= item.getQuantity() %></span>
                        <button>+</button>
                    </div>
                    <p> &#8377;<%= item.getPrice() %></p>
                		</div>
            			
            			<% 
            		}
	            }
            %>
                

           
                
                
                

                <div class="bill-details">
                    <h3>Bill details</h3>
                
                    <div class="bill-amount">
                        <p><span>Item Total</span><span>:</span><span>&#8377;<%= session.getAttribute("totalPrice") %></span></p>
                  
                        <p><span>Delivery Fee</span><span>:</span><span>0</span></p>
                    </div>
                    <div class="pay">
                        <h3>TO PAY</h3>
                        <h3>&#8377;<%= session.getAttribute("totalPrice") %></h3>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>


	<!-- Address Section -->
	  <div class="address-container" id="address-container">
     
        <div id="myBox" class="slide-bar">
        
            <div class="title">
            		<h2>Add a delivery address</h2>
            		<button class="close-btn" onclick="closeSlide()">&#10005;</button> 
            </div> 
            
            <div class="address-detail">
                <form onsubmit="CheckOutServlet"> 
                
                <input type="text" id="doorno" name="doorno" placeholder="Door no" required>
                <input type="text" id="apartment" name="apartment" placeholder="Apartment Name">
                <input type="text" id="area" name="area" placeholder="Area">
                <input type="text" id="landmark" name="landmark" placeholder="Landmark">

    

            
                <input type="radio" id="place1" name="place" value="Home">
                <label for="place1">Home</label>
                <input type="radio" id="place2" name="place" value="Work">
                <label for="place2">Work</label>
                
                <button type="submit">SAVE ADDRESS</button> 
                </form>
            </div>
            
            
            <!-- Payment Section -->
            
    <script>

        function addAddress(){
        const alter = document.getElementsByClassName("alter-address")[0];
        alter.style.display="block";

        const address = document.getElementsByClassName("address")[0];
        address.style.display="none";
        }
        
        
        
        function toggleSlide() {
            const box = document.getElementById("myBox");
            box.classList.add("active");
            box.classList.remove("inactive");
        }
        
        function closeSlide(){
            const box = document.getElementById("myBox");
            box.classList.add("inactive");
            box.classList.remove("active");
        }
        
        function payMethod(){
            document.getElementsByClassName("payments")[0].style.display="none";
            document.getElementsByClassName("container3")[0].style.display="block";
        }
        

    </script>
</body>
</html>