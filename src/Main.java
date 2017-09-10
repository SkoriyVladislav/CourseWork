import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Skori on 07.09.2017.
 */
public class Main {
    public static void main (String... args) {
        Scanner sc = new Scanner(System.in);

        String flag = "д";
        String text, stext;
        int keyC = 0;
        String keyV;

        // Это текст который нам нужно расшифравать (Ну сначало мы его зашифруем со случайным ключом, а потом расшифруем)
        String shifrText, forShifrText = "И если бы даже случилось когда-нибудь так, что уже всё до последней точки было бы им разобрано и решено окончательно и сомнений не оставалось бы уже более никаких, -- то тут-то бы, кажется, он и отказался от всего, как от нелепости, чудовищности и невозможности. Но неразрешенных пунктов и сомнений оставалась еще целая бездна. Что же касается до того, где достать топор, то эта мелочь его нисколько не беспокоила, потому что не было ничего легче. Дело в том, что Настасьи, и особенно по вечерам, поминутно не бывало дома: или убежит к соседям, или в лавочку, а дверь всегда оставляет настежь. Хозяйка только из-за этого с ней и ссорилась. Итак, стоило только потихоньку войти, когда придет время, в кухню и взять топор, а потом, чрез час (когда всё уже кончится), войти и положить обратно. Но представлялись и сомнения: он, положим, придет через час, чтобы положить обратно, а Настасья тут как тут, воротилась. Конечно, надо пройти мимо и выждать, пока она опять выйдет. А ну как тем временем хватится топора, искать начнет, раскричится, -- вот и подозрение или, по крайней мере, случай к подозрению.";

        String forShifrText2 = "И ты понял всё не так, я загадывал не это: Нет, я не хотел летать, я хотел увидеть небо	Забери крылья назад, я свободное паденье Да, ты понял всё не так";
        int key322 = 3;
        String key3222 = "примерключа";

        // Набор переменных для анализа текстов
	double arrMaxText[] = new double[Alphabet.sizeAlph]; // В этих массивах хранятся упорядоченные по частоте встречаемости буквы
        for (int i = 0; i < Alphabet.sizeAlph / 2; i++) {
            arrMaxText[i] = 0.0;
        }
	double arrMaxShifrText[] = new double[Alphabet.sizeAlph];
        for (int i = 0; i < Alphabet.sizeAlph / 2; i++) {
            arrMaxShifrText[i] = 0.0;
        }
	int arrMaxIndex[] = new int[Alphabet.sizeAlph];
        for (int i = 0; i < Alphabet.sizeAlph / 2; i++) {
            arrMaxIndex[i] = 0;
        }
	int arrMaxShifrIndex[] = new int[Alphabet.sizeAlph];
        for (int i = 0; i < Alphabet.sizeAlph / 2; i++) {
            arrMaxShifrIndex[i] = 0;
        }


        //текст для шифровки решёткой Кардано
        String kard = "ТахиондвижетсябыстреескоростисветаАА";
        //создание матрицы текста
	    final int KEYSIZE = 6;
	    int shifrMatrix[][] = new int[KEYSIZE][];
        for (int i = 0; i < KEYSIZE; i++) {
            shifrMatrix[i] = new int[KEYSIZE];
        }
        for (int i = 0; i < KEYSIZE; i++) {
            for (int j = 0; j < KEYSIZE; j++) {
                shifrMatrix[i][j] = 0;
            }
        }

        for ( ; flag.equals("д"); ) {
            int choice = 0;
            System.out.println();
            System.out.println("Введите 1, если хотите зашифровать текст методом Цезаря.");
            System.out.println("Введите 2, если хотите расшифровать текст который зашифрован методом Цезаря и у вас есть ключ.");
            System.out.println("Введите 3, если хотите зашифровать текст методом Виженера.");
            System.out.println("Введите 4, если хотите расшифровать текст который зашифрован методом Виженера и у вас есть ключ.");
            System.out.println("Введите 5, если хотите расшифровать текст который зашифрован методом Цезаря и у вас нет ключа.");
            System.out.println("Введите 6, если хотите расшифровать текст который зашифрован методом Виженера и у вас нет ключа.");
            System.out.println("Введите 7, если хотите зашифровать текст решёткой Кардано.");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введите ваш текст: ");
                    text = sc.next();
                    System.out.print("Введите ключ: ");
                    keyC = sc.nextInt();
                    while (keyC > Alphabet.sizeAlph) {
                        keyC = keyC % Alphabet.sizeAlph;
                    }
                    stext = Ceasar.shifr(text, keyC);
                    System.out.println(stext);
                    break;
                case 2:
                    System.out.println("Введите ваш зашифрованный текст: ");
                    text = sc.next();
                    System.out.println("Введите ключ: ");
                    keyC = sc.nextInt();
                    while (keyC > Alphabet.sizeAlph) {
                        keyC = keyC % Alphabet.sizeAlph;
                    }
                    stext = Ceasar.deshifr(text, 2 * keyC);
                    System.out.println(stext);
                    break;
                case 3:
                    System.out.println("Введите ваш текст: ");
                    text = sc.next();
                    System.out.println("Введите ключ: ");
                    keyV = sc.next();
                    stext = Vigenere.shifr(text, keyV);
                    System.out.println(stext);
                    break;
                case 4:
                    System.out.println("Введите ваш зашифрованный текст: ");
                    text = sc.next();
                    System.out.println("Введите ключ: ");
                    keyV = sc.next();
                    stext = Vigenere.deshifr(text, keyV);
                    System.out.println(stext);
                    break;
                case 5:
                    Ceasar c1 = new Ceasar();
                    shifrText = Ceasar.shifr(forShifrText2, key322);
                    System.out.println("Вот зашифрованный текст: ");
                    System.out.println(shifrText);
                    System.out.println("Исходный текст: " );
                    System.out.println(c1.hack(shifrText));
                    break;
                case 6:
                    Vigenere v1 = new Vigenere();
                    shifrText = Vigenere.shifr(forShifrText, key3222);
                    System.out.println("Вот зашифрованный текст: ");
                    System.out.println(shifrText);
                    System.out.println(v1.hack(shifrText));
                    break;
                case 7:
                    System.out.println();
                    shifrMatrix = Kardano.shifr(Alphabet.alph, kard, KEYSIZE);
                    for (int i = 0; i < KEYSIZE; i++) {
                        for (int j = 0; j < KEYSIZE; j++) {
                            System.out.print(Alphabet.alph[shifrMatrix[i][j]] + "   ");
                        }
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Вы должны ввести число от 1 до 7.");
            }
            System.out.println("Если вы хотите продолжить работу, введите 'д':");

            flag = sc.next();
        }
    }
}
