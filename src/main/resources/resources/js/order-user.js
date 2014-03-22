			var user="tim";
			var id =1;

			function getAllorderlist(){
				    $.ajax({
				        url: "http://localhost:8080/getuserorder/" + user  +"/" + id,
				        type: "GET",
				        dataType: "json",
				        success: function(Jdata) {
				        	for( var i in Jdata){
				        		
				        		$(".greeting-content").append(Jdata[i].username+"<br>");
				        		
				        	}				  
				        }, 
				          error: function() {      
				            //alert("ERROR!!!");
				       }        
				      });
			}
			     
			    window.onload = function ()   {    	getAllorderlist()    }
			    //setInterval(function(){ getAllorderlist() },10000);