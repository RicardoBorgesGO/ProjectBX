//PACIENTE
function executaAutoCompletePaciente(param) {
	$('.form-group .search-paciente').typeahead({
		hint : true,
		highlight : true,
		minLength : 1,
	}, {
	    source: function(query, process) {
	        var $url = param + '/rest/paciente/getPacientes';
	        var $items = new Array;
	        $items = [];
	        $.ajax({
	            url: $url,
	            dataType: "json",
	            type: "GET",
	            success: function(data) {
	                $.map(data, function(data){
	                    var group;
	                    group = {
	                        id: data.id,
	                        name: data.nome,
	                        toString: function () {
	                            return JSON.stringify(this);
	                            //return this.app;
	                        },
	                        toLowerCase: function () {
	                            return this.name.toLowerCase();
	                        },
	                        indexOf: function (string) {
	                            return String.prototype.indexOf.apply(this.name, arguments);
	                        },
	                        replace: function (string) {
	                            var value = '';
	                            value +=  this.name;
	                            if(typeof(this.level) != 'undefined') {
	                                value += ' <span class="pull-right muted">';
	                                value += this.level;
	                                value += '</span>';
	                            }
	                            return String.prototype.replace.apply('<div style="padding: 10px; font-size: 1.5em;">' + value + '</div>', arguments);
	                        }
	                    };
	                    
	                    var substrRegex;
	                    substrRegex = new RegExp(query, 'i');
	                    
	                    if (substrRegex.test(group.name)) {
	                    	$items.push(group);
	        			}
	                });
	                process($items);
	            }
	        });
	    },
	    name : 'pacientes',
		displayKey : 'name',
	    items: 10,
	    minLength: 2
	});
}

$('.form-group .search-paciente').on('typeahead:selected', function(evt, item) {
	$('#pacienteID').val(item.id);
});

//COLABORADOR
function executaAutoCompleteColaborador(param) {
	$('.form-group .search-colaborador').typeahead({
		hint : true,
		highlight : true,
		minLength : 1,
	}, {
	    source: function(query, process) {
	        var $url = param + '/rest/colaborador/getColaboradores';
	        var $items = new Array;
	        $items = [];
	        $.ajax({
	            url: $url,
	            dataType: "json",
	            type: "GET",
	            success: function(data) {
	                $.map(data, function(data){
	                    var group;
	                    group = {
	                        id: data.id,
	                        name: data.nome,
	                        toString: function () {
	                            return JSON.stringify(this);
	                            //return this.app;
	                        },
	                        toLowerCase: function () {
	                            return this.name.toLowerCase();
	                        },
	                        indexOf: function (string) {
	                            return String.prototype.indexOf.apply(this.name, arguments);
	                        },
	                        replace: function (string) {
	                            var value = '';
	                            value +=  this.name;
	                            if(typeof(this.level) != 'undefined') {
	                                value += ' <span class="pull-right muted">';
	                                value += this.level;
	                                value += '</span>';
	                            }
	                            return String.prototype.replace.apply('<div style="padding: 10px; font-size: 1.5em;">' + value + '</div>', arguments);
	                        }
	                    };
	                    
	                    var substrRegex;
	                    substrRegex = new RegExp(query, 'i');
	                    
	                    if (substrRegex.test(group.name)) {
	                    	$items.push(group);
	        			}
	                });
	                process($items);
	            }
	        });
	    },
	    name : 'colaboradores',
		displayKey : 'name',
	    items: 10,
	    minLength: 2
	});
}

$('.form-group .search-colaborador').on('typeahead:selected', function(evt, item) {
	$('#colaboradorID').val(item.id);
});