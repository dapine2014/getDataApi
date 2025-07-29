package org.getdataapi.dto.response;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAfiliado {

    private Long id;
    private String docType;
    private String personId;
    private LocalDateTime birthDate;
    private String departamento;
    private String municipio;
    private Integer departamentoId;
    private Integer municipioId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String emailPersona;
    private Integer occupationId;
    private String occupation;
    private String phonePersona;
    private String sex;
    private String relationshipStatus;
    private String employmentType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer afp;
    private String afpName;
    private String eps;
    private String epsName;
    private String arlId;
    private String arlName;
    private BigDecimal salary;
    private String address;
    private String companyDocType;
    private String companyId;
    private String companyName;
    private String companyAddress;
    private Integer companyDeptId;
    private String companyDept;
    private Integer companyMunId;
    private String companyMun;
    private String companyPhone;
    private String companyEmail;
    private String zoneIndicator;
    private Integer economicActivityId;
    private String economicActivityName;
    private LocalDateTime effectiveAffiliationDate;
    private String companyStatus;
    private Integer workCenterId;
    private Integer branchId;
    private Integer economicSectorId;
    private Integer linkedTypeId;
}
