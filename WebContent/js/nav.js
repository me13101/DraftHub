/**
 * 
 */

document.getElementById("createLeague").addEventListener("click", function(){
newsapi();
	//window.location = "http://localhost:8080/commCreateLeague.html";
	});

document.getElementById("joinLeague").addEventListener("click", function(){
	window.location = "http://localhost:8080/playerDashboard.html"; 
	});


function newsapi() {
        $.ajax({
            url: "https://newsapi.org/v1/sources?source=the-next-web&sortBy=latest&apiKey=ca73649cfc624eaf975ffa109305e988",
            context: document.getElementById("news"),
            success: function(result){
                        newsTable(result);
                    }});
    console.log("got here");
}

function newsTable(result){
    for (int i = 0; i < result.length; i++){
        document.getElementById("newsTable").insertRow(i).innerHtml = result[i].sources[i].name;
    }
}
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
