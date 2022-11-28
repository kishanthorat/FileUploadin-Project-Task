package org.SpringBootFileUploading.app.service;

import java.util.List;

import org.SpringBootFileUploading.app.model.Document;

public interface DocumentService {

public	void saveDocument(Document d);

public List<Document> getAllDocument();

public void deleteDocuments(Integer docId);

public Document updateDocuments(Integer docId, Document d);



}
