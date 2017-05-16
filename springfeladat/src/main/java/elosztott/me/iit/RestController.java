package elosztott.me.iit;
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
 
 @Controller
 @RequestMapping(value = "/angular")
 public class RestController {
       @Autowired
       private CourseManager courseManager;
 
       @RequestMapping(value = "/getCourses", method = { RequestMethod.GET}, produces= MediaType.APPLICATION_JSON_VALUE)
       @ResponseBody
       public List<CourseModel> getCourses(){
               System.out.println(courseManager.getCourses());
               return  courseManager.getCourses();
       }
 
       @RequestMapping(value = "/addCourse", method = {RequestMethod.POST },consumes = MediaType.APPLICATION_JSON_VALUE)
       @ResponseBody
       public void addUser(@RequestBody CourseModel course){
               courseManager.addCourse(course);
               System.out.println(courseManager.getCourses());
               System.out.println(course);
               
       }
       
       
 } 