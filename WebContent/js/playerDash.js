

function leagueScreen(){
	window.location = "http://localhost:8080/leagueDashboard.html";
}
function joinLeague(){
	leagueName = $("#leagueName").val();
	leaguePW = $("#leaguePW").val();
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	jQuery.noConflict();
        	$('#myModal').modal('show')
        	//leagueScreen();
        }
    }
    xhr.open('POST', '/App?league_name='+leagueName+'&leaguePW='+leaguePW, true);
    xhr.send(null);
}