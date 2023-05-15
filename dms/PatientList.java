
package com.mycompany.dms;


class PNode
{
   Patient patient;
   PNode next,pre;

    public PNode() {
    }

    public PNode(Patient patient) {
        this.patient = patient;
        next=null;
        pre=null;
    }
   
   

}


public class PatientList {
    
    PNode head,tail;

    public PatientList() {
        head=null;
        tail=null;
    }
    
    public void Insert(Patient patient)
    {
        PNode node = new PNode(patient);
        
        if(head==null|| tail==null)
        {
           head=node;
           tail=node;
        
        }
        
        else
        {
        head.next= node;
        node.pre=head;
        head=node;
        
        
        }
    
    }
    
    
    public Patient  searchByID(String id)
    {
       PNode temp=head;
       while(temp!=null)
       {
         if(temp.patient.getId().equals(id))
         {
           return temp.patient;
         
         }
       
           temp=temp.pre;
       }
    
       return null;
       
    }
    
     public Patient getAtIndex(int index)
   {
       PNode temp=head;
       for(int i=0;i<size();i++)
       {
           if(i==index)
           {
           break;
           }
           
           temp=temp.pre;
       
       }
       
       return temp.patient;
   
   }
    
    
        public int size()
    {
    PNode temp=head;
    int count=0;
    while(temp!=null)
    {
    count++;
    temp=temp.pre;
    }
    
    
    return count;
    
    }
    public Patient  searchByContact(String contact)
    {
       PNode temp=head;
       while(temp!=null)
       {
         if(temp.patient.getContact().equals(contact))
         {
           return temp.patient;
         
         }
       
           temp=temp.pre;
       }
    
       return null;
       
    }
    
    
    
      public void PrintData()
    {
    PNode temp=head;
    int count=0;
    while(temp!=null)
    {
 count++;
        System.out.println(count+":  "+temp.patient.toString());
       temp=temp.pre;
    }
    
    
    }
    
}
