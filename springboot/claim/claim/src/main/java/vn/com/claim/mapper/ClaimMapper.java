package vn.com.claim.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.com.claim.dto.ClaimDTO;
import vn.com.claim.entity.ClaimEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClaimMapper {

    /**
     * @param claimEntity
     * @return  ClaimDTO chính là object chứa các thông tin sẽ hiển thị trên UI

     mục tiếu mapstruct:
        - tự động gen ra code convert từ dạng entity sang dạng dto
        - mapstruct tự động dựa vào entity và tạo ra 1 class impl
        để triển khai method trong interface, tự convert theo hướng
        dẫn của @Mapping,
        mapstruct giúp thay thay thế việc sủ dụng for hoặc logic tại
        tầng service để convert từ dạng entity -> dto

     @Mapping:
        được sử dụng như 1 hướng dẫn giúp mapstruct biết cần lấy thuộc tính
     từ đâu để set giá trị vào cho dto
     source: chinh định nguồn sẽ lấy dữ liệu từ entity
     target: chỉ định thuộc tính sẽ được set dữ liệu vào từ entity
     */
    // @Mapping(source = "code",target = "code")
    @Mapping(source = "customerEntity.name",target = "customerName")
    @Mapping(source = "insuranceProductEntity.name",target = "nameProduct")
    @Mapping(source = "insuranceProductEntity.coverage",target = "coverageProduct")
    @Mapping(source = "claimStatusEntity.description",target = "statusName")
    @Mapping(source = "claimStatusEntity.code",target = "statusCode")
    ClaimDTO toDto(ClaimEntity claimEntity);

    List<ClaimDTO> toDtos(List<ClaimEntity> claimEntityList);

}
