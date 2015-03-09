package com.staccato.model;

import java.util.ArrayList;
import java.util.List;

public class AlumnoBD {
    
    private static List<Alumno> alumnos = new ArrayList<>();
    
    public static  void agregarAluno(Alumno alumno){
        alumnos.add(alumno);
    }
    
    public static List<Alumno> getAlumnos(){
        return alumnos;
    }
    
    public static List<Alumno> getLista(String nombre, String lic, String sem){
        List<Alumno> pre = new ArrayList<>();
        
        if (nombre != null && lic == null && sem == null) {
            for (Alumno alumno : alumnos) {
                if (alumno.getNombre().equals(nombre)) {
                    pre.add(alumno);
                }
            }
        }
        if (lic != null && sem == null && nombre == null) {
            for (Alumno alumno : alumnos) {
                if (alumno.getLicenciatura().equals(lic)) {
                    pre.add(alumno);
                }
            }
        }
        if (sem != null && lic == null && nombre == null) {
            for (Alumno alumno : alumnos) {
                if (alumno.getSemestre().equals(sem)) {
                    pre.add(alumno);
                }
            }
        }
        
        if (nombre != null && lic != null && sem == null) {
            for (Alumno alumno : alumnos) {
                if (alumno.getNombre().equals(nombre) && alumno.getLicenciatura().equals(lic)) {
                    pre.add(alumno);
                }
            }
        }
        
        if (nombre != null && lic == null && sem != null) {
            for (Alumno alumno : alumnos) {
                if (alumno.getNombre().equals(nombre) && alumno.getSemestre().equals(sem)) {
                    pre.add(alumno);
                }
            }
        }
        
        if (nombre == null && lic != null && sem != null) {
            for (Alumno alumno : alumnos) {
                if (alumno.getLicenciatura().equals(lic) && alumno.getSemestre().equals(sem)) {
                    pre.add(alumno);
                }
            }
        }
        
        if (nombre != null && lic != null && sem != null) {
            for (Alumno alumno : alumnos) {
                if (alumno.getLicenciatura().equals(lic) && 
                        alumno.getSemestre().equals(sem) &&
                        alumno.getNombre().equals(nombre)) {
                    pre.add(alumno);
                }
            }
        }
        
        return pre;
    }
    
}
