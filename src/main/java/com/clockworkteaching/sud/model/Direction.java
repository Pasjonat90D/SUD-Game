
package com.clockworkteaching.sud.model;

public enum Direction {
       N ("North"), S("South") , E ("East") , W ("West"), U("Up") , D("Down");
       
       private String exitDescription;
       
       private Direction(String exitDescription){
           this.exitDescription = exitDescription;
       }
       public String getDirectionDescription(){
           return exitDescription;
       }
       
}
