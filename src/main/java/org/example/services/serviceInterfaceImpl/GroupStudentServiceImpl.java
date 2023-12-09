package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.EditStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;
import org.example.services.serviceInterface.GroupStudentsService;

public class GroupStudentServiceImpl implements GroupStudentsService {

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод getStudentGroupById";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetStudentGroupByIdResponse.class);
    }

    @Override
    public GetStudentGroupsResponse getStudentGroups() throws JsonProcessingException {

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод getStudentGroups";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetStudentGroupsResponse.class);
    }

    @Override
    public EditStudentGroupResponse editStudentGroup(EditStudentGroupRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод editStudentGroup";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, EditStudentGroupResponse.class);
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод addStudentGroup";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, AddStudentGroupResponse.class);
    }

    @Override
    public String deleteStudentGroup(DeleteStudentGroupRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        return "Ответ сервера на метод deleteStudentGroup";
    }


}
