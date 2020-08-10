jQuery(document).ready(function($) {
	
	$('button', $('.cadCli')).on('click', function() {
		$($('#divTel')).clone().removeAttr("id").insertAfter($('#divTel'));
	});
	
	$('.deleteIcon').on('click', function() {
		let idUser = $(this).closest('tr').find('th').first().text();
		
		idUser = idUser.match(/\d+/)[0];
		
		$.ajax({
		      data: {idUserDel: idUser},
		      method: "Post",
		      url: "/Desafio/deletaUsuario",
		      success: function(result){}
		});
	});
	
});