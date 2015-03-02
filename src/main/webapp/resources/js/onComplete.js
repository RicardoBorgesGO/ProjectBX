/**
 * 
 */

function showModalOnComplete(data) {
	if (data.status === 'success') {
		$('.modal').modal('show');
	}
}