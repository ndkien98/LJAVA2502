package vn.com.claim.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.com.claim.dto.request.ClaimRequest;
import vn.com.claim.dto.request.DocumentRequest;
import vn.com.claim.dto.request.UserRequest;
import vn.com.claim.entity.ClaimDocumentEntity;
import vn.com.claim.entity.ClaimEntity;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.service.FileService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
public class FileServiceImpl implements FileService {


    @Value("${file.root.folder}")
    private String fileRootFolder;
    @Value("${file.document}")
    private String folderDocument;

    @Value("${file.image}")
    private String folderImage;

    public Set<ClaimDocumentEntity> getClaimDocumentEntities(ClaimRequest claimRequest, ClaimEntity claimEntity) {
        // 5 save file document
        List<DocumentRequest> documentRequests = claimRequest.getDocuments();
        Set<ClaimDocumentEntity> claimDocumentEntities = new HashSet<>();
        for (DocumentRequest document : documentRequests) {

            String strBase64 = document.getFileBase64Encoded();
            if (strBase64.contains(",")){
                strBase64 = strBase64.split(",")[1];
            }

            String extension = "." + document.getDocumentType();
            // tạo ra tên file
            String fileName = new StringBuilder().append(claimEntity.getCode()).append("_").append(document.getDocumentName()).append(extension).toString();

            // tạo folder lưu file
            String folderPath = fileRootFolder + folderDocument;
            String filePath = saveFileToFolder(folderPath, fileName, strBase64);

            ClaimDocumentEntity claimDocumentEntity = new ClaimDocumentEntity();
            claimDocumentEntity.setClaimEntity(claimEntity);
            claimDocumentEntity.setDocumentName(document.getDocumentName());
            claimDocumentEntity.setDocumentType(document.getDocumentType());
            claimDocumentEntity.setFilePath(filePath);
            claimDocumentEntity.setUpdateDate(document.getUpdateDate() != null ? document.getUpdateDate() : LocalDate.now());
            claimDocumentEntities.add(claimDocumentEntity);
        }
        return claimDocumentEntities;
    }

    public void setAvatarUser(UserRequest userRequest, UserEntity userEntity) {
        String[] arrayBase64 = userRequest.getAvatarStringBase64().split(",");

        String mimeType = arrayBase64[0];
        String fileExtension = getFileExtension(mimeType);
        userEntity.setMimeType(mimeType + ",");
        String dataBase64 = arrayBase64[1];

        String fileName = userRequest.getUsername() + "_" + userEntity.getCode() + fileExtension;
        String folderPath = fileRootFolder + folderImage + userEntity.getCode() + "/";
        String filePath = saveFileToFolder(folderPath, fileName, dataBase64);
        userEntity.setPathAvatar(filePath);
    }

    private static String getFileExtension(String mimeType) {
        String fileExtension = "";
        if (mimeType.contains("image/png")) {
            fileExtension = ".png";
        } else if (mimeType.contains("image/jpeg")) {
            fileExtension = ".jpg";
        } else if (mimeType.contains("image/gif")) {
            fileExtension = ".gif";
        } else {
            throw new IllegalArgumentException("Unsupported image format");
        }
        return fileExtension;
    }

    private static String saveFileToFolder(String folderPath, String fileName, String strBase64) {
        // kiểm tra folder đã tồn tại chưa, nếu chưa thì tạo mới
        log.info("Creating folder if not exists: {}", folderPath);
        File folder = new File(folderPath);
        if (!folder.exists()){
            folder.mkdirs();
        }

        // tạo ra file bằng cách ghi toàn bộ byte vào file
        String filePath = folderPath + fileName;
        log.info("Save file to path: {}", filePath);
        File file = new File(filePath);

        byte[] bytes = Base64.getDecoder().decode(strBase64);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("File saved successfully at: {}", filePath);
        return filePath;
    }
}
