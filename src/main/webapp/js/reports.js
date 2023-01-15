/**
 * 
 */
function setVehicleListParams(data) {
	for (let i = 0; i < data.length; i++) {
		var elements = document.getElementsByClassName("select-vehicle");
		for (j = 0; j < elements.length; j++) {
			var node = document.createElement("option");
			node.innerHTML = data[i].vehicle_no;
			node.value = data[i].vehicle_no;
			elements[j].appendChild(node);
		}
	}
}
function setReaderListParams(data) {
	console.log(data)
	for (let i = 0; i < data.length; i++) {
		var elements = document.getElementsByClassName("select-reader");
		for (j = 0; j < elements.length; j++) {
			console.log(data[i]);
			var node = document.createElement("option");
			node.innerHTML = data[i].address;
			node.value = data[i].pole_no;
			elements[j].appendChild(node);
		}
	}
}

$(document).ready(function() {
	fetch('./GetPolesServ')
		.then((response) => response.json())
		.then((data) => { setReaderListParams(data.data) });
	fetch('./GetVehiclesServ?key=5388d63404f6ca03cbee93832d122a2a')
		.then((response) => response.json())
		.then((data) => { setVehicleListParams(data.data) });
});
