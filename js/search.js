function Search(event){

    event.preventDefault();
    
    var xhttp = new XMLHttpRequest();

    var errordiv = document.getElementById('error-msg');

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            errordiv.style.display="none"
            var results = JSON.parse(this.responseText);
            var results_container = document.getElementById('results-container');
            while (results_container.firstChild) {
                results_container.removeChild(results_container.firstChild);
            }
            for(let result of results) {
                var a_box = document.createElement('a');
                a_box.setAttribute('href', '../views/show_info.html?key='+result.id+'&category='+result.type.toLowerCase());
                a_box.setAttribute('class', 'result-link');
                
                var div_cont = document.createElement('div');
                div_cont.setAttribute('class', 'result');

                var title = "";

                if(result.name!=null) title = result.name + " - " + result.artist;
                else title = result.artist;

                var h2_name = document.createElement('h2');
                h2_name.setAttribute('class', 'entry-title');
                h2_name.innerText= title;

                var p_category = document.createElement('p');
                p_category.setAttribute('class', 'entry-description');
                p_category.innerText= result.type;

                div_cont.appendChild(h2_name);
                div_cont.appendChild(p_category);
                a_box.appendChild(div_cont);
                results_container.appendChild(a_box);
            }
        }
    };

    var searchterm = document.getElementById('searchText').value.replace(/ /g,"+"); //Eliminamos los espacios y los cambiamos por +
    
    var category = document.getElementById('category').value;
    
    if(searchterm=="" || category=="empty"){
        errordiv.style.display="block";
        console.log("Checa tus datos");
        return;
    }
    var path_get = "search" //Cambiar por la ruta donde haremos la peticion get
    var requestdir = path_get +"?key="+searchterm.toLowerCase()+"&type="+category;
    console.log(requestdir);
    xhttp.open("GET", '../test/response.json', true);
    xhttp.send();
}