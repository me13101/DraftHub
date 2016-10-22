/**
 * 
 */

document.getElementById("createLeague").addEventListener("click", function(){
newsapi();
	window.location = "http://localhost:8080/commCreateLeague.html";
	});

document.getElementById("joinLeague").addEventListener("click", function(){
	window.location = "http://localhost:8080/playerDashboard.html"; 
	});

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
