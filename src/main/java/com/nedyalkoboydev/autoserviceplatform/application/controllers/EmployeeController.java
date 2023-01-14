package com.nedyalkoboydev.autoserviceplatform.application.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeController {
}
