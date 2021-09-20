package by.epam.task5004.main;
//Задача 4.
//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.
//Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
//дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
//выбора сокровищ на заданную сумму.


import by.epam.task5004.controller.Controller;
import by.epam.task5004.controller.impl.TreasureController;
import by.epam.task5004.main.menu.Menu;
import by.epam.task5004.main.menu.UserInput;


public class Main {
    public static void main(String[] args) {
        Controller treasureController;
        UserInput userInput;
        Menu menu;

        userInput = new UserInput();
        treasureController = new TreasureController();
        menu = new Menu(userInput, treasureController);
        menu.start();
    }
}