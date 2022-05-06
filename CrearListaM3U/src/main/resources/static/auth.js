$(document).ready(function () {
   
    $('#modal-auth').modal('toggle');
    comprobarToken();
});

var direccion = "http://cosasbochi.ddns.net:80"
//var direccion = "http://localhost:80"

var json =[];


function comprobarToken() {
    if (localStorage.getItem('token') == null) {
        console.log("Entra en 1")
      login();
    }
    else {
    console.log("Entra en 2")
      load()  
    }
  }


function login(){
    $('#enviarFormulario').click(function(){
       var nombre = $('#nombre').val();
       var pass = $('#pass').val();
        json = { "nombre": nombre, "pass": pass };
        enviarDatosLogin();
    });
}

function enviarDatosLogin() {
    if (this.json != null) {
      $.ajax({
        url: direccion + "/login",
        type: "POST",
        data: JSON.stringify(json),
        contentType: "application/json; charset=UTF-8",
        
      }).done(function (data, textStatus, jqXHR) {
        if (data != null) {
          localStorage.setItem('token', data.pass);
          localStorage.setItem('rol', data.rol);
          $('#modal-auth').modal('hide');
          quitarErrores();
          $('#nombre').val('');
          $('#pass').val('');
          //Aqui se pide al usuario o usuarios dependiendo del rol que tiene
        }
        else{
            pintarErrores();
        }
  
      })
        .fail(function (jqXHR, textStatus, errorThrown) {
          pintarErrores();
          console.log("La solicitud a fallado: " + textStatus + ' son cosas que pasan');
  
        });
    } 
  }

  function load() {
      console.log('Entra en el load');
    $.ajax({
      url: direccion + "/load",
      type: "GET",
      headers: {
        "Authorization": localStorage.getItem('token')
      },
   
  
    }).done(function (data, textStatus, jqXHR) {
      if (data == true) {
        console.log('Es correcto el load' +  data);
          console.log('Entra para cerrar el modal')
        $('#modal-auth').modal('hide');
      }else{
        console.log('REtorno falso el load ' + data);
      }
  
    })
      .fail(function (jqXHR, textStatus, errorThrown) {
        pintarErrores();
        console.log("La solicitud a fallado: " + textStatus + ' son cosas que pasan');
  
      });
      
  }

  function pintarErrores() { //Private
    $('#MensajeErrorLogin').html('<p class="text-danger mt-2" id="textoError">DNI o Contraseña inválida</p>');
    $('#dni').css('border-color', 'red');
    $('#pass').css('border-color', 'red');
    recojerClickInput();
  }
  
  function quitarErrores() { //Private
    $('#textoError').remove();
  }

  function recojerClickInput() {
    $('#nombre').click(function () {
      quitarErrores()
    })
  
    $('#pass').click(function () {
      quitarErrores()
    })
  }

  
  