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
import org.example.services.serviceInterfaceImpl.LessonServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.rpc.ServiceException;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/lesson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LessonController {

    private final LessonServiceImpl lessonService;

    @Autowired
    public LessonController(LessonServiceImpl lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddLesson(@Valid @RequestBody AddLessonRequest jsonRequest) {
        try {
            AddLessonResponse lessonResponse = lessonService.addLesson(jsonRequest);
            return new ResponseEntity<>(lessonResponse, HttpStatus.OK);
        } catch (ParseException | ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> EditLesson(@Valid @RequestBody EditLessonRequest jsonRequest) {
        try {
            String lessonResponse = lessonService.editLesson(jsonRequest);
            return new ResponseEntity<>(lessonResponse, HttpStatus.OK);
        } catch (ParseException | ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> DeleteLessonById(@Valid @RequestParam("id") @Positive int id) {
        DeleteLessonByIdRequest deleteTeacherRequest = SpringConfig.getContext().getBean("deleteLessonByIdRequest", DeleteLessonByIdRequest.class);
        deleteTeacherRequest.setLessonId(id);
        try {
            String dataResponse = lessonService.deleteLessonById(deleteTeacherRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByGroup")
    public ResponseEntity<?> DeleteLessonByGroup(@Valid @RequestParam("id") @Positive int id) {
        DeleteLessonsByGroupRequest deleteLessonsByGroupRequest = SpringConfig.getContext().getBean("deleteLessonsByGroupRequest", DeleteLessonsByGroupRequest.class);
        deleteLessonsByGroupRequest.setGroupId(id);
        try {
            String dataResponse = lessonService.deleteLessonsByGroup(deleteLessonsByGroupRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByTeacher")
    public ResponseEntity<?> DeleteLessonByTeacher(@Valid @RequestParam("id") @Positive int id) {
        DeleteLessonsByTeacherRequest deleteLessonsByTeacherRequest = SpringConfig.getContext().getBean("deleteLessonsByTeacherRequest", DeleteLessonsByTeacherRequest.class);
        deleteLessonsByTeacherRequest.setTeacherId(id);
        try {
            String dataResponse = lessonService.deleteLessonsByTeacher(deleteLessonsByTeacherRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByTeacher")
    public ResponseEntity<?> GetLessonByTeacher(@Valid @RequestParam("id") @Positive int id, @Valid @RequestParam("startDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String startDate,
                                                @Valid @RequestParam("endDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String endDate) {
        GetLessonsByTeacherRequest getLessonsByTeacherRequest = SpringConfig.getContext().getBean("getLessonsByTeacherRequest", GetLessonsByTeacherRequest.class);
        getLessonsByTeacherRequest.setTeacherId(id);
        getLessonsByTeacherRequest.setEndDate(endDate);
        getLessonsByTeacherRequest.setStartDate(startDate);

        try {
            GetLessonsByTeacherResponse getLessonsByTeacherResponse = lessonService.getLessonsByTeacher(getLessonsByTeacherRequest);
            return new ResponseEntity<>(getLessonsByTeacherResponse, HttpStatus.OK);
        } catch (ServiceException | ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByGroup")
    public ResponseEntity<?> GetLessonByGroup(@Valid @RequestParam("id") @Positive int id, @Valid @RequestParam("startDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String startDate,
                                              @Valid @RequestParam("endDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String endDate) {
        GetLessonsByGroupRequest getLessonsByGroupRequest = SpringConfig.getContext().getBean("getLessonsByGroupRequest", GetLessonsByGroupRequest.class);
        getLessonsByGroupRequest.setStartDate(startDate);
        getLessonsByGroupRequest.setEndDate(endDate);
        getLessonsByGroupRequest.setGroupId(id);

        try {
            GetLessonsByGroupResponse getLessonsByGroupResponse = lessonService.getLessonsByGroup(getLessonsByGroupRequest);
            return new ResponseEntity<>(getLessonsByGroupResponse, HttpStatus.OK);
        } catch (ServiceException | ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> GetLessonById(@Valid @RequestParam("id") @Positive int id) {
        GetLessonByIdRequest getLessonByIdRequest = SpringConfig.getContext().getBean("getLessonByIdRequest", GetLessonByIdRequest.class);
        getLessonByIdRequest.setLessonId(id);
        try {
            GetLessonByIdResponse getLessonByIdResponse = lessonService.getLessonById(getLessonByIdRequest);
            return new ResponseEntity<>(getLessonByIdResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

