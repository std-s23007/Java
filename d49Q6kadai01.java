import java.lang.StringBuilder;

class d49Q6kadai01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < args.length; i++) {
            sb.append(args[i]);
        }

        String concatenated = sb.toString();
        System.out.println(concatenated);
    }
}