// $('.popover-dismiss').popover({
//     trigger: 'hover'
//   })


let token = sessionStorage.getItem("token");

 let apiUrl = 'http://localhost:8080/employee/' + token.split(':')[0];

  if(!token || token.split(":")[1] === "2"){
    window.location.href = "login.html";
  }else{
    document.getElementById('send1').addEventListener('click', createRqt);
    // document.getElementById('optt2').addEventListener('click', pendinRqt);
    // document.getElementById('optt3').addEventListener('click', resolvedRqt);
    populateT();
  }


  function getEmp(){
    apiUrl = 'http://localhost:8080/employee/';
    populateT();
  }

  async function populateT(){
    let response = await fetch(apiUrl, {
      headers: {
          'Authorization': token 
        }
    });

    let employee = await response.json();
    
  
        if(employee.id == token.split(':')[0] ){
            document.getElementById('fName').innerHTML= employee.firstName;
            document.getElementById('lName').innerHTML= employee.lastName;
            document.getElementById('username2').innerHTML= employee.username;
            document.getElementById('email2').innerHTML= employee.email;
            document.getElementById('password2').innerHTML= "....";
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



let response = await fetch('http://localhost:8080/employee/update', {
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

  async function createRqt(){
    let amount = document.getElementById("reimb-amount").value;
    let description = document.getElementById("exampleFormControlTextarea2").value;
    let type = document.getElementById("inputGroupSelect01").value;
    let author = sessionStorage.token.split(":")[0];
    let newReimb = {author, amount, description, type};

    let response = await fetch('http://localhost:8080/reimb/request', {
      method: 'POST',
      headers: {
          'Authorization': token
      },
      body: JSON.stringify(newReimb)
  });

  if(response.status == 201){
    document.getElementById('suss').innerHTML='Reimbursement was successfully added!';
} else {
    document.getElementById('error').innerHTML='could not make request'
}

  
  }
    
  