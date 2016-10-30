var login = angular.module('login', []);

login.controller('loginController', function ($scope, $http) {
//console.log("got here");
function checkDB(email, pswd){
$http.get("/Authent?email="+email+"&password="+pswd)
      .then(function(response) {
          console.log(response);
      });
}
document.getElementById("signIn").addEventListener("click", function(){
    var email = $( "#teamSelect" ).val();
    var pswd = $( "#teamSelect" ).val();
    checkDB(email, pswd);
});
//	var host = window.location.host;
//    	window.open(host+"/WebContent/playerDashboard.html");
//	});

//      var xhr = new XMLHttpRequest();
//          xhr.onreadystatechange = function() {
//              if (xhr.readyState == 4 && xhr.status == 200) {
//              	//leagueScreen();
//              }
//          }
//          xhr.open('GET', '/login', true);
//          xhr.send(null);
});