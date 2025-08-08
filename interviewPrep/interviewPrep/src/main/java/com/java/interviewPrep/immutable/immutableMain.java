package com.java.interviewPrep.immutable;


/*
   Rules to immutable class
   Make the class final so it cannot be subclassed.
   Make all fields private and final.
   Initialize all fields via constructor.
   Do not provide setters.
   Return deep copies of mutable objects in getters.
 */

final class Employee{
    private final int id;
    private final String name;
    private final Address address; // mutable filed

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = new Address(address);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return new Address(address); // Return copy
    }

}
class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    // Copy constructor for deep copy
    public Address(Address other) {
        this.city = other.city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
public class immutableMain {

    public static void main(String[] args) {
        Address address = new Address("Mumbai");
        Employee emp = new Employee(1, "Vijay", address);

        System.out.println(emp.getName());  // Vijay
        System.out.println(emp.getAddress().getCity());  // Mumbai

        // Try to modify original address
        address.setCity("Delhi");

        // Still prints Mumbai, not affected
        System.out.println(emp.getAddress().getCity());
    }

}
