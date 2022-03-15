package br.com.cineclube.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cineclube.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	// findAll, findById, get, save, delete

/*
	void save(Filme filme);

	void update(Filme filme); 

	void excluir(Long id);

	Filme findByIdId(Long id);

	List<Filme> findAll();

*/

	/* Para usar a lógica acima, é necessário criar as classes: Service e ServiceImpl, 
	 * Herdar na Controller... 
	 * Não consegui  realizar a edição do objeto Filme sem ter que criar essas classes e, 
	 * consequentemente, alterar a lógica passada na aula. 
	 */

    
}