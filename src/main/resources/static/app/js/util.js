
$(document).on("click", ".open-modalNuevaTarjeta", function () {
     var myBookId = $(this).data('id');
     angular.element(document.getElementById('idCliente')).val(myBookId).triggerHandler('input');
     angular.element(document.getElementById('numberTarjeta')).val('').triggerHandler('input');
     angular.element(document.getElementById('numberTarjeta1')).val('').triggerHandler('input');
     angular.element(document.getElementById('numberTarjeta2')).val('').triggerHandler('input');
     angular.element(document.getElementById('numberTarjeta3')).val('').triggerHandler('input');
     angular.element(document.getElementById('ccv')).val('').triggerHandler('input');
     angular.element(document.getElementById('tipoTarjeta')).val('').triggerHandler('input');
     angular.element(document.getElementById('tarje')).val('').triggerHandler('input');
});
$(document).on("click", ".open-modalEditarTarjeta", function () {
     var card = $(this).data('id');
     angular.element(document.getElementById('numberTarjeta')).val(card.numberCard.substring(0, 4)).triggerHandler('input');
     angular.element(document.getElementById('numberTarjeta1')).val(card.numberCard.substring(4, 8)).triggerHandler('input');
     angular.element(document.getElementById('numberTarjeta2')).val(card.numberCard.substring(8, 12)).triggerHandler('input');
     angular.element(document.getElementById('numberTarjeta3')).val(card.numberCard.substring(12, 16)).triggerHandler('input');
     angular.element(document.getElementById('ccv')).val(card.ccv).triggerHandler('input');
     angular.element(document.getElementById('tipoTarjeta')).val(card.typeCardEntity.idType).triggerHandler('input');
     angular.element(document.getElementById('tarje')).val(card.idCard ).triggerHandler('input');

});
$(document).on("click", ".open-modalNuevoCustomer", function () {
     angular.element(document.getElementById('idClienteM')).val('').triggerHandler('input');
     angular.element(document.getElementById('nombre')).val('').triggerHandler('input');
     angular.element(document.getElementById('direccion')).val('').triggerHandler('input');
     angular.element(document.getElementById('telefono')).val('').triggerHandler('input');
});
$(document).on("click", ".open-modalEditarCustomer", function () {
     var customer = $(this).data('id');
     angular.element(document.getElementById('idClienteM')).val(customer.idCustomer).triggerHandler('input');
     angular.element(document.getElementById('nombre')).val(customer.name).triggerHandler('input');
     angular.element(document.getElementById('direccion')).val(customer.address).triggerHandler('input');
     angular.element(document.getElementById('telefono')).val(customer.telephone).triggerHandler('input');
});
$(document).on("click", ".open-modalMovimientos", function () {
     var card = $(this).data('id');

});
$(document).on("click", ".open-modalNuevoMovement", function () {
     var mov = $(this).data('id');
     angular.element(document.getElementById('idMov')).val('').triggerHandler('input');
          angular.element(document.getElementById('descripcion')).val('').triggerHandler('input');
          angular.element(document.getElementById('valor')).val('').triggerHandler('input');
     angular.element(document.getElementById('fecha')).val('').triggerHandler('input');


});
$(document).on("click", ".open-modalEditarMovement", function () {
     var mov = $(this).data('id');
     angular.element(document.getElementById('idMov')).val(mov.idMovement).triggerHandler('input');
     angular.element(document.getElementById('idCardMov')).val(mov.card.idCard).triggerHandler('input');
     angular.element(document.getElementById('fecha')).val(mov.dateMovement).triggerHandler('input');
     angular.element(document.getElementById('descripcion')).val(mov.description).triggerHandler('input');
     angular.element(document.getElementById('valor')).val(mov.amount).triggerHandler('input');
});