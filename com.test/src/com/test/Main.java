package com.test;
import java.util.*;

/**
 * 
 * role类的简述
 * role为角色，包含生命值和攻击力两个属性
 *
 *
 */
 class role{

    	public int health;//生命值
    	public int attack;//攻击力
    	public role(int a, int h) {
    		attack= a;
    		health= h;
    	}
 }
 /**
  * 炉石传说的代码
  * @author 谭文彪
  *
  */
public class Main {
	

	
    static Vector<role> herroAndFollow1= new Vector<>();//储存先手和后手的英雄和随从，0是英雄，1以后的是随从
    static Vector<role> herroAndFollow2= new Vector<>();
    
    /**
     * 判断两个英雄的生命值是否还大于0
     * @return 1表示先手赢，-1表示后手赢，0表示没有赢家
     */
    public int herroStillExist() {//判断两个英雄的生命值是否还大于0
    	                         //返回1表示先手赢，-1表示后手赢，0表示没有赢家
    	if(herroAndFollow1.get(0).health<= 0)
    		return -1;
    	if(herroAndFollow2.get(0).health<= 0)
    		return 1;
    	return 0;
    }

    /**
     * 按照题目的要求格式输出
     */
    public void print() {//按照题目的要求格式输出
    	
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
     * 炉石传说的main函数
     * @param args 没有输入
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
