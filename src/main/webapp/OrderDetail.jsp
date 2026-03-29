<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Detail</title>
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
        .container2{
        		display:grid;
            grid-template-columns: 1fr 500px;
            
            margin: auto;
            
            gap:60px;

            
            width:1200px;

            
            
            
        }
       .title{
        		
        		margin:5px 0px 15px 0px; 
        	}
        .container2-inner1{
          padding: 20px;
          background: white;
          
           
            
        }
        .rest-detail{
        		margin:0px 0px 15px 0px;
        }
        
        .container2-inner2{
          
           
        }

        .container2-inner2{
            display: flex;
            flex-direction: column;
            gap:20px;
            
        }
        .delivery{
            background: white;
            padding: 20px;
        }
        .price{
            background: white;
            padding: 20px;
        }
        .item{
            display: grid;
            grid-template-columns: 130px 1fr  200px;
            margin: 10px 0px;
            background: #f8f9fa;
        }
        .item img{
            width: 100px;
            height: 100px;
        }
        .item a{
            display: block;
        }
        
        .edit-rate{
            display: grid;
            padding:20px;
        }
        .rating h3{
            padding:10px 0px 0px 20px;
        }
        .rating{
            border-top:1px solid #ccc;
            
        }
        .tick{
            font-size: 15px; background: rgb(44, 160, 44); color:white; border-radius: 25px; 
            padding:0px 5px;
            width:13px;
        }
        .order-status{
           
           
        }
        .order-status .stepper{
            margin:30px;
        }


       
        /* item rating */
        .rating-block {
      margin-bottom: 20px;
    }

    .star-rating {
      display: flex;
      direction: rtl;
      font-size: 30px;
      cursor: pointer;
    }

    .star-rating input[type="radio"] {
      display: none;
    }

    .star-rating label {
      color: #ccc;
      transition: color 0.2s;
      padding: 0 2px;
    }

    .star-rating input[type="radio"]:checked ~ label {
      color: gold;
    }

    .star-rating label:hover,
    .star-rating label:hover ~ label {
      color: gold;
    }

    .rating-text {
      margin-top: 5px;
      color: #333;
      font-weight: bold;
    }

        /* rest-rating */

        .rest-star-rating {
            direction: rtl;
            font-size: 30px;
            unicode-bidi: bidi-override;
            display: inline-block;
            
        }
        .rest-star-rating input{
            display: none;
        }

         .rest-star-rating label {
            color: #ccc;
            cursor: pointer;
        
        }
        .rest-star-rating input:checked ~ label,
        .rest-star-rating label:hover,
        .rest-star-rating label:hover ~ label {
            color: red;
        }
        #rest-text {
            margin-top:0px;
            font-size: 16px;
        }
        .rest-rate{
        		display:flex;
        		align-items:center;
        		gap:20px;
        }

    		/* Order Status */

     	.stepper {
        display: flex;
        flex-direction: column;
        align-items: start;
        
        
        }
        
        .step.active .circle {
	    background: green;
	    color: white;
		}
        

        .step {
        display: flex;
        align-items: center;
        gap: 12px;
        }

        .step div,
        .step span {
        color: grey;
        }

        .active div{
        color: white;
        
        background: rgb(131, 234, 131);
        }
        .line.active{
        border-left: 2px solid rgb(95, 167, 95);
        }
        .active span {
        color:rgb(95, 167, 95);
        font-weight: 14px; 
        }

        .circle {
        width: 20px;
        height: 20px;
        background: #ccc;
        border-radius: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
        color: white;
        font-size: 12px;
        }

        .line {
        height: 40px;
        border-left: 2px solid #ccc;
        margin-left: 9px;
        }
        
        
        .address{
            margin-top: 10px;
            padding:15px 10px;
            border-bottom: 2px solid #d0cdcd7b;
            background: #f8f9fa;
        }
        .username{
            padding:15px 10px;
            background: #f8f9fa;
        }
        .price-details{
            background: #f8f9fa;
            margin-top:20px;
        }
        .price-details p{
            padding:20px 20px;
               
        }
        .head{
        		display:grid;
        		grid-template-columns:600px 1fr;
        }
        .back-btn{
        		border-radius:50px;
        		padding:0px 5px;;
        		background:rgb(202, 201, 201); 
        		display:inline-block;
        		max-width:30px;
        		height:40px;
        		margin:5px 0px 0px 5px; 
        		cursor:pointer;
        		text-decoration:none;
        }
        .back-btn span{
        		font-size:1.5rem;
        		margin-left:5px;
        }
        .back-btn:hover{
        		color:black;
        }
		.p-tag {
		    display: grid;
		    grid-template-columns: 200px 20px 150px; /* Fixed widths */
		    align-items: center; /* Vertically align */
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
		
		<div class="head">
		<a href="OrderServlet?orderStatus=false" class="back-btn"><span >&larr;</span></a>
		<h1 class="title">Order Details</h1>
		</div>
<% 	

	Restaurant r = (Restaurant) request.getAttribute("restaurant");
	List<OrderItem> oi = (List<OrderItem>) request.getAttribute("orderItem");
	List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
	Order order = (Order) request.getAttribute("order");
	User u = (User) request.getAttribute("user");
	
	
	
%>
    
     <div class="container2">

        <div class="container2-inner1">
        <div class="rest-detail">
            <h2><%=r.getName() %></h2>
            
            <p><%= r.getCuisineType() %></p>
           
          </div>
            <div>
            <h3>Ordered Items</h3>

			<% for(Menu m :  menuList){ %>
                <div class="item">
                    <img src="<%= m.getImageUrl() %>">
                    <div>
                        <p><%= m.getItemName() %></p>
                        <% for(OrderItem oitem : oi){
                        		if(m.getMenuId() == oitem.getMenuId()){%>
                        <p>Items : <%= oitem.getQuantity() %></p>
                        <%} } %>
                        <p>Price : &#8377; <%= m.getPrice() %></p>
                    </div>
                    <div>
                        <form>
						  <div class="rating-block">
						    <div class="star-rating">
						      <input type="radio" id="star5" name="rating" value="5">
						      <label for="star5" data-msg="Excellent">★</label>
						
						      <input type="radio" id="star4" name="rating" value="4">
						      <label for="star4" data-msg="Very Good">★</label>
						
						      <input type="radio" id="star3" name="rating" value="3">
						      <label for="star3" data-msg="Good">★</label>
						
						      <input type="radio" id="star2" name="rating" value="2">
						      <label for="star2" data-msg="Fair">★</label>
						
						      <input type="radio" id="star1" name="rating" value="1">
						      <label for="star1" data-msg="Poor">★</label>
						    </div>
						    <div class="rating-text"></div>
						  </div>
						</form>
                         
                    </div>
                </div>
                <% } %>
                
               
                
            </div>
            
           
            <div class="order-status">
            <h3>Order Status</h3>
            <div class="stepper">
               
                <div class="step" data-status="confirmed" id="step-confirmed">
                    <div class="circle">✔</div>
                    <span>Confirmed</span>
                </div>
                <div class="line"  id="line-0"></div>

                <div class="step" data-status="shipped" id="step-shipped">
                    <div class="circle">✔</div>
                    <span>Shipped</span>
                </div>
                <div class="line" id="line-1"></div>

                <div class="step" data-status="delivered" id="step-delivered">
                    <div class="circle">✔</div>
                    <span>Delivered</span>
                </div>
            </div>
        </div>


            <div class="rating">
                <h3>Rate the restaurant</h3>
                <div class="edit-rate">
                   
                    <div class=rest-rate>
                        <form>
                            <div class="rest-star-rating">
                            <input type="radio" id="rest-star5" name="rest-rating" value="5">
                            <label for="rest-star5" data-msg="Excellent">★</label>

                            <input type="radio" id="rest-star4" name="rest-rating" value="4">
                            <label for="rest-star4" data-msg="Very Good">★</label>

                            <input type="radio" id="rest-star3" name="rest-rating" value="3">
                            <label for="rest-star3" data-msg="Good">★</label>

                            <input type="radio" id="rest-star2" name="rest-rating" value="2">
                            <label for="rest-star2" data-msg="Fair">★</label>

                            <input type="radio" id="rest-star1" name="rest-rating" value="1">
                            <label for="rest-star1" data-msg="Poor">★</label>

                            </div>
                          	  
                        </form>
                        <div id="rest-text"></div>
                   
                    </div>
                </div>
            </div>
            
        </div>
        <div class="container2-inner2">
            <div class="delivery">
                <h3>Delivery details</h3>
                <div class="address">
                    <span id="home-icon"><i class="fa-solid fa-house" style="font-size: 15px; color: #b4b2b2; "></i></span><span style="font-weight: bold; margin-left:10px;">place</span><span style="margin-left:10px;"><%= u.getAddress()  %></span>
                </div>
                <div class="username">
                    <span class="user-icon"><i class="fa-solid fa-user" style="font-size: 15px; color: #b4b2b2;"></i></span>
                    <span style="margin-left:10px; font-weight:bold;"><%=u.getUserName() %></span>
                    <span>+91 <%= u.getPhoneNumber() %></span>
                </div>
            </div>
            <div class="price">
                <h3>Price Details</h3>
               <div class="price-details">
                 
                <p class="p-tag"><span>Total Price</span> <span>:</span>  <span>&#8377;<%= order.getTotalAmt() %></span></p>
                <p class="p-tag"><span>Delivery Fee </span><span>:</span>  <span>&#8377;<%= 0  %></span></p>
                
                <p class="p-tag" style="font-weight: bold;border:2px solid #d0cdcd7b;"><span>Paid Amount</span><span>:</span><span> &#8377;<%= (order.getTotalAmt() * 1) %></span></p>
               </div>
            </div>
        </div>
    </div>

<script>

//item rating

document.querySelectorAll('.star-rating label').forEach(label => {
label.addEventListener('mouseover', function () {
  const msg = this.getAttribute('data-msg');
  const ratingBlock = this.closest('.rating-block');
  const textDiv = ratingBlock.querySelector('.rating-text');
  textDiv.innerText = msg;
});

label.addEventListener('mouseout', function () {
  const ratingBlock = this.closest('.rating-block');
  const textDiv = ratingBlock.querySelector('.rating-text');
  textDiv.innerText = '';
});

label.addEventListener('click', function () {
  const msg = this.getAttribute('data-msg');
  const ratingBlock = this.closest('.rating-block');
  const textDiv = ratingBlock.querySelector('.rating-text');
  textDiv.innerText = `You rated: ${msg}`;
});
});

// rest-rating

const restLabels = document.querySelectorAll('.rest-star-rating label');
const restText = document.getElementById('rest-text');
const restRadios = document.querySelectorAll('input[name="rest-rating"]');
let restSelectedMsg = "";

restLabels.forEach(label => {
label.addEventListener('mouseover', () => {
    restText.innerText = label.getAttribute('data-msg');
});

label.addEventListener('mouseout', () => {
    restText.innerText = restSelectedMsg;
});

label.addEventListener('click', () => {
    restSelectedMsg = label.getAttribute('data-msg');
    restText.innerText = restSelectedMsg;
});
});

// order status



// status = "shipped" for example
const status = "${orderStatus}"; // Or hardcode to test
let activate = true;

// Select all step elements in order
const stepEls = document.querySelectorAll(".step");
const lineEls = document.querySelectorAll(".line");

stepEls.forEach((stepEl, index) => {
    if (activate) {
        stepEl.classList.add("active");
        if (lineEls[index]) lineEls[index].classList.add("active");
    }

    // If this step's data-status matches current status, stop activating
    if (stepEl.dataset.status === status) {
        activate = false;
    }
});









</script>
</body>
</html>