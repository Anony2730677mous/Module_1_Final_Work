//package Modul_1_Test;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Scanner;
//
//import static Modul_1_Test.All_Methods_Together.*;
//
//
//public class Decoding_brute_force
//{
//       public static void main(String[] args)
//       {
//           String fileOutputPath = "C:\\Users\\k84087642\\Desktop\\todo\\todolist_crypto.txt";
//           String lowText = lowLineCase(fileOutputPath);
//           System.out.println(decodingBF_short(lowText));
//
//    }
//
//    private static String decodingBF_short(String lowText) // метод, расшифровывающий фрагмент текста для оценки пользователя
//    {
//        int lowTextLength = lowTextLength(lowText);
//        String deCodeLineText = "";
//        StringBuilder stringBuilder = new StringBuilder("");
//        boolean textDecoding = true;
//        int countKey = 0;
//
//            String alphabetDecoding = alphabet2(alphabet, countKey);
//
//            for(int i = 0; i < lowTextLength; i++)
//            {
//                for (int j = 0; j < alphabetDecoding.length(); j++)
//                {
//                    if(lowText.charAt(i) == alphabetDecoding.charAt(j))
//                    {
//
//                        stringBuilder.append(alphabet.charAt(j));
//                    }
//                }
//            }
//
//        deCodeLineText = stringBuilder.toString();
//        return deCodeLineText;
//
//    }
//    private static String decodingBF_full(String lowText) // метод, расшифровывающий весь текст для сохранения в файл
//    {
//
//        String deCodeLineText = "";
//        StringBuilder stringBuilder = new StringBuilder("");
//        boolean textDecoding = true;
//        int countKey = 0;
//
//        String alphabetDecoding = alphabet2(alphabet, countKey);
//
//        for(int i = 0; i < lowText.length(); i++)
//        {
//            for (int j = 0; j < alphabetDecoding.length(); j++)
//            {
//                if(lowText.charAt(i) == alphabetDecoding.charAt(j))
//                {
//
//                    stringBuilder.append(alphabet.charAt(j));
//                }
//            }
//        }
//
//        deCodeLineText = stringBuilder.toString();
//        return deCodeLineText;
//
//    }
//    private static int lowTextLength(String lowText) // метод устанавливает размер строки для подтверждения/отрицания расшифровки
//    {
//        int lowTextLength = lowText.length();
//        if(lowTextLength <30)
//        {
//            lowTextLength = lowTextLength;
//        }
//        else if (lowTextLength >30 && lowTextLength < 100)
//        {
//            lowTextLength = lowText.length()/2;
//        }
//        else if (lowTextLength > 100)
//        {
//            lowTextLength = 30;
//        }
//        return lowTextLength;
//    }
//    private boolean textDecoding(int userAnswer) // метод принимает выбор пользователя для подтверждения/отрицания расшифровки
//    {
//        boolean isDecode;
//        if(userAnswer() == 1)
//        {
//            isDecode = true;
//        }
//        else
//        {
//            isDecode = false;
//        }
//        return isDecode;
//    }
//    private static int userAnswer() // метод просит подтвердить/опровергнуть расшифровку фрагмента текста
//    {
//        System.out.println("Будет попытка расшифровки фрагмента текста. Если удачно, нажмите 1, если нет - нажмите любую другую цифру");
//        Scanner scanner = new Scanner(System.in);
//        int console = scanner.nextInt();
//        return console;
//    }
//}
