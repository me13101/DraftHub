/**
 * 
 */


//document.getElementById("createLeague").addEventListener("click", function(){
//    newsapi();
//	window.location = "http://localhost:8080/commCreateLeague.html";
//	});
//
//document.getElementById("joinLeague").addEventListener("click", function(){
//	window.location = "http://localhost:8080/playerDashboard.html";
//	});
// Define the `phonecatApp` module
var home = angular.module('home', []);

// Define the `PhoneListController` controller on the `phonecatApp` module
home.controller('home', function PhoneListController($scope) {
  $scope.phones = [
    {
      name: 'Nexus S',
      snippet: 'Fast just got faster with Nexus S.'
    }, {
      name: 'Motorola XOOM™ with Wi-Fi',
      snippet: 'The Next, Next Generation tablet.'
    }, {
      name: 'MOTOROLA XOOM™',
      snippet: 'The Next, Next Generation tablet.'
    }
  ];
});
var host = window.location.host;
var result;
	function getURL(res){
	    if (res == "home"){
	    return host+"/leagueDashboard.html";
	    }
	}
	document.onload = newsapi();
	function newsapi() {
            $.ajax({
                url: "https://newsapi.org/v1/sources?source=the-next-web&sortBy=latest&apiKey=ca73649cfc624eaf975ffa109305e988",
                context: document.getElementById("news"),
                success: function(result){
                            newsTable(result);
                        }});
        //console.log("got here");
    }

    function newsTable(result){
        for (var i = 0; i < result.sources.length; i++){
            document.getElementById("newsTable").insertRow(i).innerHtml = result.sources[i].name;
        }
    }
//test
//var numTeams, leagueName, leagueID;
//
//function getNumTeams() {
//	var numTeams = $( "#teamSelect" ).val();
//	console.log(numTeams)
//}
//function leagueScreen(){
//	window.location = "http://localhost:8080/Dashboard.html";
//}
//function createLeague(){
//	
//	numTeams = $( "#teamSelect" ).val();
//	leagueName = $("#leagueName").val();
//	var xhr = new XMLHttpRequest();
//    xhr.onreadystatechange = function() {
//        if (xhr.readyState == 4 && xhr.status == 200) {
//        	leagueScreen();
//        }
//    }
//    xhr.open('GET', '/App?league_name='+leagueName+'&num_teams='+numTeams, true);
//    xhr.send(null);
//}
