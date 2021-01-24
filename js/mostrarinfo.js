function mostrarInfo(){
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const key = urlParams.get('key');
    const category = urlParams.get('category');

    if(category=="artist") showArtist(key, category);
    if(category=="album") showAlbum(key, category);
    if(category=="band") showBand(key, category);
    if(category=="song") showSong(key, category);
    if(category=="estudio") showEstudio(key, category);
    if(category=="musico") showMusico(key, category);
}

function showArtist(key, category){
    var elem = {
        "id": key,
        "type": category
    };

    var mostrar = JSON.stringify(elem);
    console.log(mostrar);

    //PETICION AJAX

    $.ajax({
        url: '../test/artist.json', //Cambiar
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            var result = document.getElementById("result");
            result.innerHTML = `
            <div class="container titulo">
                <h3>Informacion del artista</h3>
            </div>
            <br>
            <div class="container info">
                <div class="dato">
                    <h4><strong>Nombre: </strong> ${resp.nombre} </h4>
                </div>
                <div class="dato">
                    <h4><strong>Genero: </strong> ${resp.genero}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Fecha de nacimiento: </strong> ${resp.fechaNacimiento}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Ciudad de nacimiento: </strong> ${resp.cdNacimiento}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Biografia: </strong> </h4>
                    <p>${resp.biografia}</p>
                </div>
                <div class="dato">
                    <h4><strong>Sitio web: </strong> <a href="${resp.web}">${resp.web} </a></h4>
                </div>
            </div> 
            `;
        },
        data: mostrar
    });

}

function showAlbum(key, category){
    var elem = {
        "id": key,
        "type": category
    };

    var mostrar = JSON.stringify(elem);
    console.log(mostrar);

    //PETICION AJAX

    $.ajax({
        url: '../test/album.json', //Cambiar
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            var result = document.getElementById("result");
            result.innerHTML = `
            <div class="container titulo">
                <h3>Informacion del album</h3>
            </div>
            <br>
            <div class="container info">
                <div class="dato">
                    <h4><strong>Nombre del album: </strong> ${resp.nombre}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Fecha de lanzamiento: </strong> ${resp.fechaLanzamiento}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Banda: </strong> ${resp.banda}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Numero de pistas: </strong> ${resp.pistas}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Estudio de grabacion: </strong> ${resp.estudio}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Portada:</strong></h4>
                    <img src="${resp.portada}" alt="Imagen del album" class="album-portada">
                </div>
                <div class="dato">
                    <h4><strong>Contraportada:</strong></h4>
                    <!-- Imagenes de la bd-->
                    <img src="${resp.contraportada}" alt="Imagen del album" class="album-portada">
                </div>
            </div>
            `;
        },
        data: mostrar
    });

}

function showBand(key, category){
    var elem = {
        "id": key,
        "type": category
    };

    var mostrar = JSON.stringify(elem);
    console.log(mostrar);

    //PETICION AJAX

    $.ajax({
        url: '../test/band.json', //Cambiar
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            var result = document.getElementById("result");
            result.innerHTML = `
            <div class="container titulo">
                <h3>Informacion de la banda</h3>
            </div>
            <br>
            <div class="container info">
                <div class="dato">
                    <h4><strong>Nombre: </strong> ${resp.nombre}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Año de creacion: </strong> ${resp.anio}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Ciudad de creación: </strong> ${resp.ciudad}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Influencias: </strong> ${resp.influencias}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Artistas: </strong> ${resp.artistas}</h4>
                </div>
            </div>
            `;
        },
        data: mostrar
    });

}


function showSong(key, category){
    var elem = {
        "id": key,
        "type": category
    };

    var mostrar = JSON.stringify(elem);
    console.log(mostrar);

    //PETICION AJAX

    $.ajax({
        url: '../test/song.json', //Cambiar
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            var result = document.getElementById("result");
            result.innerHTML = `
            <div class="container titulo">
                <h3>Informacion de la cancion</h3>
            </div>
            <br>
            <div class="container info">
                <div class="dato">
                    <h4><strong>Banda: </strong> ${resp.compositor}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Fecha de lanzamiento: </strong> ${resp.fechaLanzamiento}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Nombre cancion: </strong> ${resp.nombre}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Duracion: </strong> ${resp.duracion} seconds</h4>
                </div>
                <div class="dato">
                    <h4><strong>Observaciones: </strong> ${resp.observaciones}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Invitados: </strong> ${resp.invitados.toString()}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Tablatura URL: </strong> <a href="${resp.tablatura_url}"> ${resp.tablatura_url}</a></h4>
                </div>
                <div class="dato">
                    <h4><strong>Tablatura compositor: </strong> ${resp.tablatura_compositor}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Tablatura fecha: </strong> ${resp.tablatura_fecha}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Tablatura traductor: </strong> ${resp.tablatura_traductor}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Traductor email: </strong> ${resp.tablatura_email}</h4>
                </div>
            </div>
            `;
        },
        data: mostrar
    });

}

function showEstudio(key, category){
    var elem = {
        "id": key,
        "type": category
    };

    var mostrar = JSON.stringify(elem);
    console.log(mostrar);

    //PETICION AJAX

    $.ajax({
        url: '../test/estudio.json', //Cambiar
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            var result = document.getElementById("result");
            var titulo = document.createElement('div');
            titulo.setAttribute('class', 'container titulo');
            var h3 = document.createElement('h3');
            h3.innerText = "Informacion del estudio";
            titulo.appendChild(h3);

            var info = document.createElement('div');
            info.setAttribute('class', 'container info');

            var nombre = document.createElement('div');
            nombre.setAttribute('class', 'dato');
            nombre.innerHTML = "<h4><strong>Nombre: </strong> "+ resp.nombre +"</h4>"

            var direccion = document.createElement('div');
            direccion.setAttribute('class', 'dato');
            direccion.innerHTML = "<h4><strong>Direccion: </strong> "+ resp.direccion +"</h4>"

            var telefono = document.createElement('div');
            telefono.setAttribute('class', 'dato');
            telefono.innerHTML = "<h4><strong>Telefono: </strong> "+ resp.telefono +"</h4>"

            var web = document.createElement('div');
            web.setAttribute('class', 'dato');
            web.innerHTML = "<h4><strong>Sitio web: </strong> "+ resp.web +"</h4>"

            info.appendChild(nombre);
            info.appendChild(direccion);
            info.appendChild(telefono);
            info.appendChild(web);

            result.appendChild(titulo);
            result.appendChild(info);
        },
        data: mostrar
    });

}

function showMusico(key, category){
    var elem = {
        "id": key,
        "type": category
    };

    var mostrar = JSON.stringify(elem);
    console.log(mostrar);

    //PETICION AJAX

    $.ajax({
        url: '../test/musico.json', //Cambiar
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            var result = document.getElementById("result");
            result.innerHTML = `
            <div class="container titulo">
                <h3>Informacion del musico</h3>
            </div>
            <br>
            <div class="container info">
                <div class="dato">
                    <h4><strong>Nombre: </strong> ${resp.nombre}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Instrumento: </strong> ${resp.instrumento}</h4>
                </div>
                <div class="dato">
                    <h4><strong>Ciudad de nacimiento: </strong> ${resp.cdNacimiento}</h4>
                </div>
            </div>
            `;
        },
        data: mostrar
    });

}