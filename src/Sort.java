import java.util.ArrayList;

/**
 * Caden VanSickle
 *
 * CS1122
 * Date Last Modified: 3/17/2024
 *
 */
public class Sort implements SortInterface {

    @Override
    public void insertionsort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
        for (int i = lowindex + 1; i <= highindex; i++) {
            int key = list.get(i);
            int j = i - 1;

            /*
             * Move elements that are greater than the
             * key to one pos ahead of current pos.
             */
            if (!reversed) { //allows for reversed sort when called
                while (j >= lowindex && list.get(j) > key) {
                    list.set(j + 1, list.get(j));
                    j--;

                }
            } else {
                while (j >= lowindex && list.get(j) < key) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
            }

            list.set(j + 1, key);
        }
    }

    @Override
    public void shellsort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
        int n = highindex - lowindex + 1;
        int constant = 1;
        while (constant <= n / 2) {
            constant = 2 * constant + 1;
        }

        while (constant > 0) {
            for (int i = lowindex + constant; i <= highindex; i++) {
                int key = list.get(i);
                int j = i;

                if (!reversed) {
                    while (j >= lowindex + constant && list.get(j - constant) > key) {
                        list.set(j, list.get(j - constant));
                        j -= constant;
                    }
                } else {
                    while (j >= lowindex + constant && list.get(j-constant) < key) {
                        list.set(j, list.get(j - constant));
                        j -= constant;
                    }
                }

                list.set(j, key);

            }
            constant = (constant - 1) / 2; //Hibbard
        }
    }

    @Override
    public void mysort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
        if (lowindex < highindex) {
            int vol = highindex - lowindex + 1;

            if (vol <= 10) {
                insertionsort(list, lowindex, highindex, reversed);
            } else {

                int middle = lowindex + (highindex - lowindex) / 2;
                mysort(list, lowindex, middle, reversed);
                mysort(list, middle + 1, highindex, reversed);
                merge(list, lowindex, middle, highindex, reversed);
            }
        }
    }

    // merge Helper method
    private static void merge(ArrayList<Integer> list, int low, int mid, int high, boolean reversed) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        ArrayList<Integer> left = new ArrayList<>(list.subList(low, mid + 1));
        ArrayList<Integer> right = new ArrayList<>(list.subList(mid + 1, high + 1));

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (!reversed && left.get(i) <= right.get(j) || reversed && left.get(i) >= right.get(j)) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < n1) {
            list.set(k++, left.get(i++));
        }

        while (j < n2) {
            list.set(k++, right.get(j++));
        }
    }
}