function validarvacio(campo, msj_vacio) {
    if (campo == "") {
        Swal.fire({
            icon: 'error',
            title: "Advertencia",
            text: msj_vacio
        });
        throw 'exit';
    }
}

function validarconfirm(password, confirm) {
    if (password != confirm) {
        Swal.fire({
            icon: 'error',
            text:"La confirmación no coincide con la contraseña ingresada"
        });
        throw 'exit';
    }
}

function Validar(email, callbackFunction){
    $.ajax({
        url: "http://localhost:8081/user/all",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            //console.log(respuesta);
            callbackFunction(email, respuesta);
        }
    });   
}    

function ListaUsuarios(email, respuesta){

    listusers=[];       
    for (i = 0; i < respuesta.length; i++) {
        listusers.push(respuesta[i].email);
    }
    //console.log(listusers);
    u = email;
    //console.log(u);
    if (listusers.includes(u) && u!=null) {
        Swal.fire({
            icon: 'error',
            text:"El email ya se encuentra registrado"
        });
        throw 'exit';
    }else{
        NuevoUsuario();
    }
}

function idusuario(email, respuesta){
    
    listemails=[];       
    for (i = 0; i < respuesta.length; i++) {
        listemails.push(respuesta[i].email);
    }
    id = listemails.indexOf(email)+1;
    localStorage.setItem("idnewuser", id);
    //console.log(localStorage.getItem("idnewuser"));
}

function NuevoUsuario() {
   
    validarvacio($("#name").val(), "Debe ingresar un nombre");
    validarvacio($("#email").val(), "Debe ingresar un e-mail");
    validarvacio($("#password").val(), "Debe ingresar una contraseña");
    validarvacio($("#confirm").val(), "Por favor confirme su contraseña");
    validarconfirm($("#password").val(), $("#confirm").val());

    clave=Encrypt($("#password").val());

    let myData = {
        name: $("#name").val(),
        password: clave,
        email: $("#email").val().toLowerCase(),
        tblroles: {idrol: 3}
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8081/user/new",
        type: "POST",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            //console.log(respuesta);
            $("#name").val("");
            $("#email").val("");
            $("#password").val("");
            $("#confirm").val("");
            document.getElementById("formregistro").setAttribute("hidden", "true");
            document.getElementById("h2registro").setAttribute("hidden", "true");
            document.getElementById("linkdatoscliente").removeAttribute("hidden");
            document.getElementById("linksign3").removeAttribute("hidden");
        }
    });
    
}

function guardarUsuario(){
    Validar($("#email").val().toLowerCase(), ListaUsuarios);
    localStorage.setItem("emailnewuser", $("#email").val().toLowerCase());  
    localStorage.setItem("namenewuser", $("#name").val());  
}
     

function ValidarUsuario(email){
    let myData = email;
    validarvacio($("#uemail").val(), "Debe ingresar un e-mail");
    $.ajax({
        url: "http://localhost:8081/user/" + myData,
        type: "GET",
        data: myData,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            //console.log(respuesta);
            if (respuesta == false) {
                Swal.fire({
                    icon: 'error',
                    text:"Usuario no existe en la base de datos"
                });
            } 
        }
    });
}



function Autenticacion(email, password) {
    ValidarUsuario(email);
    var hash = md5(password);
    console.log(hash); 
    validarvacio($("#uemail").val(), "Debe ingresar un e-mail");
    validarvacio($("#upassword").val(), "Debe ingresar una contraseña valida");
    $.ajax({
        url: "http://localhost:8081/user/" + email + "/" + hash,
        type: "GET",
        data: email + "/" + password,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            //console.log(respuesta);
            $("#uemail").val("");
            $("#upassword").val("");
            if (respuesta.name == "NO DEFINIDO") {
                Swal.fire({
                    icon: 'error',
                    text: "Usuario o clave incorrectos"
                });
            } else {
                localStorage.setItem("idusuariologin", respuesta.id);
                localStorage.setItem("nameusuariologin", respuesta.name);
                localStorage.setItem("emailusuariologin", respuesta.email);
                document.getElementById("formlogin").setAttribute("hidden", "true");
                document.getElementById("titulologin").setAttribute("hidden", "true");
                document.getElementById("welcome").removeAttribute("hidden");
                document.getElementById("welcome").innerHTML="Bienvenido "+respuesta.name+". Ahora puede reservar locaciones! ";
                mostrarnavbar();
                setTimeout(window.location.href = "reserva.html", 120000);
            }

        }
    });
}

function validarcliente(NIT){
    let myData = NIT;
    validarvacio($("#NIT").val(), "Debe ingresar un numero de identificación");
    $.ajax({
        url: "http://localhost:8081/customer/" + myData,
        type: "GET",
        data: myData,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            //console.log(respuesta);
            if (respuesta == true) {
                Swal.fire({
                    icon: 'error',
                    text:"El cliente ya se encuentra registrado en la base de datos, inicie sesión con sus credenciales"
                });
            } 
        }
    });
}

function guardarcliente(){
   
    validarcliente($("#NIT").val());          
    validarvacio($("#NIT").val(), "Debe ingresar un numero de identificación");
    validarvacio($("#tel").val(), "Debe ingresar un numero de contacto");
    validarvacio($("#direcc").val(), "Debe ingresar una dirección");
    validarvacio($("#ciudad").val(), "Elija un valor para la ciudad");
    validarvacio($("#tipoID").val(), "Elija un valor para tipo de documento");
     
    Validar(localStorage.getItem("emailnewuser"), idusuario);

    var fecha=horalocal(new Date()).toISOString(); 
    
    let myData = {
        nit: $("#NIT").val(),
        name: localStorage.getItem("namenewuser"),
        tel: $("#tel").val().toLowerCase(),
        direccion: $("#direcc").val(),
        fechareg: fecha,
        tblciudad:{idciudad: parseInt($("#ciudad").val())},
        tblusuarios:{id: parseInt(localStorage.getItem("idnewuser"))},
        tbltipoid:{idtipoid: parseInt($("#tipoID").val())}        
    };
    let dataToSend = JSON.stringify(myData);
    //console.log(dataToSend);
    $.ajax({
        url: "http://localhost:8081/customer/new",
        type: "POST",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            //console.log(respuesta);
            $("#name").val("");
            $("#email").val("");
            $("#password").val("");
            $("#confirm").val("");
            $("#NIT").val("");
            $("#tel").val("");
            $("#direcc").val("");
            $("#ciudad").val("");
            $("#tipoID").val("");
            Swal.fire("se ha guardado el cliente", '',"success");
            document.getElementById("formregistro2").setAttribute("hidden", "true");
            document.getElementById("linksign2").removeAttribute("hidden");
            localStorage.removeItem("idnewuser");
            localStorage.removeItem("namenewuser");
            localStorage.removeItem("emailnewuser");
        }
    });
}

function Encrypt(password){
    var hash = md5(password);
    return hash;
}

function cambiarimg(src){
    var loc = document.getElementById('image1');
    loc.removeAttribute("src");
    loc.setAttribute("src", src);

    var nombreloc = document.getElementById('nombreloc');
    var nombre = src.replace(".jpg", "").replace(".jpeg", "").replace("img/", "");
    nombreloc.innerHTML =  src.replace(".jpg", "").replace(".jpeg", "").replace("img/", "");

    let myData = nombre;
    $.ajax({
        url: "http://localhost:8081/location/" + nombre,
        type: "GET",
        data: myData,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            var descriploc = document.getElementById('descrip_loc');
            if (respuesta===null){
                descriploc.innerHTML ="";    
            }
            else{
                descriploc.innerHTML = "<b>"+respuesta.descriplocacion+"</b>";
            }
        }
    });
}

function guardarmsjpqrs(){
    validarvacio($("#name").val(), "Debe ingresar un nombre");
    validarvacio($("#email").val(), "Debe ingresar un e-mail");
    validarvacio($("#message").val(), "Por favor ingrese su mensaje");
    validarvacio($("#tipopqrs").val(), "Por favor seleccione un tipo de mensaje");

    var fecha=horalocal(new Date()).toISOString(); 
    let myData = {};
    
    if (localStorage.getItem("idcliente") !== null){
        validarvacio($("#locacion").val(), "Por favor seleccione la locacion con la que se relaciona su solicitud");
        myData = {
            pqrsNombre: $("#name").val(),
            pqrsEmail: $("#email").val().toLowerCase(),
            mensaje: $("#message").val(),
            tipo: $("#tipopqrs").val(),
            fechapqr: fecha,
            tblclientes:{idCliente:localStorage.getItem("idcliente")},
            tbllocaciones:{idlocacion: parseInt($("#locacion").val())}
        };
    
    }    
    else if ($("#locacion").val()===""){   
        myData = {
            pqrsNombre: $("#name").val(),
            pqrsEmail: $("#email").val().toLowerCase(),
            mensaje: $("#message").val(),
            tipo: $("#tipopqrs").val(),
            fechapqr: fecha
        };
    }
    else{
        myData = {
            pqrsNombre: $("#name").val(),
            pqrsEmail: $("#email").val().toLowerCase(),
            mensaje: $("#message").val(),
            tipo: $("#tipopqrs").val(),
            fechapqr: fecha.substring(0,10),
            tbllocaciones:{idlocacion: parseInt($("#locacion").val())}
        };
    }

    let dataToSend = JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url: "http://localhost:8081/pqrs/new",
        type: "POST",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            $("#name").val("");
            $("#email").val("");
            $("#message").val("");
            $("#tipopqrs").val("");
            $("#locacion").val("");
            Swal.fire("Mensaje enviado con exito!",'',"success");  
        }
    });
}

function MostrarLocaciones(){
    $.ajax({
        url: "http://localhost:8081/location/all",
        type: "GET",
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            const $locaciones = $("#locacion");
            
            for (i = 0; i < respuesta.length; i++) {
                $locaciones.append($("<option>", {value: respuesta[i].idlocacion, text: respuesta[i].nombrelocacion}))
            };
            
        }
    });
}


function guardarreserva(){
    validarvacio($("#date").val(), "Debe ingresar una fecha para la reserva");
    validarvacio($("#time").val(), "Debe ingresar una hora para la reserva");
    validarvacio($("#guests").val(), "Por favor ingrese un numero de personas");
    validarvacio($("#locacion").val(), "Por favor elija una locación para el evento");

    var fechapedido=horalocal(new Date()).toISOString(); 
    var fechareserva=horalocal(new Date($("#date").val()), "suma").toISOString(); 
    let myData = {        
        fechapedido: fechapedido,
        fechareserva: fechareserva,
        estado: "Reservado",
        tblclientes:{idCliente: localStorage.getItem("idcliente")},
        comentarios: $("#comments").val(), 
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8081/reserva/new",
        type: "POST",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            $("#date").val("");  
        }
    });

    obteneridpedido();
    let idped = localStorage.getItem("idpedido");
    var fechahorareserva=new Date($("#date").val() + " " +$("#time").val()); 

    let myData2 = {    
        pedido:{idpedido: parseInt(idped)},
        locacion:{idlocacion: parseInt($("#locacion").val())},
        numpersonas: parseInt($("#guests").val()),
        valor_pedido: 1000000,
        valor_pagado: 0,
        hora_reserva: fechahorareserva.toLocaleTimeString()
    };

    let dataToSend2 = JSON.stringify(myData2);
    $.ajax({
        url: "http://localhost:8081/reserva/details/new",
        type: "POST",
        data: dataToSend2,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            $("#time").val("");
            $("#guests").val("");
            $("#location").val("");
            Swal.fire("Reserva guardada con exito!",'',"success");  
            localStorage.removeItem("idpedido");
        }
    });

    

}


function obtenerdatosusuario(){
    
    $("#name").val(localStorage.getItem("nameusuariologin"));
    $("#email").val(localStorage.getItem("emailusuariologin"));

    let mydata=localStorage.getItem("idusuariologin");
    $.ajax({
        url: "http://localhost:8081/customer/userid/" + mydata,
        type: "GET",
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            localStorage.setItem("idcliente", respuesta.idCliente);
        }
    });


}


function obteneridpedido(){
    try{
        $.ajax({
            url: "http://localhost:8081/reserva/all",
            type: "GET",
            contentType: "application/JSON",
            datatype: "JSON",
            success: function (respuesta) {
                console.log(respuesta);
                let arrayids=[];
                for (i = 0; i < respuesta.length; i++) {
                    arrayids.push(respuesta[i].idpedido);
                };
                localStorage.setItem("idpedido", Math.max(...arrayids));
            }
        });
    }
    catch{
        localStorage.setItem("idpedido", 1);
    }    

}


function horalocal(fecha, operacion){
    let numberOfMlSeconds = fecha.getTime();
    let factor = -(5 * 60 * 60000);
    if (operacion === "suma"){
        factor*=-1;
    }
    let newDateObj = new Date(numberOfMlSeconds + factor );
    return newDateObj;
}

function cerrarsesion(){
    localStorage.removeItem("idusuariologin");
    localStorage.removeItem("nameusuariologin");
    localStorage.removeItem("emailusuariologin");
    localStorage.removeItem("idcliente");
    location.reload();
}

function validarlogin(){

    if (localStorage.getItem("idcliente") !== null){
        document.getElementById("Mensaje no login").setAttribute("hidden", "true");
        document.getElementById("form_reservas").removeAttribute("hidden");
    }
}

function mostrarnavbar(){
    
    if (localStorage.getItem("idcliente") !== null){
        $(function(){
            $("#navbar").load("navbar2.html")
        }
        )
    }
    else{
        $(function(){
            $("#navbar").load("navbar.html")
        }
        )
    }
}

function setfocus(id){

    document.getElementById(id).focus();
}