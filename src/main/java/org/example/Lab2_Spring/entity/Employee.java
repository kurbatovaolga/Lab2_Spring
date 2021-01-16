package org.example.Lab2_Spring.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(schema = "public", name = "employee")
public class Employee {
    private int personnelNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private int age;
    private Department department;

    public Employee() {
    }
    public Employee(int personnelNumber, String lastName,String firstName, String middleName,int age, Department department){
        this.personnelNumber=personnelNumber;
        this.lastName=lastName;
        this.firstName=firstName;
        this.middleName=middleName;
        this.age=age;
        this.department=department;
    }
    @Id
    @Column(name = "personnel_number", nullable = false, length = 50)
    public int getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(int personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middle_name", nullable = false, length = 50)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(personnelNumber, employee.personnelNumber) &&
                Objects.equals(lastName, employee.lastName);


    }

    @Override
    public int hashCode() {
        return Objects.hash(personnelNumber, lastName, firstName, middleName, age);
    }
}
