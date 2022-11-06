fetch('http://localhost:8080/GetVehiclesServ')
  .then((response) => response.json())
  .then((data) => console.log(data));
