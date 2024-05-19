import java.util.Scanner;
public class Task2 {
    public static void gradeCal(double avg){
        System.out.println("*********************************************************************");
        System.out.print("\t\tThe grade obtained is :");
        if(avg>95){
            System.out.println("O grade");
        }
        else if(avg>85){
            System.out.println("A1 grade");
        }
        else if(avg>75){
            System.out.println("A2 grade");
        }
        else if(avg>65){
            System.out.println("B1 grade");
        }
        else if(avg>55){
        System.out.println("B2 grade");
        }
        else if(avg>45){
        System.out.println("c1 grade");
        }
        else if(avg>35){
        System.out.println("D grade");
        }
        else{
            System.out.println("E grade");
        }
        System.out.println("*********************************************************************");
    }
    public static void main(String[] args)  {
        Scanner obj =  new Scanner(System.in);
        String reply;
        int n;
        double marks;
        double sum=0.00;
        double avg;
        do{
        System.out.println("--------------------------Enter the marks to calculate the grade-----------------------------");
        System.out.println("How many subjects you have?");
        n = obj.nextInt();
        for(int i =1;i<=n;i++){
        System.out.println("Subject:"+i);
        marks=obj.nextInt();
        sum+=marks;
    } 
    obj.nextLine(); 
    System.out.println();
    System.out.println();
    System.out.println("*********************************************************************");
    System.out.println("-> Your total sum out of "+(n*100)+" is "+sum+".");
    System.out.println("*********************************************************************");
    avg=sum/n;
    System.out.println();
    System.out.println();
    System.out.println("*********************************************************************");
    System.out.println("-> Your avg is "+avg);
    System.out.println("*********************************************************************");
    System.out.println();
    System.out.println();
 
    gradeCal(avg);
    System.out.println("\nDo you want to calculate another time:\n\t\t-> Yes\n\t\t-> No ");
    reply = obj.nextLine();
 }while(reply.equalsIgnoreCase("yes"));
if(reply.equalsIgnoreCase("no")){
    System.out.println("--------------------------THANK YOU-----------------------------");
}  }
}
