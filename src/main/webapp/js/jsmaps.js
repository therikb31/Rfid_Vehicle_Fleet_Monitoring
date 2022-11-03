jsMaps.loader(function (){
        var tiles = new jsMaps.Native.Tiles();
tiles.addTileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png",['a','b','c'],'&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>.','OpenStreetMap');
tiles.addTileLayer("http://{s}.mqcdn.com/tiles/1.0.0/map/{z}/{x}/{y}.png",['otile1','otile2','otile3','otile4'],'&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>. Tiles courtesy of <a href="http://www.mapquest.com/" target="_blank">MapQuest</a> <img src="https://developer.mapquest.com/content/osm/mq_logo.png">','Map Quest');
tiles.addTileLayer("http://{s}.mqcdn.com/tiles/1.0.0/sat/{z}/{x}/{y}.jpg",['oatile1','oatile2','oatile3','oatile4'],'&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap contributors</a>. Tiles courtesy of <a href="http://www.mapquest.com/" target="_blank">MapQuest</a> <img src="https://developer.mapquest.com/content/osm/mq_logo.png">','Map Quest Satellite',19);

        var map = jsMaps.api.init(
                '#map',
                'native',
                {
                    center: {
                        latitude: 22.5726,
                        longitude: 88.3639
                    },
                    zoom: 12,
                    mouse_scroll: true,
                    zoom_control: true,
                    map_type: true
                },tiles
        );
    });