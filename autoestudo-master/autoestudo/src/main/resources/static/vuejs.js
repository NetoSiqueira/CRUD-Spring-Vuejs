var app = new Vue({
    el: '#app',
    data: {
        Contatos: [],
        Contato: {
            id: "",
            nome: "",
            email: "",
            numero: ""
        }
    },

    created: function(){
        this.contatosListados();
    },

    methods: {
        contatosListados: function () {
            this.$http.get('http://localhost:8080/listar/').then(response => {
                this.Contatos = response.body;
        });
        },



        contatosSalvos: function(Contato) {

            let param = null;

            if (Contato.id == "") {

                param = this.$http.post('http://localhost:8080/adicionar/', Contato);
            } else {
                param = this.$http.put('http://localhost:8080/atualizar/' +Contato.id, Contato);

            }

            param.then( () => {
                this.contatosListados();
            this.Contato = {
                id: "",
                nome: "",
                email: "",
                numero: ""
            }
        });
        },


        contatosDeletados: function (id) {
            fetch("http://localhost:8080/excluir/" + id, {
                method: "DELETED"
            }).then(() => {
                this.contatosListados();
        });

        },

        contatosCarregados: function (contatos) {
            this.Contato.id = contatos.id;
            this.Contato.email = contatos.email;
            this.Contato.nome = contatos.nome;
            this.Contato.numero = contatos.numero;
        }
    }




});