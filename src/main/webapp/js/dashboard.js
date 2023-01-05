var markers = [];
var map;
var readerData;
var mapRefreshInterval;
var mapRefreshRate = 300000;
//loading the map
function loadMap() {
	jsMaps.loader(function() {
		var tiles = new jsMaps.Native.Tiles();
		tiles.addTileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", ['a', 'b', 'c'], '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>.', 'OpenStreetMap');
		tiles.addTileLayer("http://{s}.mqcdn.com/tiles/1.0.0/map/{z}/{x}/{y}.png", ['otile1', 'otile2', 'otile3', 'otile4'], '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>. Tiles courtesy of <a href="http://www.mapquest.com/" target="_blank">MapQuest</a> <img src="https://developer.mapquest.com/content/osm/mq_logo.png">', 'Map Quest');
		tiles.addTileLayer("http://{s}.mqcdn.com/tiles/1.0.0/sat/{z}/{x}/{y}.jpg", ['oatile1', 'oatile2', 'oatile3', 'oatile4'], '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>. Tiles courtesy of <a href="http://www.mapquest.com/" target="_blank">MapQuest</a> <img src="https://developer.mapquest.com/content/osm/mq_logo.png">', 'Map Quest Satellite', 19);

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
	clearInterval(mapRefreshInterval);
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

		var marker1 = jsMaps.api.marker(map, marker);
		var pair = new Object();
		pair.id = data[i].reader_id;
		pair.marker = marker1;
		var infoWindow = jsMaps.api.infoWindow({ content: data[i].address });
		jsMaps.api.attach_event(pair.marker, 'hover', function() {
			infoWindow.open(map, pair.marker);
			
		markers.push(pair);

		//var marker1 = jsMaps.api.marker(map, { position: { lat: parseFloat(data[i].lat), lng: parseFloat(data[i].lon) }, title: data[i].address, draggable: false, icon: "./static/map-icon.png" ,markerId : data[i].reader_id});
		});
	}
}

function setSidebarParams(data) {
	for (let i = 0; i < data.length; i++) {
		var element = document.getElementById(data[i].type_id.toString());
		var liNode = document.createElement("li");
		liNode.innerHTML = "<button style='margin-bottom:2px;margin-left:30px;' class='btn btn-outline-dark btn-sm' onclick='fetchVehicleLog(\"" + data[i].vehicle_no + "\")'>" + data[i].vehicle_no + "</button>";
		//liNode.innerHTML = "<a class='link-dark rounded' onclick='fetchVehicleLog(\"" + data[i].vehicle_no + "\")'>" + data[i].vehicle_no + "</button>";
		element.appendChild(liNode);
	}
}
	fetch('./GetVehiclesServ')
		.then((response) => response.json())
		.then((data) => { setSidebarParams(data.data) });
	loadMap();
