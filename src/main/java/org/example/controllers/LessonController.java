package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.example.ResponseEntity;
import org.example.SpringConfig;
import org.example.dto.dtoRequest.lesson.*;
import org.example.dto.dtoResponse.lesson.AddLessonResponse;
import org.example.dto.dtoResponse.lesson.GetLessonByIdResponse;
import org.example.dto.dtoResponse.lesson.GetLessonsByGroupResponse;
import org.example.dto.dtoResponse.lesson.GetLessonsByTeacherResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterfaceImpl.LessonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/lesson")
@Validated
public class LessonController {

    private final LessonServiceImpl lessonService;

    @Autowired
    public LessonController(LessonServiceImpl lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddLessonResponse> AddLesson(@Valid @RequestBody AddLessonRequest jsonRequest) throws EntityNotFoundInDataBase, ParseException, AddEntityMatchData {
        AddLessonResponse lessonResponse = lessonService.addLesson(jsonRequest);
        return new ResponseEntity<>(lessonResponse, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> EditLesson(@Valid @RequestBody EditLessonRequest jsonRequest) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase, ParseException {
        String lessonResponse = lessonService.editLesson(jsonRequest);
        return new ResponseEntity<>(lessonResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> DeleteLessonById(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteLessonByIdRequest deleteTeacherRequest = SpringConfig.getContext().getBean("deleteLessonByIdRequest", DeleteLessonByIdRequest.class);
        deleteTeacherRequest.setLessonId(id);

        String dataResponse = lessonService.deleteLessonById(deleteTeacherRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByGroup")
    public ResponseEntity<String> DeleteLessonByGroup(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteLessonsByGroupRequest deleteLessonsByGroupRequest = SpringConfig.getContext().getBean("deleteLessonsByGroupRequest", DeleteLessonsByGroupRequest.class);
        deleteLessonsByGroupRequest.setGroupId(id);

        String dataResponse = lessonService.deleteLessonsByGroup(deleteLessonsByGroupRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByTeacher")
    public ResponseEntity<String> DeleteLessonByTeacher(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteLessonsByTeacherRequest deleteLessonsByTeacherRequest = SpringConfig.getContext().getBean("deleteLessonsByTeacherRequest", DeleteLessonsByTeacherRequest.class);
        deleteLessonsByTeacherRequest.setTeacherId(id);

        String dataResponse = lessonService.deleteLessonsByTeacher(deleteLessonsByTeacherRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @GetMapping("/getByTeacher")
    public ResponseEntity<GetLessonsByTeacherResponse> GetLessonByTeacher(@Valid @RequestParam("id") @Positive int id, @Valid @RequestParam("startDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String startDate,
                                                                          @Valid @RequestParam("endDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String endDate) throws EntityNotFoundInDataBase, ParseException {
        GetLessonsByTeacherRequest getLessonsByTeacherRequest = SpringConfig.getContext().getBean("getLessonsByTeacherRequest", GetLessonsByTeacherRequest.class);
        getLessonsByTeacherRequest.setTeacherId(id);
        getLessonsByTeacherRequest.setEndDate(endDate);
        getLessonsByTeacherRequest.setStartDate(startDate);

        GetLessonsByTeacherResponse getLessonsByTeacherResponse = lessonService.getLessonsByTeacher(getLessonsByTeacherRequest);
        return new ResponseEntity<>(getLessonsByTeacherResponse, HttpStatus.OK);
    }

    @GetMapping("/getByGroup")
    public ResponseEntity<GetLessonsByGroupResponse> GetLessonByGroup(@Valid @RequestParam("id") @Positive int id, @Valid @RequestParam("startDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String startDate,
                                                                      @Valid @RequestParam("endDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String endDate) throws EntityNotFoundInDataBase, ParseException {
        GetLessonsByGroupRequest getLessonsByGroupRequest = SpringConfig.getContext().getBean("getLessonsByGroupRequest", GetLessonsByGroupRequest.class);
        getLessonsByGroupRequest.setStartDate(startDate);
        getLessonsByGroupRequest.setEndDate(endDate);
        getLessonsByGroupRequest.setGroupId(id);

        GetLessonsByGroupResponse getLessonsByGroupResponse = lessonService.getLessonsByGroup(getLessonsByGroupRequest);
        return new ResponseEntity<>(getLessonsByGroupResponse, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetLessonByIdResponse> GetLessonById(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        GetLessonByIdRequest getLessonByIdRequest = SpringConfig.getContext().getBean("getLessonByIdRequest", GetLessonByIdRequest.class);
        getLessonByIdRequest.setLessonId(id);

        GetLessonByIdResponse getLessonByIdResponse = lessonService.getLessonById(getLessonByIdRequest);
        return new ResponseEntity<>(getLessonByIdResponse, HttpStatus.OK);
    }
}

