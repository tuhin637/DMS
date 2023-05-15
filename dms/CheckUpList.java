package com.mycompany.dms;

class CNode
{
     Checkup cu;
     CNode  next,pre;

    public CNode(Checkup cu) {
        next=pre=null;
        this.cu = cu;
    }


}


public class CheckUpList {
    
     CNode head , tail;

    public CheckUpList() {
        head=null;
        tail=null;
    }
    
    
    
    
    
    public void  Enqueue(Checkup cu)
    {
        CNode node = new CNode(cu);    
        
        if(head==null || tail ==null)
            {
            
                head=node;
                tail=node;
                
            }
        
        else if(head.cu.getPriority()<cu.getPriority())
        {
            head.next=node;
            node.pre=head;
            head=node;
            
            
        }
        
        else if(tail.cu.getPriority()>=cu.getPriority())
        {
            tail.pre=node;
            node.next=tail;
            tail=node;
            
            
        }
        
        else 
        {
           CNode temp=tail;
    
           while(temp!=null)
           {
               
           if(temp.cu.getPriority()>=cu.getPriority())
           {
           break;
           }
               
           temp=temp.next;
           }
           
           
                
                node.next=temp;
                node.pre=temp.pre;
                temp.pre.next=node;
                temp.pre=node;
           
           
           
           
        }
        
    
    }
    
    
    public int size()
    {
    CNode temp=head;
    int count=0;
    while(temp!=null)
    {
    count++;
    temp=temp.pre;
    }
    
    
    return count;
    
    }
    
    public Checkup dequeue()
    {
        if(head==null)
        {
        tail=null;
        return null;
        
        }
        
        CNode checkup=head;
        head=head.pre;
       
        return checkup.cu;
        
    
    }
    
    
     public Checkup getAtIndex(int index)
   {
       CNode temp=head;
       for(int i=0;i<index;i++)
       {
           temp=temp.pre;
       
       }
       
       return temp.cu;
   
   }
    
    
  public  void addRcomendation(int index,String rec)
    {
        CNode temp=head;
        int i=0;
        while(temp!=null)
        {
            if(index==i)
            {
         temp.cu.setRecomendation(rec);
                break;
            }
            
        i++;
            
            
        temp=temp.pre;
        }
        
        
    }
    
  public  Patient getPatient(int index)
    {
        CNode temp=head;
        int i=0;
        while(temp!=null)
        {
            if(index==i)
            {
                break;
            }
            
        i++;
            
            
        temp=temp.pre;
        }
        return temp.cu.getPatient();
        
    }
    
  
  
    
    public void Print()
    {
        CNode temp=head;
       while(temp!=null)
       {
            System.out.println(temp.cu.getPriority()+"     "+temp.cu.getRecomendation());
       
            temp=temp.pre;
       }
    
    }
     


}
