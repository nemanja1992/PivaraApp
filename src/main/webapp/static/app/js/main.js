var PivaraApp = angular.module("PivaraApp", ['ngRoute']);

PivaraApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/',{
        templateUrl: '/static/app/html/partial/piva.html'
    }).when('/pivo/edit/:id',{
        templateUrl: '/static/app/html/partial/edit-pivo.html'
    }).otherwise({
        redirectTo: '/'
    });
}]);

PivaraApp.controller("pivaCtrl", function($scope, $http, $location){

    var base_url_piva = "/api/piva";
    var base_url_pivare = "/api/pivare";

    
   

    $scope.pageNum = 0;
    $scope.totalPages = 0;

    $scope.pivare = [];
    $scope.piva = [];

    $scope.novoPivo = {};
    $scope.novoPivo.naziv = "";
    $scope.novoPivo.procenatAlkohola = "";
    $scope.novoPivo.ibu = "";
    $scope.novoPivo.kolicina = "";
    $scope.novoPivo.pivaraId = "";

    $scope.trazenoPivo = {};
    $scope.trazenoPivo.naziv = "";
    $scope.trazenoPivo.minIbu = "";
    $scope.trazenoPivo.maxIbu = "";

    var getPiva = function(){

        var config = {params: {}};

        config.params.pageNum = $scope.pageNum;

        if($scope.trazenoPivo.naziv != ""){
            config.params.naziv = $scope.trazenoPivo.naziv;
        }

        if($scope.trazenoPivo.minIbu != ""){
            config.params.minIbu = $scope.trazenoPivo.minIbu;
        }

        if($scope.trazenoPivo.maxIbu != ""){
            config.params.maxIbu = $scope.trazenoPivo.maxIbu;
        }


        $http.get(base_url_piva, config)
            .then(function success(data){
                $scope.piva = data.data;
                $scope.totalPages = data.headers('totalPages');

            });
    };

    var getPivara = function(){

        $http.get(base_url_pivare)
            .then(function success(data){
                $scope.pivare = data.data;
            });

    };
   

    getPiva();
    getPivara();
  

    $scope.nazad = function(){
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getPiva();
        }
    };

    $scope.napred = function(){
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getPiva();
        }
    };

    $scope.dodaj = function(){
        $http.post(base_url_piva, $scope.novoPivo)
            .then(function success(data){
                console.log(data.data);
                alert("Uspesno dodato pivo u bazu.");
                getPiva();

                $scope.novoPivo.naziv = "";
                $scope.novoPivo.procenatAlkohola = "";
                $scope.novoPivo.ibu = "";
                $scope.novoPivo.kolicina = "";
                $scope.novoPivo.pivaraId = "";


            });
    };

    $scope.trazi = function () {
        $scope.pageNum = 0;
        getPiva();
    }

    $scope.izmeni = function(id){
        $location.path('/pivo/edit/' + id);
    }

    $scope.obrisi = function(id){
        $http.delete(base_url_piva + "/" + id).then(
            function success(data){
                getPiva();
            },
            function error(data){
                alert("Neuspesno brisanje!");
                console.log(data);
            }
        );

    }
});

PivaraApp.controller("editPivoCtrl", function($scope, $http, $routeParams, $location){

    var base_url_piva = "/api/piva";

    $scope.staraPiva = null;

    var getStaraPiva = function(){

        $http.get(base_url_piva + "/" + $routeParams.id)
            .then(function success(data){
               $scope.staraPiva = data.data;
            });

    }
    getStaraPiva();
    
    $scope.izmeni = function(){
        $http.put(base_url_piva + "/" + $scope.staraPiva.id, $scope.staraPiva)
            .then(function success(data){
                alert("Uspešno izmenjen objekat!");
                $location.path("/");
            });
    }
});












