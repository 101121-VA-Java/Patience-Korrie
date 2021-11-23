$('.popover-dismiss').popover({
    trigger: 'hover'
  })


  document.getElementById("logout").addEventListener('click', LogOut);

  function LogOut(){
      sessionStorage.clear();
      window.location.href = "login.html";
  }

  let api = 'http://localhost:8080';

  function receiveData() {
    // what to be done once the data is ready
    if (xhr.readyState === 4) {
        let dataSpan = document.getElementById('data');
         // Resets the innerHTML for every request
        dataSpan.innerHTML = '';
        if (xhr.status >= 200 && xhr.status < 300) {
            let response = xhr.response;

            // Converting JSON data to JS object
            response = JSON.parse(response);

            // data processing behavior
            populateData(response);







  function populateEmp(response){
    for(var i = 0; i< response)


    let first_name = response.firstName;
    let last_name = response.lastName;
    let role = response.role[1][1];//ask about this

    document.getElementById("empData").innerHTML = " ";
    let nameTag = document.createElement('tr'); 
   nameTag.innerHTML = response.name.toUpperCase();
  }

  // let token = sessionStorage.getItem("token");

  // if (token) {
  //   let tokenArr = token.split(':');
  //   let id = tokenArr[0];
  //   let role = tokenArr[1];