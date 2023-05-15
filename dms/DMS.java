package com.mycompany.dms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
 
public class DMS {

    
   static  PatientList plist = new PatientList();
   static  DoctorsList dlist=new DoctorsList();
    public static void main(String[] args) {
     
    readPFile();
        
    readDFile();
     Scanner s=new Scanner(System.in);
     
        String choice;
        
        while(true)
            
        {
        
        MainMenu();
        choice=s.nextLine();
        if(choice.equals("1"))
        {
            System.out.println("\n Doctor ID");
              String id = s.nextLine();
        
       
            System.out.println("\n Doctor Name");
              String name = s.nextLine();
        
            System.out.println("\n Doctor Contact ");
              String contact = s.nextLine();
        
            System.out.println("\n Doctor Specilaity");
              String spec = s.nextLine();
        
            System.out.println("\n Doctor Fee");
               int fee = s.nextInt();
               s.nextLine();
               
               Doctor d=  new Doctor(id,name,contact,spec,fee);
               dlist.Insert(d);
               writeDFile();
              
        }
        else if(choice.equals("2"))
        {
        
            System.out.println("\n Patient ID");
              String id = s.nextLine();
        
       
            System.out.println("\n Patient Name");
              String name = s.nextLine();
        
            System.out.println("\n Patient Contact ");
              String contact = s.nextLine();
        Patient patient = new Patient(id,name,contact);
        plist.Insert(patient);
        
        plist.PrintData();
        writePFile();
        }
        
        else if(choice.equals("3"))
        {
        
            dlist.PrintData();
        }
        
        else if(choice.equals("4"))
        {
            plist.PrintData();
        
        }
        
        else if(choice.equals("5"))
        {
        String pdata="";    
             try {
      File myObj = new File("prec.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        pdata+=data+"\n";
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
            
            
            
            
            System.out.println("\nWelcome  To CheckUp Menu \n");
        
            CheckUpList[] clist = new CheckUpList[dlist.size()];
            //System.out.println(clist.length);
            for(int i=0;i<clist.length;i++)
            {
                clist[i] = new CheckUpList();
                Doctor doctor= dlist.getAtIndex(i);
                 System.out.println("\n\nEnter Patient For Doctor ");
                 System.out.println("Name         :"+doctor.getName());
                 System.out.println("Speciality   :"+doctor.getSpeciality());
                 System.out.println("Fees         :"+doctor.getFee());
              
                 
                 System.out.println("All Patients :");
                 plist.PrintData();
                 
                 while(true)
                 {
                 System.out.println("Enter Patient Id Or type null to Stop");
                 String id=s.nextLine();
                 
                 if(id.equals("null"))
                 {
                 break;
                 }
                 
                 
                 System.out.println("Priority  3 for Emergency  2 for Intermediate  any other key for normal ");
                 String per=s.nextLine();
                 
                 int p=1;
                 
                 if(per.equals("3"))
                 {
                 p=3;
                 }
                 else if(per.equals("2"))
                 {
                 p=2;
                 }
                     
                 
                 
                
                 Patient patient=plist.searchByID(id); 
                 if(patient==null)
                 {
                      
                 
                     System.out.println("\nInvalid Patient ID ! \n");
                 
                 }
                 
                 else
                 {
                     Checkup cup = new Checkup(doctor,patient,p,"",""+java.util.Calendar.getInstance().getTime().toString());
                   
                     clist[i].Enqueue(cup);
                     
                 }
                 
                 }
                 
                 
                 
                 

            }
            
            for(int i=0;i<clist.length;i++)
                 {
                     System.out.println("\n\n Patient "+(i+1)+"  In Queue For Doctor "+dlist.getAtIndex(i).getName());
                       
                   
                     for(int j=0;j<clist[i].size();j++)
                     {
                    
                      printPerRec(dlist.getAtIndex(i).getId(),clist[i].getPatient(j).getId(),pdata);
                         
                         
                         
                      System.out.println("Enter Recomendation For Patient : "+clist[i].getPatient(j));
                     
                     String rec=s.nextLine();
                     
                     clist[i].addRcomendation(j, rec);
                     }
                 
                 }
            
            
        
   try {
        String data="";
      for(int i=0;i<clist.length;i++)
      {
          for(int j=0;j<clist[i].size();j++)
          {
              Checkup cup=clist[i].getAtIndex(j);
         
          if(cup==null)
          {
          break;
          }
          data+=cup.getDcotor().getId()+";"+cup.getDcotor().getName()+";"+cup.getPatient().getId()+";"+cup.getPatient().getName()+";"+cup.getRecomendation()+";"+cup.getDate()+"\n";
          }
         
      }
        FileWriter myWriter = new FileWriter("prec.txt");
      
      myWriter.append(pdata+"\n"+data);
      myWriter.close();
      System.out.println("Save data to file");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
           
            
            
            
        }
        
        
        else if(choice.equals("0"))
        {
        break;
        }
        
        else
            
        {
            System.out.println("\n\nInvalid Choice ! \n");
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }
        
        
        


    }
    
    
    public static void MainMenu()
    {
        System.out.println("\n\n ||     *****    DMS       *****      ||");
        System.out.println("           ||  Main Menu  ||");
        System.out.println("\nEnter 1 for Insert New Doctor  ");
        System.out.println("Enter 2 for Insert Patient  ");
        System.out.println("\nEnter 3 for Print all Doctor  ");
        System.out.println("Enter 4 for Print all Patient  ");
        
        
        
        System.out.println("Enter 5 for CheckUp Menu ");
        System.out.println("Enter 0 for Exit ");
    }
    

    private static void writeDFile() {
    try {
        String data="";
      for(int i=0;i<dlist.size();i++)
      {
          Doctor doc= dlist.getAtIndex(i);
         data+=doc.getId()+";"+doc.getName()+";"+doc.getContact()+";"+doc.getSpeciality()+";"+doc.getFee()+"\n";
      }
        FileWriter myWriter = new FileWriter("ddata.txt");
      
      myWriter.write(data);
      myWriter.close();
      System.out.println("Successfully record added.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    
    }
    
    
    
    private static void readDFile() {
       try {
      File myObj = new File("ddata.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if(data.length()>5)
        {
          String[] cus= data.split(";");
         dlist.Insert(new Doctor(cus[0],cus[1],cus[2],cus[3],Integer.parseInt(cus[4])));
        
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }

    
    private static void writePFile() {
    try {
        String data="";
      for(int i=0;i<plist.size();i++)
      {
          Patient patient= plist.getAtIndex(i);
         data+=patient.getId()+";"+patient.getName()+";"+patient.getContact()+"\n";
      }
        FileWriter myWriter = new FileWriter("pdata.txt");
      
      myWriter.write(data);
      myWriter.close();
      System.out.println("Successfully record added.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    
    }
    
    
    
    private static void readPFile() {
       try {
      File myObj = new File("pdata.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if(data.length()>5)
        {
          String[] cus= data.split(";");
         plist.Insert(new Patient(cus[0],cus[1],cus[2]));
        
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }

    private static void printPerRec(String did, String pid, String pdata) {
      String [] da=pdata.split("\n");
        System.out.println("\n Previous record \n");
      for(int i=0;i<da.length;i++)
      {
         if(da[i].length()>1)
         {
             if(did.equals(da[i].split(";")[0])  && pid.equals(da[i].split(";")[2]))
             
             {
                    System.out.println("Rcomendation "+da[i].split(";")[4]+"       Date "+da[i].split(";")[5]);
             
             }
         
             
         }
      
      
      }
        System.out.println("\n");
      
        
        
    }
}
