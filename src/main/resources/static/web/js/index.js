 angular.module('app', [])
        .controller('AppController', function($scope) {
            $scope.showWelcome = true;

            $scope.enter = function() {
                // Cambia el estado de showWelcome para mostrar el menú
                $scope.showWelcome = false;
            };

            $scope.back = function() {
                window.history.back();
            };

            $scope.navigateTo = function(category) {
                // Redirige a las diferentes páginas según la categoría
                switch (category) {
                    case 'ventas':
                        window.location.href = 'ventas.html';
                        break;
                    case 'invoices':
                        window.location.href = 'invoices.html';
                        break;
                    case 'marcas':
                        window.location.href = 'marcas.html';
                        break;
                    case 'vehiculos':
                        window.location.href = 'vehiculos.html';
                        break;
                    case 'proveedores':
                        window.location.href = 'proveedores.html';
                        break;
                    default:
                        console.error("Categoría no reconocida");
                }
            };
        });