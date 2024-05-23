import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class bankAcc{
    String name;
    String password;
    int bal;
    public bankAcc(String name,String password,int bal){
        this.name = name;
        this.password=password;
        this.bal=bal;
    }
    public String getName(){
        return name;
    }
    public String password(){
        return password;
    }
    public int getBal(){
        return bal;
    }
    public int deposit(int amount) {
       bal += amount;
        return bal;
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= bal) {
            bal -= amount;
            return true;
        }
        else{
        return false;
    }
}
public void reciept(int balance,int choice,int amount){
    System.out.println("********************RECEIPT***********************");
    System.out.println("Name:"+getName());
    if(choice==1){
    System.out.println("PROCESS DONE:DEPOSITED");
    }
    else if(choice==2){
        System.out.println("PROCESS DONE:WITHDRAW");
    }
    System.out.println("AMOUNT DEPOSITED:"+balance);
    System.out.println("OLD BALANCE:"+amount);
    System.out.println("NEWBALANCE:"+getBal());
    System.out.println("*********************THANK YOU***********************");
}
}
public class task4 {
    public static void main(String[] args){
        String f = "Userdetails.txt";
        File file = new File(f);
        String name ;
        String password ;
        String amount;
        int balance;
        int newbalance;
        int amt;
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t***********************************************BANK********************************************************");
        System.out.println("1.DEPOSIT\n2.WITHDRAW\n3.BALANCE");
        System.out.println("*********************************");
        System.out.print("Enter your choice:");
        choice = sc.nextInt();
        sc.nextLine();
        System.out.print("password:");
        String pass = sc.nextLine();
        if(file.exists()){
              List<String> lines = new ArrayList<>();
            try(BufferedReader br = new BufferedReader(new FileReader(new File(f)))){
                String line;
            while((line=br.readLine())!=null){
                String[] details = line.split(",");
                name = details[0];
                password = details[1];
                amount = details[2];
                if(name!=null&&password!=null&&password.equals(pass)){
                     balance = Integer.parseInt(amount);
                      bankAcc ba = new bankAcc(name,password,balance);
                     if(choice==1){
                     System.out.print("Enter the amount:");
                     amt = sc.nextInt(); 
                     newbalance=ba.deposit(amt);
                     String newbal = String.valueOf(newbalance);
                     details[2]=newbal;
                     line = String.join(",", details);
                     System.out.println("*********************************");
                     System.out.println("Your new balance is:"+newbal);
                     System.out.println("*********************************");
                     ba.reciept(amt,choice,balance);
                     }
                     else if(choice==2){
                        System.out.print("Enter the amount:");
                        amt = sc.nextInt();
                        if(ba.withdraw(amt)){
                        newbalance=ba.getBal();
                        String newbal = String.valueOf(newbalance);
                        details[2]=newbal;
                        line = String.join(",", details);
                        System.out.println("*********************************");
                        System.out.println("Your new balance is:"+newbal);
                        System.out.println("*********************************");
                        ba.reciept(amt,choice,balance);
                    }
                     else{
                        System.out.println("Invalid balance");
                     }
                     }
                     else{
                        String balamt=details[2];
                        System.out.println("********************RECEIPT***********************");
                        System.out.println("Name:"+ba.getName());
                        System.out.println("YOUR BALANCE:"+balamt);
                        System.out.println("*********************THANK YOU***********************");
                     }
                    }
                lines.add(line);
            }
            
            }catch(IOException e){
                System.out.println("error");
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(f)))){
                for(String line:lines){
                       bw.write(line);
                       bw.newLine();
                }
            }catch(IOException e){
                System.out.println("error in writing");
            }

        }

}
}