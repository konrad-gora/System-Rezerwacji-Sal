/**
 * Created by Tomek on 2014-12-17.
 */
var myApp = angular.module('myApp', [])

myApp.factory('Uzytkownicy', function(){
    var Uzytkownicy = {};
    Uzytkownicy.cast = [
        {
            imie: "Jan",
            nazwisko: "Kowalski",
            email: "1@1.com"
        },
        {
            imie: "Przemyslaw",
            nazwisko: "Nowak",
            email: "2@2.com"
        },
        {
            imie: "Jan",
            nazwisko: "Wcislo",
            email: "3@3.com"
        },
        {
            imie: "Adam",
            nazwisko: "Koziol",
            email: "4@4.com"
        },
        {
            imie: "Jakub",
            nazwisko: "Bilko",
            email: "5@5.com"
        }
    ];
    return Uzytkownicy
})

function UzytkownicyCtrl($scope, Uzytkownicy){
    $scope.uzytkownicy = Uzytkownicy;
}