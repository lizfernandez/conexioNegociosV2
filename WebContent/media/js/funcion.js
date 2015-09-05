$(document).ready(function(){
	
	$("#ingreso").click(function() {
		 
		  var stylo=$("#dlg_login").css("display");
		    if(stylo=="none"){
		    	 $("#dlg_login ").show();
		    	 $("#ingreso").addClass("activeBlanco activeGrisOscuro");
		    	 $("#registro").removeClass("activeBlanco activeGrisOscuro");
		    	 $("#dlg_register").hide();
		    }
		    else{
		    	 $("#dlg_login").hide();
		    	 $("#ingreso").removeClass("activeBlanco activeGrisOscuro");
		    }
	});
	$("#registro").click(function() {
		 
		  var stylo=$("#dlg_register").css("display");
		    if(stylo=="none"){
		    	
		    	
		    	/* $("#dlg_register").dialog({
						resizable : false,
						width : 530,
						modal : true,
						autoOpen : false
					});*/
		    	
		    	 $("#registro").addClass("activeBlanco activeGrisOscuro");
		    	 $("#ingreso").removeClass("activeBlanco activeGrisOscuro");
		    	 $("#dlg_register").show();
		    	 $("#dlg_login").hide();
		    	/* $("#dlg").show();*/
		    //	$('#dlg_register').dialog('open');
                //return false;
		    }
		    else{
		    	 $("#dlg_register").hide();
		    	 $("#registro").removeClass("activeBlanco activeGrisOscuro");
		    }
	});
	$("#trigger").click(function() {
		
		
		
		 var stylo=$("#topnav.nav").css("display");
		    if(stylo=="none"){
		    	$("#"+this.id+" i").removeClass('fa fa-chevron-down').addClass("fa fa-chevron-up");		     
		        $("#topnav.nav").slideDown("fast");	
		        $("#header #stuck_container").css( 'top', '44px' );
		        
		      }
		    else{
		    	
		        $("#"+this.id+" i").removeClass('fa fa-chevron-up').addClass("fa fa-chevron-down");	
		        $("#topnav.nav").slideUp("fast");
		        $("#header #stuck_container").css( 'top', '0px' );
		        
		        
		    }

	});
	$("#up_chat").click(function() {
		
		 var height=$("#content-chat").css("height");
		
		    if(height=="37px"){
		    	$("#"+this.id+" i").removeClass('fa fa-chevron-up').addClass("fa fa-chevron-down");	
		        $("#content-chat").css( 'height', '470px' );
		        
		      }
		    else{
		    	
		        $("#"+this.id+" i").removeClass('fa fa-chevron-down').addClass("fa fa-chevron-up");			      
		        $("#content-chat").css( 'height', '37px' );
		        
		        
		    }

	});
	$(".menuActive").click(function() {
		
		$(document).find('.headCategoria li').each(function(key,val){ 	 
			$(this).removeClass("active");
	   });
		
		$(this).addClass("active");
	});
   $(".menuActiveTema").click(function() {
		
		$(document).find('.headPlantilla li').each(function(key,val){ 	 
			$(this).removeClass("active");
	   });
		
		$(this).addClass("active");
	});
	
	$("#topnav li span").click(function() {
		$(document).find('#topnav li span').each(function(key,val){ 	 
			$(this).removeClass("activeAzulClaro");
	   });		
		$(this).addClass("activeAzulClaro");
		
		if(this.id=='pc'){
			$("#tipoMovil").removeClass('tablet').removeClass('phoneMovil').addClass('desktop');
		}
		if(this.id=='tablet'){
			$("#tipoMovil").removeClass('desktop').removeClass('phoneMovil').addClass('tablet');
		}
		if(this.id=='phoneMovil'){
			$("#tipoMovil").removeClass('tablet').removeClass('desktop').addClass('phoneMovil');
		}
				
		if(this.id=='comment'){
			
			 var stylo=$(".comment").css("display");
			 if(stylo=="none"){
				 $(".comment").show(); 
			 }else{
				 $(".comment").hide();
				 $(this).removeClass("activeAzulClaro");
			 }
		}
		
	});
	
	$("#barsLeft").click(function() {
		var stylo=$("#content-left").css("display");
		$("#content-left-opciones").hide();
		 var windowWidth = $(window).width();
		
	    if(stylo=="none"){
	        $("#content-left").show('300');
	        $(".grid_13").css("width","100%");
	        $(".row_1").css("margin-left","221px");
	        if(windowWidth <=450){
	        	
	        	 $(".row_1").css("margin-left","0px");
	        }
	       
	      
			
	    }
	    else{
	        $("#content-left").hide('300');
	        $(".grid_13").css("width","100%");
	        $(".row_1").css("margin-left","0px");
	        
	    }
	});
	$("#miPerfil").click(function() {
		 var stylo=$("#content-left-opciones").css("display");
		 if(stylo=="none"){
			 $("#content-left-opciones").show();
			 $(".miPerfil").show();
			 $("#miPerfil").addClass("active");
		 }else{
			 $("#content-left-opciones").hide();
			 $("#miPerfil").removeClass("active");
			 $(".miPerfil").hide();
		 }
		
	});
	$(".tabPago").click(function() {
		 $("#panel .tabPanel").slideUp(300,"easeInOutQuint");
		 $(this).parent().find('.tabPanel').slideDown(300,"easeInOutQuint");
		 
		
	});
	$(window).resize(function() {
		 var windowWidth = $(window).width();
	     //alert(windowWidth);
		 });
	/*$( ".editConexion" )
	  .mouseenter(function() {
		  var id = this.id;
		  $(this).find(".edit" ).show("fast");	
		  
		  $(this).find(".edit" ).click(function() { 
			
			 /*$(".dialogEditForm").show("fast");
			 $("#dialogEditFormlogo").dialog({
		              resizable : true,
		              width : 470,
		              modal : true,
		              autoOpen : true
		          });
		          */
	//	var idEdit=	this.id.split(":");
		   /*         $("#statusDialogLogo").load("../../plantillasBase/"+idEdit[1]+".xhtml");
		*/
			// iframeLogo.location.reload();return true;
			// $("#statusDialogLogo").find(".ui-dialog-content.ui-widget-content").html('<iframe border="0" width="100%" height="100%" src="plantillasBase/dialogLogo.xhtml?parametro='+idEdit[1]+'"></iframe>'); 
			
			 // $('#iframe'+idEdit[1]).attr('src','../../plantillasBase/dialogLogo.xhtml?nuevaImagen=1');
			//  confirmDelete(1);
			/*  document.getElementById("iframeLogo").contentWindow.refreshSections();
		  });
	  })
	  .mouseleave(function() {
		  $(".edit" ).hide("fast");
	  });
	
	*/
	$( ".editConexion" )
	  .mouseenter(function() {
		  $(this).find(".edit" ).click(function() {
			  var idEdit=	this.id.split(":");
			  document.getElementById("iframe"+idEdit[1]).contentWindow.refreshSections();
		  });
	  });
	/*$('.boxOver').mouseenter(function(e) {
		$(this).find('.imgOver').animate({ height: '80%', left: '0', top: '0', width: '310'}, 100);
		
		}).mouseleave(function(e) {
		$(this).find('.imgOver').animate({ height: '100%', left: '-20', top: '-20', width: '350'}, 100);
	
		});
	
	$('.viewport').click(function(e){
		$.lightbox("img/p11.jpg");
		});
*/
	
    
    $(".closeChat").click(function(){
    	
    });
    $(".minusChat").click(function(){
    	
    });
	
});
function addCar(){
	
}
function redirect(url){
	//alert(url);
	 window.location.href = url;
}
function addChat(identificador){
	
    var iexit = $("#content-chat-line ."+identificador).length;
	if(iexit==0){		
	  	$('#chatInd').clone().appendTo('#content-chat-line');
		var count = $("#content-chat-line .chatInd").length;
		var right=parseInt(count)*parseInt(255);	
		$('#content-chat-line .chatInd:last-child').attr("id","chatInd_"+identificador).addClass(identificador).css("right",right+"px").show();
		$('#content-chat-line .chatInd_'+identificador+' #form').attr("id","frm_"+identificador);
	}
	else{
		$("#content-chat-line ."+identificador).fadeOut().fadeIn();
	}
	$(".comment").hide();

}
function limpiar(form){
	
     $(document).find('#'+form+' .text').each(function(key,val){ 
		$(this).val(" ");
	   });
	$("#"+form+" .text:first").focus();
}
function handleMessage(facesmessage) {
	
   var res = facesmessage.summary.split(":");

   limpiar("chatInd_"+res[2]+" #frmMsn");
   var c=$('#content-chat-line #chatInd_'+res[2]+' #msnDetalle div div ul li:last-child div div').attr('class');
  // alert("c:"+c+" res[0]:"+res[0])
   if(c=='msnChatEnvia' && res[0]==$('#iUsuarioId').val()){	 
	  
	   	var cadena = '<li class="ui-datalist-item">';
	   	cadena+='<div class="envia_15454" id="msnMu">';
	   	cadena+=facesmessage.detail;
	   	cadena+='</div></li>';   
	   	$('#content-chat-line #chatInd_'+res[2]+' #msnDetalle div div ul li:last-child .msnChatEnvia').find('ul:last').append(cadena);
   }
   if(c=='msnChatRecibe' && res[0]==$('#iUsuarioId').val()){	
	   
	   var cadena ='';
	   cadena+='<li class="ui-datalist-item">';
	   cadena+='<div>'
	    cadena+='<div class="msnChatEnvia">';       
	    cadena+='<div class="msnTn">';
	       cadena+='<div class="msnKL">';
	          cadena+='<div class="msnPCimgR">';
	            if( res[4]!=null){
	            	 cadena+='<img src="'+res[3]+res[4]+'" width="33px" height="28px" ></img>';	
	            }
	            else{
	            	
	            	 cadena+='<div class="fotoUser">';                       
	            	 cadena+='<i class="fa fa-user"></i></div>'; 
	            }
	            cadena+='</div>';
	              cadena+='<div class="msnPD">';
	                cadena+='<div class="msnKR msnKRir"><i class="fa fa-caret-right"></i></div>';
	                  cadena+='<div class="msnJL">';	
	                  cadena+=' <ul class="ui-datalist-data" >';
	                  cadena+='<li class="ui-datalist-item"> ';
		               	  cadena+='<div id="msnMu" >';	
	                             cadena+=facesmessage.detail;
	                         cadena+='</div>';
	                         cadena+='</li> </ul>';
	                         cadena+='</div>  </div>  </div>   </div>     </div> </div> </li>';
	  
	   	
	   	  
	   	$('#content-chat-line #chatInd_'+res[2]+' #msnDetalle .ui-datalist-data:first').append(cadena);
  }
   
   if(c=='msnChatEnvia' && res[1]==$('#iUsuarioId').val()){	  
	   var cadena ='';
	   cadena+='<li class="ui-datalist-item">';
	   cadena+='<div>'
	   cadena+='<div  class="msnChatRecibe">';       
	     cadena+='<div class="msnKL">';
	       cadena+='<div class="msnPCimg">';
	       if( res[4]!=null){
	    	   
	    	   cadena+='<img src="'+res[3]+res[4]+'" width="33px" height="28px" ></img>';
            }
	          else{	          	 
	          	 cadena+='<div class="fotoUser">';                       
	          	 cadena+='<i class="fa fa-user"></i></div>';
	          }        
	         cadena+='</div>';
	           cadena+='<div class="msnPD">';
	             cadena+='<div class="msnKR msnKRil"><i class="fa fa-caret-left"></i></div>';
	               cadena+='<div class="msnJL">';	
	                cadena+=' <ul class="ui-datalist-data" >';
	                  cadena+='<li class="ui-datalist-item"> ';
		            
	                   cadena+='<div id="msnMu">';
	                   cadena+=facesmessage.detail;
                       cadena+='</div>';
                       cadena+='</li> </ul>';				             
	                   cadena+='</div> </div>  </div>  </div> </div> </li>';
	   	
	   	  
	   	$('#content-chat-line #chatInd_'+res[2]+' #msnDetalle .ui-datalist-data:first').append(cadena);
	   	msPlayer();
  }
  if(c=='msnChatRecibe' && res[1]==$('#iUsuarioId').val()){		
	

	   	var cadena = '<li class="ui-datalist-item">';
	   	cadena+='<div  id="msnMu">';
	   	cadena+=facesmessage.detail;
	   	cadena+='</div></li>';   
	   	$('#content-chat-line #chatInd_'+res[2]+' #msnDetalle div div ul li:last-child .msnChatRecibe').find('ul:last').append(cadena);
	   	msPlayer();
 }
   //$('#msnDetalle').height()
  var w=$('#content-chat-line #chatInd_'+res[2]+' #msnDetalle div div ul li').length;
  
   $('#frm #msnDetalle').animate({scrollTop:w*100}, 1000);

 
  
}
function msPlayer(){
	var playing = false;
	 if (playing == false) {
	       document.getElementById('rintonCN').play();
	       playing = true;
	      

	   } else {
	       document.getElementById('rintonCN').pause();
	       playing = false;
	      
	   }
}
