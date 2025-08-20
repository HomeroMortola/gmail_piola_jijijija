package com.mycompany.app;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
public class Alumno {
   private String nombre;
   private LocalDate fechaNacimiento;

   private int edad;
   public void setNombre(String _nombre){
   this.nombre = _nombre;
   }

   public String getNombre(){
      return nombre;
   }
   
   public void setFechaNacimiento(LocalDate _fecha){
      this.fechaNacimiento = _fecha;
   }

   public LocalDate getFechaNacimiento(){
      return fechaNacimiento;
   }

   public int getEdad() {
      LocalDate hoy = LocalDate.now();
      return Period.between(fechaNacimiento, hoy).getYears();
      
   }
   
}