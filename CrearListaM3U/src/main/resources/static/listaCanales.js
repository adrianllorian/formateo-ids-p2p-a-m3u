$(document).ready(function () {
    //leerTexarea()
    verEnlaces();
    borrarCanales();
});


var direccion = "http://localhost:80";
var direccionDelServidorP2P ="http://localhost:8080";

/*
function leerTexarea(){
    $("#lista-acestream").keypress(function(e) {
        if(e.which == 13) {
           // Acciones a realizar, por ej: enviar formulario.
          var array = $('#lista-acestream').val().split(/\n/); 
          crearArrays(array);
        }
     });
}
function recogerLinkPorLevantarTecla(){
    $('#lista-acestream').keyup(function(){
        var array = $('#lista-acestream').val().split(/\n/); 
        crearArrays(array);
    })
}
*/
function verEnlaces(){
    $('#verCanales').click(function(){
        var array = $('#lista-acestream').val().split(/\n/); 
        crearArrays(array);
    });
    }

function borrarCanales(){
    $('#borrarCanales').click(function(){
        $('#listaCanales').empty();
        $('#lista-acestream').val('');
    })
}
function crearArrays(array){
   var arrayTitulo = []
   var arrayEnlace = []
   for(var i = 0; i< array.length; i++){
       if(i%2 == 0){ //Par
        arrayTitulo[arrayTitulo.length] = array[i]
       }
       else{ //Impar
        arrayEnlace[arrayEnlace.length] = array[i];
       }
   }
   pintarListaCaneles(arrayTitulo, arrayEnlace);
}

var almacen = [];
function pintarListaCaneles(arrayTitulo, ArrayEnlace){
    for (var i= 0; i< arrayTitulo.length; i++ ){
        var ListaCanales ={
            "titulo": arrayTitulo[i],
            "enlace": direccionDelServidorP2P + "/pid/" + ArrayEnlace[i]+ "/" + arrayTitulo[i].replace(/ /g, "").replace( "#", "") + ".mp4"
        }
        almacen[almacen.length]= ListaCanales;
        $('#listaCanales').append('<li class="lista"><a id="enlace" href="'+ direccionDelServidorP2P + '/pid/' + ArrayEnlace[i]+ '/' + arrayTitulo[i].replace(/ /g, "").replace( "#", "") + '.mp4">' + arrayTitulo[i] + '</a></li>');
    }  
    $('#listaCanales').append('<button id="guardarLista" class="mt-4 btn btn-dark">Crear</button><button id="cambiarLista" class="mt-4 btn btn-light">Añadir</button>')
    guardarLista(); 
    cambiarLista();
    copiarPortapapeles();
    
}


function copiarPortapapeles(){

    $('.enlaces').click(function(){
        var til = $(this).html();
        for(var i=0; i< almacen.length;i++){
            if(til == almacen[i].titulo){
                navigator.clipboard.writeText(almacen[i].enlace);
            }
        }
    })
       
    }

function guardarLista(){
    $("#guardarLista").click(function(){
        console.log(JSON.stringify(almacen))
        $.ajax({
            url: direccion +"/crearLista",
            type: "POST",
            data: JSON.stringify(almacen),
            contentType: "application/json; charset=UTF-8",
            headers: {
                "Authorization": localStorage.getItem('token')
              },
            /*
            headers: {
              "Authorization": localStorage.getItem('token')
            }
            */
          }).done(function (data, textStatus, jqXHR) {
            almacen.splice(0, almacen.length)
            if (data != null) {
              if (data == true) {
                alert("CORRECTO")
        
              }
              else if (data == false) {
                alert("La " + textStatus + " no ha sido guardado. Los datos de llegada son falsos")
              }
              else {
                alert("La " + textStatus + " no ha sido guardado")
              }
        
            }
        
          })
            .fail(function (jqXHR, textStatus, errorThrown) {
              console.log("La solicitud a fallado: " + textStatus + ' son cosas que pasan');
              almacen.splice(0, almacen.length)
        
            });
    })
}

     
function cambiarLista(){
    $("#cambiarLista").click(function(){
        console.log(JSON.stringify(almacen))
        $.ajax({
            url: direccion + "/anadirCanales",
            type: "POST",
            data: JSON.stringify(almacen),
            contentType: "application/json; charset=UTF-8",
            headers: {
                "Authorization": localStorage.getItem('token')
              },
            /*
            headers: {
              "Authorization": localStorage.getItem('token')
            }
            */
          }).done(function (data, textStatus, jqXHR) {
            almacen.splice(0, almacen.length)
            if (data != null) {
              if (data == true) {
                alert("CORRECTO")
        
              }
              else if (data == false) {
                alert("La " + textStatus + " no ha sido guardado")
              }
              else {
                alert("La " + textStatus + " no ha sido guardado")
              }
        
            }
        
          })
            .fail(function (jqXHR, textStatus, errorThrown) {
              console.log("La solicitud a fallado: " + textStatus + ' son cosas que pasan');
              almacen.splice(0, almacen.length)
        
            });
    })
}