package com.test;
import java.util.*;

/**
 * 
 * role��ļ���
 * roleΪ��ɫ����������ֵ�͹�������������
 *
 *
 */
 class role{

    	public int health;//����ֵ
    	public int attack;//������
    	public role(int a, int h) {
    		attack= a;
    		health= h;
    	}
 }
 /**
  * ¯ʯ��˵�Ĵ���
  * @author ̷�ı�
  *
  */
public class Main {
	

	
    static Vector<role> herroAndFollow1= new Vector<>();//�������ֺͺ��ֵ�Ӣ�ۺ���ӣ�0��Ӣ�ۣ�1�Ժ�������
    static Vector<role> herroAndFollow2= new Vector<>();
    
    /**
     * �ж�����Ӣ�۵�����ֵ�Ƿ񻹴���0
     * @return 1��ʾ����Ӯ��-1��ʾ����Ӯ��0��ʾû��Ӯ��
     */
    public int herroStillExist() {//�ж�����Ӣ�۵�����ֵ�Ƿ񻹴���0
    	                         //����1��ʾ����Ӯ��-1��ʾ����Ӯ��0��ʾû��Ӯ��
    	if(herroAndFollow1.get(0).health<= 0)
    		return -1;
    	if(herroAndFollow2.get(0).health<= 0)
    		return 1;
    	return 0;
    }

    /**
     * ������Ŀ��Ҫ���ʽ���
     */
    public void print() {//������Ŀ��Ҫ���ʽ���
    	
    	System.out.println(herroStillExist());
    	System.out.println((int)herroAndFollow1.get(0).health);
    	System.out.print(herroAndFollow1.size()- 1);
    	
    	for(int i= 1; i< herroAndFollow1.size(); i++) {
    		System.out.print(" "+ herroAndFollow1.get(i).health);
    	}
    	System.out.println();
    	
    	System.out.println(herroAndFollow2.get(0).health);
    	System.out.print(herroAndFollow2.size()- 1);
    	
    	for(int i= 1; i< herroAndFollow2.size(); i++) {
    		System.out.print(" "+ herroAndFollow2.get(i).health);
    	}
    	System.out.println();
    }
    /**
     * ¯ʯ��˵��main����
     * @param args û������
     */
	public static void main(String[] args) {
	        
	       Scanner scanner= new Scanner(System.in);
	       Main mainclass= new Main();
 
	       herroAndFollow1.add(0, new role(0, 30));
           herroAndFollow2.add(new role(0, 30));
     
           
           int n= scanner.nextInt();
           int count= 1;
           while((n--)!= 0) {
        	   String operator= scanner.next();
        	
        	   if(operator.equals("summon")) { 
  
        		   int position = scanner.nextInt();
        		   int attack= scanner.nextInt();
        		   int health= scanner.nextInt();
        		   
                  
        			  if(count% 2!= 0) {
        				  if(position< herroAndFollow1.size()) {
        					  herroAndFollow1.get(position).health+= health;
        					  herroAndFollow1.get(position).attack+= attack; 
        				  }
        				  else
        				  herroAndFollow1.add(position, new role(attack, health));
        			  }
        		      else {
        		    	  if(position< herroAndFollow2.size()) {
        		    		herroAndFollow2.get(position).health+= health;
        		    		herroAndFollow2.get(position).attack+= attack;
        		    	  } 
        		    	  else
        		    	   herroAndFollow2.add(position, new role(attack, health));
        		      }
        			    
                   
        	   }
        	   else if(operator.equals("end")) {
        		   count++;
        	   }
        	   else if(operator.equals("attack")) {
        		   int attacker= scanner.nextInt();
        		   int deffender= scanner.nextInt();
        		   
        		   if(count%2!= 0) {
        		       
        			  
        			       herroAndFollow1.get(attacker).health-= herroAndFollow2.get(deffender).attack;
        			       herroAndFollow2.get(deffender).health-= herroAndFollow1.get(attacker).attack;
        				
        				   if(herroAndFollow1.get(attacker).health<= 0&&attacker!= 0) {
        					   herroAndFollow1.remove(attacker);
        				   }
        				
        				   if(herroAndFollow2.get(deffender).health<= 0&&deffender!= 0) {
        					   herroAndFollow2.remove(deffender);
        				   }
        				
        			
        			   
        		   }
        		   else {
        			   
        			  herroAndFollow1.get(deffender).health-= herroAndFollow2.get(attacker).attack;
        			  herroAndFollow2.get(attacker).health-= herroAndFollow1.get(deffender).attack;
    				   
    				   if(herroAndFollow2.get(attacker).health<= 0&&attacker!= 0) {
    					   herroAndFollow2.remove(attacker);
    				   }
    				   
    				   
    				   if(herroAndFollow1.get(deffender).health<= 0&&deffender!= 0) {
    					   herroAndFollow1.remove(deffender);
    				   }
    						   
    				   
        			   
        		   }
        	   }

           }
           
	    mainclass.print();
	    scanner.close();
	}
}
