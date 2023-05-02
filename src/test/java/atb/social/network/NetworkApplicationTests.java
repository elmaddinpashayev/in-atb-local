package atb.social.network;

//@SpringBootTest
class NetworkApplicationTests {

//

    private Object t;

    public static void main(String args[]) {
        NetworkApplicationTests type = new NetworkApplicationTests();
        type.set("Pankaj");
        String str = (String) type.get(); //type casting, error prone and can cause ClassCastException
        System.out.println(str);
    }

    public Object get() {
        return t;
    }

    public void set(Object t) {
        this.t = t;
    }
}
