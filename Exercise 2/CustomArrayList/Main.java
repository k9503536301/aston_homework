public class Main {
    public static void main(String[] args) throws Exception {
        CustomArrayList<Integer> list1 = new CustomArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        CustomArrayList<Integer> list2 = new CustomArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.addAll(list2);

        System.out.println(list1); // [1, 2, 3, 4, 5, 6]
    }
}
