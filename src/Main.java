/**
 * Created by Olivi on 09-09-2016.
 */
public class Main {

    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();

        list.add(1);
        list.add(18);
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(39);
        list.add(19);
        list.add(40);
        list.add(1);
        //list.add(21);


        LinkedIntList list1 = new LinkedIntList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        //System.out.println(list.deleteBack());    //ex7
        //System.out.println(list);
        //list.switchPairs();                       //ex8
        //System.out.println(list);
        //list.stutter(list);                           //ex9
        //list.stretch(3);                           //ex10
        //System.out.println(list);
        list.compress();                      //ex11
        System.out.println(list);
        //list.split();                               //ex12
        //System.out.println(list);
        //list.transferFrom(list1);


    }
}
