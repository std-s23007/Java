class d49Q26 {
    public static void main(String[] args) {
        if (args.length > 0) {
            new d49Q26().show(Double.parseDouble(args[0]));
        }
    }

    void show(double n) {
        System.out.println("value is " + n);
    }
}