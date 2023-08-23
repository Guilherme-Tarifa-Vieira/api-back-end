package com.stack.apibooklovers.service.publishingService;

import com.stack.apibooklovers.domain.publishing.PublishingCompanyResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PublishingCompanyService {

    public ResponseEntity<Page<PublishingCompanyResponseDTO>> getAllPublishingCompany(Pageable pageable);

    public ResponseEntity<PublishingCompanyResponseDTO> getPublishingCompanyById();

}
