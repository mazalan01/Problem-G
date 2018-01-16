import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static List<Integer> primek;
    private static int max_prim=2;

    public static void main(String[] args) {
        primek=new ArrayList<>();
        primek.add(2);


        int n;
        List<Boolean>valaszok=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            valaszok.add(eset());
        }
        for(int i=0;i<n;i++){
            if(valaszok.get(i)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
        //System.out.println("muk");
    }

    private static Boolean eset(){
        int p1,p2,p3,p4;
        int s1,s2,s3,s4;
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextInt();
        s2 = sc.nextInt();
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        s3 = sc.nextInt();
        s4 = sc.nextInt();
        p3 = sc.nextInt();
        p4 = sc.nextInt();
        prim_lista_frissites(max(max(max(p1,p2),p3),p4));
        int lnko=lnko(lnko(lnko(p1,p2),p3),p4);
        if(s1%lnko==s2%lnko && s2%lnko==s3%lnko && s3%lnko==s4%lnko)return true;
        return false;
    }

    private static void prim_lista_frissites(int ig){
        while(max_prim<=ig){
            max_prim++;
            Boolean prim=true;
            for(int j=0;j<primek.size();j++){
                if(max_prim%primek.get(j)==0){prim=false;break;}
            }
            if(prim)primek.add(max_prim);
        }
    }

    private static int max(int a,int b){
        if(a>b)return a;
        return b;
    }

    private static int lnko(int a,int b){
        int ret=1;
        for(int i=0;i<primek.size();i++){
            int most=primek.get(i);
            while(a%most==0 && b%most==0){
                ret*=most;
                a/=most;
                b/=most;
            }
        }
        return ret;
    }

}
