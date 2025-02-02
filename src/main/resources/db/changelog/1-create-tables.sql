CREATE TABLE public.cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL,
    rg VARCHAR(20),
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    CONSTRAINT cliente_cpf_cnpj UNIQUE (cpf_cnpj)
);

CREATE TABLE public.endereco (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT REFERENCES cliente (id),
    endereco VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(2),
    cep int8 NOT NULL
);

CREATE TABLE public.sistema (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE public.garantia (
    id BIGSERIAL PRIMARY KEY,
    quantidade int4 NOT NULL,
    tipo_periodo VARCHAR(20) NOT NULL
);

CREATE TABLE public.empresa (
    id BIGSERIAL PRIMARY KEY,
    nome varchar(255) NOT NULL,
    cnpj varchar(20) NOT NULL,
    email varchar(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(255),
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cep VARCHAR(10) NOT NULL
);

CREATE TABLE public.tipo_orcamento (
   id BIGSERIAL PRIMARY KEY,
   descricao varchar(255) NOT NULL
);

CREATE TABLE public.orcamento (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT REFERENCES cliente (id),
    endereco_id BIGINT REFERENCES endereco (id),
    sistema_id BIGINT REFERENCES sistema (id),
    tipo_orcamento_id BIGINT REFERENCES tipo_orcamento (id),
    titulo VARCHAR(255) NOT NULL,
    quantidade_vidros int4 NOT NULL,
    descrição VARCHAR(8000) NOT NULL,
    garantia_id BIGINT REFERENCES garantia (id),
    data_hora TIMESTAMP NOT NULL,
    a_vista BOOLEAN NOT NULL,
    valor_pix DECIMAL(10,2) NOT NULL,
    valor_parcelado DECIMAL(10,2) NOT NULL,
    quantidade_parcelas int4 NOT NULL,
    impresso BOOLEAN NOT NULL
);
