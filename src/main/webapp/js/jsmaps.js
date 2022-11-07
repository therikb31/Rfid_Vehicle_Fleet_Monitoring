jsMaps.loader(function() {
	var tiles = new jsMaps.Native.Tiles();
	tiles.addTileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", ['a', 'b', 'c'], '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>.', 'OpenStreetMap');
	tiles.addTileLayer("http://{s}.mqcdn.com/tiles/1.0.0/map/{z}/{x}/{y}.png", ['otile1', 'otile2', 'otile3', 'otile4'], '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>. Tiles courtesy of <a href="http://www.mapquest.com/" target="_blank">MapQuest</a> <img src="https://developer.mapquest.com/content/osm/mq_logo.png">', 'Map Quest');
	tiles.addTileLayer("http://{s}.mqcdn.com/tiles/1.0.0/sat/{z}/{x}/{y}.jpg", ['oatile1', 'oatile2', 'oatile3', 'oatile4'], '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>. Tiles courtesy of <a href="http://www.mapquest.com/" target="_blank">MapQuest</a> <img src="https://developer.mapquest.com/content/osm/mq_logo.png">', 'Map Quest Satellite', 19);

	var map = jsMaps.api.init(
		'#map',
		'native',
		{
			center: {
				latitude: 22.581548,
				longitude: 88.455631
			},
			zoom: 14.5,
			mouse_scroll: true,
			zoom_control: true,
			map_type: true
		}, tiles
	);
	async function fetchData() {
		const url = '../GetReaderServ';
		const response = await fetch(url);
		const datapoints = await response.json();
		console.log(datapoints);
		plotMap(datapoints.data);
	};

	function plotMap(data) {
		console.log(data);
		/*var marker1 = jsMaps.api.marker(map,{position: {lat: data[0].lat,lng: 88.447738}, title: 'Marker No 1',draggable: true});
		var infoWindow = jsMaps.api.infoWindow({content: "Test"});
		jsMaps.api.attach_event(marker1,'click',function() {
            infoWindow.open(map,marker1);
        });*/
		for (let i = 0; i < data.length; i++) {
			var position = new Object();
			position.lat = parseFloat(data[i].lat);
			position.lon = parseFloat(data[i].lon);
			var marker = new Object();
			marker.position = position;
			marker.title = data[i].address;
			marker.draggable = false;
			
			var marker1 = jsMaps.api.marker(map,{position: {lat:parseFloat(data[i].lat), lng:parseFloat(data[i].lon)}, title:data[i].address, draggable:false});
			var infoWindow = jsMaps.api.infoWindow({content: data[i].address});
			jsMaps.api.attach_event(marker1,'click',function() {
            	infoWindow.open(map,marker1);
        });
			console.log(marker);
		}
	}
	fetchData();
});