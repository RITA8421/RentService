'use strict';

var voituresLocationControllers = angular.module('VoituresLocationControllers', []);

voituresLocationControllers.controller("listeVoituresController", function($scope,$http,$routeParams) {

	$http.get('http://localhost:8080/cars').
	  success(function(data, status, headers, config) {
	  	$scope.listeVoitures = data;
	  	$scope.voitureChoisie = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });

        
});

voituresLocationControllers.controller("ajoutVoitureController", function($scope,$http,$routeParams) {

	$scope.voiture = {"immatriculation":"11aa22", "marque": "ferrari"};
	
	$scope.ajouterVoiture = function(voiture) {
		
		$http.post('http://localhost:8080/voiture', voiture).
		  success(function(data, status, headers, config) {
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};


        
});