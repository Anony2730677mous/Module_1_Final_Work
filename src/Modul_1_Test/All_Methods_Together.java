package Modul_1_Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Paths.get;

public class All_Methods_Together
{
    public static int userChoice; // переменная, определяющая порядок действий на основании выбора пользователя
    public static int userDecoding; // переменная, определяющая порядок действий на основании выбора пользователя
    public static int key; // объявляется переменная для записи в нее ключа шифрования, введенного пользователем. Возвращается методом enterTheKey()
    public static int countKey = 0; // переменная для перебора ключей при выборе декодирования методом brute force
    public static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? "; //.,":-!? символы и алфавит, которые могут быть зашифрованы
    public static int indexOletter = alphabet.indexOf("о"); // позиция буквы "о" в текущем алфавите
    public static int alphabet_length = alphabet.length(); // длина строковой переменной alphabet
    public static boolean isTextFile = false; // условие для работы цикла по вводу пути к файлу
    public static boolean isTextDecode; // условие для расшифровки текста в автоматическом режиме
    public static Pattern pattern = Pattern.compile("ёя|ёь|ёэ|ъж|эё|ъд|цё|уь|щч|чй|шй|шз|ыф|жщ|жш|жц|ыъ|ыэ|ыю|ыь|жй|ыы|жъ|жы|ъш|пй|ъщ|зщ|ъч|ъц|ъу|ъф|ъх|ъъ|ъы|ыо|жя|зй|ъь|ъэ|ыа|нй|еь|цй|ьй|ьл|ьр|пъ|еы|еъ|ьа|шъ|ёы|ёъ|ът|щс|оь|къ|оы|щх|щщ|щъ|щц|кй|оъ|цщ|лъ|мй|шщ|ць|цъ|щй|йь|ъг|иъ|ъб|ъв|ъи|ъй|ъп|ър|ъс|ъо|ън|ък|ъл|ъм|иы|иь|йу|щэ|йы|йъ|щы|щю|щя|ъа|мъ|йй|йж|ьу|гй|эъ|уъ|аь|чъ|хй|тй|чщ|ръ|юъ|фъ|уы|аъ|юь|аы|юы|эь|эы|бй|яь|ьы|ьь|ьъ|яъ|яы|хщ|дй|фй"); // шаблон для регулярного выражения, содержащий недопустимое сочетание букв
    public static String pathToFile;
    public static String choiceCodingDecoding_Menu = "Выберите операцию с файлом: Кодирование - нажмите 1, Декодирование - нажмите 2. Выход из программы - нажмите 0.";
    public static String choice_Decoding_Menu = "Выберите тип дешифровки: Методом brute force в автоматическом режиме - нажмите 1, методом brute force в полуавтоматическом режиме - нажмите 2, методом статистического анализа - нажмите 3.";
    public static String enter_the_key = "Введите ключ шифрования: целое положительное число от 0 включительно и не более";
    public static String wrongChoice = "Неправильный выбор, выберите другое число";
    public static String wrongKey = "Введенный ключ не соответствует требуемым параметрам";
    public static String crypto = "_crypto";
    public static String decrypto = "_decrypto";
    public static String decodingComplete = "Расшифровка документа закончена";
    public static String fileSaveAs = "Документ сохранен как ";
    public static String devider = "------------------------";


    public static void menu() // основной метод, запускающий меню выбора
    {
        int userMenuChoice = codingDecodingMenu(); // запускается метод для выбора пользователем режима работы программы
        if (userMenuChoice == 1) // если выбран режим кодирования текстового документа
        {
            System.out.println("Вы выбрали режим кодирования");
            enterTheKey();
            String createPath = createPath();
            String changePath = changePath(createPath, crypto);
            String lowLine = lowLineCase(createPath);
            String alphabet2 = alphabet2(alphabet, key);
            String codeLine = codeLine(lowLine, alphabet2);
            codeLineWrite(codeLine, changePath);
            System.out.println("Зашифрованный документ создан: " + changePath(pathToFile, crypto));
            System.out.println(devider);
        }
        else if (userMenuChoice == 2) // если выбран режим работы декодирования текстового документа
        {
            System.out.println("Вы выбрали режим декодирования");
            int userChoiceDecoding = decodingMenu(); //запускается метод для выбора пользователем режима декодирования
            if(userChoiceDecoding == 1) // если выбран режим декодирования методом brute force в автоматическом режиме
            {
                System.out.println("Вы выбрали режим декодирования методом brute force в автоматическом режиме");
                String createPath = createPath();
                String lowLine = lowLineCase(createPath);
                while (true)
                {
                     String decodingBF_full = decodingBF_full(lowLine, countKey);
                    isTextDecode = stringAnalizer(decodingBF_full, pattern);
                    if(isTextDecode)
                    {
                        String changePath = changePath(createPath, decrypto);
                        codeLineWrite(decodingBF_full, changePath);
                        System.out.println(devider);
                        System.out.println(decodingComplete);
                        System.out.println(fileSaveAs + changePath);
                        System.out.println(devider);
                        break;
                    }
                    else
                    {
                        countKey++;
                    }
                 }

            }

            else if(userChoiceDecoding == 2) // если выбран режим декодирования методом brute force в полуавтоматическом режиме
            {
                System.out.println("Вы выбрали режим декодирования методом brute force в полуавтоматическом режиме с участием пользователя");
                String createPath = createPath();
                String lowLine = lowLineCase(createPath);
                int lowTextLength = lowTextLength(lowLine);
                while (true)
                {
                    System.out.println("Будет попытка расшифровки фрагмента текста. Если удачно, нажмите 1, если нет - нажмите любую другую цифру/букву");
                    System.out.println(devider);
                    System.out.println(decodingBF_short(lowLine, lowTextLength, countKey));
                    if(countKey > (alphabet_length-1))
                    {
                        countKey = 0;
                    }
                    int userAnswer = userAnswer();
                    if(userAnswer == 1)
                    {
                        if(countKey == 0)
                        {
                            break;
                        }
                        else if(countKey == (alphabet_length-1))
                        {
                            countKey = alphabet_length-1;
                            break;
                        }
                        else if (countKey>0 && countKey < (alphabet_length-1))
                        {
                            break;
                        }
                    }
                    countKey++;
                }
                String decodingBF_full = decodingBF_full(lowLine, countKey);
                String changePath = changePath(createPath, decrypto);
                codeLineWrite(decodingBF_full, changePath);
                System.out.println(devider);
                System.out.println(decodingComplete);
                System.out.println(fileSaveAs + changePath);
                System.out.println(devider);
            }
            else if(userChoiceDecoding == 3) // если выбран режим декодирования методом статистического анализа
            {
                System.out.println("Вы выбрали режим декодирования методом статистического анализа");
                String createPath = createPath();
                String lowLine = lowLineCase(createPath);
                int keyFromTextAnalize = textAnalizer(lowLine, alphabet);
                String decodingBF_full = decodingBF_full(lowLine, keyFromTextAnalize);
                String changePath = changePath(createPath, decrypto);
                codeLineWrite(decodingBF_full, changePath);
                System.out.println(devider);
                System.out.println(decodingComplete);
                System.out.println(fileSaveAs + changePath);
                System.out.println(devider);
            }
        } else if (userMenuChoice == 0) {
            System.out.println("Выход из меню");
        }
        System.out.println("Программа завершила работу");
    }

    public static int enterTheKey() // метод, запрашивающий у пользователя размер ключа шифрования
    {
        int userKey;
        int alphabetLength = alphabet_length-1;
        System.out.println(enter_the_key + " " + alphabetLength);
        Scanner scanner = new Scanner(System.in);
        try {
            if (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    userKey = scanner.nextInt();
                    if (userKey >= 0 && userKey <= alphabetLength) {
                        key = userKey;

                    } else {
                        System.out.println(wrongKey);

                        enterTheKey();
                    }
                } else if (scanner.hasNextLine()) {
                    System.out.println(wrongKey);
                    enterTheKey();
                }
            }
        } catch (Exception e) {
            System.out.println("Перехвачено исключение " + e.getMessage());
        }

        return key;
    }

    public static int codingDecodingMenu() // метод выбора пользователем режима шифрования/дешифровки
    {
        System.out.println(choiceCodingDecoding_Menu);
        int codingDecoding;
        Scanner scanner = new Scanner(System.in);
        try {
            if (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    codingDecoding = scanner.nextInt();
                    if (codingDecoding == 1) {
                        userChoice = 1;
                    } else if (codingDecoding == 2) {
                        userChoice = 2;
                    } else if (codingDecoding == 0) {
                        userChoice = 0;
                    } else {
                        System.out.println(wrongChoice);
                        codingDecodingMenu();
                    }
                } else if (scanner.hasNextLine()) {
                    System.out.println(wrongChoice);
                    codingDecodingMenu();
                }
            } else {
                System.out.println(wrongChoice);
                codingDecodingMenu();
            }

        } catch (Exception e) {
            System.out.println("Перехвачено исключение " + e.getMessage());
        }

        return userChoice;
    }

    public static int decodingMenu() // метод выбора пользователем режима дешифровки
    {
        int Decoding;
        System.out.println(choice_Decoding_Menu);
        Scanner scanner = new Scanner(System.in);
        try {
            if (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    Decoding = scanner.nextInt();
                    if (Decoding == 1)
                    {
                        userDecoding = 1;
                    }
                    else if (Decoding == 2)
                    {
                        userDecoding = 2;
                    }
                    else if (Decoding == 3)
                    {
                        userDecoding = 3;
                    } else {
                        System.out.println(wrongChoice);
                        decodingMenu();
                    }
                } else if (scanner.hasNextLine()) {
                    System.out.println(wrongChoice);
                    decodingMenu();
                }
            } else {
                System.out.println(wrongChoice);
                decodingMenu();
            }
        } catch (Exception e) {
            System.out.println("Перехвачено исключение " + e.getMessage());
        }

        return userDecoding;
    }

    public static String createPath() // метод, проверяющий и создающий путь к выбранному файлу
    {
        Scanner scanner = new Scanner(System.in); // переменная типа Scanner для считывания пути к файлу
            try { // на случай ввода неправильного пути и возникновения исключения типа Exception
            while (!isTextFile) // цикл с условием повторения приглашения ввода пути к файлу в случае неправильного ввода
            {
                System.out.println("Введите путь к текстовому файлу с расширением txt, rtf"); // приглашение на ввод пути к файлу
                pathToFile = scanner.nextLine(); // в строку заносим введенный путь
                if (Files.isRegularFile(Path.of(pathToFile)) && Files.exists(get(pathToFile))) // условие проверки пути на наличие и существования файла
                {
                    System.out.println("Путь к файлу существует");
                    System.out.println(devider);
                    if (pathToFile.endsWith(".txt") || pathToFile.endsWith(".doc") || pathToFile.endsWith(".rtf") || pathToFile.endsWith("docx")) // условие для работы программы с текстовыми файлами
                    {
                        System.out.println("Выбран текстовый документ");
                        System.out.println(devider);
                        break; // если по введенному пути существует текстовый файл, то происходит выход из цикла ввода

                    } else // иначе предлагается проверить правильность вводимых данных
                    {
                        System.out.println("Выберите документ с расширением txt, rtf");
                        System.out.println(devider);
                    }

                } else if (!Files.exists(get(pathToFile))) // иначе предлагается проверить правильность вводимых данных
                {
                    System.out.println("Файла по введенному пути не существует. Проверьте правильность пути к файлу.");
                    System.out.println(devider);
                } else if (!Files.isRegularFile(Path.of(pathToFile))) // иначе предлагается проверить правильность вводимых данных
                {
                    System.out.println("По указанному пути текстовый файл не обнаружен. Проверьте правильность пути к файлу.");
                    System.out.println(devider);
                }
            }
        } catch (Exception e) // при возникновении исключения в случае неправильного ввода пути к файлу
        {
            System.out.println("Перехвачено исключение " + e.getMessage()); // выводится сообщение об исключении
        }

        return pathToFile; // метод возвращает строковый тип данных

    }

    public static String changePath(String createPath, String crypto) // метод, создающий название зашифрованного файла, не меняя его расширения
    {
        int index = pathToFile.lastIndexOf("."); // находим индекс точки для определения расширения файла
        String first = pathToFile.substring(0, index); // создаем подстроку до начала расширения файла
        String last = pathToFile.substring(index); // создаем строку расширения файла
        String result = first + crypto + last; // склеиваем строки с добавлением строки, указывающей на шифрование файла
        return result; // метод возвращает строковый тип данных

    }

    public static void codeLineWrite(String codeLine, String changePath) // метод, записывающий зашифрованную строку в выходной файл
    {
        FileWriter fileWriter = null;
        try
        {
            if(Files.exists(Path.of(changePath))) // если файл с таким именем существует, то он перезаписывается
            {
                System.out.println("Файл с таким именем существует и будет перезаписан");
                Files.delete(Path.of(changePath));
                fileWriter = new FileWriter(String.valueOf(Path.of(changePath)));
                for(int i = 0; i <codeLine.length(); i++)
                {
                    fileWriter.write(codeLine.charAt(i));
                }
            }
            else {

                fileWriter = new FileWriter(String.valueOf(Path.of(changePath)));
                for(int i = 0; i <codeLine.length(); i++)
                {
                    fileWriter.write(codeLine.charAt(i));
                }
                System.out.println("------------------------");
            }
        }
        catch (IOException e)
        {
            System.out.println("Перехвачено исключение " + e.getMessage()); // выводится сообщение об исключении
        }
finally {
            try {
                fileWriter.close();
             } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String alphabet2(String alphabet, int key) // метод, создающий новый алфавит на основе ключа
    {
        String shiftStart = alphabet.substring(0, key);
        String shiftEnd = alphabet.substring(key);
        return shiftEnd + shiftStart;
    }

    public static String codeLine(String lowLine, String alphabet2) // метод, шифрующий текст из файла на основе нового алфавита
    {
        String codeLineText;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lowLine.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++)
            {
                if (lowLine.charAt(i) == alphabet.charAt(j)) {
                    stringBuilder.append(alphabet2.charAt(j));
                }
            }
        }
        codeLineText = stringBuilder.toString();
        return codeLineText;
    }

    public static String lowLineCase(String createPath) // метод, преобразующий все буквы в тексте к нижнему регистру
    {
        String lowLine = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(createPath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            lowLine = stringBuilder.toString().toLowerCase();
        } catch (IOException e) {
            System.out.println("Обнаружено исключение:" + e.getMessage());
        }
        return lowLine;
    }

    private static String decodingBF_short(String lowText, int lowTextLength, int countKey) // метод, расшифровывающий фрагмент текста для оценки пользователя в полуавтоматическом режиме
    {
        String deCodeLineText;
        StringBuilder stringBuilder = new StringBuilder();
        String alphabetDecoding = alphabet2(alphabet, countKey);

            for(int i = 0; i < lowTextLength; i++)
            {
                for (int j = 0; j < alphabetDecoding.length(); j++)
                {
                    if(lowText.charAt(i) == alphabetDecoding.charAt(j))
                    {

                        stringBuilder.append(alphabet.charAt(j));
                    }
                }
            }

        deCodeLineText = stringBuilder.toString();
        return deCodeLineText;
    }

    public static String decodingBF_full(String lowText, int countKey) // метод, расшифровывающий весь текст для сохранения в файл
    {
        String deCodeLineText;
        StringBuilder stringBuilder = new StringBuilder();

        String alphabetDecoding = alphabet2(alphabet, countKey);

        for(int i = 0; i < lowText.length(); i++)
        {
            for (int j = 0; j < alphabetDecoding.length(); j++)
            {
                if(lowText.charAt(i) == alphabetDecoding.charAt(j))
                {

                    stringBuilder.append(alphabet.charAt(j));
                }
            }
        }
        deCodeLineText = stringBuilder.toString();
        return deCodeLineText;

    }
    private static int lowTextLength(String lowText) // метод устанавливает размер строки для подтверждения/отрицания расшифровки
    {
        int lowTextLength = lowText.length();
        if(lowTextLength <30)
        {
            lowTextLength = lowTextLength;
        }
        else if (lowTextLength >30 && lowTextLength < 100)
        {
            lowTextLength = lowText.length()/2;
        }
        else if (lowTextLength > 100)
        {
            lowTextLength = 30;
        }
        return lowTextLength;
    }

    public static int userAnswer() // метод просит подтвердить/опровергнуть расшифровку фрагмента текста
    {
        Scanner scanner1 = new Scanner(System.in);
        int console;
        int userAnswer = 0;
        try {
             if(scanner1.hasNext())
            {
                if(scanner1.hasNextInt())
                {
                    console = scanner1.nextInt();

                    if (console == 1)
                    {
                        userAnswer = console;
                    }
                    else
                    {
                        userAnswer = 0;
                    }
                }
                else if(scanner1.hasNextLine())
                {

                    userAnswer = 0;
                }
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return userAnswer;
    }

    public static boolean stringAnalizer(String textToAnalize, Pattern pattern) // метод, проверящий текст на наличие недопустимых сочетаний букв
    {
        boolean isDecode;
        Matcher matcher = pattern.matcher(textToAnalize);
        if(matcher.find())
        {
            isDecode = false;;
        }
        else
        {
            isDecode = true;
        }
        return isDecode;
        }
    public static int textAnalizer(String textToAnalize, String alphabet) // метод, принимающий зашифрованный текст и возвращающий ключ шифрования на основе статистического анализа текста
    {
        int key = 0;
        int max1 = 0;
        int max2 = 0;
        Character m1 = '0';
        Character m2 = '0';
        Character letterToReturn;
        HashMap<Character, Integer> countChar = new HashMap<Character, Integer>();
        for (int i = 0; i < alphabet.length(); i++) // цикл для подсчета количества символов, встречающихся в тексте, и занесение пар символ-количество в коллекцию
        {
            int count = 0;
            for (int j = 0; j < textToAnalize.length(); j++) {
                if (alphabet.charAt(i) == textToAnalize.charAt(j)) {
                    count++;
                }
            }
            countChar.put(alphabet.charAt(i), count);
        }

        for (Map.Entry<Character, Integer> pair: countChar.entrySet()) // цикл, выявляющий частоту вхождения в текст буквы "о"
        {
            Integer value = pair.getValue();
            Character letter = pair.getKey();
            if(value > max1)
            {
                max2 = max1;
                m2 = m1;
                max1 = value;
                m1 = letter;
            }
            else if(value < max1 && value > max2 )
            {
                max2 = value;
                m2 = letter;
            }
        }
        letterToReturn = m2;
        //System.out.println(letterToReturn + " " + max2 + " " + m1 + " " + max1);
        for (int i = 0; i < alphabet_length; i++) // цикл по алфавиту, определяющий ключ шифрования
        {
            if(letterToReturn == alphabet.charAt(i))
            {
                if(i >= indexOletter)
                {
                    key = i - indexOletter;
                }
                else
                {
                    key = alphabet_length - indexOletter + i;
                }
            }
        }
        return key;
    }
}
