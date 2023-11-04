// Busque o elemento select
const movieSelect = document.getElementById('movieSelect');
// Exemplos de filmes
const movies = ['Batman', 'Coringa', 'Alerquina'];

// Preencha o campo select com as opções de filmes
movies.forEach((movie) => {
    const option = document.createElement('option'); // Crie um elemento de opção
    option.value = movie; // Defina o valor da opção (pode ser o nome do filme)
    option.textContent = movie; // Defina o texto visível da opção
    movieSelect.appendChild(option); // Adicione a opção ao campo select
});

// Faça uma solicitação à API OMDB para obter uma lista de filmes
fetch(`http://www.omdbapi.com/?apikey=ac5d41can&s=movie`) // Substitua [yourkey] pela sua chave
    .then((response) => response.json())
    .then((data) => {
        data.Search.forEach((movie) => {
            const option = document.createElement('option');
            option.value = movie.imdbID; // Use o ID do filme como valor
            option.textContent = movie.Title;
            movieSelect.appendChild(option);
        });
    })
    .catch((error) => {
        console.error('Erro ao buscar a lista de filmes:', error);
    });
    // Manipule o envio do formulário
const movieForm = document.getElementById('movieForm');
movieForm.addEventListener('submit', function (event) {
    event.preventDefault();

    // Obtenha o valor selecionado no campo select
    const selectedMovieId = movieSelect.value;

    // Faça uma solicitação à API OMDB para obter as informações do filme com base no IMDb ID
    fetch(`http://www.omdbapi.com/?apikey=ac5d41ca&t=${selectedMovieId}`) // Substitua [yourkey] pela sua chave
        .then((response) => response.json())
        .then((movieData) => {
            // Exiba as informações do filme na tabela #movieInfo
            const movieInfoTable = document.getElementById('movieInfo');
            movieInfoTable.innerHTML = `
                <tr>
                    <td>${movieData.Title}</td>
                    <td>${movieData.Year}</td>
                    <td>${movieData.Director}</td>
                    <td>
                        <button class="btn btn-primary" id="editButton">Editar</button>
                        <button class="btn btn-danger" id="deleteButton">Deletar</button>
                    </td>
                </tr>
            `;
        })
        .catch((error) => {
            console.error('Erro ao buscar informações do filme:', error);
        });
});


 // Adicione eventos aos botões
 const editButton = document.getElementById('editButton');
 const deleteButton = document.getElementById('deleteButton');

 editButton.addEventListener('click', function () {
     // Lógica para editar o filme
     // Aqui você pode fazer uma solicitação PUT para a API para editar o filme
     const editedMovieData = {
         title: movieData.Title,
         year: movieData.Year,
         director: movieData.Director,
     };

     fetch(`/sua/api/editar?idFilme=ID_DO_FILME`, {
         method: 'PUT',
         headers: {
             'Content-Type': 'application/json',
         },
         body: JSON.stringify(editedMovieData),
     })
     .then((response) => {
         if (response.status === 200) {
             console.log("Editado com sucesso!")
         } else {
            console.log("Erro")
         }
     });
 });

 deleteButton.addEventListener('click', function () {
     // Lógica para deletar o filme
     // Aqui você pode fazer uma solicitação DELETE para a API para deletar o filme
     fetch(`/sua/api/deletar?idFilme=ID_DO_FILME`, {
         method: 'DELETE',
     })
     .then((response) => {
         if (response.status === 200) {
            console.log("Deletado com sucesso!")
             movieInfoTable.innerHTML = '';
         } else {
            console.log("Erro")
         }
     });
 });

