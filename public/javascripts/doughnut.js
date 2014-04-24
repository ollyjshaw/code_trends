$(document).ready(function() {					
var myDoughnut = new Chart(document.getElementById("canvas").getContext("2d")).Doughnut(D_D);
					
					$(".key").find("tr").each(function(i,v){
						$(this).find("th").css("background-color", D_D[i].color);
					});
});