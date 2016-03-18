/**
 * 
 */

var numTeams, leagueName, leagueID;

function getNumTeams() {
	var numTeams = $( "#teamSelect" ).val();
	console.log(numTeams)
}

function createLeague(){
	numTeams = $( "#teamSelect" ).val();
	leagueName = $("leagueName").val();
	//league name not working
	leagueID = 1;
	var league = [{"num": numTeams, "name": leagueName, "id": leagueID}];
	console.log(league);
	$.ajax({
	    type: 'get', // it's easier to read GET request parameters
	    url: 'index.js',
	    dataType: 'JSON',
	    data: { 
	      league: JSON.stringify(league) // look here!
	    },
	    success: function(data) {
	    	console.log("got here");
	    },
	    error: function(data) {
	        console.log(data.num);
	    }
	});
}