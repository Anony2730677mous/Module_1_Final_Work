//package Modul_1_Test;
//import java.io.IOException;
//import java.util.Scanner;
//
//import static Modul_1_Test.Adding_the_Creation_output_File.*;
//import static Modul_1_Test.Coding.codeLine;
//
//
//public class In_and_Out
//{
//    public  static int userChoice;
//    public  static int userDecoding;
//    public  static int userDecoding_BF;
//    public  static int userDecoding_Analize;
//    public  static int key;
//    public static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? "; //.,":-!?
//    public  static int alphabet_length = 39;//alphabet.length(); // длина строковой переменной alphabet из класса Coding
//
//    public  static String choiceCodingDecoding_Menu = "Выберите операцию с файлом: Кодирование - нажмите 1, Декодирование - нажмите 2. Выход из программы - нажмите 0";
//    public  static String choice_Decoding_Menu = "Выберите тип дешифровки: Методом brut force - нажмите 1, методом статистического анализа - нажмите 2. Выход из программы - нажмите 0";
//    public  static String enter_the_key = "Введите ключ шифрования: целое положительное число не более";
//    public  static String wrongChoice = "Неправильный выбор, выберите другое число";
//    public  static String wrongKey = "Введенный ключ не соответствует требуемым параметрам";
//
//
//    public static void main(String[] args)
//    {
//        menu();
//
//    }
//public static void menu()
//{
//    int userMenuChoice = codingDecodingMenu();
//    if (userMenuChoice == 1)
//    {
//        enterTheKey();
//        createPath();
//        createOutputFile(fileOutputPath);
//        System.out.println("Ключ шифрования " + key);
//        codeLineWrite(codeLine);
//
//    }
//    else if(userMenuChoice == 2)
//    {
//        int userChoiceDecoding = decodingMenu();
//        System.out.println(userChoiceDecoding);
//    }
//    else if(userMenuChoice == 0)
//    {
//        System.out.println("Выход из меню");
//    }
//    System.out.println("Программа завершила работу");
//}
//    public static int enterTheKey() // метод, запрашивающий у пользователя размер ключа шифрования
//    {
//        int userKey;
//        System.out.println(enter_the_key + " " + alphabet_length);
//        Scanner scanner = new Scanner(System.in);
//        try
//        { if(scanner.hasNext())
//         {
//            if (scanner.hasNextInt())
//            {
//                userKey = scanner.nextInt();
//                if (userKey >= 0 && userKey <= alphabet_length) {
//                    key = userKey;
//
//                } else {
//                    System.out.println(wrongKey);
//
//                    enterTheKey();
//                }
//            }
//            else if(scanner.hasNextLine())
//            {
//                System.out.println(wrongKey);
//                enterTheKey();
//            }
//         }
//        }
//        catch (Exception e)
//        {
//            System.out.println("Перехвачено исключение " + e.getMessage());
//        }
//
//        return key;
//    }
//
//    public static int codingDecodingMenu() // метод выбора пользователем режима шифрования/дешифровки
//    {
//        int codingDecoding;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(choiceCodingDecoding_Menu);
//        try
//        {
//            if(scanner.hasNext())
//            {
//                    if (scanner.hasNextInt())
//                        {
//                            codingDecoding = scanner.nextInt();
//                            if (codingDecoding == 1)
//                            {
//                            userChoice = 1;
//                            }
//                            else if (codingDecoding == 2)
//                            {
//                            userChoice = 2;
//                            }
//                            else if (codingDecoding == 0)
//                            {
//                            userChoice = 0;
//                            }
//                            else
//                            {
//                            System.out.println(wrongChoice);
//                            codingDecodingMenu();
//                            }
//                        }
//                    else if(scanner.hasNextLine())
//                    {
//                        System.out.println(wrongChoice);
//                        codingDecodingMenu();
//                    }
//            }
//                else
//                {
//                    System.out.println(wrongChoice);
//                    codingDecodingMenu();
//                }
//
//          }
//        catch (Exception e)
//        {
//            System.out.println("Перехвачено исключение " + e.getMessage());
//        }
//
//        return userChoice;
//    }
//    public static int decodingMenu() // метод выбора пользователем режима шифрования/дешифровки
//    {
//        int Decoding;
//        System.out.println(choice_Decoding_Menu);
//        Scanner scanner = new Scanner(System.in);
//        try
//        {
//            if(scanner.hasNext())
//            {
//                if (scanner.hasNextInt())
//                {
//                    Decoding = scanner.nextInt();
//                    if(Decoding == 1)
//                    {
//                        userDecoding = 1;
//                    }
//                    else if(Decoding == 2)
//                    {
//                        userDecoding = 2;
//                    }
//                    else  if(Decoding == 0)
//                    {
//                        userDecoding = 0;
//                    }
//                    else
//                    {
//                        System.out.println(wrongChoice);
//                        decodingMenu();
//                    }
//                }
//                else if(scanner.hasNextLine())
//                {
//                    System.out.println(wrongChoice);
//                    decodingMenu();
//                }
//            }
//            else
//            {
//                System.out.println(wrongChoice);
//                decodingMenu();
//            }
//        }
//        catch (Exception e)
//        {
//            System.out.println("Перехвачено исключение " + e.getMessage());
//        }
//
//        return userDecoding;
//    }
//}
