/**
 * 
 */

document.onload = newsapi();

function newsapi() {
    $.ajax({
        url: "https://newsapi.org/v1/sources?source=the-next-web&sortBy=latest&apiKey=ca73649cfc624eaf975ffa109305e988",
        context: document.getElementById("news"),
        success: function(result){
            ang(result);
        }});
        //console.log("got here");
    }

function ang(result){
    var home = angular.module('home');
    try{
        home.controller('home-controller', function ($scope) {
        console.log($scope);
        $scope = result;
    });
    }catch(exception){
        console.log(exception);
    }
}

 var host = window.location.host;
 var result;
 function getURL(res){
   if (res == "home"){
       return host+"/leagueDashboard.html";
   }
}