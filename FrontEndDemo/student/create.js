function showFormCreate() {
    document.getElementById("main").innerHTML = `
    <div>
        <input type="text" id="name" placeholder="Name">
        <input type="text" id="age" placeholder="Age">
        <input type="text" id="email" placeholder="Email">
        <input type="text" id="idClassRoom" placeholder="ClassRoom">
        <input type="file" id="fileButton" onchange="uploadImage(event)">
        <input type="hidden" id="image" value="">
        <div id="imgDiv"></div>
        <button onclick="create()">Nhấp</button>
    </div>
    `
}

function create() {
    let name = document.getElementById("name").value;
    let age = document.getElementById("age").value;
    let email = document.getElementById("email").value;
    let idClassRoom = document.getElementById("idClassRoom").value;
    let image = document.getElementById("image").value;

    let student = {
        name: name,
        age: age,
        email: email,
        image: image,
        classRoom: {
            id: idClassRoom
        }
    }
    console.log(student);

    axios.post('http://localhost:8080/students', student)
        .then(function (response) {
            getAll()
        })
}

function uploadImage(e) {
    let fbBucketName = 'images';
    let uploader = document.getElementById('uploader');
    let file = e.target.files[0];
    let storageRef = firebase.storage().ref(`${fbBucketName}/${file.name}`);
    let uploadTask = storageRef.put(file);
    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,
        function (snapshot) {
            uploader.value = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            switch (snapshot.state) {
                case firebase.storage.TaskState.PAUSED:
                    break;
                case firebase.storage.TaskState.RUNNING:
                    break;
            }
        }, function (error) {
            switch (error.code) {
                case 'storage/unauthorized':
                    break;
                case 'storage/canceled':
                    break;
                case 'storage/unknown':
                    break;
            }
        }, function () {
            let downloadURL = uploadTask.snapshot.downloadURL;
            console.log(downloadURL)
            document.getElementById('imgDiv').innerHTML = `<img src="${downloadURL}" alt="">`
            document.getElementById("image").value = downloadURL;
        });
}