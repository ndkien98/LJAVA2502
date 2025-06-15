package vn.com.claim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "claim_document")
@Data
public class ClaimDocumentEntity extends BaseEntity {

    private String documentName;
    private String documentType;
    private String filePath;
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private ClaimEntity claimEntity;

}
