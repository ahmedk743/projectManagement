package projectmanagement;
import java.util.*;
import java.io.*;
import java.io.File;
class Account
{   
    String name;
    double balance;
    public Account()
    {
        balance=0;
        name="";
    }
    public void withDraw(double v)
    {
        if(v>balance)
        {
            System.out.println("UNSUFFICENT BALANCE");
        }
        else
        {
            balance=balance-v;
        }
    }
    public void setBalance(double balance)
    {
        this.balance+=balance;
    }
    public double getBalance()
    {
        return balance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }  
}
class Project
{
    
    static double total_balance;//of all projects;
    int no_developers;
    String name;
    double revenue;
    Scanner kb=new Scanner(System.in);
    public void setter()
    {
        System.out.println("Enter project name: ");
        name=kb.nextLine();
        System.out.println("Enter No of Persons: ");
        no_developers=kb.nextInt();
        System.out.println("Enter total revenue: ");
        revenue=kb.nextInt();
        total_balance+=revenue;
    }

    public static void setTotal_balance(double total_balance) {
        Project.total_balance = total_balance;
    }

    public void setNo_developers(int no_developers) {
        this.no_developers = no_developers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    public double getTotal_balance()
    {
        return total_balance;
    }
    public String getName()
    {
        return name;
    }
    public double getRevenue()
    {
        return revenue;
    }
    public int getNoPersons()
    {
       return no_developers;
    }
    public double gettotal_balance()
    {
        return total_balance;
    } 
}
class Person
{   
   String name;
   Scanner kb=new Scanner(System.in);
   public Person(int v)
   {
       
   }
   public void  setter(int pos)
   {
       int i=pos;i++;
        System.out.println("Enter Person "+i+" name: ");
        name=kb.nextLine();
   } 
   public String getName()
   {
       return name;
   }
   public  double findCountribution(int no_developers,double revenue,int pos)
   {
       int i=pos;i++;
       System.out.println("Enter person "+i+" Countribution (%)");
       double v=kb.nextInt();
       double share=(v/100)*revenue;
       return share;
    }      
}
public class ProjectManagement 
{       
    public static void main(String []args) 
    {
        File ac=new File("Acccounts.txt");
        File pr=new File("Projects.txt");
        Scanner kb=new Scanner(System.in);
        int ch;double withDraw; //String strr="",strrr="",temp[],temp1[],str1,str2="";
        int count=0, save=0;int persons=0;double revenue=0;
        ArrayList<Account> account=new ArrayList<Account>();
        ArrayList<Project> project=new ArrayList<Project>();
        ArrayList<Person> person=new ArrayList<Person>(persons);
        //Getting backPrevious Records.......
         String Strr="",Strrr="",Temp[],Temp1[],Str1,Str2="";
                    //account...............
                    
                    try
                    {
                        BufferedReader input=new BufferedReader(new FileReader(ac));
                        if(!(input.ready()))
                        {
                            throw new Exception();
                        }
                        while((Strr=input.readLine())!=null)
                        {
                            Strrr+=Strr;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("NO RECORD IN ACCOUNT FILE YET");
                    }
                  //  System.out.println(strrr);
                    Temp=Strrr.split("@");int J=0;double Data;
                    for(int i=1;i<Temp.length;i=i+2)
                    {
                        J=i;J--;
                        Account aa=new Account();
                        aa.setName(Temp[J]);
                        Data=Double.parseDouble(Temp[i]);
                        aa.setBalance(Data);
                        account.add(aa);
                    }
                    //project...................
                    
                     try
                    {
                        BufferedReader input=new BufferedReader(new FileReader(pr));
                        if(!(input.ready()))
                        {
                            throw new Exception();
                        }
                        while((Str1=input.readLine())!=null)
                        {
                            Str2+=Str1;
                        }
                    }
                     catch(Exception e)
                    {
                        System.out.println("NO RECORD IN PROJECT FILE YET\nLETS TRY MY APPLICATION.^^");
                    }
                     //System.out.println(str2);
                     Temp1=Str2.split("@");
                     int aa,bb,cc;
                     for(int i=3;i<Temp1.length;i=i+4)//total..name..nop...revenue
                     {
                         aa=i;aa-=3;
                         bb=i;bb=bb-2;
                         cc=i;cc--;
                         Project pp=new Project();
                         pp.setTotal_balance(Double.parseDouble(Temp1[aa]));
                         pp.setName(Temp1[bb]);
                         pp.setNo_developers(Integer.parseInt(Temp1[cc]));
                         pp.setRevenue(Double.parseDouble(Temp1[i]));
                         project.add(pp);
                     }
        //End................................
            
        while(true)
        {
            System.out.println("           Main Menu");
            System.out.println("0. Delete All Records");
            System.out.println("1. Joint Balance");
            System.out.println("2. Add new Projrct");
            System.out.println("3. Create new Persons Account");
            System.out.println("4. All Accounts Details");
            System.out.println("5. All Completed Projects");
            System.out.println("6. WithDraw someone's Money");
            System.out.println("7. Save current Files");
            System.out.println("8. Load Previous Record files");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            ch=kb.nextInt();
            switch(ch)
            {
                case 0:
                    try
                      {
                        FileWriter fww=new FileWriter(ac);
                        Writer outputp= new BufferedWriter(fww);
                        for(int i=0;i<account.size();i++)
                        {
                            outputp.write("");
                        }
                        outputp.close();
                    }
                    catch(Exception e)
                            {
                                System.out.println("I can not create this file7");
                            }
                    //Deleting Project
                                        try
                      {
                        FileWriter f1=new FileWriter(pr);
                        Writer outputpp= new BufferedWriter(f1);
                        for(int i=0;i<account.size();i++)
                        {
                            outputpp.write("");
                        }
                        outputpp.close();
                    }
                    catch(Exception e)
                            {
                                System.out.println("I can not create this file7");
                            }
                    System.out.println("Deleted Successfully.");
                    break;
                case 1:
                    try
                    {
                    int ii=project.size();ii--;
                    System.out.println("Total joint Balance of all Projects is "+project.get(ii).gettotal_balance());                      
                    }
                    catch(Exception e)
                    {
                        System.out.println("There is no records!");
                    }    
                    break;
                case 2:
                    Project tempp=new Project();
                    tempp.setter();
                    project.add(tempp);
                    count++;
                    persons=tempp.getNoPersons();
                    revenue=tempp.getRevenue();
                    //Inserting in account...
                     int check;
                    for(int i=0;i<persons;i++)
                    {
                      check=0;
                      Person p=new Person(persons);
                      Account acc=new Account(); double v;
                      p.setter(i);
                      v=p.findCountribution(persons, revenue,i);
                      for(int j=0;j<account.size();j++)
                      {
                        
                          if(p.getName().equals(account.get(j).getName()))
                          {
                              account.get(j).setBalance(v);
                              check=1;
                              break;
                          }
                      }
                      if(check==0)
                      {
                         acc.setName(p.getName());
                         acc.setBalance(v);
                         account.add(acc);
                      }
                      person.add(p);
                    }
                    break;
                case 3:
                   
                    break;
                case 4:
                    
                    for(int i=0;i<account.size();i++)
                    {
                        int iii=i;iii++;
                        System.out.println(" ACCOUNT "+iii);
                        System.out.println("Name: "+account.get(i).getName()+"    BALANCE: "+account.get(i).getBalance());
                    }
                    break;
                case 5://all completed projects
                    for(int i=0;i<project.size();i++)
                    {
                        int k=i;k++;
                        System.out.println("    PROJECT "+k);
                        System.out.println("Name: "+project.get(i).getName());
                        System.out.println("Persons: "+project.get(i).getNoPersons());
                        System.out.println("Revenue: "+project.get(i).getRevenue());
                    }
                    break;
                case 6://withDraw
                    kb.nextLine();int chk=0;
                    System.out.println("Enter Name: ");
                    String str=kb.nextLine();
                    for(int i=0;i<account.size();i++)
                    {
                        if(str.equals(account.get(i).getName()))
                        {
                           System.out.println("Enter amount: ");
                           withDraw=kb.nextDouble();
                           account.get(i).withDraw(withDraw);
                           chk=1;
                           
                        }
                    }
                    if(chk==0)
                    {
                        System.out.println("No Found In Records.");
                    }
                    break;
                                          
                case 7://saving to file
                    //account..........
                    save++;
                    try
                    {
                        FileWriter fw=new FileWriter(ac);
                        Writer output= new BufferedWriter(fw);
                        for(int i=0;i<account.size();i++)
                        {
                            output.write(account.get(i).getName().toString()+"@"+account.get(i).getBalance()+"@");
                        }
                        output.close();
                    }
                    catch(Exception e)
                            {
                                System.out.println("I can not create this file7");
                            }
                    //project..................................................
                    try
                    {
                        FileWriter fw=new FileWriter(pr);
                        Writer output= new BufferedWriter(fw);
                        for(int i=0;i<project.size();i++)//total..name..nop...revenue
                        {
                            output.write(project.get(i).getTotal_balance()+"@"+project.get(i).getName().toString()+"@"+project.get(i).getNoPersons()+"@"+project.get(i).getRevenue()+"@");
                        }
                        output.close();
                    }
                    catch(Exception e)
                            {
                                System.out.println("I can not create this file7");
                            }
                    System.out.println("Saved to file Successfully.");
                    break;
                case 8://Reading from file
                     String strr="",strrr="",temp[],temp1[],str1,str2="";
                    //account...............
                    strr="";strr="";
                    try
                    {
                        BufferedReader input=new BufferedReader(new FileReader(ac));
                        if(!(input.ready()))
                        {
                            throw new Exception();
                        }
                        while((strr=input.readLine())!=null)
                        {
                            strrr+=strr;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Problem in opening the file.!");
                    }
                  //  System.out.println(strrr);
                    temp=strrr.split("@");int j=0;double data;
                    for(int i=1;i<temp.length;i=i+2)
                    {
                        j=i;j--;
                        Account a=new Account();
                        a.setName(temp[j]);
                        data=Double.parseDouble(temp[i]);
                        a.setBalance(data);
                        account.add(a);
                    }
                    //project...................
                    
                     try
                    {
                        BufferedReader input=new BufferedReader(new FileReader(pr));
                        if(!(input.ready()))
                        {
                            throw new Exception();
                        }
                        while((str1=input.readLine())!=null)
                        {
                            str2+=str1;
                        }
                    }
                     catch(Exception e)
                    {
                        System.out.println("Problem in opening the file.!");
                    }
                     //System.out.println(str2);
                     temp1=str2.split("@");
                     int a,b,c;
                     for(int i=3;i<temp1.length;i=i+4)//total..name..nop...revenue
                     {
                         a=i;a-=3;
                         b=i;b=b-2;
                         c=i;c--;
                         Project p=new Project();
                         p.setTotal_balance(Double.parseDouble(temp1[a]));
                         p.setName(temp1[b]);
                         p.setNo_developers(Integer.parseInt(temp1[c]));
                         p.setRevenue(Double.parseDouble(temp1[i]));
                         project.add(p);
                     }
                    System.out.println("Read Successfully from file.");
                    break;
                case 9:
                    if(save!=0)
                    {
                        System.exit(0);
                    }
                    try
                    {
                        FileWriter fw=new FileWriter(ac);
                        Writer output= new BufferedWriter(fw);
                        for(int i=0;i<account.size();i++)
                        {
                            output.write(account.get(i).getName().toString()+"@"+account.get(i).getBalance()+"@");
                        }
                        output.close();
                    }
                    catch(Exception e)
                            {
                                System.out.println("I can not create this file7");
                            }
                    //project..................................................
                    try
                    {
                        FileWriter fw=new FileWriter(pr);
                        Writer output= new BufferedWriter(fw);
                        for(int i=0;i<project.size();i++)//total..name..nop...revenue
                        {
                            output.write(project.get(i).getTotal_balance()+"@"+project.get(i).getName().toString()+"@"+project.get(i).getNoPersons()+"@"+project.get(i).getRevenue()+"@");
                        }
                        output.close();
                    }
                    catch(Exception e)
                            {
                                System.out.println("I can not create this file7");
                            }
                    System.exit(0);
            }
        }
    }  
}

