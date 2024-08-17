package org.example;

import lombok.Getter;
import org.example.controllers.*;
import org.example.services.serviceInterfaceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class SpringConfig implements WebMvcConfigurer {
    @Getter
    private static ApplicationContext context;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    @Bean
    public LessonController lessonController(LessonServiceImpl lessonService){
        return new LessonController(lessonService);
    }

    @Bean
    public TeacherController teacherController(TeacherServiceImpl teacherService){
        return new TeacherController(teacherService);
    }

    @Bean
    public LessonVisitingController lessonVisitingController(LessonVisitingServiceImpl lessonVisitingService){
        return new LessonVisitingController(lessonVisitingService);
    }

    @Bean
    public SubjectController subjectController(SubjectServiceImpl subjectService){
        return new SubjectController(subjectService);
    }

    @Bean
    public StudentController studentController(StudentServiceImpl studentService){
        return new StudentController(studentService);
    }

    @Bean
    public StudentGroupController studentGroupController(GroupStudentServiceImpl groupStudentService){
        return new StudentGroupController(groupStudentService);
    }
}
