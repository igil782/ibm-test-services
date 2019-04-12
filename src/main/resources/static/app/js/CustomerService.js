
app.service('CustomerService',["$http", "CONSTANTS", function($http, CONSTANTS){

    this.addTarjeta = function addTarjeta( idCard, numero, numero1, numero2, numero3, ccv, tipo, idCustomer){
        return $http({
          method: 'POST',
          url: CONSTANTS.saveTarjeta,
          data: {idCard:idCard, numberCard:numero+numero1+numero2+numero3, ccv:ccv, idCustomer:idCustomer, idTypeCard:tipo}
        });
    }

    this.saveCustomer = function saveCustomer( idCustomer, nombre, direccion, telefono){
        return $http({
          method: 'POST',
          url: CONSTANTS.saveCustomer,
          data: {idCustomer:idCustomer, nombre:nombre, direccion:direccion, telefono:telefono}
        });
    }

    this.saveMovement = function saveMovement( idMovement, idCard, date, description, amount){
        return $http({
          method: 'POST',
          url: CONSTANTS.saveMovimiento,
          data: {idMovement:idMovement, idCard:idCard, date:date, description:description, amount:amount}
        });
    }

    this.deleteTarjeta = function deleteTarjeta(id){
        return $http({
          method: 'DELETE',
          url: CONSTANTS.deleteTarjeta+id
        })
    }

    this.deleteCustomer = function deleteCustomer(id){
        return $http({
          method: 'DELETE',
          url: CONSTANTS.deleteCustomer+id
        })
    }

    this.deleteMovimiento = function deleteMovimiento(id){
         return $http({
           method: 'DELETE',
           url: CONSTANTS.deleteMovimiento+id
         })
     }


    this.getAllCustomers = function getAllCustomers(){
        return $http({
          method: 'GET',
          url: CONSTANTS.getAllCustomers
        });
    }
    this.getMovements = function getMovements(idCard){
        return $http({
          method: 'GET',
          url: "customer/movement/list?idCard="+idCard
        });
    }

}]);