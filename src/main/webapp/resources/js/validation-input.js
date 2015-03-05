var imported = document.createElement('script');
imported.src = '/sgo/javax.faces.resource/jquery.bootstrap-growl.min.js.xhtml?ln=js';
document.head.appendChild(imported);


/**
 * JavaScript utilitário para validação.
 * 
 * Para validar os campos é necessário inserir as classes: 
 * - validation-required: para campos requeridos
 * - btn-validation: botao de submit
 * 
 */
$('.btn-validation').click(function() {
	var hasError = false;
	var campos = $('.form-group .validation-required');

	for (var i = 0; i < campos.length; i++) {
		if (!$('.form-group .validation-required:eq(' + i + ')').val()) {
			$('.form-group .validation-required:eq(' + i + ')').closest('.form-group').addClass('has-error');
			hasError = true;
		} else {
			$('.form-group .validation-required:eq(' + i + ')').closest('.form-group').removeClass('has-error');
		}
	}
	if (hasError) {
		$.bootstrapGrowl("Campos obrigatórios", {
			ele: 'body', // which element to append to
			type: 'danger', // (null, 'info', 'danger', 'success')
			offset: {from: 'top', amount: 60}, // 'top', or 'bottom'
			align: 'right', // ('left', 'right', or 'center')
			width: 250, // (integer, or 'auto')
			delay: 4000, // Time while the message will be displayed. It's not equivalent to the *demo* timeOut!
			allow_dismiss: true, // If true then will display a cross to close the popup.
			stackup_spacing: 10 // spacing between consecutively stacked growls.
		});
		return false;
	} else {
		alert("Passou");
		return true;
	}
});


//Alterações nos campos
$('.validation-required').keyup(function() {
	var count = $(this).val().length;
	
	if (count > 0) {
		$(this).closest('.form-group').removeClass('has-error');
	}
});

$('.validation-required').change(function() {
	$(this).closest('.form-group').removeClass('has-error');
});