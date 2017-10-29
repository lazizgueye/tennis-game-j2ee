<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myapp">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>TennisGame</title>
		<script type="text/javascript" src="js/angular.min.js"></script>
		<script type="text/javascript" src="js/angular-sanitize.js"></script>
	</head>
	
	<body ng-controller="gameCtrl">
		<h1>Final score</h1>
			<p><b>player 1 score </b>: {{listSetGames.score1}} </p>
		   	<p><b>player 2 score </b>: {{listSetGames.score2}} </p>
			
			
			<p>The winner is :
				<b>
					{{listSetGames.winner==0 ? 'player 1' : 'player 2'}}
				</b>
			</p>
						
		
		<h1>Details Set</h1>
		
		 	<p>Player 1 : {{listSetGames.historic_score1}} <br/>
		 	   Player 2 : {{listSetGames.historic_score2}}	</p>
		 	    
		
		<h1>Details Game Set</h1>		 	
		 	<table border="1">
			    <tr ng-repeat="x in listSetGames.historic_game_score">
			    	<td>Game {{$index + 1}}</td>
			        <td ng-bind-html="x"></td>
			    </tr>
			</table>
			
		
		<script type="text/javascript">
			var myapp=angular.module('myapp', ['ngSanitize']);
			myapp.controller('gameCtrl', function($scope, $http){
				$http.get('http://localhost:8080/TennisGameRules/rest/setgame/findall').success(function(response){
					$scope.listSetGames = response.setgame;
				});
			});
		</script>
		
	</body>
</html>
