function showFormCreate(){
    document.getElementById("main").innerHTML = `
    <div>
        <input type="text" id="name" placeholder="Name">
        <input type="text" id="age" placeholder="Age">
        <input type="text" id="email" placeholder="Email">
        <input type="text" id="idClassRoom" placeholder="ClassRoom">
        <button onclick="create()">Nhấp</button>
    </div>
    `
}

function create() {
    let name = document.getElementById("name").value;
    let age = document.getElementById("age").value;
    let email = document.getElementById("email").value;
    let idClassRoom = document.getElementById("idClassRoom").value;

    let student = {
        name: name,
        age: age,
        email: email,
        classRoom: {
            id: idClassRoom
        }
    }

    axios.post('http://localhost:8080/students', student)
        .then(function (response) {
            getAll()
        })
}