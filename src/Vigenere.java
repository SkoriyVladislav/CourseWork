import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Skori on 08.09.2017.
 */
public class Vigenere implements Hackable{
    static String shifr(String t, String k) {
        int sizeAlph = Alphabet.alph.length;
        int sizeText = t.length();
        int sizeKey = k.length();

        int tempT = 0;
        int tempK = 0;
        int znaki = 0;
        char shifrText[] = t.toCharArray();

        for (int i = 0; i < sizeText; i++) {
            tempT = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == Alphabet.alph[j]) {
                    tempT = j;
                    break;
                }
            }
            if (tempT == -1) {
                znaki++;
            }

            for (int j = 0; j < sizeAlph; j++) {
                if (k.charAt((i-znaki) % sizeKey) == Alphabet.alph[j]) {
                    tempK = j;
                    break;
                }
                else
                    tempK = 0;
            }
            if (tempT == -1) {
                shifrText[i] = t.charAt(i);
            }
            else
                shifrText[i] = Alphabet.alph[(tempT + tempK - 1) % sizeAlph];
        }

        return new String(shifrText);
    }

    static String deshifr(String t, String k) {
        int sizeAlph = Alphabet.alph.length;
        int sizeText = t.length();
        int sizeKey = k.length();
        int tempT = 0;
        int tempK = 0;
        int znaki = 0;
        char deshifrText[] = t.toCharArray();

        for (int i = 0; i < sizeText; i++) {
            tempT = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == Alphabet.alph[j]) {
                    tempT = j;
                    break;
                }
            }
            for (int j = 0; j < sizeAlph; j++) {
                if (k.charAt((i - znaki) % sizeKey) == Alphabet.alph[j]) {
                    tempK = j;
                    break;
                }
            }
            if (tempT == -1) {
                deshifrText[i] = t.charAt(i);
                znaki++;
            }
            else
                deshifrText[i] = Alphabet.alph[(sizeAlph + tempT - tempK + 1) % sizeAlph];
        }
        return deshifrText.toString();
    }

    static String deshifr(String t, List<Integer> k)  {
        int sizeAlph = Alphabet.alph.length;
        int sizeText = t.length();
        int sizeKey = k.size();
        int tempT = 0;
        int tempK = 0;
        int znaki = 0;
        char deshifrText[] = t.toCharArray();

        for (int i = 0; i < sizeText; i++) {
            tempT = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == Alphabet.alph[j]) {
                    tempT = j;
                    break;
                }
            }
            for (int j = 0; j < sizeAlph; j++) {
                if (Alphabet.alph[k.get((i - znaki) % sizeKey)] == Alphabet.alph[j]) {
                    tempK = j;
                    break;
                }
            }
            if (tempT == -1) {
                deshifrText[i] = t.charAt(i);
                znaki++;
            }
            else
                deshifrText[i] = Alphabet.alph[(sizeAlph + tempT - tempK + 1) % sizeAlph];
        }
        return new String(deshifrText);
    }

    @Override
    public String hack(String t) {
        List<Integer> myKey = new ArrayList<>();
        // В этом блоке мы анализируем частоту встречаемости букв в заданном тексте
        // и составляем массив с упорядоченными по частоте индексами букв алфавита
        int[] arrMaxIndex = Analiz.analizText(Analiz.textForAnaliz);
        // В этом блоке тоже самое что и в предыдущем только тут анализируем зашифрованный текст
        int[] arrMaxShifrIndex = Analiz.analizText(t);

        int sizeMyKey = Analiz.anVig(t);




        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < sizeMyKey; i++) {

            //cout << arrMaxIndex[i] << "   текст" << endl << Analiz::anText(alph, shifrText, i, sizeMyKey) << endl << endl;
            myKey.add((2 * Alphabet.sizeAlph + Analiz.analizTextVig(t, i, sizeMyKey) - arrMaxIndex[0]) % (2 * Alphabet.sizeAlph) + 1);
        }

        System.out.println( "Я предполгагаю что ключ к этому тексту: ");
        for (int i = 0; i < myKey.size(); i++) {
            System.out.print(Alphabet.alph[myKey.get(i)]);
        }
        System.out.println();


        System.out.println("Введите 1, если данный ключ корректен.");
        System.out.println("Введите 2, если хотите исправить ключ.");
        int choise2 = sc.nextInt();

        switch (choise2) {
            case 1:
                break;
            case 2:
                System.out.print("Введите новый ключ: ");
                String key = sc.next();
                char[] keyArr = key.toCharArray();
                //List<Integer> keyList = new ArrayList<>();
                for (int i = 0; i < key.length(); i++) {
                    for (int j = 0; j < Alphabet.sizeAlph * 2; j++) {
                        if (keyArr[i] == Alphabet.alph[j]) {
                            myKey.set(i,j);
                        }
                    }
                }

                /*String  flag2 = "д";
                for (; flag2.equals("д");) {
                    System.out.print("Введите номер буквы которую хотите изменить: ");
                    int numb = sc.nextInt();
                     System.out.print("Введите букву на которую хотите заменить: ");
                    String bukva = sc.next();
                    for (int i = 1; i < Alphabet.sizeAlph * 2; i = i + 2) {
                        if (bukva.charAt(0) == Alphabet.alph[i]) {
                            myKey.set(numb - 1, i);
                        }
                    }
                    System.out.print("Я предполгагаю что ключ к этому тексту: ");
                    for (int i = 0; i < myKey.size(); i++) {
                        System.out.print(Alphabet.alph[myKey.get(i)]);
                    }
                    System.out.println();
                    System.out.println();
                    System.out.print( "Если хотите продолжать исправять ключ введите 'д': ");
                    flag2 = sc.nextLine();
                }*/
                break;
        }




        return Vigenere.deshifr(t, myKey);
    }
}
