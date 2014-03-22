				var tid=0;
				var oid=0;
			    function check(){
			    	 $.ajax({
					        url: "http://localhost:8080/gettopid",
					        type: "GET",
					        dataType: "json",
					        success: function(Jdata) {
			  
					        	tid=Jdata.id;
					        }, 
					          error: function() {      
					       }        
					      });
			    	if(tid != oid){
			    		getNeworderlist();
			    	}
				}       
			    function getAllorderlist(){
				    $.ajax({
				        url: "http://localhost:8080/getallorderlist",
				        type: "GET",
				        dataType: "json",
				        success: function(Jdata) {
				        	for( var i in Jdata){
				        		$(".order").append("<tr class='"+Jdata[i].uid+"'><td class='uuid'>"+Jdata[i].id+","+Jdata[i].uid+"</td><td>"+Jdata[i].username+"</td><td>"+Jdata[i].totalPrice+"</td><td class='oriptime' style='display:none'>"+Jdata[i].prepareTime*60000+"</td><td class='oritime' style='display:none'>"+Jdata[i].orderDate+"</td><td class='time'>"+new Date(Jdata[i].orderDate+Jdata[i].prepareTime*60000)+"</td><td class='status'>"+Jdata[i].status+"</td><td class='check'></td><td class='orderDate' style='display:none'>"+Jdata[i].orderDate+"</td><td class='prepareTime' style='display:none'>"+Jdata[i].prepareTime+"</td></tr>");
				        		if(Jdata[i].status == "準備中"){
				        			$("."+Jdata[i].uid+" .check").html("<input type='button' onclick=\"finalcheck('"+Jdata[i].uid+"','"+Jdata[i].id+"')\" value='check'></input>");
				        		}
				        	}
				        	$( document ).ready(function() {		    
							    $( ".order .uuid ").click(function() {
							    	str=$( this ).html();
							    	result=str.split(',');
							    	localuuid=result[1];
							    	localid=result[0];
							    	getOrderlistDetail(localuuid,localid);
								});
							});
				        	tid=Jdata[Jdata.length-1].id;
				        	oid=tid;
				        }, 
				          error: function() {      
				       }        
				      });
			}
			     function getNeworderlist(){
				    $.ajax({
				        url: "http://localhost:8080/getneworderlist/"+ oid,
				        type: "GET",
				        dataType: "json",
				        success: function(Jdata) {
							for( var i in Jdata){
								$(".order").append("<tr class='"+Jdata[i].uid+"'><td class='uuid'>"+Jdata[i].id+","+Jdata[i].uid+"</td><td>"+Jdata[i].username+"</td><td>"+Jdata[i].totalPrice+"</td><td class='oriptime' style='display:none'>"+Jdata[i].prepareTime*60000+"</td><td class='oritime' style='display:none'>"+Jdata[i].orderDate+"</td><td class='time'>"+new Date(Jdata[i].orderDate+Jdata[i].prepareTime*60000)+"</td><td class='status'>"+Jdata[i].status+"</td><td class='check'></td><td class='orderDate' style='display:none'>"+Jdata[i].orderDate+"</td><td class='prepareTime' style='display:none'>"+Jdata[i].prepareTime+"</td></tr>");
				        		if(Jdata[i].status == "準備中"){
				        			$("."+Jdata[i].uid+" .check").html("<input type='button' onclick=\"finalcheck('"+Jdata[i].uid+"','"+Jdata[i].id+"')\" value='check'></input>");
				        		}
								$( document ).ready(function() {		    
								    $( ".order .uuid ").click(function() {
								    	str=$( this ).html();
								    	result=str.split(',');
								    	localuuid=result[1];
								    	localid=result[0];
								    	getOrderlistDetail(localuuid,localid);
									});
								});
							}
							oid=tid;
				        }, 
				          error: function() {      
				       }        
				      });
				    playAudio();
			} 
			   
			     
			     function getOrderlistDetail(uuid,id){
					    $.ajax({
					        url: "http://localhost:8080/getorders/" + uuid,
					        type: "GET",
					        dataType: "json",
					        success: function(Jdata) {
					        	$(".orderdetail").html("");
					        	for( var i in Jdata){
					        		$(".orderdetail").append("<tr><td>"+Jdata[i].beverageName+"</td><td>"+Jdata[i].ice+"</td><td>"+Jdata[i].sweetness+"</td><td>"+Jdata[i].quantity+"</td></tr>");
					        	}
					        	
					        	ori=0;
					        	pre=0;
					        	ori1=0;
					        	pre1=0;
					        	
					        	$(".order-detail").html("");
					        	if($("."+uuid+" .status").html() != "準備中"){
					        		
					        		$(".order-detail").append("<input type='button' onclick=\"docheck('"+uuid+"','"+id+"')\" value='check' \/>");
						        	$(".order-detail").append("<input type='button' onclick=\"timeAdd('"+Jdata[i].uid+"','"+$("."+uuid+" .orderDate").html()+"','"+$("."+uuid+" .prepareTime").html()+"')\" value='延後五分鐘' \/>");
									$(".order-detail").append("<input type='button' onclick=\"timeSub('"+Jdata[i].uid+"','"+$("."+uuid+" .orderDate").html()+"','"+$("."+uuid+" .prepareTime").html()+"')\" value='提前五分鐘' \/>");	
									
					        	}
					        }, 
					          error: function() {      
					       }        
					      });
				}
			     
			     function getFinishOrder(){
					    $.ajax({
					        url: "http://localhost:8080/finishorders",
					        type: "GET",
					        dataType: "json",
					        success: function(Jdata) {
					        	for( var i in Jdata){
					        	$(".finishorder").append("<tr><td>"+Jdata[i].uid+"</td><td>"+Jdata[i].username+"</td><td>"+Jdata[i].totalPrice+"</td><td>"+new Date(Jdata[i].orderDate)+"</td></tr>");
					        	}
					        }, 
					          error: function() {      
					            //alert("ERROR!!!");
					       }        
					      });
				}
			     
			     function docheck(uuid,id){
			    	 $("."+uuid+" .status").html("準備中");
			         $("."+uuid+" .check").html("<input type='button' onclick=\"finalcheck('"+uuid+"','"+id+"')\" value='check'></input>");
			         $(".order-detail").html("");
			         if(pre == 0){
			        	 var x = parseInt($("."+uuid+" .oritime").html(),10);
			        	 var y = parseInt($("."+uuid+" .oriptime").html(),10); 
			        	 pre=x+y;
			         }
			         $.ajax({
					        url: "http://localhost:8080/myOrder/status/" +id+"/"+pre,
					        type: "POST",
					        dataType: "json",
					        success: function(Jdata) {
					        }, 
					          error: function() {      
					       }        
					      });
			         
				}
			     function finalcheck(uuid,id){
			    	 $("."+uuid+" .status").html("完成");
			    	 
			    	 $.ajax({
					        url: "http://localhost:8080/myOrder/finalstatus/" + id,
					        type: "POST",
					        dataType: "json",
					        success: function(Jdata) {
					        	$("."+uuid).slideUp();
					        	$("."+uuid+" .status").remove();
					        	$("."+uuid+" .check").remove();
					        	$("."+uuid+" .timebutton").remove();
					        	$(".orderdetail").html("");
					        	$(".order-detail").html("");
					        	$(".finishorder").append("<tr>"+$("."+uuid).html()+"</tr>");
					        }, 
					          error: function() {      
					       }        
					      });
			         			         
				}
			     var ori=0;
			     var pre=0;
			     function timeAdd(uuid,time,prepare){
			    	 ts=time;
			    	 ta=prepare*60000
			    	 ori=Number(ts)+Number(ta)+300000;
			    	 if(pre!=0){
			    		 pre=pre+300000
			    		 $("."+uuid+" .time").html(new Date(pre));
			    		 pre1=pre;
			    		 ori1=ori;
			    	 }else{
			    		 $("."+uuid+" .time").html(new Date(ori));
			    		 pre=ori;
			    		 ori1=pre;
			    		 pre1=ori;
			    	 }
			    	 
			    	 
				}
			     var ori1=0;
			     var pre1=0;
			     function timeSub(uuid,time,prepare){
			    	 ts=time;
			    	 ta=prepare*60000
			    	 ori1=Number(ts)+Number(ta)-300000;
			    	 if(pre1!=0){
			    		 pre1=pre1-300000
			    		 $("."+uuid+" .time").html(new Date(pre1));
			    		 pre=pre1;
			    		 ori=ori1;
			    	 }else{
			    		 $("."+uuid+" .time").html(new Date(ori1));
			    		 pre1=ori1;
			    		 ori=pre1;
			    		 pre=pre1;
			    	 }
			    	 
				}
			     function playAudio(){
			    	 $(".audio").append("<audio id=\"video\" autoplay=\"true\"><source src=\"./resources/audio/john_rington.mp3\" type=\"audio/mpeg\" /></audio>");
			     }
			     
			     
			     
			    window.onload = function ()   {    	
			    	getAllorderlist();   
			    	getFinishOrder();
			    }
			    setInterval(function(){ check() },3000);