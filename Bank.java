import java.time.*;
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bank {

  ArrayList<String[]> memory_list;
  
  public Bank(){
    
    memory_list = new ArrayList<String[]>();
    
    memory_list = this.format(this.readBank());
    
    this.list();
  }
  
  public static void main(String[] args){
    
    Bank b = new Bank();
    
  }
  
  public String readBank(){
    
    String filePath = "memorybank.txt";
    String all_input = new String();

 
        try
        {
            all_input = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

    
    
    return all_input;
    
  }
  
  public ArrayList<String[]> format(String s){
    
    ArrayList<String[]> memory_list_input = new ArrayList<String[]>();
    String[] strArr = s.split(",,'',,");
    
    
    for(int i = 0; i<strArr.length;i++){
      
      memory_list_input.add(strArr[i].split(",',"));
      
    }
    
    return memory_list_input;
    
  }
  
  public void list(){
    
    for(int i = 0; i<memory_list.size();i++){
      
      for(int j = 0; j<4; j++){
        
        switch(j){
          
          case 0:
            System.out.print("Date: ");
            break;
          case 1:
            System.out.print("Time: ");
            break;
          case 2:
            System.out.print("Location: ");
            break;
          case 3:
            System.out.print("Desc: ");
            break;
          
        }
        
        System.out.print(memory_list.get(i)[j]);
        System.out.println();
        
      }
      
      System.out.println();
      
    }
    
  }
  
  public void closeBank(){
    
    System.exit(0);
    
  }
  
}
