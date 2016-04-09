/**
 * 
 */

var numTeams, leagueName, leagueID;

function getNumTeams() {
	var numTeams = $( "#teamSelect" ).val();
	console.log(numTeams)
}
function leagueScreen(){
	alert("got here");
}
function createLeague(){
	console.log("got here");
	numTeams = $( "#teamSelect" ).val();
	leagueName = $("#leagueName").val();
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
    	alert("status: "+xhr.status);
    	alert("readyState: "+xhr.readyState);
        if (xhr.readyState == 4 && xhr.status == 200) {
        	leagueScreen();
        }
    }
    xhr.open('GET', '/App?league_name='+leagueName+'&num_teams='+numTeams, true);
    xhr.send(null);
}
