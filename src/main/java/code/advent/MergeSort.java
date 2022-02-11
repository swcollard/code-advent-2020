package code.advent;

public class MergeSort {

    public void mergeSort(int[] n) {
        if (n.length < 2) {
            return;
        }
        int mid = (n.length / 2);

        int l[] = new int[mid];
        int r[] = new int[n.length - mid];

        // Copy vals
        for (int i = 0; i < mid; i++) {
            l[i] = n[i];
        }
        for (int i = mid; i < n.length; i++) {
            r[i - mid] = n[i];
        }
        // Sort sub arrays
        mergeSort(l);
        mergeSort(r);
        int lI = 0;
        int rI = 0;

        for (int i = 0; i < n.length; i++) {
            if (lI < l.length) {
                int leftVal = l[lI];
                if (rI < r.length) {
                    int rightVal = r[rI];
                    if (leftVal < rightVal) {
                        n[i] = leftVal;
                        lI++;
                    } else {
                        n[i] = rightVal;
                        rI++;
                    }
                } else {
                    n[i] = leftVal;
                    lI++;
                }
            } else if (rI < r.length) {
                int rightVal = r[rI];
                n[i] = rightVal;
                rI++;
            }
        }
    }
}
