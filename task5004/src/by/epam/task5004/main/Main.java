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

import by.epam.task5004.dao.TreasuresLoaderUtil;
import by.epam.task5004.view.UserInput;
import by.epam.task5004.bean.Treasure;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path treasuresPath;
        UserInput input;
        UserViewAction userViewAction;
        List<Treasure> treasures;

        treasuresPath = Path.of(String.valueOf(
                Main.class.getResource("/by/epam/task5004/source/treasures.txt"))
                .substring(6));

        treasures = TreasuresLoaderUtil.loadTreasures(treasuresPath);
        input = new UserInput();
        userViewAction = new UserViewAction(input, treasures);
        userViewAction.start();
    }
}