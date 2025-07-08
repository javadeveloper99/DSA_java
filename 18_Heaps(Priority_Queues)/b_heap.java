import java.util.*;
public class b_heap {

    static class Heap{
        ArrayList<Integer>list = new ArrayList<>();
        public boolean isEmpty(){
            return list.size()==0;
        }
        public void add(int data){
            list.add(data);

            int x=list.size()-1;
            int par=(x-1)/2;

            while (list.get(x)< list.get(par)) {
                int temp=list.get(x);
                list.set(x,list.get(par));
                list.set(par,temp);
            }


        }
        public int peek(){
            return list.get(0);
        }
        public void heapify(int i){
            int left = 2*i+1;
            int right=2*i+2;
            int minIdx=i;

            if (left < list.size() && list.get(minIdx)>list.get(left) ) {
               minIdx=left; 
            }
            if (right < list.size() && list.get(minIdx)>list.get(right) ) {
               minIdx=right; 
            }

            if (i!=minIdx) {
                int temp=list.get(i);
                list.set(i, list.get(minIdx));
                list.set(minIdx,temp);

                heapify(minIdx);
            }
        }
        public int remove(){
            //first element
            int data=list.get(0);

            //swap first and last
            int temp=list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1,temp);

            //delete last 

            list.remove(list.size()-1);

            //heapify
              heapify(0);

            return data;
        }
    }
    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }

    }
}
