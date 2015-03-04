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
	if (hasError)
		return false;
	else
		return true;
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