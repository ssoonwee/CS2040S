//Name: Song Soon Wee
//Student Number: A0200378L

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Ladice {
    public static void main(String[]args){
        Kattio reader = new Kattio(System.in);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int items = reader.getInt();
        int drawers = reader.getInt();
        int addOneDrawer = drawers + 1;
        int counter = 0;
        UnionFindDS unionStruct = new UnionFindDS(addOneDrawer);
        while(counter < items){
            int drawerNo = reader.getInt();
            int itemNo = reader.getInt();
            unionStruct.unionSet(drawerNo, itemNo);
            if(unionStruct.isItemStored(drawerNo)){
                writer.println("LADICA");
            } else{
                writer.println("SMECE");
            }
            counter++;
        }
        writer.flush();
        writer.close();
    }
}