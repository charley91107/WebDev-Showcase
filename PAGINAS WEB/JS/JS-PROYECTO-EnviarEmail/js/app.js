document.addEventListener('DOMContentLoaded', function(){

    const email = {
        email: '',
        asunto: '',
        mensaje:''
    };

   
    //selecionar los elementos de la interfaz
    const inputEmail = document.querySelector('#email');
    const inputAsunto = document.querySelector('#asunto');
    const inputMensaje = document.querySelector('#mensaje');
    const formulario = document.querySelector('#enviar-mail');
    const btnSubmit = document.querySelector('#enviar-mail button[type="submit"]')
    const btnReset = document.querySelector('#enviar-mail button[type="reset"]')
    const spinner = document.querySelector('#spinner');

    //asignar eventos
    inputEmail.addEventListener('input', validar);
    inputAsunto.addEventListener('input', validar);
    inputMensaje.addEventListener('input', validar);

    formulario.addEventListener('submit', enviarEmail);

    btnReset.addEventListener('click', function(e){
        e.preventDefault();

        //reiniciar el objeto
        email.email = '';
        email.asunto = '';
        email.mensaje = '';

        formulario.reset();
        comprobarEmail();
    })

    function enviarEmail(e) {
        e.preventDefault();

        spinner.classList.add('flex');
        spinner.classList.remove('hidden');
    }

    function validar(e){        
        if(e.target.value.trim() === ''){
           mostrarAlerta(`el campo ${e.target.id} es obligatorio`, e.target.parentElement);
           email[e.target.id] = '';
           comprobarEmail();
           return;
           }

           if(!e.target.id === 'email' && !validarEmail(e.target.value)){
            mostrarAlerta('El email no es válido', e.target.parentElement);
            email[e.target.id] = '';
            comprobarEmail();
            return;
           }

           limpiarAlerta(e.target.parentElement);

           //asignar los valores
           email[e.target.id] = e.target.value.trim().toLowerCase();

           //comprobar el objeto de email
           comprobarEmail();

        }

    function validarEmail(email){
        const regex = /^\w +([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/
        const resultado = regex.test(email);
        return resultado;        

    }


        
    

    function mostrarAlerta(mensaje, referencia){
        limpiarAlerta(referencia);                

        //generar alerta en html
        const error = document.createElement('P');
        error.textContent = mensaje;
        error.classList.add('bg-red-600', 'text-white', 'p-2', 'text-center')

        //Inyectar el error al formulario
        referencia.appendChild(error);
    }

    function limpiarAlerta(referencia){
        //comprueba si ya existe una alerta
        const alerta = referencia.querySelector('.bg-red-600');
        if(alerta){
            alerta.remove();
        }    
    }

    function comprobarEmail(){
        if(Object.values(email).includes('')){
            btnSubmit.classList.add('opacity-50');
            btnSubmit.disabled = true;
            return;
        }
        btnSubmit.classList.remove('opacity-50');
        btnSubmit.disabled = false;
        
    }

});