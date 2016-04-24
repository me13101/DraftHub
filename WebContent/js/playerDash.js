

function leagueScreen(){
	window.location = "http://localhost:8080/leagueDashboard.html";
}
var leagueName;

function join(){
	var teamName = $("#teamName").val();
	var OwnerName = $("#ownerName").val();
	console.log(leagueName);
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	//leagueScreen();
        }
    }
    xhr.open('GET', '/Join?league_name='+leagueName+'&teamName='+teamName+'&OwnerName='+OwnerName, true);
    xhr.send(null);
}

function joinLeague(){
	leagueName = $("#leagueName").val();
	var leaguePW = $("#leaguePW").val();
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	jQuery.noConflict();
        	$('#myModal').modal('show');
        	//leagueScreen();
        }
    }
    xhr.open('POST', '/App?league_name='+leagueName+'&leaguePW='+leaguePW, true);
    xhr.send(null);
}