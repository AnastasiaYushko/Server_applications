package org.example.dao_repositories;

import org.example.model.StudentGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface StudentGroupDAO {

    ArrayList<StudentGroup> getStudentGroups();

    StudentGroup getStudentGroupById(int groupId);

    int addStudentGroup(String name);

    String editStudentGroup(int id, String name);

    String deleteStudentGroup(int id);
}
