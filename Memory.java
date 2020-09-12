import java.time.*;
import java.io.*;
import java.util.Scanner;

public class Memory {
  
  private LocalTime time;
  private LocalDate date;
  private String location;
  private String description;
  
  public Memory(){
    
    date = LocalDate.now();
    time = LocalTime.now();
    
    location = this.getLocation(); 
    
    description = this.getDescription();
    
    if(this.appendMemory(this.formatMemory())){
      
      this.print("Memory saved successfully.");
      
    }else{
      
      this.print("Error: The memory could not be saved.");
      
    }
    
  }
  
  
  public static void main(String[] args){
   
    Memory m = new Memory();
    
  }
  
  private String formatMemory(){
       
    return date.toString() + ",'," + time.toString() + ",'," + location + ",'," + description + ",,'',,";
    
  }
  
  public String getLocation(){
    
    this.print("Where are you?");
    
    return this.getInput();
    
  }
  
  public String getDescription(){
    
    this.print("What Happened?");
    
    return this.getInput();
    
  }
  
  public String getInput(){
    
    return new Scanner(System.in).nextLine();
    
  }
  
  public void print(String s){
    
    System.out.println(s);
    
  }
  
  public boolean appendMemory(String addition){
    
    boolean success = true;
   // FileInputStream in = null;
    FileOutputStream out = null;

    try{
      try {
      //   in = new FileInputStream("memorybank.txt");
         out = new FileOutputStream("memorybank.txt", true);
         
      //   int c;
       //  while ((c = in.read()) != -1) {
    //       out.write(c);
     //    }
         
         out.write(addition.getBytes());
         
      }finally {
       //  if (in != null) {
      //      in.close();
       //  }
         if (out != null) {
            out.close();
         }
      }
    }catch(Exception e){
        
        success = false;
      }
    /*
      FileInputStream inAgain = null;
      FileOutputStream outAgain = null;

      try {
         inAgain = new FileInputStream("memorybanktemp.txt");
         outAgain = new FileOutputStream("memorybank.txt");
         
         int c;
         while ((c = inAgain.read()) != -1) {
            outAgain.write(c);
         }
      }finally {
         if (inAgain != null) {
            inAgain.close();
         }
         if (outAgain != null) {
            outAgain.close();
         }
      }*/
      
      return success;
  }
    
}