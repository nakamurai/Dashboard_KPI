// TEST GET DATA FROM MODEL page.jsp
$( document ).ready(function() {
	var listvalueTemp;
	$.ajax({
		url: "../Model/page.jsp",
		type: "get",
		dataType: "json",
		async: false,
		complete:function(results) {
			//console.log(results);
			//jquery1.10+
			var data = results.responseJSON;
			listvalueTemp = data;
		}
	});
	console.log(listvalueTemp);

	
	//genCylinder("#doughnut",null);
	gendoughnut2d("#doughnut",null);
	var panel_chart_count = 2;

	//panel1
	var panel_currentDetail1 = 1;
	var valueList1 = listvalueTemp;
	var panel_count1 = valueList1.length;
	genPanel(listvalueTemp,"panel_1_title","panel_1_content");
	var datasource1 = [];
	datasource = getSource(panel_currentDetail1);
	//datasourceb = getSource1(panel_currentDetail1);
	genChart("#chart_1",datasource);
	genBulletChart("#bullet_1",null);
	//genBottom(panel_currentDetail1,"panelTitleChart_1");
	
	//panel2
	var panel_currentDetail2 = 1;
	var valueList2 = listvalueTemp;
	var panel_count2 = valueList2.length;
	genPanel(listvalueTemp,"panel_2_title","panel_2_content");
	var datasource2 = [];
	datasource2 = getSource(panel_currentDetail2);
	genChart("#chart_2",datasource2);
	//genBottom(panel_currentDetail1,"panelTitleChart_1");
	

	
	
	//Gen Buttom start FOR
    for(i=0;i<panel_chart_count;i++){
    	eval("var temp_currentDetail"+(i+1)+"= panel_currentDetail"+(i+1)+";");	
    	//alert(temp_currentDetail1);
    	eval("$('#next"+(i+1)+"').click(function() { " +
        //"alert("+(i+1)+");   " +
    			"if(panel_currentDetail"+(i+1)+" < panel_count"+(i+1)+"){"+
    			" ++panel_currentDetail"+(i+1)+"; "+
    			" document.getElementById('panel_"+(i+1)+"_title').innerHTML = valueList"+(i+1)+"[(panel_currentDetail"+(i+1)+")-1][1]; "+
    			" document.getElementById('panel_"+(i+1)+"_content').innerHTML = valueList"+(i+1)+"[(panel_currentDetail"+(i+1)+")-1][0]; "+
    			" var datasource = [];"+
    			" var datasource = [];"+
    			" datasource = getSource(panel_currentDetail"+(i+1)+");               "+
    			//" genBottom(panel_currentDetail"+(i+1)+",panelTitleChart_"+(i+1)+");"+
    			" genChart('#chart_"+(i+1)+"',datasource);                            "+
    			"}"+
    			"});");
    	
    	eval("$('#prev"+(i+1)+"').click(function() { " +
//    			"alert("+(i+1)+");   " +
    			"if(panel_currentDetail"+(i+1)+" > 1){"+
    			" --panel_currentDetail"+(i+1)+"; "+
    			" document.getElementById('panel_"+(i+1)+"_title').innerHTML = valueList"+(i+1)+"[(panel_currentDetail"+(i+1)+")-1][1]; "+
    			" document.getElementById('panel_"+(i+1)+"_content').innerHTML = valueList"+(i+1)+"[(panel_currentDetail"+(i+1)+")-1][0]; "+
    			" var datasource = [];"+
    			" datasource = getSource(panel_currentDetail"+(i+1)+");               "+
    	//		" genBottom(panel_currentDetail"+(i+1)+",panelTitleChart_"+(i+1)+");  "+
    			" genChart('#chart_"+(i+1)+"',datasource);                            "+
    			"}"+
    			"});");
	
}//end FOR	

	function genPanel(vallist,idpanel,idcontent){
				
				var valueList = ["no setting"];
				//check no config
				if(vallist == null || idcontent == null){
				//alert(valueList[0]);
				}
				else
				{
					var valueList = vallist; 	
				// Percent %
				document.getElementById(idpanel).innerHTML = listvalueTemp[0][1];
				// SKPI XX
				document.getElementById(idcontent).innerHTML = listvalueTemp[0][0];
				}//end
			}	
	
	function genChart(chart_id,datasource){
		$(chart_id).insertFusionCharts({
			type: 'column2d',
	        renderAt: 'chart-container',
	        width: '350',
	        height: '200',
	        dataFormat: 'json',
	        dataSource: {
	            "chart": {
	            	"paletteColors": "#ffd625,#9ecf6c,#00cfff",
	                "bgColor": "#ffffff",
	                "borderAlpha": "0",
	                "canvasBorderAlpha": "0",
	                "usePlotGradientColor": "0",
	                "plotBorderAlpha": "10",
	                "rotatevalues": "0",
	                "valueFontColor": "#000000",                
	                "xAxisLineColor": "#999999",
	                "divlineColor": "#999999",               
                    "divLineAlpha": "0",
	                "showAlternateHGridColor": "0"
	            },            
	            "data": datasource
		    }
		});
	}
	
	function getSource(value) {
		
		var dataS = [];
		//DATAS1
		if(value == 1){

			dataS = [];
		
			dataS.push({ 
		    "label" : "2559",
		    "value"  : "220000"
		    });
			dataS.push({ 
	        "label" : "2558",
	        "value"  : "430000"
	    });
			dataS.push({ 
	        "label" : "2557",
	        "value"  : "160000"
	    });
		
		}
		
		//DATAS2
		else if (value == 2){

			dataS = [];
		
			dataS.push({ 
		    "label" : "2559",
		    "value"  : "420000"
		    });
			dataS.push({ 
	        "label" : "2558",
	        "value"  : "450000"
	    });
			dataS.push({ 
	        "label" : "2557",
	        "value"  : "460000"
	    });
		
		}
		
		//DATAS3
		else if(value == 3){
			
			dataS = [];
		
			dataS.push({ 
		    "label" : "2559",
		    "value"  : "320000"
		    });
			dataS.push({ 
	        "label" : "2558",
	        "value"  : "330000"
	    });
			dataS.push({ 
	        "label" : "2557",
	        "value"  : "550000"
	    });
		
		}
		return dataS;
		
	}
	
	function genBulletChart(chart_id,datasource){

		$(chart_id).insertFusionCharts({
		        type: 'hbullet',
		        renderAt: 'chart-container',
		        width: '210',
		        height: '73.9931',
		        dataFormat: 'json',
		        dataSource: {
		            "chart": {
		                "lowerLimit": "0",
		                "upperLimit": "100",
		                "bgColor": "#D3D3D3,#ECECEC",
		                "bgRatio": "#D3D3D3,#ECECEC",
		                "chartBottomMargin": "25",
		                "showBorder": "0",
		                "showShadow": "0",
		                "targetFillPercent": "80",
		                "targetColor": "#004b7f",
		                "targetThickness": "10",
		                "setAdaptiveYMin": "1"
		            },
		            "colorRange": {
		                "color": [
		                    {
		                        "minValue": "0",
		                        "maxValue": "25",
		                        "code": "#e00000",
		                        "alpha": "80"
		                    },
		                    {
		                        "minValue": "25",
		                        "maxValue": "50",
		                        "code": "#ffff00",
		                        "alpha": "80"
		                    },
		                    {
		                        "minValue": "50",
		                        "maxValue": "75",
		                        "code": "#9eff39",
		                        "alpha": "80"
		                    },
		                    {
		                        "minValue": "75",
		                        "maxValue": "100",
		                        "code": "#00b456",
		                        "alpha": "80"
		                    }
		                ]
		            },
		            "target": "90"
		        }
		    });

		}
	

	function gendoughnut2d(chart_id,datasource){

		$(chart_id).insertFusionCharts({
			type: 'doughnut2d',
	        renderAt: 'chart-container',
	        width: '220',
	        height: '210',
	        dataFormat: 'json',
	        dataSource: {
	            "chart": {
	                "paletteColors": "#e2b2ae,#ececec",
	                "bgColor": "#ffffff",
	                "showBorder": "0",
	                "use3DLighting": "0",
	                "showShadow": "0",
	                "showValues": "0",
	                "enableSmartLabels": "0",
	                "startingAngle": "90",
	                "showLabels": "0",
	                "showPercentValues": "1",
	                "showLegend": "1",
	                "defaultCenterLabel": "72%",
	                "centerLabelBold": "1",
	                "centerLabelFontSize": "10",
	                "decimals": "0",
	            },
	            "data": [
	                     {
	                         "value": "74"
	                     }, 
	                     {
	                         "value": "26"
	                     }
	                 ]
		        }
		    });

		}
	
	function genCylinder(chart_id,datasource){

		$(chart_id).insertFusionCharts({
			type: 'cylinder',
            dataFormat: 'json',
            id: 'fuelMeter',
            renderAt: 'chart-container',
            width: '200',
            height: '160',
            dataSource: {
                "chart": {
                    "subcaptionFontBold": "0",
                    "lowerLimit": "0",
                    "upperLimit": "100",
                    "lowerLimitDisplay": "Empty",
                    "upperLimitDisplay": "Full",
                    "numberSuffix": " %",
                    "showValue": "1",
                    "showhovereffect": "0",
                    "bgCOlor": "#ffffff",
                    "borderAlpha": "0",
                    "cylFillColor": "#e2b2ae"
                },
                "value": "110"
            },
            "events":{
                "rendered": function(evtObj, argObj){
                    setInterval(function () {
                        (fuelVolume = 74) ? (fuelVolume = 74) : "";
                        var consVolume = fuelVolume -(Math.floor(Math.random() * 3));
                        FusionCharts("fuelMeter").feedData("&value=" + consVolume);
                        fuelVolume = consVolume;
                    }, 1000);
                }
            }
		    });
		}
	
	
});

