/**
 * 
 */

	var i = 1;
	for (i; i <= 16; i++){
		var x = document.getElementById("teamSelect");
		var option = document.createElement("option");
		option.text = i;
		x.add(option);
	}

var numTeams, leagueName, leagueID, commEmail, commName;

function getNumTeams() {
	var numTeams = $( "#teamSelect" ).val();
	console.log(numTeams)
}
function leagueScreen(){
	window.location = "http://localhost:8080/leagueDashboard.html";
}
function joinLeague(){
	leagueName = $("#leagueName").val();
	leaguePW = $("#leaguePW").val();
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	console.log("launchModal join league")
        	leagueScreen();
        }
    }
    xhr.open('POST', '/App?league_name='+leagueName+'&leaguePW='+leaguePW, true);
    xhr.send(null);
}