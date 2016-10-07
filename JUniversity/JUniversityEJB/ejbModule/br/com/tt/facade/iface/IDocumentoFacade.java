package br.com.tt.facade.iface;

	import java.util.List;

	import javax.ejb.Local;

import br.com.tt.dto.DocumentoDTO;

	@Local
	public interface IDocumentoFacade {

		public void save(DocumentoDTO documento);

		public void update(DocumentoDTO documento);
		
		public void delete(DocumentoDTO documento);

		public DocumentoDTO find(int entityID);

		public List<DocumentoDTO> findAll();
		
		
	}
