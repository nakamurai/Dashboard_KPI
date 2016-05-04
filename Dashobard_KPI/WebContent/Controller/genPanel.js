$( document ).ready(function() {
	
	var valueList = ["2.91%","3.251%","10.5%"];
	//
	var currentNext = "#next";
	var currentPrev = "#prev";
	var panel_count = 0;
	var panel_currentDetail = 0;
	
	genPanel(valueList,"panel_1_title","#next1","#prev1");
	
	$(currentNext).click(function() {
		
		if(panel_currentDetail < panel_count){
			++panel_currentDetail;
			document.getElementById("panel_1_title").innerHTML = valueList[panel_currentDetail-1];
			genChart();
			}
		else
			{
				console.log("Array Out of Bound");
			}
		
	

});
	$(currentPrev).click(function() {
		if(panel_currentDetail > 1){
			--panel_currentDetail;
			document.getElementById("panel_1_title").innerHTML = valueList[panel_currentDetail-1];
			}
		else
			{
				console.log("Array Out of Bound");
			}
		

	}); // end Prev
	

	// GET Panel
	// Arg1 List Value	
	// Arg2 panel ID
	// Arg3 next ID
	// Arg4	prev ID
			
	function genPanel(vallist,idpanel,idnext,idprev){
				

				var valueList = ["no setting"];
				
				
				//check no config
				if(vallist == null || idnext == null || idprev == null){
				//alert(valueList[0]);
				}
				else
				{
					valueList = vallist; 	
					//alert(valueList[1]);
					panel_count = valueList.length;
					panel_currentDetail = 1;
					currentNext=idnext;
					currentPrev=idprev;
				
				document.getElementById(idpanel).innerHTML = valueList[0];

				}//end

			}	
	function genChart()
	{
		$("#chart_1").insertFusionCharts({
		    type: "column2d",
		    width: "200",
		    height: "180",
		    dataFormat: "json",
		    dataSource: {
		        chart: {
		            caption: "Harry's SuperMart",
		            subCaption: "Top 5 stores in last month by revenue",
		            numberPrefix: "$",
		            theme: "ocean"
		        },
		        data: [{
		            label: "Bakersfield Central",
		            value: "880000"
		        }, {
		            label: "Garden Groove harbour",
		            value: "730000"
		        }, {
		            label: "Los Angeles Topanga",
		            value: "590000"
		        }, {
		            label: "Compton-Rancho Dom",
		            value: "520000"
		        }, {
		            label: "Daly City Serramonte",
		            value: "330000"
		        }]
		    }
		});
		
	}
});

