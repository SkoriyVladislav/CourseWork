import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Skori on 08.09.2017.
 */
public class Analiz {
    // Это текст который мы анализируем что бы узнать частоту встречаемости букв в обычом тексте
    static String textForAnaliz = "Он съел немного, без аппетита, ложки три-четыре, как бы машинально. Голова болела меньше. Пообедав, протянулся он опять на диван, но заснуть уже не мог, а лежал без движения, ничком, уткнув лицо в подушку. Ему всё грезилось, и всё странные такие были грезы: всего чаще представлялось ему, что он где-то в Африке, в Египте, в каком-то оазисе. Караван отдыхает, смирно лежат верблюды; кругом пальмы растут целым кругом; все обедают. Он же всё пьет воду, прямо из ручья, который тут же, у бока, течет и журчит. И прохладно так, и чудесная-чудесная такая голубая вода, холодная, бежит по разноцветным камням и по такому чистому с золотыми блестками песку... Вдруг он ясно услышал, что бьют часы. Он вздрогнул, очнулся, приподнял голову, посмотрел в окно, сообразил время и вдруг вскочил, совершенно опомнившись, как будто кто его сорвал с дивана. На цыпочках подошел он к двери, приотворил ее тихонько и стал прислушиваться вниз на лестницу. Сердце его страшно билось. Но на лестнице было всё тихо, точно все спали... Дико и чудно показалось ему, что он мог проспать в таком забытьи со вчерашнего дня и ничего еще не сделал, ничего не приготовил... А меж тем, может, и шесть часов било... И необыкновенная лихорадочная и какая-то растерявшаяся суета охватила его вдруг, вместо сна и отупения. Приготовлений, впрочем, было немного. Он напрягал все усилия, чтобы всё сообразить и ничего не забыть; а сердце всё билось, стукало так, что ему дышать стало тяжело. Во-первых, надо было петлю сделать и к пальто пришить -- дело минуты. Он полез под подушку и отыскал в напиханном под нее белье одну, совершенно развалившуюся, старую, немытую свою рубашку. Из лохмотьев ее он выдрал тесьму, в вершок шириной и вершков в восемь длиной. Эту тесьму сложил он вдвое, снял с себя свое широкое, крепкое, из какой-то толстой бумажной материи летнее пальто (единственное его верхнее платье) и стал пришивать оба конца тесьмы под левую мышку изнутри. Руки его тряслись пришивая, но он одолел и так, что снаружи ничего не было видно, когда он опять надел пальто. Иголка и нитки были у него уже давно приготовлены и лежали в столике, в бумажке. Что же касается петли, то это была очень ловкая его собственная выдумка: петля назначалась для топора. Нельзя же было по улице нести топор в руках. А если под пальто спрятать, то все-таки надо было рукой придерживать, что было бы приметно. Теперь же, с петлей, стоит только вложить в нее лезвие топора, и он будет висеть спокойно, под мышкой изнутри, всю дорогу. Запустив же руку в боковой карман пальто, он мог и конец топорной ручки придерживать, чтоб она не болталась; а так как пальто было очень широкое, настоящий мешок, то и не могло быть приметно снаружи, что он что-то рукой, через карман, придерживает. Эту петлю он тоже уже две недели назад придумал.";


    static int[] analizText(String t) {
        int sizeAlph = Alphabet.alph.length;
        int[] ma = new int[sizeAlph];
        int sizeText = t.length();

	    double[] arr1 = new double[sizeAlph / 2];
        for (int i = 0; i < sizeAlph / 2; i++) {
            arr1[i] = 0.0;
        }

        double[] arrMaxText = new double[sizeAlph / 2];
        for (int i = 0; i < sizeAlph / 2; i++) {
            arr1[i] = 0.0;
        }

        // В этом блоке мы анализируем частоту встречаемости букв в заданном тексте
        for (int i = 1, k = 0; i < sizeAlph; i += 2, k++) {
            for (int j = 0; j < sizeText; j++) {
                if (t.charAt(j) == Alphabet.alph[i]) {
                    arr1[k]++;
                }
            }
        }

        for (int i = 0; i < sizeAlph / 2; i++) {
            arr1[i] /= sizeText;
        }

        for (int i = 0; i < sizeAlph / 2; i++) {
            arrMaxText[i] = arr1[i];
        }

        // Инициализируем упорядоченный массив из наиболее встречающихся букв (в процентах)
        for (int repeat_counter = 0; repeat_counter < sizeAlph / 2; repeat_counter++) {
            // временная переменная для хранения значения перестановки
            double temp;
            for (int element_counter = repeat_counter + 1; element_counter < sizeAlph / 2; element_counter++) {
                if (arrMaxText[repeat_counter] < arrMaxText[element_counter]) {
                    temp = arrMaxText[repeat_counter];
                    arrMaxText[repeat_counter] = arrMaxText[element_counter];
                    arrMaxText[element_counter] = temp;
                }
            }
        }

        // Cоставляем массив с упорядоченными по частоте индексами букв алфавита
        for (int i = 0; i < sizeAlph / 2; i++) {
            int temp = 0;
            for (int j = 0; j < sizeAlph / 2; j++) {
                if (arrMaxText[i] == arr1[j]) {
                    arr1[j] = 0;
                    temp = j;
                    break;
                }
            }
            ma[i] = 1 + 2 * temp;
        }
        return ma;
    }


    static int anVig(String t) {
        String newText = clearText(t);

        char[] posl = { 'a', 'a' };
        char[] posl1 = { 'a', 'a' };
        char[] posl2 = { 'a', 'a' };

        List<Integer> index = new ArrayList<>(0);
        int kol = 0;
        // Находим последовательность из двух букв которая встречается чаще всего
        for (int i = 1; i < Alphabet.sizeAlph * 2; i += 2) {
            posl1[0] = Alphabet.alph[i];
            for (int j = 1; j < Alphabet.sizeAlph * 2; j += 2) {
                posl1[1] = Alphabet.alph[j];
                int temp = 0;
                for (int k = 0; k < newText.length() - 1; k++) {
                    posl2[0] = newText.charAt(k);
                    posl2[1] = newText.charAt(k + 1);
                    if (posl1[0] == posl2[0] && posl1[1] == posl2[1]) {
                        temp++;
                    }
                }
                if (temp > kol) {
                    posl[0] = posl1[0];
                    posl[1] = posl1[1];
                    kol = temp;
                }
            }
        }

        for (int i = 0; i < newText.length(); i++) {
            posl2[0] = newText.charAt(i);
            posl2[1] = newText.charAt(i + 1);
            if (posl[0] == posl2[0] && posl[1] == posl2[1]) {
                // Создаём вектор, элементы которого это места на которых стоит сочетание букв
                index.add(i);
            }
        }

        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < index.size() - 1; i++) {
            dist.add(index.get(i + 1) - index.get(i));
        }

        List<Integer> dlina = new ArrayList<>();
        for (int i = 0; i < dist.size() - 1; i++) {
            for (int j = i + 1; j < dist.size(); j++) {
                int temp = Analiz.nod(dist.get(i), dist.get(j));
                dlina.add(temp);
            }
        }

        System.out.println( "Числа представленные ниже являются делителями длины ключевого слова." );
        for (int i = 0; i < dlina.size(); i++) {
            System.out.print(dlina.get(i) + "  ");
        }
        System.out.println();
        System.out.print( "Исходя из этого попытайтесь угадать длину ключевого слова." );
        System.out.print("Учтите что если введёное вами число не подойдет то ответ можно будет изменить." );



        System.out.println( "Выебрите длину ключа: ");
        Scanner sc = new Scanner(System.in);
        int sizeMyKey = sc.nextInt();
        return sizeMyKey;
    }

    static int analizTextVig(String t, int b, int shag) {
        int max = 0;
        int maxIndex = -1;

        String newText = clearText(t);

        // В этом блоке мы анализируем частоту встречаемости букв в заданном тексте
        for (int i = 1; i < Alphabet.sizeAlph * 2; i += 2) {
            int temp = 0;
            for (int j = b; j < newText.length(); j += shag) {
                if (Alphabet.alph[i] == newText.charAt(j)) {
                    temp++;
                }
            }
            if (temp > max) {
                max = temp;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    static int nod(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }
        return a + b;
    }

    static String clearText(String t) {

        int znaki = 0;
        for (int i = 0; i < t.length(); i++) {
            int tempT = -1;
            for (int j = 0; j < Alphabet.sizeAlph * 2; j++) {
                if (t.charAt(i) == Alphabet.alph[j]) {
                    tempT = j;
                    break;
                }
            }
            if (tempT == -1) {
                znaki++;
            }
        }

        int sizeNewText = t.length() - znaki;
        char[] newText = new char[sizeNewText];
        for (int i = 0, k = 0; k < sizeNewText; i++) {
            int tempT = -1;
            for (int j = 0; j < Alphabet.sizeAlph * 2; j++) {
                if (t.charAt(i) == Alphabet.alph[j]) {
                    tempT = j;
                    break;
                }
            }
            if (tempT >= 0) {
                if (tempT % 2 != 0)
                    newText[k] = Alphabet.alph[tempT];
                else
                    newText[k] = Alphabet.alph[tempT + 1];
                k++;
            }
        }

        return new String(newText);
    }
}
