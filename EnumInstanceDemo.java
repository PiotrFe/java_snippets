enum AppleEnum {
    Jonathan (10), GoldenDel(9), RedDel(12), Winesap(15), Cortland();

    private int price;

    AppleEnum() {
        price = -1;
    }

    AppleEnum(int p) {
        price = p;
    } 

    int getPrice() {
        return price;
    }
}

public class EnumInstanceDemo {
    public static void main(String[] args) {
        System.out.println("Winesap costs: " + AppleEnum.Winesap.getPrice());
        System.out.println("All apple prices");

        AppleEnum ap = AppleEnum.Winesap;

        for (AppleEnum a : AppleEnum.values()) {
            System.out.println(a + " costs " + a.getPrice() + " cents");
        }

        System.out.println("The ordinal value of Winesap is: " + AppleEnum.Winesap.ordinal());
        System.out.println("Comparation of Jonathan and Winesap: " + AppleEnum.Jonathan.compareTo(AppleEnum.Winesap));
        System.out.println("Ap is equal to Winesap: " + ap.equals(AppleEnum.Winesap));
    }
}
