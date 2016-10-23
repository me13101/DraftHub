/**
 * 
 */

// function newsapi() {
//     $.ajax({
//         url: "https://newsapi.org/v1/sources?source=the-next-web&sortBy=latest&apiKey=ca73649cfc624eaf975ffa109305e988",
//         context: document.getElementById("news"),
//         success: function(result){

//         }});
//         //console.log("got here");
//     }

//current home.js angular
var home = angular.module('home', []);

home.controller('homeController', function ($scope, $http) {
    $http.get("https://newsapi.org/v1/articles?source=nfl-news&sortBy=latest&apiKey=ca73649cfc624eaf975ffa109305e988")
      .then(function(response) {
          $scope.newsArticles = response.data.articles;
          console.log($scope.newsArticles);
      });
});

//var app = angular.module('myApp', []);
//app.controller('myCtrl', function($scope, $http) {
//  $http.get("https://newsapi.org/v1/sources?source=the-next-web&sortBy=latest&apiKey=ca73649cfc624eaf975ffa109305e988")
//  .then(function(response) {
//      $scope.newsArticles = response.data;
//  });
//});