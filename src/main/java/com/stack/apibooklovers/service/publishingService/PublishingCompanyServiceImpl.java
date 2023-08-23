package com.stack.apibooklovers.service.publishingService;

import com.stack.apibooklovers.domain.publishing.PublishingCompany;
import com.stack.apibooklovers.domain.publishing.PublishingCompanyResponseDTO;
import com.stack.apibooklovers.exception.NoContentList;
import com.stack.apibooklovers.mapper.Mapper;
import com.stack.apibooklovers.repository.PublishingCompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingCompanyServiceImpl implements PublishingCompanyService {


    private final PublishingCompanyRepository publishingCompanyRepository;


    public PublishingCompanyServiceImpl(PublishingCompanyRepository publishingCompanyRepository) {
        this.publishingCompanyRepository = publishingCompanyRepository;
    }

    @Override
    public ResponseEntity<Page<PublishingCompanyResponseDTO>> getAllPublishingCompany(Pageable pageable) {
        Page<PublishingCompany> publis = publishingCompanyRepository.findAll(pageable);
        if (publis.isEmpty())
            throw new NoContentList("Lista Vazia!");

        List<PublishingCompanyResponseDTO> publisDto = publis.getContent().stream().map(Mapper::PublishingMapperDTO).toList();
        Page<PublishingCompanyResponseDTO> response = new PageImpl<>(publisDto, pageable, publis.getTotalElements());

        return ResponseEntity.status(200).body(response);
    }


    @Override
    public ResponseEntity<PublishingCompanyResponseDTO> getPublishingCompanyById() {
        return null;
    }




}
