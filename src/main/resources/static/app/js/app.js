var app = angular.module('app',[]);
app.constant("CONSTANTS", {
	getAllCustomers : 'customer/list',
	saveTarjeta : "customer/card",
	saveCustomer : "customer",
	saveMovimiento : "customer/movement",
	getMovimientosTarjeta : "customer/movement/list?idCard=",
	deleteTarjeta : "customer/card?idCard=",
	deleteCustomer : "customer?idCustomer=",
	deleteMovimiento : "customer/movement?idMovement="
});