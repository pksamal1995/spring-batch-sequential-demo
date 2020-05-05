package com.morganstanley.batch.sequential.demo.controller;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morganstanley.batch.sequential.demo.service.BatchService;

@RestController
@RequestMapping("/start")
public class BatchController {

	@Autowired
	private BatchService batchService;
	
	@GetMapping
	public ResponseEntity<String> startJob(){
		String response = "";
		HttpStatus status = null;
		try {
			batchService.readWriteFlow();
			response = "JOB COMPLETED";
			status = HttpStatus.CREATED;
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			response = "FAILED TO READ AND WRITE";
			status = HttpStatus.EXPECTATION_FAILED;
			e.printStackTrace();
		}
		return new ResponseEntity<String>(response, status);
	}
}
