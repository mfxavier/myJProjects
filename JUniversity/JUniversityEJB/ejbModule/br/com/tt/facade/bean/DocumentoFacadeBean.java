package br.com.tt.facade.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.tt.dao.DocumentoDAO;
import br.com.tt.dto.DocumentoDTO;
import br.com.tt.facade.iface.IDocumentoFacade;
import br.com.tt.model.Documento;

@Stateless
public class DocumentoFacadeBean implements IDocumentoFacade {

	@EJB
	private DocumentoDAO dao;
	
	@Override
	public void save(DocumentoDTO documento) {
		
		Documento entidade = DtoAsDocumento(documento);
		
		entidade.setDataInclusao(new Date());
		
		dao.save(entidade);
		
		
	}

	@Override
	public void update(DocumentoDTO documento) {
		// TODO Auto-generated method stub
		Documento entidade = DtoAsDocumento(documento);
		entidade.setDataAlteracao(new Date());
		dao.update(entidade);
	
	}

	@Override
	public void delete(DocumentoDTO documento) {
		// TODO Auto-generated method stub
		
		Documento entidade = DtoAsDocumento(documento);
		
		dao.delete(entidade);
		
	}

	@Override
	public DocumentoDTO find(int entityID) {
		
		Documento entidade = dao.find(entityID);
		
		DocumentoDTO dto = DocumentoAsDto(entidade);
		
		return dto;
	}

	@Override
	public List<DocumentoDTO> findAll() {
		
		List<Documento> entidades = dao.findAll();
		
		List<DocumentoDTO> dtos = new ArrayList<DocumentoDTO>();
		
		for (Iterator<Documento> iterator = entidades.iterator(); iterator.hasNext();) {
			
			dtos.add(DocumentoAsDto(iterator.next()));
		}
		
		
		return dtos;
	}

	
	private DocumentoDTO DocumentoAsDto(Documento documento) {
		
		DocumentoDTO dto = new DocumentoDTO();
		
		dto.setAluno(documento.getAluno());
		dto.setAssunto(documento.getAssunto());
		dto.setDataAlteracao(documento.getDataAlteracao());
		dto.setDataExclusao(documento.getDataExclusao());
		dto.setDataInclusao(documento.getDataInclusao());
		dto.setDisciplina(documento.getDisciplina());
		dto.setGrupoestudos(documento.getGrupoEstudos());
		dto.setIsbn(documento.getIsbn());
		dto.setNome(documento.getNome());
		dto.setNota(documento.getNota());
		dto.setObservacoes(documento.getObservacoes());
		dto.setPath(documento.getPath());
		dto.setPkDocumento(documento.getId());
		dto.setProfessor(documento.getProfessor());
		dto.setTipoDocumentoFromString(documento.getTipoDocumento());
				
		return dto;
		
	}
	
	private Documento DtoAsDocumento(DocumentoDTO dto) {
		
		Documento documento = new Documento();
		
		documento.setAluno(dto.getAluno());
		documento.setAssunto(dto.getAssunto());
		documento.setDataAlteracao(dto.getDataAlteracao());
		documento.setDataExclusao(dto.getDataExclusao());
		documento.setDataInclusao(dto.getDataInclusao());
		documento.setDisciplina(dto.getDisciplina());
		documento.setGrupoEstudos(dto.getGrupoestudos());
		documento.setIsbn(dto.getIsbn());
		documento.setNome(dto.getNome());
		documento.setNota(dto.getNota());
		documento.setObservacoes(dto.getObservacoes());
		documento.setPath(dto.getPath());
		documento.setId(dto.getPkDocumento());
		documento.setProfessor(dto.getProfessor());
		documento.setTipoDocumento(dto.getTipoDocumentoAsString());
		
		
		return documento;
		
	}
	

}
