INSERT INTO public.sistema (nome) VALUES
    ('Vetro System'),
    ('Reiki'),
    ('Euro Glass'),
    ('Olga Colors'),
    ('JK Vidros'),
    ('Verelux'),
    ('Espaço Aberto'),
    ('Mansur'),
    ('American Box'),
    ('Hoppens');

INSERT INTO public.empresa (nome, cnpj, email, telefone, endereco, numero, complemento, bairro, cidade, estado, cep) VALUES
    ('Multi Sacadas', '49800328000181', 'contato@multisacadas.com.br', '11972206771', 'Rua Dr. Alberto Seabra', '1297', null, 'Vila Madalena', 'São Paulo', 'SP', '05452-001');

INSERT INTO public.garantia (quantidade, tipo_periodo) VALUES
    (90, 'dias'),
    (120, 'dias'),
    (150, 'dias'),
    (180, 'dias');

INSERT INTO public.tipo_orcamento (descricao) VALUES
    ('Manutenção Corretiva em Sacada de Vidro'),
    ('Manutenção Corretiva em Cobertura de Vidro');