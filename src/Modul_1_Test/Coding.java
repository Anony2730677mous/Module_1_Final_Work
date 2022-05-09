//package Modul_1_Test;
//import static Modul_1_Test.Adding_the_Creation_output_File.*;
//import static Modul_1_Test.In_and_Out.enterTheKey;
//import static java.nio.file.Paths.get;
//import static Modul_1_Test.In_and_Out.alphabet;
//import static Modul_1_Test.In_and_Out.key;
//import java.io.*;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//public class Coding
//{
//
//    //public static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? "; //.,":-!?
//
//    public static Path fileInputPath = createPath();//Paths.get("C:\\Users\\k84087642\\Desktop\\todo\\todolist.txt");
//    //public static Path fileOutputPath = createOutputFile(get(changePath(pathToFile, crypto)));//Paths.get("C:\\Users\\k84087642\\Desktop\\todo\\todolist_crypto.txt");
//    public static String lowText = lowLineCase(fileInputPath);
//    public static String alphabet2 = alphabet2(alphabet, key);
//    public static String codeLine = codeLine(lowLineCase(fileInputPath), alphabet2(alphabet, key));
//    public static void main(String[] args) {
//
//
////        Path fileInputPath = createPath();//Paths.get("C:\\Users\\k84087642\\Desktop\\todo\\todolist.txt");
////        Path fileOutputPath = createOutputFile(get(changePath(pathToFile, crypto)));//Paths.get("C:\\Users\\k84087642\\Desktop\\todo\\todolist_crypto.txt");
////        String lowText = lowLineCase(fileInputPath);
////        String alphabet2 = alphabet2(alphabet, key);
////        System.out.println(lowText);
////        System.out.println(alphabet2);
////        System.out.println(codeLine(lowText, alphabet2));
//
//    }
//    public static String alphabet2(String alphabet, int key) // метод, создающий новый алфавит на основе ключа
//    {
//
//        String shiftStart = alphabet.substring(0, key);
//        String shiftEnd = alphabet.substring(key);
//        String alphabet2 = shiftEnd + shiftStart;
//        return alphabet2;
//
//    }
//
//    public static String codeLine(String lowLine, String alphabet2) // метод, шифрующий текст из файла на основе нового алфавита
//    {
//
//        String codeLineText = "";
//        StringBuilder stringBuilder = new StringBuilder("");
//        for(int i = 0; i < lowLine.length(); i++)
//        {
//            for (int j = 0; j < alphabet.length(); j++)
//            {
//                if(lowLine.charAt(i) == alphabet.charAt(j))
//                {
//
//                  stringBuilder.append(alphabet2.charAt(j));
//
//                }
//            }
//        }
//        codeLineText = stringBuilder.toString();
//        return codeLineText;
//    }
//
//    public static String lowLineCase(Path fileInputPath) // метод, преобразующий все буквы в тексте к нижнему регистру
//    {
//        String lowLine = "";
//        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(fileInputPath))))
//        {
//            StringBuilder stringBuilder = new StringBuilder();
//            String line = "";
//            while (reader.ready()) {
//                line = reader.readLine();
//                stringBuilder.append(line);
//                stringBuilder.append('\n');
//
//            }
//            lowLine = stringBuilder.toString().toLowerCase();
//
//        } catch (IOException e) {
//            System.out.println("Обнаружено исключение:" + e.getMessage());
//        }
//        return lowLine;
//    }
//
//
//
//}
