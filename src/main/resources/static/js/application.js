$(document).ready(function(){

	hideLoadingMsg();
	
	// Datepicker 
	$('.datepicker').datepicker();

});

function showLoadingMsg(){
	$("#loadingMsg").show();	
}

function hideLoadingMsg(){
	$("#loadingMsg").hide();	
}