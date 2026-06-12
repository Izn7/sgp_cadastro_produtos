// Chamando API
const API_BUSCAR_TODAS_PECAS = 'http://localhost:8012/produtos/acharTodos';
const API_SALVAR = 'http://localhost:8012/produtos/gravar';
const API_BUSCAR_ID = 'http://localhost:8012/produtos';
const API_DELETAR = 'http://localhost:8012/produtos/deletar';
const API_ATUALIZAR = 'http://localhost:8012/produtos/atualizar';
const API_BUSCAR_TODOS = "http"

// Variável de controle
let editandoId = null;

// Buscar todos os produtos
async function buscarProdutos() {

    const response = await fetch(API_BUSCAR_TODAS_PECAS, {
        method: 'GET'
    });

    const produtos = await response.json();

    const tbody = document.getElementById('tabelaProdutos');
    tbody.innerHTML = "";

    produtos.forEach(produto => {

        const tr = document.createElement("tr");

        tr.innerHTML = `
            <td>${produto.sku}</td>
            <td>${produto.descricao}</td>
            <td>${produto.marca}</td>
            <td>${produto.precoCusto}</td>
            <td>${produto.precoVenda}</td>
            <td>${produto.peso}</td>
            <td>${produto.estoqueMin}</td>
            <td>${produto.estoqueMax}</td>
            <td>${produto.ativo}</td>
            <td>
                <button class="btn btn-warning btn-sm"
                    onclick="editar(${produto.id})">
                    Editar
                </button>

                <button class="btn btn-danger btn-sm"
                    onclick="deletar(${produto.id})">
                    Deletar
                </button>
            </td>
        `;

        tbody.appendChild(tr);

    });

}

// Cadastrar ou atualizar
async function cadastrarProdutos() {

    const produto = {

        sku: document.getElementById('sku').value,
        descricao: document.getElementById('descricao').value,
        categoria: document.getElementById('categoria').value,
        marca: document.getElementById('marca').value,
        precoCusto: parseFloat(document.getElementById('precoCusto').value),
        precoVenda: parseFloat(document.getElementById('precoVenda').value),
        peso: parseFloat(document.getElementById('peso').value),
        estoqueMin: parseInt(document.getElementById('estoqueMin').value),
        estoqueMax: parseInt(document.getElementById('estoqueMax').value),
        ativo: document.getElementById('ativo').checked
    };

   

        if (editandoId) {

            response = await fetch(`${API_ATUALIZAR}/${editandoId}`, {

                method: 'PUT',

                headers: {
                    'Content-Type': 'application/json'
                },

                body: JSON.stringify(produto)

            });

        } else {

            response = await fetch(API_SALVAR, {

                method: 'POST',

                headers: {
                    'Content-Type': 'application/json'
                },

                body: JSON.stringify(produto)

            });

        }

     

    }




// Deletar
async function deletar(id) {

    if (!confirm("Deseja excluir?")) return;

    await fetch(`${API_DELETAR}/${id}`, {
        method: 'DELETE'
    });

    buscarProdutos();

}

// Editar
async function editar(id) {

    const response = await fetch(`${API_BUSCAR_ID}/${id}`);
    const produto = await response.json();

    editandoId = id;

    document.getElementById("sku").value = produto.sku;
    document.getElementById("descricao").value = produto.descricao;
    document.getElementById("categoria").value = produto.categoria;
    document.getElementById("marca").value = produto.marca;
    document.getElementById("precoCusto").value = produto.precoCusto;
    document.getElementById("precoVenda").value = produto.precoVenda;
    document.getElementById("peso").value = produto.peso;
    document.getElementById("estoqueMin").value = produto.estoqueMin;
    document.getElementById("estoqueMax").value = produto.estoqueMax;
    document.getElementById("ativo").checked = produto.ativo;

}

