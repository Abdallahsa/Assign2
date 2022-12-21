import java.util.Enumeration;

public class RoundRobin {
    private
    int Brust[];
    int Arrival[];
    int Wait[];
    int completion[];
    int Quantam;
    int contextswitch;
    int total;

    public void SetBrust(int [] brust) {
        Brust = brust;
    }
    public int getBrust (int index)
    {
        return Brust[index];
    }

    public void WaitTime(int [] wait)
    {

        Wait = wait;
    }
    public int getWait (int index , int[] anobrust)
    {
        if(contextswitch>0)
        {
            if(Arrival[index]>0 && anobrust[index]>Quantam)
                return (Wait[index]-Arrival[index]+1);
            return (Wait[index]-Arrival[index]);
        }
        else
            return (Wait[index]-Arrival[index]);
    }
    public void SetArrival(int [] arrival) {
        Arrival = arrival;
    }
    public int GetArrival (int index)
    {
        return Arrival[index];
    }

    public int getcompletion (int index)
    {
        return completion[index];
    }

    public void SetQantam(int q)
    {
        Quantam = q;
    }
    public void SetContext(int c){ contextswitch = c;}
    public int GetQantam() {return  Quantam;}


    public void CalculatWatingTime(int Num, int contextswitch)
    {
        for(int i=0; i<Num; i++ )
        {
            if(Brust[i] > GetQantam())
            {
                for( int j=0; j<Num; j++)
                {
                    if(i!=j && Brust[j]!=0)
                    {
                        Wait[j]+= (Quantam+contextswitch);
                    }
                }
                Brust[i] -= Quantam;
            }
            else
            {
                for( int j=0; j<Num; j++)
                {
                    if(i!=j && Brust[j]!=0)
                    {

                        Wait[j]+= (Brust[i]+contextswitch);
                        if(Brust[i] ==0 && contextswitch>0)
                            Wait[j]-=contextswitch;
                    }
                }
                    Brust[i] =0 ;
            }
        }
    }

    public void CalculatTurntime(int num, int[] brust)
    {

        completion = new int[num];
        for(int i=0; i<num; i++)
        {
            completion[i] = getWait(i, brust) + (brust[i]);
        }
    }

    }



