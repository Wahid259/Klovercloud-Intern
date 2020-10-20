
public class River {
	public int solution(int X, int[] A) {
        int remaining = X;
        boolean[] done = new boolean[ remaining + 1 ];

        for (int i = 0; i < A.length; i++) {
            if (done[ A[i] ] == false) {
                remaining--;
                done[ A[i] ] = true;
            }
            if (remaining == 0) {
                return i;
            }
        }

        return -1; // Not possible
    }

}
