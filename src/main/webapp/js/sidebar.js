function setSidebarParams(data){
	for (let i = 0; i < data.length; i++) {
		console.log(data[i].type_id.toString());
		var element = document.getElementById(data[i].type_id.toString());
		var liNode = document.createElement("li");
		var aNode = document.createElement("a");
		aNode.innerHTML = data[i].vehicle_no;
		aNode.href = "#";
		aNode.className = "link-dark rounded";
		liNode.append(aNode);
		element.appendChild(liNode);
		
	}
}


fetch('http://localhost:8080/GetVehiclesServ')
  .then((response) => response.json())
  .then((data) => {setSidebarParams(data.data)});
  