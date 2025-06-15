package vn.com.claim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "insurance_product")
@Data
public class InsuranceProductEntity extends BaseEntity {

    private String coverage;

    private String description;

    private String name;


}
