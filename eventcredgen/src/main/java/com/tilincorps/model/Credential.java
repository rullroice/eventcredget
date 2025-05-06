package com.tilincorps.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credential implements Cloneable {
    private String name;
    private String role;
    private String rut;
    private LocalDate creationDate;
    private LocalDate birthDate;

    @Override
    public Credential clone() {
        try {
            return new Credential(
                this.name,
                this.role,
                this.rut,
                this.creationDate,
                this.birthDate
            );
        } catch (Exception e) {
            throw new AssertionError("Error en clonación: " + e.getMessage());
        }
    }
}