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
            url: "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=ca73649cfc624eaf975ffa109305e988",
            context: document.getElementById("news"),
            success: function(result){
                        console.log("got here");
                    }});
    console.log("got here");
}

$(document).ready(function(){
    $("button").click(function(){
        $.ajax({url: "demo_test.txt", success: function(result){
            $("#div1").html(result);
        }});
    });
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
