package Modul_1_Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Paths.*;

public class In_Exc_new_criteria {
    public static void main(String[] args) {

        String crypto = "_crypto";
        boolean isTextFile = false; // условие для работы цикла по вводу пути к файлу
        String pathToFile = ""; // строковая переменная для занесения пути к файлу
        Path fileInputPath = null; // переменная типа Path для проверки существования файла
        Path fileOutnputPath = null; // переменная типа Path для создания пути к зашифрованному файлу
        Scanner scanner = new Scanner(System.in); // переменная типа Scanner для считывания пути к файлу
        try { // на случай ввода неправильного пути и возникновения исключения типа Exception
            while (!isTextFile) // цикл с условием повторения приглашения ввода пути к файлу в случае неправильного ввода
            {
                System.out.println("Введите путь к текстовому файлу с расширением txt, doc, rtf, docx"); // приглашение на ввод пути к файлу
                scanner = new Scanner(System.in); // инициализация переменной scanner

                pathToFile = scanner.nextLine(); // в строку заносим введенный путь
                fileInputPath = get(pathToFile); // из строки получаем путь к файлу

                if (Files.isRegularFile(Path.of(pathToFile)) && Files.exists(fileInputPath)) // условие проверки пути на наличие и существования файла
                {
                    System.out.println("Путь к файлу существует");
                    System.out.println("------------------------");
                    if (pathToFile.endsWith(".txt") || pathToFile.endsWith(".doc") || pathToFile.endsWith(".rtf") || pathToFile.endsWith("docx")) // условие для работы программы с текстовыми файлами
                    {
                        System.out.println("Выбран текстовый документ");
                        System.out.println("------------------------");
                        break; // если по введенному пути существует текстовый файл, то происходит выход из цикла ввода

                    }
                    else // иначе предлагается проверить правильность вводимых данных
                    {
                        System.out.println("Выберите документ с расширением txt, doc, rtf, docx");
                        System.out.println("------------------------");
                    }

                }
                else if (!Files.exists(fileInputPath)) // иначе предлагается проверить правильность вводимых данных
                {
                    System.out.println("Файла по введенному пути не существует. Проверьте правильность пути к файлу.");
                    System.out.println("------------------------");
                }
                else if (!Files.isRegularFile(Path.of(pathToFile))) // иначе предлагается проверить правильность вводимых данных
                {
                    System.out.println("По указанному пути текстовый файл не обнаружен. Проверьте правильность пути к файлу.");
                    System.out.println("------------------------");
                }
            }
        }
        catch(Exception e) // при возникновении исключения в случае неправильного ввода пути к файлу
        {
            System.out.println("Перехвачено исключение " + e.getMessage()); // выводится сообщение об исключении
        }
        finally
        {

            scanner.close(); // занятый ресурс scanner закрывается

        }
        //System.out.println("------------------------");
        System.out.println("Зашифрованный документ: " + changePath(pathToFile, crypto));
        fileOutnputPath = get(changePath(pathToFile, crypto));

        System.out.println("Работа программы окончена");

    }
    public static String changePath(String pathToFile, String crypto) // метод, создающий название зашифрованного файла, не меняя его расширения
    {
        int index = pathToFile.lastIndexOf("."); // находим индекс точки для определения расширения файла
        String first = pathToFile.substring(0, index); // создаем подстроку до начала расширения файла
        String last = pathToFile.substring(index); // создаем строку расширения файла
        String result = first + crypto + last; // склеиваем строки с добавлением строки, указывающей на шифрование файла
        return result; // метод возвращает строковый тип данных

    }
}
