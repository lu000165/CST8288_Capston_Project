<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>


<div class="container">
  <form name="menu" id="menu">
  <h3>MENU</h3>
    <table style="width:100%">
     <tr>
      <th>Name</th>
      <th>Description</th>
      <th>Price</th>
      <th>Quantity</th>
      <th></th>
     </tr>
     <tr>
      <th header="Name">Item 1</th>
      <th header="Description">Item 1 description</th>
      <th header="Price">$10.00</th>
      <th><input type="number" id="quantity" name="quantity" value =0></th>
      <th><input type="submit" name ="submit" value="Add to cart"></th>
     </tr>
     <tr>
      <th>Item 2</th>
      <th>Item 2 description</th>
      <th>$20.00</th>
      <th><input type="number" id="quantity" name="quantity" value =0></th>
      <th><input type="submit" name ="submit" value="Add to cart"></th>
     </tr>
     <tr>
      <th>Item 3</th>
      <th>Item 3 description</th>
      <th>$30.00</th>
      <th><input type="number" id="quantity" name="quantity" value =0></th>
      <th><input type="submit" name ="submit" value="Add to cart"></th>
     </tr>
    </table>
 
   </form>
  

  
  <form name="cart" id="cart">
   <h3>Cart</h3>
   <table style="width:50%">
    <tr>
     <th>Item Name</th>
     <th>Quantity</th>
     <th>Price</th>
    </tr>
  
   </table>
  </form>
  


</div>