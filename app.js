var app = angular.module("piadaapp",[]);

app.controller("piadactrl", function($scope, $http){
    $scope.salvar = function(piada){
        $scope.enviando=true;
        console.log(piada);
        $http.post("http://piada.herokuapp.com/piada",piada)
                .then(function(result){
                   $scope.enviando=false;
                   $scope.mensagem="Piada cadastrada com sucesso";
                  
                   console.log(result);
                },  function(erro){
                   $scope.enviando=false;
                   $scope.mensagem="Erro no cadastro."
                   console.log(erro);
                });
        console.log("foi!");
        
    }
    $scope.listar = function(){
        $scope.buscando = true;
        $http.get("http://piada.herokuapp.com/piada")
                .then(function(result){  $scope.buscando = true;
                 console.log(result);
                 $scope.piadas =  result.data;}
        
        , function(erro){
             $scope.buscando = true;
            console.log(result);
        })
    }
});