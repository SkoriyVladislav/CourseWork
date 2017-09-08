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
        return shifrText.toString();
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
        return deshifrText.toString();
    }

    @Override
    public String hack(String t) {

        // В этом блоке мы анализируем частоту встречаемости букв в заданном тексте
        // и составляем массив с упорядоченными по частоте индексами букв алфавита
        int[] arrMaxIndex = Analiz.analizText(Analiz.textForAnaliz);
        // В этом блоке тоже самое что и в предыдущем только тут анализируем зашифрованный текст
        int[] arrMaxShifrIndex = Analiz.analizText(t);

        cout << "Выебрите длину ключа: ";
        cin >> sizeMyKey;
        for (int i = 0; i < sizeMyKey; i++) {
            //cout << arrMaxIndex[i] << "   текст" << endl << Analiz::anText(alph, shifrText, i, sizeMyKey) << endl << endl;
            myKey.push_back((2 * sizeAlph + Analiz::anText(alph, shifrText, i, sizeMyKey) - arrMaxIndex[0]) % (2 * sizeAlph) + 1);
        }
        cout << "Я предполгагаю что ключ к этому тексту: ";
        for (int i = 0; i < myKey.size(); i++) {
            cout << alph[myKey[i]];
        }
        cout << endl << endl;


        cout << "Введите 1, если данный ключ корректен." << endl;
        cout << "Введите 2, если хотите заменить определённую букву ключа." << endl;
        cin >> choise2;
        switch (choise2) {
            case 1:
                break;
            case 2:
                for (; flag2 == 'д';) {
                    cout << "Введите номер буквы которую хотите изменить: ";
                    cin >> numb;
                    cout << "Введите букву на которую хотите заменить: ";
                    cin >> bukva;
                    for (int i = 1; i < sizeAlph * 2; i = i + 2) {
                        if (bukva == alph[i]) {
                            myKey[numb - 1] = i;
                        }
                    }
                    cout << "Я предполгагаю что ключ к этому тексту: ";
                    for (int i = 0; i < myKey.size(); i++) {
                        cout << alph[myKey[i]];
                    }
                    cout << endl << endl;
                    cout << "Если хотите продолжать исправять ключ введите 'д': ";
                    cin >> flag2;
                }
                break;
        }

        stext = Vigenere::deshifr2(alph, shifrText, myKey);


        return Ceasar.deshifr( t,(Alphabet.sizeAlph + (arrMaxShifrIndex[0] - arrMaxIndex[0])) % Alphabet.sizeAlph);
    }
}
