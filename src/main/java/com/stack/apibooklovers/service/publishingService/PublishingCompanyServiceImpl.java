package com.stack.apibooklovers.service.publishingService;

import com.stack.apibooklovers.domain.publishing.PublishingCompany;
import com.stack.apibooklovers.domain.publishing.PublishingCompanyResponseDTO;
import com.stack.apibooklovers.infraestructure.exception.NoContentList;
import com.stack.apibooklovers.repository.PublishingCompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingCompanyServiceImpl implements PublishingCompanyService {


    private PublishingCompanyRepository publishingCompanyRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PublishingCompanyServiceImpl(PublishingCompanyRepository publishingCompanyRepository, ModelMapper modelMapper) {
        this.publishingCompanyRepository = publishingCompanyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<Page<PublishingCompanyResponseDTO>> getAllPublishingCompany(Pageable pageable) {
        Page<PublishingCompany> publis = publishingCompanyRepository.findAll(pageable);
        if (publis.isEmpty())
            throw new NoContentList("Lista Vazia!");

        List<PublishingCompanyResponseDTO> publisDto = publis.getContent().stream().map(publiss -> modelMapper.map(publiss, PublishingCompanyResponseDTO.class)).toList();
        Page<PublishingCompanyResponseDTO> response = new PageImpl<>(publisDto, pageable, publis.getTotalElements());

        return ResponseEntity.status(200).body(response);
    }


    @Override
    public ResponseEntity<PublishingCompanyResponseDTO> getPublishingCompanyById() {
        return null;
    }


}
