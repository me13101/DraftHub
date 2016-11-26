
function lottery(){
	var numTeams = $( "#teamSelect" ).val();
	console.log(numTeams)
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(data) {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(data);
		}
	}
	xhr.open('GET', '/Draft?league_name='+leagueName+'&num_teams='+numTeams+'&commName='+commName, true);
	xhr.send(null);
}
var draft = angular.module('draft', []);

draft.controller('draftController', function ($scope, $http) {


});
