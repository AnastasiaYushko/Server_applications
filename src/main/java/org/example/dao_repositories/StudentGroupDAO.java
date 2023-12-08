package org.example.dao_repositories;

import org.example.model.StudentGroup;

import java.util.ArrayList;

public interface StudentGroupDAO {

    ArrayList<StudentGroup> getStudentGroups();

    StudentGroup getStudentGroupById(int groupId);

    void addStudentGroup(String name);

    void editStudentGroup(int id,String name);

    void deleteStudentGroup(int id);
}
