package factory;

public class MyError {

    private String poruka;
    int type;
    public MyError (String s){
        poruka=s;
    }
    public void IspisiPoruku (){
        System.out.println(poruka);
    }
}
