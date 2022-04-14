import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Algorithm001 {


    public void run(){


        ArrayList<Integer> list = new ArrayList();
        Stack<Integer> stack = new Stack<>();
        Stack<String> result = new Stack<>();
        Scanner sc = new Scanner(System.in);



        //1. stack을 이용해서 만들고자 하는 수열 입력
        System.out.println("정수 (1~100,000) 중 하나를 입력하세요");
        int row = sc.nextInt();

        System.out.println("1~"+row+ " 중 중복이 되지 않도록 입력해주세요.");
        
        do{
            int num = sc.nextInt();
            list.add(num);

            if(list.size()!=1) {
                for (int i = 0; i < list.size()-1; i++) {
                    int lastNum = list.get(list.size() - 1);
                    if (list.get(i) == lastNum) {
                        list.remove(list.size() - 1);
                        System.out.println("중복된 숫자를 입력하셨습니다. 다른 숫자를 입력해주세요.");
                    }
                }
            }
        }while(list.size()<row);



        // 2. 1부터 n까지 stack에 쌓으면서 수열 만들기 (stack에 push할 경우 "+", 수열을 만들기위해 pop할 경우 "-")
        int i = 0;
        do{

            i++;
            stack.push(i);
            result.push("+");

            int cnt = stack.size();
            for(int j = 0; j < cnt; j++) {
                if (stack.peek() == list.get(0)) {
                    stack.pop();
                    list.remove(0);
                    result.push("-");
                }else{
                    break;
                }

            }

        }while(i!=row);


        //3. stack에 의해 수열을 만들지 못할 경우 'NO'출력
        if(list.size() != 0){
            System.out.println("NO");
        }else{

            Iterator it = result.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        }

    }



}
