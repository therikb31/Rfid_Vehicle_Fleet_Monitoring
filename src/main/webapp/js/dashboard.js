var markers = [];
var map;
var readerData;
var mapRefreshInterval;
var mapRefreshRate = 60000;
//loading the map
function loadMap() {
	jsMaps.loader(function() {
		var tiles = new jsMaps.Native.Tiles();
		tiles.addTileLayer("http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", ['a', 'b', 'c']);
		map = jsMaps.api.init(
			'#map',
			'native',
			{
				center: {
					latitude: 22.59,
					longitude: 88.475
				},
				zoom: 13.5,
				mouse_scroll: true,
				zoom_control: true,
				map_type: true
			}, tiles
		);
	});
	fetchReaderData();
}
//fetch reader locations
async function fetchReaderData() {
	let url = './GetReaderServ';
	const response = await fetch(url);
	const datapoints = await response.json();
	readerData = datapoints.data;
	plotMap();
};
async function fetchVehicleLog(vehicle_no) {
	document.getElementById("vehicle_no_edit_driver").value = vehicle_no;
	setVehicleInfo(vehicle_no);
	clearInterval(mapRefreshInterval);
	setLogData(vehicle_no);
	let url = './GetMarkerServ?date=2022-11-19&vehicle_no=';
	url = url.concat(vehicle_no);
	const response = await fetch(url);
	const datapoints = await response.json();
	const data = datapoints.data;
	console.log(data);
	plotConditionalMap(data);
	mapRefreshInterval = setInterval(fetchVehicleLog, mapRefreshRate, vehicle_no);
}
function plotConditionalMap(Vehicledata) {
	var data = Vehicledata;
	jsMaps.api.removeMarkers(map);
	for (let i = 0; i < data.length; i++) {
		var position = new Object();
		position.lat = parseFloat(data[i].lat);
		position.lng = parseFloat(data[i].lon);
		var marker = new Object();
		marker.position = position;
		marker.title = data[i].address;
		marker.draggable = false;
		marker.icon = "./static/map-icon.png";
		var marker1 = jsMaps.api.marker(map, marker);
		var infoWindow = jsMaps.api.infoWindow({ content: data[i].address });
		jsMaps.api.attach_event(marker1, 'click', function() {
			infoWindow.open(map, marker1);
		});
	}
}

//plot reader locations
function plotMap() {
	var data = readerData;
	for (let i = 0; i < data.length; i++) {
		var position = new Object();
		position.lat = parseFloat(data[i].lat);
		position.lng = parseFloat(data[i].lon);
		var marker = new Object();
		marker.position = position;
		marker.title = data[i].address;
		marker.draggable = false;
		//marker.icon = "./static/wifi-icon.png";

		var marker1 = new jsMaps.api.marker(map, marker);
		var pair = new Object();
		pair.id = data[i].reader_id;
		pair.marker = marker1;
		pair.infoWindow = jsMaps.api.infoWindow({ content: data[i].address });
		jsMaps.api.attach_event(pair.marker, 'click', function() {
			pair.infoWindow.open(map, pair.marker);

			markers.push(pair);

			//var marker1 = jsMaps.api.marker(map, { position: { lat: parseFloat(data[i].lat), lng: parseFloat(data[i].lon) }, title: data[i].address, draggable: false, icon: "./static/map-icon.png" ,markerId : data[i].reader_id});
		});
	}
}

function setSidebarParams(data) {
	for (let i = 0; i < data.length; i++) {
		var element = document.getElementById(data[i].type_id.toString());
		var liNode = document.createElement("li");
		liNode.innerHTML = "<button style='margin-bottom:0.5vh;margin-left:2vw;' class='btn btn-outline-dark btn-sm' onclick='fetchVehicleLog(\"" + data[i].vehicle_no + "\")'><span style='font-size:0.7vw;'>" + data[i].vehicle_no + "</span></button>";
		//liNode.innerHTML = "<a class='link-dark rounded' onclick='fetchVehicleLog(\"" + data[i].vehicle_no + "\")'>" + data[i].vehicle_no + "</button>";
		element.appendChild(liNode);
	}
}
function resetMap() {
	document.getElementById("vehicle_no").innerHTML = "No vehicle selected";
	document.getElementById("vehicle_type").innerHTML = "No vehicle selected";
	document.getElementById("driver_name").innerHTML = "No vehicle selected";
	document.getElementById("current_location").innerHTML = "No vehicle selected";
	//document.getElementById("editDriverName").style.visibility = "hidden";
	document.getElementById("LogBody").innerHTML="";
	jsMaps.api.removeMarkers(map);
	map.setCenter(22.59,88.475);
	map.setZoom(13.5);
	plotMap();
}
function setVehicleInfo(vehicle_no) {
	document.getElementById("vehicle_no").innerHTML = "loading...";
	document.getElementById("vehicle_type").innerHTML = "loading...";
	document.getElementById("driver_name").innerHTML = "loading...";
	document.getElementById("current_location").innerHTML = "loading...";
	fetch('./GetVehicleInfo?vehicle_no=' + vehicle_no)
		.then((response) => response.json())
		.then((datapoints) => {
			data = datapoints.data;
			console.log(data);
			document.getElementById("vehicle_no").innerHTML = data.vehicle_no;
			document.getElementById("vehicle_type").innerHTML = data.type_name;
			document.getElementById("driver_name").innerHTML = data.date_added;
			document.getElementById("current_location").innerHTML = data.current_location;
			document.getElementById("editDriverName").style.visibility = "visible";
		});
}
function updateDriverName() {
	var vehicle_no = document.getElementById('vehicle_no_edit_driver').value;
	var driver_name = document.getElementById('driver_name_input').value;
	if(driver_name == ""){
		alert("Driver Name cannot be empty!");
		return;
	}
	fetch('./UpdateDriverServ?vehicle_no=' + vehicle_no + "&driver_name=" + driver_name)
	.then((response) => response.json())
	.then((datapoints) => {
		document.getElementById('driver_name').innerHTML = driver_name;
		$("#editDriverModal").modal("hide");
	});
};
async function setLogData(vehicle_no){
	var table = document.getElementById('LogBody');
	table.innerHTML = "";
	fetch('./GetVehicleLogTodayServ?vehicle_no='+vehicle_no)
	.then((response) => response.json())
	.then((datapoints) => {
		console.log("hello");
		console.log(datapoints);
		data = datapoints.data;
		for(let i=0;i<data.length;i++){
			var code="<tr><th scope='row'>"+(i+1)+"</th>"+
			"<td>"+data[i].address+"</td>"+
			"<td>"+data[i].date+"</td>"+
			"<td>"+data[i].time+"</td></tr>";
			table.innerHTML += code;
		}
	}).catch(err => {
          // Do something for an error here
          console.log("Error Reading data " + err);
        });;
}
fetch('./GetVehiclesServ')
	.then((response) => response.json())
	.then((data) => { setSidebarParams(data.data) });
loadMap();
