function deleteSong(index, type, name_search, artist) {

    var title = "";
    if (name_search != "null") title = name_search + " - " + artist + "( " + type + " )";
    else title = artist + "( " + type + " )";

    var pos = document.getElementById("detalles_cancion");
    pos.innerHTML = '';
    var nodo = document.createTextNode(title.toUpperCase());
    pos.appendChild(nodo);
    var btn_delete = document.getElementById("dodelete");
    btn_delete.setAttribute('onclick', 'commitDelete(' + index + ',"' + type.toLowerCase()+'")');
    
    $("#deleteModal").modal();
}

//Para borrar canciones, musicos, banda, etc
function commitDelete(index, type) {
    console.log("Borrando dato con index = "+index+ " y tipo= "+ type);
    var elem = {
        id: index,
        type: type
    };

    var todelete = JSON.stringify(elem);
    console.log(todelete);

    //PETICION AJAX

    $.ajax({
        url: 'ruta', //Cambiar
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            if(resp.success){
                console.log("OK");
            }else{
                console.log("ERROR");
            }
        },
        data: todelete
    });
}

function searchAdmin(event) {

    event.preventDefault();

    var xhttp = new XMLHttpRequest();

    var errordiv = document.getElementById('error-msg');

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            errordiv.style.display = "none"
            var results = JSON.parse(this.responseText);
            var results_container = document.getElementById('results-container');
            while (results_container.firstChild) {
                results_container.removeChild(results_container.firstChild);
            }
            for (let result of results) {
                var a_box = document.createElement('a');
                a_box.setAttribute('href', '../views/show_info.html?key=' + result.id + '&category=' + result.type.toLowerCase());
                a_box.setAttribute('class', 'result-link');

                var div_cont = document.createElement('div');
                div_cont.setAttribute('class', 'result');

                var title = "";

                if (result.name != null) title = result.name + " - " + result.artist;
                else title = result.artist;

                var h2_name = document.createElement('h2');
                h2_name.setAttribute('class', 'entry-title');
                h2_name.innerText = title;

                var p_category = document.createElement('p');
                p_category.setAttribute('class', 'entry-description');
                p_category.innerText = result.type;
                
                var categoria = result.type.toLowerCase();
                var ruta;
                if(categoria=="artist") ruta= "update_artista.html";
                if(categoria=="album") ruta= "update_album.html";
                if(categoria=="band") ruta= "update_banda.html";
                if(categoria=="song") ruta= "update_cancion.html";
                if(categoria=="musico") ruta= "update_musico.html";
                if(categoria=="estudio") ruta= "update_estudio.html";                if(categoria=="banda") ruta= "update_banda.html";
                var a_edit = document.createElement('a');
                a_edit.setAttribute('href', '../views/'+ ruta + '?key=' + result.id);
                a_edit.innerText = "Editar";
                a_edit.setAttribute('class', 'btn_edit');

                var btn_delete = document.createElement('a');
                btn_delete.setAttribute('onclick', 'deleteSong(' + result.id + ',"' + result.type.toLowerCase() + '", "' + result.name + '","' + result.artist + ' ")');
                btn_delete.setAttribute('href', '#');
                btn_delete.innerText = "Eliminar";
                btn_delete.setAttribute('class', 'btn_delete');

                div_cont.appendChild(h2_name);
                div_cont.appendChild(p_category);
                div_cont.appendChild(a_edit);
                div_cont.appendChild(btn_delete);
                a_box.appendChild(div_cont);
                results_container.appendChild(a_box);
            }
        }
    };

    var searchterm = document.getElementById('searchText').value.replace(/ /g, "+"); //Eliminamos los espacios y los cambiamos por +

    var category = document.getElementById('category').value;

    if (searchterm == "" || category == "empty") {
        errordiv.style.display = "block";
        console.log("Checa tus datos");
        return;
    }
    var path_get = "search_admin" //Cambiar por la ruta donde haremos la peticion get
    var requestdir = path_get + "?key=" + searchterm.toLowerCase() + "&type=" + category; //Enviamos el texto busqueda y la categoria
    console.log(requestdir);
    xhttp.open("GET", '../test/response.json', true);
    xhttp.send();
}

function deleteUser(index, name_user) {

    var title = name_user;

    var pos = document.getElementById("detalles_user");
    pos.innerHTML = '';
    var nodo = document.createTextNode(title.toUpperCase());
    pos.appendChild(nodo);
    var btn_delete = document.getElementById("dodelete");
    btn_delete.setAttribute('onclick', 'commitDeleteUser('+index+')');
    $("#deleteModal").modal();
}


//Para eliminar usuarios admin/locutor
function commitDeleteUser(index) {
    var user = {
        id: index
    };

    var todelete = JSON.stringify(user);
    console.log(todelete);

    //PETICION AJAX

    $.ajax({
        url: 'ruta', //Cambiar
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            if(resp.success){
                console.log("OK");
            }else{
                console.log("ERROR");
            }
        },
        data: todelete
    });
}