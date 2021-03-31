class FixingExceptions {

//    public static void main(String[] args) {
//        int[] array = new int[5];
//        int index = 1;
//        calculateSquare(array, index);
//    }

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        if (array == null) {
            System.out.println("Exception!");
        } else if (array.length - 1 < index || index < 0) {
            System.out.println("Exception!");
        } else {
            System.out.println(array[index] * array[index]);
        }
    }
}