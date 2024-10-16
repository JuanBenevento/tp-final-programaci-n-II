
angular.module('app', [])
      .controller('ventas', function(
      $scope
      $rootScope,
      salesService,
      $modal,
      $q,
      $timeout,
      $filter) {
          $rootScope.sales = [];
           $scope.getVentas = function () {
              $timeout(function () {
                  $rootScope.isRequestingWithoutRequest = true;
                  salesService.getAllSales(
                          {
                              idSale: $scope.comunicador.selectSale.id,
                          },
                          function (data) {
                              console.log('Datos recibidos:', data);
                              $rootScope.salesArr = [];
                              data.forEach(function (sale) {
                                  console.log('Procesando solicitud:', sale);

                                      $rootScope.salesArr.push(sale);
                              });
                              $rootScope.isRequestingWithoutRequest = false;
                          }
                  );
              }, 200);
          };
          $scope.showAddForm = false;

          $scope.toggleAddForm = function() {
              $scope.showAddForm = !$scope.showAddForm;
          };

          $scope.addSale = function() {
              if ($scope.newSale && $scope.newSale.client && $scope.newSale.date) {
                  $scope.sales.push({
                      client: $scope.newSale.client,
                      date: new Date($scope.newSale.date)
                  });
                  $scope.newSale = {};
                  $scope.showAddForm = false;
              }
          };

          $scope.editSale = function(sale) {
              alert('Funcionalidad de edición para: ' + sale.client);
          };

          $scope.deleteSale = function(sale) {
              const index = $scope.sales.indexOf(sale);
              if (index > -1) {
                  $scope.sales.splice(index, 1);
              }
          };
      });