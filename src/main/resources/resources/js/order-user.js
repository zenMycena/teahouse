			function checkFinishDate(){
				    if($(".finishdate").html()==""){
				    	$(".finishdate").append("處理中請稍候！");
				    }
				    	
			}
			function checkorder(){
				
				$.ajax({
			        url: "http://localhost:8080/getuserorder/"+$(".account").html()+"/"+$(".uid").html(),
			        type: "GET",
			        dataType: "json",
			        success: function(Jdata) {
			        	if(Jdata.status != "未確認"){
			        		
			        		$(".status").html(Jdata.status);
			        		$(".finishdate").html(new Date(Jdata.finishDate));
			        		clearInterval(intervalID);
			        	}
			        }, 
			          error: function() {
			       }        
			      });
			    	
		}
			     
			    window.onload = function ()   {    	checkFinishDate()    }
			    var intervalID=setInterval(function(){ checkorder() },1000);
			    