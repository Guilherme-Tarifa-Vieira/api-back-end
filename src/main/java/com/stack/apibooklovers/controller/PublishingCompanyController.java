package com.stack.apibooklovers.controller;

import com.stack.apibooklovers.domain.publishing.PublishingCompanyResponseDTO;
import com.stack.apibooklovers.service.publishingService.PublishingCompanyService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publishings")
public class PublishingCompanyController {


    private final PublishingCompanyService publishingCompanyService;

    public PublishingCompanyController(PublishingCompanyService publishingCompanyService) {

        this.publishingCompanyService = publishingCompanyService;
    }


    @GetMapping
    public ResponseEntity<Page<PublishingCompanyResponseDTO>> getAllPublishings(
            @ParameterObject
            @PageableDefault(size = 20, sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(publishingCompanyService.getAllPublishingCompany(pageable).getBody());
    }


}
