import java.util.Scanner;

/**
 * Created by Skori on 07.09.2017.
 */
public class Ceasar implements Hackable {

    static String shifr(String t, int k) {
        int sizeAlph = Alphabet.sizeAlph;
        int sizeText = t.length();
        int temp = 0;

        char shifrText[] = t.toCharArray();
        for (int i = 0; i < sizeText; i++) {
            temp = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == Alphabet.alph[j]) {
                    temp = j;
                    break;
                }
            }
            if (temp == -1) {
                shifrText[i] = t.charAt(i);
            }
            else
                shifrText[i] = Alphabet.alph[(temp + 2*k)%sizeAlph];
        }
        return new String(shifrText);
    }


    static String deshifr(String t, int k) {
        int sizeAlph = Alphabet.sizeAlph;
        int sizeText = t.length();
        int temp = 0;
        char deShifrText[] = t.toCharArray();

        for (int i = 0; i < sizeText; i++) {
            temp = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == Alphabet.alph[j]) {
                    temp = j;
                    break;
                }
            }
            if (temp == -1) {
                deShifrText[i] = t.charAt(i);
            }
            else
                deShifrText[i] = Alphabet.alph[(sizeAlph + temp - k) % sizeAlph];
        }
        return new String(deShifrText);
    }

    @Override
    public String hack(String t) {

        // В этом блоке мы анализируем частоту встречаемости букв в заданном тексте
        // и составляем массив с упорядоченными по частоте индексами букв алфавита
        int[] arrMaxIndex = Analiz.analizText(Analiz.textForAnaliz);
        // В этом блоке тоже самое что и в предыдущем только тут анализируем зашифрованный текст
        int[] arrMaxShifrIndex = Analiz.analizText(t);

        return Ceasar.deshifr( t,(Alphabet.sizeAlph + (arrMaxShifrIndex[0] - arrMaxIndex[0])) % Alphabet.sizeAlph);
    }
}
