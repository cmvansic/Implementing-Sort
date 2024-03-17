import java.util.ArrayList;

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

    }

    @Override
    public void mysort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {

    }
}