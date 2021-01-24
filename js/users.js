function mostrarUsers() {
    $.ajax({
        url: '../test/users.json', //Cambiar
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (resp) {
            var div_results = document.getElementById("results-container");
            for (let result of resp) {
                console.log(result);
                console.log(div_results);
                var div_result = document.createElement('div');
                div_result.setAttribute('class', 'result');

                var h2 = document.createElement('h2');
                h2.setAttribute('class', 'entry-title');
                h2.innerText = result.name;

                var h3 = document.createElement('h3');
                h3.setAttribute('class', 'entry-title');
                h3.innerText = "Username: " + result.username;

                var p = document.createElement('p');
                p.setAttribute('class', 'entry-description');
                p.innerText = (result.rol).toUpperCase();

                var edit = document.createElement('a');
                var url = "../views/edit_info_user.html?key="+result.username;
                edit.setAttribute('href', url);
                edit.setAttribute('class', 'btn_edit');
                edit.innerText = "Editar";

                var a_delete = document.createElement('a');
                var funcion = "deleteUser('"+result.username+"','"+result.name+"')";
                a_delete.setAttribute('onclick', funcion);
                a_delete.setAttribute('class', 'btn_delete');
                a_delete.innerText = "Eliminar";

                div_result.appendChild(h2);
                div_result.appendChild(h3);
                div_result.appendChild(p);
                div_result.appendChild(edit);
                div_result.appendChild(a_delete);
                div_results.appendChild(div_result);
            }

        }
    });
}