package Modul_1_Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class In_and_Out_Test_Exception {
    public static void main(String[] args) {
        Scanner scanner = null;
        String pathToFile = "";
        Path fileInputPath = null;
        try {
            do {
                System.out.println("Введите путь к текстовому файлу в формате txt, doc, rtf, docx");
                scanner = new Scanner(System.in);

                pathToFile = scanner.nextLine();
                fileInputPath = Paths.get(scanner.nextLine());

                if (Files.isRegularFile(Path.of(pathToFile)) && Files.exists(fileInputPath))
                {
                    System.out.println("Путь к файлу указан правильно");
                    if (pathToFile.endsWith(".txt") || pathToFile.endsWith(".doc") || pathToFile.endsWith(".rtf") || pathToFile.endsWith("docx"))
                    {
                        System.out.println("Выбран текстовый документ");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Выберите документ в текстовом формате txt, doc, rtf, docx");
                        System.out.println();
                        continue;
                    }

                } else if (!Files.exists(fileInputPath)) {
                    System.out.println("Файла по введенному пути не существует. Проверьте правильность пути к файлу.");
                    System.out.println();
                } else if (!Files.isRegularFile(Path.of(pathToFile))) {
                    System.out.println("По указанному пути текстовый файл не обнаружен. Проверьте правильность пути к файлу.");
                    System.out.println();
                }
            } while (!Files.isRegularFile(Path.of(pathToFile)) || !Files.exists(fileInputPath));
        }
        catch(Exception e)
        {
            System.out.println("Перехвачено исключение " + e.getMessage());
        }
        finally {

                scanner.close();

        }
        System.out.println("Работа программы окончена");

    }
}
