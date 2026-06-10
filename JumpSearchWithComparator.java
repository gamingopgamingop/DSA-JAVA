public static int jumpSearch(int[] arr, int target) {
    int n = arr.length;
    int step = (int) Math.floor(Math.sqrt(n));
    int prev = 0;
    
    // Functional interface for comparison
    IntBinaryOperator comparator = (a, b) -> Integer.compare(a, b);
    
    while (comparator.applyAsInt(arr[Math.min(step, n) - 1], target) < 0) {
        prev = step;
        step += (int) Math.floor(Math.sqrt(n));
        if (prev >= n) return -1;
    }

    while (comparator.applyAsInt(arr[prev], target) < 0) {
        prev++;
        if (prev == Math.min(step, n)) return -1;
    }

    if (comparator.applyAsInt(arr[prev], target) == 0) return prev;
    return -1;
}