package com.weeklyTest.JobSearchPortal.repo;

import com.weeklyTest.JobSearchPortal.model.Job;
import com.weeklyTest.JobSearchPortal.model.Type;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {

    List<Job> findByJobType(Type type);

    List<Job> findBySalaryGreaterThanEqual(Double salary);

    List<Job> findByCompanyName(String cName);

    @Modifying
    @Transactional
    @Query(value ="Delete From Jobs where Company_Name= :cName", nativeQuery = true)
    void deleteJobsFromTheSameCompany(String cName);

    @Modifying
    @Transactional
    @Query(value = "update jobs Set salary= salary + (salary * 10/100) where Job_Type= :type", nativeQuery = true)
    void updateAllSalaryOfSimilarType(String type);
}
