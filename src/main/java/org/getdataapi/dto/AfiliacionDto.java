package org.getdataapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AfiliacionDto {

    private String tipoDoc;
    private String idPersona;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaNacimiento;

    private String departamento;
    private String municipio;
    private Integer idDepartamento;
    private Integer idMunicipio;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String emailPersona;
    private Integer idOcupacion;
    private String ocupacion;
    private String telefonoPersona;
    private String sexo;
    private String estadoRl;
    private String nomVinLaboral;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaInicioVinculacion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaFinVinculacion;

    private Integer afp;
    private String nombreAfp;
    private String eps;
    private String nombreEps;
    private String idArl;
    private String nombreArl;
    private BigDecimal salario;
    private String direccion;
    private String tpDocEmpresa;
    private String idEmpresa;
    private String razonSocial;
    private String direccionEmpresa;
    private Integer idDepartamentoEmp;
    private String departamentoEmp;
    private Integer idMunicipioEmp;
    private String municipioEmp;
    private String telefonoEmpresa;
    private String emailEmpresa;
    private String indZona;
    private Long idActEconomica;
    private String nomActEco;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaAfiliacionEfectiva;

    private String estadoEmpresa;
    private Integer idCentroTrabajo;
    private Integer idSucursal;
    private Integer idSectorEconomico;
    private Integer idTipoVinculado;

}
