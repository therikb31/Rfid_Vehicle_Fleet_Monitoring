function setMostUsedReader(data){
	var element = document.getElementById("mostUsedReader");
	element.innerHTML = "Reader ID: <b>"+data.reader_id+"</b><br/>"+
						"Address: <b>"+data.address+"</b><br/>"+
						"Latitude: <b>"+data.lat+"</b><br/>"+
						"Longitude: <b>"+data.lon+"</b><br/>"+
						"Activity: <b>"+data.activity+"</b><br/>";
}
function setLeastUsedReader(data){
	console.log(data);
	for(i=0;i<data.length;i++){
		var card = document.createElement("div");
		card.className = "col card";
		card.style="width: 18rem; margin: 20px; padding: 0px;";
		
		var card_header = document.createElement("h5");
		card_header.innerText="Least Used Reader";
		card_header.className="card-header";
		card.appendChild(card_header);
		
		var card_body = document.createElement("div");;
		card_body.className = "card-body"
		var card_text = document.createElement("p");
		card_text.className = "card-text";
		card_text.innerHTML = "Reader ID: <b>"+data[i].reader_id+"</b><br/>"+
						"Address: <b>"+data[i].address+"</b><br/>"+
						"Latitude: <b>"+data[i].lat+"</b><br/>"+
						"Longitude: <b>"+data[i].lon+"</b><br/>"+
						"Activity: <b>"+data[i].activity+"</b><br/>";
		card_body.appendChild(card_text);
		card_header.appendChild(card_body);
		card.appendChild(card_header);
		document.body.appendChild(card);
	}
}
$(document).ready(function() {
	fetch('http://localhost:8080/MostUsedReaderAlert')
		.then((response) => response.json())
		.then((data) => { setMostUsedReader(data.data) });
	fetch('http://localhost:8080/LeastUsedReaderAlert')
		.then((response) => response.json())
		.then((data) => {setLeastUsedReader(data.data) });
});
