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
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface StudentRestController {

    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    boolean insertStudentDetails(final Student student);

    @Path("/{rollNumber}")
    @DELETE
    boolean deleteStudentDetails(@PathParam("rollNumber") final String rollNumber);

    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    boolean updateStudentDetails(final Student student);

    @Path("/allStudent")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    List<Student> getAllStudents();

    @Path("/{rollNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    Student selectStudentDetail(@PathParam("rollNumber") final String rollNumber);

}
