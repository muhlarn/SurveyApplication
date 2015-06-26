function loadBubbles() {
    $(function() {
	    var bubbles = []; 

		for (var i = 0; i < tags.length; i++) {
			var tagTitle = tags[i].title;
			var tagId = tags[i].id;
            var numberOfPosts = 0;
			var xPosition =  Math.floor(Math.random() * 90);
			var yPosition = Math.floor(Math.random() * 90);
			
			for (var j = 0; j < vTag.length; j++) {
				if (tagId === vTag[j].tagId) {
				   numberOfPosts =  vTag[j].posts; 
				}   
			} 
			 
			if (numberOfPosts > 0) {
			
    			var bubble = {
					name: tagTitle,
					dataLabels: {
						enabled: true,

						formatter:function() {			    
							return this.series.name;
						},
					},
					data: [[xPosition , yPosition , parseInt(numberOfPosts)]],

                    events: {
                        click: function(event) { 
                          loadPopupBox(event.currentTarget.name);
                        }
                    }					
				}
			    
				bubbles.push(bubble);
			}
		}
        
        	
		$('#bubbles_container').highcharts({
			chart: {
				type: 'bubble',
				plotBorderWidth: 1,
				zoomType: 'xy'
			},
            
			legend: {
               enabled: false
            },
			title: {
				text: 'Problem Areas'
			},

			xAxis: {
			    minPadding:0,
                gridLineWidth: 1,
				
				labels: {
					enabled: false
				}
			},

			yAxis: {
			    startOnTick: false,
                endOnTick: false,
				
				labels: {
					enabled: false

				},
				
				title: {
                   enabled: false
                }
			},
            
			plotOptions: {
				bubble: {
					minSize: 50,
					maxSize: 120
				}
			},
			
			series: bubbles,
			
		});
    });
    }	
	function setupHotTopics(technologyName) {
	    var _title = technologyName;
		
	    $(function () {
          $('#hot_topics_container').highcharts({
            chart: {
            },
            title: {
                text: _title
            },
            xAxis: {
                categories: ['Gauteng', 'Limpopo', 'Kwazulu-Natal', 'Mpumalanga']
            },
            tooltip: {
                formatter: function() {
                    var s;
                    if (this.point.name) { // the pie chart
                        s = ''+
                            this.point.name +': '+ this.y +' counts';
                    } else {
                        s = ''+
                            this.x  +': '+ this.y;
                    }
                    return s;
                }
            },
            series: [{
                type: 'column',
                name: 'Province',
                data: [6, 3, 3, 9, 0,]
            }, {
                type: 'spline',
                name: 'Average',
                data: [6, 2.67, 3, 6.33, 3.33],
                marker: {
                	lineWidth: 2,
                	lineColor: Highcharts.getOptions().colors[3],
                	fillColor: 'white'
                }
            }, 
        ]
        });
    });
	} 
	
	function unloadPopupBox() {    
	
	    // TO Unload the Popupbox
		$('#pop-up').fadeOut("slow");
		$("#bubbles_container").css({ // this is just for style       
			"opacity": "1" 
		});
	}

    function loadPopupBox(technologyName) {
	    
        // To Load the Popupbox
		$('#pop-up').fadeIn("slow");
		$("#bubbles_container").css({ // this is just for style
			"opacity": "0.3" 
		});        
		
		setupHotTopics(technologyName);
	}
  	
	