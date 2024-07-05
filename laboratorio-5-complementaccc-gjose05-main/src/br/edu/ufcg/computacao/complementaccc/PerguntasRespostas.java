package br.edu.ufcg.computacao.complementaccc;

public class PerguntasRespostas {

	private String pergunta;
	private String resposta;
	private int importancia;
	private String[] tag;
	
	/**
	 * faz um item faq
	 * @param pergunta pergunta
	 */
	public PerguntasRespostas(String pergunta) {
		this.pergunta = pergunta;
		this.resposta = "";
		tag = new String[2];
	}
	
	/**
	 * faz um item faq
	 * @param pergunta pergunta 
	 * @param resposta resposta
	 */
	public PerguntasRespostas(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
		tag = new String[2];
	}
	
	/**
	 * altera a resposta
	 * @param resposta resposta
	 */
	public void alteraResposta(String resposta) {
		this.resposta = resposta;
	}
	
	/**
	 * adiciona importancia
	 */
	public void adicionaImportancia() {
		importancia++;
	}
	
	/**
	 * pega a importancia 
	 * @return importancia
	 */
	public int getImportancia() {
		return importancia;
	}
	
	/**
	 * adiciona as tags
	 * @param tag tag
	 */
	public void adicionaTaq(String[] tag) {
		this.tag = tag;
	}
	
	/**
	 * compara as tags
	 * @param tags tags
	 * @return se tiver retorna verdadeiro
	 */
	public boolean comparaTag(String[] tags) {
		for (int i = 0 ; i<tags.length ; i++) {
			if (((tag[0]!=null)&&(tag[0].equals(tags[i])))||((tag[1]!=null)&&(tag[1].equals(tags[i])))||((tag[2]!=null)&&(tag[2].equals(tags[i])))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * to string do item faq
	 */
	@Override
	public String toString() {
		String tags = "";
		for (int i = 0; i < tag.length;i++) {
			if (tag[i]!= null) {
				tags += tag[i] + " ";
			}
		}
		return pergunta + " " + resposta + " " + importancia + " " + tags;
	}
}
