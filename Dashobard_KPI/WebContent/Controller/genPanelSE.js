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
	//Chart  Count
	var panel_chart_count = listvalueTemp.length;
	
	var content = "";
	 for(j=0;j<panel_chart_count;j++){
		  eval(" content += \" <div class = 'panel'> \"   " +
		                  " + \" <div class = 'page'> \" " +
		           "+ \" <div class = 'pagehead' style='width:180px; height:10px; background:#e2b2ae;'></div> \" " +
		           "+ \" <div class='row-fluid'> \" " +
		           "+ \" <div class='span4'> \" " +
		           "+ \" <a href='#' id='prev"+(j+1)+"' onclick='return false;'><img src='../img/1461912837_icon-arrow-left-b.png' style='float:left;'></a> \" " +
		           "+ \" </div> \" " +
		           "+ \" <div id='pagecontent' class='span4'> \" " +
		              "+ \" <div class='row-fluid'><span id='panel_"+(j+1)+"_content'>SKPI4</span></div> \" " +
		              "+ \" <div class='row-fluid'><span id='panel_"+(j+1)+"_title'>no data</span></div> \" " +
		           "+ \" </div> \" " +   
		           "+ \" <div class='span4'> \" " +
		           "+ \" <a href='#' id='next"+(j+1)+"' onclick='return false;'><img src='../img/1461912800_icon-arrow-right-b.png' style='float:right;'></a> \" " +
			     " + \" </div> \" " +
		         " + \" </div> \" " +
		         " + \" </div> \" " +
		         " + \" <div id='bullet_"+(j+1)+"' class='bulletbar' >Bullet</div> \"	" +
		         " + \" <div id='chart_"+(j+1)+"' class='barchart' >columnChart</div> \" " +
		         " + \" <div class = 'panelTitleChart'> \" " +
		         " + \" <p id='panelTitleChart_"+(j+1)+"'><b>จำนวนผลการวิจัยที่ตีพิมพ์ในวารสารวิชาการระดับนานาชาติ<br>ต่อจำนวนบุคลากรสายวิชาการ</b></p> \" " +
		         " + \" </div> \" " +
		         " + \" </div> \";" );	 

	 }
	 document.getElementById("Content").innerHTML=content;
	 
	 //GENDATA
	 for(t=0;t<panel_chart_count;t++){
	  eval(" var panel_currentDetail"+(t+1)+" = "+(t+1)+"; ");
	  eval(" var valueList"+(t+1)+" = listvalueTemp; ");
	  eval(" var panel_count"+(t+1)+" = valueList1.length; ");
	  eval(" document.getElementById('panel_"+(t+1)+"_title').innerHTML = valueList"+(t+1)+"[(panel_currentDetail"+(t+1)+")-1][1]; ");
	  eval(" document.getElementById('panel_"+(t+1)+"_content').innerHTML = valueList"+(t+1)+"[(panel_currentDetail"+(t+1)+")-1][0]; ");
	  eval(" document.getElementById('panelTitleChart_"+(t+1)+"').innerHTML = valueList"+(t+1)+"[(panel_currentDetail"+(t+1)+")-1][2].substring(0,80); ");
	  eval(" var datasource"+(t+1)+" = []; ");
	  eval(" datasource"+(t+1)+" = getSource(panel_currentDetail"+(t+1)+",listvalueTemp); ");
	  eval(" genChart('#chart_"+(t+1)+"',datasource"+(t+1)+"); ");
	  eval(" genBulletChart('#bullet_"+(t+1)+"',listvalueTemp,panel_currentDetail"+(t+1)+"); ");
	 }

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
    			" document.getElementById('panelTitleChart_"+(i+1)+"').innerHTML = valueList"+(i+1)+"[(panel_currentDetail"+(i+1)+")-1][2].substring(0,80);; "+
    			" var datasource"+(i+1)+" = [];"+
    			" datasource"+(i+1)+" = getSource(panel_currentDetail"+(i+1)+",listvalueTemp);               "+
    			//" genBottom(panel_currentDetail"+(i+1)+",panelTitleChart_"+(i+1)+");"+
    			" genChart('#chart_"+(i+1)+"',datasource"+(i+1)+");                            "+
    			" genBulletChart('#bullet_"+(i+1)+"',listvalueTemp,panel_currentDetail"+(i+1)+");                            "+
    			"}"+
    			"});");
    	
    	eval("$('#prev"+(i+1)+"').click(function() { " +
//    			"alert("+(i+1)+");   " +
    			"if(panel_currentDetail"+(i+1)+" > 1){"+
    			" --panel_currentDetail"+(i+1)+"; "+
    			" document.getElementById('panel_"+(i+1)+"_title').innerHTML = valueList"+(i+1)+"[(panel_currentDetail"+(i+1)+")-1][1]; "+
    			" document.getElementById('panel_"+(i+1)+"_content').innerHTML = valueList"+(i+1)+"[(panel_currentDetail"+(i+1)+")-1][0]; "+
    			" document.getElementById('panelTitleChart_"+(i+1)+"').innerHTML = valueList"+(i+1)+"[(panel_currentDetail"+(i+1)+")-1][2].substring(0,80);; "+
    			" var datasource"+(i+1)+" = [];"+
    			" datasource"+(i+1)+" = getSource(panel_currentDetail"+(i+1)+",listvalueTemp);               "+
    	//		" genBottom(panel_currentDetail"+(i+1)+",panelTitleChart_"+(i+1)+");  "+
    			" genChart('#chart_"+(i+1)+"',datasource"+(i+1)+");                            "+
    			" genBulletChart('#bullet_"+(i+1)+"',listvalueTemp,panel_currentDetail"+(i+1)+");                            "+
    			"}"+
    			"});");
	
}//end FOR	
	
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
	
	function getSource(value,rsource) {
		
		var dataS = [];
		//DATAS1
		lab=rsource[value-1][4]
		val=rsource[value-1][5]

		dataS = [];
		
	
			dataS.push({ 
		    "label" : lab,
		    "value"  : val
		    });
		
		
		return dataS;
		
	}
	
	function genBulletChart(chart_id,datasource,index){
		
		var bulletValue = datasource[index-1][3]

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
		            "target": bulletValue
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

