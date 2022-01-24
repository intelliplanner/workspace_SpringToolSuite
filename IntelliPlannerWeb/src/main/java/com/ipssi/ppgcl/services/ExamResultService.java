package com.ipssi.ppgcl.services;

import com.ipssi.ppgcl.entity.TPRecordEO;
import com.ipssi.ppgcl.requestDto.ExamResultRequestDto;
import com.ipssi.ppgcl.response.ServiceResponse;

public interface ExamResultService {

	public ServiceResponse updateExamDetails(TPRecordEO dto, String userId);

	ServiceResponse fetchExamDetails(ExamResultRequestDto requestDto);
}
