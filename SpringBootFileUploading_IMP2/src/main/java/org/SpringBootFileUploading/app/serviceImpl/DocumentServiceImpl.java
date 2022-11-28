package org.SpringBootFileUploading.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.SpringBootFileUploading.app.model.Document;
import org.SpringBootFileUploading.app.repository.DocumentRepository;
import org.SpringBootFileUploading.app.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DocumentServiceImpl implements DocumentService  {
   @Autowired
	DocumentRepository dr;
	
	@Override
	public void saveDocument(Document d) {
		
		dr.save(d);
	}

	@Override
	public List<Document> getAllDocument() {
	
		return dr.findAll(); 
	}

	@Override
	public void deleteDocuments(Integer docId) {
		 dr.deleteById(docId);
		
	}

	@Override
	public Document updateDocuments(Integer docId, Document d) {
		
		Optional<Document> op=dr.findById(docId);
		 
		if(op.isPresent()) {
			
			Document document=op.get();
			document.setCustId(d.getCustId());
			document.setPhoto(d.getPhoto());
			document.setSignature(d.getSignature());
			document.setPancard(d.getPancard());
			
			return dr.save(document); 
			
		}
		else {
			return null;
			
		}
		
		}
	
	
	
 
}
