package org.SpringBootFileUploading.app.repository;

import org.SpringBootFileUploading.app.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
