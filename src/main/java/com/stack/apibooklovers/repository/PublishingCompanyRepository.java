package com.stack.apibooklovers.repository;

import com.stack.apibooklovers.domain.publishing.PublishingCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingCompanyRepository extends JpaRepository<PublishingCompany, Long> {


}
