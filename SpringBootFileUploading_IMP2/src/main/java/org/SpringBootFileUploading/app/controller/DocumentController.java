package org.SpringBootFileUploading.app.controller;

import java.util.List;

import org.SpringBootFileUploading.app.model.Document;
import org.SpringBootFileUploading.app.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@Slf4j
@RestController
public class DocumentController {
    @Autowired
	DocumentService ds;
	
	@PostMapping(value = "/documents",consumes=  MediaType.MULTIPART_FORM_DATA_VALUE)
	public String saveDocument(@RequestParam("photo") MultipartFile file1,@RequestParam("signature") MultipartFile file2,@RequestParam("pancard") MultipartFile file3,@RequestPart  String custId)
	{
		try {
			
			log.info("json"+custId);
			
			ObjectMapper om=new ObjectMapper();
			Document d=new Document();
			d.setPhoto(file1.getBytes());
			d.setSignature(file2.getBytes());
			d.setPancard(file3.getBytes());
			Document doc=om.readValue(custId, Document.class);
			d.setCustId(doc.getCustId());
			log.info("java"+doc);
			   
			ds.saveDocument(d);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
//		log.info("File upload...."+file1.getContentType());
//		log.info("File upload...."+file1.getName());
//		log.info("File upload...."+file1.getOriginalFilename());
//		log.info("File upload...."+file1.getSize());
		return "Documents uploaded successfully...";
			 
	}
	
	@GetMapping(value = "/documents" )
	public List<Document> getAllDocument()
	{
	  List<Document>	list=ds.getAllDocument();
	  
	  return list; 
	}
	
	@DeleteMapping(value = "/documents/{docId}")
	public String deleteDocuments(@PathVariable Integer docId)
	{
	  	ds.deleteDocuments(docId);
	  
	  return "Documents delete Succesfully ..."; 
	}
	
	@PutMapping("/documents/{docId}")
	public String updateDocuments(@PathVariable Integer docId,@RequestParam("photo") MultipartFile file1,
			@RequestParam("signature") MultipartFile file2,
			@RequestParam("pancard") MultipartFile file3,
			@RequestPart  String custId)
	{

		try {
			
			log.info("json"+custId);
			
			ObjectMapper om=new ObjectMapper();
			Document d=new Document();
			d.setPhoto(file1.getBytes());
			d.setSignature(file2.getBytes());
			d.setPancard(file3.getBytes());
			Document doc=om.readValue(custId, Document.class);
			d.setCustId(doc.getCustId());
			log.info("java"+doc);
			   
			ds.updateDocuments(docId,d);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Documents update successfully";
	}
	
} 
