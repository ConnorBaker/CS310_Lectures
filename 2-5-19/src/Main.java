public class Main {
    public static void main(String[] args) {
        List<String> s = new SinglyLinkedList<>();
        s.add("Hey");
        s.add("There");
        s.add("Friend!");
        System.out.println(s);
        s.remove();
        s.remove();
        s.remove();
        System.out.println(s);
    }
}
