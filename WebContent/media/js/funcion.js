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
	


	
});