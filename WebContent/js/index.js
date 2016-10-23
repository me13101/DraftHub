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
	window.location = "http://localhost:8080/WebContent/leagueDashboard.html";
}
function createLeague(){
	
	numTeams = $( "#teamSelect" ).val();
	leagueName = $("#leagueName").val();
	commName = $("#commName").val();
	commEmail = $("#commEmail").val();
	alert(commName+", "+commEmail);
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	leagueScreen();
        }
    }
    xhr.open('GET', '/App?league_name='+leagueName+'&num_teams='+numTeams+'&commName='+commName+'&commEmail='+commEmail, true);
    xhr.send(null);
}
