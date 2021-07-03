--
-- Estrutura da tabela "estado"
--

DROP TABLE IF EXISTS "estado" CASCADE;

CREATE TABLE estado (
  id     bigserial NOT NULL,
  nome   varchar(60),
  uf  varchar(2),
  ibge   integer,
  ddd    json,
  /* Keys */
  CONSTRAINT estado_pkey
    PRIMARY KEY (id)
);

COMMENT ON TABLE estado
  IS 'Unidades Federativas';

--
-- Inserindo dados na tabela "estado"
--

INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (1, 'Acre', 'AC', 12, '[68]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (2, 'Alagoas', 'AL', 27, '[82]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (3, 'Amazonas', 'AM', 13, '[97,92]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (4, 'Amapá', 'AP', 16, '[96]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (5, 'Bahia', 'BA', 29, '[77,75,73,74,71]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (6, 'Ceará', 'CE', 23, '[88,85]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (7, 'Distrito Federal', 'DF', 53, '[61]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (8, 'Espírito Santo', 'ES', 32, '[28,27]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (9, 'Goiás', 'GO', 52, '[62,64,61]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (10, 'Maranhão', 'MA', 21, '[99,98]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (11, 'Minas Gerais', 'MG', 31, '[34,37,31,33,35,38,32]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (12, 'Mato Grosso do Sul', 'MS', 50, '[67]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (13, 'Mato Grosso', 'MT', 51, '[65,66]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (14, 'Pará', 'PA', 15, '[91,94,93]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (15, 'Paraíba', 'PB', 25, '[83]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (16, 'Pernambuco', 'PE', 26, '[81,87]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (17, 'Piauí', 'PI', 22, '[89,86]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (18, 'Paraná', 'PR', 41, '[43,41,42,44,45,46]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (19, 'Rio de Janeiro', 'RJ', 33, '[24,22,21]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (20, 'Rio Grande do Norte', 'RN', 24, '[84]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (21, 'Rondônia', 'RO', 11, '[69]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (22, 'Roraima', 'RR', 14, '[95]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (23, 'Rio Grande do Sul', 'RS', 43, '[53,54,55,51]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (24, 'Santa Catarina', 'SC', 42, '[47,48,49]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (25, 'Sergipe', 'SE', 28, '[79]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (26, 'São Paulo', 'SP', 35, '[11,12,13,14,15,16,17,18,19]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (27, 'Tocantins', 'TO', 17, '[63]');
INSERT INTO public.estado (id, nome, uf, ibge, ddd) VALUES (99, 'Exterior', 'EX', 99, NULL);

ALTER SEQUENCE estado_id_seq
  RESTART 99;