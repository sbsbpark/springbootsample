package com.sample.api.model.vo;

import com.sample.api.model.enums.ResultStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

	private ResultStatus status; // 일반적인 코드 분류 ( ex : SUCCESS, FAILED, .. )

	private Map<String, Object> data;

}
