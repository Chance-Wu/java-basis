package com.chance.toolkit.parsing;

/**
 * @Description: School
 * @Author: chance
 * @Date: 4/9/21 3:08 PM
 * @Version 1.0
 */
public class School {

    private String name;
    private Grade grades[] = new Grade[0];
    private final Object servicesLock = new Object();

    public void addGrade(Grade g) {
        synchronized (servicesLock) {
            Grade results[] = new Grade[grades.length + 1];
            System.arraycopy(grades, 0, results, 0, grades.length);
            results[grades.length] = g;
            grades = results;
        }
    }

    public Grade[] getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
