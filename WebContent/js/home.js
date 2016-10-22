/**
 * 
 */


var host = window.location.host;
var result;
	function getURL(res){
	    if (res == "home"){
	    return host+"/leagueDashboard.html";
	    }
	}
	document.onload = newsapi();
	function newsapi() {
            $.ajax({
                url: "https://newsapi.org/v1/sources?source=the-next-web&sortBy=latest&apiKey=ca73649cfc624eaf975ffa109305e988",
                context: document.getElementById("news"),
                success: function(result){
                           //newsTable(result);
                        }});
        //console.log("got here");
    }
    var home = angular.module('home', []);

    // Define the `PhoneListController` controller on the `phonecatApp` module
    home.controller('home', function ($scope) {
    $scope = newsapi();
    });

