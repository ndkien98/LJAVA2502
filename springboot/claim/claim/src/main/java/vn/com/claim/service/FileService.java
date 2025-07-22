package vn.com.claim.service;

import vn.com.claim.dto.request.ClaimRequest;
import vn.com.claim.dto.request.UserRequest;
import vn.com.claim.entity.ClaimDocumentEntity;
import vn.com.claim.entity.ClaimEntity;
import vn.com.claim.entity.UserEntity;

import java.util.Set;

public interface FileService {

    Set<ClaimDocumentEntity> getClaimDocumentEntities(ClaimRequest claimRequest, ClaimEntity claimEntity);

    void setAvatarUser(UserRequest userRequest, UserEntity userEntity);
}
