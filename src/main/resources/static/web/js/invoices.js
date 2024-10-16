  angular.module('app', [])
      .controller('InvoiceController', function($scope, $http) {
          $scope.invoices = [];
          $scope.selectedInvoice = null;

          // Cargar todas las facturas desde el backend
          $scope.loadInvoices = function() {
              $http.get('/invoices')
                  .then(function(response) {
                      $scope.invoices = response.data;
                  })
                  .catch(function(error) {
                      console.error("Error cargando las facturas:", error);
                  });
          };

          // Editar una factura
          $scope.editInvoice = function(invoice) {
              $scope.selectedInvoice = angular.copy(invoice);
          };

          // Cancelar la edición
          $scope.cancelEdit = function() {
              $scope.selectedInvoice = null;
          };

          // Guardar una factura (llamar al backend para guardar o actualizar)
          $scope.saveInvoice = function() {
              if ($scope.selectedInvoice.idInvoice) {
                  // Actualizar factura existente
                  $http.post('/invoices', $scope.selectedInvoice)
                      .then(function(response) {
                          $scope.loadInvoices();
                          $scope.selectedInvoice = null;
                      })
                      .catch(function(error) {
                          console.error("Error guardando la factura:", error);
                      });
              } else {
                  // Crear nueva factura
                  $http.post('/invoices', $scope.selectedInvoice)
                      .then(function(response) {
                          $scope.loadInvoices();
                          $scope.selectedInvoice = null;
                      })
                      .catch(function(error) {
                          console.error("Error creando la factura:", error);
                      });
              }
          };

          // Eliminar una factura
          $scope.deleteInvoice = function(idInvoice) {
              $http.delete('/invoices/' + idInvoice)
                  .then(function(response) {
                      $scope.loadInvoices();
                  })
                  .catch(function(error) {
                      console.error("Error eliminando la factura:", error);
                  });
          };

          // Inicializar cargando las facturas
          $scope.loadInvoices();
      });