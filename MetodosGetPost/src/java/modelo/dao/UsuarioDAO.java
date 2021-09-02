/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.dto.ContactoDTO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author Morenofamily
 */
public class UsuarioDAO {
    private static final List<UsuarioDTO> lista = new ArrayList<>();

    public UsuarioDAO() {
        
    }
    
    public void datosprueba(){
        UsuarioDTO usu1= new UsuarioDTO(1, "Alex", "Alex37@gmail.com", "654321", UsuarioDTO.ADMINISTRADOR);
        UsuarioDTO usu2= new UsuarioDTO(2, "Axel", "Axel73@gmail.com", "123456", UsuarioDTO.CLIENTE);
        UsuarioDTO usu3= new UsuarioDTO(3, "Roberto", "Roberto25@gmail.com", "678910", UsuarioDTO.VENDEDOR);
        lista.add(usu1);
        lista.add(usu2);
        lista.add(usu3);
    }
    
    public boolean crear(UsuarioDTO c){
        if(c != null){
             lista.add(c);
             return true;
        }else{
            return false;
        }                   
    }
    
    public List<UsuarioDTO> readAll(){
        List<UsuarioDTO> obj = null;
        obj = UsuarioDAO.lista;
        return obj;
    }
}
