import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int num = in.nextInt();
        RoundRobin obj = new RoundRobin();
        int wait[] = new int [num];
        int brust[] =new int [num];
        int anobrust[]=new int [num];
        int arrival[] =new int [num];
        String name[] =new String [num];
        obj.WaitTime(wait);
        int qunt ;
        int context;
        int total;
       for(int i=0; i<num; i++) //take the brust time and arrival time
        {
            System.out.println("Enter the Name for p"+(i+1));
            name[i] = in.next();
            System.out.println("Enter the Brust time for p "+name[i]);
            brust[i] = in.nextInt();
            anobrust[i] = brust[i];
            obj.SetBrust(brust);
            System.out.println("Enter the arrival time for p "+name[i]);
            arrival[i] = in.nextInt();
           obj.SetArrival(arrival);
        }


        obj.SetBrust(brust);
        obj.SetArrival(arrival);
        System.out.println("Enter tha Qantam time time :");
        qunt = in.nextInt();
        obj.SetQantam(qunt);
        System.out.println("Enter tha Context switch time :");
        context = in.nextInt();
        obj.SetContext(context);
        do
        {
            obj.CalculatWatingTime(num,context);
            total =0 ;
            for(int i=0; i<num; i++)
            {
                total += brust[i];
            }
        }//loop work until all brust time be zero
        while (total!=0);
        System.out.println("Process execution \t\t\tWaitting time\t\t\tTurn around time");
        float AvgWait =0;
        float AvgTrun =0;
        obj.CalculatTurntime(num,anobrust);
        for(int i=0; i<num; i++)
        {
            System.out.println("Process "+name[i]+"\t\t\t\t\t\t"+(obj.getWait(i,anobrust))+"\t\t\t\t\t\t"+(obj.getcompletion(i)));
            AvgWait += obj.getWait(i,anobrust);
            AvgTrun += obj.getcompletion(i);
        }//print the process' name , wait, Turn around
        System.out.println("Average Wait = "+AvgWait/num);
        System.out.println("Average Trun = "+AvgTrun/num);

    }


}