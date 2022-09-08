/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author duypham0705
 */
public class Student {

    private int id;
    private String name;
    private boolean gender;
    private int department;

    public Student(int id, String name, boolean gender, int department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getDepartment() {
        return department;
    }

    public String getDepartmentName() {
        if (department == 1) {
            return "Information Technology";
        }
        if (department == 2) {
            return "Business Administration";
        }
        if (department == 3) {
            return "Data Science";
        }
        if (department == 4) {
            return "Marketing and PR";
        }
        return null;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

}
