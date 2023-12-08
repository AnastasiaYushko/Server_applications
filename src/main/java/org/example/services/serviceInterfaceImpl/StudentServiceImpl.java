package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.student.add.AddStudentRequest;
import org.example.dto_request.student.delete.DeleteStudentRequest;
import org.example.dto_request.student.edit.EditStudentRequest;
import org.example.dto_request.student.get.byGroup.GetStudentsByGroupRequest;
import org.example.dto_request.student.get.byId.GetStudentByIdRequest;
import org.example.dto_response.student.AddStudentResponse;
import org.example.dto_response.student.EditStudentResponse;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.dto_response.student.GetStudentsByGroupResponse;
import org.example.services.serviceInterface.StudentService;

public class StudentServiceImpl implements StudentService {

    @Override
    public GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "ответ сервера";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetStudentByIdResponse.class);
    }

    @Override
    public GetStudentsByGroupResponse getStudentsByGroup(GetStudentsByGroupRequest request)throws JsonProcessingException {
        return null;
    }

    @Override
    public EditStudentResponse editStudent(EditStudentRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request) throws JsonProcessingException {

    }
}
