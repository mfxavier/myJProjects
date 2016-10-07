package br.com.tt.dto;


import java.util.Date;


public class DocumentoDTO {

	private int pkDocumento;

	private String aluno;

	private String assunto;

	private Date dataAlteracao;

	private Date dataExclusao;

	private Date dataInclusao;

	private String disciplina;

	private String grupoestudos;

	private String isbn;

	private String nome;

	private float nota=0;

	private String observacoes;

	private String path;
	
	private String professor;

	private int tipoDocumento;


	public int getPkDocumento() {
		return pkDocumento;
	}

	public void setPkDocumento(int pkDocumento) {
		this.pkDocumento = pkDocumento;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getGrupoestudos() {
		return grupoestudos;
	}

	public void setGrupoestudos(String grupoestudos) {
		this.grupoestudos = grupoestudos;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getTipoDocumentoAsString() {
		
		String result="DESCONHECIDO";
		
		switch (tipoDocumento)  {
		
		case 1: result="LIVRO";break;
		case 2: result="ARTIGO";break;
		case 3: result="APOSTILA";break;
		case 4: result="PROVA DIGITALIZADA";break;
		case 5: result="FOTO DE AULAS";break;
		case 6: result="GRAVACAO AUDIO AULA";break;
		case 7: result="VIDEO AULA";break;
		case 8: result="MONOGRAFIA";break;
		case 9: result="DISSERTACAO";break;
	}
		
		return result;
	}

	public void setTipoDocumentoFromString(String tipoDocumento) {
		int value=0;
		
		if (tipoDocumento.equalsIgnoreCase("LIVRO")) {
			this.tipoDocumento = 1;
			return;
		}
		
		if (tipoDocumento.equalsIgnoreCase("ARTIGO")) {
			this.tipoDocumento = 2;
			return;
		}

		if (tipoDocumento.equalsIgnoreCase("APOSTILA")) {
			this.tipoDocumento = 3;
			return;
		}

		if (tipoDocumento.equalsIgnoreCase("PROVA DIGITALIZADA")) {
			this.tipoDocumento = 4;
			return;
		}

		if (tipoDocumento.equalsIgnoreCase("FOTO DE AULAS")) {
			this.tipoDocumento = 5;
			return;
		}

		if (tipoDocumento.equalsIgnoreCase("GRAVACAO AUDIO AULA")) {
			this.tipoDocumento = 6;
			return;
		}

		if (tipoDocumento.equalsIgnoreCase("VIDEO AULA")) {
			this.tipoDocumento = 7;
			return;
		}

		if (tipoDocumento.equalsIgnoreCase("MONOGRAFIA")) {
			this.tipoDocumento = 8;
			return;
		}

		if (tipoDocumento.equalsIgnoreCase("DISSERTACAO")) {
			this.tipoDocumento = 9;
			return;
		}

		
		
		
	}

	public DocumentoDTO() {
	}

		
}
