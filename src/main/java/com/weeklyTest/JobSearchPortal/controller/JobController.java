package com.weeklyTest.JobSearchPortal.controller;

import com.weeklyTest.JobSearchPortal.model.Job;
import com.weeklyTest.JobSearchPortal.model.Type;
import com.weeklyTest.JobSearchPortal.service.JobService;
import jakarta.validation.constraints.Email;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    //Get
    @GetMapping("jobs")
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
    @GetMapping("job/{id}")
    public Optional<Job> getJobById(@PathVariable  Long id)
    {
        return jobService.getJobById(id);
    }

    //get all jobs of the same type
    @GetMapping("jobs/type/{type}")
    public List<Job> getAllSameTypeJobs(@PathVariable Type type)
    {
        return jobService.getAllSameTypeJobs(type);
    }
    //get all jobs above a certain salary

    @GetMapping("jobs/salary/range/{salary}")
    public List<Job>getAllJobsInASalaryRange(@PathVariable Double salary)
    {
        return jobService.getAllJobsInASalaryRange(salary);
    }
    //get all jobs within the company
    @GetMapping("jobs/company/")
    public List<Job>getAllJobsWithTheSameCompany(@RequestParam("companyName") String cName)
    {
        return jobService.getAllJobsWithTheSameCompany(cName);
    }



    //Post
    @PostMapping("job")
    public String postAJob(@RequestBody Job j)
    {
        return jobService.postAJob(j);
    }
    @PostMapping("jobs")
    public String postJobs(@RequestBody List<Job> j)
    {
        return jobService.postJobs(j);
    }
    //Put
    //Salary
    @PutMapping("job/id/{id}/Salary/{salary}")

    public String updateSalaryById(@PathVariable Long id,@PathVariable Double salary)
    {
        return jobService.updateSalaryById(id,salary);
    }


    //Location
    @PutMapping("job/id/{id}/location")
    public String updateLocationById(@PathVariable Long id,@RequestParam String location)
    {
        return jobService.updateLocationById(id,location);
    }
    //company mail
    @PutMapping("job/id/{id}/email")
    public String updateEmailById(@PathVariable Long id,@Email @RequestParam String email)
    {
        return jobService.updateEmailById(id,email);
    }
    //Update all the Job Type IT salaries by 10%
    @PutMapping("jobs/salaryHike/jobType/{type}")
    public String updateSalaryOfSimilarJobType(@PathVariable Type type)
    {
        return jobService.updateSalaryOfSimilarJobType(type);
    }

    //Delete
    //the job by id
    @DeleteMapping("job/delete/id/{id}")
    public String removeJobById(@PathVariable Long id)
    {
        return jobService.removeJobById(id);
    }

    //Delete all jobs from the same Company
    @DeleteMapping("jobs/company/{cName}")
    public String removeAllJobsOfTheSameCompany(@PathVariable String cName)
    {
        return jobService.removeAllJobsOfTheSameCompany(cName);
    }


}