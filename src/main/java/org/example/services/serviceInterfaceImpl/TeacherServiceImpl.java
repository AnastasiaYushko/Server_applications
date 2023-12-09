package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_response.teacher.AddTeacherResponse;
import org.example.dto_response.teacher.EditTeacherResponse;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.dto_response.teacher.GetTeachersResponse;
import org.example.services.serviceInterface.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public AddTeacherResponse addTeacher(AddTeacherRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод addTeacher";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, AddTeacherResponse.class);
    }

    @Override
    public String deleteTeacher(DeleteTeacherRequest request) throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        return "Ответ сервера на метод deleteTeacher";
    }

    @Override
    public EditTeacherResponse editTeacher(EditTeacherRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод editTeacher";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, EditTeacherResponse.class);
    }

    @Override
    public GetTeacherByIdResponse getTeacherById(GetTeacherByIdRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод getTeacherById";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetTeacherByIdResponse.class);
    }

    @Override
    public GetTeachersResponse getTeachers() throws JsonProcessingException {

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод getTeachers";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetTeachersResponse.class);
    }
}
