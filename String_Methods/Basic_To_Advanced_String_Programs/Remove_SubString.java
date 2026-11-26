public class Remove_SubString {
    public static void main(String[] args) {
        
        String str="abc dfabc dfr ghtv abc achb ghf  abc";

        String str_arr[]=str.split(" ");
        String Remove_substr="abc";

        int array_size=str_arr.length;

        for(int i=0; i<array_size; i++){
             if(str_arr[i].equals(Remove_substr)){
                  for(int j=i; j<array_size-1; j++){
                      str_arr[j]=str_arr[j+1];
                  }
                  array_size--;
                  i--;
             }
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0; i<array_size; i++){
              sb.append(str_arr[i]);
              if(array_size-1 != i){
                sb.append(" ");
              }
        }
       
        System.out.println(sb);
        
    }
}
