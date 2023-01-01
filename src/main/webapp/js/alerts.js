function setMostUsedReader(data) {
	var element = document.getElementById("mostUsedReader");
	element.innerHTML = "Reader ID: <b>" + data.reader_id + "</b><br/>" +
		"Address: <b>" + data.address + "</b><br/>" +
		"Latitude: <b>" + data.lat + "</b><br/>" +
		"Longitude: <b>" + data.lon + "</b><br/>" +
		"Activity: <b>" + data.activity + "</b><br/>";
}
function setLeastUsedReader(data) {
	var body = document.getElementById('leastUsedReader');
	for (i = 0; i < data.length; i++) {
		var breakline = "";
		if ((i + 1) % 3 == 0) {
			breakline = '<div class="w-100"></div>';
		}
		var html = '<div class="col card" style="width: 18rem; margin: 20px; padding: 0px;">' +
			'<h5 class="card-header">Least Used Reader</h5>' +
			'<div class="card-body">' +
			'<p class="card-text" id="leastUsedReader">' +
			"Reader ID: <b>" + data[i].reader_id + "</b><br/>" +
			"Address: <b>" + data[i].address + "</b><br/>" +
			"Latitude: <b>" + data[i].lat + "</b><br/>" +
			"Longitude: <b>" + data[i].lon + "</b><br/>" +
			"Activity: <b>" + data[i].activity + "</b><br/>" +
			'</p>' +
			'</div>' +
			'</div>';
		body.innerHTML += html + breakline;
	}
	document.querySelector(
			"#loader").style.display = "none";
		document.querySelector(
			"body").style.visibility = "visible"; 
}
function setMostActiveVehicle(data){
	var body = document.getElementById('mostUsedVehicle');
	for (i = 0; i < data.length; i++) {
		var breakline = "";
		if ((i + 1) % 3 == 0) {
			breakline = '<div class="w-100"></div>';
		}
		var html = '<div class="col card" style="width: 18rem; margin: 20px; padding: 0px;">' +
			'<h5 class="card-header">Least Used Reader</h5>' +
			'<div class="card-body">' +
			'<p class="card-text" id="leastUsedReader">' +
			"Reader ID: <b>" + data[i].reader_id + "</b><br/>" +
			"Address: <b>" + data[i].address + "</b><br/>" +
			"Latitude: <b>" + data[i].lat + "</b><br/>" +
			"Longitude: <b>" + data[i].lon + "</b><br/>" +
			"Activity: <b>" + data[i].activity + "</b><br/>" +
			'</p>' +
			'</div>' +
			'</div>';
		body.innerHTML += html + breakline;
}
document.onreadystatechange = function() {
            if (document.readyState !== "complete") {
                document.querySelector(
                  "body").style.visibility = "hidden";
                document.querySelector(
                  "#loader").style.visibility = "visible";
            }
        };
$(document).ready(function() { 
	fetch('./MostUsedReaderAlert')
		.then((response) => response.json())
		.then((data) => { setMostUsedReader(data.data) });
	fetch('./LeastUsedReaderAlert')
		.then((response) => response.json())
		.then((data) => { setLeastUsedReader(data.data) });
	fetch('./LeastUsedReaderAlert')
		.then((response) => response.json())
		.then((data) => { setLeastUsedReader(data.data) });
		
});
