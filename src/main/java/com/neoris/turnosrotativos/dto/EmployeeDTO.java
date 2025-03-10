package com.neoris.turnosrotativos.dto;

import com.neoris.turnosrotativos.annotations.employee.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author Federico Fernando Sorgi Rosenthal
 */
@Validated
public class EmployeeDTO {

    //Puse min 8 para que contemple a partir de 10 millones ( esto puede variar según el pais, lo mismo si se pusiera un @Max).
    @NotNull(message = "‘nroDocumento’ es obligatorio.")
    @Positive(message = "Ingrese un numero de documento valido.")
    @Min(value = 8, message = "Ingrese un numero de documento valido.")
    @DocumentNumberAlreadyExists
    private Integer nroDocumento;

    @NotEmpty(message = "‘nombre’ es obligatorio.")
    @ValidFullName(field = "nombre")
    private String nombre;

    @NotEmpty(message = "‘apellido’ es obligatorio.")
    @ValidFullName(field = "apellido")
    private String apellido;

    @NotEmpty(message = "‘email’ es obligatorio.")
    @EmailAlreadyExists
    @ValidEmail
    private String email;

    @NotNull(message = "‘fechaNacimiento’ es obligatorio.")
    @Adult
    @NotFutureDate(message = "La fecha de nacimiento no puede ser posterior al día de la fecha.")
    private LocalDate fechaNacimiento;

    @NotNull(message = "‘fechaIngreso’ es obligatorio.")
    @NotFutureDate(message = "La fecha de ingreso no puede ser posterior al día de la fecha.")
    private LocalDate fechaIngreso;

    public Integer getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(Integer nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
