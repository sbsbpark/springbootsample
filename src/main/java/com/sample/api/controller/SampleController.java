package com.sample.api.controller;

import com.sample.api.model.dto.SampleDto;
import com.sample.api.model.vo.Result;
import com.sample.api.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping( value="/api/v1/sample" )
@RequiredArgsConstructor
@RestController
public class SampleController {

	private final SampleService sampleService;

	/**** CREATE ****/

	@PostMapping( value = "" )
	public Result putAgent( @RequestBody SampleDto sampleDto ) {
		return sampleService.insertMonoHandler( sampleDto );
	}

	/**** READ ****/

	@GetMapping( value = "" )
	public Result selectAll( @ModelAttribute SampleDto sampleDto ) {
		return sampleService.selectAllHandler( sampleDto );
	}

	@GetMapping( value = "/flux" )
	public Result selectFlux( @ModelAttribute SampleDto sampleDto ) {
		return sampleService.selectFluxHandler( sampleDto );
	}

	@GetMapping( value = "/count" )
	public Result count( @ModelAttribute SampleDto sampleDto ) {
		return sampleService.countHandler( sampleDto );
	}

	@GetMapping( value = "/mono/{idx}" )
	public Result selectMono( @PathVariable long idx ) {
		return sampleService.selectMonoHandler( idx );
	}

	/**** UPDATE ****/

	@PatchMapping( value = "/mono/{idx}" )
	public Result updateMono( @PathVariable long idx, @RequestBody SampleDto sampleDto ) {
		return sampleService.updateMonoHandler( idx, sampleDto );
	}

	/**** DELETE ****/

	@DeleteMapping(value = "/mono/{idx}")
	public Result deleteMono( @PathVariable long idx ) {
		return sampleService.deleteMonoHandler( idx );
	}

}
