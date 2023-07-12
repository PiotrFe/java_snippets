interface InterfaceExample {
    String defString = "defString";
    int versionNo = 3;

    private String getStr() {
        return defString;
    }

    default String getDefaultString() {
        return getStr();
    }

    static int getVersionNo() {
        return versionNo;
    }
}

class Implementor implements InterfaceExample {

}


public class InterfaceDemo implements InterfaceExample {

    public static void main(String[] args) {
        Implementor i = new Implementor();

        System.out.println(i.getDefaultString());
        System.out.println(InterfaceExample.getVersionNo());
    
    }
    
}
