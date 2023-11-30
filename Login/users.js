function showFormLogin() {
    document.getElementById("main").innerHTML = `
        <input type="text" id="username" placeholder="username">
        <input type="password" id="password" placeholder="password">
        <button onclick="login()">Nhấn em đi</button>
    `
}

function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let userLogin = {
        username: username,
        password: password
    }

    axios.post("http://localhost:8080/login", userLogin).then(function (res) {
        localStorage.setItem("currentUser", JSON.stringify(res.data));
        showUsers()
    }).catch(function (err) {
        alert("Sai tài khoản mật khẩu bé ơi")
    })
}

function getCurrentUser() {
    return JSON.parse(localStorage.getItem("currentUser"))
}

function showUsers() {
    axios.get("http://localhost:8080/admin/users", {headers: {"Authorization": `Bearer ${getCurrentUser().accessToken}`}})
        .then(function (res) {
            document.getElementById("main").innerHTML = `<h1>Hello ${getCurrentUser().username}</h1>
            <button onclick="logout()">Logout</button>`;
            console.log(res.data)
        })
}

function logout() {
    localStorage.clear();
    showFormLogin();
}

if(getCurrentUser()){
   showUsers();
} else {
    showFormLogin()
}