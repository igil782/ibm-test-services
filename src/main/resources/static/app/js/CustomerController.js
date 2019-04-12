
app.controller('CustomerCtrl', ['$scope','CustomerService', function ($scope,CustomerService) {
    $scope.tarjeta = {};
    $scope.formData = {};

    $scope.addTarjeta = function (tarjeta) {
        $scope.tarjeta = tarjeta;
        if ($scope.tarjeta != null && $scope.tarjeta.ccv ) {
            CustomerService.addTarjeta($scope.tarjeta.idCard, $scope.tarjeta.number1, $scope.tarjeta.number2, $scope.tarjeta.number3, $scope.tarjeta.number4, $scope.tarjeta.ccv, $scope.tarjeta.tipo, $scope.tarjeta.idCliente)
              .then (function success(response){
                  $scope.message = 'Guardado!';
                  $scope.errorMessage = '';
                  $scope.getAllCustomers();
              },
              function error(response){
                  $scope.errorMessage = 'Error guardando tarjeta!';
                  $scope.message = '';
            });
        }
        else {
            $scope.errorMessage = 'Completar datos!';
            $scope.message = '';
        }
    }

    $scope.saveCustomer = function (customer) {
        $scope.customer = customer;
        if ($scope.customer != null && $scope.customer.nombre ) {
            CustomerService.saveCustomer($scope.customer.idCustomer, $scope.customer.nombre, $scope.customer.direccion, $scope.customer.telefono)
              .then (function success(response){
                  $scope.message = 'Guardado!';
                  $scope.errorMessage = '';
                  $scope.getAllCustomers();
              },
              function error(response){
                  $scope.errorMessage = 'Error guardando cliente!';
                  $scope.message = '';
            });
        }
        else {
            $scope.errorMessage = 'Completar datos!';
            $scope.message = '';
        }
    }
    $scope.saveMovement = function (mov) {
        $scope.mov = mov;
    alert('tarjeta ' + JSON.stringify(mov));
        if ($scope.mov != null && $scope.mov.valor ) {
            CustomerService.saveMovement($scope.mov.idMovement, $scope.mov.idCard, $scope.mov.fecha, $scope.mov.descripcion, $scope.mov.valor)
              .then (function success(response){
                  $scope.message = 'Guardado!';
                  $scope.errorMessage = '';
                  $scope.getMovements($scope.mov.idCard);
              },
              function error(response){
                  $scope.errorMessage = 'Error guardando cliente!';
                  $scope.message = '';
            });
        }
        else {
            $scope.errorMessage = 'Completar datos!';
            $scope.message = '';
        }
    }

    $scope.deleteTarjeta = function (card) {

        CustomerService.deleteTarjeta(card.idCard)
          .then (function success(response){
              $scope.message = 'Tarjeta eliminada!';
              $scope.user = null;
              $scope.errorMessage='';
              $scope.getAllCustomers();
          },
          function error(response){
              $scope.errorMessage = 'Error eliminando tarjeta!';
              $scope.message='';
          })
    }
    $scope.deleteCustomer = function (idCustomer) {
        CustomerService.deleteCustomer(idCustomer)
          .then (function success(response){
              $scope.message = 'Cliente eliminado!';
              $scope.user = null;
              $scope.errorMessage='';
              $scope.getAllCustomers();
          },
          function error(response){
              $scope.errorMessage = 'Error eliminando cliente!';
              $scope.message='';
          })
    }
    $scope.deleteMovimiento = function (mov) {
        CustomerService.deleteMovimiento(mov.idMovement)
          .then (function success(response){
              $scope.message = 'Movimiento de la tarjeta eliminado!';
              $scope.user = null;
              $scope.errorMessage='';
              $scope.getMovements(mov.card.idCard);
          },
          function error(response){
              $scope.errorMessage = 'Error eliminando movimiento de la tarjeta!';
              $scope.message='';
          })
    }

    $scope.getAllCustomers = function () {
        CustomerService.getAllCustomers()
          .then(function success(response){
              $scope.customers = response.data;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message='';
              $scope.errorMessage = 'Error obteniendo clientes!';
          });
    }
    $scope.getMovements = function (idCard) {
        CustomerService.getMovements(idCard)
          .then(function success(response){
              $scope.movements = response.data;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message='';
              $scope.errorMessage = 'Error obteniendo movimientos!';
          });
    }
}]);

