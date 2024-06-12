(function ($) {
    $.toggleShowPassword = function (options) {
        var settings = $.extend({
            field: "#password",
            control: "#toggle_show_password",
        }, options);

        var control = $(settings.control);
        var field = $(settings.field);

        control.bind('click', function () {
            if (control.is(':checked')) {
                field.attr('type', 'text');
            } else {
                field.attr('type', 'password');
            }
        })
    };

    $.transferDisplay = function () {
        $("#transferFrom").change(function () {
            if ($("#transferFrom").val() === 'Tarjeta') {
                $('#transferTo').val('Ahorros');
            } else if ($("#transferFrom").val() === 'Ahorros') {
                $('#transferTo').val('Tarjeta');
            }
        });

        $("#transferTo").change(function () {
            if ($("#transferTo").val() === 'Tarjeta') {
                $('#transferFrom').val('Ahorros');
            } else if ($("#transferTo").val() === 'Ahorros') {
                $('#transferFrom').val('Tarjeta');
            }
        });
    };


}(jQuery));

$(document).ready(function () {
    var confirm = function () {
        bootbox.confirm({
            title: "Confirmar cita",
            message: "Está seguro de concretar esta cita?",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> Cancelar'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Confirmar'
                }
            },
            callback: function (result) {
                if (result === true) {
                    $('#appointmentForm').submit();
                } else {
                    console.log("Cita cancelada");
                }
            }
        });
    };

    $.toggleShowPassword({
        field: '#password',
        control: "#showPassword"
    });

    $.transferDisplay();

    $('.form_datetime').datetimepicker({
        format: 'YYYY-MM-DD HH:mm',
        autoclose: true,
        todayBtn: true,
        startDate: new Date()
    });

    $('#concretarCita').click(function () {
        confirm();
    });

});




