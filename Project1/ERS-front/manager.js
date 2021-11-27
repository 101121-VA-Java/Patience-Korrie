// $('.popover-dismiss').popover({
//     trigger: 'hover'
//   })


let token = sessionStorage.getItem("token");




let apiUrl = "http://localhost:8080/manager/employees";

  if(!token || token.split(":")[1] === "1"){
    window.location.href = "login.html";
  }else{
    // document.getElementById('opt1').addEventListener('click', pendReqt);
    // document.getElementById('opt2').addEventListener('click', resolvedReqt);
    document.getElementById('opt3').addEventListener('click', emps);

    populateT();

  }

  // function pendReqt(){
  //   apiUrl = 'localhost:8080/manager/employees';
  //   populateEmp();
  // }

  // function resolvedReqt(){
  //   apiUrl = 'localhost:8080/manager/employees';
  //   populateEmp();
  // }

  function emps(){
    apiUrl = 'http://localhost:8080/manager/employees';
    populateT();
  }

  

  async function populateT(){
    let response = await fetch(apiUrl, {
      headers: {
          'Authorization': token
      }
  });

  let employees = await response.json();

  let tableBody = document.getElementById('empData');

  tableBody.innerHTML = '';

  for (i of employees) {
    if(i.id == token.split(':')[0] ){
      document.getElementById('fName').innerHTML= i.firstName;
      document.getElementById('lName').innerHTML= i.lastName;
      document.getElementById('username2').innerHTML= i.username;
      document.getElementById('email2').innerHTML= i.email;
      document.getElementById('password2').innerHTML= "....";
    }

    let row = document.createElement('tr');

    let firstnameTd = document.createElement('td');
    firstnameTd.innerHTML = i.firstName;

    let lastnameTd = document.createElement('td');
    lastnameTd.innerHTML = i.lastName;

    let usernameTd = document.createElement('td');
    usernameTd.innerHTML = i.username;

    let roleTd = document.createElement('td');
    roleTd.innerHTML = i.role.role;

    row.appendChild(firstnameTd);
    row.appendChild(lastnameTd);
    row.appendChild(usernameTd);
    row.appendChild(roleTd);
    tableBody.appendChild(row);

    }
}


document.getElementById('update-button').addEventListener('click', updateEmployee);

async function updateEmployee(){
  let FirstName = document.getElementById('floatingInput1').value;
  let LastName = document.getElementById('floatingInput4').value;
  let UserName = document.getElementById('floatingInput5').value;
  let password = document.getElementById('floatingInput3').value;
  let email = document.getElementById('floatingInput2').value;


  let updatedEmployee = {
    firstName : FirstName,
    lastName : LastName,
    email : email,
    username : UserName,
    password : password
  }



let response = await fetch('http://localhost:8080/manager/update', {
        method: 'PUT',
        headers: {
            'Authorization': token
        },
        body: JSON.stringify(updatedEmployee)
    });

    if(response.status == 200){
        window.location.reload();
    } else {
        document.getElementById('error').innerHTML='Unable to update employee.'
    }
  }
    
  
  
  
  document.getElementById("logout").addEventListener('click', LogOut);

  function LogOut(){
      sessionStorage.clear();
      window.location.href = "login.html";
  }

 
 