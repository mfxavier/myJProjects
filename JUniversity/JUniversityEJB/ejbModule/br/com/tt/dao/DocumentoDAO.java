package br.com.tt.dao;

import javax.ejb.Stateless;

import br.com.tt.model.Documento;

@Stateless
public class DocumentoDAO extends GenericDAO<Documento> {

    public DocumentoDAO() {
    	super(Documento.class);
   }
    
    public void delete(Documento documento) {
        super.delete(documento.getId(), Documento.class);
    }
    
    
}