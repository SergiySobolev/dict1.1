$(document).ready(function() {
	$('select').change(function(){
		 $(this).parents('form').submit();
	});
	$(".chzn-select").chosen();
	$(".chzn-select-deselect").chosen({allow_single_deselect:true});
})
