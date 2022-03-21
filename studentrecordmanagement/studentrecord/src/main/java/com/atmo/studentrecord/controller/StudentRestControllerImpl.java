package com.atmo.studentrecord.controller;

import com.atmo.studentrecord.model.Student;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/")
public class StudentRestControllerImpl extends StudentRecordController implements StudentRestController {

    /**
     *Post student details using API.
     *
     * @param student
     */
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public boolean insertStudentDetails(final Student student) {
        return super.insertStudentDetails(student);
    }

    /**
     *Delete student details using API.
     *
     * @param rollNumber
     */
    @Path("/{rollNumber}")
    @DELETE
    public boolean deleteStudentDetails(@PathParam("rollNumber") final String rollNumber) {
        return super.deleteStudentDetails(rollNumber);
    }

    /**
     *Update student details using API.
     *
     * @param student
     */
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public boolean updateStudentDetails(final Student student) {
        return super.updateStudentDetails(student);
    }

    /**
     *Get particular student details using API.
     *
     * @param rollNumber
     */
    @Path("/{rollNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Student selectStudentDetail(@PathParam("rollNumber") final String rollNumber) {
        return super.selectStudentDetail(rollNumber);
    }

    /**
     *Get all student details using API.
     */
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Student> getAllStudents(@QueryParam("page") int page, @DefaultValue("3") @QueryParam("limit") int limit) {
        List<Student> student = new ArrayList<Student>(super.getAllStudents());

        int first = 0;
        int last = 0;

        if (page > 0 && limit >= 0) {
            first  = ((page - 1) * limit);
            last = page * limit;
        }

        if (first < student.size() && last < student.size()) {
            return student.subList (first, last);
        } else if (first < student.size()) {
            return student.subList (first, student.size());
        }
        return null;
    }
}
