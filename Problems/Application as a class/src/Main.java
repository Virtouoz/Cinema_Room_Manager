class Application {

    String name;

    void run(String[] args) {
        // implement me
        System.out.println(name);
        for (String name : args) {
            System.out.println(name);
        }
    }
}