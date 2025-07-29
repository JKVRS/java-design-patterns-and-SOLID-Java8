package com.java.interviewPrep.designPatterns.builderDP;


/*
  The Builder Design Pattern is used to construct complex objects step-by-step,
  allowing you to create different types and representations of an object using the same construction code.
  it avoids the telescope constructor
 */

class Bank{
    private int id;
    private String name;
    private String owner;
    private String branch;

//     If we put all the fields then while creatig the obje of the employee we need to put all the filed name
//     but if we want that only name and owner i should then we need to creat another constructor that has two filed
//     or we need to use telescope constructor
//     to avoid these telescope constructor we use builder DP
//
//      public Bank(int id, String name, String owner, String branch) {
//        this.id = id;
//        this.name = name;
//        this.owner = owner;
//        this.branch = branch;
//      }

        public Bank(Builder builder){
            this.id = builder.id;
            this.branch = builder.branch;
            this.name = builder.name;
            this.owner = builder.owner;
        }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    public static class Builder
    {
        private int id;
        private String name;
        private String owner;
        private String branch;

        // If we want to enforce required filed then we need to create this constructor
        public Builder(String name, String owner){
          this.name = name;
          this.owner = owner;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder setBranch(String branch) {
            this.branch = branch;
            return this;
        }

        public Bank build(){
            return new Bank(this);
        }
    }


}
public class BuilderMain {
    public static void main(String[] args) {
        Bank b = new Bank.Builder("Union","Vijay")
                .setId(1)
                .build();

        System.out.println(b.toString());

    }
}
