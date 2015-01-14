/**
 * Created by Konrad on 2015-01-14.
 */
var myApp = angular.module('myApp', [])

myApp.factory('Sale', function(){
    var Sale = {};
    Sale.cast = [
        {
            nazwa: "Konferencyjna",
            pojemnosc: 220,
            opis: "Sala do konferencji"
        },
        {
            nazwa: "Mala Bankietowa",
            pojemnosc: 80,
            opis: "Mala sala na kameralne imprezy"
        },
        {
            nazwa: "Duza Bankietowa",
            pojemnosc: 340,
            opis: "Duza sala weselna"
        }
    ];
    return Sale
})

function SaleCtrl($scope, Sale){
    $scope.sale = Sale;
}