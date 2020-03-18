package com.online.edu.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.online.edu.eduservice.entity.dto.CourseInfoDto;
import com.online.edu.eduservice.entity.dto.TeacherAllInfoDto;
import com.online.edu.eduservice.entity.form.CourseInfoForm;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2019-04-17
 */
public interface EduCourseService extends IService<EduCourse> {

    String insertCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getIdCourse(String id);

    Boolean updateCourse(CourseInfoForm courseInfoForm);

    boolean removeCourseId(String id);

    CourseInfoDto getCourseInfoAll(String courseId);

    //前台系统课程分页列表
    Map<String, Object> listCoursePage(Page<EduCourse> pageCourse);

    //前台根据课程id查询课程详情
    TeacherAllInfoDto getTeacherAllInfo(String id);
}
