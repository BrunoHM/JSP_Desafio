jQuery(document).ready(function($) {
	let $el = $('.divTel');
	
	$('button', $('.cadCli')).on('click', function() {
		  $elPai = $($el).clone().insertAfter($('.divEmail')).removeClass('col-4').addClass('col-12');
		  $elPai.children().eq(0).removeClass('col-3').addClass('col-1');
		  $elPai.children().eq(1).removeClass('col-6').addClass('col-2');
	});
	
	$('.deleteIcon').on('click', function() {
		let idUser = $(this).closest('tr').find('th').first().text();
		
		idUser = idUser.match(/\d+/)[0];
		
		$.ajax({
		      data: {idUserDel: idUser},
		      method: "Post",
		      url: "/Desafio/deletaUsuario",
		      success: function(result){
		    	  //console.info(result);
		      }
		});
	});
	
});