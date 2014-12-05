$(document).ready(function() {
        $('#usuario').blur(function(event) {
                var name = $('#usuario').val();
                var password = $('#contrasena').val();
                $.get('JqueryServlet', {
                        usuario : name,
                        contrasena : password
                }, function(responseText) {
                        $('#mensaje').text(responseText);
                });
        });
});

$(document).ready(function() {
        $('#contrasena').blur(function(event) {
                var name = $('#usuario').val();
                var password = $('#contrasena').val();
                $.get('JqueryServlet', {
                        usuario : name,
                        contrasena : password
                }, function(responseText) {
                        $('#mensaje').text(responseText);
                });
        });
});

$(document).ready(function() {
        $('#area').change(function(event) {
                var are = $('#area').val();
                var zone = $('#zona').val();
                var match = $('#partido').val();
                $.get('Seleccionar', {
                        area : are,
                        zona : zone,
                        partido : match
                }, function(responseText) {
                      $('#b_disponibles').text(responseText);
                      document.getElementById("b_disponibles").value=responseText;
                });
        });
});

$(document).ready(function() {
        $('#partido').change(function(event) {
                var match = $('#partido').val();
                $.post('Seleccionar', {
                        partido : match
                }, function(responseText) {
                      $('#hora').text(responseText);
                      document.getElementById("hora").value=responseText;
                });
        });
});

$(document).ready(function() {
        $('#partido').change(function(event) {
                var are = $('#area').val();
                var zone = $('#zona').val();
                var match = $('#partido').val();
                $.get('Seleccionar', {
                        area : are,
                        zona : zone,
                        partido : match
                }, function(responseText) {
                      $('#b_disponibles').text(responseText);
                      document.getElementById("b_disponibles").value=responseText;
                });
        });
});

$(document).ready(function() {
        $('#zona').change(function(event) {
                var are = $('#area').val();
                var zone = $('#zona').val();
                var match = $('#partido').val();
                $.get('Seleccionar', {
                        area : are,
                        zona : zone,
                        partido : match
                }, function(responseText) {
                        $('#b_disponibles').text(responseText);
                        document.getElementById("b_disponibles").value=responseText;
                });
        });
});

$(document).ready(function() {
        $('#descuento').change(function(event) {
                var match = $('#partido').val();
                var disp = $('#b_disponibles').val();
                var name = $('#nombre').val();
                var quanty = $('#cantidad').val();
                var desc = $('#descuento').val();
                $.get('Enviar', {
                        nombre : name,
                        b_disponibles : disp,
                        cantidad : quanty,
                        descuento : desc,
                        partido : match
                }, function(responseText) {
                        $('#respuesta').text(responseText);
                });
        });
});

$(document).ready(function() {
        $('#sclave').blur(function(event) {
                var search = $('#sclave').val();
                $.get('Venta', {
                        clave : search
                }, function(responseText) {
                        $('#encontrado').text(responseText);
                });
        });
});