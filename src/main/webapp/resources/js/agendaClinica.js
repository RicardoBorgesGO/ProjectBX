/**
 * 
 */
function executaAgenda(param) {
	$(document).ready(function() {
				    $('#calendar').fullCalendar({
				    	header: {
							left: 'prev,next today',
							center: 'title',
							right: 'month,agendaWeek,agendaDay'
						},
				    	editable: true,
				    	selectable: true,
				    	select: function(start, end) {
				    		var dataInicial = moment(start).format("YYYY/MM/DD hh:mm");
				    		var dataFinal = moment(end).format("YYYY/MM/DD hh:mm");
				    		
				    		$('#dataDoEvento').val(dataInicial);
				    		$('#dataFinalDoEvento').val(dataFinal);
				    		
				    		$('#labelDataDoEvento').html(dataInicial);
				    		$('#labelDataFinalDoEvento').html(dataFinal);
				            
				            $('#myModal').modal('show');
				        },
				        eventDrop: function(event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view) {
				        	var dataInicial = moment(event.start).format("YYYY-MM-DD'T'HH:mm:ss");
				        	var dataFinal = moment(event.end).format("YYYY-MM-DD'T'HH:mm:ss");
				        	
				        	var JSONObject = {'id':event.id,'end':dataFinal,'title':event.title,'start':dataInicial};
				        	alert(JSONObject.end);
	// 			        	var jsonData = $.parseJSON(JSONObject);
	
	// 			        	var request = $.ajax({
	// 			        	  url: param + "/rest/evento/updateEvento",
	// 			        	  type: "POST",
	// 			        	  data: JSONObject,
	// 			        	  dataType: "JSON",
	// 			        	  contentType: "application/json; charset=utf-8",
	// 			        	});
							
	// 						$.post(param + "/rest/evento/updateEvento", {"id":event.id,"end":dataFinal,"title":event.title,"start":dataInicial} );
						},
				        events: {
				        	url: param + '/rest/evento/getEventos',
				        	
				        },
				        eventRender: function(event, element) {
				            element.append('<span class="closeon">X</span>');
				            element.find('.closeon').click(function() {
				            	$('#idDoEvento').val(event.id);
				            	
				            	$('#myModalRemove').modal('show');
	// 			               	$('#calendar').fullCalendar('removeEvents',event._id);
				            });
				        }
				    })
			
			
				});
}