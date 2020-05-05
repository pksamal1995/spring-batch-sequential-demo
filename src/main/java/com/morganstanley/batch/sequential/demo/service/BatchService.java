package com.morganstanley.batch.sequential.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	public void readWriteFlow() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String, JobParameter> parameters = new HashMap<>();
		parameters.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(parameters);
		
		jobLauncher.run(job, jobParameters);
	}
}
