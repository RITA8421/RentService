'use strict';

var app = angular.module('VoituresLocation', ['ngRoute','VoituresLocationControllers']);

app.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
			when('/gestionVoitures', {
				templateUrl: 'partials/menu.html'
			}).
			when('/gestionVoitures/listerVoitures', {
				templateUrl: 'partials/listerVoitures.html',
				controller: 'listeVoituresController'
			}).
			when('/gestionVoitures/ajoutVoiture', {
				templateUrl: 'partials/ajoutVoiture.html',
				controller: 'ajoutVoitureController'
			}).
			otherwise({
				redirectTo: '/gestionVoitures'
			});
}]);