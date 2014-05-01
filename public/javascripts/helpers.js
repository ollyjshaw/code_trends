var DC = {
		
	loadChart : function(data) {
		var myDoughnut = new Chart(document.getElementById("canvas").getContext("2d")).Doughnut(data);
		
		$(".key").find("tr").each(function(i,v){
			$(this).find("th").css("background-color", data[i].color);
		});
	},
	
	refreshData : function(data){
		var foo = function(){
			console.log(data);
		};
		setInterval(foo, 1000);
	}
	
	
};