/**
 * 
 */
 function dailylog(){
	var dateVar = $("#date").val();
	if(dateVar==""){
		alert("Date cannot be null");
		window.location.href="reports";
		return;
	}
	else{
		document.getElementById("dailylog").submit();
	}
}