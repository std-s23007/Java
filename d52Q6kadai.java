public class d52Q6kadai {
    public static void main(String[] args) {  // String argsをString[] argsに修正
        Drink[] dr = {
                new Drink("Gomacola", 150),
                new Drink("MrPepper", 130),
                new Drink("SaltWater", 320)
        };
        VendingMachine vm = new VendingMachine(dr);
        vm.display();
        vm.execCom("i 100");
        vm.execCom("p 2");
        vm.execCom("i 500");
        vm.execCom("p 3");
        vm.execCom("c 0");
    }
}

class Drink {
    private String name;
    private int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return "[" + name + "] " + price + "円";
    }
}

class VendingMachine {
    private Drink[] drinks;
    private int cash = 0;
    private int[] coins = {500, 100, 50, 10};

    VendingMachine(Drink[] drinks) {
        this.drinks = drinks;
    }

    public void display() {
        int idx = 1;  // indをintに修正
        for (Drink drink : drinks) {
            System.out.println(" [" + idx + "] " + drink);
            idx++;
        }
    }

    public void execCom(String command) {
        String[] s = command.split(" ");
        switch (s[0]) {  // switch文でs[0]を使用
            case "i":
                cash += Integer.parseInt(s[1]);  // IntergerをIntegerに修正
                break;
            case "p":
                int idx = Integer.parseInt(s[1]) - 1;
                if (idx < 0 || idx >= drinks.length) return;  // idxの範囲チェック
                int price = drinks[idx].getPrice();
                if (price <= cash) {
                    eject(idx);
                    cash -= price;
                    payChange();
                } else {
                    System.out.println("お金が足りません");
                }
                break;
            case "c":
                payChange();
                break;
            default:
                break;
        }
    }

    private boolean isCoin(String s) {
        int c = Integer.parseInt(s);
        for (int coin : coins) {  // forループにパラメータを追加
            if (c == coin) return true;
        }
        return false;
    }

    private void eject(int idx) {
        System.out.println(drinks[idx] + " が排出されました");
    }

    private void payChange() {
        if (cash == 0) {
            System.out.println("お釣り　なし");
            return;
        }
        String s = "お釣り ";
        for (int coin : coins) {
            if (cash / coin > 0) {
                s += coin + "円:" + (cash / coin) + "枚 ";
                cash %= coin;  // cashの更新を追加
            }
        }
        System.out.println(s);
    }
}
