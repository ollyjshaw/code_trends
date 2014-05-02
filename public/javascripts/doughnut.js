var DoughnutChart = {
		
	loadChart : function(data) {
		new Chart(document.getElementById("canvas").getContext("2d")).Doughnut(data);
		
		$(".key").find("tr").each(function(i,v){
			$(this).find("th").css("background-color", data[i].color);
		});
	},
	
	refreshData : function(inputData){
		var internal = function(){
			$.get('/trends/data', {language1 : inputData[0], language2 : inputData[1], language3 : inputData[2]}, function(data){
				new Chart(document.getElementById("canvas").getContext("2d")).Doughnut(data);
				$(".key").find("tr").each(function(i,v){
					$(this).find("td").html(data[i].display);
				});
			});
		};
		
		setInterval(internal, 60000);
	}
};
