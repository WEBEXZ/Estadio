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