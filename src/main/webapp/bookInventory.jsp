<!DOCTYPE html>
<html>
<body>

<h1>The input element</h1>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#insertButton").click(function(){
    var bName=$("#bName").val();
    var price=$("#price").val();

    $.ajax({
    	type:'POST',
    	data:{
    		 bName:bName,
    		 price:price
    		 },
    	url:'bookInsert',
    	success: function(result){
    		
    	}
    })
  });
});
</script>



<form>


	<% if(request.getAttribute("insertRes")!=null){ %>
	<%=request.getAttribute("insertRes") %>
	<% } %>
<br><br>
<br><br>
  <label for="BookName">Book Name:</label>
  
  <input type="text" id="bName" name="bName"><br><br>
  
  <label for="BookPrice">Price:</label>
  
  <input type="text" id="price" name="price"><br><br>
  
  <input type="button"  id="insertButton" value="inseryt">

</form>

</body>
</html>