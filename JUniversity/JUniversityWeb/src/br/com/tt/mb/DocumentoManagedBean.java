package br.com.tt.mb;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.tt.dto.DocumentoDTO;
import br.com.tt.facade.iface.IDocumentoFacade;

@ManagedBean
@RequestScoped
public class DocumentoManagedBean {

		@EJB
		private IDocumentoFacade facade;
		
		private static final String CREATE_DOCUMENTO = "createDocument";
		private static final String DELETE_DOCUMENTO = "deleteDocument"; 
		private static final String UPDATE_DOCUMENTO = "updateDocument";
		private static final String LIST_ALL_DOCUMENTO = "listAllDocuments";
		private static final String STAY_IN_THE_SAME_PAGE = null;

		private DocumentoDTO documento;

		public DocumentoDTO getDocumento() {
			
			if(documento == null){
				documento = new DocumentoDTO();
			}
			
			return documento;
		}

		public void setDocumento(DocumentoDTO documento) {
			this.documento = documento;
		}

		public List<DocumentoDTO> getAllDocumentos() {
			
			if (facade.findAll().isEmpty()) {
				
				//sendInfoMessageToUser("Não Existem Documentos a Serem Listados");
				
				return null;
			}
			
			return facade.findAll();
		}

		public String updateDocumentoStart(){
			return UPDATE_DOCUMENTO;
		}
		
		public String updateDocumentoEnd(){
			try {
				facade.update(documento);
			} catch (Exception e) {
				sendErrorMessageToUser("Erro ao atualizar documento : " + e.getMessage());
				return STAY_IN_THE_SAME_PAGE;
			}
			
			//sendInfoMessageToUser("Alteração de Documento Efetuada com Sucesso");
			return LIST_ALL_DOCUMENTO;
		}
		
		public String deleteDocumentoStart(){
			return DELETE_DOCUMENTO;
		}
		
		public String deleteDocumentoEnd(){
			try {
				facade.delete(documento);
			} catch (Exception e) {
				sendErrorMessageToUser("Erro ao atualizar documento : " + e.getMessage());
				return STAY_IN_THE_SAME_PAGE;
			}			
			
			//sendInfoMessageToUser("Documento Removido com Sucesso");
			
			return LIST_ALL_DOCUMENTO;
		}
		
		public String createDocumentoStart(){
			return CREATE_DOCUMENTO;
		}
		
		public String createDocumentoEnd(){
			try {
				
				if (documento.getAluno().equalsIgnoreCase("A")) {
					
					throw new Exception("Nome do Aluno não pode ser A");
					
				}
				
				facade.save(documento);
			} catch (Exception e) {
				sendErrorMessageToUser("Erro ao incluir o documento : " + e.getMessage());
				
				return STAY_IN_THE_SAME_PAGE;
			}		
			
			//sendInfoMessageToUser("Documento Criado com Sucesso");
			
			return LIST_ALL_DOCUMENTO;
		}
		
		public String listAllDocumentos(){
			return LIST_ALL_DOCUMENTO;
		}
		
		private void sendInfoMessageToUser(String message){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
		}
		
		private void sendErrorMessageToUser(String message){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
		}
		
}
