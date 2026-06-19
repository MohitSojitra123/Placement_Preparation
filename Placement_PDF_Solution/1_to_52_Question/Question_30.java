// WAP to check whether number is present in array or not (using recursion only) and the function’s syntax 
// is given below 
// int isInArray(int a [], int m); Where int a [] is Array of integer and m is element to be searched.

public class Question_30 {
    static int index = 0;


    static int isInArray(int a[], int m){

        if(index == a.length)
            return 0;

        if(a[index] == m)
            return 1;

        index++;
        return isInArray(a,m);
    }


    public static void main(String[] args){


        int a[] = {5,8,12,20};

        System.out.println(isInArray(a,12));

    }
}