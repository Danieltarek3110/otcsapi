package com.example.otcsapi.Services;

import java.io.IOException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.otcsapi.DatabaseRepository.DatabaseRepository;
import com.example.otcsapi.Entity.DTreeCoreEntity;

@Service
public class DocumentService {

    @Value("${BASE_URL}")
    private String BASE_URL;

    @Autowired
    private AuthenticationService auth;
    @Autowired
    private DatabaseRepository repo;

    public String getNodeID(String fullpath){

        long parentid = 2000;
        String[] splitted = fullpath.split("/");
        for (String string : splitted) {
            
            long node = repo.getNodeID(string, parentid).get(0).getDataID();
            parentid = node;
        }

        return String.valueOf(parentid);
    }
    
    public String uploadDocument(MultipartFile file, String fullpath, String username, String password) {

        try {
            String token = auth.authenticate(username, password);

            HttpHeaders header = new HttpHeaders();
            header.add("otcsTicket", token);

            header.setContentType(MediaType.MULTIPART_FORM_DATA);

            String url = BASE_URL + "v1/nodes";

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();

            body.add("body", "{\"type\":144, \"parent_id\":" + getNodeID(fullpath) + ", \"name\":\""
                    + file.getOriginalFilename() + "_" + System.currentTimeMillis() + "\"}");

            body.add("file", convertMultipartFileToByteArrayResource(file));

            HttpEntity<MultiValueMap<String, Object>> requEntity = new HttpEntity<MultiValueMap<String, Object>>(body,
                    header);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requEntity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new RuntimeErrorException(null, "failed to fetch data" + response.getStatusCode());
            }
        }

        catch (Exception e) {
            return e.getMessage();
        }

    }

    public ByteArrayResource convertMultipartFileToByteArrayResource(MultipartFile multipartFile) {
        try {
            byte[] fileBytes = multipartFile.getBytes();
            return new ByteArrayResource(fileBytes) {
                @Override
                public String getFilename() {
                    return multipartFile.getOriginalFilename();
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DTreeCoreEntity> ListDtree() {
        return repo.getAll();
    }

}
