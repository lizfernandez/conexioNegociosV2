$(function() {
	var app_id = '415791701964022';
	var scopes = 'email, user_friends';
	var btn_login = '<a href="#" id="login">Inicio</a>';
	var div_session = "<div id='facebook-session'>" + "<strong></strong>"
			+ "<img>" + "<a href='#' id='logout'>Cerrar sesion</a>" + "</div>";

	window.fbAsyncInit = function() {
		FB.init({
			appId : app_id,
			status : true,
			cookie : true,
			xfbml : true,
			version : 'v2.2'
		});
		
		/*
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response, function() {
				
			});
		});*/
	};

	var statusChangeCallback = function(response, callback) {
		console.log('statusChangeCallback');
		console.log(response);
		if (response.status === 'connected') {
			//testAPI();
			getFacebookData();
			//window.location.href = "/conexioNegocios/home.xhtml";
		} /*else if (response.status === 'not_authorized') {
			document.getElementById('status').innerHTML = 'Please log '
					+ 'into this app.';
		} */else {
			/*document.getElementById('status').innerHTML = 'Please log '
					+ 'into Facebook.';*/
			callback(false);
		}
	};

	var checkLoginState = function(callback) {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response, function(data){
				callback(data);
			});
		});
	};
	
	var getFacebookData = function(){
		FB.api('/me', function(response) {
		    /*  
			console.log('Successful login for: ' + response.name);
		      document.getElementById('status').innerHTML =
		        'Thanks for logging in, ' + response.name + '!';
			
			$('#login').after(div_session);
			$('#login').remove();
			$('#facebook-session strong').text("Bienvenido: "+response.id);
			$('#facebook-session img').attr('src','http://graph.facebook.com/'+response.id+'/picture?type=small');*/
			$('#frmRegister\\:vNombres').attr('value',response.name);
			$('#frmRegister\\:vEmail').attr('value',response.id);
			$('#frmRegister\\:vTelefono').attr('value','0000000');
			$('#frmRegister\\:vPass').attr('value','0000000');
			$('#frmRegister\\:btnRegister').click();
			
			setTimeout(function(){
				window.location.href = "/conexioNegocios/home.xhtml";
				}, 1000);
		 });
	};
	
	var facebookLogin = function(){
		checkLoginState(function(response){
			if(!response){
				FB.login(function(response){
					if(response.status === 'connected')
						getFacebookData();
						//window.location.href = "/conexioNegocios/home.xhtml";
				}, {scope:scopes});
			}
		});
	};
	
	var facebookLogout = function(){
		FB.getLoginStatus(function(response){
			if(response.status==='connected'){
				FB.logout(function(response){
					$('#faceboook-session').before(btn_login);
					$('#faceboook-session').remove();
				});
			}
		});
	};
	
	$(document).on('click', '#login', function(e){
		e.preventDefault();
		facebookLogin();
	});
	
	$(document).on('click', '#logout', function(e){
		e.preventDefault();
		facebookLogout();
	});
});