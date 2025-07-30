package org.getdataapi.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAfiliado {

    @JsonProperty("tipoDoc")
    String docType;
    @JsonProperty("idPersona")
    String personId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("fechaNacimiento")
    LocalDateTime birthDate;


    @JsonProperty("departamento")
    String departamento;
    @JsonProperty("municipio")
    String municipio;
    @JsonProperty("idDepartamento")
    Integer departamentoId;
    @JsonProperty("idMunicipio")
    Integer municipioId;
    @JsonProperty("nombre1")
    String firstName;
    @JsonProperty("nombre2")
    String middleName;
    @JsonProperty("apellido1")
    String lastName;
    @JsonProperty("apellido2")
    String secondLastName;
    @JsonProperty("emailPersona")
    String emailPersona;
    @JsonProperty("idOcupacion")
    Integer occupationId;
    @JsonProperty("ocupacion")
    String occupation;
    @JsonProperty("telefonoPersona")
    String phonePersona;
    @JsonProperty("sexo")
    String sex;
    @JsonProperty("estadoRl")
    String relationshipStatus;
    @JsonProperty("nomVinLaboral")
    String employmentType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("fechaInicioVinculacion")
    LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("fechaFinVinculacion")
    LocalDateTime endDate;

    @JsonProperty("afp")
    Integer afp;
    @JsonProperty("nombreAfp")
    String afpName;
    @JsonProperty("eps")
    String eps;
    @JsonProperty("nombreEps")
    String epsName;
    @JsonProperty("idArl")
    String arlId;
    @JsonProperty("nombreArl")
    String arlName;
    @JsonProperty("salario")
    BigDecimal salary;
    @JsonProperty("direccion")
    String address;
    @JsonProperty("tpDocEmpresa")
    String companyDocType;
    @JsonProperty("idEmpresa")
    String companyId;
    @JsonProperty("razonSocial")
    String companyName;
    @JsonProperty("direccionEmpresa")
    String companyAddress;
    @JsonProperty("idDepartamentoEmp")
    Integer companyDeptId;
    @JsonProperty("departamentoEmp")
    String companyDept;
    @JsonProperty("idMunicipioEmp")
    Integer companyMunId;
    @JsonProperty("municipioEmp")
    String companyMun;
    @JsonProperty("telefonoEmpresa")
    String companyPhone;
    @JsonProperty("emailEmpresa")
    String companyEmail;
    @JsonProperty("indZona")
    String zoneIndicator;
    @JsonProperty("idActEconomica")
    Integer economicActivityId;
    @JsonProperty("nomActEco")
    String economicActivityName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("fechaAfiliacionEfectiva")
    LocalDateTime effectiveAffiliationDate;
    @JsonProperty("estadoEmpresa")
    String companyStatus;
    @JsonProperty("idCentroTrabajo")
    Integer workCenterId;
    @JsonProperty("idSucursal")
    Integer branchId;
    @JsonProperty("idSectorEconomico")
    Integer economicSectorId;
    @JsonProperty("idTipoVinculado")
    Integer affiliateTypeId;
}
