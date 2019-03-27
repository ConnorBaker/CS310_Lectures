class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Box with "+getT();
    }

    public static void main(String[] args) {
        Box<Integer> b = new Box<>();
        b.setT(4);
        System.out.println(b);

        class Cat {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Cat: "+getName();
            }
        }

        Cat cat = new Cat();
        cat.setName("Meowmeow");

        Box<Cat> c = new Box<>();
        c.setT(cat);

        System.out.println(c);

        // This doesn't provide enough information for us to do type-checking
        // We can force a cast on the RHS, but at runtime we still can't verify the types that
        // we're using.
        Box<Integer>[] boxes = (Box<Integer> []) new Box[5];
    }
}
