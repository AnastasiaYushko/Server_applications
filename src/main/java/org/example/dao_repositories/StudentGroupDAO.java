package org.example.dao_repositories;

import org.example.model.StudentGroup;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;
import java.util.ArrayList;

public interface StudentGroupDAO {

    ArrayList<StudentGroup> getStudentGroups();

    StudentGroup getStudentGroupById(int groupId) throws ServiceException, RepositoryException;

    int addStudentGroup(String name);

    String editStudentGroup(int id, String name) throws RepositoryException;

    String deleteStudentGroup(int id) throws RepositoryException;
}
