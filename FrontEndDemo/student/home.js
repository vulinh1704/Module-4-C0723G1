function getAll() {
    axios.get('http://localhost:8080/students')
        .then(function (response) {
            let students = response.data;
            let html = `
             <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Class</th>
                    <th colspan="2">Action</th>
                </tr>
            `;
            for (let i = 0; i < students.length; i++) {
                html += `<tr>
                    <td>${students[i].id}</td>
                    <td>${students[i].name}</td>
                    <td>${students[i].age}</td>
                    <td>${students[i].email}</td>
                    <td>${students[i].classRoom.name}</td>
                    <td><button>Sửa</button></td>
                    <td><button onclick="remove(${students[i].id})">Xóa</button></td>
                </tr>`
            }
            html += `</table>`
            document.getElementById("main").innerHTML = html;
        })
}

getAll();

function remove(id) {
    let isConfirm = confirm("Are you OK?");
    if (isConfirm) {
        axios.delete('http://localhost:8080/students/' + id)
            .then(function (respone) {
                alert("Xóa thành công")
                getAll();
            })
    } else {
        alert("Are you rảnh?")
    }
}

function search() {
    let name = document.getElementById("q").value;
    if (name === "") {
        getAll();
    } else {
        axios.get('http://localhost:8080/students/search?name=' + name)
            .then(function (response) {
                let students = response.data;
                let html = `
             <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Class</th>
                    <th colspan="2">Action</th>
                </tr>
            `;
                for (let i = 0; i < students.length; i++) {
                    html += `<tr>
                    <td>${students[i].id}</td>
                    <td>${students[i].name}</td>
                    <td>${students[i].age}</td>
                    <td>${students[i].email}</td>
                    <td>${students[i].classRoom.name}</td>
                    <td><button>Sửa</button></td>
                    <td><button onclick="remove(${students[i].id})">Xóa</button></td>
                </tr>`
                }
                html += `</table>`
                document.getElementById("main").innerHTML = html;
            })
    }
}