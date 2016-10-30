var join = angular.module('join', []);

join.controller('joinController', function ($scope, $http) {
//console.log("got here");
function checkDB(email, password, username, leagueID){
$http.post("/Authent?email="+email+"&password="+password+"&userName="+username+"&leagueID="+leagueID)
      .then(function(response) {
          console.log(response);
      });
}
document.getElementById("join").addEventListener("click", function(){
    var username = $( "#inputUsername" ).val();
    var email = $( "#inputEmail" ).val();
    var password = $( "#inputPassword" ).val();
    var leagueID = $( "#inputLeague" ).val();
    checkDB(email, password, username, leagueID);
});

var array = Java.type.("java.lang.String[]");
var a = new array(5);
a[0] = "Scripting";
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