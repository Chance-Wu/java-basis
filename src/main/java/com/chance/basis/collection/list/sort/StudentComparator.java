package com.chance.basis.collection.list.sort;

import java.util.Comparator;

/**
 * @Description: StudentComparator
 * @Author: chance
 * @Date: 1/4/21 9:09 AM
 * @Version 1.0
 */
public class StudentComparator implements Comparator<Student> {

    /**
     * 先按成绩 降序 排序，如果成绩一样的话按id 升序 排序
     */
    @Override
    public int compare(Student s1, Student s2) {
        //greater
        if (s1.getScore() > s2.getScore()) {
            return -1;
        } else if (s1.getScore() == s2.getScore()) {
            if (s1.getId() > s2.getId()) {
                return 1;
            } else if (s1.getId() == s2.getId()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }
}
